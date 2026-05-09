"use strict";
(self["webpackChunkvue3_nf0"] = self["webpackChunkvue3_nf0"] || []).push([[7513],{

/***/ 1195:
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

// ESM COMPAT FLAG
__webpack_require__.r(__webpack_exports__);

// EXPORTS
__webpack_require__.d(__webpack_exports__, {
  "default": function() { return /* binding */ formAdd; }
});

// EXTERNAL MODULE: ../../../../../../../node_modules_front/1/node_modules/@vue/runtime-core/dist/runtime-core.esm-bundler.js
var runtime_core_esm_bundler = __webpack_require__(4818);
// EXTERNAL MODULE: ../../../../../../../node_modules_front/1/node_modules/@vue/shared/dist/shared.esm-bundler.js
var shared_esm_bundler = __webpack_require__(5406);
// EXTERNAL MODULE: ../../../../../../../node_modules_front/1/node_modules/@vue/reactivity/dist/reactivity.esm-bundler.js
var reactivity_esm_bundler = __webpack_require__(3870);
// EXTERNAL MODULE: ../../../../../../../node_modules_front/1/node_modules/vue-router/dist/vue-router.esm-bundler.js
var vue_router_esm_bundler = __webpack_require__(1503);
// EXTERNAL MODULE: ../../../../../../../node_modules_front/1/node_modules/vuex/dist/vuex.esm-bundler.js + 5 modules
var vuex_esm_bundler = __webpack_require__(231);
// EXTERNAL MODULE: ./src/components/payForm.vue + 13 modules
var payForm = __webpack_require__(5682);
;// CONCATENATED MODULE: ../../../../../../../node_modules_front/1/node_modules/thread-loader/dist/cjs.js!../../../../../../../node_modules_front/1/node_modules/babel-loader/lib/index.js??clonedRuleSet-40.use[1]!../../../../../../../node_modules_front/1/node_modules/vue-loader/dist/index.js??ruleSet[0].use[0]!./src/views/pages/shuikuanjiaona/formAdd.vue?vue&type=script&setup=true&lang=js

const _hoisted_1 = {
  class: "edit_view"
};
const _hoisted_2 = {
  class: "breadcrumb-wrapper",
  style: {
    "width": "100%"
  }
};
const _hoisted_3 = {
  class: "bread_view"
};
const _hoisted_4 = {
  class: "formModel_btn_box"
};




const tableName = 'shuikuanjiaona';
const formName = '税款缴纳';
//基础信息

/* harmony default export */ var formAddvue_type_script_setup_true_lang_js = ({
  __name: 'formAdd',
  setup(__props) {
    const store = (0,vuex_esm_bundler/* useStore */.oR)();
    const user = (0,runtime_core_esm_bundler/* computed */.Fl)(() => store.getters['user/session']);
    const moment = window.moment;
    const context = (0,runtime_core_esm_bundler/* getCurrentInstance */.FN)()?.appContext.config.globalProperties;
    const route = (0,vue_router_esm_bundler/* useRoute */.yj)();
    const router = (0,vue_router_esm_bundler/* useRouter */.tv)();
    //基础信息
    const breadList = (0,reactivity_esm_bundler/* ref */.iH)([{
      name: formName
    }]);
    //获取唯一标识
    const getUUID = () => {
      return new Date().getTime();
    };
    //form表单
    const form = (0,reactivity_esm_bundler/* ref */.iH)({
      nianfen: '',
      yuefen: '',
      xiaoxiangfapiao: '',
      jinxiangfapiao: '',
      yingshou: 0,
      chengbenfeiyong: 0,
      shenbaoshijian: '',
      wanshuipingzheng: '',
      qiyemingcheng: '',
      shuikuanjine: 0,
      reversetime: '',
      zongfeiyong: 0,
      crossuserid: '',
      crossrefid: ''
    });
    const formRef = (0,reactivity_esm_bundler/* ref */.iH)(null);
    const id = (0,reactivity_esm_bundler/* ref */.iH)(0);
    const type = (0,reactivity_esm_bundler/* ref */.iH)('');
    const disabledForm = (0,reactivity_esm_bundler/* ref */.iH)({
      nianfen: false,
      yuefen: false,
      xiaoxiangfapiao: false,
      jinxiangfapiao: false,
      yingshou: false,
      chengbenfeiyong: false,
      shenbaoshijian: false,
      wanshuipingzheng: false,
      qiyemingcheng: false,
      shuikuanjine: false,
      reversetime: false,
      ispay: false,
      zongfeiyong: false,
      crossuserid: false,
      crossrefid: false
    });
    const isAdd = (0,reactivity_esm_bundler/* ref */.iH)(false);
    //表单验证
    const rules = (0,reactivity_esm_bundler/* ref */.iH)({
      nianfen: [{
        required: true,
        message: '请输入',
        trigger: 'blur'
      }],
      yuefen: [{
        required: true,
        message: '请输入',
        trigger: 'blur'
      }],
      xiaoxiangfapiao: [{
        required: true,
        message: '请输入',
        trigger: 'blur'
      }],
      jinxiangfapiao: [],
      yingshou: [{
        validator: context.$toolUtil.validator.number,
        trigger: 'blur'
      }],
      chengbenfeiyong: [{
        validator: context.$toolUtil.validator.number,
        trigger: 'blur'
      }],
      shenbaoshijian: [],
      wanshuipingzheng: [],
      qiyemingcheng: [],
      shuikuanjine: [{
        validator: context.$toolUtil.validator.number,
        trigger: 'blur'
      }],
      reversetime: [],
      ispay: [],
      zongfeiyong: [{
        validator: context.$toolUtil.validator.number,
        trigger: 'blur'
      }],
      crossuserid: [],
      crossrefid: []
    });
    //销项发票上传回调
    const xiaoxiangfapiaoUploadSuccess = e => {
      form.value.xiaoxiangfapiao = e;
    };
    //进项发票上传回调
    const jinxiangfapiaoUploadSuccess = e => {
      form.value.jinxiangfapiao = e;
    };
    //完税凭证上传回调
    const wanshuipingzhengUploadSuccess = e => {
      form.value.wanshuipingzheng = e;
    };
    const zongfeiyong = (0,runtime_core_esm_bundler/* computed */.Fl)(() => {
      let c = form.value;
      let a = Number(c.yingshou) + Number(c.chengbenfeiyong);
      form.value.zongfeiyong = Number(a) ? Number(parseFloat(a).toFixed(2)) : 0;
      return Number(a) ? Number(parseFloat(a).toFixed(2)) : 0;
    });
    const shuikuanjine = (0,runtime_core_esm_bundler/* computed */.Fl)(() => {
      let c = form.value;
      let a = Number(c.zongfeiyong) / 0.2;
      form.value.shuikuanjine = Number(a) ? Number(parseFloat(a).toFixed(2)) : 0;
      return Number(a) ? Number(parseFloat(a).toFixed(2)) : 0;
    });
    //获取info
    const getInfo = () => {
      context?.$http({
        url: `${tableName}/info/${id.value}`,
        method: 'get'
      }).then(res => {
        let reg = new RegExp('../../../file', 'g');
        form.value = res.data.data;
      });
    };
    const crossRow = (0,reactivity_esm_bundler/* ref */.iH)('');
    const crossTable = (0,reactivity_esm_bundler/* ref */.iH)('');
    const crossTips = (0,reactivity_esm_bundler/* ref */.iH)('');
    const crossColumnName = (0,reactivity_esm_bundler/* ref */.iH)('');
    const crossColumnValue = (0,reactivity_esm_bundler/* ref */.iH)('');
    //初始化
    const init = (formId = null, formType = 'add', formNames = '', row = null, table = null, statusColumnName = null, tips = null, statusColumnValue = null) => {
      form.value.shenbaoshijian = context?.$toolUtil.getCurDateTime();
      if (formId) {
        id.value = formId;
        type.value = formType;
      }
      if (formType == 'add') {
        isAdd.value = true;
      } else if (formType == 'info') {
        isAdd.value = false;
        getInfo();
      } else if (formType == 'edit') {
        isAdd.value = true;
        getInfo();
      } else if (formType == 'cross') {
        isAdd.value = true;
        // getInfo()
        for (let x in row) {
          if (x == 'nianfen') {
            form.value.nianfen = row[x];
            disabledForm.value.nianfen = true;
            continue;
          }
          if (x == 'yuefen') {
            form.value.yuefen = row[x];
            disabledForm.value.yuefen = true;
            continue;
          }
          if (x == 'xiaoxiangfapiao') {
            form.value.xiaoxiangfapiao = row[x];
            disabledForm.value.xiaoxiangfapiao = true;
            continue;
          }
          if (x == 'jinxiangfapiao') {
            form.value.jinxiangfapiao = row[x];
            disabledForm.value.jinxiangfapiao = true;
            continue;
          }
          if (x == 'yingshou') {
            form.value.yingshou = row[x];
            disabledForm.value.yingshou = true;
            continue;
          }
          if (x == 'chengbenfeiyong') {
            form.value.chengbenfeiyong = row[x];
            disabledForm.value.chengbenfeiyong = true;
            continue;
          }
          if (x == 'shenbaoshijian') {
            form.value.shenbaoshijian = row[x];
            disabledForm.value.shenbaoshijian = true;
            continue;
          }
          if (x == 'wanshuipingzheng') {
            form.value.wanshuipingzheng = row[x];
            disabledForm.value.wanshuipingzheng = true;
            continue;
          }
          if (x == 'qiyemingcheng') {
            form.value.qiyemingcheng = row[x];
            disabledForm.value.qiyemingcheng = true;
            continue;
          }
          if (x == 'shuikuanjine') {
            form.value.shuikuanjine = row[x];
            disabledForm.value.shuikuanjine = true;
            continue;
          }
          if (x == 'reversetime') {
            form.value.reversetime = row[x];
            disabledForm.value.reversetime = true;
            continue;
          }
          if (x == 'zongfeiyong') {
            form.value.zongfeiyong = row[x];
            disabledForm.value.zongfeiyong = true;
            continue;
          }
          if (x == 'crossuserid') {
            form.value.crossuserid = row[x];
            disabledForm.value.crossuserid = true;
            continue;
          }
          if (x == 'crossrefid') {
            form.value.crossrefid = row[x];
            disabledForm.value.crossrefid = true;
            continue;
          }
        }
        if (row) {
          crossRow.value = row;
        }
        if (table) {
          crossTable.value = table;
        }
        if (tips) {
          crossTips.value = tips;
        }
        if (statusColumnName) {
          crossColumnName.value = statusColumnName;
        }
        if (statusColumnValue) {
          crossColumnValue.value = statusColumnValue;
        }
      }
      context?.$http({
        url: `${context?.$toolUtil.storageGet('frontSessionTable')}/session`,
        method: 'get'
      }).then(res => {
        var json = res.data.data;
        if (json.hasOwnProperty('qiyemingcheng') && context?.$toolUtil.storageGet("frontSessionTable") != "users") {
          form.value.qiyemingcheng = json.qiyemingcheng;
          disabledForm.value.qiyemingcheng = true;
        }
        if (localStorage.getItem('autoSave')) {
          localStorage.removeItem('autoSave');
          save();
        }
      });
    };
    //初始化
    //取消
    const backClick = () => {
      history.back();
    };
    //提交
    const save = () => {
      if (form.value.xiaoxiangfapiao != null) {
        form.value.xiaoxiangfapiao = form.value.xiaoxiangfapiao.replace(new RegExp(context?.$config.url, "g"), "");
      }
      if (form.value.jinxiangfapiao != null) {
        form.value.jinxiangfapiao = form.value.jinxiangfapiao.replace(new RegExp(context?.$config.url, "g"), "");
      }
      if (form.value.wanshuipingzheng != null) {
        form.value.wanshuipingzheng = form.value.wanshuipingzheng.replace(new RegExp(context?.$config.url, "g"), "");
      }
      var table = crossTable.value;
      var objcross = JSON.parse(JSON.stringify(crossRow.value));
      let crossUserId = '';
      let crossRefId = '';
      let crossOptNum = '';
      formRef.value.validate(async valid => {
        if (valid) {
          if (type.value == 'cross') {
            if (crossColumnName.value != '') {
              if (!crossColumnName.value.startsWith('[')) {
                for (let o in objcross) {
                  if (o == crossColumnName.value) {
                    objcross[o] = crossColumnValue.value;
                  }
                }
                //修改跨表数据
                await changeCrossData(objcross);
              } else {
                crossUserId = context?.$toolUtil.storageGet('userid');
                crossRefId = objcross['id'];
                crossOptNum = crossColumnName.value.replace(/\[/, "").replace(/\]/, "");
              }
            }
          }
          if (crossUserId && crossRefId) {
            //限制用户操作次数
            form.value.crossuserid = crossUserId;
            form.value.crossrefid = crossRefId;
            let params = {
              page: 1,
              limit: 1000,
              crossuserid: form.value.crossuserid,
              crossrefid: form.value.crossrefid
            };
            context?.$http({
              url: `${tableName}/page`,
              method: 'get',
              params: params
            }).then(async res => {
              if (res.data.data.total >= crossOptNum) {
                context?.$toolUtil.message(`${crossTips.value}`, 'error');
                return false;
              } else {
                context?.$http({
                  url: `${tableName}/${!form.value.id ? "save" : "update"}`,
                  method: 'post',
                  data: form.value
                }).then(async res => {
                  if (context.$toolUtil.isBackAuth('shuikuanjiaona', '支付')) {
                    context.$http.get(`${tableName}/page?sort=id&order=desc`).then(res1 => {
                      payRef.value.payClick(tableName, res1.data.data.list[0]);
                    });
                    return;
                  }
                  context?.$toolUtil.message(`操作成功`, 'success');
                  history.back();
                });
              }
            });
          } else {
            context?.$http({
              url: `${tableName}/${!form.value.id ? "save" : "update"}`,
              method: 'post',
              data: form.value
            }).then(async res => {
              if (context.$toolUtil.isBackAuth('shuikuanjiaona', '支付')) {
                context.$http.get(`${tableName}/page?sort=id&order=desc`).then(res1 => {
                  payRef.value.payClick(tableName, res1.data.data.list[0]);
                });
                return;
              }
              context?.$toolUtil.message(`操作成功`, 'success');
              history.back();
            });
          }
        }
      });
    };
    const payRef = (0,reactivity_esm_bundler/* ref */.iH)(null);
    const payClose = e => {
      history.back();
    };
    const paySave = async data => {
      data.ispay = '已支付';
      context?.$http({
        url: `${tableName}/update`,
        method: 'post',
        data: data
      }).then(res => {
        context.$message.success('支付成功');
        payRef.value.payVisible = false;
      });
    };
    //修改跨表数据
    const changeCrossData = (row, key) => {
      if (type.value == 'cross') {
        let data = row;
        if (key) {
          //如果有指定key，则只更新key属性
          data = {
            id: row.id
          };
          data[key] = row[key];
        }
        context?.$http({
          url: `${crossTable.value}/update`,
          method: 'post',
          data: data
        }).then(res => {});
      }
    };
    (0,runtime_core_esm_bundler/* onMounted */.bv)(() => {
      type.value = route.query.type ? route.query.type : 'add';
      let row = null;
      let table = null;
      let statusColumnName = null;
      let tips = null;
      let statusColumnValue = null;
      if (type.value == 'cross') {
        row = context?.$toolUtil.storageGet('crossObj') ? JSON.parse(context?.$toolUtil.storageGet('crossObj')) : {};
        table = context?.$toolUtil.storageGet('crossTable');
        statusColumnName = context?.$toolUtil.storageGet('crossStatusColumnName');
        tips = context?.$toolUtil.storageGet('crossTips');
        statusColumnValue = context?.$toolUtil.storageGet('crossStatusColumnValue');
      }
      init(route.query.id ? route.query.id : null, type.value, '', row, table, statusColumnName, tips, statusColumnValue);
    });
    (0,runtime_core_esm_bundler/* onUnmounted */.Ah)(() => {
      Object.keys(localStorage).map(item => {
        if (item.startsWith('cross')) {
          localStorage.removeItem(item);
        }
      });
    });
    return (_ctx, _cache) => {
      const _component_el_breadcrumb_item = (0,runtime_core_esm_bundler/* resolveComponent */.up)("el-breadcrumb-item");
      const _component_el_breadcrumb = (0,runtime_core_esm_bundler/* resolveComponent */.up)("el-breadcrumb");
      const _component_el_input = (0,runtime_core_esm_bundler/* resolveComponent */.up)("el-input");
      const _component_el_form_item = (0,runtime_core_esm_bundler/* resolveComponent */.up)("el-form-item");
      const _component_el_col = (0,runtime_core_esm_bundler/* resolveComponent */.up)("el-col");
      const _component_uploads = (0,runtime_core_esm_bundler/* resolveComponent */.up)("uploads");
      const _component_el_date_picker = (0,runtime_core_esm_bundler/* resolveComponent */.up)("el-date-picker");
      const _component_el_row = (0,runtime_core_esm_bundler/* resolveComponent */.up)("el-row");
      const _component_el_button = (0,runtime_core_esm_bundler/* resolveComponent */.up)("el-button");
      const _component_el_form = (0,runtime_core_esm_bundler/* resolveComponent */.up)("el-form");
      return (0,runtime_core_esm_bundler/* openBlock */.wg)(), (0,runtime_core_esm_bundler/* createElementBlock */.iD)("div", _hoisted_1, [(0,runtime_core_esm_bundler/* createElementVNode */._)("div", _hoisted_2, [(0,runtime_core_esm_bundler/* createElementVNode */._)("div", _hoisted_3, [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_breadcrumb, {
        separator: ":",
        class: "breadcrumb"
      }, {
        default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_breadcrumb_item, {
          class: "first_breadcrumb",
          to: {
            path: '/'
          }
        }, {
          default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => _cache[9] || (_cache[9] = [(0,runtime_core_esm_bundler/* createTextVNode */.Uk)("首页", -1)])),
          _: 1,
          __: [9]
        }), ((0,runtime_core_esm_bundler/* openBlock */.wg)(true), (0,runtime_core_esm_bundler/* createElementBlock */.iD)(runtime_core_esm_bundler/* Fragment */.HY, null, (0,runtime_core_esm_bundler/* renderList */.Ko)(breadList.value, (item, index) => {
          return (0,runtime_core_esm_bundler/* openBlock */.wg)(), (0,runtime_core_esm_bundler/* createBlock */.j4)(_component_el_breadcrumb_item, {
            class: "second_breadcrumb",
            key: index
          }, {
            default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createTextVNode */.Uk)((0,shared_esm_bundler/* toDisplayString */.zw)(item.name), 1)]),
            _: 2
          }, 1024);
        }), 128))]),
        _: 1
      })])]), (0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_form, {
        ref_key: "formRef",
        ref: formRef,
        model: form.value,
        class: "add_form",
        "label-width": "120px",
        rules: rules.value
      }, {
        default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_row, null, {
          default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_col, {
            span: 12
          }, {
            default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_form_item, {
              label: "年份",
              prop: "nianfen"
            }, {
              default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_input, {
                class: "list_inp",
                modelValue: form.value.nianfen,
                "onUpdate:modelValue": _cache[0] || (_cache[0] = $event => form.value.nianfen = $event),
                placeholder: "年份",
                type: "text",
                readonly: !isAdd.value || disabledForm.value.nianfen ? true : false
              }, null, 8, ["modelValue", "readonly"])]),
              _: 1
            })]),
            _: 1
          }), (0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_col, {
            span: 12
          }, {
            default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_form_item, {
              label: "月份",
              prop: "yuefen"
            }, {
              default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_input, {
                class: "list_inp",
                modelValue: form.value.yuefen,
                "onUpdate:modelValue": _cache[1] || (_cache[1] = $event => form.value.yuefen = $event),
                placeholder: "月份",
                type: "text",
                readonly: !isAdd.value || disabledForm.value.yuefen ? true : false
              }, null, 8, ["modelValue", "readonly"])]),
              _: 1
            })]),
            _: 1
          }), (0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_col, {
            span: 12
          }, {
            default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_form_item, {
              label: "销项发票",
              prop: "xiaoxiangfapiao"
            }, {
              default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_uploads, {
                disabled: !isAdd.value || disabledForm.value.xiaoxiangfapiao ? true : false,
                action: "file/upload",
                tip: "请上传销项发票",
                style: {
                  "width": "100%",
                  "text-align": "left"
                },
                fileUrls: form.value.xiaoxiangfapiao ? form.value.xiaoxiangfapiao : '',
                onChange: xiaoxiangfapiaoUploadSuccess
              }, null, 8, ["disabled", "fileUrls"])]),
              _: 1
            })]),
            _: 1
          }), (0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_col, {
            span: 12
          }, {
            default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_form_item, {
              label: "进项发票",
              prop: "jinxiangfapiao"
            }, {
              default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_uploads, {
                disabled: !isAdd.value || disabledForm.value.jinxiangfapiao ? true : false,
                action: "file/upload",
                tip: "请上传进项发票",
                style: {
                  "width": "100%",
                  "text-align": "left"
                },
                fileUrls: form.value.jinxiangfapiao ? form.value.jinxiangfapiao : '',
                onChange: jinxiangfapiaoUploadSuccess
              }, null, 8, ["disabled", "fileUrls"])]),
              _: 1
            })]),
            _: 1
          }), (0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_col, {
            span: 12
          }, {
            default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_form_item, {
              label: "营收",
              prop: "yingshou"
            }, {
              default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_input, {
                class: "list_inp",
                modelValue: form.value.yingshou,
                "onUpdate:modelValue": _cache[2] || (_cache[2] = $event => form.value.yingshou = $event),
                modelModifiers: {
                  number: true
                },
                placeholder: "营收",
                type: "number",
                readonly: !isAdd.value || disabledForm.value.yingshou ? true : false
              }, null, 8, ["modelValue", "readonly"])]),
              _: 1
            })]),
            _: 1
          }), (0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_col, {
            span: 12
          }, {
            default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_form_item, {
              label: "成本费用",
              prop: "chengbenfeiyong"
            }, {
              default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_input, {
                class: "list_inp",
                modelValue: form.value.chengbenfeiyong,
                "onUpdate:modelValue": _cache[3] || (_cache[3] = $event => form.value.chengbenfeiyong = $event),
                modelModifiers: {
                  number: true
                },
                placeholder: "成本费用",
                type: "number",
                readonly: !isAdd.value || disabledForm.value.chengbenfeiyong ? true : false
              }, null, 8, ["modelValue", "readonly"])]),
              _: 1
            })]),
            _: 1
          }), (0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_col, {
            span: 12
          }, {
            default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_form_item, {
              label: "申报时间",
              prop: "shenbaoshijian"
            }, {
              default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_date_picker, {
                class: "list_date",
                modelValue: form.value.shenbaoshijian,
                "onUpdate:modelValue": _cache[4] || (_cache[4] = $event => form.value.shenbaoshijian = $event),
                format: "YYYY-MM-DD HH:mm:ss",
                "value-format": "YYYY-MM-DD HH:mm:ss",
                type: "datetime",
                style: {
                  "width": "100%"
                },
                readonly: !isAdd.value || disabledForm.value.shenbaoshijian ? true : false,
                placeholder: "请选择申报时间"
              }, null, 8, ["modelValue", "readonly"])]),
              _: 1
            })]),
            _: 1
          }), (0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_col, {
            span: 12
          }, {
            default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_form_item, {
              label: "完税凭证",
              prop: "wanshuipingzheng"
            }, {
              default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_uploads, {
                disabled: !isAdd.value || disabledForm.value.wanshuipingzheng ? true : false,
                type: "file",
                action: "file/upload",
                tip: "请上传完税凭证",
                limit: 1,
                style: {
                  "width": "100%",
                  "text-align": "left"
                },
                fileUrls: form.value.wanshuipingzheng ? form.value.wanshuipingzheng : '',
                onChange: wanshuipingzhengUploadSuccess
              }, null, 8, ["disabled", "fileUrls"])]),
              _: 1
            })]),
            _: 1
          }), (0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_col, {
            span: 12
          }, {
            default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_form_item, {
              label: "企业名称",
              prop: "qiyemingcheng"
            }, {
              default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_input, {
                class: "list_inp",
                modelValue: form.value.qiyemingcheng,
                "onUpdate:modelValue": _cache[5] || (_cache[5] = $event => form.value.qiyemingcheng = $event),
                placeholder: "企业名称",
                type: "text",
                readonly: !isAdd.value || disabledForm.value.qiyemingcheng ? true : false
              }, null, 8, ["modelValue", "readonly"])]),
              _: 1
            })]),
            _: 1
          }), (0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_col, {
            span: 12
          }, {
            default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_form_item, {
              label: "税款金额",
              prop: "shuikuanjine"
            }, {
              default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_input, {
                class: "list_inp",
                modelValue: shuikuanjine.value,
                "onUpdate:modelValue": _cache[6] || (_cache[6] = $event => shuikuanjine.value = $event),
                placeholder: "税款金额",
                readonly: ""
              }, null, 8, ["modelValue"])]),
              _: 1
            })]),
            _: 1
          }), (0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_col, {
            span: 12
          }, {
            default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_form_item, {
              label: "失效时间",
              prop: "reversetime"
            }, {
              default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_date_picker, {
                class: "list_date",
                modelValue: form.value.reversetime,
                "onUpdate:modelValue": _cache[7] || (_cache[7] = $event => form.value.reversetime = $event),
                format: "YYYY-MM-DD HH:mm:ss",
                "value-format": "YYYY-MM-DD HH:mm:ss",
                type: "datetime",
                style: {
                  "width": "100%"
                },
                readonly: !isAdd.value || disabledForm.value.reversetime ? true : false,
                placeholder: "请选择失效时间"
              }, null, 8, ["modelValue", "readonly"])]),
              _: 1
            })]),
            _: 1
          }), (0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_col, {
            span: 12
          }, {
            default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_form_item, {
              label: "总费用",
              prop: "zongfeiyong"
            }, {
              default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_input, {
                class: "list_inp",
                modelValue: zongfeiyong.value,
                "onUpdate:modelValue": _cache[8] || (_cache[8] = $event => zongfeiyong.value = $event),
                placeholder: "总费用",
                readonly: ""
              }, null, 8, ["modelValue"])]),
              _: 1
            })]),
            _: 1
          })]),
          _: 1
        }), (0,runtime_core_esm_bundler/* createElementVNode */._)("div", _hoisted_4, [(0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_button, {
          class: "formModel_cancel",
          onClick: backClick
        }, {
          default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => _cache[10] || (_cache[10] = [(0,runtime_core_esm_bundler/* createTextVNode */.Uk)("取消", -1)])),
          _: 1,
          __: [10]
        }), (0,runtime_core_esm_bundler/* createVNode */.Wm)(_component_el_button, {
          class: "formModel_confirm",
          onClick: save,
          type: "success"
        }, {
          default: (0,runtime_core_esm_bundler/* withCtx */.w5)(() => _cache[11] || (_cache[11] = [(0,runtime_core_esm_bundler/* createTextVNode */.Uk)(" 提交 ", -1)])),
          _: 1,
          __: [11]
        }), (0,runtime_core_esm_bundler/* createVNode */.Wm)((0,reactivity_esm_bundler/* unref */.SU)(payForm/* default */.Z), {
          ref_key: "payRef",
          ref: payRef,
          onClose: payClose,
          onPaySave: paySave
        }, null, 512)])]),
        _: 1
      }, 8, ["model", "rules"])]);
    };
  }
});
;// CONCATENATED MODULE: ./src/views/pages/shuikuanjiaona/formAdd.vue?vue&type=script&setup=true&lang=js
 
