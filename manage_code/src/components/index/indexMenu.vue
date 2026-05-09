<template>
	<div class="sidebar-menu">
		<el-menu
			:default-openeds="[]"
			:unique-opened="true"
			:default-active="menuIndex"
			:collapse="collapse"
			class="sidebar-el-menu"
			background-color="#1d2b3a"
			text-color="rgba(255,255,255,0.7)"
			active-text-color="#fff"
		>
			<el-menu-item index="/" @click="menuHandler('')">
				<i class="iconfont icon-zhuye2"></i>
				<template #title><span>首页</span></template>
			</el-menu-item>
			<template v-for="(item, index) in menuList.backMenu" :key="item.menu">
				<el-sub-menu :index="item.menu">
					<template #title>
						<i class="iconfont" :class="item.fontClass"></i>
						<span>{{ item.menu }}</span>
					</template>
					<el-menu-item
						v-for="(child, sort) in item.child"
						:key="sort"
						:index="getPath(child.classname || child.tableName, child.menuJump)"
						@click="menuHandler(child.classname || child.tableName, child.menuJump)"
					>{{ child.menu }}</el-menu-item>
				</el-sub-menu>
			</template>
		</el-menu>
	</div>
</template>

<script setup>
	import menu from '@/utils/menu'
	import {
		ref,
		toRefs,
		getCurrentInstance,
		watch
	} from 'vue';
	import { useStore } from 'vuex'
	const store = useStore()
	const context = getCurrentInstance()?.appContext.config.globalProperties;

	const props = defineProps({
		collapse: Boolean
	})
	const { collapse } = toRefs(props)

	const menuList = ref([])
	const role = ref('')

	const init = () => {
		const menus = menu.list()
		if (menus) {
			menuList.value = menus
		}
		role.value = context?.$toolUtil.storageGet('role')
		for (let i = 0; i < menuList.value.length; i++) {
			if (menuList.value[i].roleName == role.value) {
				menuList.value = menuList.value[i];
				break;
			}
		}
	}

	const menuIndex = ref('')
	watch(() => context.$router.currentRoute.value, (value) => {
		menuIndex.value = decodeURIComponent(value.fullPath)
	}, {
		immediate: true
	})

	const getPath = (name, menuJump) => {
		if (name == 'center') {
			return `/${role.value}Center`
		} else if (name == 'storeup') {
			return `/storeup?type=${menuJump}`
		} else if (name == 'exampaper' && menuJump == '12') {
			return '/exampaperlist'
		} else if (name == 'examrecord' && menuJump == '22') {
			return '/examfailrecord'
		} else {
			return `/${name}${menuJump ? '?menuJump=' + menuJump : ''}`
		}
	}

	const menuHandler = (name, menuJump) => {
		let url = getPath(name, menuJump)
		context.$router.push(url)
	}

	init()
</script>

<style lang="scss">
.sidebar-menu {
	flex: 1;
	overflow-y: auto;
	overflow-x: hidden;

	/* 隐藏滚动条 */
	scrollbar-width: none;
	&::-webkit-scrollbar {
		display: none;
	}
}

.sidebar-el-menu {
	border-right: none !important;
	padding: 8px;

	/* 一级菜单项 */
	.el-menu-item {
		height: 44px;
		line-height: 44px;
		border-radius: 8px;
		margin-bottom: 4px;
		padding-left: 16px !important;
		font-size: 14px;

		i.iconfont {
			margin-right: 10px;
			font-size: 18px;
			color: rgba(255, 255, 255, 0.6);
		}

		&:hover {
			background: rgba(255, 255, 255, 0.08) !important;
		}

		&.is-active {
			background: #1a73e8 !important;
			color: #fff !important;

			i.iconfont {
				color: #fff;
			}
		}
	}

	/* 子菜单标题 */
	.el-sub-menu__title {
		height: 44px;
		line-height: 44px;
		border-radius: 8px;
		margin-bottom: 4px;
		padding-left: 16px !important;
		font-size: 14px;

		i.iconfont {
			margin-right: 10px;
			font-size: 18px;
			color: rgba(255, 255, 255, 0.6);
		}

		&:hover {
			background: rgba(255, 255, 255, 0.08) !important;
		}
	}

	/* 子菜单展开后的子项 */
	.el-sub-menu .el-menu {
		background: none !important;

		.el-menu-item {
			height: 40px;
			line-height: 40px;
			padding-left: 46px !important;
			font-size: 13px;
			color: rgba(255, 255, 255, 0.6);
			min-width: auto;

			&:hover {
				color: #fff;
				background: rgba(255, 255, 255, 0.06) !important;
			}

			&.is-active {
				color: #fff;
				background: rgba(26, 115, 232, 0.6) !important;
			}
		}
	}

	/* 折叠状态 */
	&.el-menu--collapse {
		padding: 8px 4px;

		.el-menu-item,
		.el-sub-menu__title {
			padding-left: 0 !important;
			text-align: center;

			i.iconfont {
				margin-right: 0;
			}
		}
	}
}

/* 弹出菜单样式 */
.el-popper.is-light {
	background: #1d2b3a !important;
	border: 1px solid rgba(255, 255, 255, 0.1) !important;
}

.el-menu--popup {
	background: #1d2b3a !important;
	padding: 6px;
	min-width: 160px;

	.el-menu-item {
		height: 38px;
		line-height: 38px;
		color: rgba(255, 255, 255, 0.7) !important;
		border-radius: 6px;
		font-size: 13px;

		&:hover {
			background: rgba(255, 255, 255, 0.08) !important;
			color: #fff !important;
		}

		&.is-active {
			background: rgba(26, 115, 232, 0.6) !important;
			color: #fff !important;
		}
	}
}
</style>
