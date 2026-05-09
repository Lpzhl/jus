"use strict";
(self["webpackChunkvue3_nf0"] = self["webpackChunkvue3_nf0"] || []).push([[6587],{

/***/ 6587:
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

// ESM COMPAT FLAG
__webpack_require__.r(__webpack_exports__);

// EXPORTS
__webpack_require__.d(__webpack_exports__, {
  "default": function() { return /* binding */ register; }
});

// EXTERNAL MODULE: ../../../../../../../node_modules_front/1/node_modules/@vue/runtime-core/dist/runtime-core.esm-bundler.js
var runtime_core_esm_bundler = __webpack_require__(4818);
// EXTERNAL MODULE: ../../../../../../../node_modules_front/1/node_modules/@vue/shared/dist/shared.esm-bundler.js
var shared_esm_bundler = __webpack_require__(5406);
// EXTERNAL MODULE: ../../../../../../../node_modules_front/1/node_modules/@vue/reactivity/dist/reactivity.esm-bundler.js
var reactivity_esm_bundler = __webpack_require__(3870);
// EXTERNAL MODULE: ../../../../../../../node_modules_front/1/node_modules/vue-router/dist/vue-router.esm-bundler.js
var vue_router_esm_bundler = __webpack_require__(1503);
;// CONCATENATED MODULE: ../../../../../../../node_modules_front/1/node_modules/thread-loader/dist/cjs.js!../../../../../../../node_modules_front/1/node_modules/babel-loader/lib/index.js??clonedRuleSet-40.use[1]!../../../../../../../node_modules_front/1/node_modules/vue-loader/dist/index.js??ruleSet[0].use[0]!./src/views/pages/qiye/register.vue?vue&type=script&setup=true&lang=js

const _hoisted_1 = {
  class: "register_view"
};
const _hoisted_2 = {
  class: "form",
  style: {
    "z-index": "1"
  }
};
const _hoisted_3 = {
  class: "projectName"
};
const _hoisted_4 = {
  class: "register_form"
};
const _hoisted_5 = {
  class: "list_item"
};
const _hoisted_6 = {
  class: "list_item"
};
const _hoisted_7 = {
  class: "list_item"
};
const _hoisted_8 = {
  class: "list_item"
};
const _hoisted_9 = {
  class: "list_item"
};
const _hoisted_10 = {
  class: "list_item"
};
const _hoisted_11 = {
  class: "list_item"
};
const _hoisted_12 = {
  class: "list_file_list"
};
const _hoisted_13 = {
  class: "btn"
};


/* harmony default export */ var registervue_type_script_setup_true_lang_js = ({
  __name: 'register',
  setup(__props) {
    const context = (0,runtime_core_esm_bundler/* getCurrentInstance */.FN)()?.appContext.config.globalProperties;
    const projectName = context.$project.projectName;
    //获取注册类型
    const route = (0,vue_router_esm_bundler/* useRoute */.yj)();
    const tableName = (0,reactivity_esm_bundler/* ref */.iH)('qiye');

    //公共方法
    const getUUID = () => {
      return new Date().getTime();
    };
    const registerForm = (0,reactivity_esm_bundler/* ref */.iH)({
      tongyishehuixinyongdaima: getUUID(),
      xingyeleixing: ''
    });
    const qiyexingyeleixingLists = (0,reactivity_esm_bundler/* ref */.iH)([]);
    const init = () => {
      context?.$http({
        url: `option/xingyeleixing/xingyeleixing`,
        method: 'get'
      }).then(res => {
        qiyexingyeleixingLists.value = res.data.data;
      });
    };
    const touxiangUploadSuccess = fileUrls => {
      registerForm.value.touxiang = fileUrls;
    };

    //注册按钮
    const handleRegister = () => {
      let url = tableName.value + "/register";
      if (!registerForm.value.qiyemingcheng) {
        context?.$toolUtil.message(`企业名称不能为空`, 'error');
        return false;
      }
      if (!registerForm.value.qiyedianhua) {
        context?.$toolUtil.message(`企业电话不能为空`, 'error');
        return false;
      }
      if (registerForm.value.qiyedianhua && !context?.$toolUtil.isMobile(registerForm.value.qiyedianhua)) {
        context?.$toolUtil.message(`企业电话应输入手机格式`, 'error');
        return false;
      }
      if (!registerForm.value.tongyishehuixinyongdaima) {
        context?.$toolUtil.message(`统一社会信用代码不能为空`, 'error');
        return false;
      }
      if (!registerForm.value.mima) {
        context?.$toolUtil.message(`密码不能为空`, 'error');
        return false;
      }
      if (registerForm.value.mima != registerForm.value.mima2) {
        context?.$toolUtil.message('两次密码输入不一致', 'error');
        return false;
      }
      if (registerForm.value.touxiang != null) {
        registerForm.value.touxiang = registerForm.value.touxiang.replace(new RegExp(context?.$config.url, "g"), "");
      }
      if (registerForm.value.maxPasswordWrong && !context?.$toolUtil.isIntNumer(registerForm.value.maxPasswordWrong)) {
        context?.$toolUtil.message(`最大密码输错次数应输入整数`, 'error');
        return false;
      }
      if (registerForm.value.isLocked && !context?.$toolUtil.isIntNumer(registerForm.value.isLocked)) {
        context?.$toolUtil.message(`用户锁定状态应输入整数`, 'error');
        return false;
      }
      context?.$http({
        url: url,
        method: 'post',
        data: registerForm.value
      }).then(res => {
        context?.$toolUtil.message('注册成功', 'success', obj => {
          context?.$router.push({
            path: "/login"
          });
        });
      });
    };
    //返回登录
    const close = () => {
      context?.$router.push({
        path: "/login"
      });
    };
    init();
    (0,runtime_core_esm_bundler/* onMounted */.bv)(() => {});
    return (_ctx, _cache) => {
      const _component_el_input = (0,runtime_core_esm_bundler/* resolveComponent */.up)("el-input");
      const _component_el_option = (0,runtime_core_esm_bundler/* resolveComponent */.up)("el-option");
      const _component_el_select = (0,runtime_core_esm_bundler/* resolveComponent */.up)("el-select");
      const _component_uploads = (0,runtime_core_esm_bundler/* resolveComponent */.up)("uploads");
      const _component_el_button = (0,runtime_core_esm_bundler/* resolveComponent */.up)("el-button");
      return (0,runtime_core_esm_bundler/* openBlock */.wg)(), (0,runtime_core_esm_bundler/* createElementBlock */.iD)("div", _hoisted_1, [(0,runtime_core_esm_bundler/* createElementVNode */._)("div", _hoisted_2, [_cache[14] || (_cache[14] = (0,runtime_core_esm_bundler/* createElementVNode */._)("div", {
        class: "logo"
      }, null, -1)), (0,runtime_core_esm_bundler/* createElementVNode */._)("div", _hoisted_3, (0,shared_esm_bundler/* toDisplayString */.zw)((0,reactivity_esm_bundler/* unref */.SU)(projectName)) + "注册", 1), (0,runtime_core_esm_bundler/* createElementVNode */._)("div", _hoisted_4, [(0,runtime_core_esm_bundler/* createElementVNode */._)("div", _hoisted_5, [_cache[6] || (_cache[6] = (0,runtime_core_esm_bundler/* createElementVNode */._)("div", {
        class: "list_label"
      }, "企业名称：", -1)), (0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_input, {
        class: "list_inp",
        modelValue: registerForm.value.qiyemingcheng,
        "onUpdate:modelValue": _cache[0] || (_cache[0] = $event => registerForm.value.qiyemingcheng = $event),
        placeholder: "请输入企业名称",
        type: "text"
      }, null, 8, ["modelValue"])]), (0,runtime_core_esm_bundler/* createElementVNode */._)("div", _hoisted_6, [_cache[7] || (_cache[7] = (0,runtime_core_esm_bundler/* createElementVNode */._)("div", {
        class: "list_label"
      }, "企业电话：", -1)), (0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_input, {
        class: "list_inp",
        modelValue: registerForm.value.qiyedianhua,
        "onUpdate:modelValue": _cache[1] || (_cache[1] = $event => registerForm.value.qiyedianhua = $event),
        placeholder: "请输入企业电话",
        type: "text"
      }, null, 8, ["modelValue"])]), (0,runtime_core_esm_bundler/* createElementVNode */._)("div", _hoisted_7, [_cache[8] || (_cache[8] = (0,runtime_core_esm_bundler/* createElementVNode */._)("div", {
        class: "list_label"
      }, "统一社会信用代码：", -1)), (0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_input, {
        class: "list_inp",
        modelValue: registerForm.value.tongyishehuixinyongdaima,
        "onUpdate:modelValue": _cache[2] || (_cache[2] = $event => registerForm.value.tongyishehuixinyongdaima = $event),
        placeholder: "请输入统一社会信用代码",
        type: "text"
      }, null, 8, ["modelValue"])]), (0,runtime_core_esm_bundler/* createElementVNode */._)("div", _hoisted_8, [_cache[9] || (_cache[9] = (0,runtime_core_esm_bundler/* createElementVNode */._)("div", {
        class: "list_label"
      }, "密码：", -1)), (0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_input, {
        class: "list_inp",
        modelValue: registerForm.value.mima,
        "onUpdate:modelValue": _cache[3] || (_cache[3] = $event => registerForm.value.mima = $event),
        placeholder: "请输入密码",
        type: "password",
        "show-password": ""
      }, null, 8, ["modelValue"])]), (0,runtime_core_esm_bundler/* createElementVNode */._)("div", _hoisted_9, [_cache[10] || (_cache[10] = (0,runtime_core_esm_bundler/* createElementVNode */._)("div", {
        class: "list_label"
      }, "确认密码：", -1)), (0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_input, {
        class: "list_inp",
        modelValue: registerForm.value.mima2,
        "onUpdate:modelValue": _cache[4] || (_cache[4] = $event => registerForm.value.mima2 = $event),
        type: "password",
        placeholder: "请输入确认密码",
        "show-password": ""
      }, null, 8, ["modelValue"])]), (0,runtime_core_esm_bundler/* createElementVNode */._)("div", _hoisted_10, [_cache[11] || (_cache[11] = (0,runtime_core_esm_bundler/* createElementVNode */._)("div", {
        class: "list_label"
      }, "行业类型：", -1)), (0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_select, {
        class: "list_sel",
        modelValue: registerForm.value.xingyeleixing,
        "onUpdate:modelValue": _cache[5] || (_cache[5] = $event => registerForm.value.xingyeleixing = $event),
        placeholder: "请选择行业类型"
      }, {
        default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [((0,runtime_core_esm_bundler/* openBlock */.wg)(true), (0,runtime_core_esm_bundler/* createElementBlock */.iD)(runtime_core_esm_bundler/* Fragment */.HY, null, (0,runtime_core_esm_bundler/* renderList */.Ko)(qiyexingyeleixingLists.value, item => {
          return (0,runtime_core_esm_bundler/* openBlock */.wg)(), (0,runtime_core_esm_bundler/* createBlock */.j4)(_component_el_option, {
            label: item,
            value: item
          }, null, 8, ["label", "value"]);
        }), 256))]),
        _: 1
      }, 8, ["modelValue"])]), (0,runtime_core_esm_bundler/* createElementVNode */._)("div", _hoisted_11, [_cache[12] || (_cache[12] = (0,runtime_core_esm_bundler/* createElementVNode */._)("div", {
        class: "list_label"
      }, "头像：", -1)), (0,runtime_core_esm_bundler/* createElementVNode */._)("div", _hoisted_12, [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_uploads, {
        action: "file/upload",
        tip: "请上传头像",
        fileUrls: registerForm.value.touxiang ? registerForm.value.touxiang : '',
        onChange: touxiangUploadSuccess
      }, null, 8, ["fileUrls"])])])]), (0,runtime_core_esm_bundler/* createElementVNode */._)("div", _hoisted_13, [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_button, {
        class: "register",
        onClick: handleRegister
      }, {
        default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => _cache[13] || (_cache[13] = [(0,runtime_core_esm_bundler/* createTextVNode */.Uk)("注册", -1)])),
        _: 1,
        __: [13]
      })]), (0,runtime_core_esm_bundler/* createElementVNode */._)("div", {
        class: "back",
        onClick: close
      }, "已有账号，直接登录"), _cache[15] || (_cache[15] = (0,runtime_core_esm_bundler/* createElementVNode */._)("div", {
        class: "form-circle1"
      }, null, -1)), _cache[16] || (_cache[16] = (0,runtime_core_esm_bundler/* createElementVNode */._)("div", {
        class: "form-circle2"
      }, null, -1))]), _cache[17] || (_cache[17] = (0,runtime_core_esm_bundler/* createElementVNode */._)("div", {
        class: "circle1"
      }, null, -1)), _cache[18] || (_cache[18] = (0,runtime_core_esm_bundler/* createElementVNode */._)("div", {
        class: "circle2"
      }, null, -1))]);
    };
  }
});
;// CONCATENATED MODULE: ./src/views/pages/qiye/register.vue?vue&type=script&setup=true&lang=js
 
