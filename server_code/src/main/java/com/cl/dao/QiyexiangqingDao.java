package com.cl.dao;

import com.cl.entity.QiyexiangqingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QiyexiangqingView;


/**
 * 企业详情
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
public interface QiyexiangqingDao extends BaseMapper<QiyexiangqingEntity> {
	
	List<QiyexiangqingView> selectListView(@Param("ew") QueryWrapper<QiyexiangqingEntity> wrapper);

	List<QiyexiangqingView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<QiyexiangqingEntity> wrapper);
	
	QiyexiangqingView selectView(@Param("ew") QueryWrapper<QiyexiangqingEntity> wrapper);


}
