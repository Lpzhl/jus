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
					<div class="info_label">上传时间</div>

					<div  class="info_text" >{{detail.shangchuanshijian}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">企业名称</div>

					<div  class="info_text" >{{detail.qiyemingcheng}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">税务合同</div>
					<div class="info_text">
						<el-button class="info_down" v-if="detail.shuiwuhetong" @click="downClick(detail.shuiwuhetong)">点击下载</el-button>
						<el-button class="info_undown" v-else>暂无</el-button>
					</div>
				</div>
				<div class="info_item">
					<div class="info_label">附件凭证</div>
					<div class="info_text">
						<el-button class="info_down" v-if="detail.fujianpingzheng" @click="downClick(detail.fujianpingzheng)">点击下载</el-button>
						<el-button class="info_undown" v-else>暂无</el-button>
					</div>
				</div>
				<div class="info_item" v-if="centerType">
					<div class="info_label">是否审核</div>
					<div class="info_text">{{detail.sfsh}}</div>
				</div>
				<div class="info_item" v-if="centerType">
					<div class="info_label">回复内容</div>
					<div class="info_text">{{detail.shhf}}</div>
				</div>
				<div class="btn_view">
					<el-button class="cross_btn" v-if="btnFrontAuth('ziliaoshangchuan','归档')" @click="ziliaoguidangonAcross('归档','是','','[1]','请勿重复操作')" type="warning">归档</el-button>
					<el-button class="approval_btn" v-if="btnAuth('ziliaoshangchuan','审核')&&detail.sfsh=='待审核'" type="warning" @click="approvalClick()">审核</el-button>
					<el-button class="edit_btn" v-if="centerType&&btnAuth('ziliaoshangchuan','修改')" type="primary" @click="editClick">修改</el-button>
					<el-button class="del_btn" v-if="centerType&&btnAuth('ziliaoshangchuan','删除')" type="danger" @click="delClick">删除</el-button>
				</div>
			</div>
		</div>
		<Approval ref="approvalRef" @approvalSave="approvalSave" :tableName="tableName"></Approval>
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
	const tableName = 'ziliaoshangchuan'
	const formName = '资料上传'
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
	const getDetail = () => {
		context?.$http({
			url: `${tableName}/detail/${route.query.id}`,
			method: 'get'
		}).then(res => {
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
	//审核
	import Approval from '@/components/approval.vue'
	const approvalRef = ref(null)
	const approvalClick = (btnType='审核') => {
		if(!context?.$toolUtil.storageGet('frontToken')){
			context?.$toolUtil.message('请登录后再操作！','error')
			return false
		}
		if(!btnAuth('ziliaoshangchuan',btnType)){
			context?.$toolUtil.message('暂无权限操作！','error')
			return false
		}
		let row = detail.value
		nextTick(() => {
			approvalRef.value.approvalClick(row)
		})
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
	const ziliaoguidangonAcross = async (btnType,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue,type=1) => {
		if(!context?.$toolUtil.storageGet('frontToken')){
			context?.$toolUtil.message('请登录后再操作！','error')
			return false
		}
		if(!btnAuth('ziliaoshangchuan',btnType)){
			context?.$toolUtil.message('暂无权限操作！','error')
			return false
		}
		if(crossOptAudit=='是'&&detail.value.sfsh!='是') {
			context?.$toolUtil.message('请审核通过后再操作！','error')
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
			router.push(`/index/ziliaoguidangAdd?type=cross&&id=${detail.value.id}`)
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