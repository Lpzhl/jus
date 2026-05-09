<template>
	<div class="edit_view">
        <div class="breadcrumb-wrapper" style="width: 100%;">
            <div class="bread_view">
                <el-breadcrumb separator=":" class="breadcrumb">
                    <el-breadcrumb-item class="first_breadcrumb" :to="{ path: '/' }">首页</el-breadcrumb-item>
                    <el-breadcrumb-item class="second_breadcrumb" v-for="(item,index) in breadList" :key="index">{{item.name}}</el-breadcrumb-item>
                </el-breadcrumb>
            </div>
        </div>
		<el-form ref="formRef" :model="form" class="add_form" label-width="120px" :rules="rules">
			<el-row>
				<el-col :span="12">
					<el-form-item label="年份" prop="nianfen">
						<el-input class="list_inp"
                                  v-model="form.nianfen"
                                  placeholder="年份"
                                  type="text"
							      :readonly="!isAdd||disabledForm.nianfen?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item label="月份" prop="yuefen">
						<el-input class="list_inp"
                                  v-model="form.yuefen"
                                  placeholder="月份"
                                  type="text"
							      :readonly="!isAdd||disabledForm.yuefen?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item label="销项发票" prop="xiaoxiangfapiao">
						<uploads
							:disabled="!isAdd||disabledForm.xiaoxiangfapiao?true:false"
							action="file/upload" 
							tip="请上传销项发票"
							style="width: 100%;text-align: left;"
							:fileUrls="form.xiaoxiangfapiao?form.xiaoxiangfapiao:''" 
							@change="xiaoxiangfapiaoUploadSuccess">
						</uploads>
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item label="进项发票" prop="jinxiangfapiao">
						<uploads
							:disabled="!isAdd||disabledForm.jinxiangfapiao?true:false"
							action="file/upload" 
							tip="请上传进项发票"
							style="width: 100%;text-align: left;"
							:fileUrls="form.jinxiangfapiao?form.jinxiangfapiao:''" 
							@change="jinxiangfapiaoUploadSuccess">
						</uploads>
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item label="营收" prop="yingshou">
						<el-input class="list_inp"
                                  v-model.number="form.yingshou"
                                  placeholder="营收"
                                  type="number"
							      :readonly="!isAdd||disabledForm.yingshou?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item label="成本费用" prop="chengbenfeiyong">
						<el-input class="list_inp"
                                  v-model.number="form.chengbenfeiyong"
                                  placeholder="成本费用"
                                  type="number"
							      :readonly="!isAdd||disabledForm.chengbenfeiyong?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item label="申报时间" prop="shenbaoshijian">
						<el-date-picker
							class="list_date"
							v-model="form.shenbaoshijian"
							format="YYYY-MM-DD HH:mm:ss"
							value-format="YYYY-MM-DD HH:mm:ss"
							type="datetime"
							style="width:100%;"
							:readonly="!isAdd||disabledForm.shenbaoshijian?true:false"
							placeholder="请选择申报时间" />
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item label="企业名称" prop="qiyemingcheng">
						<el-input class="list_inp"
                                  v-model="form.qiyemingcheng"
                                  placeholder="企业名称"
                                  type="text"
							      :readonly="!isAdd||disabledForm.qiyemingcheng?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item label="申报回执" prop="shenbaohuizhi">
						<uploads
							:disabled="!isAdd||disabledForm.shenbaohuizhi?true:false"
							type="file"
							action="file/upload" 
							tip="请上传申报回执" 
							:limit="1" 
							style="width: 100%;text-align: left;"
							:fileUrls="form.shenbaohuizhi?form.shenbaohuizhi:''" 
							@change="shenbaohuizhiUploadSuccess">
						</uploads>
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item label="备注" prop="beizhu">
						<el-input class="list_inp"
                                  v-model="form.beizhu"
                                  placeholder="备注"
                                  type="text"
							      :readonly="!isAdd||disabledForm.beizhu?true:false" />
					</el-form-item>
				</el-col>

			</el-row>
			<div class="formModel_btn_box">
				<el-button class="formModel_cancel" @click="backClick">取消</el-button>
				<el-button class="formModel_confirm"
                           @click="save"
                           type="success"
				>
					保存
				</el-button>
			</div>
		</el-form>
	</div>
