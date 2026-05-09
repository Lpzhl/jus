package com.cl.dao;

import com.cl.entity.FapiaohexiaoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FapiaohexiaoView;


/**
 * 发票核销
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
public interface FapiaohexiaoDao extends BaseMapper<FapiaohexiaoEntity> {
	
	List<FapiaohexiaoView> selectListView(@Param("ew") QueryWrapper<FapiaohexiaoEntity> wrapper);

	List<FapiaohexiaoView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<FapiaohexiaoEntity> wrapper);
	
	FapiaohexiaoView selectView(@Param("ew") QueryWrapper<FapiaohexiaoEntity> wrapper);


}
