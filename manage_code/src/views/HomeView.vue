<template>
	<div class="home_view">
		<!-- 统计卡片区域 -->
		<div class="stat-cards">
			<div class="stat-card stat-card--blue" v-if="btnAuth('qiye','首页总数')">
				<div class="stat-card__icon">
					<svg viewBox="0 0 24 24" fill="none"><path d="M3 21h18M3 7v14M21 7v14M6 11h4M6 15h4M14 11h4M14 15h4M10 21V17h4v4M12 3l9 4H3l9-4z" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/></svg>
				</div>
				<div class="stat-card__info">
					<span class="stat-card__label">企业总数</span>
					<span class="stat-card__value"><countTo :startVal="0" :endVal="qiyeCount" :duration="1000"></countTo></span>
				</div>
			</div>
			<div class="stat-card stat-card--green" v-if="btnAuth('jichushuju','首页总数')">
				<div class="stat-card__icon">
					<svg viewBox="0 0 24 24" fill="none"><path d="M4 7v10c0 2.21 3.58 4 8 4s8-1.79 8-4V7M4 7c0 2.21 3.58 4 8 4s8-1.79 8-4M4 7c0-2.21 3.58-4 8-4s8 1.79 8 4M4 12c0 2.21 3.58 4 8 4s8-1.79 8-4" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/></svg>
				</div>
				<div class="stat-card__info">
					<span class="stat-card__label">基础数据</span>
					<span class="stat-card__value"><countTo :startVal="0" :endVal="jichushujuCount" :duration="1000"></countTo></span>
				</div>
			</div>
			<div class="stat-card stat-card--orange" v-if="btnAuth('shuikuanjiaona','首页总数')">
				<div class="stat-card__icon">
					<svg viewBox="0 0 24 24" fill="none"><path d="M12 2v20M17 5H9.5a3.5 3.5 0 000 7h5a3.5 3.5 0 010 7H6" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/></svg>
				</div>
				<div class="stat-card__info">
					<span class="stat-card__label">税款缴纳</span>
					<span class="stat-card__value"><countTo :startVal="0" :endVal="shuikuanjiaonaCount" :duration="1000"></countTo></span>
				</div>
			</div>
			<div class="stat-card stat-card--purple" v-if="btnAuth('fapiaoleixing','首页总数')">
				<div class="stat-card__icon">
					<svg viewBox="0 0 24 24" fill="none"><path d="M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2M9 5a2 2 0 012-2h2a2 2 0 012 2M9 14l2 2 4-4" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/></svg>
				</div>
				<div class="stat-card__info">
					<span class="stat-card__label">发票类型</span>
					<span class="stat-card__value"><countTo :startVal="0" :endVal="fapiaoleixingCount" :duration="1000"></countTo></span>
				</div>
			</div>
			<div class="stat-card stat-card--cyan" v-if="btnAuth('fapiaokaiju','首页总数')">
				<div class="stat-card__icon">
					<svg viewBox="0 0 24 24" fill="none"><path d="M14 2H6a2 2 0 00-2 2v16a2 2 0 002 2h12a2 2 0 002-2V8l-6-6zM14 2v6h6M16 13H8M16 17H8M10 9H8" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/></svg>
				</div>
				<div class="stat-card__info">
					<span class="stat-card__label">发票开具</span>
					<span class="stat-card__value"><countTo :startVal="0" :endVal="fapiaokaijuCount" :duration="1000"></countTo></span>
				</div>
			</div>
			<div class="stat-card stat-card--pink" v-if="btnAuth('fapiaolingyong','首页总数')">
				<div class="stat-card__icon">
					<svg viewBox="0 0 24 24" fill="none"><path d="M16 4h2a2 2 0 012 2v14a2 2 0 01-2 2H6a2 2 0 01-2-2V6a2 2 0 012-2h2M8 2h8v4H8V2zM12 11v6M9 14h6" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/></svg>
				</div>
				<div class="stat-card__info">
					<span class="stat-card__label">发票领用</span>
					<span class="stat-card__value"><countTo :startVal="0" :endVal="fapiaolingyongCount" :duration="1000"></countTo></span>
				</div>
			</div>
		</div>

		<!-- 税务资讯区域 -->
		<div class="dashboard-section">
			<div class="section-card news-card">
				<div class="section-header">
					<h3 class="section-title">税务资讯</h3>
				</div>
				<div class="news-list">
					<div class="news-item" v-for="(item, index) in newsList" :key="index" @click="newsDetailClick(item)">
						<img class="news-img" :src="item.imgUrl" />
						<div class="news-content">
							<div class="news-title">{{ item.title }}</div>
							<div class="news-desc">{{ item.introduction }}</div>
							<div class="news-time">{{ moment(item.addtime).format('YYYY-MM-DD') }}</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<el-dialog v-model="newsDialog.visible" title="税务资讯" :append-to-body="true" width="60%" class="home_newsDialog">
			<div class="newsTitle" style="text-align: center;font-size: 20px;padding: 0 0 20px;color:#000;font-weight: bold;">{{newsDialog.detail.title}}</div>
			<div class="newImg" v-if="newsDialog.detail.picture">
				<img :src="newsDialog.detail.imgUrl" style="width:100%;height: 100%;object-fit: cover;max-height: 200px;"/>
			</div>
			<div class="newContent">
				<span v-html="newsDialog.detail.content"></span>
			</div>
		</el-dialog>
		<!-- 图表区域 -->
		<div class="chart-grid">
			<div class="chart-card" v-if="btnAuth('qiye','首页统计')">
				<div class="chart-card__header">行业类型分布</div>
				<div id="qiyexingyeleixingEchart1" class="chart-canvas"></div>
			</div>
			<div class="chart-card" v-if="btnAuth('jichushuju','首页统计')">
				<div class="chart-card__header">税务变化趋势</div>
				<div id="jichushujunianfenEchart1" class="chart-canvas"></div>
			</div>
			<div class="chart-card" v-if="btnAuth('jichushuju','首页统计')">
				<div class="chart-card__header">申报进度</div>
				<div id="jichushujushenbaojinduEchart2" class="chart-canvas"></div>
			</div>
			<div class="chart-card" v-if="btnAuth('shuikuanjiaona','首页统计')">
				<div class="chart-card__header">缴款状态</div>
				<div id="shuikuanjiaonaispayEchart1" class="chart-canvas"></div>
			</div>
			<div class="chart-card" v-if="btnAuth('fapiaoleixing','首页统计')">
				<div class="chart-card__header">发票类型统计</div>
				<div id="fapiaoleixingfapiaoleixingEchart1" class="chart-canvas"></div>
			</div>
			<div class="chart-card" v-if="btnAuth('fapiaokaiju','首页统计')">
				<div class="chart-card__header">发票开具统计</div>
				<div id="fapiaokaijufapiaoleixingEchart1" class="chart-canvas"></div>
			</div>
			<div class="chart-card" v-if="btnAuth('fapiaolingyong','首页统计')">
				<div class="chart-card__header">发票领用统计</div>
				<div id="fapiaolingyongfapiaoleixingEchart1" class="chart-canvas"></div>
			</div>
		</div>
	</div>
