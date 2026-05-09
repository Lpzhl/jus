package com.cl.dao;

import com.cl.entity.FapiaozuofeiEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FapiaozuofeiView;


/**
 * 发票作废
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
public interface FapiaozuofeiDao extends BaseMapper<FapiaozuofeiEntity> {
	
	List<FapiaozuofeiView> selectListView(@Param("ew") QueryWrapper<FapiaozuofeiEntity> wrapper);

	List<FapiaozuofeiView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<FapiaozuofeiEntity> wrapper);
	
	FapiaozuofeiView selectView(@Param("ew") QueryWrapper<FapiaozuofeiEntity> wrapper);


}
