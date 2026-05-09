<template>
    <div class="news-page">
        <div class="breadcrumb-wrapper" style="width: 100%;">
            <div class="bread_view">
                <el-breadcrumb separator=":" class="breadcrumb">
                    <el-breadcrumb-item class="first_breadcrumb" :to="{ path: '/' }">首页</el-breadcrumb-item>
                    <el-breadcrumb-item class="second_breadcrumb" v-for="(item,index) in breadList" :key="index">{{item.name}}</el-breadcrumb-item>
                </el-breadcrumb>
            </div>
        </div>

        <div class="list_search">
			<div class="search_view">
				<div class="search_label">
					标题：
				</div>
				<div class="search_box">
					<el-input class="search_inp" v-model="searchQuery.title" placeholder="标题" clearable></el-input>
				</div>
			</div>
			<div class="search_btn_view">
				<el-button class="search_btn" type="primary" @click="searchClick">搜索</el-button>
			</div>
		</div>


<div class="list">

	<template v-for="(item,index) in list">
		<div class="item" @click="newsDetail(item.id)">
			<div class="imgbox"><img :src="item.imgUrls[0]" alt=""></div>
			<div class="content">
				<div class="title text-one-row">{{item.title}}</div>
				<div class="intro text-two-row">{{item.introduction}}</div>
				<div class="time">{{moment(item.addtime).format('YYYY-MM-DD')}}</div>
			</div>
		</div>
	</template>

</div>
		<el-pagination
			background
			:layout="layouts.join(',')"
			:total="total"
			:page-size="listQuery.limit"
            v-model:current-page="listQuery.page"
			prev-text="<"
			next-text=">"
			:hide-on-single-page="true"
			@size-change="sizeChange"
			@current-change="currentChange"/>


    </div>
    <formModel ref="formModelRef"></formModel>
</template>

<script setup>
    const moment = window.moment
	import formModel from './formModel'
	import {
		ref,
		nextTick,
        computed,
		getCurrentInstance
	} from 'vue';
	import {
		useRoute,
		useRouter
	} from 'vue-router'
    import {
        useStore
    } from 'vuex';
    const store = useStore()
    const user = computed(()=>store.getters['user/session'])
	const context = getCurrentInstance()?.appContext.config.globalProperties;
    const baseUrl = ref(context.$config.url)
	//基础信息
	const tableName = 'news'
	const formName = '税务资讯'
	const router = useRouter()
	const route = useRoute()
	//基础信息
    const breadList = ref([{
        name: formName
    }])
	//权限验证
	const btnAuth = (e, a) => {
		return context?.$toolUtil.isAuth(e, a)
	}
	const list = ref([])
	const listLoading = ref(false)
	const listQuery = ref({
		page: 1,
		limit: 10,
		sort: 'addtime',
		order: 'desc'
	})
	const searchQuery = ref({})
	//分页
	const layouts = ref(["total","prev","pager","next","sizes"])
	const total = ref(0)
	const sizeChange = (size) => {
		listQuery.value.limit = size
		getList()
	}
	const currentChange = (page) => {
		listQuery.value.page = page
		getList()
	}
	//分页
	const searchClick = () => {
		listQuery.value.page = 1
		getList()
	}
	const getList = () => {
		listLoading.value = true
		let params = JSON.parse(JSON.stringify(listQuery.value))
		if (searchQuery.value.title && searchQuery.value.title != '') {
			params['title'] = `%${searchQuery.value.title}%`
		}
		context?.$http({
			url: `news/list`,
			method: 'get',
			params: params
		}).then(res => {
			listLoading.value = false
			list.value = res.data.data.list
			total.value = res.data.data.total
            list.value.forEach(item=>{
                let urls = item.picture.split(',')
                item.imgUrls = urls.map(url=>{
                    if(url && url.substr(0,4)=='http'){
                        return url
                    }else{
                        return baseUrl.value+url
                    }
                })
            })
		})
	}
	//判断是否从个人中心跳转
	const centerType = ref(false)
	//返回
	const backClick = () => {
		router.push(`/index/${context?.$toolUtil.storageGet('frontSessionTable')}Center`)
	}
	const init = () => {
		if (route.query.centerType) {
			centerType.value = true
		}
		getList()
        nextTick(()=>{
            if(route.query.id){
                newsDetail(route.query.id)
            }
        })
	}
	//定义弹窗
	const formModelRef = ref(null)
	const newsDetail = (id = null) => {
		if (id) {
			formModelRef.value.init(id)
		}
	}
	init()
