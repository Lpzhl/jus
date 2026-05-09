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

import com.cl.entity.ZiliaoshangchuanEntity;
import com.cl.entity.view.ZiliaoshangchuanView;

import com.cl.service.ZiliaoshangchuanService;
import com.cl.service.TokenService;
import java.io.IOException;

/**
 * 资料上传
 * 后端接口
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
@RestController
@RequestMapping("/ziliaoshangchuan")
public class ZiliaoshangchuanController {
    @Autowired
    private ZiliaoshangchuanService ziliaoshangchuanService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZiliaoshangchuanEntity ziliaoshangchuan,
        HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            ziliaoshangchuan.setQiyemingcheng((String)request.getSession().getAttribute("username"));
        }
        QueryWrapper<ZiliaoshangchuanEntity> ew = new QueryWrapper<ZiliaoshangchuanEntity>();



        PageUtils page = ziliaoshangchuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziliaoshangchuan), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ZiliaoshangchuanEntity ziliaoshangchuan,
		HttpServletRequest request){
        QueryWrapper<ZiliaoshangchuanEntity> ew = new QueryWrapper<ZiliaoshangchuanEntity>();

		PageUtils page = ziliaoshangchuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziliaoshangchuan), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZiliaoshangchuanEntity ziliaoshangchuan){
       	QueryWrapper<ZiliaoshangchuanEntity> ew = new QueryWrapper<ZiliaoshangchuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ziliaoshangchuan, MPUtil.camelToSnake("ziliaoshangchuan")));
        return R.ok().put("data", ziliaoshangchuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZiliaoshangchuanEntity ziliaoshangchuan){
        QueryWrapper< ZiliaoshangchuanEntity> ew = new QueryWrapper< ZiliaoshangchuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ziliaoshangchuan, MPUtil.camelToSnake("ziliaoshangchuan")));
		ZiliaoshangchuanView ziliaoshangchuanView =  ziliaoshangchuanService.selectView(ew);
		return R.ok("查询资料上传成功").put("data", ziliaoshangchuanView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZiliaoshangchuanEntity ziliaoshangchuan = ziliaoshangchuanService.getById(id);
		ziliaoshangchuan = ziliaoshangchuanService.selectView(new QueryWrapper<ZiliaoshangchuanEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(ziliaoshangchuan,deSens);
        return R.ok().put("data", ziliaoshangchuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZiliaoshangchuanEntity ziliaoshangchuan = ziliaoshangchuanService.getById(id);
		ziliaoshangchuan = ziliaoshangchuanService.selectView(new QueryWrapper<ZiliaoshangchuanEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(ziliaoshangchuan,deSens);
        return R.ok().put("data", ziliaoshangchuan);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增资料上传")
    public R save(@RequestBody ZiliaoshangchuanEntity ziliaoshangchuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ziliaoshangchuan);
        ziliaoshangchuanService.save(ziliaoshangchuan);
        return R.ok().put("data",ziliaoshangchuan.getId());
    }

    /**
     * 前端保存
     */
    @SysLog("新增资料上传")
    @RequestMapping("/add")
    public R add(@RequestBody ZiliaoshangchuanEntity ziliaoshangchuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(ziliaoshangchuan);
        ziliaoshangchuanService.save(ziliaoshangchuan);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改资料上传")
    public R update(@RequestBody ZiliaoshangchuanEntity ziliaoshangchuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ziliaoshangchuan);
        ziliaoshangchuanService.updateById(ziliaoshangchuan);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核资料上传")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ZiliaoshangchuanEntity> list = new ArrayList<ZiliaoshangchuanEntity>();
        for(Long id : ids) {
            ZiliaoshangchuanEntity ziliaoshangchuan = ziliaoshangchuanService.getById(id);
            ziliaoshangchuan.setSfsh(sfsh);
            ziliaoshangchuan.setShhf(shhf);
            list.add(ziliaoshangchuan);
        }
        ziliaoshangchuanService.updateBatchById(list);
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除资料上传")
    public R delete(@RequestBody Long[] ids){
        ziliaoshangchuanService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }

    








}
