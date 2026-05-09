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

import com.cl.entity.QianshuicuijiaoEntity;
import com.cl.entity.view.QianshuicuijiaoView;

import com.cl.service.QianshuicuijiaoService;
import com.cl.service.TokenService;
import java.io.IOException;

/**
 * 欠税催缴
 * 后端接口
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
@RestController
@RequestMapping("/qianshuicuijiao")
public class QianshuicuijiaoController {
    @Autowired
    private QianshuicuijiaoService qianshuicuijiaoService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QianshuicuijiaoEntity qianshuicuijiao,
        HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            qianshuicuijiao.setQiyemingcheng((String)request.getSession().getAttribute("username"));
        }
        QueryWrapper<QianshuicuijiaoEntity> ew = new QueryWrapper<QianshuicuijiaoEntity>();



        PageUtils page = qianshuicuijiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qianshuicuijiao), params), params));
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
    public R list(@RequestParam Map<String, Object> params,QianshuicuijiaoEntity qianshuicuijiao,
		HttpServletRequest request){
        QueryWrapper<QianshuicuijiaoEntity> ew = new QueryWrapper<QianshuicuijiaoEntity>();

		PageUtils page = qianshuicuijiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qianshuicuijiao), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QianshuicuijiaoEntity qianshuicuijiao){
       	QueryWrapper<QianshuicuijiaoEntity> ew = new QueryWrapper<QianshuicuijiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qianshuicuijiao, MPUtil.camelToSnake("qianshuicuijiao")));
        return R.ok().put("data", qianshuicuijiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QianshuicuijiaoEntity qianshuicuijiao){
        QueryWrapper< QianshuicuijiaoEntity> ew = new QueryWrapper< QianshuicuijiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qianshuicuijiao, MPUtil.camelToSnake("qianshuicuijiao")));
		QianshuicuijiaoView qianshuicuijiaoView =  qianshuicuijiaoService.selectView(ew);
		return R.ok("查询欠税催缴成功").put("data", qianshuicuijiaoView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QianshuicuijiaoEntity qianshuicuijiao = qianshuicuijiaoService.getById(id);
		qianshuicuijiao = qianshuicuijiaoService.selectView(new QueryWrapper<QianshuicuijiaoEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(qianshuicuijiao,deSens);
        return R.ok().put("data", qianshuicuijiao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QianshuicuijiaoEntity qianshuicuijiao = qianshuicuijiaoService.getById(id);
		qianshuicuijiao = qianshuicuijiaoService.selectView(new QueryWrapper<QianshuicuijiaoEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(qianshuicuijiao,deSens);
        return R.ok().put("data", qianshuicuijiao);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增欠税催缴")
    public R save(@RequestBody QianshuicuijiaoEntity qianshuicuijiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qianshuicuijiao);
        qianshuicuijiaoService.save(qianshuicuijiao);
        return R.ok().put("data",qianshuicuijiao.getId());
    }

    /**
     * 前端保存
     */
    @SysLog("新增欠税催缴")
    @RequestMapping("/add")
    public R add(@RequestBody QianshuicuijiaoEntity qianshuicuijiao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(qianshuicuijiao);
        qianshuicuijiaoService.save(qianshuicuijiao);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改欠税催缴")
    public R update(@RequestBody QianshuicuijiaoEntity qianshuicuijiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qianshuicuijiao);
        qianshuicuijiaoService.updateById(qianshuicuijiao);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除欠税催缴")
    public R delete(@RequestBody Long[] ids){
        qianshuicuijiaoService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }

    








}
