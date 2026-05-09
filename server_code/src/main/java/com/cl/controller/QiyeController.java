package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import jakarta.servlet.http.HttpServletRequest;

import com.cl.entity.TokenEntity;
import com.cl.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cl.annotation.IgnoreAuth;
import com.cl.annotation.SysLog;

import com.cl.entity.QiyeEntity;
import com.cl.entity.view.QiyeView;

import com.cl.service.QiyeService;
import com.cl.service.TokenService;
import java.io.IOException;

/**
 * 企业
 * 后端接口
 * @author 
 * @email 
 * @date 2026-04-30 18:52:45
 */
@RestController
@RequestMapping("/qiye")
public class QiyeController {
    @Autowired
    private QiyeService qiyeService;



	@Autowired
	private TokenService tokenService;

	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		QiyeEntity u = qiyeService.getOne(new QueryWrapper<QiyeEntity>().eq("qiyemingcheng", username));
        if(u!=null && u.getIsLocked().intValue()==1) {
            return R.error("账号已锁定，请联系管理员。");
        }
        if(u==null || !u.getMima().equals(password)) {
        if(u!=null) {
            u.setMaxPasswordWrong(u.getMaxPasswordWrong()+1);
            if(u.getMaxPasswordWrong()>=3) {
                u.setIsLocked(1);
            }
                qiyeService.updateById(u);
        }
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"qiye",  "管理员" );
		return R.ok().put("token", token);
	}



	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody QiyeEntity qiye){
    	//ValidatorUtils.validateEntity(qiye);
        QiyeEntity u = qiyeService.getOne(new QueryWrapper<QiyeEntity>().eq("qiyemingcheng", qiye.getQiyemingcheng()));
        if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		qiye.setId(uId);
        qiyeService.save(qiye);
        return R.ok();
    }


	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}

	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        return R.ok().put("data", qiyeService.selectView(new QueryWrapper<QiyeEntity>().eq("id", id)));
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	QiyeEntity u = qiyeService.getOne(new QueryWrapper<QiyeEntity>().eq("qiyemingcheng", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        qiyeService.updateById(u);
        return R.ok("密码已重置为：123456");
    }




    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QiyeEntity qiye,
        HttpServletRequest request){
        QueryWrapper<QiyeEntity> ew = new QueryWrapper<QiyeEntity>();



        PageUtils page = qiyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiye), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }







    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QiyeEntity qiye,
		HttpServletRequest request){
        QueryWrapper<QiyeEntity> ew = new QueryWrapper<QiyeEntity>();

		PageUtils page = qiyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiye), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QiyeEntity qiye){
       	QueryWrapper<QiyeEntity> ew = new QueryWrapper<QiyeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qiye, MPUtil.camelToSnake("qiye")));
        return R.ok().put("data", qiyeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QiyeEntity qiye){
        QueryWrapper< QiyeEntity> ew = new QueryWrapper< QiyeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qiye, MPUtil.camelToSnake("qiye")));
		QiyeView qiyeView =  qiyeService.selectView(ew);
		return R.ok("查询企业成功").put("data", qiyeView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QiyeEntity qiye = qiyeService.getById(id);
		qiye = qiyeService.selectView(new QueryWrapper<QiyeEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(qiye,deSens);
        return R.ok().put("data", qiye);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QiyeEntity qiye = qiyeService.getById(id);
		qiye = qiyeService.selectView(new QueryWrapper<QiyeEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(qiye,deSens);
        return R.ok().put("data", qiye);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增企业")
    public R save(@RequestBody QiyeEntity qiye, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(qiyeService.count(new QueryWrapper<QiyeEntity>().eq("qiyemingcheng", qiye.getQiyemingcheng()))>0) {
            return R.error("企业名称已存在");
        }
        //ValidatorUtils.validateEntity(qiye);
        QiyeEntity u = qiyeService.getOne(new QueryWrapper<QiyeEntity>().eq("qiyemingcheng", qiye.getQiyemingcheng()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	qiye.setId(new Date().getTime()+(long)Math.floor(Math.random()*1000));
		qiye.setId(new Date().getTime());
        qiyeService.save(qiye);
        return R.ok().put("data",qiye.getId());
    }

    /**
     * 前端保存
     */
    @SysLog("新增企业")
    @RequestMapping("/add")
    public R add(@RequestBody QiyeEntity qiye, HttpServletRequest request){
        if(qiyeService.count(new QueryWrapper<QiyeEntity>().eq("qiyemingcheng", qiye.getQiyemingcheng()))>0) {
            return R.error("企业名称已存在");
        }
    	qiye.setId(new Date().getTime()+(long)Math.floor(Math.random()*1000));
    	//ValidatorUtils.validateEntity(qiye);
        QiyeEntity u = qiyeService.getOne(new QueryWrapper<QiyeEntity>().eq("qiyemingcheng", qiye.getQiyemingcheng()));
        if(u!=null) {
			return R.error("用户已存在");
		}
		qiye.setId(new Date().getTime());
        qiyeService.save(qiye);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改企业")
    public R update(@RequestBody QiyeEntity qiye, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qiye);
        qiyeService.updateById(qiye);//全部更新
        if(null!=qiye.getQiyemingcheng())
        {
            // 修改token
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setUsername(qiye.getQiyemingcheng());
            tokenService.update(tokenEntity, new UpdateWrapper<TokenEntity>().eq("userid", qiye.getId()));
        }
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除企业")
    public R delete(@RequestBody Long[] ids){
        qiyeService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }

    





    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @RequestParam(required = false) String conditionColumn, @RequestParam(required = false) String conditionValue, @RequestParam(required = false, defaultValue = "总和") String func, HttpServletRequest request) throws IOException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", MPUtil.camelToSnake(xColumnName));
        params.put("yColumn", MPUtil.camelToSnake(yColumnName));
        params.put("method", func);
        QueryWrapper<QiyeEntity> ew = new QueryWrapper<QiyeEntity>();
        String order = request.getParameter("order");
        if (StringUtils.isNotBlank(order)) {
            String orderType = request.getParameter("orderType");
            if (null != orderType) {
                if (order.equals("asc")) {
                    ew.orderByAsc(orderType.equals("x") ? xColumnName : yColumnName);
                } else {
                    ew.orderByDesc(orderType.equals("x") ? xColumnName :yColumnName);
                }
            }
        }
        if(StringUtils.isNotBlank(conditionColumn)&&StringUtils.isNotBlank(conditionValue))
        {
            String[] conditionColumns = conditionColumn.split(";");
            String[] conditionValues = conditionValue.split(";");

            for (int i = 0; i < conditionColumns.length; i++) {
                String column = conditionColumns[i];
                String value = conditionValues[i];

                // 处理范围查询：如果列名包含逗号，表示是范围查询
                if (column.contains(",")) {
                    String[] rangeColumns = column.split(",");
                    String[] rangeValues = value.split(",");

                    if (rangeColumns.length == 2 && rangeValues.length == 2) {
                        // 第一个列名使用 >= 条件
                        ew.ge(rangeColumns[0], rangeValues[0]);
                        // 第二个列名使用 <= 条件
                        ew.le(rangeColumns[1], rangeValues[1]);
                    }
                } else {
                    // 普通等值查询
                    ew.eq(column, value);
                }
            }
        }
        List<Map<String, Object>> result = MPUtil.snakeListToCamel(qiyeService.selectValue(params, ew));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);

    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, @RequestParam(required = false) String conditionColumn, @RequestParam(required = false) String conditionValue, HttpServletRequest request)  throws IOException {
        String[] yColumnNames = MPUtil.camelToSnake(yColumnNameMul).split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", MPUtil.camelToSnake(xColumnName));
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        QueryWrapper<QiyeEntity> ew = new QueryWrapper<QiyeEntity>();
        String order = request.getParameter("order");
        if (StringUtils.isNotBlank(order)) {
            String orderType = request.getParameter("orderType");
            if (null != orderType) {
                if (order.equals("asc")) {
                    ew.orderByAsc(orderType.equals("x") ? Arrays.asList(xColumnName) : Arrays.asList(yColumnNames));
                } else {
                    ew.orderByDesc(orderType.equals("x") ? Arrays.asList(xColumnName) : Arrays.asList(yColumnNames));
                }
            }
        }
        if(StringUtils.isNotBlank(conditionColumn)&&StringUtils.isNotBlank(conditionValue))
        {
            String[] conditionColumns = conditionColumn.split(";");
            String[] conditionValues = conditionValue.split(";");

            for (int i = 0; i < conditionColumns.length; i++) {
                String column = conditionColumns[i];
                String value = conditionValues[i];

                // 处理范围查询：如果列名包含逗号，表示是范围查询
                if (column.contains(",")) {
                    String[] rangeColumns = column.split(",");
                    String[] rangeValues = value.split(",");

                    if (rangeColumns.length == 2 && rangeValues.length == 2) {
                        // 第一个列名使用 >= 条件
                        ew.ge(rangeColumns[0], rangeValues[0]);
                        // 第二个列名使用 <= 条件
                        ew.le(rangeColumns[1], rangeValues[1]);
                    }
                } else {
                    // 普通等值查询
                    ew.eq(column, value);
                }
            }
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = MPUtil.snakeListToCamel(qiyeService.selectValue(params, ew));
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType, @RequestParam(required = false) String conditionColumn, @RequestParam(required = false) String conditionValue, @RequestParam(required = false, defaultValue = "总和") String func, HttpServletRequest request) throws IOException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", MPUtil.camelToSnake(xColumnName));
        params.put("yColumn", MPUtil.camelToSnake(yColumnName));
        params.put("timeStatType", timeStatType);
        params.put("method", func);
        QueryWrapper<QiyeEntity> ew = new QueryWrapper<QiyeEntity>();
        String order = request.getParameter("order");
        if (StringUtils.isNotBlank(order)) {
            String orderType = request.getParameter("orderType");
            if (null != orderType) {
                if (order.equals("asc")) {
                    ew.orderByAsc(orderType.equals("x") ? xColumnName : yColumnName);
                } else {
                    ew.orderByDesc(orderType.equals("x") ? xColumnName :yColumnName);
                }
            }
        }
        if(StringUtils.isNotBlank(conditionColumn)&&StringUtils.isNotBlank(conditionValue))
        {
            String[] conditionColumns = conditionColumn.split(";");
            String[] conditionValues = conditionValue.split(";");

            for (int i = 0; i < conditionColumns.length; i++) {
                String column = conditionColumns[i];
                String value = conditionValues[i];

                // 处理范围查询：如果列名包含逗号，表示是范围查询
                if (column.contains(",")) {
                    String[] rangeColumns = column.split(",");
                    String[] rangeValues = value.split(",");

                    if (rangeColumns.length == 2 && rangeValues.length == 2) {
                        // 第一个列名使用 >= 条件
                        ew.ge(rangeColumns[0], rangeValues[0]);
                        // 第二个列名使用 <= 条件
                        ew.le(rangeColumns[1], rangeValues[1]);
                    }
                } else {
                    // 普通等值查询
                    ew.eq(column, value);
                }
            }
        }
        List<Map<String, Object>> result = MPUtil.snakeListToCamel(qiyeService.selectTimeStatValue(params, ew));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType, @RequestParam String yColumnNameMul, @RequestParam(required = false) String conditionColumn, @RequestParam(required = false) String conditionValue, HttpServletRequest request) throws IOException {
        String[] yColumnNames = MPUtil.camelToSnake(yColumnNameMul).split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        QueryWrapper<QiyeEntity> ew = new QueryWrapper<QiyeEntity>();
        String order = request.getParameter("order");
        if (StringUtils.isNotBlank(order)) {
            String orderType = request.getParameter("orderType");
            if (null != orderType) {
                if (order.equals("asc")) {
                    ew.orderByAsc(orderType.equals("x") ? Arrays.asList(xColumnName) : Arrays.asList(yColumnNames));
                } else {
                    ew.orderByDesc(orderType.equals("x") ? Arrays.asList(xColumnName) : Arrays.asList(yColumnNames));
                }
            }
        }
        if(StringUtils.isNotBlank(conditionColumn)&&StringUtils.isNotBlank(conditionValue))
        {
            String[] conditionColumns = conditionColumn.split(";");
            String[] conditionValues = conditionValue.split(";");

            for (int i = 0; i < conditionColumns.length; i++) {
                String column = conditionColumns[i];
                String value = conditionValues[i];

                // 处理范围查询：如果列名包含逗号，表示是范围查询
                if (column.contains(",")) {
                    String[] rangeColumns = column.split(",");
                    String[] rangeValues = value.split(",");

                    if (rangeColumns.length == 2 && rangeValues.length == 2) {
                        // 第一个列名使用 >= 条件
                        ew.ge(rangeColumns[0], rangeValues[0]);
                        // 第二个列名使用 <= 条件
                        ew.le(rangeColumns[1], rangeValues[1]);
                    }
                } else {
                    // 普通等值查询
                    ew.eq(column, value);
                }
            }
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = MPUtil.snakeListToCamel(qiyeService.selectTimeStatValue(params, ew));
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName, @RequestParam(required = false) String conditionColumn, @RequestParam(required = false) String conditionValue, HttpServletRequest request) throws IOException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", MPUtil.camelToSnake(columnName));
        String order = request.getParameter("order");
        if (StringUtils.isNotBlank(order)) {
            params.put("order", request.getParameter("order"));
            String orderType = request.getParameter("orderType");
            params.put("orderType", StringUtils.isNotBlank(orderType) && orderType.equals("x") ? MPUtil.camelToSnake(columnName) : "total");
        }
        QueryWrapper<QiyeEntity> ew = new QueryWrapper<QiyeEntity>();
        if(StringUtils.isNotBlank(conditionColumn)&&StringUtils.isNotBlank(conditionValue))
        {
            String[] conditionColumns = conditionColumn.split(";");
            String[] conditionValues = conditionValue.split(";");

            for (int i = 0; i < conditionColumns.length; i++) {
                String column = conditionColumns[i];
                String value = conditionValues[i];

                // 处理范围查询：如果列名包含逗号，表示是范围查询
                if (column.contains(",")) {
                    String[] rangeColumns = column.split(",");
                    String[] rangeValues = value.split(",");

                    if (rangeColumns.length == 2 && rangeValues.length == 2) {
                        // 第一个列名使用 >= 条件
                        ew.ge(rangeColumns[0], rangeValues[0]);
                        // 第二个列名使用 <= 条件
                        ew.le(rangeColumns[1], rangeValues[1]);
                    }
                } else {
                    // 普通等值查询
                    ew.eq(column, value);
                }
            }
        }
        List<Map<String, Object>> result = MPUtil.snakeListToCamel(qiyeService.selectGroup(params, ew));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,QiyeEntity qiye, HttpServletRequest request){
        QueryWrapper<QiyeEntity> ew = new QueryWrapper<QiyeEntity>();
    long count = qiyeService.count(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiye), params), params));
        return R.ok().put("data", count);
    }


}
