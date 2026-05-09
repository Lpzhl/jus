package com.cl.dao;

import com.cl.entity.FapiaokaijuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FapiaokaijuView;


/**
 * 发票开具
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
public interface FapiaokaijuDao extends BaseMapper<FapiaokaijuEntity> {
	
	List<FapiaokaijuView> selectListView(@Param("ew") QueryWrapper<FapiaokaijuEntity> wrapper);

	List<FapiaokaijuView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<FapiaokaijuEntity> wrapper);
	
	FapiaokaijuView selectView(@Param("ew") QueryWrapper<FapiaokaijuEntity> wrapper);


    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<FapiaokaijuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<FapiaokaijuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<FapiaokaijuEntity> wrapper);



}
