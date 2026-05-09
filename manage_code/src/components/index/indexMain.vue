<template>
	<div class="layout-container">
		<!-- 左侧侧边栏 -->
		<div class="layout-sidebar" :class="{ 'is-collapse': collapse }">
			<div class="sidebar-logo">
				<h1 class="sidebar-title" v-show="!collapse">智能税务管理</h1>
				<span class="sidebar-title-mini" v-show="collapse">税务</span>
			</div>
			<index-aside :collapse="collapse"></index-aside>
		</div>
		<!-- 右侧内容区 -->
		<div class="layout-main" :class="{ 'main-collapse': collapse }">
			<index-header :collapse="collapse" @collapseChange="collapseChange"></index-header>
			<index-tags></index-tags>
			<div class="layout-content">
				<router-view v-slot="{ Component }">
					<keep-alive>
						<transition name="el-fade-in-linear" mode="out-in">
							<component :is="Component" />
						</transition>
					</keep-alive>
				</router-view>
			</div>
		</div>
	</div>
</template>

<script setup>
	import IndexAside from '@/components/index/indexMenu'
	import IndexHeader from '@/components/index/indexTop'
	import IndexTags from '@/components/index/indexTags'
	import menu from "@/utils/menu";
	import router from '../../router'
	import {
		ref,
		getCurrentInstance
	} from 'vue'
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const menuList = ref(null)
	const role = ref('')
	const collapse = ref(false)

	const collapseChange = () => {
		collapse.value = !collapse.value
	}

	const init = () => {
		const menus = menu.list()
		if (menus) {
			menuList.value = menus
		}
		role.value = context?.$toolUtil.storageGet('role')
		for (let i = 0; i < menuList.value.length; i++) {
			if (menuList.value[i].roleName == role.value) {
				menuList.value = menuList.value[i].backMenu;
				break;
			}
		}
		let arr = makeMenu(menuList.value)

		router.addRoute(arr)
	}
	const makeMenu = (menu) => {
		let brr = {
			path: '/1',
			component: () => import('../../views/index'),
			children: []
		}
		for (let x in menu) {
			for (let i in menu[x].child) {
				brr.children.push({
					path: '/' + menu[x].child[i].tableName,
					name: menu[x].child[i].menu,
					component: () => import(`../../views/${menu[x].child[i].tableName}/list.vue`)
				})
			}
		}
		return brr
	}
	// init()
</script>
<style lang="scss" scoped>
	.index_transition{
		transition:all .35s;
	}
</style>
<style lang="scss">
.layout-container {
	display: flex;
	height: 100vh;
	overflow: hidden;
}

.layout-sidebar {
	width: 220px;
	background: #1d2b3a;
	display: flex;
	flex-direction: column;
	transition: width 0.3s ease;
	flex-shrink: 0;
	overflow: hidden;

	&.is-collapse {
		width: 64px;
	}
}

.sidebar-logo {
	height: 60px;
	display: flex;
	align-items: center;
	justify-content: center;
	padding: 0 16px;
	border-bottom: 1px solid rgba(255, 255, 255, 0.08);
}

.sidebar-title {
	color: #fff;
	font-size: 18px;
	font-weight: 600;
	white-space: nowrap;
	margin: 0;
	letter-spacing: 1px;
}

.sidebar-title-mini {
	color: #fff;
	font-size: 16px;
	font-weight: 600;
}

.layout-main {
	flex: 1;
	display: flex;
	flex-direction: column;
	overflow: hidden;
	background: #f5f7fa;
	transition: margin-left 0.3s ease;
}

.layout-content {
	flex: 1;
	overflow-y: auto;
	padding: 0;
}
</style>
