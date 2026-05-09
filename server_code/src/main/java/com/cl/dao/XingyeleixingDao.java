package com.cl.dao;

import com.cl.entity.XingyeleixingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XingyeleixingView;


/**
 * 行业类型
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:45
 */
public interface XingyeleixingDao extends BaseMapper<XingyeleixingEntity> {
	
	List<XingyeleixingView> selectListView(@Param("ew") QueryWrapper<XingyeleixingEntity> wrapper);

	List<XingyeleixingView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<XingyeleixingEntity> wrapper);
	
	XingyeleixingView selectView(@Param("ew") QueryWrapper<XingyeleixingEntity> wrapper);


}
