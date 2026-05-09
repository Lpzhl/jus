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

import com.cl.entity.ShenbaohuizhiEntity;
import com.cl.entity.view.ShenbaohuizhiView;

import com.cl.service.ShenbaohuizhiService;
import com.cl.service.TokenService;
import java.io.IOException;

/**
 * 申报回执
 * 后端接口
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
@RestController
@RequestMapping("/shenbaohuizhi")
public class ShenbaohuizhiController {
    @Autowired
    private ShenbaohuizhiService shenbaohuizhiService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShenbaohuizhiEntity shenbaohuizhi,
        HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            shenbaohuizhi.setQiyemingcheng((String)request.getSession().getAttribute("username"));
        }
        QueryWrapper<ShenbaohuizhiEntity> ew = new QueryWrapper<ShenbaohuizhiEntity>();



        PageUtils page = shenbaohuizhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenbaohuizhi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ShenbaohuizhiEntity shenbaohuizhi,
		HttpServletRequest request){
        QueryWrapper<ShenbaohuizhiEntity> ew = new QueryWrapper<ShenbaohuizhiEntity>();

		PageUtils page = shenbaohuizhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenbaohuizhi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShenbaohuizhiEntity shenbaohuizhi){
       	QueryWrapper<ShenbaohuizhiEntity> ew = new QueryWrapper<ShenbaohuizhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shenbaohuizhi, MPUtil.camelToSnake("shenbaohuizhi")));
        return R.ok().put("data", shenbaohuizhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShenbaohuizhiEntity shenbaohuizhi){
        QueryWrapper< ShenbaohuizhiEntity> ew = new QueryWrapper< ShenbaohuizhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shenbaohuizhi, MPUtil.camelToSnake("shenbaohuizhi")));
		ShenbaohuizhiView shenbaohuizhiView =  shenbaohuizhiService.selectView(ew);
		return R.ok("查询申报回执成功").put("data", shenbaohuizhiView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShenbaohuizhiEntity shenbaohuizhi = shenbaohuizhiService.getById(id);
		shenbaohuizhi = shenbaohuizhiService.selectView(new QueryWrapper<ShenbaohuizhiEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shenbaohuizhi,deSens);
        return R.ok().put("data", shenbaohuizhi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShenbaohuizhiEntity shenbaohuizhi = shenbaohuizhiService.getById(id);
		shenbaohuizhi = shenbaohuizhiService.selectView(new QueryWrapper<ShenbaohuizhiEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shenbaohuizhi,deSens);
        return R.ok().put("data", shenbaohuizhi);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增申报回执")
    public R save(@RequestBody ShenbaohuizhiEntity shenbaohuizhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shenbaohuizhi);
        shenbaohuizhiService.save(shenbaohuizhi);
        return R.ok().put("data",shenbaohuizhi.getId());
    }

    /**
     * 前端保存
     */
    @SysLog("新增申报回执")
    @RequestMapping("/add")
    public R add(@RequestBody ShenbaohuizhiEntity shenbaohuizhi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shenbaohuizhi);
        shenbaohuizhiService.save(shenbaohuizhi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改申报回执")
    public R update(@RequestBody ShenbaohuizhiEntity shenbaohuizhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shenbaohuizhi);
        shenbaohuizhiService.updateById(shenbaohuizhi);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除申报回执")
    public R delete(@RequestBody Long[] ids){
        shenbaohuizhiService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }

    








}