;// CONCATENATED MODULE: ../../../../../../../node_modules_front/1/node_modules/mini-css-extract-plugin/dist/loader.js??clonedRuleSet-22.use[0]!../../../../../../../node_modules_front/1/node_modules/css-loader/dist/cjs.js??clonedRuleSet-22.use[1]!../../../../../../../node_modules_front/1/node_modules/vue-loader/dist/stylePostLoader.js!../../../../../../../node_modules_front/1/node_modules/postcss-loader/dist/cjs.js??clonedRuleSet-22.use[2]!../../../../../../../node_modules_front/1/node_modules/sass-loader/dist/cjs.js??clonedRuleSet-22.use[3]!../../../../../../../node_modules_front/1/node_modules/vue-loader/dist/index.js??ruleSet[0].use[0]!./src/views/pages/shuikuanjiaona/formAdd.vue?vue&type=style&index=0&id=1f3e136d&lang=scss&scoped=true
// extracted by mini-css-extract-plugin

;// CONCATENATED MODULE: ./src/views/pages/shuikuanjiaona/formAdd.vue?vue&type=style&index=0&id=1f3e136d&lang=scss&scoped=true

;// CONCATENATED MODULE: ../../../../../../../node_modules_front/1/node_modules/mini-css-extract-plugin/dist/loader.js??clonedRuleSet-22.use[0]!../../../../../../../node_modules_front/1/node_modules/css-loader/dist/cjs.js??clonedRuleSet-22.use[1]!../../../../../../../node_modules_front/1/node_modules/vue-loader/dist/stylePostLoader.js!../../../../../../../node_modules_front/1/node_modules/postcss-loader/dist/cjs.js??clonedRuleSet-22.use[2]!../../../../../../../node_modules_front/1/node_modules/sass-loader/dist/cjs.js??clonedRuleSet-22.use[3]!../../../../../../../node_modules_front/1/node_modules/vue-loader/dist/index.js??ruleSet[0].use[0]!./src/views/pages/shuikuanjiaona/formAdd.vue?vue&type=style&index=1&id=1f3e136d&lang=scss
// extracted by mini-css-extract-plugin

;// CONCATENATED MODULE: ./src/views/pages/shuikuanjiaona/formAdd.vue?vue&type=style&index=1&id=1f3e136d&lang=scss

// EXTERNAL MODULE: ../../../../../../../node_modules_front/1/node_modules/vue-loader/dist/exportHelper.js
var exportHelper = __webpack_require__(3815);
;// CONCATENATED MODULE: ./src/views/pages/shuikuanjiaona/formAdd.vue



;



const __exports__ = /*#__PURE__*/(0,exportHelper/* default */.Z)(formAddvue_type_script_setup_true_lang_js, [['__scopeId',"data-v-1f3e136d"]])

/* harmony default export */ var formAdd = (__exports__);

/***/ })

}]);
//# sourceMappingURL=7513.6ee2fc5f.js.map