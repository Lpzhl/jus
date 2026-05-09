<template>
    <div class="home_box">



			<!-- 税务资讯 -->
			<div class="newsList_view">
<div class="tableName"><span>税务资讯</span></div>
<div class="list">
        <template v-for="(item,index) in newsList">
            <div v-if="index>0" class="item" @click="newsDetailClick(item)" style="cursor: pointer;">
                <div class="imgbox">
                   <img :src="item.imgUrls[0]" >
                </div>
                <div class="infobox">
                   <div class="title">{{item.title}}</div>
                   <div class="intro text-two-row">{{item.introduction}}</div>
                   <div class="date">{{moment(item.addtime).format('YYYY-MM-DD')}}<span>阅读全文</span></div>
                </div>
            </div>
        </template>
        <div class="more" @click="moreClick('news')" style="cursor: pointer"><span>查看更多</span></div>
</div>

			</div>





    </div>
    <formModel ref="newsFormModelRef"></formModel>
</template>

<script setup>
	import {
		ref,
        computed,
		getCurrentInstance
	} from 'vue';
    const moment = window.moment
	import {
		useRouter
	} from 'vue-router';
    import {
        useStore
    } from 'vuex';
    const store = useStore()
    const user = computed(()=>store.getters['user/session'])
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const router = useRouter()
    const baseUrl = ref(context.$config.url)
	//税务资讯弹窗
	import formModel from './news/formModel'
	const newsFormModelRef = ref(null)
	//税务资讯
	const newsList = ref([])
	const getNewsList = () => {
		context?.$http({
			url: 'news/list',
			method: 'get',
			params:{
				page:1,
				limit: 5,
                sort:'id',
                order:'desc',
			}
		}).then(res=>{
			newsList.value = res.data.data.list
			newsList.value.forEach(item=>{
                let urls = item.picture.split(',')
                item.imgUrls = urls.map(url=>{
                    if(isHttp(url)){
                        return url
                    }else{
                        return baseUrl.value+url
                    }
                })
			})
		})
	}
	const newsDetailClick = (item) => {
		if (item && item.id){
			newsFormModelRef.value.init(item.id)
		}
	}
	//判断图片链接是否带http
	const isHttp = (str) => {
        return str && str.substr(0,4)=='http';
    }
	//跳转详情
	const detailClick = (table,id) => {
		router.push(`/index/${table}Detail?id=${id}`)
	}
	const moreClick = (table) => {
		router.push(`/index/${table}List`)
	}
	const init = () => {
		//税务资讯
		getNewsList()
	}
	init()
</script>

<style lang="scss">
.home_box {
    width: 100%;
    margin: 0 auto;
    padding: 0;
}
.newsList_view {
    width: 100%;
    margin: 0 auto;
    padding:30px 10% 20px;
    position: relative;
    background: var(--theme30)
}
.newsList_view .tableName {
    text-align: center;
    font-size: 32px;
    letter-spacing: 1px;
}
.newsList_view .tableName span{
    padding:0 0 6px;
    border-bottom: 0px solid #b6010c;
}

.newsList_view .list {
    width: 100%;
    margin-top: 30px;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
}

.newsList_view .item {
    width: calc(50% - 10px);  
    background:#fff;
    padding:10px;
    margin:0 0 20px 0;
    border-radius: 4px;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;  
}
.newsList_view .item .imgbox {
    margin: 0 20px 0 0;
}
.newsList_view .item .imgbox img{
    width: 275px;
    height: 220px;
    object-fit: cover;
    border-radius: 4px;
}
.newsList_view .item .infobox {
    flex:1;
    position: relative;
}
.newsList_view .item .infobox .title {
    width: 100%;
    font-size: 16px;
    color: #000;
    font-weight: 600;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
}
.newsList_view .item .infobox .intro{
    margin-top:5px;
    font-size: 14px;
    color: #999;
    line-height: 24px;
    padding-right: 10px;
}
.newsList_view .item .infobox .date {
    width: 100%;
    margin-top:5px;
    text-align: left;
    color: #999;
    position: absolute;
    bottom: 0;
}
.newsList_view .item .infobox .date span{
    display: block;
    float: right;
    color: #b54043;
    padding-right: 10px;
}
.newsList_view .el-carousel {
    height: 100%;
}
.newsList_view .el-carousel__container {
    height: 100%;
}

.newsList_view .more {
    width: 100%;
    text-align: center;
}
.newsList_view .more span{
    color: #333;
    font-size: 15px;
    font-weight: 600;
}
</style>