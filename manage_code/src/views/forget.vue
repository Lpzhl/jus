<template>
	<div class="forget_view">

<div class="form" style="z-index: 1;">
    <div class="pageTitle">{{pageTitle}}</div>
				<div class="tab_view">
					<div class="header_number" :class="pageType>1?'header_number2':pageType==1?'header_number1':''"><div class="number" v-if="pageType<2">1</div><div class="number" v-else><el-icon><Check /></el-icon></div></div>
					<div class="header_number" :class="pageType>2?'header_number2':pageType==2?'header_number1':''"><div class="number" v-if="pageType<3">2</div><div class="number" v-else><el-icon><Check /></el-icon></div></div>
					<div class="header_number" :class="pageType==3?'header_number1':''"><div class="number">3</div></div>
				</div>

			<div class="form-box">
			</div>

     
                    <el-button v-if="pageType==1" class="get_btn" @click="getSecurity">获取密保</el-button>
                    <el-button v-if="pageType==2" class="valid_btn" @click="validateSecurity">确认密保</el-button>
					<el-button v-if="pageType==3" class="update_btn" @click="updatePassword">重置密码</el-button>

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
		computed,
	} from 'vue';
    import { useRoute } from 'vue-router'
    const route = useRoute()
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const projectName = context.$project.projectName
    onMounted(()=>{
    })
	const pageType = ref(1)
	const pageTitle = computed(()=>{
		return pageType.value==1?'输入账号':pageType.value==2?'输入密保':'重置密码'
	})
	const forgetForm = ref({})
	const userForm = ref({})
	//返回登录
	const close = () => {
		context?.$router.push({
			path: "/login"
		});
	}
</script>

<style lang="scss">
	.forget_view {
        background-image: url("http://clfile.zggen.cn/20250901/753701d01cfe4a9db62d1c7e1e449840.png")!important;
	}
.forget_view {
  background-color:none;
    
    display: flex;
    align-items: center;
    justify-content: center;
    position: relative;
    overflow: hidden;
     
background:#feba55;
      background-size: cover;
  background-position: center;
  background-attachment: fixed;
    min-height:100vh ;
}

.forget_view .form {
    background: #fcfcf4;
    width: 600px;
    box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
    padding: 50px 60px 30px 30px;
    border-radius: 24px;
    position: relative;
    overflow: hidden;
    text-align: center;
}

