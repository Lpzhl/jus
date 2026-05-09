const config = {
    get() {
        return {
            url : process.env.VUE_APP_BASE_API_URL + process.env.VUE_APP_BASE_API + '/',
            name: process.env.VUE_APP_BASE_API,
			menuList:[
				{
					name: '税务资讯管理',
					icon: '',
					child:[
						{
							name:'税务资讯',
                            url:'/index/newsList'

						},
					]
				},

				{
					name: '基础数据管理',
					icon: '',
					child:[
						{
							name:'基础数据',
                            url:'/index/jichushujuList'

						},
					]
				},

			]
        }
    },
    getProjectName(){
        return {
            projectName: `小企业税务智能管理系统设计与实现`
        } 
    }
}
export default config
