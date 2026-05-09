package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FapiaolingyongEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FapiaolingyongView;


/**
 * 发票领用
 *
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
public interface FapiaolingyongService extends IService<FapiaolingyongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FapiaolingyongView> selectListView(QueryWrapper<FapiaolingyongEntity> wrapper);
   	
   	FapiaolingyongView selectView(@Param("ew") QueryWrapper<FapiaolingyongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<FapiaolingyongEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,QueryWrapper<FapiaolingyongEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,QueryWrapper<FapiaolingyongEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,QueryWrapper<FapiaolingyongEntity> wrapper);



}

