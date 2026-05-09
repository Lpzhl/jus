<template>
    <div class="login_view">
<div class="form" style="z-index: 1;">
    <div class="form2">
    <div class="logo"></div>
    <div class="projectName">{{projectName}}</div>
    <div class="tip"></div>
				<div class="form-item userName" v-if="loginType==1">
					<div class="label">
						账号：
					</div>
					<el-input class="item-input" v-model="loginForm.username" placeholder="请输入账号" name="username" />
				</div>

				<div class="form-item password" v-if="loginType==1">
					<div class="label">
						密码：
					</div>
					<el-input class="item-input" v-model="loginForm.password" type="password" show-password placeholder="请输入密码" @keydown.enter.native="handleLogin"  />
				</div>


				<div class="form-item roles" v-if="userList.length>1">
					<div class="label">
						用户类型：
					</div>
				  <el-select v-model="loginForm.role" placeholder="请选择用户类型">
					<el-option v-for="(item,index) in userList" :label="item.roleName" :value="item.roleName"></el-option>
				  </el-select>
				</div>

				<el-button class="login" v-if="loginType==1" @click="handleLogin">登录</el-button>


                    <el-button class="register" @click="handleRegister('qiye')">注册企业</el-button>

    <div class="forget-row">

    </div>
    <div class="card-decoration-1 bg-cream"></div>
    <div class="card-decoration-2 bg-mauve"></div>
</div>
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
	} from "vue";
	import {
		useStore
	} from 'vuex';
	const store = useStore()
    const projectName = ref(`小企业税务智能管理系统设计与实现`)
	import menu from '@/utils/menu'
	const userList = ref([])
	const menus = ref([])
	const loginForm = ref({
		role: '',
		username: '',
		password: ''
	})
	const tableName = ref('')
	const loginType = ref(1)
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	//注册
    const handleRegister = (tableName) => {
    	context?.$router.push(`/${tableName}Register`)
    }
	const handleLogin = () => {
		if (!loginForm.value.username) {
			context?.$toolUtil.message('请输入用户名', 'error')
			return;
		}
		if (!loginForm.value.password) {
			context?.$toolUtil.message('请输入密码', 'error')
			return;
		}
		if (userList.value.length > 1) {
			if (!loginForm.value.role) {
				context?.$toolUtil.message('请选择角色', 'error')
				verifySlider.reset()
				return;
			}
			for (let i = 0; i < menus.value.length; i++) {
				if (menus.value[i].roleName == loginForm.value.role) {
					tableName.value = menus.value[i].pathName||menus.value[i].tableName;
				}
			}
		} else {
			tableName.value = userList.value[0].pathName||userList.value[0].tableName;
			loginForm.value.role = userList.value[0].roleName;
		}
		login()
	}
	const login = () => {
		context?.$http({
			url: `${tableName.value}/login?username=${loginForm.value.username}&password=${loginForm.value.password}`,
			method: 'post'
		}).then(res => {
			context?.$toolUtil.storageSet("frontToken", res.data.token);
			context?.$toolUtil.storageSet("frontRole", loginForm.value.role);
			context?.$toolUtil.storageSet("frontSessionTable", tableName.value);
			store.dispatch('user/getSession')
			let path = context?.$toolUtil.storageGet('toPath')
			if (path && path!='/login') {
				context?.$router.replace(path)
				context?.$toolUtil.storageRemove('toPath')
				return
			}
			context?.$router.replace(`/index/${tableName.value}Center`)
		},err=>{
		})
	}
	//获取菜单
	const getMenu= async ()=> {
		let arr = menu.list()
		if(!arr){
			let res = await context?.$http.get("menu/list")
			context?.$toolUtil.storageSet("menus", res.data.data.list[0].menujson);
			arr = JSON.parse(res.data.data.list[0].menujson)
		}
		menus.value = arr
		for (let i = 0; i < menus.value.length; i++) {
			if (menus.value[i].hasFrontLogin=='是') {
				userList.value.push(menus.value[i])
			}
		}
    }
	//初始化
	const init = async () => {
		await getMenu();
		loginForm.value.role = userList.value[0].roleName
	}
	onMounted(()=>{
		init()

	})
</script>

<style lang="scss">
	.login_view {
        background-image: url("http://clfile.zggen.cn/20251006/ffad178adfa7408d950a2fb8146c970d.jpg")!important;
	}
