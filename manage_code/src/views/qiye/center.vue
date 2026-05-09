<template>
	<div>
		<div class="center_view edit_form">
			<el-form class="userinfo_form" ref="userinfoFormRef" :model="form">
				<el-row>
					<el-col :span="8">
						<el-form-item label="企业名称" prop="qiyemingcheng">
							<el-input class="list_inp" v-model="user.qiyemingcheng" readonly placeholder="企业名称" clearable />
						</el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="企业电话" prop="qiyedianhua">
							<el-input class="list_inp" v-model="user.qiyedianhua"  placeholder="企业电话" clearable />
						</el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="统一社会信用代码" prop="tongyishehuixinyongdaima">
							<el-input class="list_inp" v-model="user.tongyishehuixinyongdaima"  placeholder="统一社会信用代码" clearable />
						</el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="行业类型" prop="xingyeleixing">
							<el-select 
								class="list_sel" 
								v-model="user.xingyeleixing" 
								placeholder="请选择行业类型"
								>
								<el-option v-for="item in qiyexingyeleixingLists" :label="item" :value="item"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="头像" prop="touxiang">
							<uploads
								action="file/upload" 
								tip="请上传头像"
								style="width: 100%;text-align: left;"
								:fileUrls="user.touxiang?user.touxiang:''" 
								@change="qiyetouxiangUploadSuccess">
							</uploads>
						</el-form-item>
					</el-col>
					<span class="formModel_btn_box">
						<el-button class='confirm_btn' type="primary" @click="onSubmit">保存</el-button>
					</span>
				</el-row>
			</el-form>
		</div>
	</div>
</template>

<script setup>
	import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/toolUtil";
	import {
		reactive,
		ref,
		getCurrentInstance,
        computed
	} from 'vue'
	import { useStore } from 'vuex'
	const store = useStore()
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const tableName = ref('qiye')
	const user = ref({})
	const qiyexingyeleixingLists = ref([])
	const init = () => {
		context?.$http({
			url:`option/xingyeleixing/xingyeleixing`,
			method:'get',
		}).then(res=>{
			qiyexingyeleixingLists.value = res.data.data
		})
	}
	const qiyetouxiangUploadSuccess=(fileUrls)=> {
	    user.value.touxiang = fileUrls;
	}
	const onSubmit = () => {
		if((!user.value.qiyemingcheng)){
			context?.$toolUtil.message(`企业名称不能为空`,'error')
			return false
		}
		if((!user.value.qiyedianhua)){
			context?.$toolUtil.message(`企业电话不能为空`,'error')
			return false
		}
		if((user.value.qiyedianhua)&&(!context?.$toolUtil.isMobile(user.value.qiyedianhua))){
			context?.$toolUtil.message(`企业电话应输入手机格式`,'error')
			return false
		}
		if((!user.value.tongyishehuixinyongdaima)){
			context?.$toolUtil.message(`统一社会信用代码不能为空`,'error')
			return false
		}
		if((!user.value.mima)){
			context?.$toolUtil.message(`密码不能为空`,'error')
			return false
		}
		if(user.value.touxiang!=null){
			user.value.touxiang = user.value.touxiang.replace(new RegExp(context?.$config.url,"g"),"");
		}
		if((user.value.maxPasswordWrong)&&(!context?.$toolUtil.isIntNumer(user.value.maxPasswordWrong))){
			context?.$toolUtil.message(`最大密码输错次数应输入整数`,'error')
			return false
		}
		if((user.value.isLocked)&&(!context?.$toolUtil.isIntNumer(user.value.isLocked))){
			context?.$toolUtil.message(`用户锁定状态应输入整数`,'error')
			return false
		}
		store.dispatch('user/update',user.value).then(res=>{
			if(res?.data&&res.data.code==0)context?.$toolUtil.message('修改成功','success')
		})

	}
	const getInfo = () => {
		context?.$http({
			url: `${tableName.value}/session`,
			method: 'get'
		}).then(res => {
			user.value = res.data.data
			init()
		})
	}
	getInfo()
</script>

<style lang="scss" scoped>
	// 表单
	.userinfo_form {
		:deep(.el-form-item) {
		}
	}
</style>
