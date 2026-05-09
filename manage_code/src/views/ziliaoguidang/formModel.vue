<template>
	<div>
		<el-dialog modal-class="edit_form_modal" class="edit_form" v-model="formVisible" :title="formTitle" width="90%" destroy-on-close :fullscreen='false'>
			<el-form class="formModel_form" ref="formRef" :model="form" :rules="rules">
				<el-row >
					<el-col :span="8">
						<el-form-item label="税务合同" prop="shuiwuhetong">
							<uploads
								:disabled="!isAdd||disabledForm.shuiwuhetong?true:false"
								type="file"
								action="file/upload" 
								tip="请上传税务合同" 
								:limit="1" 
								style="width: 100%;text-align: left;"
								:fileUrls="form.shuiwuhetong?form.shuiwuhetong:''" 
								@change="shuiwuhetongUploadSuccess">
							</uploads>
						</el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="附件凭证" prop="fujianpingzheng">
							<uploads
								:disabled="!isAdd||disabledForm.fujianpingzheng?true:false"
								type="file"
								action="file/upload" 
								tip="请上传附件凭证" 
								:limit="1" 
								style="width: 100%;text-align: left;"
								:fileUrls="form.fujianpingzheng?form.fujianpingzheng:''" 
								@change="fujianpingzhengUploadSuccess">
							</uploads>
						</el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="上传时间" prop="shangchuanshijian">
							<el-date-picker
								class="list_date"
								v-model="form.shangchuanshijian"
								format="YYYY-MM-DD HH:mm:ss"
								value-format="YYYY-MM-DD HH:mm:ss"
								type="datetime"
								:readonly="!isAdd||disabledForm.shangchuanshijian?true:false"
								placeholder="请选择上传时间" />
						</el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="企业名称" prop="qiyemingcheng">
							<el-input class="list_inp" v-model="form.qiyemingcheng" placeholder="企业名称"
                                type="text"
								:readonly="!isAdd||disabledForm.qiyemingcheng?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="8">
						<el-form-item label="归档时间" prop="guidangshijian">
							<el-date-picker
								class="list_date"
								v-model="form.guidangshijian"
								format="YYYY-MM-DD HH:mm:ss"
								value-format="YYYY-MM-DD HH:mm:ss"
								type="datetime"
								:readonly="!isAdd||disabledForm.guidangshijian?true:false"
								placeholder="请选择归档时间" />
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
	const tableName = 'ziliaoguidang'
	const formName = '资料归档'
	//基础信息
	//form表单
	const form = ref({})
	const disabledForm = ref({
        shuiwuhetong : false,
        fujianpingzheng : false,
        shangchuanshijian : false,
        qiyemingcheng : false,
        guidangshijian : false,
        crossuserid : false,
        crossrefid : false,
	})
	const formVisible = ref(false)
	const isAdd = ref(false)
	const formTitle = ref('')
	const rules = ref({
		shuiwuhetong: [
		],
		fujianpingzheng: [
		],
		shangchuanshijian: [
		],
		qiyemingcheng: [
		],
		guidangshijian: [
		],
		crossuserid: [
		],
		crossrefid: [
		],
	})
	//表单验证
	
	const formRef = ref(null)
	const id = ref(0)
	const type = ref('')
	//税务合同上传回调
	const shuiwuhetongUploadSuccess=(e)=>{
		form.value.shuiwuhetong = e
	}
	//附件凭证上传回调
	const fujianpingzhengUploadSuccess=(e)=>{
		form.value.fujianpingzheng = e
	}
	//获取唯一标识
	const getUUID =()=> {
      return new Date().getTime();
    }
	//重置
	const resetForm = () => {
		form.value = {
			shuiwuhetong: '',
			fujianpingzheng: '',
			shangchuanshijian: '',
			qiyemingcheng: '',
			guidangshijian: '',
			crossuserid: '',
			crossrefid: '',

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
			form.value.shangchuanshijian = context?.$toolUtil.getCurDateTime()
			form.value.guidangshijian = context?.$toolUtil.getCurDateTime()
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
				if(x=='shuiwuhetong'){
					form.value.shuiwuhetong = row[x];
					disabledForm.value.shuiwuhetong = true;
					continue;
				}
				if(x=='fujianpingzheng'){
					form.value.fujianpingzheng = row[x];
					disabledForm.value.fujianpingzheng = true;
					continue;
				}
				if(x=='shangchuanshijian'){
					form.value.shangchuanshijian = row[x];
					disabledForm.value.shangchuanshijian = true;
					continue;
				}
				if(x=='qiyemingcheng'){
					form.value.qiyemingcheng = row[x];
					disabledForm.value.qiyemingcheng = true;
					continue;
				}
				if(x=='guidangshijian'){
					form.value.guidangshijian = row[x];
					disabledForm.value.guidangshijian = true;
					continue;
				}
				if(x=='crossuserid'){
					form.value.crossuserid = row[x];
					disabledForm.value.crossuserid = true;
					continue;
				}
				if(x=='crossrefid'){
					form.value.crossrefid = row[x];
					disabledForm.value.crossrefid = true;
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
		if(form.value.shuiwuhetong!=null) {
			form.value.shuiwuhetong = form.value.shuiwuhetong.replace(new RegExp(context?.$config.url,"g"),"");
		}
		if(form.value.fujianpingzheng!=null) {
			form.value.fujianpingzheng = form.value.fujianpingzheng.replace(new RegExp(context?.$config.url,"g"),"");
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
	// 表单
	.formModel_form{
		:deep(.el-form-item) {
			.el-form-item__content {
				//文件上传样式
				.upload-demo {
					width: 100%;
				}
			}
		}
	}
</style>