.login_view {
    background:url(http://clfile.zggen.cn/20251006/ffad178adfa7408d950a2fb8146c970d.jpg) no-repeat center top / 100% 100%;
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    position: relative;
    overflow: hidden;
}

.login_view .form {
    background: rgba(255,255,255,.9);
    width: 660px;
    margin: 0 auto;
    padding: 0;
    border-radius: 10px;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    overflow: hidden;
    box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
    font-size: 16px;
    border-left:8px solid var(--theme50);
}
.login_view .form2 {
    width: 100%;
    background: rgba(255,255,255,0);
    padding: 20px 40px;
    border: 0px solid #DDA0DD;
    position: relative;
    text-align: center;
}

.login_view .projectName {
    font-size: 24px;
    color: var(--theme);
    font-weight: 700;
    width: 100%;
    text-align: center;
    margin-top: 20px;
    text-shadow: 0px 0px 0px rgba(0, 0, 0, 0.3);
}

.login_view .tip {
    font-size: 16px;
    width: 100%;
    text-align: center;
    margin-top: 10px;
    color: #6b7280;
}

.login_view .form-item {
    width: 100%;
    display: flex;
    align-items: center;
    margin-top: 20px;
    background: none !important;
    padding: 0;
    border-bottom: 1px dashed #d1d5db;
    line-height: 50px;
    border-radius: 0px;
}

.login_view .form-item .item-input{
    flex:1;
    font-size: inherit;
}

.login_view .el-input__wrapper {
    border: none;
    outline: none;
    box-shadow: none!important;
    padding: 0;
    background: none!important;
}

.login_view .form-item .el-input__inner {
    background:none;
    height: var(--input-height);
    line-height: var(--input-height);
    border: 0px solid #d1d5db;
    padding: 0 10px;
    border-radius: 6px;
    font-size: inherit;
}
.login_view .form-item .el-input__inner:focus {
    border: 0px solid #a7b5ca;
}
.login_view .form-item .el-select{
    flex: 1;
}
.login_view .form-item .el-select .el-select__wrapper{
    background: none;
    height: var(--input-height);
    line-height:var(--input-height);
    box-shadow:none;
    border: 0px solid #d1d5db;
    padding: 0 10px;
    border-radius: 6px;
    font-size: inherit;
}
.login_view .form-item .el-select .el-select__wrapper:focus {
    border: 0px solid #a7b5ca;
}
.el-select-dropdown__item.is-selected{
    color: var(--theme);
}

.login_view .label {
    background: none;
    color: #333;
    font-size: inherit;
    padding: 0 10px;
    white-space: nowrap;
    width: 130px;
    text-align: right;
}
.login_view .label .el-icon{
    font-size:18px;
    top: 4px;
}
.el-input .el-input__password {
    margin-right: 10px;
}


.login_view .code-info {
    width: 120px;
    background: #fffacd;
    flex-shrink: 0;
    display: flex;
    justify-content: space-around;
    font-size: 20px;
    border-radius: 10px;
    border: 0px solid var(--theme);
    height: var(--input-height);
    line-height: var(--input-height);
    margin:0 3px 0 0;
}

.login_view .form-item.code {
    position: relative;
}
.login_view .form-item.code .item-input{
    flex:1
}

.login_view .form-item.roles {
    position: relative;
    background: none;
    display: flex;
    gap: 0px;
    padding: 0;
}

.login_view .el-radio.role {
    background: #fff;
    border: 1px solid #eee;
    padding: 10px;
    flex: 1;
    margin-right: 0;
    border-radius: 8px;
}

.login_view .login {
    width: auto;
    margin-top: 20px;
    height: 50px;
    background: var(--theme);
    border: none;
    color: #fff;
    font-size: 18px;
    border-radius: 8px;
    margin: 20px 20px 0 0;
    min-width: 100px;
}
.login_view .face{
    width: auto;
    height: 50px;
    line-height: 50px;
    background: #ADD8E6;
    border: none;
    color: #fff;
    font-size: 18px;
    text-align: center;
    margin-left: 0;
    border-radius: 8px;
    margin: 20px 20px 0 0;
}

.login_view .register-row{
    width: auto;
    display: inline-flex;
    flex-wrap: wrap;
    justify-content: center;
}

.login_view .register {
    background: #fff;
    border: none;
    font-size: 16px;
    border:1px solid var(--theme50);
    display: inlien-block;
    height: 50px;
    line-height: 50px;
    padding: 0 10px;
    border-radius: 8px;
    color:var(--theme);
    min-width: 100px;
    margin: 20px 20px 0 0;
}

.login_view .register:hover{
    opacity: 0.8;
}
.login_view .forget-row {
    width: 100%;
    display: flex;
    justify-content: flex-end;
    margin-top: 20px;
}

.login_view .forget {
    background: none;
    border: 0;
    font-size: 16px;   
    color: #999;
}
.login_view .forget:hover{
    color:var(--theme);
}

.login_view .logo {
    background: url(http://clfile.zggen.cn/20250725/889d208e5ddd4107bce6600713cdf6d1.webp);
    background-size: 100% 100%;
    width: 80px;
    height: 80px;
    animation: float 3s ease-in-out infinite;
    display: none;
}


</style>