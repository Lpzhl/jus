"use strict";
(self["webpackChunkvue3_nb0"] = self["webpackChunkvue3_nb0"] || []).push([[419],{

/***/ 2419:
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {


// EXPORTS
__webpack_require__.d(__webpack_exports__, {
  A: () => (/* binding */ formModel)
});

// EXTERNAL MODULE: ../../../../../../../node_modules_admin/1/node_modules/@babel/runtime/helpers/esm/toConsumableArray.js + 3 modules
var toConsumableArray = __webpack_require__(7525);
// EXTERNAL MODULE: ../../../../../../../node_modules_admin/1/node_modules/@babel/runtime/helpers/esm/regenerator.js + 1 modules
var regenerator = __webpack_require__(8331);
// EXTERNAL MODULE: ../../../../../../../node_modules_admin/1/node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js
var asyncToGenerator = __webpack_require__(7783);
// EXTERNAL MODULE: ../../../../../../../node_modules_admin/1/node_modules/core-js/modules/es.array.concat.js
var es_array_concat = __webpack_require__(9534);
// EXTERNAL MODULE: ../../../../../../../node_modules_admin/1/node_modules/core-js/modules/es.date.to-json.js
var es_date_to_json = __webpack_require__(8615);
// EXTERNAL MODULE: ../../../../../../../node_modules_admin/1/node_modules/core-js/modules/es.date.to-string.js
var es_date_to_string = __webpack_require__(3620);
// EXTERNAL MODULE: ../../../../../../../node_modules_admin/1/node_modules/core-js/modules/es.json.stringify.js
var es_json_stringify = __webpack_require__(9594);
// EXTERNAL MODULE: ../../../../../../../node_modules_admin/1/node_modules/core-js/modules/es.object.keys.js
var es_object_keys = __webpack_require__(5604);
// EXTERNAL MODULE: ../../../../../../../node_modules_admin/1/node_modules/core-js/modules/es.regexp.constructor.js
var es_regexp_constructor = __webpack_require__(6316);
// EXTERNAL MODULE: ../../../../../../../node_modules_admin/1/node_modules/core-js/modules/es.regexp.exec.js
var es_regexp_exec = __webpack_require__(1771);
// EXTERNAL MODULE: ../../../../../../../node_modules_admin/1/node_modules/core-js/modules/es.regexp.sticky.js
var es_regexp_sticky = __webpack_require__(9181);
// EXTERNAL MODULE: ../../../../../../../node_modules_admin/1/node_modules/core-js/modules/es.regexp.to-string.js
var es_regexp_to_string = __webpack_require__(8713);
// EXTERNAL MODULE: ../../../../../../../node_modules_admin/1/node_modules/core-js/modules/es.string.replace.js
var es_string_replace = __webpack_require__(4292);
// EXTERNAL MODULE: ../../../../../../../node_modules_admin/1/node_modules/core-js/modules/es.string.starts-with.js
var es_string_starts_with = __webpack_require__(372);
// EXTERNAL MODULE: ../../../../../../../node_modules_admin/1/node_modules/@vue/runtime-core/dist/runtime-core.esm-bundler.js
var runtime_core_esm_bundler = __webpack_require__(3308);
// EXTERNAL MODULE: ../../../../../../../node_modules_admin/1/node_modules/@vue/runtime-dom/dist/runtime-dom.esm-bundler.js
var runtime_dom_esm_bundler = __webpack_require__(1974);
// EXTERNAL MODULE: ../../../../../../../node_modules_admin/1/node_modules/@vue/reactivity/dist/reactivity.esm-bundler.js
var reactivity_esm_bundler = __webpack_require__(604);
// EXTERNAL MODULE: ../../../../../../../node_modules_admin/1/node_modules/vuex/dist/vuex.esm-bundler.js + 5 modules
var vuex_esm_bundler = __webpack_require__(923);
;// ../../../../../../../node_modules_admin/1/node_modules/thread-loader/dist/cjs.js!../../../../../../../node_modules_admin/1/node_modules/babel-loader/lib/index.js??clonedRuleSet-40.use[1]!../../../../../../../node_modules_admin/1/node_modules/vue-loader/dist/index.js??ruleSet[0].use[0]!./src/views/shenbaohuizhi/formModel.vue?vue&type=script&setup=true&lang=js















var _hoisted_1 = {
  "class": "formModel_btn_box"
};


var tableName = 'shenbaohuizhi';
var formName = '申报回执';
//基础信息
//form表单

/* harmony default export */ const formModelvue_type_script_setup_true_lang_js = ({
  __name: 'formModel',
  emits: ['formModelChange'],
  setup: function setup(__props, _ref) {
    var _getCurrentInstance;
    var __expose = _ref.expose,
      __emit = _ref.emit;
    var moment = window.moment;
    var store = (0,vuex_esm_bundler/* useStore */.Pj)();
    var user = (0,runtime_core_esm_bundler/* computed */.EW)(function () {
      return store.getters['user/session'];
    });
    var context = (_getCurrentInstance = (0,runtime_core_esm_bundler/* getCurrentInstance */.nI)()) === null || _getCurrentInstance === void 0 ? void 0 : _getCurrentInstance.appContext.config.globalProperties;
    var emit = __emit;
    var isAdmin = localStorage.getItem('isAdmin') || context.$toolUtil.storageGet("sessionTable") == 'users';
    //基础信息
    var form = (0,reactivity_esm_bundler/* ref */.KR)({});
    var disabledForm = (0,reactivity_esm_bundler/* ref */.KR)({
      nianfen: false,
      yuefen: false,
      xiaoxiangfapiao: false,
      jinxiangfapiao: false,
      yingshou: false,
      chengbenfeiyong: false,
      shenbaoshijian: false,
      qiyemingcheng: false,
      shenbaohuizhi: false,
      beizhu: false
    });
    var formVisible = (0,reactivity_esm_bundler/* ref */.KR)(false);
    var isAdd = (0,reactivity_esm_bundler/* ref */.KR)(false);
    var formTitle = (0,reactivity_esm_bundler/* ref */.KR)('');
    var rules = (0,reactivity_esm_bundler/* ref */.KR)({
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
      qiyemingcheng: [],
      shenbaohuizhi: [],
      beizhu: []
    });
    //表单验证

    var formRef = (0,reactivity_esm_bundler/* ref */.KR)(null);
    var id = (0,reactivity_esm_bundler/* ref */.KR)(0);
    var type = (0,reactivity_esm_bundler/* ref */.KR)('');
    //销项发票上传回调
    var xiaoxiangfapiaoUploadSuccess = function xiaoxiangfapiaoUploadSuccess(e) {
      form.value.xiaoxiangfapiao = e;
    };
    //进项发票上传回调
    var jinxiangfapiaoUploadSuccess = function jinxiangfapiaoUploadSuccess(e) {
      form.value.jinxiangfapiao = e;
    };
    //申报回执上传回调
    var shenbaohuizhiUploadSuccess = function shenbaohuizhiUploadSuccess(e) {
      form.value.shenbaohuizhi = e;
    };
    //获取唯一标识
    var getUUID = function getUUID() {
      return new Date().getTime();
    };
    //重置
    var resetForm = function resetForm() {
      form.value = {
        nianfen: '',
        yuefen: '',
        xiaoxiangfapiao: '',
        jinxiangfapiao: '',
        yingshou: '',
        chengbenfeiyong: '',
        shenbaoshijian: '',
        qiyemingcheng: '',
        shenbaohuizhi: '',
        beizhu: ''
      };
    };
    //获取info
    var getInfo = function getInfo() {
      context === null || context === void 0 || context.$http({
        url: "".concat(tableName, "/info/").concat(id.value),
        method: 'get'
      }).then(function (res) {
        var reg = new RegExp('../../../file', 'g');
        form.value = res.data.data;
        formVisible.value = true;
      });
    };
    var crossRow = (0,reactivity_esm_bundler/* ref */.KR)('');
    var crossTable = (0,reactivity_esm_bundler/* ref */.KR)('');
    var crossTips = (0,reactivity_esm_bundler/* ref */.KR)('');
    var crossColumnName = (0,reactivity_esm_bundler/* ref */.KR)('');
    var crossColumnValue = (0,reactivity_esm_bundler/* ref */.KR)('');
    //初始化
    var init = function init() {
      var formId = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : null;
      var formType = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 'add';
      var formNames = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : '';
      var row = arguments.length > 3 && arguments[3] !== undefined ? arguments[3] : null;
      var table = arguments.length > 4 && arguments[4] !== undefined ? arguments[4] : null;
      var statusColumnName = arguments.length > 5 && arguments[5] !== undefined ? arguments[5] : null;
      var tips = arguments.length > 6 && arguments[6] !== undefined ? arguments[6] : null;
      var statusColumnValue = arguments.length > 7 && arguments[7] !== undefined ? arguments[7] : null;
      resetForm();
      form.value.shenbaoshijian = context === null || context === void 0 ? void 0 : context.$toolUtil.getCurDateTime();
      if (formId) {
        id.value = formId;
        type.value = formType;
      }
      if (formType == 'add') {
        isAdd.value = true;
        formTitle.value = '新增' + formName;
        formVisible.value = true;
      } else if (formType == 'info') {
        isAdd.value = false;
        formTitle.value = '查看' + formName;
        getInfo();
      } else if (formType == 'edit') {
        isAdd.value = true;
        formTitle.value = '修改' + formName;
        getInfo();
      } else if (formType == 'cross') {
        isAdd.value = true;
        formTitle.value = formNames;
        // getInfo()
        for (var x in row) {
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
          if (x == 'qiyemingcheng') {
            form.value.qiyemingcheng = row[x];
            disabledForm.value.qiyemingcheng = true;
            continue;
          }
          if (x == 'shenbaohuizhi') {
            form.value.shenbaohuizhi = row[x];
            disabledForm.value.shenbaohuizhi = true;
            continue;
          }
          if (x == 'beizhu') {
            form.value.beizhu = row[x];
            disabledForm.value.beizhu = true;
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
        formVisible.value = true;
      }
      context === null || context === void 0 || context.$http({
        url: "".concat(context === null || context === void 0 ? void 0 : context.$toolUtil.storageGet('sessionTable'), "/session"),
        method: 'get'
      }).then(function (res) {
        var json = res.data.data;
        if (json.hasOwnProperty('qiyemingcheng') && (context === null || context === void 0 ? void 0 : context.$toolUtil.storageGet("sessionTable")) != "users") {
          form.value.qiyemingcheng = json.qiyemingcheng;
          disabledForm.value.qiyemingcheng = true;
        }
      });
    };
    //初始化
    //声明父级调用
    __expose({
      init: init
    });
    //关闭
    var closeClick = function closeClick() {
      formVisible.value = false;
    };
    //富文本
    var editorChange = function editorChange(e, name) {
      form.value[name] = e;
    };
    //提交
    var save = /*#__PURE__*/function () {
      var _ref2 = (0,asyncToGenerator/* default */.A)(/*#__PURE__*/(0,regenerator/* default */.A)().m(function _callee5() {
        var table, objcross, crossUserId, crossRefId, crossOptNum;
        return (0,regenerator/* default */.A)().w(function (_context5) {
          while (1) switch (_context5.n) {
            case 0:
              if (form.value.xiaoxiangfapiao != null) {
                form.value.xiaoxiangfapiao = form.value.xiaoxiangfapiao.replace(new RegExp(context === null || context === void 0 ? void 0 : context.$config.url, "g"), "");
              }
              if (form.value.jinxiangfapiao != null) {
                form.value.jinxiangfapiao = form.value.jinxiangfapiao.replace(new RegExp(context === null || context === void 0 ? void 0 : context.$config.url, "g"), "");
              }
              if (form.value.shenbaohuizhi != null) {
                form.value.shenbaohuizhi = form.value.shenbaohuizhi.replace(new RegExp(context === null || context === void 0 ? void 0 : context.$config.url, "g"), "");
              }
              table = crossTable.value;
              objcross = JSON.parse(JSON.stringify(crossRow.value));
              crossUserId = '';
              crossRefId = '';
              crossOptNum = '';
              formRef.value.validate(/*#__PURE__*/function () {
                var _ref3 = (0,asyncToGenerator/* default */.A)(/*#__PURE__*/(0,regenerator/* default */.A)().m(function _callee4(valid) {
                  var o, params;
                  return (0,regenerator/* default */.A)().w(function (_context4) {
                    while (1) switch (_context4.n) {
                      case 0:
                        if (!valid) {
                          _context4.n = 4;
                          break;
                        }
                        if (!(type.value == 'cross')) {
                          _context4.n = 3;
                          break;
                        }
                        if (!(crossColumnName.value != '')) {
                          _context4.n = 3;
                          break;
                        }
                        if (crossColumnName.value.startsWith('[')) {
                          _context4.n = 2;
                          break;
                        }
                        for (o in objcross) {
                          if (o == crossColumnName.value) {
                            objcross[o] = crossColumnValue.value;
                          }
                        }
                        //修改跨表数据
                        _context4.n = 1;
                        return changeCrossData(objcross);
                      case 1:
                        _context4.n = 3;
                        break;
                      case 2:
                        crossUserId = user.value.id;
                        crossRefId = objcross['id'];
                        crossOptNum = crossColumnName.value.replace(/\[/, "").replace(/\]/, "");
                      case 3:
                        if (crossUserId && crossRefId) {
                          form.value.crossuserid = crossUserId;
                          form.value.crossrefid = crossRefId;
                          params = {
                            page: 1,
                            limit: 1000,
                            crossuserid: form.value.crossuserid,
                            crossrefid: form.value.crossrefid
                          };
                          context === null || context === void 0 || context.$http({
                            url: "".concat(tableName, "/page"),
                            method: 'get',
                            params: params
                          }).then(/*#__PURE__*/function () {
                            var _ref4 = (0,asyncToGenerator/* default */.A)(/*#__PURE__*/(0,regenerator/* default */.A)().m(function _callee2(res) {
                              return (0,regenerator/* default */.A)().w(function (_context2) {
                                while (1) switch (_context2.n) {
                                  case 0:
                                    if (!(res.data.data.total >= crossOptNum)) {
                                      _context2.n = 1;
                                      break;
                                    }
                                    context === null || context === void 0 || context.$toolUtil.message("".concat(crossTips.value), 'error');
                                    return _context2.a(2, false);
                                  case 1:
                                    context === null || context === void 0 || context.$http({
                                      url: "".concat(tableName, "/").concat(!form.value.id ? "save" : "update"),
                                      method: 'post',
                                      data: form.value
                                    }).then(/*#__PURE__*/function () {
                                      var _ref5 = (0,asyncToGenerator/* default */.A)(/*#__PURE__*/(0,regenerator/* default */.A)().m(function _callee(res) {
                                        return (0,regenerator/* default */.A)().w(function (_context) {
                                          while (1) switch (_context.n) {
                                            case 0:
                                              emit('formModelChange');
                                              context === null || context === void 0 || context.$toolUtil.message("\u64CD\u4F5C\u6210\u529F", 'success');
                                              formVisible.value = false;
                                            case 1:
                                              return _context.a(2);
                                          }
                                        }, _callee);
                                      }));
                                      return function (_x3) {
                                        return _ref5.apply(this, arguments);
                                      };
                                    }());
                                  case 2:
                                    return _context2.a(2);
                                }
                              }, _callee2);
                            }));
                            return function (_x2) {
                              return _ref4.apply(this, arguments);
                            };
                          }());
                        } else {
                          context === null || context === void 0 || context.$http({
                            url: "".concat(tableName, "/").concat(!form.value.id ? "save" : "update"),
                            method: 'post',
                            data: form.value
                          }).then(/*#__PURE__*/function () {
                            var _ref6 = (0,asyncToGenerator/* default */.A)(/*#__PURE__*/(0,regenerator/* default */.A)().m(function _callee3(res) {
                              return (0,regenerator/* default */.A)().w(function (_context3) {
                                while (1) switch (_context3.n) {
                                  case 0:
                                    emit('formModelChange');
                                    context === null || context === void 0 || context.$toolUtil.message("\u64CD\u4F5C\u6210\u529F", 'success');
                                    formVisible.value = false;
                                  case 1:
                                    return _context3.a(2);
                                }
                              }, _callee3);
                            }));
                            return function (_x4) {
                              return _ref6.apply(this, arguments);
                            };
                          }());
                        }
                        _context4.n = 5;
                        break;
                      case 4:
                        context.$message.error('请完善信息');
                      case 5:
                        return _context4.a(2);
                    }
                  }, _callee4);
                }));
                return function (_x) {
                  return _ref3.apply(this, arguments);
                };
              }());
            case 1:
              return _context5.a(2);
          }
        }, _callee5);
      }));
      return function save() {
        return _ref2.apply(this, arguments);
      };
    }();
    //修改跨表数据
    var changeCrossData = /*#__PURE__*/function () {
      var _ref7 = (0,asyncToGenerator/* default */.A)(/*#__PURE__*/(0,regenerator/* default */.A)().m(function _callee6(row, key) {
        var data;
        return (0,regenerator/* default */.A)().w(function (_context6) {
          while (1) switch (_context6.n) {
            case 0:
              if (!(type.value == 'cross')) {
                _context6.n = 1;
                break;
              }
              data = row;
              if (key) {
                //如果有指定key，则只更新key属性
                data = {
                  id: row.id
                };
                data[key] = row[key];
              }
              _context6.n = 1;
              return context === null || context === void 0 ? void 0 : context.$http({
                url: "".concat(crossTable.value, "/update"),
                method: 'post',
                data: data
              }).then(function (res) {});
            case 1:
              return _context6.a(2);
          }
        }, _callee6);
      }));
      return function changeCrossData(_x5, _x6) {
        return _ref7.apply(this, arguments);
      };
    }();
    return function (_ctx, _cache) {
      var _component_el_input = (0,runtime_core_esm_bundler/* resolveComponent */.g2)("el-input");
      var _component_el_form_item = (0,runtime_core_esm_bundler/* resolveComponent */.g2)("el-form-item");
      var _component_el_col = (0,runtime_core_esm_bundler/* resolveComponent */.g2)("el-col");
      var _component_uploads = (0,runtime_core_esm_bundler/* resolveComponent */.g2)("uploads");
      var _component_el_date_picker = (0,runtime_core_esm_bundler/* resolveComponent */.g2)("el-date-picker");
      var _component_el_row = (0,runtime_core_esm_bundler/* resolveComponent */.g2)("el-row");
      var _component_el_form = (0,runtime_core_esm_bundler/* resolveComponent */.g2)("el-form");
      var _component_el_button = (0,runtime_core_esm_bundler/* resolveComponent */.g2)("el-button");
      var _component_el_dialog = (0,runtime_core_esm_bundler/* resolveComponent */.g2)("el-dialog");
      return (0,runtime_core_esm_bundler/* openBlock */.uX)(), (0,runtime_core_esm_bundler/* createElementBlock */.CE)("div", null, [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_dialog, {
        "modal-class": "edit_form_modal",
        "class": "edit_form",
        modelValue: formVisible.value,
        "onUpdate:modelValue": _cache[9] || (_cache[9] = function ($event) {
          return formVisible.value = $event;
        }),
        title: formTitle.value,
        width: "90%",
        "destroy-on-close": "",
        fullscreen: false
      }, (0,runtime_core_esm_bundler/* createSlots */.eX)({
        "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
          return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_form, {
            "class": "formModel_form",
            ref_key: "formRef",
            ref: formRef,
            model: form.value,
            rules: rules.value
          }, {
            "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
              return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_row, null, {
                "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                  return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_col, {
                    span: 8
                  }, {
                    "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                      return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_form_item, {
                        label: "年份",
                        prop: "nianfen"
                      }, {
                        "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                          return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_input, {
                            "class": "list_inp",
                            modelValue: form.value.nianfen,
                            "onUpdate:modelValue": _cache[0] || (_cache[0] = function ($event) {
                              return form.value.nianfen = $event;
                            }),
                            placeholder: "年份",
                            type: "text",
                            readonly: !isAdd.value || disabledForm.value.nianfen ? true : false
                          }, null, 8, ["modelValue", "readonly"])];
                        }),
                        _: 1
                      })];
                    }),
                    _: 1
                  }), (0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_col, {
                    span: 8
                  }, {
                    "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                      return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_form_item, {
                        label: "月份",
                        prop: "yuefen"
                      }, {
                        "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                          return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_input, {
                            "class": "list_inp",
                            modelValue: form.value.yuefen,
                            "onUpdate:modelValue": _cache[1] || (_cache[1] = function ($event) {
                              return form.value.yuefen = $event;
                            }),
                            placeholder: "月份",
                            type: "text",
                            readonly: !isAdd.value || disabledForm.value.yuefen ? true : false
                          }, null, 8, ["modelValue", "readonly"])];
                        }),
                        _: 1
                      })];
                    }),
                    _: 1
                  }), (0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_col, {
                    span: 8
                  }, {
                    "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                      return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_form_item, {
                        prop: "xiaoxiangfapiao",
                        label: "销项发票"
                      }, {
                        "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                          return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_uploads, {
                            disabled: !isAdd.value || disabledForm.value.xiaoxiangfapiao ? true : false,
                            action: "file/upload",
                            tip: "请上传销项发票",
                            style: {
                              "width": "100%",
                              "text-align": "left"
                            },
                            fileUrls: form.value.xiaoxiangfapiao ? form.value.xiaoxiangfapiao : '',
                            onChange: xiaoxiangfapiaoUploadSuccess
                          }, null, 8, ["disabled", "fileUrls"])];
                        }),
                        _: 1
                      })];
                    }),
                    _: 1
                  }), (0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_col, {
                    span: 8
                  }, {
                    "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                      return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_form_item, {
                        prop: "jinxiangfapiao",
                        label: "进项发票"
                      }, {
                        "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                          return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_uploads, {
                            disabled: !isAdd.value || disabledForm.value.jinxiangfapiao ? true : false,
                            action: "file/upload",
                            tip: "请上传进项发票",
                            style: {
                              "width": "100%",
                              "text-align": "left"
                            },
                            fileUrls: form.value.jinxiangfapiao ? form.value.jinxiangfapiao : '',
                            onChange: jinxiangfapiaoUploadSuccess
                          }, null, 8, ["disabled", "fileUrls"])];
                        }),
                        _: 1
                      })];
                    }),
                    _: 1
                  }), (0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_col, {
                    span: 8
                  }, {
                    "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                      return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_form_item, {
                        label: "营收",
                        prop: "yingshou"
                      }, {
                        "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                          return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_input, {
                            "class": "list_inp",
                            modelValue: form.value.yingshou,
                            "onUpdate:modelValue": _cache[2] || (_cache[2] = function ($event) {
                              return form.value.yingshou = $event;
                            }),
                            modelModifiers: {
                              number: true
                            },
                            placeholder: "营收",
                            type: "number",
                            onMousewheel: _cache[3] || (_cache[3] = (0,runtime_dom_esm_bundler/* withModifiers */.D$)(function () {}, ["prevent"])),
                            readonly: !isAdd.value || disabledForm.value.yingshou ? true : false
                          }, null, 8, ["modelValue", "readonly"])];
                        }),
                        _: 1
                      })];
                    }),
                    _: 1
                  }), (0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_col, {
                    span: 8
                  }, {
                    "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                      return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_form_item, {
                        label: "成本费用",
                        prop: "chengbenfeiyong"
                      }, {
                        "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                          return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_input, {
                            "class": "list_inp",
                            modelValue: form.value.chengbenfeiyong,
                            "onUpdate:modelValue": _cache[4] || (_cache[4] = function ($event) {
                              return form.value.chengbenfeiyong = $event;
                            }),
                            modelModifiers: {
                              number: true
                            },
                            placeholder: "成本费用",
                            type: "number",
                            onMousewheel: _cache[5] || (_cache[5] = (0,runtime_dom_esm_bundler/* withModifiers */.D$)(function () {}, ["prevent"])),
                            readonly: !isAdd.value || disabledForm.value.chengbenfeiyong ? true : false
                          }, null, 8, ["modelValue", "readonly"])];
                        }),
                        _: 1
                      })];
                    }),
                    _: 1
                  }), (0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_col, {
                    span: 8
                  }, {
                    "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                      return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_form_item, {
                        label: "申报时间",
                        prop: "shenbaoshijian"
                      }, {
                        "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                          return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_date_picker, {
                            "class": "list_date",
                            modelValue: form.value.shenbaoshijian,
                            "onUpdate:modelValue": _cache[6] || (_cache[6] = function ($event) {
                              return form.value.shenbaoshijian = $event;
                            }),
                            format: "YYYY-MM-DD HH:mm:ss",
                            "value-format": "YYYY-MM-DD HH:mm:ss",
                            type: "datetime",
                            readonly: !isAdd.value || disabledForm.value.shenbaoshijian ? true : false,
                            placeholder: "请选择申报时间"
                          }, null, 8, ["modelValue", "readonly"])];
                        }),
                        _: 1
                      })];
                    }),
                    _: 1
                  }), (0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_col, {
                    span: 8
                  }, {
                    "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                      return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_form_item, {
                        label: "企业名称",
                        prop: "qiyemingcheng"
                      }, {
                        "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                          return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_input, {
                            "class": "list_inp",
                            modelValue: form.value.qiyemingcheng,
                            "onUpdate:modelValue": _cache[7] || (_cache[7] = function ($event) {
                              return form.value.qiyemingcheng = $event;
                            }),
                            placeholder: "企业名称",
                            type: "text",
                            readonly: !isAdd.value || disabledForm.value.qiyemingcheng ? true : false
                          }, null, 8, ["modelValue", "readonly"])];
                        }),
                        _: 1
                      })];
                    }),
                    _: 1
                  }), (0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_col, {
                    span: 8
                  }, {
                    "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                      return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_form_item, {
                        label: "申报回执",
                        prop: "shenbaohuizhi"
                      }, {
                        "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                          return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_uploads, {
                            disabled: !isAdd.value || disabledForm.value.shenbaohuizhi ? true : false,
                            type: "file",
                            action: "file/upload",
                            tip: "请上传申报回执",
                            limit: 1,
                            style: {
                              "width": "100%",
                              "text-align": "left"
                            },
                            fileUrls: form.value.shenbaohuizhi ? form.value.shenbaohuizhi : '',
                            onChange: shenbaohuizhiUploadSuccess
                          }, null, 8, ["disabled", "fileUrls"])];
                        }),
                        _: 1
                      })];
                    }),
                    _: 1
                  }), (0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_col, {
                    span: 8
                  }, {
                    "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                      return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_form_item, {
                        label: "备注",
                        prop: "beizhu"
                      }, {
                        "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
                          return [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_input, {
                            "class": "list_inp",
                            modelValue: form.value.beizhu,
                            "onUpdate:modelValue": _cache[8] || (_cache[8] = function ($event) {
                              return form.value.beizhu = $event;
                            }),
                            placeholder: "备注",
                            type: "text",
                            readonly: !isAdd.value || disabledForm.value.beizhu ? true : false
                          }, null, 8, ["modelValue", "readonly"])];
                        }),
                        _: 1
                      })];
                    }),
                    _: 1
                  })];
                }),
                _: 1
              })];
            }),
            _: 1
          }, 8, ["model", "rules"])];
        }),
        _: 2
      }, [isAdd.value || type.value == 'logistics' || type.value == 'reply' ? {
        name: "footer",
        fn: (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
          return [(0,runtime_core_esm_bundler/* createElementVNode */.Lk)("span", _hoisted_1, [(0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_button, {
            "class": "cancel_btn",
            onClick: closeClick
          }, {
            "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
              return (0,toConsumableArray/* default */.A)(_cache[10] || (_cache[10] = [(0,runtime_core_esm_bundler/* createTextVNode */.eW)("取消", -1)]));
            }),
            _: 1
          }), (0,runtime_core_esm_bundler/* createVNode */.bF)(_component_el_button, {
            "class": "confirm_btn",
            type: "primary",
            onClick: save
          }, {
            "default": (0,runtime_core_esm_bundler/* withCtx */.k6)(function () {
              return (0,toConsumableArray/* default */.A)(_cache[11] || (_cache[11] = [(0,runtime_core_esm_bundler/* createTextVNode */.eW)(" 提交 ", -1)]));
            }),
            _: 1
          })])];
        }),
        key: "0"
      } : undefined]), 1032, ["modelValue", "title"])]);
    };
  }
});
;// ./src/views/shenbaohuizhi/formModel.vue?vue&type=script&setup=true&lang=js
 