</template>
<script setup>
	import {
		ref,
		getCurrentInstance,
		watch,
		onUnmounted,
		onMounted,
		nextTick,
		computed
	} from 'vue';
	import {
		useRoute,
		useRouter
	} from 'vue-router';
    import {
        useStore
    } from 'vuex';
    const store = useStore()
    const user = computed(()=>store.getters['user/session'])
    const moment = window.moment
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const route = useRoute()
	const router = useRouter()
	//基础信息
	const tableName = 'shenbaohuizhi'
	const formName = '申报回执'
	//基础信息
	const breadList = ref([{
		name: formName
	}])
	//获取唯一标识
	const getUUID =()=> {
      return new Date().getTime();
    }
	//form表单
	const form = ref({
		nianfen: '',
		yuefen: '',
		xiaoxiangfapiao: '',
		jinxiangfapiao: '',
		yingshou: 0,
		chengbenfeiyong: 0,
		shenbaoshijian: '',
		qiyemingcheng: '',
		shenbaohuizhi: '',
		beizhu: '',
	})
	const formRef = ref(null)
	const id = ref(0)
	const type = ref('')
	const disabledForm = ref({
		nianfen : false,
		yuefen : false,
		xiaoxiangfapiao : false,
		jinxiangfapiao : false,
		yingshou : false,
		chengbenfeiyong : false,
		shenbaoshijian : false,
		qiyemingcheng : false,
		shenbaohuizhi : false,
		beizhu : false,
	})
	const isAdd = ref(false)
	//表单验证
	const rules = ref({
		nianfen: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		yuefen: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		xiaoxiangfapiao: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		jinxiangfapiao: [
		],
		yingshou: [
			{ validator: context.$toolUtil.validator.number, trigger: 'blur' },
		],
		chengbenfeiyong: [
			{ validator: context.$toolUtil.validator.number, trigger: 'blur' },
		],
		shenbaoshijian: [
		],
		qiyemingcheng: [
		],
		shenbaohuizhi: [
		],
		beizhu: [
		],
	})
	//销项发票上传回调
	const xiaoxiangfapiaoUploadSuccess=(e)=>{
		form.value.xiaoxiangfapiao = e
	}
	//进项发票上传回调
	const jinxiangfapiaoUploadSuccess=(e)=>{
		form.value.jinxiangfapiao = e
	}
	//申报回执上传回调
	const shenbaohuizhiUploadSuccess=(e)=>{
		form.value.shenbaohuizhi = e
	}
	//获取info
	const getInfo = ()=>{
		context?.$http({
			url: `${tableName}/info/${id.value}`,
			method: 'get'
		}).then(res => {
			let reg=new RegExp('../../../file','g')
			form.value = res.data.data
		})
	}
	const crossRow = ref('')
	const crossTable = ref('')
	const crossTips = ref('')
	const crossColumnName = ref('')
	const crossColumnValue = ref('')
	//初始化
	const init = (formId=null,formType='add',formNames='',row=null,table=null,statusColumnName=null,tips=null,statusColumnValue=null) => {
        form.value.shenbaoshijian = context?.$toolUtil.getCurDateTime()
		if(formId){
			id.value = formId
			type.value = formType
		}
		if(formType == 'add'){
			isAdd.value = true
		}else if(formType == 'info'){
			isAdd.value = false
			getInfo()
		}else if(formType == 'edit'){
			isAdd.value = true
			getInfo()
		}
		else if(formType == 'cross'){
			isAdd.value = true
			// getInfo()
			for(let x in row){
				if(x=='nianfen'){
					form.value.nianfen = row[x];
					disabledForm.value.nianfen = true;
					continue;
				}
				if(x=='yuefen'){
					form.value.yuefen = row[x];
					disabledForm.value.yuefen = true;
					continue;
				}
				if(x=='xiaoxiangfapiao'){
					form.value.xiaoxiangfapiao = row[x];
					disabledForm.value.xiaoxiangfapiao = true;
					continue;
				}
				if(x=='jinxiangfapiao'){
					form.value.jinxiangfapiao = row[x];
					disabledForm.value.jinxiangfapiao = true;
					continue;
				}
				if(x=='yingshou'){
					form.value.yingshou = row[x];
					disabledForm.value.yingshou = true;
					continue;
				}
				if(x=='chengbenfeiyong'){
					form.value.chengbenfeiyong = row[x];
					disabledForm.value.chengbenfeiyong = true;
					continue;
				}
				if(x=='shenbaoshijian'){
					form.value.shenbaoshijian = row[x];
					disabledForm.value.shenbaoshijian = true;
					continue;
				}
				if(x=='qiyemingcheng'){
					form.value.qiyemingcheng = row[x];
					disabledForm.value.qiyemingcheng = true;
					continue;
				}
				if(x=='shenbaohuizhi'){
					form.value.shenbaohuizhi = row[x];
					disabledForm.value.shenbaohuizhi = true;
					continue;
				}
				if(x=='beizhu'){
					form.value.beizhu = row[x];
					disabledForm.value.beizhu = true;
					continue;
				}
			}
			if(row){
				crossRow.value = row
			}
			if(table){
				crossTable.value = table
			}
			if(tips){
				crossTips.value = tips
			}
			if(statusColumnName){
				crossColumnName.value = statusColumnName
			}
			if(statusColumnValue){
				crossColumnValue.value = statusColumnValue
			}
		}
		context?.$http({
			url: `${context?.$toolUtil.storageGet('frontSessionTable')}/session`,
			method: 'get'
		}).then(res => {
			var json = res.data.data
			if(json.hasOwnProperty('qiyemingcheng') && context?.$toolUtil.storageGet("frontSessionTable")!="users"){
				form.value.qiyemingcheng = json.qiyemingcheng
				disabledForm.value.qiyemingcheng = true;
			}
            if (localStorage.getItem('autoSave')) {
                localStorage.removeItem('autoSave')
                save()
            }
		})
	}
	//初始化
	//取消
	const backClick = () => {
		history.back()
	}
	//提交
	const save=()=>{
		if(form.value.xiaoxiangfapiao!=null) {
			form.value.xiaoxiangfapiao = form.value.xiaoxiangfapiao.replace(new RegExp(context?.$config.url,"g"),"");
		}
		if(form.value.jinxiangfapiao!=null) {
			form.value.jinxiangfapiao = form.value.jinxiangfapiao.replace(new RegExp(context?.$config.url,"g"),"");
		}
		if(form.value.shenbaohuizhi!=null) {
			form.value.shenbaohuizhi = form.value.shenbaohuizhi.replace(new RegExp(context?.$config.url,"g"),"");
		}
		var table = crossTable.value
		var objcross = JSON.parse(JSON.stringify(crossRow.value))
		let crossUserId = ''
		let crossRefId = ''
		let crossOptNum = ''
		formRef.value.validate(async (valid)=>{
			if(valid){
                if(type.value == 'cross'){
                    if(crossColumnName.value!=''){
                        if(!crossColumnName.value.startsWith('[')){
                            for(let o in objcross){
                                if(o == crossColumnName.value){
                                    objcross[o] = crossColumnValue.value
                                }
                            }
                            //修改跨表数据
                            await changeCrossData(objcross)
                        }else{
                            crossUserId = context?.$toolUtil.storageGet('userid')
                            crossRefId = objcross['id']
                            crossOptNum = crossColumnName.value.replace(/\[/,"").replace(/\]/,"")
                        }
                    }
                }
				if(crossUserId&&crossRefId){    //限制用户操作次数
					form.value.crossuserid = crossUserId
					form.value.crossrefid = crossRefId
					let params = {
						page: 1,
						limit: 1000, 
						crossuserid:form.value.crossuserid,
						crossrefid:form.value.crossrefid,
					}
					context?.$http({
						url: `${tableName}/page`,
						method: 'get', 
						params: params 
					}).then(async (res)=>{
						if(res.data.data.total>=crossOptNum){
							context?.$toolUtil.message(`${crossTips.value}`,'error')
							return false
						}else{
							context?.$http({
								url: `${tableName}/${!form.value.id ? "save" : "update"}`,
								method: 'post', 
								data: form.value 
							}).then(async (res)=>{
                                context?.$toolUtil.message(`操作成功`,'success')
                                history.back()
							})
						}
					})
				}else{
					context?.$http({
						url: `${tableName}/${!form.value.id ? "save" : "update"}`,
						method: 'post', 
						data: form.value 
					}).then(async (res)=>{
                        context?.$toolUtil.message(`操作成功`,'success')
                        history.back()
					})
				}
			}
		})
	}
	//修改跨表数据
	const changeCrossData=(row,key)=>{
        if(type.value == 'cross'){
            let data = row
            if(key){	//如果有指定key，则只更新key属性
                data = {
                    id:row.id,
                }
                data[key] = row[key]
            }
            context?.$http({
                url: `${crossTable.value}/update`,
                method: 'post',
                data: data
            }).then(res=>{})
        }
	}
	onMounted(()=>{
		type.value = route.query.type?route.query.type:'add'
		let row = null
		let table = null
		let statusColumnName = null
		let tips = null
		let statusColumnValue = null
		if(type.value == 'cross'){
			row = context?.$toolUtil.storageGet('crossObj')?JSON.parse(context?.$toolUtil.storageGet('crossObj')):{}
			table = context?.$toolUtil.storageGet('crossTable')
			statusColumnName = context?.$toolUtil.storageGet('crossStatusColumnName')
			tips = context?.$toolUtil.storageGet('crossTips')
			statusColumnValue = context?.$toolUtil.storageGet('crossStatusColumnValue')
		}
		init(route.query.id?route.query.id:null, type.value,'', row, table, statusColumnName, tips, statusColumnValue)
	})
    onUnmounted(()=>{
        Object.keys(localStorage).map(item=>{
            if(item.startsWith('cross')){
                localStorage.removeItem(item)
            }
        })
    })
