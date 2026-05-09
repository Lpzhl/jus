<template>
    <div class="list-page">
        <div class="breadcrumb-wrapper" style="width: 100%;">
            <div class="bread_view">
                <el-breadcrumb separator=":" class="breadcrumb">
                    <el-breadcrumb-item class="first_breadcrumb" :to="{ path: '/' }">首页</el-breadcrumb-item>
                    <el-breadcrumb-item class="second_breadcrumb" v-for="(item,index) in breadList" :key="index">{{item.name}}</el-breadcrumb-item>
                </el-breadcrumb>
            </div>
            <div class="back_view" v-if="centerType">
                <el-button class="back_btn" @click="backClick">返回</el-button>
            </div>
        </div>
		<div class="list_search">
			<div class="search_view">
				<div class="search_label">
					年份：
				</div>
				<div class="search_box">
					<el-input class="search_inp" v-model="searchQuery.nianfen" placeholder="年份"
						clearable>
					</el-input>
				</div>
			</div>
			<div class="search_view">
				<div class="search_label">
					月份：
				</div>
				<div class="search_box">
					<el-input class="search_inp" v-model="searchQuery.yuefen" placeholder="月份"
						clearable>
					</el-input>
				</div>
			</div>
			<div class="search_btn_view">
				<el-button class="search_btn" @click="searchClick">搜索</el-button>
				<el-button class="add_btn" v-if="btnAuth('qianshuicuijiao','新增')" @click="addClick">新增</el-button>
			</div>
		</div>



                <div class="table_view">
					<el-table v-loading="listLoading" class="data_table" :data="list" border :row-style="{'cursor':'pointer'}"
						@row-click="tableDetailClick" :stripe='false'>
						<el-table-column :resizable='true' align="center" header-align="center" type="selection" width="55" />
						<el-table-column label="序号" width="120" :resizable='true' align="center" header-align="center">
							<template #default="scope">{{ (listQuery.page-1)*listQuery.limit+scope.$index + 1}}</template>
						</el-table-column>
						<el-table-column label="年份" :resizable='true' align="center" header-align="center">
							<template #default="scope">
								{{scope.row.nianfen}}
							</template>
						</el-table-column>
						<el-table-column label="月份" :resizable='true' align="center" header-align="center">
							<template #default="scope">
								{{scope.row.yuefen}}
							</template>
						</el-table-column>
						<el-table-column label="销项发票" :resizable='true' align="center" header-align="center">
							<template #default="scope">
								<div v-if="scope.row.xiaoxiangfapiao">
									<el-image v-if="scope.row.xiaoxiangfapiao.substring(0,4)=='http'" preview-teleported
										:preview-src-list="[scope.row.xiaoxiangfapiao.split(',')[0]]"
										:src="scope.row.xiaoxiangfapiao.split(',')[0]" style="width:100px;height:100px" @click.stop></el-image>
									<el-image v-else preview-teleported
										:preview-src-list="[baseUrl+scope.row.xiaoxiangfapiao.split(',')[0]]"
										:src="baseUrl+scope.row.xiaoxiangfapiao.split(',')[0]" style="width:100px;height:100px" @click.stop>
									</el-image>
								</div>
								<div v-else>无图片</div>
							</template>
						</el-table-column>
						<el-table-column label="进项发票" :resizable='true' align="center" header-align="center">
							<template #default="scope">
								<div v-if="scope.row.jinxiangfapiao">
									<el-image v-if="scope.row.jinxiangfapiao.substring(0,4)=='http'" preview-teleported
										:preview-src-list="[scope.row.jinxiangfapiao.split(',')[0]]"
										:src="scope.row.jinxiangfapiao.split(',')[0]" style="width:100px;height:100px" @click.stop></el-image>
									<el-image v-else preview-teleported
										:preview-src-list="[baseUrl+scope.row.jinxiangfapiao.split(',')[0]]"
										:src="baseUrl+scope.row.jinxiangfapiao.split(',')[0]" style="width:100px;height:100px" @click.stop>
									</el-image>
								</div>
								<div v-else>无图片</div>
							</template>
						</el-table-column>
						<el-table-column label="营收" :resizable='true' align="center" header-align="center">
							<template #default="scope">
								{{scope.row.yingshou}}
							</template>
						</el-table-column>
						<el-table-column label="成本费用" :resizable='true' align="center" header-align="center">
							<template #default="scope">
								{{scope.row.chengbenfeiyong}}
							</template>
						</el-table-column>
						<el-table-column label="申报时间" :resizable='true' align="center" header-align="center">
							<template #default="scope">
								{{scope.row.shenbaoshijian}}
							</template>
						</el-table-column>
						<el-table-column label="申报回执" :resizable='true' align="center" header-align="center">
							<template #default="scope">
								<el-button v-if="scope.row.shenbaohuizhi" type="text" size="small" @click.stop="download(scope.row.shenbaohuizhi)">下载</el-button>
								<el-button v-else disabled type="text" size="small">无</el-button>
							</template>
						</el-table-column>
						<el-table-column label="企业名称" :resizable='true' align="center" header-align="center">
							<template #default="scope">
								{{scope.row.qiyemingcheng}}
							</template>
						</el-table-column>
						<el-table-column label="税款金额" :resizable='true' align="center" header-align="center">
							<template #default="scope">
								{{scope.row.shuikuanjine}}
							</template>
						</el-table-column>
						<el-table-column label="催缴时间" :resizable='true' align="center" header-align="center">
							<template #default="scope">
								{{scope.row.cuijiaoshijian}}
							</template>
						</el-table-column>
					</el-table>
                </div>

				<el-pagination
					background
					:layout="layouts.join(',')"
					:total="total"
					:page-size="listQuery.limit"
                    v-model:current-page="listQuery.page"
					prev-text="上一页"
					next-text="下一页"
					:hide-on-single-page="false"
					@size-change="sizeChange"
					@current-change="currentChange"/>


    </div>

    <el-dialog v-model="preViewVisible" :title="'查看大图'" width="40%" destroy-on-close>
        <div style="text-align:center">
            <img :src="preViewUrl" style="max-width: 100%;" alt="">
        </div>
    </el-dialog>
