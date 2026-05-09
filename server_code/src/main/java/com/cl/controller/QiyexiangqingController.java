package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import jakarta.servlet.http.HttpServletRequest;

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

import com.cl.entity.QiyexiangqingEntity;
import com.cl.entity.view.QiyexiangqingView;

import com.cl.service.QiyexiangqingService;
import com.cl.service.TokenService;
import java.io.IOException;

/**
 * 企业详情
 * 后端接口
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
@RestController
@RequestMapping("/qiyexiangqing")
public class QiyexiangqingController {
    @Autowired
    private QiyexiangqingService qiyexiangqingService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QiyexiangqingEntity qiyexiangqing,
        @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date chuangjianshijianStart,
        @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date chuangjianshijianEnd,
        HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            qiyexiangqing.setQiyemingcheng((String)request.getSession().getAttribute("username"));
        }
        QueryWrapper<QiyexiangqingEntity> ew = new QueryWrapper<QiyexiangqingEntity>();
        if(chuangjianshijianStart!=null) ew.ge("chuangjianshijian", chuangjianshijianStart);
        if(chuangjianshijianEnd!=null) ew.le("chuangjianshijian", chuangjianshijianEnd);



        PageUtils page = qiyexiangqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiyexiangqing), params), params));
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
    public R list(@RequestParam Map<String, Object> params,QiyexiangqingEntity qiyexiangqing,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date chuangjianshijianStart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date chuangjianshijianEnd,
		HttpServletRequest request){
        QueryWrapper<QiyexiangqingEntity> ew = new QueryWrapper<QiyexiangqingEntity>();
                if(chuangjianshijianStart!=null) ew.ge("chuangjianshijian", chuangjianshijianStart);
                if(chuangjianshijianEnd!=null) ew.le("chuangjianshijian", chuangjianshijianEnd);

		PageUtils page = qiyexiangqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiyexiangqing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QiyexiangqingEntity qiyexiangqing){
       	QueryWrapper<QiyexiangqingEntity> ew = new QueryWrapper<QiyexiangqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qiyexiangqing, MPUtil.camelToSnake("qiyexiangqing")));
        return R.ok().put("data", qiyexiangqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QiyexiangqingEntity qiyexiangqing){
        QueryWrapper< QiyexiangqingEntity> ew = new QueryWrapper< QiyexiangqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qiyexiangqing, MPUtil.camelToSnake("qiyexiangqing")));
		QiyexiangqingView qiyexiangqingView =  qiyexiangqingService.selectView(ew);
		return R.ok("查询企业详情成功").put("data", qiyexiangqingView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QiyexiangqingEntity qiyexiangqing = qiyexiangqingService.getById(id);
		qiyexiangqing = qiyexiangqingService.selectView(new QueryWrapper<QiyexiangqingEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(qiyexiangqing,deSens);
        return R.ok().put("data", qiyexiangqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QiyexiangqingEntity qiyexiangqing = qiyexiangqingService.getById(id);
		qiyexiangqing = qiyexiangqingService.selectView(new QueryWrapper<QiyexiangqingEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(qiyexiangqing,deSens);
        return R.ok().put("data", qiyexiangqing);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增企业详情")
    public R save(@RequestBody QiyexiangqingEntity qiyexiangqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qiyexiangqing);
        qiyexiangqingService.save(qiyexiangqing);
        return R.ok().put("data",qiyexiangqing.getId());
    }

    /**
     * 前端保存
     */
    @SysLog("新增企业详情")
    @RequestMapping("/add")
    public R add(@RequestBody QiyexiangqingEntity qiyexiangqing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(qiyexiangqing);
        qiyexiangqingService.save(qiyexiangqing);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改企业详情")
    public R update(@RequestBody QiyexiangqingEntity qiyexiangqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qiyexiangqing);
        qiyexiangqingService.updateById(qiyexiangqing);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除企业详情")
    public R delete(@RequestBody Long[] ids){
        qiyexiangqingService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }

    








}
