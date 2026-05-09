package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FapiaokaijuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FapiaokaijuView;


/**
 * 发票开具
 *
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
public interface FapiaokaijuService extends IService<FapiaokaijuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FapiaokaijuView> selectListView(QueryWrapper<FapiaokaijuEntity> wrapper);
   	
   	FapiaokaijuView selectView(@Param("ew") QueryWrapper<FapiaokaijuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<FapiaokaijuEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,QueryWrapper<FapiaokaijuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,QueryWrapper<FapiaokaijuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,QueryWrapper<FapiaokaijuEntity> wrapper);



}

