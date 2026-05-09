package com.cl.dao;

import com.cl.entity.ShuikuanjiaonaEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShuikuanjiaonaView;


/**
 * 税款缴纳
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
public interface ShuikuanjiaonaDao extends BaseMapper<ShuikuanjiaonaEntity> {
	
	List<ShuikuanjiaonaView> selectListView(@Param("ew") QueryWrapper<ShuikuanjiaonaEntity> wrapper);

	List<ShuikuanjiaonaView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<ShuikuanjiaonaEntity> wrapper);
	
	ShuikuanjiaonaView selectView(@Param("ew") QueryWrapper<ShuikuanjiaonaEntity> wrapper);


    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<ShuikuanjiaonaEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<ShuikuanjiaonaEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<ShuikuanjiaonaEntity> wrapper);



}
