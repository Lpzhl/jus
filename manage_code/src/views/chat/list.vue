<template>
	<div>
		<div class="center_view">
			<div class="list_search_view">
				<el-form class="search_form" >
					<div class="search_view">
						<div class="search_label">
							回复状态
						</div>
						<div class="search_box">
							<el-select
									class="search_sel"
									v-model="searchQuery.isreply"
									placeholder="请选择"
							>
								<el-option label="未回复" :value="1"></el-option>
								<el-option label="已回复" :value="0"></el-option>
							</el-select>
						</div>
					</div>
					<div class="search_view">
						<div class="search_label">
							是否已读
						</div>
						<div class="search_box">
							<el-select
									class="search_sel"
									v-model="searchQuery.isRead"
									placeholder="请选择"
							>
								<el-option label="未读" :value="0"></el-option>
								<el-option label="已读" :value="1"></el-option>
							</el-select>
						</div>
					</div>
					<div class="search_btn_view">
						<el-button class="search_btn" type="primary" @click="searchClick()" size="small">搜索</el-button>
					</div>
				</el-form>
			</div>
			<el-table v-loading="listLoading" :data="list" border
				:stripe='false'>
				<el-table-column label="用户" :resizable='true' :sortable='false' align="left" header-align="left">
					<template #default="scope">
						<div style="display: flex;align-items: center;gap: 10px">
							<el-image v-if="scope.row.userImage" preview-teleported :preview-src-list="[$config.url+scope.row.userImage.split(',')[0]]"
									  :src="$config.url+scope.row.userImage.split(',')[0]" style="width:80px;height:80px;border-radius: 6px;">
							</el-image>
							{{scope.row.userName}}
						</div>
					</template>
				</el-table-column>
				<el-table-column label="新消息" :resizable='true' align="left" header-align="left">
					<template #default="scope">
						{{scope.row.ask}}
					</template>
				</el-table-column>
				<el-table-column label="回复状态" :resizable='true' align="left" header-align="left">
					<template #default="scope">
						<el-tag v-if="scope.row.isreply==0" type="success">已回复</el-tag>
						<el-tag v-if="scope.row.isreply==1" type="info">未回复</el-tag>
					</template>
				</el-table-column>
				<el-table-column label="是否已读" :resizable='true' align="left" header-align="left">
					<template #default="scope">
						<el-tag v-if="scope.row.isRead==1" type="success">已读</el-tag>
						<el-tag v-if="scope.row.isRead==0" type="info">未读</el-tag>
					</template>
				</el-table-column>
				<el-table-column label="操作" :resizable='true' align="left" header-align="left">
					<template #default="scope">
						<el-button class="edit_btn" type="primary" @click="replyClick(scope.row)">回复</el-button>
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
				@size-change="sizeChange"
				@current-change="currentChange"  />
			<el-dialog v-model="formVisible" title="回复" width="70%" destroy-on-close @close="delTimer" class="chat-dialog">
				<div class="chat_view">
					<div class="chat-content">
						<div class="chat-item" :key="item.id" v-for="(item,index) in chatList">
							<div class="chat_time" v-if="item.showTime">{{item.addtime}}</div>
							<div v-if="item.ask" class="left-content">
								<div class="user">
									<span>{{item.userName}}</span>
									<img v-if="item.userImage" :src="$config.url+item.userImage" style="width: 50px;height: 50px;">
									<img v-else src="@/assets/img/avatar.png" style="width: 50px;height: 50px;">
								</div>
								<div class="content">
									<el-alert v-if="item.type==1" class="text-content" :title="item.ask" :closable="false"
											  type="warning"></el-alert>
									<el-image v-else-if="item.type==2" :src="baseUrl + item.ask"
											  class="chat_img" fit="scale-down"
											  :preview-src-list="[baseUrl + item.ask]"></el-image>
									<video v-else-if="item.type==3" controls style="width: 200px;height: 160px">
										<source  :src="baseUrl + item.ask">
									</video>
									<audio v-else-if="item.type==5" controls style="height: 40px;">
										<source :src="baseUrl + item.ask">
									</audio>
									<div v-else @click="downloadFile(item.ask)" class="chat-file"
										 style="display: flex;align-items: center;gap: 10px;border: 1px solid #999;padding: 10px;cursor: pointer;">
										<el-icon style="font-size: 30px;"><Document /></el-icon><span>点击下载</span>
									</div>
								</div>
							</div>
							<div v-else class="right-content">
								<div class="user">
									<span>{{item.userName}}</span>
									<img v-if="item.userImage" :src="$config.url+item.userImage" style="width: 50px;height: 50px;">
									<img v-else src="@/assets/img/avatar.png" style="width: 50px;height: 50px;">
								</div>
								<div class="content">
									<el-alert v-if="item.type==1" class="text-content" :title="item.reply" :closable="false"
											  type="success"></el-alert>
									<el-image v-else-if="item.type==2" :src="baseUrl + item.reply"
											  class="chat_img" fit="scale-down"
											  :preview-src-list="[baseUrl + item.reply]"></el-image>
									<video v-else-if="item.type==3" controls style="width: 200px;height: 160px">
										<source  :src="baseUrl + item.reply">
									</video>
									<audio v-else-if="item.type==5" controls style="height: 40px;">
										<source :src="baseUrl + item.reply">
									</audio>
									<div v-else @click="downloadFile(item.reply)" class="chat-file"
										 style="display: flex;align-items: center;gap: 10px;border: 1px solid #999;padding: 10px;cursor: pointer;">
										<el-icon style="font-size: 30px;"><Document /></el-icon><span>点击下载</span>
									</div>
								</div>
							</div>
							<div class="clear-float"></div>
						</div>
					</div>
					<div class="input_box">
						<div class="actionBar">
							<el-popover
									title="表情"
									width="auto"
									trigger="click"
									placement="top"
							>
								<template #reference>
									<i class="iconfont icon-xiaolian expression-icon-btn" style="font-size: 24px;"></i>
								</template>
								<template #default>
									<Picker
											:data="emojiIndex"
											:emojiSize="24"
											:showPreview="showEmoji"
											:infiniteScroll="false"
											set="apple"
											@select="handleEmoji"
											:showSearch="false"
											:i18n="emojiI18n"
									/>
								</template>
							</el-popover>
							<el-upload class="upload" :action="action" :on-success="uploadSuccess"
									   :show-file-list="false" accept="image/*,.mp4,.mp3">
								<el-icon style="font-size: 28px"><FolderAdd /></el-icon>
							</el-upload>
						</div>
						<div class="input-row">
							<el-input class="textarea" type="textarea" v-model="form.reply"></el-input>
						</div>
						<div class="send-box">
							<el-button class="send" type="primary" @click="addChat">发送</el-button>
						</div>
					</div>
				</div>
			</el-dialog>
		</div>
	</div>