.forget_view .projectName {
    font-size: 24px;
    font-weight: 700;
    width: 100%;
    text-align: center;
    margin-top: 20px;
}
.forget_view .logo {
    background: url(http://clfile.zggen.cn/20250725/889d208e5ddd4107bce6600713cdf6d1.webp);
    background-size: 100% 100%;
    width: 80px;
    height: 80px;
    animation: float 3s ease-in-out infinite;
    margin: 0 auto;
}
@keyframes float{
    0%, 100% {
        transform: translateY(0);
    }
    50% {
        transform: translateY(-10px);
    }
}

.forget_view .circle1 {
    position: absolute;
    left: 100px;
    top: 100px;
    background: #daf4dc;
    width: 200px;
    height: 200px;
    border-radius: 50%;
    z-index: 1;
    animation: float 4s ease-in-out infinite;
}

.forget_view .circle2 {
    position: absolute;
    right: 100px;
    bottom: 100px;
    background: #EBEFD9;
    width: 300px;
    height: 300px;
    border-radius: 50%;
    z-index: 0;
    animation: float 5s ease-in-out infinite;
}
.forget_view .form-circle1 {
    position: absolute;
    right: -34px;
    top: -32px;
    background: #dff6e9;
    width: 140px;
    height: 140px;
    border-radius: 50%;
    z-index: -1;
}

.forget_view .form-circle2 {
    position: absolute;
    left: -34px;
    bottom: -32px;
    background: #f7efeb;
    width: 140px;
    height: 140px;
    border-radius: 50%;
    z-index: -1;
}


.forget_view .register_form {
    text-align: left;
    display: flex;
    flex-direction: column;
    gap: 20px;
    margin-top: 40px;
    padding: 0 50px;
}

.forget_view .list_item {
    display: flex;
    align-items: center;
    padding: 10px;
}

.forget_view .item_label {
    min-width:15%;
    text-align: right;
}

.forget_view .register {
    background: var(--theme);
    border: none;
    color: #fff;
    width: 60%;
    margin-top: 30px;
    height: 40px;
    font-size: 18px;
}

.forget_view .back {
    width: 50%;
    margin: 20px auto;
    color:#87C3FF;
}

.forget_view .tab {
    width: calc(33.3333%);
    padding: 16px 0px;
    box-sizing: border-box;
    text-align: center;
}
.forget_view .tab.tab_active {
    width: calc(33.3333%);
    padding: 16px 0px;
    box-sizing: border-box;
    text-align: center;
    clip-path: polygon(0% 0%, 92% 0%, 100% 50%, 92% 100%, 0px 100%, 8% 50%);
    background: var(--theme);
    color: rgb(255, 255, 255);
}
.forget_view .tab_view {
    width: 50%;
    display: flex;
    align-items: center;
    padding: 30px 0px;
    font-size: 16px;
}

.forget_view .pageTitle {
    font-size: 24px;
    font-weight: 700;
    width: 100%;
    text-align: center;
    margin-top: 20px;
}

.forget_view .el-input.list_inp {
    height: 40px;
}

.forget_view .el-select__wrapper {
    height: 40px;
}

.forget_view button.el-button {
    background: var(--theme);
    color: #fff;
    width: 50%;
    border: none;
    height: 40px;
    margin-top: 30px;
}
.forget_view  .backgif {
   width: 1107px;
  height: 1080px;
  background-image: url('http://clfile.zggen.cn/20250805/40ac7c5f1da54ac09a77ac5707af19a8.gif');
  background-size: cover;  
  background-position: top center;  
  background-repeat: no-repeat;
}
.forget_view  .form {
    display: block;
    overflow: auto;
    position: relative;
}

.forget_view  .form {
    width: 813px !important;
    height: 1080px;
    background: #FFFFFF !important;
}
.forget_view  .backgif {
   width: 1107px;
  height: 1080px;
  background-image: url('http://clfile.zggen.cn/20250805/40ac7c5f1da54ac09a77ac5707af19a8.gif');
  background-size: cover;  
  background-position: top center;  
  background-repeat: no-repeat;
}
.forget_view .form {
    display: block;
    overflow: auto;
    position: relative;
}

.forget_view  .form {
    width: 813px !important;
    height: 1080px;
    background: #FFFFFF !important;
}

.circle1 {
 display:none
}

.form-circle1 {
 display:none
 
}

.form-circle2 {
 display:none
 
}


.forget_view .tab {
    clip-path: none !important;
 background: #FFFFFF;
box-shadow: 0px 4px 10px 0px rgba(0,0,0,0.3);
border-radius: 0px 5px 5px 0px!important;
}


.forget_view .tab.tab_active {

box-shadow: 0px 4px 10px 0px rgba(0,0,0,0.3);
border-radius: 0px 5px 5px 0px!important;
}

.forget_view .tab_view {
 width:70%!important;
 margin:auto;
}

.forget_view .list_item {
 width:90%;
 margin:auto;

   flex-direction: row; 
  align-items: center; 
}

.forget_view .item_label {
 width:15%;

text-align: left!important;
 margin-bottom:5px;
font-weight: 400;
font-size: 14px;
color: #9CA3AF;
font-style: normal;
text-transform: none;
}

.forget_view button.el-button.get_btn {
 width: 400px;
height: 60px;
background: #0949F7;
border-radius: 5px 5px 5px 5px;
}

.forget_view button.el-button.get_btn span {
font-weight: 700;
font-size: 24px;
color: #FFFFFF;
line-height: 20px;
text-align: left;
font-style: normal;
text-transform: none;
}

.forget_view .el-input.list_inp {
 width:510px;
}

.forget_view .pageTitle {
 margin-top:10%!important;
}

.forget_view .el-select.list_sel {
 width:510px;
}
.forget_view .form {
    width: 550px !important;
    height: 560px !important;
    margin-left: 20px !important;
    margin-top: 10px !important;
    background: #FFFFFF !important;
        box-shadow:none!important;
    padding:0px;
  
  scrollbar-width: none; 
  -ms-overflow-style: none; 
box-shadow: 0px 4px 10px 0px #87C3FF!important;
border-radius: 30px 30px 30px 30px!important;
}
.forget_view .backgif {
   
  width: 1280px !important;  
  height: 627px !important;   
  
  
  background: 
    url('http://clfile.zggen.cn/20250814/5714f5d298b5480aace355cf93dfcfdf.png') 
    center / contain 
    no-repeat !important;
  padding: 10px;

  
  border-radius: 30px;
  margin: 160px auto;
  box-sizing: border-box; 
}

.forget_view .list_item {
  margin:20px auto!important;
  width:70%!important;
  padding:1px;
  padding-left:17px;
  background: #FFFFFF!important;
border-radius: 5px 5px 5px 5px!important;
    box-shadow: 0 0 0 1px var(--el-input-border-color, var(--el-border-color)) inset;
}








.circle2 {
  display:none;
}

.forget_view .item_label {
min-width:20%!important;
color: #000000;
}

.forget_view .el-input__wrapper {
box-shadow:none;
}

.forget_view .el-select__wrapper.el-tooltip__trigger.el-tooltip__trigger {
box-shadow:none;
}

.forget_view button.el-button.get_btn {
background: var(--theme)!important;

    width: 50%;
    border: none;
    height: 40px;
    margin-top: 30px;
}
.forget_view button.el-button.get_btn span{
   color: #FFFFFF!important;
}

.forget_view button.el-button.valid_btn {
width:400px;
height:60px;
   
}
.forget_view button.el-button.valid_btn span{
 font-weight: 700;
    font-size: 24px;
    color: #FFFFFF;
    line-height: 20px;
    text-align: left;
    font-style: normal;
    text-transform: none;
}

.forget_view button.el-button.update_btn {
width:400px;
height:60px;
}
.forget_view button.el-button.update_btn span{
 font-weight: 700;
    font-size: 24px;
    color: #FFFFFF;
    line-height: 20px;
    text-align: left;
    font-style: normal;
    text-transform: none;
}
.header_number.header_number1 {}

.header_number.header_number1 {
width: 40px;
height: 40px;
background: #FFF08A;
border-radius: 20px 20px 20px 20px;
line-height:40px;
font-weight: 700;
font-size: 28px;
color: #000000;
}
 
.header_number.header_number2 {
width: 40px;
height: 40px;
background: #FFF08A;
border-radius: 20px 20px 20px 20px;
line-height:40px;
font-weight: 700;
font-size: 28px;
color: #000000;
}

.tab_view {
    width:!important;
justify-content: space-between;
}

.header_number {
width: 40px;
height: 40px;
background: #87C3FF;
border-radius: 20px 20px 20px 20px;
color:#fff;
line-height:40px;
font-weight: 700;
font-size: 28px;
}






button.el-button.get_btn {
    width: 400px!important;
    height: 60px!important;
}

</style>