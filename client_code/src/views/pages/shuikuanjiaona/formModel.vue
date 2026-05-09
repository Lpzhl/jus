<template>
	<div class="detail-page">
        <div class="breadcrumb-wrapper" style="width: 100%;">
            <div class="bread_view">
                <el-breadcrumb separator=":" class="breadcrumb">
                    <el-breadcrumb-item class="first_breadcrumb" :to="{ path: '/' }">首页</el-breadcrumb-item>
                    <el-breadcrumb-item class="second_breadcrumb" v-for="(item,index) in breadList" :key="index">{{item.name}}</el-breadcrumb-item>
                </el-breadcrumb>
            </div>
            <div class="back_view">
                <el-button class="back_btn" @click="backClick">返回</el-button>
            </div>
        </div>
		<div class="detail_view">
			<div class="info_view">
				<div class="title_view">
					<div class="detail_title">
					</div>
				</div>
				<div class="info_item">
					<div class="info_label">倒计时</div>
					<count-down class="countDown" v-if="endTime&&startTime" :startTime="startTime" :endTime="endTime" :tipText="'距离开始'"
						tipTextEnd="距离结束 " :endText="`倒计时已结束`" dayTxt="天 " hourTxt="小时 "
						minutesTxt="分钟 " secondsTxt="秒" @end_callback="onCountdownEnd">
					</count-down>
				</div>
				<div class="info_item">
					<div class="info_label">年份</div>

					<div  class="info_text" >{{detail.nianfen}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">月份</div>

					<div  class="info_text" >{{detail.yuefen}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">营收</div>

					<div  class="info_text" >{{detail.yingshou}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">成本费用</div>

					<div  class="info_text" >{{detail.chengbenfeiyong}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">申报时间</div>

					<div  class="info_text" >{{detail.shenbaoshijian}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">企业名称</div>

					<div  class="info_text" >{{detail.qiyemingcheng}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">税款金额</div>

					<div  class="info_text" >{{detail.shuikuanjine}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">总费用</div>

					<div  class="info_text" >{{detail.zongfeiyong}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">完税凭证</div>
					<div class="info_text">
						<el-button class="info_down" v-if="detail.wanshuipingzheng" @click="downClick(detail.wanshuipingzheng)">点击下载</el-button>
						<el-button class="info_undown" v-else>暂无</el-button>
					</div>
				</div>
				<div class="btn_view">
					<el-button class="cross_btn" v-if="btnFrontAuth('shuikuanjiaona','催缴')" @click="qianshuicuijiaoonAcross('催缴','是','否','','')" type="warning">催缴</el-button>
					<el-button v-if="centerType&&(detail.ispay=='未支付'||!detail.ispay)&&btnFrontAuth('shuikuanjiaona','支付')&&!isExpired" class="approval_btn" @click="payClick">支付</el-button>
					<el-button v-if="centerType&&(detail.ispay=='未支付'||!detail.ispay)&&btnFrontAuth('shuikuanjiaona','支付')&&isExpired" class="approval_btn" type="info" disabled>已过期</el-button>
					<el-button class="edit_btn" v-if="centerType&&btnAuth('shuikuanjiaona','修改')" type="primary" @click="editClick">修改</el-button>
					<el-button class="del_btn" v-if="centerType&&btnAuth('shuikuanjiaona','删除')" type="danger" @click="delClick">删除</el-button>
				</div>
			</div>
		</div>
		<payForm ref="payRef" @paySave="paySave"></payForm>
	</div>
</template>
<script setup>
	import axios from 'axios'
    const moment = window.moment
	import {
		ref,
		getCurrentInstance,
		watch,
		onUnmounted,
		onMounted,
		nextTick,
		computed,
        inject
	} from 'vue';
	import countDown from '@/components/countDown'
	import {
		useRoute,
		useRouter
	} from 'vue-router';
	import {
		useStore
	} from 'vuex';
	const store = useStore()
	const user = computed(()=>store.getters['user/session'])
	const userAvatar = computed(()=>store.getters['user/avatar'])
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const route = useRoute()
	const router = useRouter()
    const baseUrl = ref(context.$config.url)
	//基础信息
	const tableName = 'shuikuanjiaona'
	const formName = '税款缴纳'
	//基础信息
	const breadList = ref([{
		name: formName
	}])
	//权限验证
	const btnAuth = (e,a)=>{
		if(centerType.value){
			return context?.$toolUtil.isBackAuth(e,a)
		}else{
			return context?.$toolUtil.isAuth(e,a)
		}
	}
	//查看权限验证
	const btnFrontAuth = (e,a)=>{
		if(centerType.value){
			return context?.$toolUtil.isBackAuth(e,a)
		}else{
			return context?.$toolUtil.isFrontAuth(e,a)
		}
	}
	// 返回
	const backClick = () =>{
		history.back()
	}
	// 轮播图
	const bannerList = ref([])
	// 详情
	const title = ref('')
	const detail = ref({})
    const activeName = ref('false')
	const startTime = ref('')
	const endTime = ref('')
	const isExpired = ref(false)
	const onCountdownEnd = () => {
		isExpired.value = true
	}
	const getDetail = () => {
		context?.$http({
			url: `${tableName}/detail/${route.query.id}`,
			method: 'get'
		}).then(res => {
			startTime.value = new Date().getTime()
			endTime.value = new Date(res.data.data.reversetime).getTime()
			if (endTime.value <= startTime.value) {
				isExpired.value = true
			}
			detail.value = res.data.data
		})
	}
	// 下载文件
	const downClick = (file) => {
		if(!file){
			context?.$toolUtil.message('文件不存在','error')
		}
		let arr = file.replace(new RegExp('file/', "g"), "")
		axios.get((location.href.split(context?.$config.name).length>1 ? location.href.split(context?.$config.name)[0] :'') + context?.$config.name + '/file/download?fileName=' + arr, {
			headers: {
				token: context?.$toolUtil.storageGet('frontToken')
			},
			responseType: "blob"
		}).then(({
			data
		}) => {
			const binaryData = [];
			binaryData.push(data);
			const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
				type: 'application/pdf;chartset=UTF-8'
			}))
			const a = document.createElement('a')
			a.href = objectUrl
			a.download = arr
			// a.click()
			// 下面这个写法兼容火狐
			a.dispatchEvent(new MouseEvent('click', {
				bubbles: true,
				cancelable: true,
				view: window
			}))
			window.URL.revokeObjectURL(data)
		})
	}
    const approvalSave = async (form)=>{
        context.$http.post(`${tableName}/update`,form).then(res => {
            context.$message.success('审核成功')
            approvalRef.value.approvalVisible = false
            init()
        })
    }
	// 判断是否从个人中心跳转
	const centerType = ref(false)
	const init = () => {
		if(route.query.centerType){
			centerType.value = true
		}
		getDetail()
	}
    const paySave = async(data)=>{
        data.ispay = '已支付'
        context?.$http({
            url: `${tableName}/update`,
            method: 'post',
            data: data
        }).then(res => {
            context.$message.success('支付成功')
            payRef.value.payVisible = false
            getDetail()
        })
    }
	//普通支付
	import payForm from '@/components/payForm'
	const payRef = ref(null)
	const payClick = ()=>{
        payRef.value.payClick(tableName,detail.value)
	}
	//修改
	const editClick = () => {
		router.push(`/index/${tableName}Add?id=${detail.value.id}&&type=edit`)
	}
	//删除
	const delClick = () => {
		ElMessageBox.confirm(`是否删除此${formName}？`, '提示', {
			confirmButtonText: '是',
			cancelButtonText: '否',
			type: 'warning',
		}).then(()=>{
			context?.$http({
				url: `${tableName}/delete`,
				method: 'post',
				data: [detail.value.id]
			}).then(res=>{
				context?.$toolUtil.message('删除成功','success',()=>{
					history.back()
				})
			})

		}).catch(_ => {})
	}
	const qianshuicuijiaoonAcross = async (btnType,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue,type=1) => {
		if(!context?.$toolUtil.storageGet('frontToken')){
			context?.$toolUtil.message('请登录后再操作！','error')
			return false
		}
		if(!btnAuth('shuikuanjiaona',btnType)){
			context?.$toolUtil.message('暂无权限操作！','error')
			return false
		}
        if(crossOptPay=='是'&&detail.value.ispay!='已支付') {
            context.$message.error('请支付完成再操作')
            return;
        }
		if (new Date().getTime() > new Date(detail.value.reversetime).getTime()) {
			context?.$toolUtil.message('倒计时已结束！','error')
			return false
		}
		context?.$toolUtil.storageSet('crossObj',JSON.stringify(detail.value))
		context?.$toolUtil.storageSet('crossTable',tableName)
		context?.$toolUtil.storageSet('crossStatusColumnName',statusColumnName)
		context?.$toolUtil.storageSet('crossTips',tips)
		context?.$toolUtil.storageSet('crossStatusColumnValue',statusColumnValue)
		if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
			var obj = detail.value
			for (var o in obj){
				if(o==statusColumnName && obj[o]==statusColumnValue){
					context?.$toolUtil.message(tips,'warning')
					return;
				}
			}
		}
		nextTick(()=>{
			router.push(`/index/qianshuicuijiaoAdd?type=cross&&id=${detail.value.id}`)
		})
	}
	onMounted(()=>{
		init()
	})
</script>
<style lang="scss" scoped>
//底部盒子
.tabs_view {
    :deep(.el-tabs__header) {
        background: transparent;
        border: none;
    }
}
</style>