;// ../../../../../../../node_modules_admin/1/node_modules/mini-css-extract-plugin/dist/loader.js??clonedRuleSet-22.use[0]!../../../../../../../node_modules_admin/1/node_modules/css-loader/dist/cjs.js??clonedRuleSet-22.use[1]!../../../../../../../node_modules_admin/1/node_modules/vue-loader/dist/stylePostLoader.js!../../../../../../../node_modules_admin/1/node_modules/postcss-loader/dist/cjs.js??clonedRuleSet-22.use[2]!../../../../../../../node_modules_admin/1/node_modules/sass-loader/dist/cjs.js??clonedRuleSet-22.use[3]!../../../../../../../node_modules_admin/1/node_modules/vue-loader/dist/index.js??ruleSet[0].use[0]!./src/views/shenbaohuizhi/formModel.vue?vue&type=style&index=0&id=2787997a&lang=scss&scoped=true
// extracted by mini-css-extract-plugin

;// ./src/views/shenbaohuizhi/formModel.vue?vue&type=style&index=0&id=2787997a&lang=scss&scoped=true

// EXTERNAL MODULE: ../../../../../../../node_modules_admin/1/node_modules/vue-loader/dist/exportHelper.js
var exportHelper = __webpack_require__(9701);
;// ./src/views/shenbaohuizhi/formModel.vue



;


const __exports__ = /*#__PURE__*/(0,exportHelper/* default */.A)(formModelvue_type_script_setup_true_lang_js, [['__scopeId',"data-v-2787997a"]])

/* harmony default export */ const formModel = (__exports__);

/***/ })

}]);
//# sourceMappingURL=419.844ee24c.js.map