;// CONCATENATED MODULE: ../../../../../../../node_modules_front/1/node_modules/mini-css-extract-plugin/dist/loader.js??clonedRuleSet-22.use[0]!../../../../../../../node_modules_front/1/node_modules/css-loader/dist/cjs.js??clonedRuleSet-22.use[1]!../../../../../../../node_modules_front/1/node_modules/vue-loader/dist/stylePostLoader.js!../../../../../../../node_modules_front/1/node_modules/postcss-loader/dist/cjs.js??clonedRuleSet-22.use[2]!../../../../../../../node_modules_front/1/node_modules/sass-loader/dist/cjs.js??clonedRuleSet-22.use[3]!../../../../../../../node_modules_front/1/node_modules/vue-loader/dist/index.js??ruleSet[0].use[0]!./src/views/pages/qiye/register.vue?vue&type=style&index=0&id=cc94bfee&lang=scss
// extracted by mini-css-extract-plugin

;// CONCATENATED MODULE: ./src/views/pages/qiye/register.vue?vue&type=style&index=0&id=cc94bfee&lang=scss

;// CONCATENATED MODULE: ./src/views/pages/qiye/register.vue



;

const __exports__ = registervue_type_script_setup_true_lang_js;

/* harmony default export */ var register = (__exports__);

/***/ })

}]);
//# sourceMappingURL=6587.2a15bf72.js.map