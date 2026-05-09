<template>
	<div>
		<el-dialog modal-class="edit_form_modal" class="edit_form" v-model="formVisible" :title="formTitle" width="90%" destroy-on-close :fullscreen='false'>
			<el-form class="formModel_form" ref="formRef" :model="form" :rules="rules">
				<el-row >
					<el-col :span="8">
						<el-form-item label="年份" prop="nianfen">
							<el-input class="list_inp" v-model="form.nianfen" placeholder="年份"
                                type="text"
								:readonly="!isAdd||disabledForm.nianfen?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="8">
						<el-form-item label="月份" prop="yuefen">
							<el-input class="list_inp" v-model="form.yuefen" placeholder="月份"
                                type="text"
								:readonly="!isAdd||disabledForm.yuefen?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="8">
						<el-form-item prop="xiaoxiangfapiao"
									  label="销项发票"
						>
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
					<el-col :span="8">
						<el-form-item prop="jinxiangfapiao"
									  label="进项发票"
						>
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
					<el-col :span="8">
						<el-form-item label="营收" prop="yingshou">
							<el-input class="list_inp" v-model.number="form.yingshou" placeholder="营收"
                                type="number"
                                @mousewheel.native.prevent
								:readonly="!isAdd||disabledForm.yingshou?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="8">
						<el-form-item label="成本费用" prop="chengbenfeiyong">
							<el-input class="list_inp" v-model.number="form.chengbenfeiyong" placeholder="成本费用"
                                type="number"
                                @mousewheel.native.prevent
								:readonly="!isAdd||disabledForm.chengbenfeiyong?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="8">
						<el-form-item label="操作时间" prop="caozuoshijian">
							<el-date-picker
								class="list_date"
								v-model="form.caozuoshijian"
								format="YYYY-MM-DD HH:mm:ss"
								value-format="YYYY-MM-DD HH:mm:ss"
								type="datetime"
								:readonly="!isAdd||disabledForm.caozuoshijian?true:false"
								placeholder="请选择操作时间" />
						</el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="企业名称" prop="qiyemingcheng">
							<el-input class="list_inp" v-model="form.qiyemingcheng" placeholder="企业名称"
                                type="text"
								:readonly="!isAdd||disabledForm.qiyemingcheng?true:false" />
						</el-form-item>
					</el-col>


				</el-row>
			</el-form>
			<template #footer v-if="isAdd||type=='logistics'||type=='reply'">
				<span class="formModel_btn_box">
					<el-button class="cancel_btn" @click="closeClick">取消</el-button>
					<el-button class="confirm_btn" type="primary" @click="save"
						>
						提交
					</el-button>
				</span>
			</template>
		</el-dialog>
	</div>