</template>

<script setup>
	import {
		inject,
		nextTick,
		ref,
		getCurrentInstance,
		computed,
		onMounted,
	} from 'vue';
	import {
		useStore
	} from 'vuex';
	const moment = window.moment
	const store = useStore()
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const projectName = context.$project.projectName
	const user = computed(()=>store.getters['user/session'])
	//权限验证
	const btnAuth = (e,a)=>{
		return context?.$toolUtil.isAuth(e,a)
	}
	const newsList = ref([])
	const newsDialog = ref({
		visible:false,
		detail:{}
	})
	const getNewsList = () => {
		context.$http({
			url: 'news/list',
			method: 'get',
			params: {
				page: 1,
				limit: 8,
				sort: 'id',
				order: 'desc',
			}
		}).then(res => {
			newsList.value = res.data.data.list
			newsList.value.forEach(item => {
				item.imgUrl = context.$config.url + item.picture.split(',')[0]
			})
		})
	}
	const newsDetailClick = (item) => {
		newsDialog.value.detail = item
		newsDialog.value.visible = true
	}
	//获取列表数据
	getNewsList()
	import countTo from '@/components/count-to/vue-countTo.vue';
	const countTypeList = ref({
	})
	const getCountList=()=>{
		countTypeList.value.closeqiyeCountType = true
		countTypeList.value.hiddenqiyeCountType = true
		if(btnAuth('qiye','首页总数')){
			getqiyeCount()
		}
		countTypeList.value.closejichushujuCountType = true
		countTypeList.value.hiddenjichushujuCountType = true
		if(btnAuth('jichushuju','首页总数')){
			getjichushujuCount()
		}
		countTypeList.value.closeshuikuanjiaonaCountType = true
		countTypeList.value.hiddenshuikuanjiaonaCountType = true
		if(btnAuth('shuikuanjiaona','首页总数')){
			getshuikuanjiaonaCount()
		}
		countTypeList.value.closefapiaoleixingCountType = true
		countTypeList.value.hiddenfapiaoleixingCountType = true
		if(btnAuth('fapiaoleixing','首页总数')){
			getfapiaoleixingCount()
		}
		countTypeList.value.closefapiaokaijuCountType = true
		countTypeList.value.hiddenfapiaokaijuCountType = true
		if(btnAuth('fapiaokaiju','首页总数')){
			getfapiaokaijuCount()
		}
		countTypeList.value.closefapiaolingyongCountType = true
		countTypeList.value.hiddenfapiaolingyongCountType = true
		if(btnAuth('fapiaolingyong','首页总数')){
			getfapiaolingyongCount()
		}
	}
	const qiyeCount = ref(0)
	const getqiyeCount = () => {
		context?.$http({
			url:'qiye/count',
			method: 'get'
		}).then(res=>{
			qiyeCount.value = res.data.data
		})
	}
	const jichushujuCount = ref(0)
	const getjichushujuCount = () => {
		context?.$http({
			url:'jichushuju/count',
			method: 'get'
		}).then(res=>{
			jichushujuCount.value = res.data.data
		})
	}
	const shuikuanjiaonaCount = ref(0)
	const getshuikuanjiaonaCount = () => {
		context?.$http({
			url:'shuikuanjiaona/count',
			method: 'get'
		}).then(res=>{
			shuikuanjiaonaCount.value = res.data.data
		})
	}
	const fapiaoleixingCount = ref(0)
	const getfapiaoleixingCount = () => {
		context?.$http({
			url:'fapiaoleixing/count',
			method: 'get'
		}).then(res=>{
			fapiaoleixingCount.value = res.data.data
		})
	}
	const fapiaokaijuCount = ref(0)
	const getfapiaokaijuCount = () => {
		context?.$http({
			url:'fapiaokaiju/count',
			method: 'get'
		}).then(res=>{
			fapiaokaijuCount.value = res.data.data
		})
	}
	const fapiaolingyongCount = ref(0)
	const getfapiaolingyongCount = () => {
		context?.$http({
			url:'fapiaolingyong/count',
			method: 'get'
		}).then(res=>{
			fapiaolingyongCount.value = res.data.data
		})
	}
	const countTypeClick = (e) => {
		countTypeList.value[e] = !countTypeList.value[e]
	}
	//获取总数
	getCountList()
	const cardTypeClick = (e) =>{
		cardTypeList.value[e] = !cardTypeList.value[e]
		setTimeout(()=>{
			getChartList()
		},1000)
	}
	const cardTypeList = ref({
		closeqiyeChartType1: true,
		hiddenqiyeChartType1: true,
		closejichushujuChartType1: true,
		hiddenjichushujuChartType1: true,
		closejichushujuChartType2: true,
		hiddenjichushujuChartType2: true,
		closeshuikuanjiaonaChartType1: true,
		hiddenshuikuanjiaonaChartType1: true,
		closefapiaoleixingChartType1: true,
		hiddenfapiaoleixingChartType1: true,
		closefapiaokaijuChartType1: true,
		hiddenfapiaokaijuChartType1: true,
		closefapiaolingyongChartType1: true,
		hiddenfapiaolingyongChartType1: true,
	})
	//判断是否有统计图筛选权限
	const changeStatQuery = (arr)=>{
		if(!arr){	//不传限制条件，默认都可见
			return true
		}
		let role = localStorage.getItem('role')
		for(let x in arr){
			if(arr[x] == role) {
				return true
			}
		}
		return false
	}
	import '@/assets/js/echarts-theme'
	const getqiyeChart1 = () => {
		nextTick(async ()=>{
			var xingyeleixingEchart1 = echarts.init(document.getElementById("qiyexingyeleixingEchart1"),'theme');
			let params = {}
			context?.$http({
				url: "qiye/group/xingyeleixing?order=desc",
				method: "get",
				params
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let dataList = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].xingyeleixing);
				    yAxis.push(parseFloat((res[i].total)));
					dataList.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].xingyeleixing				    })
				}

				var option = {};
				option = {
    title:{
        show:false,
        text: '行业类型',
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
                option.series[0].roseType = 'area'
				xingyeleixingEchart1.clear()
				// 使用刚指定的配置项和数据显示图表。
				xingyeleixingEchart1.setOption(option);
				//根据窗口的大小变动图表
				xingyeleixingEchart1.resize();
			})
		})
	}
	const getjichushujuChart1 = () => {
		nextTick(async ()=>{
			var nianfenEchart1 = echarts.init(document.getElementById("jichushujunianfenEchart1"),'theme');
			let params = {}
			if(params.conditionColumn) {
				params.conditionColumn += ';' + 'sfsh'
				params.conditionValue += ';' + '是'
			}else {
				params.conditionColumn = 'sfsh'
				params.conditionValue = '是'
			}
			context?.$http({
				url: `jichushuju/valueMul/nianfen?yColumnNameMul=yingshou,chengbenfeiyong`,
				method: "get",
				params
			}).then(obj=>{
				let res = obj.data.data
                let xAxis1 = [];
                let yAxis1 = [];
                let pArray1 = []
                for(let i=0;i<res[0].length;i++){
                    xAxis1.push(res[0][i].nianfen);
                    yAxis1.push(parseFloat((res[0][i].total)));
                    pArray1.push({
                        value: parseFloat((res[0][i].total)),
                        name: res[0][i].nianfen
                    })
                }
                let xAxis2 = [];
                let yAxis2 = [];
                let pArray2 = []
                for(let i=0;i<res[1].length;i++){
                    xAxis2.push(res[1][i].nianfen);
                    yAxis2.push(parseFloat((res[1][i].total)));
                    pArray2.push({
                        value: parseFloat((res[1][i].total)),
                        name: res[1][i].nianfen
                    })
                }
				var option = {};
				let series = [
					{
						data: yAxis1,
						type: 'line',
						name: '营收',
					},
					{
						data: yAxis2,
						type: 'line',
						name: '成本费用',
					},
				]
				let legend_data = ['营收','成本费用',]
				option = {
    title: {
        show:false,
        text: '税务变化',
        left: 'center'
    },
    grid:{
        containLabel:true
    },
    legend: {
        data: legend_data,
        left: 'center',
        bottom: 4,
    },
    tooltip: {
        trigger: 'axis'
    },
    xAxis: {
        type: 'category',
        data: xAxis1.slice(0,12), 
        axisLabel: {
        "interval": 0,
        "rotate": 30,
        "width": 120,
        "overflow": "truncate",
        "ellipsis": "..."
        }
    },
    yAxis: {
        type: 'value',
        "minInterval": 1
    },
    series: series.slice(0,12), 
}
                // 使用刚指定的配置项和数据显示图表。
				nianfenEchart1.clear()
                nianfenEchart1.setOption(option);
                //根据窗口的大小变动图表
                nianfenEchart1.resize();
			})
		})
	}
	const getjichushujuChart2 = () => {
		nextTick(async ()=>{
			var shenbaojinduEchart2 = echarts.init(document.getElementById("jichushujushenbaojinduEchart2"),'theme');
			let params = {}
			if(params.conditionColumn) {
				params.conditionColumn += ';' + 'sfsh'
				params.conditionValue += ';' + '是'
			}else {
				params.conditionColumn = 'sfsh'
				params.conditionValue = '是'
			}
			context?.$http({
				url: "jichushuju/group/shenbaojindu?order=desc",
				method: "get",
				params
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let dataList = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].shenbaojindu);
				    yAxis.push(parseFloat((res[i].total)));
					dataList.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].shenbaojindu				    })
				}

				var option = {};
				option = {
    title:{
        show:false,
        text: '申报进度',
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
				shenbaojinduEchart2.clear()
				// 使用刚指定的配置项和数据显示图表。
				shenbaojinduEchart2.setOption(option);
				//根据窗口的大小变动图表
				shenbaojinduEchart2.resize();
			})
		})
	}
	const getshuikuanjiaonaChart1 = () => {
		nextTick(async ()=>{
			var ispayEchart1 = echarts.init(document.getElementById("shuikuanjiaonaispayEchart1"),'theme');
			let params = {}
			context?.$http({
				url: "shuikuanjiaona/group/ispay?order=desc",
				method: "get",
				params
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let dataList = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].ispay);
				    yAxis.push(parseFloat((res[i].total)));
					dataList.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].ispay				    })
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
				ispayEchart1.clear()
				// 使用刚指定的配置项和数据显示图表。
				ispayEchart1.setOption(option);
				//根据窗口的大小变动图表
				ispayEchart1.resize();
			})
		})
	}
	const getfapiaoleixingChart1 = () => {
		nextTick(async ()=>{
			var fapiaoleixingEchart1 = echarts.init(document.getElementById("fapiaoleixingfapiaoleixingEchart1"),'theme');
			let params = {}
			context?.$http({
				url: "fapiaoleixing/group/fapiaoleixing?order=desc",
				method: "get",
				params
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let dataList = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].fapiaoleixing);
				    yAxis.push(parseFloat((res[i].total)));
					dataList.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].fapiaoleixing				    })
				}

				var option = {};
				option = {
    title:{
        show:false,
        text: '发票类型',
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
				fapiaoleixingEchart1.clear()
				// 使用刚指定的配置项和数据显示图表。
				fapiaoleixingEchart1.setOption(option);
				//根据窗口的大小变动图表
				fapiaoleixingEchart1.resize();
			})
		})
	}
	const getfapiaokaijuChart1 = () => {
		nextTick(async ()=>{
			var fapiaoleixingEchart1 = echarts.init(document.getElementById("fapiaokaijufapiaoleixingEchart1"),'theme');
			let params = {}
			context?.$http({
				url: "fapiaokaiju/group/fapiaoleixing?order=desc",
				method: "get",
				params
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let dataList = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].fapiaoleixing);
				    yAxis.push(parseFloat((res[i].total)));
					dataList.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].fapiaoleixing				    })
				}

				var option = {};
				option = {
    title:{
        show:false,
        text: '发票类型',
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
				fapiaoleixingEchart1.clear()
				// 使用刚指定的配置项和数据显示图表。
				fapiaoleixingEchart1.setOption(option);
				//根据窗口的大小变动图表
				fapiaoleixingEchart1.resize();
			})
		})
	}
	const getfapiaolingyongChart1 = () => {
		nextTick(async ()=>{
			var fapiaoleixingEchart1 = echarts.init(document.getElementById("fapiaolingyongfapiaoleixingEchart1"),'theme');
			let params = {}
			context?.$http({
				url: "fapiaolingyong/group/fapiaoleixing?order=desc",
				method: "get",
				params
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let dataList = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].fapiaoleixing);
				    yAxis.push(parseFloat((res[i].total)));
					dataList.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].fapiaoleixing				    })
				}

				var option = {};
				option = {
    title:{
        show:false,
        text: '发票类型',
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
				fapiaoleixingEchart1.clear()
				// 使用刚指定的配置项和数据显示图表。
				fapiaoleixingEchart1.setOption(option);
				//根据窗口的大小变动图表
				fapiaoleixingEchart1.resize();
			})
		})
	}
	const getChartList = () => {
		if(btnAuth('qiye','首页统计')){
			getqiyeChart1()
		}
		if(btnAuth('jichushuju','首页统计')){
			getjichushujuChart1()
		}
		if(btnAuth('jichushuju','首页统计')){
			getjichushujuChart2()
		}
		if(btnAuth('shuikuanjiaona','首页统计')){
			getshuikuanjiaonaChart1()
		}
		if(btnAuth('fapiaoleixing','首页统计')){
			getfapiaoleixingChart1()
		}
		if(btnAuth('fapiaokaiju','首页统计')){
			getfapiaokaijuChart1()
		}
		if(btnAuth('fapiaolingyong','首页统计')){
			getfapiaolingyongChart1()
		}
	}
	//获取统计图数据
	getChartList()
