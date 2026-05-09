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
				<el-button class="add_btn" v-if="btnAuth('shuikuanjiaona','新增')" @click="addClick">新增</el-button>
			</div>
            <div class="chartBtn-row">
                <el-button class="chart_btn" type="warning" @click="echartClick1" v-if="btnAuth('shuikuanjiaona','缴款状态')">
                    缴款状态
                </el-button>
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
						<el-table-column label="完税凭证" :resizable='true' align="center" header-align="center">
							<template #default="scope">
								<el-button v-if="scope.row.wanshuipingzheng" type="text" size="small" @click.stop="download(scope.row.wanshuipingzheng)">下载</el-button>
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
						<el-table-column label="是否支付" :resizable='true' align="center" header-align="center">
							<template #default="scope">
								<span style="margin-right:10px">{{scope.row.ispay=='已支付'?'已支付':'未支付'}}</span>
								<el-button v-if="scope.row.ispay!='已支付'  && btnAuth('shuikuanjiaona','支付')" type="text" size="small" @click.stop="payClick(scope.row)">支付</el-button>
							</template>
						</el-table-column>
						<el-table-column label="总费用" :resizable='true' align="center" header-align="center">
							<template #default="scope">
								{{scope.row.zongfeiyong}}
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

    <payForm ref="payRef" @paySave="paySave"></payForm>
    <el-dialog v-model="preViewVisible" :title="'查看大图'" width="40%" destroy-on-close>
        <div style="text-align:center">
            <img :src="preViewUrl" style="max-width: 100%;" alt="">
        </div>
    </el-dialog>
    <!-- 统计图弹窗 -->
    <el-dialog v-model="echartVisible" modal-class="chart-dialog-modal" class="chart-dialog" title="统计图" width="70%">
        <div  class="chart-wrapper">
            <div class="chart" id="ispayEchart1" style="width:100%;height:600px;"></div>
        </div>
        <template #footer>
            <span class="formModel_btn_box">
                <el-button class="cancel_btn" @click="echartVisible=false">关闭</el-button>
            </span>
        </template>
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
	const tableName = 'shuikuanjiaona'
	const formName = '税款缴纳'
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
		router.push('/index/shuikuanjiaonaAdd')
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
    const paySave = async(data)=>{
        data.ispay = '已支付'
        context?.$http({
            url: `${tableName}/update`,
            method: 'post',
            data: data
        }).then(res => {
            context.$message.success('支付成功')
            payRef.value.payVisible = false
            getList()
        })
    }
	//普通支付
	import payForm from '@/components/payForm'
	const payRef = ref(null)
	const payClick = (row)=>{
		payRef.value.payClick(tableName,row)
	}
    import '@/assets/js/echarts-theme'
	//判断是否有统计图筛选权限
	const changeStatQuery = (arr)=>{
		if(!arr){
			return true
		}
		let role = localStorage.getItem('frontRole')
		for(let x in arr){
			if(arr[x] == role) {
				return true
			}
		}
		return false
	}
	// 统计图1
	const echartVisible = ref(false)
	const echartClick1 = ()=>{
		if(!route.path.endsWith('Analysis')){
			echartVisible.value = true
		}
		nextTick(async ()=>{
			let dom = document.getElementById("ispayEchart1")
			if(!dom)return
			var ispayEchart1 = echarts.init(dom,'theme');
			let params = {}
			context.$http({
				url: `${tableName}/group/ispay?order=desc`,
				method: 'get',
				params
			}).then(res=>{
				let obj = res.data.data
				let xAxis = [];
				let yAxis = [];
				let dataList = []
				for(let i=0;i<obj.length;i++){
				    xAxis.push(obj[i].ispay);
				    yAxis.push(parseFloat((obj[i].total)));
                    dataList.push({
				        value: parseFloat((obj[i].total)),
				        name: obj[i].ispay				    })
				}
				var option = {};
				option = {
    title:{
        show:false,
        text: '缴款状态',
        left: 'center'
    },
    legend: {
        orient: 'horizontal',
        type: 'scroll', // 启用滚动条
        left: 'center',
        padding:[20,0,0,0]
    },
    tooltip: {
        trigger: 'item',
        formatter: '{b} : {c} ({d}%)'
    },
    series: [
        {
            left: '10%',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: dataList.slice(0,12), 
            emphasis: {
                itemStyle: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
}
                option.series[0].radius = ['25%', '55%']
				// 使用刚指定的配置项和数据显示图表。
				ispayEchart1.setOption(option);
				  //根据窗口的大小变动图表
				window.onresize = function() {
				    ispayEchart1.resize();
				};
			})
		})
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
.condition-box {
    display: flex;
    gap: 10px;
    justify-content: center;
}
.condition-box>* {
    max-width: 300px;
}
</style>