</script>
<style lang="scss" scoped>
	// 表单
	.add_form{
		// form item
		:deep(.el-form-item) {
			// 内容盒子
			.el-form-item__content {
				//文件上传样式
				.upload-demo {
					width: 100%;
				}
			}
		}
	}
</style>
<style lang="scss">
.edit_view {
    width: 100%;
    padding: 0 7%;
    margin: 0 auto;
    position: relative;
    font-size:16px;
    color:#666;
}
.edit_view .add_form{
    width: 100%;
    margin: 30px auto;
    background: #f8f8f8;
    padding: 50px 100px;
    border:0px solid #eee;
    border-radius: 12px;
}
.edit_view .add_form .el-form-item{
    margin: 0px 0px 20px;
    display: flex;
}
.edit_view .add_form .el-form-item .el-form-item__label{
    width: 150px;
    background: none;
    text-align: right;
    display: block;
    font-size: 16px;
    color: rgb(51, 51, 51);
    font-weight: 500;
}
.edit_view .add_form .el-form-item .el-form-item__content{
    display: flex;
    justify-content: flex-start;
    align-items: center;
    flex-wrap: wrap;
    width: calc(100% - 120px);
}
.edit_view .list_inp .el-input__wrapper{
    height: 36px;
}


.edit_view .list_date{
    line-height: 36px;
}






