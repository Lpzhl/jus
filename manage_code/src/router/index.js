import {
	createRouter,
	createWebHashHistory
} from 'vue-router'
import login from '@/views/login.vue'
import index from '@/views/index.vue'
import HomeView from '@/views/HomeView.vue'
export const routes = [{
		path: '/login',
		name: 'login',
        meta: { title: '登录' },
		component: login
	},{
		path: '/',
		name: '首页',
        meta: { title: '首页' },
		component: index,
		children: [{
			path: '/',
			name: 'home',
			component: HomeView,
			meta: {
				affix: true,
                title: '首页'
			}
		}, {
			path: '/updatepassword',
			name: 'updatepassword',
            meta: { title: '修改密码' },
			component: () => import('../views/updatepassword.vue')
		}

		,{
			path: '/usersCenter',
			name: 'usersCenter',
            meta: { title: '管理员个人中心' },
			component: ()=>import('@/views/users/center')
		}
		,{
			path: '/news',
			name: 'news',
            meta: { title: '税务资讯' },
			component: ()=>import('@/views/news/list')
		}
		,{
			path: '/fapiaozuofei',
			name: 'fapiaozuofei',
            meta: { title: '发票作废' },
			component: ()=>import('@/views/fapiaozuofei/list')
		}
		,{
			path: '/fapiaoleixing',
			name: 'fapiaoleixing',
            meta: { title: '发票类型' },
			component: ()=>import('@/views/fapiaoleixing/list')
		}
		,{
			path: '/shuiwuhuizongfenxi',
			name: 'shuiwuhuizongfenxi',
            meta: { title: '税务汇总分析' },
			component: ()=>import('@/views/shuiwuhuizongfenxi/list')
		}
		,{
			path: '/xingyeleixing',
			name: 'xingyeleixing',
            meta: { title: '行业类型' },
			component: ()=>import('@/views/xingyeleixing/list')
		}
		,{
			path: '/fapiaolingyong',
			name: 'fapiaolingyong',
            meta: { title: '发票领用' },
			component: ()=>import('@/views/fapiaolingyong/list')
		}
		,{
			path: '/shuikuanjiaona',
			name: 'shuikuanjiaona',
            meta: { title: '税款缴纳' },
			component: ()=>import('@/views/shuikuanjiaona/list')
		}
		,{
			path: '/ziliaoshangchuan',
			name: 'ziliaoshangchuan',
            meta: { title: '资料上传' },
			component: ()=>import('@/views/ziliaoshangchuan/list')
		}
		,{
			path: '/fapiaokaiju',
			name: 'fapiaokaiju',
            meta: { title: '发票开具' },
			component: ()=>import('@/views/fapiaokaiju/list')
		}
		,{
			path: '/syslog',
			name: 'syslog',
            meta: { title: '操作日志' },
			component: ()=>import('@/views/syslog/list')
		}
        ,{
            path: '/menu',
            name: 'menu',
            meta: { title: '菜单权限管理' },
            component: ()=>import('@/views/menu_manage/list')
        }
		,{
			path: '/users',
			name: 'users',
            meta: { title: '管理员' },
			component: ()=>import('@/views/users/list')
		}
		,{
			path: '/ziliaoguidang',
			name: 'ziliaoguidang',
            meta: { title: '资料归档' },
			component: ()=>import('@/views/ziliaoguidang/list')
		}
		,{
			path: '/qiyexiangqing',
			name: 'qiyexiangqing',
            meta: { title: '企业详情' },
			component: ()=>import('@/views/qiyexiangqing/list')
		}
		,{
			path: '/qiye',
			name: 'qiye',
            meta: { title: '企业' },
			component: ()=>import('@/views/qiye/list')
		}
		,{
			path: '/shenbaohuizhi',
			name: 'shenbaohuizhi',
            meta: { title: '申报回执' },
			component: ()=>import('@/views/shenbaohuizhi/list')
		}
		,{
			path: '/shenbaocaozuo',
			name: 'shenbaocaozuo',
            meta: { title: '申报操作' },
			component: ()=>import('@/views/shenbaocaozuo/list')
		}
		,{
			path: '/systemNotice',
			name: 'systemNotice',
            meta: { title: '系统公告' },
			component: ()=>import('@/views/systemNotice/list')
		}
		,{
			path: '/jichushuju',
			name: 'jichushuju',
            meta: { title: '基础数据' },
			component: ()=>import('@/views/jichushuju/list')
		}
		,{
			path: '/fapiaohexiao',
			name: 'fapiaohexiao',
            meta: { title: '发票核销' },
			component: ()=>import('@/views/fapiaohexiao/list')
		}
		,{
			path: '/config',
			name: 'config',
            meta: { title: '轮播图' },
			component: ()=>import('@/views/config/list')
		}
		,{
			path: '/qianshuicuijiao',
			name: 'qianshuicuijiao',
            meta: { title: '欠税催缴' },
			component: ()=>import('@/views/qianshuicuijiao/list')
		}
		]
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
