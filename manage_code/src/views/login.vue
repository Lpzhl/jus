<template>
  <div class="login-page">
    <!-- 左侧品牌区域 -->
    <div class="login-brand">
      <div class="brand-content">
        <div class="brand-icon">
          <svg viewBox="0 0 64 64" fill="none" xmlns="http://www.w3.org/2000/svg">
            <rect x="8" y="12" width="48" height="40" rx="4" stroke="white" stroke-width="3"/>
            <path d="M8 20h48" stroke="white" stroke-width="3"/>
            <path d="M20 28v18" stroke="white" stroke-width="3"/>
            <path d="M32 28v18" stroke="white" stroke-width="3"/>
            <path d="M44 28v18" stroke="white" stroke-width="3"/>
            <path d="M14 34h4M26 34h4M38 34h4" stroke="white" stroke-width="2"/>
            <path d="M14 40h4M26 40h4M38 40h4" stroke="white" stroke-width="2"/>
            <path d="M14 46h4M26 46h4M38 46h4" stroke="white" stroke-width="2"/>
          </svg>
        </div>
        <h1 class="brand-title">小企业智能税务管理系统</h1>
        <p class="brand-desc">智能化税务管理，让企业财税更简单</p>
        <div class="brand-features">
          <div class="feature-item">
            <span class="feature-dot"></span>
            <span>智能税务申报</span>
          </div>
          <div class="feature-item">
            <span class="feature-dot"></span>
            <span>财务数据分析</span>
          </div>
          <div class="feature-item">
            <span class="feature-dot"></span>
            <span>合规风险预警</span>
          </div>
        </div>
      </div>
      <div class="brand-decoration">
        <div class="deco-circle deco-circle-1"></div>
        <div class="deco-circle deco-circle-2"></div>
        <div class="deco-circle deco-circle-3"></div>
      </div>
    </div>

    <!-- 右侧登录表单 -->
    <div class="login-form-wrapper">
      <div class="login-form-container">
        <h2 class="form-title">欢迎登录</h2>
        <p class="form-subtitle">请输入您的账号信息</p>

        <!-- 角色选择 -->
        <div class="role-selector" v-if="userList.length > 1">
          <label class="field-label">选择角色</label>
          <div class="role-tabs">
            <div
              class="role-tab"
              :class="{ active: loginForm.role === item.roleName }"
              v-for="(item, index) in userList"
              :key="index"
              @click="tabClick(item.roleName)"
            >{{ item.roleName }}</div>
          </div>
        </div>

        <!-- 账号输入 -->
        <div class="form-field" v-if="loginType == 1">
          <label class="field-label">账号</label>
          <el-input
            v-model="loginForm.username"
            placeholder="请输入账号"
            name="username"
            size="large"
            prefix-icon="User"
          />
        </div>

        <!-- 密码输入 -->
        <div class="form-field" v-if="loginType == 1">
          <label class="field-label">密码</label>
          <el-input
            v-model="loginForm.password"
            type="password"
            show-password
            placeholder="请输入密码"
            size="large"
            prefix-icon="Lock"
            @keydown.enter.native="handleLogin"
          />
        </div>

        <!-- 登录按钮 -->
        <el-button
          class="login-btn"
          type="primary"
          size="large"
          v-if="loginType == 1"
          @click="handleLogin"
        >登 录</el-button>
      </div>
    </div>
  </div>
</template>
<script setup>
import {
  ref,
  getCurrentInstance,
  onMounted,
} from "vue";
import { useStore } from 'vuex'

const store = useStore()
const projectName = ref('小企业智能税务管理系统')
const userList = ref([])
const menus = ref([])
const loginForm = ref({
  role: '',
  username: '',
  password: ''
})
const tableName = ref('')
const loginType = ref(1)
const context = getCurrentInstance()?.appContext.config.globalProperties;

const tabClick = (role) => {
  loginForm.value.role = role
}

const handleLogin = () => {
  if (!loginForm.value.username) {
    context?.$toolUtil.message('请输入用户名', 'error')
    return;
  }
  if (!loginForm.value.password) {
    context?.$toolUtil.message('请输入密码', 'error')
    return;
  }
  if (userList.value.length > 1) {
    if (!loginForm.value.role) {
      context?.$toolUtil.message('请选择角色', 'error')
      return;
    }
    for (let i = 0; i < menus.value.length; i++) {
      if (menus.value[i].roleName == loginForm.value.role) {
        tableName.value = menus.value[i].pathName || menus.value[i].tableName;
      }
    }
  } else {
    tableName.value = userList.value[0].pathName || userList.value[0].tableName;
    loginForm.value.role = userList.value[0].roleName;
  }
  login()
}
const login = () => {
  context?.$http({
    url: `${tableName.value}/login?username=${loginForm.value.username}&password=${loginForm.value.password}`,
    method: 'post'
  }).then(res => {
    context?.$toolUtil.storageSet("Token", res.data.token);
    context?.$toolUtil.storageSet("role", loginForm.value.role);
    context?.$toolUtil.storageSet("sessionTable", tableName.value);
    if (tableName.value == 'qiye') {
      context?.$toolUtil.storageSet("isAdmin", 1);
    }
    context?.$toolUtil.storageSet("adminName", loginForm.value.username);
    store.dispatch('user/getSession').then(res => {
      context?.$router.push('/')
    })
  }, err => {
  })
}

