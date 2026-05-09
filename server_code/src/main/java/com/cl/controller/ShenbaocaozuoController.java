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

import com.cl.entity.ShenbaocaozuoEntity;
import com.cl.entity.view.ShenbaocaozuoView;

import com.cl.service.ShenbaocaozuoService;
import com.cl.service.TokenService;
import java.io.IOException;

/**
 * 申报操作
 * 后端接口
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
@RestController
@RequestMapping("/shenbaocaozuo")
public class ShenbaocaozuoController {
    @Autowired
    private ShenbaocaozuoService shenbaocaozuoService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShenbaocaozuoEntity shenbaocaozuo,
        HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            shenbaocaozuo.setQiyemingcheng((String)request.getSession().getAttribute("username"));
        }
        QueryWrapper<ShenbaocaozuoEntity> ew = new QueryWrapper<ShenbaocaozuoEntity>();



        PageUtils page = shenbaocaozuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenbaocaozuo), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ShenbaocaozuoEntity shenbaocaozuo,
		HttpServletRequest request){
        QueryWrapper<ShenbaocaozuoEntity> ew = new QueryWrapper<ShenbaocaozuoEntity>();

		PageUtils page = shenbaocaozuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenbaocaozuo), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShenbaocaozuoEntity shenbaocaozuo){
       	QueryWrapper<ShenbaocaozuoEntity> ew = new QueryWrapper<ShenbaocaozuoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shenbaocaozuo, MPUtil.camelToSnake("shenbaocaozuo")));
        return R.ok().put("data", shenbaocaozuoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShenbaocaozuoEntity shenbaocaozuo){
        QueryWrapper< ShenbaocaozuoEntity> ew = new QueryWrapper< ShenbaocaozuoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shenbaocaozuo, MPUtil.camelToSnake("shenbaocaozuo")));
		ShenbaocaozuoView shenbaocaozuoView =  shenbaocaozuoService.selectView(ew);
		return R.ok("查询申报操作成功").put("data", shenbaocaozuoView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShenbaocaozuoEntity shenbaocaozuo = shenbaocaozuoService.getById(id);
		shenbaocaozuo = shenbaocaozuoService.selectView(new QueryWrapper<ShenbaocaozuoEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shenbaocaozuo,deSens);
        return R.ok().put("data", shenbaocaozuo);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShenbaocaozuoEntity shenbaocaozuo = shenbaocaozuoService.getById(id);
		shenbaocaozuo = shenbaocaozuoService.selectView(new QueryWrapper<ShenbaocaozuoEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shenbaocaozuo,deSens);
        return R.ok().put("data", shenbaocaozuo);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增申报操作")
    public R save(@RequestBody ShenbaocaozuoEntity shenbaocaozuo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shenbaocaozuo);
        shenbaocaozuoService.save(shenbaocaozuo);
        return R.ok().put("data",shenbaocaozuo.getId());
    }

    /**
     * 前端保存
     */
    @SysLog("新增申报操作")
    @RequestMapping("/add")
    public R add(@RequestBody ShenbaocaozuoEntity shenbaocaozuo, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shenbaocaozuo);
        shenbaocaozuoService.save(shenbaocaozuo);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改申报操作")
    public R update(@RequestBody ShenbaocaozuoEntity shenbaocaozuo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shenbaocaozuo);
        shenbaocaozuoService.updateById(shenbaocaozuo);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除申报操作")
    public R delete(@RequestBody Long[] ids){
        shenbaocaozuoService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }

    








}
