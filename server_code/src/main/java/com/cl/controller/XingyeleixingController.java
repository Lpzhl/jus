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

import com.cl.entity.XingyeleixingEntity;
import com.cl.entity.view.XingyeleixingView;

import com.cl.service.XingyeleixingService;
import com.cl.service.TokenService;
import java.io.IOException;

/**
 * 行业类型
 * 后端接口
 * @author 
 * @email 
 * @date 2026-04-30 18:52:45
 */
@RestController
@RequestMapping("/xingyeleixing")
public class XingyeleixingController {
    @Autowired
    private XingyeleixingService xingyeleixingService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XingyeleixingEntity xingyeleixing,
        HttpServletRequest request){
        QueryWrapper<XingyeleixingEntity> ew = new QueryWrapper<XingyeleixingEntity>();



        PageUtils page = xingyeleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xingyeleixing), params), params));
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
    public R list(@RequestParam Map<String, Object> params,XingyeleixingEntity xingyeleixing,
		HttpServletRequest request){
        QueryWrapper<XingyeleixingEntity> ew = new QueryWrapper<XingyeleixingEntity>();

		PageUtils page = xingyeleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xingyeleixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XingyeleixingEntity xingyeleixing){
       	QueryWrapper<XingyeleixingEntity> ew = new QueryWrapper<XingyeleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xingyeleixing, MPUtil.camelToSnake("xingyeleixing")));
        return R.ok().put("data", xingyeleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XingyeleixingEntity xingyeleixing){
        QueryWrapper< XingyeleixingEntity> ew = new QueryWrapper< XingyeleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xingyeleixing, MPUtil.camelToSnake("xingyeleixing")));
		XingyeleixingView xingyeleixingView =  xingyeleixingService.selectView(ew);
		return R.ok("查询行业类型成功").put("data", xingyeleixingView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XingyeleixingEntity xingyeleixing = xingyeleixingService.getById(id);
		xingyeleixing = xingyeleixingService.selectView(new QueryWrapper<XingyeleixingEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(xingyeleixing,deSens);
        return R.ok().put("data", xingyeleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XingyeleixingEntity xingyeleixing = xingyeleixingService.getById(id);
		xingyeleixing = xingyeleixingService.selectView(new QueryWrapper<XingyeleixingEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(xingyeleixing,deSens);
        return R.ok().put("data", xingyeleixing);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增行业类型")
    public R save(@RequestBody XingyeleixingEntity xingyeleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xingyeleixing);
        xingyeleixingService.save(xingyeleixing);
        return R.ok().put("data",xingyeleixing.getId());
    }

    /**
     * 前端保存
     */
    @SysLog("新增行业类型")
    @RequestMapping("/add")
    public R add(@RequestBody XingyeleixingEntity xingyeleixing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xingyeleixing);
        xingyeleixingService.save(xingyeleixing);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改行业类型")
    public R update(@RequestBody XingyeleixingEntity xingyeleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xingyeleixing);
        xingyeleixingService.updateById(xingyeleixing);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除行业类型")
    public R delete(@RequestBody Long[] ids){
        xingyeleixingService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }

    








}
