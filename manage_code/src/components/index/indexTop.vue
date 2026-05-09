<template>
	<div class="top-header">
		<div class="header-left">
			<div class="collapse-btn" @click="toggleClick">
				<el-icon :size="20">
					<Fold v-if="!collapse" />
					<Expand v-else />
				</el-icon>
			</div>
			<span class="page-title">{{ projectName }}</span>
		</div>
		<div class="header-right">
			<el-dropdown class="avatar-container" trigger="hover">
				<div class="avatar-wrapper">
					<img class="user-avatar" :src="store.getters['user/avatar']">
					<span class="nickname">{{ showName }}</span>
					<el-icon class="el-icon-arrow-down">
						<arrow-down />
					</el-icon>
				</div>
				<template #dropdown>
					<el-dropdown-menu class="user-dropDown" slot="dropdown">
						<el-dropdown-item class="center" @click="centerClick">
							个人中心
						</el-dropdown-item>
						<el-dropdown-item class="password" @click="updatepasswordClick">
							修改密码
						</el-dropdown-item>
						<el-dropdown-item class="front">
							<span style="display:block;" @click="frontClick">系统前台</span>
						</el-dropdown-item>
						<el-dropdown-item class="loginOut">
							<span style="display:block;" @click="onLogout">退出登录</span>
						</el-dropdown-item>
					</el-dropdown-menu>
				</template>
			</el-dropdown>
		</div>
	</div>
</template>

<script setup>
	import axios from 'axios'
	const moment = window.moment
	import {
		toRefs,
		defineEmits,
		getCurrentInstance,
		ref,
		onBeforeUnmount,
		onMounted,
		computed,
	} from 'vue';
	import {
		useRouter,
		useRoute
	} from 'vue-router';
	const route = useRoute()
	const router = useRouter()
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const baseUrl = ref(context.$config.url)
	const projectName = context.$project.projectName
	const emit = defineEmits(['collapseChange'])
	const role = context.$toolUtil.storageGet('sessionTable')
	const adminName = context.$toolUtil.storageGet('adminName')

	const props = defineProps({
		collapse: Boolean
	})
	const {collapse} = toRefs(props)

	import { useStore } from 'vuex'
	const store = useStore()
	const user = computed(()=>store.getters['user/session'])
	const avatar = ref(store.state.user.avatar)
	const showName = computed(()=>{
		return adminName
	})
	store.dispatch('user/getSession').then(()=>{
		avatar.value = store.state.user.avatar
	})
	const toggleClick = () => {
		emit('collapseChange')
	}
	const onLogout = () => {
		let toolUtil = context?.$toolUtil
		store.dispatch('delAllCachedViews')
		store.dispatch('delAllVisitedViews')
		store.dispatch('user/loginOut')
		toolUtil.storageClear()
		router.replace({
			name: "login"
		});
	}
	const frontClick = () => {
		window.open(`${context.$config.url}client/index.html#/index/home`,'_blank')
	}
	const centerClick = () => {
		router.push(`/${role}Center`)
	}
	const updatepasswordClick = () => {
		router.push(`/updatepassword`)
	}
</script>

<style lang="scss">
.top-header {
	height: 60px;
	background: #fff;
	display: flex;
	align-items: center;
	justify-content: space-between;
	padding: 0 24px;
	box-shadow: 0 1px 4px rgba(0, 0, 0, 0.06);
	flex-shrink: 0;
	z-index: 10;
}

.header-left {
	display: flex;
	align-items: center;
	gap: 16px;
}

.collapse-btn {
	cursor: pointer;
	display: flex;
	align-items: center;
	justify-content: center;
	width: 36px;
	height: 36px;
	border-radius: 8px;
	transition: background 0.2s;
	color: #333;

	&:hover {
		background: #f0f2f5;
	}
}

.page-title {
	font-size: 16px;
	font-weight: 500;
	color: #1a1a1a;
}

.header-right {
	display: flex;
	align-items: center;
}

.top-header .avatar-wrapper {
	display: flex;
	align-items: center;
	gap: 8px;
	cursor: pointer;
	padding: 6px 12px;
	border-radius: 8px;
	transition: background 0.2s;

	&:hover {
		background: #f5f7fa;
	}
}

.top-header img.user-avatar {
	width: 32px;
	height: 32px;
	border-radius: 50%;
	object-fit: cover;
}

.top-header .nickname {
	font-size: 14px;
	color: #333;
}

.top-header .el-dropdown {
	color: inherit;
}

.top-header .el-icon-arrow-down {
	color: #999;
	font-size: 12px;
}
</style>