</script>
<style lang="scss">
.news-page {
    width: 100%;
    margin: 20px auto;
    padding: 0 7%;
}


.news-page .list_search {
    display: flex;
    align-items: center;
    padding: 10px;
    justify-content: center;
}
.news-page .list_search .search_view {
    display: flex;
    align-items: center;
}
.news-page .search_view .search_label{
    
}
.news-page .search_view .search_box{
    
}
.news-page .search_view .search_box .search_inp{
    
}
.news-page .search_view .search_box .search_inp .el-input__wrapper{
    min-width: 450px;
}
.news-page .search_view .search_box .search_inp .el-input__wrapper .el-input__inner{
    
}
.news-page .list_search .search_btn_view{
    margin: 0 0 0 10px;
}
.news-page .list_search .search_btn_view .search_btn{
    width: auto;
    height: 44px;
    line-height: 44px;
    background:var(--theme);
    padding: 0 20px;
    border: 0;
    color: #fff;
}


.news-page .categorys {
    display: flex;
    justify-content: center;
    gap: 10px;
    padding: 20px 0;
}
.news-page .category {
    display: inline-block;
    width: auto;
    color: #333;
    line-height: 40px;
    border: 1px solid #eee;
    border-radius: 4px;
    padding: 0px 20px;
    margin: 0 10px 0 0;
}
.news-page .category.active {
    background: var(--theme);
    color: #fff;
    cursor: pointer;
}



.news-page .list {
    width: calc(100% + 20px);   
    display: flex;
    flex-wrap: wrap;
    margin: 20px auto 0 -10px;
}
.news-page .list .item {
    width: calc(50% - 20px);
    background: #fff;
    display: flex;
    flex-wrap: wrap;
    margin: 0 10px 20px;
    padding: 10px;
    border-radius: 4px;
    box-shadow: 4px 2px 8px -3px #999;
    cursor: pointer;
}
.news-page .list .item .imgbox {
    margin-right: 20px;
}
.news-page .list .item .imgbox img {
    width: 275px;
    height: 220px;
    object-fit: cover;
    border-radius: 4px;
}
.news-page .list .item .content {
    width: 100%;
    padding: 10px;
    flex:1;
}
.news-page .list .item .content .title {
    font-size: 16px;
    line-height: 24px;
}
.news-page .list .item .content .intro {
    font-size: 14px;
    color: #666;
    margin: 5px 0 0 0;
}
.news-page .list .item .content .time {
    text-align: right;
    font-size: 14px;
    color: #666;
    line-height: 24px;
    margin: 5px 0 0 0;
}



.news-page .hot-title {
    width: 100%;
    height: 60px;
    line-height: 60px;
    margin: 0 0 20px 0;
    text-align: center;
}
.news-page .hot-title span{
    font-size: 32px;
    padding:0 0 6px;
    border-bottom: 0px solid #b6010c;
}

.news-page .hot-item{
    background: #fff;   
}
.news-page .hot-item img {
    width: 100%;
    height: 250px;
    object-fit: cover;
}

.news-page .hot-item-title {
    font-size: 16px;
    text-align: center;
}

.news-page .hot-item-intro {
    color: #666;
}

.news-page .hot-item-content {
    padding: 4px 10px;
}
.news-page .swiper-button-prev{
   color: var(--theme);
   top:40%;
}
.news-page .swiper-button-next{
   color: var(--theme);
   top:40%;
}

.news-page .el-pagination {
    display: flex;
    justify-content: center;
    padding: 30px;
}

</style>