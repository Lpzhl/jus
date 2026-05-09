package com.cl.dao;

import com.cl.entity.JichushujuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JichushujuView;


/**
 * 基础数据
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
public interface JichushujuDao extends BaseMapper<JichushujuEntity> {
	
	List<JichushujuView> selectListView(@Param("ew") QueryWrapper<JichushujuEntity> wrapper);

	List<JichushujuView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<JichushujuEntity> wrapper);
	
	JichushujuView selectView(@Param("ew") QueryWrapper<JichushujuEntity> wrapper);


    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<JichushujuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<JichushujuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<JichushujuEntity> wrapper);



}