const getMenu = () => {
  let params = {
    page: 1,
    limit: 1,
    sort: 'id',
  }
  context?.$http({
    url: "menu/list",
    method: "get",
    params: params
  }).then(res => {
    menus.value = JSON.parse(res.data.data.list[0].menujson)
    for (let i = 0; i < menus.value.length; i++) {
      if (menus.value[i].hasBackLogin == '是') {
        userList.value.push(menus.value[i])
      }
    }
    loginForm.value.role = userList.value[0].roleName
    context?.$toolUtil.storageSet("menus", JSON.stringify(menus.value));
  })
}

onMounted(() => {
  getMenu()
})
</script>
<style lang="scss" scoped>
.login-page {
  display: flex;
  height: 100vh;
  overflow: hidden;
}

/* 左侧品牌区域 */
.login-brand {
  flex: 1;
  background: linear-gradient(135deg, #1a73e8 0%, #0d47a1 100%);
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
  overflow: hidden;
  padding: 60px;
}

.brand-content {
  position: relative;
  z-index: 2;
  color: #fff;
}

.brand-icon {
  width: 80px;
  height: 80px;
  margin-bottom: 32px;

  svg {
    width: 100%;
    height: 100%;
  }
}

.brand-title {
  font-size: 32px;
  font-weight: 700;
  margin: 0 0 12px 0;
  letter-spacing: 1px;
}

.brand-desc {
  font-size: 16px;
  opacity: 0.85;
  margin: 0 0 48px 0;
}
.brand-features {
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.feature-item {
  display: flex;
  align-items: center;
  gap: 12px;
  font-size: 15px;
  opacity: 0.9;
}

.feature-dot {
  width: 8px;
  height: 8px;
  background: rgba(255, 255, 255, 0.8);
  border-radius: 50%;
  flex-shrink: 0;
}

/* 装饰圆 */
.brand-decoration {
  position: absolute;
  inset: 0;
  pointer-events: none;
}

.deco-circle {
  position: absolute;
  border-radius: 50%;
  background: rgba(255, 255, 255, 0.06);
}

.deco-circle-1 {
  width: 300px;
  height: 300px;
  top: -80px;
  right: -60px;
}

.deco-circle-2 {
  width: 200px;
  height: 200px;
  bottom: -40px;
  left: -60px;
}

.deco-circle-3 {
  width: 120px;
  height: 120px;
  bottom: 20%;
  right: 10%;
}

/* 右侧表单区域 */
.login-form-wrapper {
  width: 480px;
  display: flex;
  align-items: center;
  justify-content: center;
  background: #fff;
  padding: 60px;
}

.login-form-container {
  width: 100%;
  max-width: 360px;
}

.form-title {
  font-size: 28px;
  font-weight: 700;
  color: #1a1a1a;
  margin: 0 0 8px 0;
}

.form-subtitle {
  font-size: 14px;
  color: #999;
  margin: 0 0 40px 0;
}

/* 角色选择 */
.role-selector {
  margin-bottom: 24px;
}

.role-tabs {
  display: flex;
  gap: 8px;
  background: #f5f7fa;
  padding: 4px;
  border-radius: 8px;
}

.role-tab {
  flex: 1;
  text-align: center;
  padding: 8px 12px;
  border-radius: 6px;
  cursor: pointer;
  font-size: 14px;
  color: #666;
  transition: all 0.25s ease;

  &:hover {
    color: #1a73e8;
  }

  &.active {
    background: #1a73e8;
    color: #fff;
    box-shadow: 0 2px 8px rgba(26, 115, 232, 0.3);
  }
}

/* 表单字段 */
.form-field {
  margin-bottom: 24px;
}

.field-label {
  display: block;
  font-size: 14px;
  font-weight: 500;
  color: #333;
  margin-bottom: 8px;
}

.form-field :deep(.el-input__wrapper) {
  border-radius: 8px;
  box-shadow: 0 0 0 1px #dcdfe6 inset;
  padding: 4px 12px;
  transition: box-shadow 0.25s ease;

  &:hover {
    box-shadow: 0 0 0 1px #b0b8c4 inset;
  }

  &.is-focus {
    box-shadow: 0 0 0 2px #1a73e8 inset;
  }
}

/* 登录按钮 */
.login-btn {
  width: 100%;
  height: 48px;
  font-size: 16px;
  font-weight: 600;
  border-radius: 8px;
  margin-top: 16px;
  background: #1a73e8;
  border-color: #1a73e8;
  letter-spacing: 4px;

  &:hover,
  &:focus {
    background: #1557b0;
    border-color: #1557b0;
  }
}

/* 响应式适配 */
@media (max-width: 900px) {
  .login-page {
    flex-direction: column;
  }

  .login-brand {
    display: none;
  }

  .login-form-wrapper {
    width: 100%;
    flex: 1;
  }
}
</style>
