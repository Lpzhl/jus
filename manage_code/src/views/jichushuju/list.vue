<template>
	<div>
		<div class="center_view">
			<div class="list_search_view">
				<el-form :model="searchQuery" class="search_form" >
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
					<div class="search_view">
						<div class="search_label">
							审核状态：
						</div>
						<div class="search_box">
							<el-select
								class="search_sel"
								clearable
								v-model="searchQuery.sfsh"
								placeholder="审核状态"
								>
								<el-option v-for="item in approvalLists" :label="item" :value="item"></el-option>
							</el-select>
						</div>
					</div>
					<div class="search_btn_view">
						<el-button class="search_btn" type="primary" @click="searchClick()" size="small">搜索</el-button>
					</div>
				</el-form>
				<div class="btn_view">
					<el-button class="add_btn" type="success" @click="addClick" v-if="btnAuth('jichushuju','新增')">
						新增
					</el-button>
					<el-button class="del_btn" type="danger" :disabled="selRows.length?false:true" @click="delClick(null)"  v-if="btnAuth('jichushuju','删除')">
						删除
					</el-button>
                    <el-button class="statis_btn" type="warning" @click="echartClick1" v-if="btnAuth('jichushuju','税务变化')">
                        税务变化
                    </el-button>
                    <el-button class="statis_btn" type="warning" @click="echartClick2" v-if="btnAuth('jichushuju','申报进度')">
                        申报进度
                    </el-button>
				</div>
			</div>
			<el-table
				v-loading="listLoading" :stripe='false'
				@selection-change="handleSelectionChange"
				ref="table"
				v-if="btnAuth('jichushuju','查看')"
				:data="list"
				@row-click="listChange">
				<el-table-column :resizable='true' align="left" header-align="left" type="selection" width="55" />
				<el-table-column label="序号" width="70" :resizable='true' align="left" header-align="left">
					<template #default="scope">{{ (listQuery.page-1)*listQuery.limit+scope.$index + 1}}</template>
				</el-table-column>
				<el-table-column min-width="140"
					:resizable='true'
					:sortable='false'
					align="left"
					header-align="left"
					prop="nianfen"
					label="年份">
					<template #default="scope">
						{{scope.row.nianfen}}
					</template>
				</el-table-column>
				<el-table-column min-width="140"
					:resizable='true'
					:sortable='false'
					align="left"
					header-align="left"
					prop="yuefen"
					label="月份">
					<template #default="scope">
						{{scope.row.yuefen}}
					</template>
				</el-table-column>
				<el-table-column label="销项发票" min-width="140" width="120" :resizable='true' :sortable='false' align="left" header-align="left">
					<template #default="scope">
						<div v-if="scope.row.xiaoxiangfapiao">
							<el-image v-if="scope.row.xiaoxiangfapiao.substring(0,4)=='http'" preview-teleported
								:preview-src-list="[scope.row.xiaoxiangfapiao.split(',')[0]]"
								:src="scope.row.xiaoxiangfapiao.split(',')[0]" style="width:100px;height:100px"></el-image>
							<el-image v-else preview-teleported
								:preview-src-list="[$config.url+scope.row.xiaoxiangfapiao.split(',')[0]]"
								:src="$config.url+scope.row.xiaoxiangfapiao.split(',')[0]" style="width:100px;height:100px">
							</el-image>
						</div>
						<div v-else>无图片</div>
					</template>
				</el-table-column>
				<el-table-column label="进项发票" min-width="140" width="120" :resizable='true' :sortable='false' align="left" header-align="left">
					<template #default="scope">
						<div v-if="scope.row.jinxiangfapiao">
							<el-image v-if="scope.row.jinxiangfapiao.substring(0,4)=='http'" preview-teleported
								:preview-src-list="[scope.row.jinxiangfapiao.split(',')[0]]"
								:src="scope.row.jinxiangfapiao.split(',')[0]" style="width:100px;height:100px"></el-image>
							<el-image v-else preview-teleported
								:preview-src-list="[$config.url+scope.row.jinxiangfapiao.split(',')[0]]"
								:src="$config.url+scope.row.jinxiangfapiao.split(',')[0]" style="width:100px;height:100px">
							</el-image>
						</div>
						<div v-else>无图片</div>
					</template>
				</el-table-column>
				<el-table-column min-width="140"
					:resizable='true'
					:sortable='false'
					align="left"
					header-align="left"
					prop="yingshou"
					label="营收">
					<template #default="scope">
						{{scope.row.yingshou}}
					</template>
				</el-table-column>
				<el-table-column min-width="140"
					:resizable='true'
					:sortable='false'
					align="left"
					header-align="left"
					prop="chengbenfeiyong"
					label="成本费用">
					<template #default="scope">
						{{scope.row.chengbenfeiyong}}
					</template>
				</el-table-column>
				<el-table-column min-width="140"
					:resizable='true'
					:sortable='false'
					align="left"
					header-align="left"
					prop="shenbaoshijian"
					label="申报时间">
					<template #default="scope">
						{{scope.row.shenbaoshijian}}
					</template>
				</el-table-column>
				<el-table-column min-width="140"
					:resizable='true'
					:sortable='false'
					align="left"
					header-align="left"
					prop="qiyemingcheng"
					label="企业名称">
					<template #default="scope">
						{{scope.row.qiyemingcheng}}
					</template>
				</el-table-column>
				<el-table-column min-width="140"
					:resizable='true'
					:sortable='false'
					align="left"
					header-align="left"
					prop="shenbaojindu"
					label="申报进度">
					<template #default="scope">
						{{scope.row.shenbaojindu}}
					</template>
				</el-table-column>
				<el-table-column label="审核回复" min-width="140" :resizable='true' :sortable='false' align="left" header-align="left">
					<template #default="scope">
						{{scope.row.shhf}}
					</template>
				</el-table-column>
				<el-table-column prop="sfsh" label="审核状态" min-width="140" :resizable='true' :sortable='false' align="left" header-align="left">
					<template #default="scope">
                        <div v-if="scope.row.sfsh=='是'" style="text-align: center">
                            <img class="list-sh-img" src="@/assets/img/pass.png" style="width: 50px;"/>
                            <div>通过</div>
                        </div>
                        <div v-else-if="scope.row.sfsh=='否'" style="text-align: center">
                            <img class="list-sh-img" src="@/assets/img/reject.png" style="width: 50px;"/>
                            <div>未通过</div>
                        </div>
                        <div v-else-if="scope.row.sfsh=='待审核'" style="text-align: center">
                            <img class="list-sh-img" src="@/assets/img/wait.png" style="width: 50px;"/>
                            <div>待审核</div>
                        </div>
					</template>
				</el-table-column>
				<el-table-column label="审核" v-if="btnAuth('jichushuju','审核')" :resizable='true' :sortable='false' align="left" header-align="left">
					<template #default="scope">
						<el-button v-if="scope.row.sfsh=='待审核'" size="small" @click="approvalClick(scope.row)">审核</el-button>
					</template>
				</el-table-column>
				<el-table-column label="操作" class-name="operation-cell" width="300"  :resizable='true' :sortable='false' align="left" header-align="left">
					<template #default="scope">
						<el-button class="view_btn" type="info" v-if=" btnAuth('jichushuju','查看')" @click="infoClick(scope.row.id)">
							详情
						</el-button>
						<el-button class="edit_btn" type="primary" @click="editClick(scope.row.id,scope.row)" v-if=" btnAuth('jichushuju','修改')">
							修改						</el-button>
						<el-button class="del_btn" type="danger" @click="delClick(scope.row.id,scope.row)"  v-if="btnAuth('jichushuju','删除')">
							删除						</el-button>
						<el-button class="cross_btn" v-if="btnAuth('jichushuju','缴纳金额')" type="success" @click="shuikuanjiaonaCrossAddOrUpdateHandler(scope.row,'cross','是','','[1]','请勿重复操作')">
							缴纳金额
						</el-button>
						<el-button class="cross_btn" v-if="btnAuth('jichushuju','申报操作')" type="success" @click="shenbaocaozuoCrossAddOrUpdateHandler(scope.row,'cross','是','','shenbaojindu','已申报','已申报,未申报'.split(',')[0])">
							申报操作
						</el-button>
					</template>
				</el-table-column>
			</el-table>
			<el-pagination
				background
				:layout="layouts.join(',')"
				:total="total"
				:page-size="listQuery.limit"
                v-model:current-page="listQuery.page"
				prev-text="<"
				next-text=">"
				:hide-on-single-page="true"
				:page-sizes="[10, 20, 30, 40, 50, 100]"
				@size-change="sizeChange"
				@current-change="currentChange"  />
		</div>
		<formModel ref="formRef" @formModelChange="formModelChange"></formModel>
		<Approval ref="approvalRef" @approvalSave="approvalSave" :tableName="tableName">
		</Approval>
		<!-- 统计图弹窗 -->
		<el-dialog v-model="echartVisible" modal-class="edit_form_modal" class="edit_form" title="统计图" width="70%">
			<el-tabs v-model="echartActive" class="demo-tabs" @tab-change="echartTabClick" type="card">
                <el-tab-pane label="税务变化" name="1" v-if="btnAuth('jichushuju','税务变化')"></el-tab-pane>
                <el-tab-pane label="申报进度" name="2" v-if="btnAuth('jichushuju','申报进度')"></el-tab-pane>
			</el-tabs>
			<div v-if="echartActive==1">
				<div id="nianfenEchart1" style="width:100%;height:600px;"></div>
			</div>
			<div v-if="echartActive==2">
				<div id="shenbaojinduEchart2" style="width:100%;height:600px;"></div>
			</div>
			<template #footer>
				<span class="formModel_btn_box">
					<el-button class="cancel_btn" @click="echartVisible=false">取消</el-button>
				</span>
			</template>
		</el-dialog>
		<shuikuanjiaonaFormModel ref="shuikuanjiaonaFormModelRef" @formModelChange="formModelChange"></shuikuanjiaonaFormModel>
		<shenbaocaozuoFormModel ref="shenbaocaozuoFormModelRef" @formModelChange="formModelChange"></shenbaocaozuoFormModel>
	</div>
