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
                            支付状态：
                        </div>
                        <div class="search_box">
                            <el-select
                                class="search_sel"
                                clearable
                                v-model="searchQuery.ispay"
                                placeholder="支付状态"
                            >
                                <el-option label="已支付" value="已支付"></el-option>
                                <el-option label="未支付" value="未支付"></el-option>
                            </el-select>
                        </div>
                    </div>
					<div class="search_btn_view">
						<el-button class="search_btn" type="primary" @click="searchClick()" size="small">搜索</el-button>
					</div>
				</el-form>
				<div class="btn_view">
					<el-button class="add_btn" type="success" @click="addClick" v-if="btnAuth('shuikuanjiaona','新增')">
						新增
					</el-button>
					<el-button class="del_btn" type="danger" :disabled="selRows.length?false:true" @click="delClick(null)"  v-if="btnAuth('shuikuanjiaona','删除')">
						删除
					</el-button>
                    <el-button class="statis_btn" type="warning" @click="echartClick1" v-if="btnAuth('shuikuanjiaona','缴款状态')">
                        缴款状态
                    </el-button>
				</div>
			</div>
			<el-table
				v-loading="listLoading" :stripe='false'
				@selection-change="handleSelectionChange"
				ref="table"
				v-if="btnAuth('shuikuanjiaona','查看')"
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
				<el-table-column label="完税凭证" min-width="140" :resizable='true' :sortable='false' align="left" header-align="left">
					<template #default="scope">
						<el-button v-if="scope.row.wanshuipingzheng" size="small" @click="download(scope.row.wanshuipingzheng)">下载</el-button>
						<el-button v-else disabled link size="small">无</el-button>
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
					prop="shuikuanjine"
					label="税款金额">
					<template #default="scope">
						{{scope.row.shuikuanjine}}
					</template>
				</el-table-column>
				<el-table-column prop="ispay" label="支付状态" min-width="140" :resizable='true' :sortable='false' align="left" header-align="left">
					<template #default="scope">
						<span style="margin-right:10px">{{scope.row.ispay=='已支付'?'已支付':'未支付'}}</span>
						<el-button v-if="scope.row.ispay!='已支付' && btnAuth('shuikuanjiaona','支付')" size="small" @click.stop="payClick(scope.row)">支付</el-button>
					</template>
				</el-table-column>
				<el-table-column min-width="140"
					:resizable='true'
					:sortable='false'
					align="left"
					header-align="left"
					prop="zongfeiyong"
					label="总费用">
					<template #default="scope">
						{{scope.row.zongfeiyong}}
					</template>
				</el-table-column>
				<el-table-column label="操作" class-name="operation-cell" width="300"  :resizable='true' :sortable='false' align="left" header-align="left">
					<template #default="scope">
						<el-button class="view_btn" type="info" v-if=" btnAuth('shuikuanjiaona','查看')" @click="infoClick(scope.row.id)">
							详情
						</el-button>
						<el-button class="edit_btn" type="primary" @click="editClick(scope.row.id,scope.row)" v-if=" btnAuth('shuikuanjiaona','修改')">
							修改						</el-button>
						<el-button class="del_btn" type="danger" @click="delClick(scope.row.id,scope.row)"  v-if="btnAuth('shuikuanjiaona','删除')">
							删除						</el-button>
						<el-button class="cross_btn" v-if="btnAuth('shuikuanjiaona','催缴')" type="success" @click="qianshuicuijiaoCrossAddOrUpdateHandler(scope.row,'cross','是','否','','')">
							催缴
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
		<payForm ref="payRef" @paySave="paySave"></payForm>
		<!-- 统计图弹窗 -->
		<el-dialog v-model="echartVisible" modal-class="edit_form_modal" class="edit_form" title="统计图" width="70%">
			<div >
				<div id="ispayEchart1" style="width:100%;height:600px;"></div>
			</div>
			<template #footer>
				<span class="formModel_btn_box">
					<el-button class="cancel_btn" @click="echartVisible=false">取消</el-button>
				</span>
			</template>
		</el-dialog>
		<qianshuicuijiaoFormModel ref="qianshuicuijiaoFormModelRef" @formModelChange="formModelChange"></qianshuicuijiaoFormModel>
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
	const tableName = 'shuikuanjiaona'
	const formName = '税款缴纳'
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
        if(searchQuery.value.ispay && searchQuery.value.ispay!=''){
            params['ispay'] = searchQuery.value.ispay
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
    const paySave = async(data)=>{
        data.ispay = '已支付'
        context?.$http({
            url: `${tableName}/update`,
            method: 'post',
            data: data
        }).then(res => {
            context.$message.success('支付成功')
            payRef.value.payVisible = false
			searchClick()
        })
    }
	import payForm from '@/components/common/payForm'
	const payRef = ref(null)
	const payClick = (row)=>{
		payRef.value.payClick(tableName,row)
	}
	import qianshuicuijiaoFormModel from '@/views/qianshuicuijiao/formModel'
	const qianshuicuijiaoFormModelRef = ref(null)
    const qianshuicuijiaoCrossAddOrUpdateHandler = (row,type,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue) => {
        if(crossOptPay=='是'&&row.ispay!='已支付'){
            context.$toolUtil.message("请支付完成再操作",'error');
            return
        }
		if (new Date().getTime() > new Date(row.reversetime).getTime()) {
			context?.$toolUtil.message('已超过失效时间！','error')
			return false
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
			qianshuicuijiaoFormModelRef.value.init(row.id,'cross','催缴',row,'shuikuanjiaona',statusColumnName,tips,statusColumnValue)
		})
    }
	//初始化
	const init = () => {
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