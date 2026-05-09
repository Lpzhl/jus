<template>
    <div class="register_view">
<div class="form" style="z-index: 1;">
    <div class="logo"></div>
    <div class="projectName">{{projectName}}注册</div>
			<div class="register_form">
				<div class="list_item">
					<div class="list_label">企业名称：</div>
					<el-input class="list_inp"
						 v-model="registerForm.qiyemingcheng"
						 placeholder="请输入企业名称"
						 type="text"
						/>
				</div>
				<div class="list_item">
					<div class="list_label">企业电话：</div>
					<el-input class="list_inp"
						 v-model="registerForm.qiyedianhua"
						 placeholder="请输入企业电话"
						 type="text"
						/>
				</div>
				<div class="list_item">
					<div class="list_label">统一社会信用代码：</div>
					<el-input class="list_inp"
						 v-model="registerForm.tongyishehuixinyongdaima"
						 placeholder="请输入统一社会信用代码"
						 type="text"
						/>
				</div>
				<div class="list_item">
					<div class="list_label">密码：</div>
					<el-input class="list_inp"
						 v-model="registerForm.mima"
						 placeholder="请输入密码"
						 type="password"
					     show-password
					 />
				</div>
				<div class="list_item">
					<div class="list_label">确认密码：</div>
					<el-input class="list_inp" v-model="registerForm.mima2" type="password" placeholder="请输入确认密码" show-password />
				</div>
				<div class="list_item">
					<div class="list_label">行业类型：</div>
					<el-select
						class="list_sel"
						v-model="registerForm.xingyeleixing"
						placeholder="请选择行业类型"
						>
						<el-option v-for="item in qiyexingyeleixingLists" :label="item" :value="item"></el-option>
					</el-select>
				</div>
				<div class="list_item">
					<div class="list_label">头像：</div>
					<div class="list_file_list">
						<uploads
							action="file/upload"
							tip="请上传头像"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="touxiangUploadSuccess">
						</uploads>
					</div>
				</div>
			</div>

    <div class="btn"><el-button class="register" @click="handleRegister">注册</el-button></div>
    <div class="back" @click="close">已有账号，直接登录</div>
    <div class="form-circle1"></div>
    <div class="form-circle2"></div>
</div>
<div class="circle1"></div>
<div class="circle2"></div>

	</div>
</template>
<script setup>
	import {
		ref,
		getCurrentInstance,
		nextTick,
		onMounted,
	} from 'vue';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const projectName = context.$project.projectName
	//获取注册类型
	import { useRoute } from 'vue-router';
	const route = useRoute()
	const tableName = ref('qiye')

	//公共方法
	const getUUID=()=> {
		return new Date().getTime();
	}
	const registerForm = ref({
		tongyishehuixinyongdaima: getUUID(),
        xingyeleixing: '',
	})
	const qiyexingyeleixingLists = ref([])
	const init=()=>{
		context?.$http({
			url:`option/xingyeleixing/xingyeleixing`,
			method:'get',
		}).then(res=>{
			qiyexingyeleixingLists.value = res.data.data
		})
	}
    const touxiangUploadSuccess=(fileUrls)=> {
        registerForm.value.touxiang = fileUrls;
    }

	//注册按钮
	const handleRegister = () => {
		let url = tableName.value +"/register";
		if((!registerForm.value.qiyemingcheng)){
			context?.$toolUtil.message(`企业名称不能为空`,'error')
			return false
		}
		if((!registerForm.value.qiyedianhua)){
			context?.$toolUtil.message(`企业电话不能为空`,'error')
			return false
		}
		if(registerForm.value.qiyedianhua&&(!context?.$toolUtil.isMobile(registerForm.value.qiyedianhua))){
			context?.$toolUtil.message(`企业电话应输入手机格式`,'error')
			return false
		}
		if((!registerForm.value.tongyishehuixinyongdaima)){
			context?.$toolUtil.message(`统一社会信用代码不能为空`,'error')
			return false
		}
		if((!registerForm.value.mima)){
			context?.$toolUtil.message(`密码不能为空`,'error')
			return false
		}
		if(registerForm.value.mima!=registerForm.value.mima2){
			context?.$toolUtil.message('两次密码输入不一致','error')
			return false
		}
		if(registerForm.value.touxiang!=null){
			registerForm.value.touxiang = registerForm.value.touxiang.replace(new RegExp(context?.$config.url,"g"),"");
		}
		if(registerForm.value.maxPasswordWrong&&(!context?.$toolUtil.isIntNumer(registerForm.value.maxPasswordWrong))){
			context?.$toolUtil.message(`最大密码输错次数应输入整数`,'error')
			return false
		}
		if(registerForm.value.isLocked&&(!context?.$toolUtil.isIntNumer(registerForm.value.isLocked))){
			context?.$toolUtil.message(`用户锁定状态应输入整数`,'error')
			return false
		}
		context?.$http({
			url:url,
			method:'post',
			data:registerForm.value
		}).then(res=>{
			context?.$toolUtil.message('注册成功','success', obj=>{
				context?.$router.push({
					path: "/login"
				});
			})
		})
	}
	//返回登录
	const close = () => {
		context?.$router.push({
			path: "/login"
		});
	}
	init()
	onMounted(()=>{

	})