</template>
<script setup>
	import {
		reactive,
		ref,
		getCurrentInstance,
		nextTick,
		computed,
		defineEmits
	} from 'vue'
    import {
        useStore
    } from 'vuex';
	const moment = window.moment
    const store = useStore()
    const user = computed(()=>store.getters['user/session'])
	const context = getCurrentInstance()?.appContext.config.globalProperties;	
	const emit = defineEmits(['formModelChange'])
    const isAdmin = localStorage.getItem('isAdmin')||context.$toolUtil.storageGet("sessionTable")=='users'
	//基础信息
	const tableName = 'shenbaocaozuo'
	const formName = '申报操作'
	//基础信息
	//form表单
	const form = ref({})
	const disabledForm = ref({
        nianfen : false,
        yuefen : false,
        xiaoxiangfapiao : false,
        jinxiangfapiao : false,
        yingshou : false,
        chengbenfeiyong : false,
        caozuoshijian : false,
        qiyemingcheng : false,
	})
	const formVisible = ref(false)
	const isAdd = ref(false)
	const formTitle = ref('')
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
		caozuoshijian: [
		],
		qiyemingcheng: [
		],
	})
	//表单验证
	
	const formRef = ref(null)
	const id = ref(0)
	const type = ref('')
	//销项发票上传回调
	const xiaoxiangfapiaoUploadSuccess=(e)=>{
		form.value.xiaoxiangfapiao = e
	}
	//进项发票上传回调
	const jinxiangfapiaoUploadSuccess=(e)=>{
		form.value.jinxiangfapiao = e
	}
	//获取唯一标识
	const getUUID =()=> {
      return new Date().getTime();
    }
	//重置
	const resetForm = () => {
		form.value = {
			nianfen: '',
			yuefen: '',
			xiaoxiangfapiao: '',
			jinxiangfapiao: '',
			yingshou: '',
			chengbenfeiyong: '',
			caozuoshijian: '',
			qiyemingcheng: '',

		}
	}
	//获取info
	const getInfo = ()=>{
		context?.$http({
			url: `${tableName}/info/${id.value}`,
			method: 'get'
		}).then(res => {
			let reg=new RegExp('../../../file','g')
			form.value = res.data.data
			formVisible.value = true
		})
	}
	const crossRow = ref('')
	const crossTable = ref('')
	const crossTips = ref('')
	const crossColumnName = ref('')
	const crossColumnValue = ref('')
	//初始化
	const init=(formId=null,formType='add',formNames='',row=null,table=null,statusColumnName=null,tips=null,statusColumnValue=null)=>{
		resetForm()
			form.value.caozuoshijian = context?.$toolUtil.getCurDateTime()
		if(formId){
			id.value = formId
			type.value = formType
		}
		if(formType == 'add'){
			isAdd.value = true
			formTitle.value = '新增' + formName
			formVisible.value = true
		}else if(formType == 'info'){
			isAdd.value = false
			formTitle.value = '查看' + formName
			getInfo()
		}else if(formType == 'edit'){
			isAdd.value = true
			formTitle.value = '修改' + formName
			getInfo()
		}
		else if(formType == 'cross'){
			isAdd.value = true
			formTitle.value = formNames
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
				if(x=='caozuoshijian'){
					form.value.caozuoshijian = row[x];
					disabledForm.value.caozuoshijian = true;
					continue;
				}
				if(x=='qiyemingcheng'){
					form.value.qiyemingcheng = row[x];
					disabledForm.value.qiyemingcheng = true;
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
			formVisible.value = true
		}
		context?.$http({
			url: `${context?.$toolUtil.storageGet('sessionTable')}/session`,
			method: 'get'
		}).then(res => {
			var json = res.data.data
			if(json.hasOwnProperty('qiyemingcheng')&& context?.$toolUtil.storageGet("sessionTable")!="users"){
				form.value.qiyemingcheng = json.qiyemingcheng
				disabledForm.value.qiyemingcheng = true;
			}
		})
	}
	//初始化
	//声明父级调用
	defineExpose({
		init
	})
	//关闭
	const closeClick = () => {
		formVisible.value = false
	}
	//富文本
	const editorChange = (e,name) =>{
		form.value[name] = e
	}
	//提交
	const save= async ()=>{
		if(form.value.xiaoxiangfapiao!=null) {
			form.value.xiaoxiangfapiao = form.value.xiaoxiangfapiao.replace(new RegExp(context?.$config.url,"g"),"");
		}
		if(form.value.jinxiangfapiao!=null) {
			form.value.jinxiangfapiao = form.value.jinxiangfapiao.replace(new RegExp(context?.$config.url,"g"),"");
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
							crossUserId = user.value.id
							crossRefId = objcross['id']
							crossOptNum = crossColumnName.value.replace(/\[/,"").replace(/\]/,"")
						}
					}
				}
				if(crossUserId&&crossRefId){
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
							}).then(async res=>{
								emit('formModelChange')
								context?.$toolUtil.message(`操作成功`,'success')
                                formVisible.value = false
							})
						}
					})
				}else{
					context?.$http({
						url: `${tableName}/${!form.value.id ? "save" : "update"}`,
						method: 'post', 
						data: form.value 
					}).then(async (res)=>{
						emit('formModelChange')
						context?.$toolUtil.message(`操作成功`,'success')
                        formVisible.value = false
					})
				}
			}else{
                context.$message.error('请完善信息')
            }
		})
	}
	//修改跨表数据
	const changeCrossData = async (row,key)=>{
        if(type.value == 'cross'){
			let data = row
			if(key){	//如果有指定key，则只更新key属性
				data = {
					id:row.id,
				}
				data[key] = row[key]
			}
            await context?.$http({
                url: `${crossTable.value}/update`,
                method: 'post',
                data: data
            }).then(res=>{})
        }
	}
</script>
<style lang="scss" scoped>
</style>
