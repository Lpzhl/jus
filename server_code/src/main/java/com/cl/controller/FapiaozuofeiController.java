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

import com.cl.entity.FapiaozuofeiEntity;
import com.cl.entity.view.FapiaozuofeiView;

import com.cl.service.FapiaozuofeiService;
import com.cl.service.TokenService;
import java.io.IOException;

/**
 * 发票作废
 * 后端接口
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
@RestController
@RequestMapping("/fapiaozuofei")
public class FapiaozuofeiController {
    @Autowired
    private FapiaozuofeiService fapiaozuofeiService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FapiaozuofeiEntity fapiaozuofei,
        @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date zuofeishijianStart,
        @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date zuofeishijianEnd,
        HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            fapiaozuofei.setQiyemingcheng((String)request.getSession().getAttribute("username"));
        }
        QueryWrapper<FapiaozuofeiEntity> ew = new QueryWrapper<FapiaozuofeiEntity>();
        if(zuofeishijianStart!=null) ew.ge("zuofeishijian", zuofeishijianStart);
        if(zuofeishijianEnd!=null) ew.le("zuofeishijian", zuofeishijianEnd);



        PageUtils page = fapiaozuofeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fapiaozuofei), params), params));
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
    public R list(@RequestParam Map<String, Object> params,FapiaozuofeiEntity fapiaozuofei,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date zuofeishijianStart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date zuofeishijianEnd,
		HttpServletRequest request){
        QueryWrapper<FapiaozuofeiEntity> ew = new QueryWrapper<FapiaozuofeiEntity>();
                if(zuofeishijianStart!=null) ew.ge("zuofeishijian", zuofeishijianStart);
                if(zuofeishijianEnd!=null) ew.le("zuofeishijian", zuofeishijianEnd);

		PageUtils page = fapiaozuofeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fapiaozuofei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FapiaozuofeiEntity fapiaozuofei){
       	QueryWrapper<FapiaozuofeiEntity> ew = new QueryWrapper<FapiaozuofeiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fapiaozuofei, MPUtil.camelToSnake("fapiaozuofei")));
        return R.ok().put("data", fapiaozuofeiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FapiaozuofeiEntity fapiaozuofei){
        QueryWrapper< FapiaozuofeiEntity> ew = new QueryWrapper< FapiaozuofeiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fapiaozuofei, MPUtil.camelToSnake("fapiaozuofei")));
		FapiaozuofeiView fapiaozuofeiView =  fapiaozuofeiService.selectView(ew);
		return R.ok("查询发票作废成功").put("data", fapiaozuofeiView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FapiaozuofeiEntity fapiaozuofei = fapiaozuofeiService.getById(id);
		fapiaozuofei = fapiaozuofeiService.selectView(new QueryWrapper<FapiaozuofeiEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(fapiaozuofei,deSens);
        return R.ok().put("data", fapiaozuofei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FapiaozuofeiEntity fapiaozuofei = fapiaozuofeiService.getById(id);
		fapiaozuofei = fapiaozuofeiService.selectView(new QueryWrapper<FapiaozuofeiEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(fapiaozuofei,deSens);
        return R.ok().put("data", fapiaozuofei);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增发票作废")
    public R save(@RequestBody FapiaozuofeiEntity fapiaozuofei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fapiaozuofei);
        fapiaozuofeiService.save(fapiaozuofei);
        return R.ok().put("data",fapiaozuofei.getId());
    }

    /**
     * 前端保存
     */
    @SysLog("新增发票作废")
    @RequestMapping("/add")
    public R add(@RequestBody FapiaozuofeiEntity fapiaozuofei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fapiaozuofei);
        fapiaozuofeiService.save(fapiaozuofei);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改发票作废")
    public R update(@RequestBody FapiaozuofeiEntity fapiaozuofei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fapiaozuofei);
        fapiaozuofeiService.updateById(fapiaozuofei);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除发票作废")
    public R delete(@RequestBody Long[] ids){
        fapiaozuofeiService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }

    








}
