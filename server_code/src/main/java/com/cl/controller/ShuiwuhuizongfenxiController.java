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

import com.cl.entity.ShuiwuhuizongfenxiEntity;
import com.cl.entity.view.ShuiwuhuizongfenxiView;

import com.cl.service.ShuiwuhuizongfenxiService;
import com.cl.service.TokenService;
import java.io.IOException;

/**
 * 税务汇总分析
 * 后端接口
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
@RestController
@RequestMapping("/shuiwuhuizongfenxi")
public class ShuiwuhuizongfenxiController {
    @Autowired
    private ShuiwuhuizongfenxiService shuiwuhuizongfenxiService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShuiwuhuizongfenxiEntity shuiwuhuizongfenxi,
        HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            shuiwuhuizongfenxi.setQiyemingcheng((String)request.getSession().getAttribute("username"));
        }
        QueryWrapper<ShuiwuhuizongfenxiEntity> ew = new QueryWrapper<ShuiwuhuizongfenxiEntity>();



        PageUtils page = shuiwuhuizongfenxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shuiwuhuizongfenxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ShuiwuhuizongfenxiEntity shuiwuhuizongfenxi,
		HttpServletRequest request){
        QueryWrapper<ShuiwuhuizongfenxiEntity> ew = new QueryWrapper<ShuiwuhuizongfenxiEntity>();

		PageUtils page = shuiwuhuizongfenxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shuiwuhuizongfenxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShuiwuhuizongfenxiEntity shuiwuhuizongfenxi){
       	QueryWrapper<ShuiwuhuizongfenxiEntity> ew = new QueryWrapper<ShuiwuhuizongfenxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shuiwuhuizongfenxi, MPUtil.camelToSnake("shuiwuhuizongfenxi")));
        return R.ok().put("data", shuiwuhuizongfenxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShuiwuhuizongfenxiEntity shuiwuhuizongfenxi){
        QueryWrapper< ShuiwuhuizongfenxiEntity> ew = new QueryWrapper< ShuiwuhuizongfenxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shuiwuhuizongfenxi, MPUtil.camelToSnake("shuiwuhuizongfenxi")));
		ShuiwuhuizongfenxiView shuiwuhuizongfenxiView =  shuiwuhuizongfenxiService.selectView(ew);
		return R.ok("查询税务汇总分析成功").put("data", shuiwuhuizongfenxiView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShuiwuhuizongfenxiEntity shuiwuhuizongfenxi = shuiwuhuizongfenxiService.getById(id);
		shuiwuhuizongfenxi = shuiwuhuizongfenxiService.selectView(new QueryWrapper<ShuiwuhuizongfenxiEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shuiwuhuizongfenxi,deSens);
        return R.ok().put("data", shuiwuhuizongfenxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShuiwuhuizongfenxiEntity shuiwuhuizongfenxi = shuiwuhuizongfenxiService.getById(id);
		shuiwuhuizongfenxi = shuiwuhuizongfenxiService.selectView(new QueryWrapper<ShuiwuhuizongfenxiEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shuiwuhuizongfenxi,deSens);
        return R.ok().put("data", shuiwuhuizongfenxi);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增税务汇总分析")
    public R save(@RequestBody ShuiwuhuizongfenxiEntity shuiwuhuizongfenxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shuiwuhuizongfenxi);
        shuiwuhuizongfenxiService.save(shuiwuhuizongfenxi);
        return R.ok().put("data",shuiwuhuizongfenxi.getId());
    }

    /**
     * 前端保存
     */
    @SysLog("新增税务汇总分析")
    @RequestMapping("/add")
    public R add(@RequestBody ShuiwuhuizongfenxiEntity shuiwuhuizongfenxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shuiwuhuizongfenxi);
        shuiwuhuizongfenxiService.save(shuiwuhuizongfenxi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改税务汇总分析")
    public R update(@RequestBody ShuiwuhuizongfenxiEntity shuiwuhuizongfenxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shuiwuhuizongfenxi);
        shuiwuhuizongfenxiService.updateById(shuiwuhuizongfenxi);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除税务汇总分析")
    public R delete(@RequestBody Long[] ids){
        shuiwuhuizongfenxiService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }

    








}