</template>

<script setup>
	import {
		ref,
		getCurrentInstance,
		nextTick,
        computed,
        inject,
	} from 'vue';
    const moment = window.moment
	import {
		useRoute,
		useRouter
	} from 'vue-router';
    import {
        useStore
    } from 'vuex';
    const store = useStore()
    const user = computed(()=>store.getters['user/session'])
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const router = useRouter()
	const route = useRoute()
    const baseUrl = ref(context.$config.url)
	//基础信息
	const tableName = 'qianshuicuijiao'
	const formName = '欠税催缴'
	//基础信息
	const breadList = ref([{
		name: formName
	}])
	const list = ref([])
	const listQuery = ref({
		page: 1,
		limit: 20,
	})
	const total = ref(0)
	const listLoading = ref(false)
	//权限验证
	const btnAuth = (e,a)=>{
		if(centerType.value){
			return context?.$toolUtil.isBackAuth(e,a)
		}else{
			return context?.$toolUtil.isAuth(e,a)
		}
	}
	const addClick = () => {
		router.push('/index/qianshuicuijiaoAdd')
	}
	//判断是否从个人中心跳转
	const centerType = ref(false)
	//返回
	const backClick = () => {
		router.push(`/index/${context?.$toolUtil.storageGet('frontSessionTable')}Center`)
	}
	//搜索
	const searchQuery = ref({})
	//下拉列表
	const searchClick = async() => {
		listQuery.value.page = 1
		getList()
	}
	//分页
	const layouts = ref(["total","prev","pager","next","sizes"])
	const sizeChange = (size) => {
		listQuery.value.limit = size
		getList()
	}
	const currentChange = (page) => {
		listQuery.value.page = page
		getList()
	}
	//分页
	//列表
	const getList = (obj) => {
		listLoading.value = true
		let params = JSON.parse(JSON.stringify(listQuery.value))
		if(searchQuery.value.nianfen&&searchQuery.value.nianfen!=''){
			params.nianfen = '%' + searchQuery.value.nianfen + '%'
		}
		if(searchQuery.value.yuefen&&searchQuery.value.yuefen!=''){
			params.yuefen = '%' + searchQuery.value.yuefen + '%'
		}
		context?.$http({
			url: `${tableName}/${centerType.value?'page':'list'}`,
			method: 'get',
			params: params
		}).then(res => {
			listLoading.value = false
			list.value = res.data.data.list
			total.value = Number(res.data.data.total)
		})
	}
	const tableDetailClick = (row) => {
		router.push(`${tableName}Detail?id=` + row.id + (centerType.value?'&&centerType=1':''))
	}
	//下载文件
	const download = (file) =>{
		if(!file){
			context?.$toolUtil.message('文件不存在','error')
		}
		const a = document.createElement('a');
		a.style.display = 'none';
		a.setAttribute('target', '_blank');
		file && a.setAttribute('download', file);
		a.href = context?.$config.url + file;
		document.body.appendChild(a);
		a.click();
		document.body.removeChild(a);
	}
	// 查看大图
	const preViewUrl = ref('')
	const preViewVisible = ref(false)
	const preViewClick = (url) =>{
		preViewUrl.value = url
		preViewVisible.value = true
	}
	const init = async() => {
		if(route.query.centerType){
			centerType.value = true
		}
        if(context.$toolUtil.storageGet('frontToken') && !user.value.id){
            await store.dispatch("user/getSession")
        }
		getList()
	}
	init()
</script>
<style lang="scss" scoped>
</style>