.edit_view .add_form .el-form-item .el-form-item__content .el-upload--picture-card{
    background-color: rgb(255, 255, 255);
    width: 100px;
    height: 90px;
    line-height: 100px;
    text-align: center;
    
    border-radius: 0px;
    cursor: pointer;
}

.edit_view .add_form .el-form-item .el-form-item__content .el-upload--picture-card .el-icon{
    font-size: 32px;
    color: #999;
}

.edit_view .add_form .el-form-item .el-form-item__content .img-uploader .el-upload__tip{
    font-size: 15px;
    color: #666;
    margin: 0;
}

.edit_view .add_form .el-form-item .el-form-item__content .el-upload--text .el-upload-dragger{
    background-color: rgb(255, 255, 255);
    
    border-radius: 0px;
    box-sizing: border-box;
    width: 360px;
    height: 180px;
    text-align: center;
    cursor: pointer;
    overflow: hidden;
}

.edit_view .add_form .el-form-item .el-form-item__content .el-upload--text .el-upload-dragger .el-icon--upload{
    font-size: 67px;
    color: var(--theme);
    line-height: 50px;
}

.edit_view .add_form .el-form-item .el-form-item__content .upload-demo .el-upload__tip{
    font-size: 15px;
    color: #666;
    margin: 0px 0 0;
    line-height:1;
}

.edit_view .add_form .el-form-item .el-form-item__content .el-upload--text .el-upload-dragger em{
    color: var(--theme);
    font-size: 15px;
}


</style>