</template>

<script setup>
	import {
		reactive,
		ref,
		getCurrentInstance,
		nextTick,
		onMounted,
	} from 'vue'
	const moment = window.moment
	import { useStore } from 'vuex'
	const store = useStore()
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const baseUrl = context?.$config.url

	import emojiData from 'emoji-mart-vue-fast/data/all.json'
	import 'emoji-mart-vue-fast/css/emoji-mart.css'
	import { Picker, EmojiIndex } from 'emoji-mart-vue-fast/src'
	const emojiIndex = new EmojiIndex(emojiData)
	const emojiI18n = {
		categories: {
			search: '搜索结果',
			recent: '经常使用',
			smileys: '表情与情感',
			people: '人物与身体',
			nature: '动物与自然',
			foods: '食物与饮料',
			activity: '活动',
			places: '旅行与地理',
			objects: '物品',
			symbols: '符号标志',
			flags: '旗帜',
			custom: 'Custom',
			joy: '哭笑'
		}
	}
	const showEmoji = ref(false)
	// 选中emoji
	const handleEmoji = (e) => {
		form.value.reply += e.native;
		showEmoji.value = false
	}

	const list = ref([])
	const listQuery = ref({
		page: 1,
		limit: 20,
		sort: 'id',
		order: 'desc',
		isreply: 1
	})
	const searchQuery = ref({
		isreply:1,  //默认查未回复
		isRead:0,   //默认查未读
	})
	//搜索
	const searchClick = () => {
		listQuery.value.page = 1
		getList()
	}
	const listLoading = ref(false)
	//获取列表
	const getList = () => {
		let params = listQuery.value
		params.isreply = searchQuery.value.isreply
		params.isRead = searchQuery.value.isRead
		listLoading.value = true
		context?.$http({
			url: 'chat/page',
			method: 'get',
			params: params
		}).then(res => {
			listLoading.value = false
			list.value = res.data.data.list
			total.value = Number(res.data.data.total)
		})
	}
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
	//form
	const formVisible = ref(false)
	const nowId = ref(0)
	const form = ref({
		reply: '',
        isreply: 0,
		adminTableName:localStorage.getItem('adminName')
	})
	//对话列表
	const chatList = ref([])
	//回复按钮
	const replyClick = (row) => {
		nowId.value = row.userid
		getChatList()
		formVisible.value = true
		timer.value = setInterval(() => {
			getChatList()
		}, 3000)
	}
	//定时器
	const timer = ref(null)
	const delTimer = () => {
		clearInterval(timer.value)
	}
    const scrollFlag = ref(true)
	const getChatList = () => {
		context?.$http({
			url: 'chat/page',
			method: 'get',
			params: {
				limit: 1000,
				sort: 'addtime',
				order: 'asc',
				userid: nowId.value
			}
		}).then(res => {
			for (let x in res.data.data.list) {
				if (res.data.data.list[x].ask) {
					if (res.data.data.list[x].ask.split('/').length > 1) {
						if (res.data.data.list[x].ask.split('/')[0] == 'file') {
							res.data.data.list[x].img = res.data.data.list[x].ask
						}
					}
				}
				if (res.data.data.list[x].reply) {
					if (res.data.data.list[x].reply.split('/').length > 1) {
						if (res.data.data.list[x].reply.split('/')[0] == 'file') {
							res.data.data.list[x].img = res.data.data.list[x].reply
						}
					}
				}
				if(x==0){
					res.data.data.list[x].showTime = 1
				}else{
					let jian = new Date(res.data.data.list[x].addtime).getTime() - new Date(res.data.data.list[x-1].addtime).getTime()
					if(jian>18000){
						res.data.data.list[x].showTime = 1
					}else{
						res.data.data.list[x].showTime = 0
					}
				}
			}
			chatList.value = res.data.data.list
			nextTick(() => {
				let div = document.getElementsByClassName('chat-content')[0]
				setTimeout(() => {
                    if (div){
                        if(div.scrollTop+div.clientHeight==div.scrollHeight || scrollFlag.value){
                            div.scrollTop = div.scrollHeight
                            scrollFlag.value = false
                        }
                    }
				}, 100)
			})
		}).catch(e=>{
			delTimer()
			console.error(e)
		})
	}
	//发送信息
	const addChat = () => {
		form.value.userid = nowId.value
		form.value.userName = store.state.user.username||localStorage.getItem('adminName')
		form.value.userImage = store.state.user.avatar
		form.value.userTableName = localStorage.getItem('sessionTable')
		form.value.type = 1
		if (form.value.reply) {
			context?.$http({
				url: 'chat/save',
				method: 'post',
				data: form.value
			}).then(res => {
				context.$message.success('发送成功')
				getChatList()
				form.value.reply = ''
			})
		}
	}
	//图片
	const action = ref(`${context?.$config.name}/file/upload`)
	const uploadSuccess = (e) => {
		let type;
		if(/(\.png|\.jpg|\.webp)$/i.test(e.file)){    //图片
			type = 2
		}else if(/(\.mp4)$/i.test(e.file)){   //mp4视频
			type = 3
		}else if(/(\.mp3)$/i.test(e.file)){   //mp3音频
			type = 5
		}else{  //文件
			type = 4
		}
		let params = {
			type:type,
			reply: 'file/' + e.file,
			userid: nowId.value,
			userName:store.state.user.username,
			userImage:store.state.user.avatar,
			userTableName:localStorage.getItem('sessionTable')
		}
		context?.$http({
			url: 'chat/save',
			method: 'post',
			data: params
		}).then(res => {
			context?.$toolUtil.message('发送成功', 'success', () => {
				getChatList()
				form.value.reply = ''

			})
		})
	}
	const downloadFile = (url)=>{
		if(!url){
			return false
		}
		window.open(baseUrl.value + 'file/download?fileName=' + url.replace("file/",''))
	}
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
	// 聊天总盒子
	.chat_view {
		.clear-float {
			clear: both;
		}
	}
</style>