</template>
<script setup>
	import axios from 'axios'
	const moment = window.moment
	import {
		reactive,
		ref,
		getCurrentInstance,
		nextTick,
		onMounted,
		watch,
		computed,
		inject
	} from 'vue'
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
	import formModel from './formModel.vue'
	//基础信息
	const tableName = 'jichushuju'
	const formName = '基础数据'
	const route = useRoute()
    const router = useRouter()
	const role = context.$toolUtil.storageGet('sessionTable')
	//基础信息
	onMounted(()=>{
	})
	//列表数据
	const list = ref(null)
	const table = ref(null)
	const listQuery = ref({
		page: 1,
		limit: 20,
		sort: 'id',
		order: 'desc'
	})
	const searchQuery = ref({})
	const selRows = ref([])
	const listLoading = ref(false)
	const listChange = (row) =>{
		nextTick(()=>{
			//table.value.clearSelection()
			table.value.toggleRowSelection(row)
		})
	}
	//列表
	const getList = () => {
		listLoading.value = true
		let params = JSON.parse(JSON.stringify(listQuery.value))
		params['sort'] = 'id'
		params['order'] = 'desc'
		if(searchQuery.value.nianfen&&searchQuery.value.nianfen!=''){
			params['nianfen'] = '%' + searchQuery.value.nianfen + '%'
		}
		if(searchQuery.value.yuefen&&searchQuery.value.yuefen!=''){
			params['yuefen'] = '%' + searchQuery.value.yuefen + '%'
		}
		if(searchQuery.value.sfsh && searchQuery.value.sfsh!=''){
			params['sfsh'] = searchQuery.value.sfsh
		}
		context.$http({
			url: `${tableName}/page`,
			method: 'get',
			params: params
		}).then(res => {
			listLoading.value = false
			list.value = res.data.data.list
			total.value = Number(res.data.data.total)
		})
	}
	//删
	const delClick = (id,row={}) => {
		let ids = []
		if (id) {
			ids = [id]
		} else {
			if (selRows.value.length) {
				for (let x in selRows.value) {
					ids.push(selRows.value[x].id)
				}
			} else {
				return false
			}
		}
		ElMessageBox.confirm(`是否删除选中${formName}`, '提示', {
			confirmButtonText: '是',
			cancelButtonText: '否',
			type: 'warning',
		}).then(() => {
			context.$http({
				url: `${tableName}/delete`,
				method: 'post',
				data: ids
			}).then(res => {
				context?.$toolUtil.message('删除成功', 'success',()=>{
					getList()
				})
			})
		}).catch(_ => {})
	}
	//多选
	const handleSelectionChange = (e) => {
		selRows.value = e
	}
	//列表数据
	//分页
	const total = ref(0)
	const layouts = ref(["total","prev","pager","next"])
	const sizeChange = (size) => {
		listQuery.value.limit = size
		getList()
	}
	const currentChange = (page) => {
		listQuery.value.page = page
		getList()
	}
	//分页
	//权限验证
	const btnAuth = (e,a)=>{
		return context?.$toolUtil.isAuth(e,a)
	}
    const approvalSave = async (form)=>{
		context.$http.post(`${tableName}/update`,form).then(res => {
            context.$message.success('审核成功')
            approvalRef.value.approvalVisible = false
			searchClick()
        })
    }
	//搜索
	const searchClick = () => {
		listQuery.value.page = 1
		getList()
	}
	//表单
	const formRef = ref(null)
	const formModelChange=()=>{
		searchClick()
	}
	const addClick = ()=>{
		formRef.value.init()
	}
	const editClick = (id=null,row={})=>{
		if(id){
			formRef.value.init(id,'edit')
			return
		}
		if(selRows.value.length){
			formRef.value.init(selRows.value[0].id,'edit')
		}
	}

	const infoClick = (id=null)=>{
		if(id){
			formRef.value.init(id,'info')
		}
		else if(selRows.value.length){
			formRef.value.init(selRows.value[0].id,'info')
		}
	}
	// 表单
	// 预览文件
	const preClick = (file) =>{
		if(!file){
			context?.$toolUtil.message('文件不存在','error')
		}
		window.open(context?.$config.url + file)
	}
	// 下载文件
	const download = (file) => {
		if(!file){
			context?.$toolUtil.message('文件不存在','error')
		}
		let arr = file.replace(new RegExp('file/', "g"), "")
		axios.get((location.href.split(context?.$config.name).length>1 ? location.href.split(context?.$config.name)[0] :'') + context?.$config.name + '/file/download?fileName=' + arr, {
			headers: {
				token: context?.$toolUtil.storageGet('Token')
			},
			responseType: "blob"
		}).then(({
			data
		}) => {
			const binaryData = [];
			binaryData.push(data);
			const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
				type: 'application/pdf;chartset=UTF-8'
			}))
			const a = document.createElement('a')
			a.href = objectUrl
			a.download = arr
			// a.click()
			// 下面这个写法兼容火狐
			a.dispatchEvent(new MouseEvent('click', {
				bubbles: true,
				cancelable: true,
				view: window
			}))
			window.URL.revokeObjectURL(data)
		})
	}
    import '@/assets/js/echarts-theme'
	//判断是否有统计图筛选权限
	const changeStatQuery = (arr)=>{
		if(!arr){
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
	// 统计图1
	const echartVisible = ref(false)
	const echartClick1 = ()=>{
		if(!route.path.endsWith('Analysis')){
			echartActive.value = '1'
			echartVisible.value = true
		}
		nextTick(async ()=>{
			let dom = document.getElementById("nianfenEchart1")
			if(!dom)return
			var nianfenEchart1 = echarts.init(dom,'theme');
			let params = {}
			if(params.conditionColumn) {
				params.conditionColumn += ';' + 'sfsh'
				params.conditionValue += ';' + '是'
			}else {
				params.conditionColumn = 'sfsh'
				params.conditionValue = '是'
			}
			context.$http({
				url: `${tableName}/valueMul/nianfen?yColumnNameMul=yingshou,chengbenfeiyong`,
				method: 'get',
				params
			}).then(res=>{
				let obj = res.data.data
                let xAxis1 = [];
                let yAxis1 = [];
                let pArray1 = []
                for(let i=0;i<obj[0].length;i++){
                    xAxis1.push(obj[0][i].nianfen);
                    yAxis1.push(parseFloat((obj[0][i].total)));
                    pArray1.push({
                        value: parseFloat((obj[0][i].total)),
                        name: obj[0][i].nianfen
                    })
                }
                let xAxis2 = [];
                let yAxis2 = [];
                let pArray2 = []
                for(let i=0;i<obj[1].length;i++){
                    xAxis2.push(obj[1][i].nianfen);
                    yAxis2.push(parseFloat((obj[1][i].total)));
                    pArray2.push({
                        value: parseFloat((obj[1][i].total)),
                        name: obj[1][i].nianfen
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
                nianfenEchart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    nianfenEchart1.resize();
                };
			})
		})
	}
	// 统计图2
    const echartActive = ref('1')
    const echartTabClick = () =>{
		if(echartActive.value==1){
			echartClick1()
		}
		else if(echartActive.value==2){
			echartClick2()
		}
	}
	const echartClick2 = ()=>{
		if(!route.path.endsWith('Analysis')){
			echartActive.value = '2'
			echartVisible.value = true
		}
		nextTick(async ()=>{
			let dom = document.getElementById("shenbaojinduEchart2")
			if(!dom)return
			var shenbaojinduEchart2 = echarts.init(dom,'theme');
			let params = {}
			if(params.conditionColumn) {
				params.conditionColumn += ';' + 'sfsh'
				params.conditionValue += ';' + '是'
			}else {
				params.conditionColumn = 'sfsh'
				params.conditionValue = '是'
			}
			context.$http({
				url: `${tableName}/group/shenbaojindu?order=desc`,
				method: 'get',
				params
			}).then(res=>{
				let obj = res.data.data
				let xAxis = [];
				let yAxis = [];
				let dataList = []
				for(let i=0;i<obj.length;i++){
				    xAxis.push(obj[i].shenbaojindu);
				    yAxis.push(parseFloat((obj[i].total)));
                    dataList.push({
				        value: parseFloat((obj[i].total)),
				        name: obj[i].shenbaojindu				    })
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
				// 使用刚指定的配置项和数据显示图表。
				shenbaojinduEchart2.setOption(option);
				  //根据窗口的大小变动图表
				window.onresize = function() {
				    shenbaojinduEchart2.resize();
				};
			})
		})
	}
	//审核
	import Approval from '@/components/common/approval.vue'
	const approvalRef = ref(null)
	const approvalClick = (row) => {
		nextTick(() => {
			approvalRef.value.approvalClick(row )
		})
	}
	import shuikuanjiaonaFormModel from '@/views/shuikuanjiaona/formModel'
	const shuikuanjiaonaFormModelRef = ref(null)
    const shuikuanjiaonaCrossAddOrUpdateHandler = (row,type,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue) => {
		if(crossOptAudit=='是'&&row.sfsh!='是') {
			context?.$toolUtil.message('请审核通过后再操作！','error')
			return
		}
		if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
			var obj = row
			for (var o in obj){
				if(o==statusColumnName && obj[o]==statusColumnValue){
					context?.$toolUtil.message(tips,'error')
					return;
				}
			}
		}
		nextTick(()=>{
			shuikuanjiaonaFormModelRef.value.init(row.id,'cross','缴纳金额',row,'jichushuju',statusColumnName,tips,statusColumnValue)
		})
    }
	import shenbaocaozuoFormModel from '@/views/shenbaocaozuo/formModel'
	const shenbaocaozuoFormModelRef = ref(null)
    const shenbaocaozuoCrossAddOrUpdateHandler = (row,type,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue) => {
		if(crossOptAudit=='是'&&row.sfsh!='是') {
			context?.$toolUtil.message('请审核通过后再操作！','error')
			return
		}
		if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
			var obj = row
			for (var o in obj){
				if(o==statusColumnName && obj[o]==statusColumnValue){
					context?.$toolUtil.message(tips,'error')
					return;
				}
			}
		}
		nextTick(()=>{
			shenbaocaozuoFormModelRef.value.init(row.id,'cross','申报操作',row,'jichushuju',statusColumnName,tips,statusColumnValue)
		})
    }
	//查询审核状态列表
	const approvalLists = ref([])
	//初始化
	const init = () => {
        approvalLists.value = "是,否,待审核".split(',');
		getList()
	}
	init()
</script>
<style lang="scss" scoped>
	// 表格样式
	.el-table {
		:deep(.el-table__body-wrapper) {
			tbody {
			}
		}
	}
	.condition-box {
		display: flex;
		gap: 10px;
		justify-content: center;
	}

	.condition-box>* {
		max-width: 300px;
	}
</style>