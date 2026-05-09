package com.cl.dao;

import com.cl.entity.FapiaolingyongEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FapiaolingyongView;


/**
 * 发票领用
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
public interface FapiaolingyongDao extends BaseMapper<FapiaolingyongEntity> {
	
	List<FapiaolingyongView> selectListView(@Param("ew") QueryWrapper<FapiaolingyongEntity> wrapper);

	List<FapiaolingyongView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<FapiaolingyongEntity> wrapper);
	
	FapiaolingyongView selectView(@Param("ew") QueryWrapper<FapiaolingyongEntity> wrapper);


    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<FapiaolingyongEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<FapiaolingyongEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<FapiaolingyongEntity> wrapper);



}