</script>
<style lang="scss" scoped>
.home_view {
	padding: 24px;
	background: #f5f7fa;
	min-height: 100vh;
}

/* 统计卡片 */
.stat-cards {
	display: grid;
	grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
	gap: 16px;
	margin-bottom: 24px;
}

.stat-card {
	background: #fff;
	border-radius: 12px;
	padding: 20px;
	display: flex;
	align-items: center;
	gap: 16px;
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.06);
	transition: transform 0.2s, box-shadow 0.2s;

	&:hover {
		transform: translateY(-2px);
		box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
	}
}

.stat-card__icon {
	width: 48px;
	height: 48px;
	border-radius: 12px;
	display: flex;
	align-items: center;
	justify-content: center;
	flex-shrink: 0;

	svg {
		width: 24px;
		height: 24px;
	}
}

.stat-card--blue .stat-card__icon {
	background: #e8f4fd;
	color: #1a73e8;
}
.stat-card--green .stat-card__icon {
	background: #e6f7ed;
	color: #16a34a;
}
.stat-card--orange .stat-card__icon {
	background: #fff3e0;
	color: #f57c00;
}

.stat-card--purple .stat-card__icon {
	background: #f3e8fd;
	color: #7c3aed;
}
.stat-card--cyan .stat-card__icon {
	background: #e0f7fa;
	color: #0097a7;
}
.stat-card--pink .stat-card__icon {
	background: #fce4ec;
	color: #e91e63;
}

