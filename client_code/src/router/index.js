import { createRouter, createWebHashHistory } from 'vue-router'
import index from '../views'
import home from '../views/pages/home.vue'

const routes = [{
		path: '/',
		redirect: '/index/home'
	},
	{
		path: '/index',
		component: index,
		children: [{
			path: 'home',
			component: home
		}
		, {
			path: 'newsList',
			component: ()=>import('@/views/pages/news/list')
		}
		, {
			path: 'chathelperList',
			component: ()=>import('@/views/pages/chathelper/list')
		}, {
			path: 'chathelperDetail',
			component: ()=>import('@/views/pages/chathelper/formModel')
		}, {
			path: 'chathelperAdd',
			component: ()=>import('@/views/pages/chathelper/formAdd')
		}
		, {
			path: 'syslogList',
			component: ()=>import('@/views/pages/syslog/list')
		}, {
			path: 'syslogDetail',
			component: ()=>import('@/views/pages/syslog/formModel')
		}, {
			path: 'syslogAdd',
			component: ()=>import('@/views/pages/syslog/formAdd')
		}
		, {
			path: 'systemNoticeList',
			component: ()=>import('@/views/pages/systemNotice/list')
		}, {
			path: 'systemNoticeDetail',
			component: ()=>import('@/views/pages/systemNotice/formModel')
		}, {
			path: 'systemNoticeAdd',
			component: ()=>import('@/views/pages/systemNotice/formAdd')
		}
		, {
			path: 'qiyeList',
			component: ()=>import('@/views/pages/qiye/list')
		}, {
			path: 'qiyeDetail',
			component: ()=>import('@/views/pages/qiye/formModel')
		}, {
			path: 'qiyeAdd',
			component: ()=>import('@/views/pages/qiye/formAdd')
		}
		, {
			path: 'qiyeCenter',
			component: ()=>import('@/views/pages/qiye/center')
		}
		, {
			path: 'xingyeleixingList',
			component: ()=>import('@/views/pages/xingyeleixing/list')
		}, {
			path: 'xingyeleixingDetail',
			component: ()=>import('@/views/pages/xingyeleixing/formModel')
		}, {
			path: 'xingyeleixingAdd',
			component: ()=>import('@/views/pages/xingyeleixing/formAdd')
		}
		, {
			path: 'jichushujuList',
			component: ()=>import('@/views/pages/jichushuju/list')
		}, {
			path: 'jichushujuDetail',
			component: ()=>import('@/views/pages/jichushuju/formModel')
		}, {
			path: 'jichushujuAdd',
			component: ()=>import('@/views/pages/jichushuju/formAdd')
		}
		, {
			path: 'shuikuanjiaonaList',
			component: ()=>import('@/views/pages/shuikuanjiaona/list')
		}, {
			path: 'shuikuanjiaonaDetail',
			component: ()=>import('@/views/pages/shuikuanjiaona/formModel')
		}, {
			path: 'shuikuanjiaonaAdd',
			component: ()=>import('@/views/pages/shuikuanjiaona/formAdd')
		}
		, {
			path: 'qianshuicuijiaoList',
			component: ()=>import('@/views/pages/qianshuicuijiao/list')
		}, {
			path: 'qianshuicuijiaoDetail',
			component: ()=>import('@/views/pages/qianshuicuijiao/formModel')
		}, {
			path: 'qianshuicuijiaoAdd',
			component: ()=>import('@/views/pages/qianshuicuijiao/formAdd')
		}
		, {
			path: 'fapiaoleixingList',
			component: ()=>import('@/views/pages/fapiaoleixing/list')
		}, {
			path: 'fapiaoleixingDetail',
			component: ()=>import('@/views/pages/fapiaoleixing/formModel')
		}, {
			path: 'fapiaoleixingAdd',
			component: ()=>import('@/views/pages/fapiaoleixing/formAdd')
		}
		, {
			path: 'ziliaoshangchuanList',
			component: ()=>import('@/views/pages/ziliaoshangchuan/list')
		}, {
			path: 'ziliaoshangchuanDetail',
			component: ()=>import('@/views/pages/ziliaoshangchuan/formModel')
		}, {
			path: 'ziliaoshangchuanAdd',
			component: ()=>import('@/views/pages/ziliaoshangchuan/formAdd')
		}
		, {
			path: 'ziliaoguidangList',
			component: ()=>import('@/views/pages/ziliaoguidang/list')
		}, {
			path: 'ziliaoguidangDetail',
			component: ()=>import('@/views/pages/ziliaoguidang/formModel')
		}, {
			path: 'ziliaoguidangAdd',
			component: ()=>import('@/views/pages/ziliaoguidang/formAdd')
		}
		, {
			path: 'shenbaohuizhiList',
			component: ()=>import('@/views/pages/shenbaohuizhi/list')
		}, {
			path: 'shenbaohuizhiDetail',
			component: ()=>import('@/views/pages/shenbaohuizhi/formModel')
		}, {
			path: 'shenbaohuizhiAdd',
			component: ()=>import('@/views/pages/shenbaohuizhi/formAdd')
		}
		, {
			path: 'shenbaocaozuoList',
			component: ()=>import('@/views/pages/shenbaocaozuo/list')
		}, {
			path: 'shenbaocaozuoDetail',
			component: ()=>import('@/views/pages/shenbaocaozuo/formModel')
		}, {
			path: 'shenbaocaozuoAdd',
			component: ()=>import('@/views/pages/shenbaocaozuo/formAdd')
		}
		, {
			path: 'qiyexiangqingList',
			component: ()=>import('@/views/pages/qiyexiangqing/list')
		}, {
			path: 'qiyexiangqingDetail',
			component: ()=>import('@/views/pages/qiyexiangqing/formModel')
		}, {
			path: 'qiyexiangqingAdd',
			component: ()=>import('@/views/pages/qiyexiangqing/formAdd')
		}
		, {
			path: 'shuiwuhuizongfenxiList',
			component: ()=>import('@/views/pages/shuiwuhuizongfenxi/list')
		}, {
			path: 'shuiwuhuizongfenxiDetail',
			component: ()=>import('@/views/pages/shuiwuhuizongfenxi/formModel')
		}, {
			path: 'shuiwuhuizongfenxiAdd',
			component: ()=>import('@/views/pages/shuiwuhuizongfenxi/formAdd')
		}
		, {
			path: 'fapiaokaijuList',
			component: ()=>import('@/views/pages/fapiaokaiju/list')
		}, {
			path: 'fapiaokaijuDetail',
			component: ()=>import('@/views/pages/fapiaokaiju/formModel')
		}, {
			path: 'fapiaokaijuAdd',
			component: ()=>import('@/views/pages/fapiaokaiju/formAdd')
		}
		, {
			path: 'fapiaolingyongList',
			component: ()=>import('@/views/pages/fapiaolingyong/list')
		}, {
			path: 'fapiaolingyongDetail',
			component: ()=>import('@/views/pages/fapiaolingyong/formModel')
		}, {
			path: 'fapiaolingyongAdd',
			component: ()=>import('@/views/pages/fapiaolingyong/formAdd')
		}
		, {
			path: 'fapiaozuofeiList',
			component: ()=>import('@/views/pages/fapiaozuofei/list')
		}, {
			path: 'fapiaozuofeiDetail',
			component: ()=>import('@/views/pages/fapiaozuofei/formModel')
		}, {
			path: 'fapiaozuofeiAdd',
			component: ()=>import('@/views/pages/fapiaozuofei/formAdd')
		}
		, {
			path: 'fapiaohexiaoList',
			component: ()=>import('@/views/pages/fapiaohexiao/list')
		}, {
			path: 'fapiaohexiaoDetail',
			component: ()=>import('@/views/pages/fapiaohexiao/formModel')
		}, {
			path: 'fapiaohexiaoAdd',
			component: ()=>import('@/views/pages/fapiaohexiao/formAdd')
		}
		]
	},
	{
		path: '/login',
		component: ()=>import('../views/pages/login.vue')
	}
	,{
		path: '/qiyeRegister',
		component: ()=>import('@/views/pages/qiye/register')
	}
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})
// 全局后置钩子，路由跳转后执行
router.afterEach(() => {
    // 滚动到顶部
    window.scrollTo(0, 0)
})

export default router
