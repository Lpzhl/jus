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

import com.cl.entity.ZiliaoguidangEntity;
import com.cl.entity.view.ZiliaoguidangView;

import com.cl.service.ZiliaoguidangService;
import com.cl.service.TokenService;
import java.io.IOException;

/**
 * 资料归档
 * 后端接口
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
@RestController
@RequestMapping("/ziliaoguidang")
public class ZiliaoguidangController {
    @Autowired
    private ZiliaoguidangService ziliaoguidangService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZiliaoguidangEntity ziliaoguidang,
        HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            ziliaoguidang.setQiyemingcheng((String)request.getSession().getAttribute("username"));
        }
        QueryWrapper<ZiliaoguidangEntity> ew = new QueryWrapper<ZiliaoguidangEntity>();



        PageUtils page = ziliaoguidangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziliaoguidang), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ZiliaoguidangEntity ziliaoguidang,
		HttpServletRequest request){
        QueryWrapper<ZiliaoguidangEntity> ew = new QueryWrapper<ZiliaoguidangEntity>();

		PageUtils page = ziliaoguidangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziliaoguidang), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZiliaoguidangEntity ziliaoguidang){
       	QueryWrapper<ZiliaoguidangEntity> ew = new QueryWrapper<ZiliaoguidangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ziliaoguidang, MPUtil.camelToSnake("ziliaoguidang")));
        return R.ok().put("data", ziliaoguidangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZiliaoguidangEntity ziliaoguidang){
        QueryWrapper< ZiliaoguidangEntity> ew = new QueryWrapper< ZiliaoguidangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ziliaoguidang, MPUtil.camelToSnake("ziliaoguidang")));
		ZiliaoguidangView ziliaoguidangView =  ziliaoguidangService.selectView(ew);
		return R.ok("查询资料归档成功").put("data", ziliaoguidangView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZiliaoguidangEntity ziliaoguidang = ziliaoguidangService.getById(id);
		ziliaoguidang = ziliaoguidangService.selectView(new QueryWrapper<ZiliaoguidangEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(ziliaoguidang,deSens);
        return R.ok().put("data", ziliaoguidang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZiliaoguidangEntity ziliaoguidang = ziliaoguidangService.getById(id);
		ziliaoguidang = ziliaoguidangService.selectView(new QueryWrapper<ZiliaoguidangEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(ziliaoguidang,deSens);
        return R.ok().put("data", ziliaoguidang);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增资料归档")
    public R save(@RequestBody ZiliaoguidangEntity ziliaoguidang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ziliaoguidang);
        ziliaoguidangService.save(ziliaoguidang);
        return R.ok().put("data",ziliaoguidang.getId());
    }

    /**
     * 前端保存
     */
    @SysLog("新增资料归档")
    @RequestMapping("/add")
    public R add(@RequestBody ZiliaoguidangEntity ziliaoguidang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(ziliaoguidang);
        ziliaoguidangService.save(ziliaoguidang);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改资料归档")
    public R update(@RequestBody ZiliaoguidangEntity ziliaoguidang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ziliaoguidang);
        ziliaoguidangService.updateById(ziliaoguidang);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除资料归档")
    public R delete(@RequestBody Long[] ids){
        ziliaoguidangService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }

    








}
