<template>
	<div>
		<el-dialog modal-class="edit_form_modal" class="edit_form" v-model="formVisible" :title="formTitle" width="90%" destroy-on-close :fullscreen='false'>
			<el-form class="formModel_form" ref="formRef" :model="form" :rules="rules">
				<el-row >
					<el-col :span="8" >
						<el-form-item label="企业名称" prop="qiyemingcheng">
							<el-select
								class="list_sel"
								:disabled="!isAdd||disabledForm.qiyemingcheng?true:false"
								v-model="form.qiyemingcheng" 
								placeholder="请选择企业名称"
								>
								<el-option v-for="(item,index) in qiyemingchengLists" :label="item"
									:value="item"
									>
								</el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="8" >
						<el-form-item label="税负异常" prop="shuifuyichang">
							<el-select
								class="list_sel"
								:disabled="!isAdd||disabledForm.shuifuyichang?true:false"
								v-model="form.shuifuyichang" 
								placeholder="请选择税负异常"
								>
								<el-option v-for="(item,index) in shuifuyichangLists" :label="item"
									:value="item"
									>
								</el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="8" >
						<el-form-item label="逾期申报" prop="yuqishenbao">
							<el-select
								class="list_sel"
								:disabled="!isAdd||disabledForm.yuqishenbao?true:false"
								v-model="form.yuqishenbao" 
								placeholder="请选择逾期申报"
								>
								<el-option v-for="(item,index) in yuqishenbaoLists" :label="item"
									:value="item"
									>
								</el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="风险点" prop="fengxiandian">
							<el-input class="list_inp" v-model.number="form.fengxiandian" placeholder="风险点"
                                type="number"
                                @mousewheel.native.prevent
								:readonly="!isAdd||disabledForm.fengxiandian?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="8">
						<el-form-item label="创建时间" prop="chuangjianshijian">
							<el-date-picker
								class="list_date"
								v-model="form.chuangjianshijian"
								format="YYYY-MM-DD HH:mm:ss"
								value-format="YYYY-MM-DD HH:mm:ss"
								type="datetime"
								:readonly="!isAdd||disabledForm.chuangjianshijian?true:false"
								placeholder="请选择创建时间" />
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
	const tableName = 'qiyexiangqing'
	const formName = '企业详情'
	//基础信息
	//form表单
	const form = ref({})
	const disabledForm = ref({
        qiyemingcheng : false,
        shuifuyichang : false,
        yuqishenbao : false,
        fengxiandian : false,
        chuangjianshijian : false,
	})
	const formVisible = ref(false)
	const isAdd = ref(false)
	const formTitle = ref('')
	const rules = ref({
		qiyemingcheng: [
		],
		shuifuyichang: [
		],
		yuqishenbao: [
		],
		fengxiandian: [
			{ validator: context.$toolUtil.validator.number, trigger: 'blur' },
		],
		chuangjianshijian: [
		],
	})
	//表单验证
	
	const formRef = ref(null)
	const id = ref(0)
	const type = ref('')
	//企业名称列表
	const qiyemingchengLists = ref([])
	//税负异常列表
	const shuifuyichangLists = ref([])
	//逾期申报列表
	const yuqishenbaoLists = ref([])
	//获取唯一标识
	const getUUID =()=> {
      return new Date().getTime();
    }
	//重置
	const resetForm = () => {
		form.value = {
			qiyemingcheng: '',
			shuifuyichang: '',
			yuqishenbao: '',
			fengxiandian: '',
			chuangjianshijian: '',

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
			form.value.chuangjianshijian = context?.$toolUtil.getCurDateTime()
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
				if(x=='qiyemingcheng'){
					form.value.qiyemingcheng = row[x];
					disabledForm.value.qiyemingcheng = true;
					continue;
				}
				if(x=='shuifuyichang'){
					form.value.shuifuyichang = row[x];
					disabledForm.value.shuifuyichang = true;
					continue;
				}
				if(x=='yuqishenbao'){
					form.value.yuqishenbao = row[x];
					disabledForm.value.yuqishenbao = true;
					continue;
				}
				if(x=='fengxiandian'){
					form.value.fengxiandian = row[x];
					disabledForm.value.fengxiandian = true;
					continue;
				}
				if(x=='chuangjianshijian'){
					form.value.chuangjianshijian = row[x];
					disabledForm.value.chuangjianshijian = true;
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
		})
		context?.$http({
			url: `option/qiye/qiyemingcheng`,
			method: 'get',
		}).then(res=>{
			qiyemingchengLists.value = res.data.data
		})
		shuifuyichangLists.value = "是,否".split(',')
		yuqishenbaoLists.value = "是,否".split(',')
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
