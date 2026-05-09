package com.cl.dao;

import com.cl.entity.ShenbaohuizhiEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShenbaohuizhiView;


/**
 * 申报回执
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
public interface ShenbaohuizhiDao extends BaseMapper<ShenbaohuizhiEntity> {
	
	List<ShenbaohuizhiView> selectListView(@Param("ew") QueryWrapper<ShenbaohuizhiEntity> wrapper);

	List<ShenbaohuizhiView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<ShenbaohuizhiEntity> wrapper);
	
	ShenbaohuizhiView selectView(@Param("ew") QueryWrapper<ShenbaohuizhiEntity> wrapper);


}