.stat-card__info {
	display: flex;
	flex-direction: column;
}

.stat-card__label {
	font-size: 13px;
	color: #666;
	margin-bottom: 4px;
}

.stat-card__value {
	font-size: 28px;
	font-weight: 700;
	color: #1a1a1a;
	line-height: 1.2;
}

/* 资讯区域 */
.dashboard-section {
	margin-bottom: 24px;
}

.section-card {
	background: #fff;
	border-radius: 12px;
	padding: 24px;
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.06);
}

.section-header {
	margin-bottom: 16px;
}

.section-title {
	font-size: 18px;
	font-weight: 600;
	color: #1a1a1a;
	margin: 0;
}

.news-list {
	max-height: 400px;
	overflow-y: auto;
}

.news-item {
	display: flex;
	gap: 16px;
	padding: 14px 0;
	border-bottom: 1px solid #f0f0f0;
	cursor: pointer;
	transition: background 0.2s;

	&:hover {
		background: #fafbfc;
	}

	&:last-child {
		border-bottom: none;
	}
}

.news-img {
	width: 80px;
	height: 60px;
	border-radius: 8px;
	object-fit: cover;
	flex-shrink: 0;
}

.news-content {
	flex: 1;
	min-width: 0;
}

.news-title {
	font-size: 15px;
	font-weight: 500;
	color: #1a1a1a;
	margin-bottom: 4px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

.news-desc {
	font-size: 13px;
	color: #666;
	margin-bottom: 4px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

.news-time {
	font-size: 12px;
	color: #999;
}

/* 图表区域 */
.chart-grid {
	display: grid;
	grid-template-columns: repeat(2, 1fr);
	gap: 20px;
}

.chart-card {
	background: #fff;
	border-radius: 12px;
	padding: 20px;
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.06);
}

.chart-card__header {
	font-size: 16px;
	font-weight: 600;
	color: #1a1a1a;
	margin-bottom: 12px;
}

.chart-canvas {
	width: 100%;
	height: 360px;
}
</style>
