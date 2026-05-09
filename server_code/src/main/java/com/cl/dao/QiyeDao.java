package com.cl.dao;

import com.cl.entity.QiyeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QiyeView;


/**
 * 企业
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:45
 */
public interface QiyeDao extends BaseMapper<QiyeEntity> {
	
	List<QiyeView> selectListView(@Param("ew") QueryWrapper<QiyeEntity> wrapper);

	List<QiyeView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<QiyeEntity> wrapper);
	
	QiyeView selectView(@Param("ew") QueryWrapper<QiyeEntity> wrapper);


    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<QiyeEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<QiyeEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<QiyeEntity> wrapper);



}
