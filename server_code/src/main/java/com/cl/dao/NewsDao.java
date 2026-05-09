package com.cl.dao;

import com.cl.entity.NewsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.NewsView;


/**
 * 税务资讯
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:45
 */
public interface NewsDao extends BaseMapper<NewsEntity> {
	
	List<NewsView> selectListView(@Param("ew") QueryWrapper<NewsEntity> wrapper);

	List<NewsView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<NewsEntity> wrapper);
	
	NewsView selectView(@Param("ew") QueryWrapper<NewsEntity> wrapper);


}
