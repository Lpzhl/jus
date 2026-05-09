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

import com.cl.entity.FapiaohexiaoEntity;
import com.cl.entity.view.FapiaohexiaoView;

import com.cl.service.FapiaohexiaoService;
import com.cl.service.TokenService;
import java.io.IOException;

/**
 * 发票核销
 * 后端接口
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
@RestController
@RequestMapping("/fapiaohexiao")
public class FapiaohexiaoController {
    @Autowired
    private FapiaohexiaoService fapiaohexiaoService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FapiaohexiaoEntity fapiaohexiao,
        @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date hexiaoshijianStart,
        @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date hexiaoshijianEnd,
        HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            fapiaohexiao.setQiyemingcheng((String)request.getSession().getAttribute("username"));
        }
        QueryWrapper<FapiaohexiaoEntity> ew = new QueryWrapper<FapiaohexiaoEntity>();
        if(hexiaoshijianStart!=null) ew.ge("hexiaoshijian", hexiaoshijianStart);
        if(hexiaoshijianEnd!=null) ew.le("hexiaoshijian", hexiaoshijianEnd);



        PageUtils page = fapiaohexiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fapiaohexiao), params), params));
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
    public R list(@RequestParam Map<String, Object> params,FapiaohexiaoEntity fapiaohexiao,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date hexiaoshijianStart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date hexiaoshijianEnd,
		HttpServletRequest request){
        QueryWrapper<FapiaohexiaoEntity> ew = new QueryWrapper<FapiaohexiaoEntity>();
                if(hexiaoshijianStart!=null) ew.ge("hexiaoshijian", hexiaoshijianStart);
                if(hexiaoshijianEnd!=null) ew.le("hexiaoshijian", hexiaoshijianEnd);

		PageUtils page = fapiaohexiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fapiaohexiao), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FapiaohexiaoEntity fapiaohexiao){
       	QueryWrapper<FapiaohexiaoEntity> ew = new QueryWrapper<FapiaohexiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fapiaohexiao, MPUtil.camelToSnake("fapiaohexiao")));
        return R.ok().put("data", fapiaohexiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FapiaohexiaoEntity fapiaohexiao){
        QueryWrapper< FapiaohexiaoEntity> ew = new QueryWrapper< FapiaohexiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fapiaohexiao, MPUtil.camelToSnake("fapiaohexiao")));
		FapiaohexiaoView fapiaohexiaoView =  fapiaohexiaoService.selectView(ew);
		return R.ok("查询发票核销成功").put("data", fapiaohexiaoView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FapiaohexiaoEntity fapiaohexiao = fapiaohexiaoService.getById(id);
		fapiaohexiao = fapiaohexiaoService.selectView(new QueryWrapper<FapiaohexiaoEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(fapiaohexiao,deSens);
        return R.ok().put("data", fapiaohexiao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FapiaohexiaoEntity fapiaohexiao = fapiaohexiaoService.getById(id);
		fapiaohexiao = fapiaohexiaoService.selectView(new QueryWrapper<FapiaohexiaoEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(fapiaohexiao,deSens);
        return R.ok().put("data", fapiaohexiao);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增发票核销")
    public R save(@RequestBody FapiaohexiaoEntity fapiaohexiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fapiaohexiao);
        fapiaohexiaoService.save(fapiaohexiao);
        return R.ok().put("data",fapiaohexiao.getId());
    }

    /**
     * 前端保存
     */
    @SysLog("新增发票核销")
    @RequestMapping("/add")
    public R add(@RequestBody FapiaohexiaoEntity fapiaohexiao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fapiaohexiao);
        fapiaohexiaoService.save(fapiaohexiao);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改发票核销")
    public R update(@RequestBody FapiaohexiaoEntity fapiaohexiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fapiaohexiao);
        fapiaohexiaoService.updateById(fapiaohexiao);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除发票核销")
    public R delete(@RequestBody Long[] ids){
        fapiaohexiaoService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }

    








}