</script>
<style lang="scss">
	.register_view {
        background-image: url("http://clfile.zggen.cn/20251006/ffad178adfa7408d950a2fb8146c970d.jpg")!important;
	}
.register_view {
    background:url(http://clfile.zggen.cn/20251006/ffad178adfa7408d950a2fb8146c970d.jpg) no-repeat center top / 100% 100%;
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    position: relative;
    overflow: hidden;
    padding: 0px;
}

.register_view .form {
    background: rgba(255,255,255,.9);
    width: 600px;
    margin: 20px auto;
    padding: 0 0 10px;
    border-radius: 10px;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    overflow: hidden;
    box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
    font-size: 16px;
    border-left:8px solid var(--theme50);
}

.register_view .projectName {
    font-size: 20px;
    color: var(--theme);
    font-weight: 600;
    width: 100%;
    text-align: center;
    margin-top: 20px;
    text-shadow: 0px 0px 0px rgba(0, 0, 0, 0.3);
}
.register_view .logo {
    background: url(http://clfile.zggen.cn/20250725/889d208e5ddd4107bce6600713cdf6d1.webp);
    background-size: 100% 100%;
    width: 80px;
    height: 80px;
    animation: float 3s ease-in-out infinite;
    margin: 0 auto;
    display: none;
}
@keyframes float{
     0%,  100% {
        transform: translateY(0);
    }
     50% {
        transform: translateY(-10px);
    }
}

.register_view .register_form {
    width: 100%;
    text-align: left;
    display: flex;
    flex-direction: column;
    margin-top: 20px;
    padding: 0 40px;
}

.register_view .list_item {
    display: flex;
    align-items: center;
    margin-bottom: 15px;
}

.register_view .list_label {
    width: 130px;
    text-align: right;
}

.register_view .list_item .list_inp{
    flex: 1;
    font-size: inherit;
}
.register_view .list_item .el-select{
    flex: 1;
    font-size: inherit;
}

.register_view .list_code {
    display: flex;
}
.register_view .list_code .list_code_btn{
    background: var(--theme2);
    font-size: inherit;
    color: #333;
    border-radius: 4px;
    border: 0px solid #d1d5db;
    height: var(--input-height);
    line-height: var(--input-height);
}

.register_view .list_item .el-input__wrapper {
    border: none;
    outline: none;
    box-shadow: none!important;
    padding: 0;
    background: none!important;
}

.register_view .list_item .el-input__inner {
    background: none;
    height: var(--input-height);
    line-height: var(--input-height);
    border-bottom: 1px solid #d1d5db;
    padding: 0 10px;
    border-radius: 0px;
    font-size: inherit;
}
.register_view .list_item .el-input__inner:focus {
    border-bottom: 1px solid #d1d5db;
}

.register_view .list_item .list_date{
    flex: 1;
    background: none;
    height: var(--input-height);
    line-height: var(--input-height);
    border-bottom: 1px solid #d1d5db;
    padding: 0 10px;
    border-radius: 0px;
}
.register_view .list_item .list_date .el-input__inner {
    background:none;
    height: var(--input-height);
    line-height: var(--input-height);
    border: 0px solid rgba(193,42,49,0.3);
    padding: 0 0px;
    border-radius: 0px;
    font-size: inherit;
}
.register_view .list_item .list_date .el-input__inner:focus {
    border: 0px solid rgba(193,42,49,1);
}

.register_view .list_item .el-select .el-select__wrapper{
    background: none;
    height: var(--input-height);
    line-height:var(--input-height);
    box-shadow:none;
    border-bottom: 1px solid #d1d5db;
    padding: 0 10px;
    border-radius: 0px;
    font-size: inherit;
}
.register_view .list_item .el-select .el-select__wrapper:focus {
    border-bottom: 1px solid var(--theme);
}
.el-select-dropdown__item.is-selected {
    color: var(--theme);
}

.register_view .list_code_item {
    display: flex;
    gap: 20px;
    font-size: inherit;
}
.register_view .list_code_item  .list_code_inp{
    font-size: inherit; 
}

.el-upload-list--picture-card {
    --el-upload-list-picture-card-size: 80px;
}
.el-upload--picture-card {
    --el-upload-picture-card-size: 80px;
    background: none;
    border: 1px solid #ddd;
}
.el-upload--picture-card:hover {
    border: 1px solid var(--theme);  
}
.el-upload__tip {
    color: var(--el-text-color-regular);
    font-size: inherit;
    margin-top: 8px;
}

.register_view .list_item .list_radio{
     font-size: inherit;   
}
.register_view .list_item .list_radio .el-radio{
     font-size: inherit;   
}
.el-radio .el-radio__label{
    font-size: inherit;
}
.el-radio__input.is-checked .el-radio__inner {
    background: var(--theme);
    border-color: var(--theme);
}

.el-radio__input.is-checked+.el-radio__label {
    color: var(--theme);
    font-size: inherit;
}
.el-upload-dragger .el-upload__text{
    font-size: inherit;
}
.el-upload-dragger .el-upload__text em {
    color: var(--theme);
}

.list_checkbox{
    font-size: inherit; 
}
.list_checkbox .el-checkbox{
    font-size: inherit;
}
.list_checkbox .el-checkbox .el-checkbox__label{
    font-size: inherit;
}
.el-checkbox__input.is-checked+.el-checkbox__label {
    color: var(--theme);
}

.register_view .list_item .el-upload {
    --el-upload-dragger-padding-horizontal: 10px;
    --el-upload-dragger-padding-vertical: 10px;
}
.register_view .list_item .el-upload-dragger{
    border: 1px solid #ddd;
    background: none;
}
.register_view .list_item .el-upload-dragger .el-icon--upload {
    color: var(--el-text-color-placeholder);
    font-size: 60px;
    line-height: 1;
    margin-bottom:0px;
}

.el-checkbox__input.is-checked .el-checkbox__inner {
    background-color: var(--theme);
    border-color: var(--theme);
}

.register_view .btn{
    width: 100%;
    padding:20px 40px 0 170px;
}
.register_view .btn .register {
    background: var(--theme);
    border: none;
    color: #fff;
    width: 100%;
    height: 44px;
    font-size: 18px;
    border-radius: 8px;
}

.register_view .back {
    width: 100%;
    padding: 0 0 0 130px;
    margin: 20px auto;
    text-align: center;
    font-size: inherit;
    color:#999;
}
</style>