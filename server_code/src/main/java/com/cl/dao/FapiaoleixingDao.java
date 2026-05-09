package com.cl.dao;

import com.cl.entity.FapiaoleixingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FapiaoleixingView;


/**
 * 发票类型
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
public interface FapiaoleixingDao extends BaseMapper<FapiaoleixingEntity> {
	
	List<FapiaoleixingView> selectListView(@Param("ew") QueryWrapper<FapiaoleixingEntity> wrapper);

	List<FapiaoleixingView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<FapiaoleixingEntity> wrapper);
	
	FapiaoleixingView selectView(@Param("ew") QueryWrapper<FapiaoleixingEntity> wrapper);


    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<FapiaoleixingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<FapiaoleixingEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<FapiaoleixingEntity> wrapper);



}
