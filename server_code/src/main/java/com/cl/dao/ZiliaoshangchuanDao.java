package com.cl.dao;

import com.cl.entity.ZiliaoshangchuanEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiliaoshangchuanView;


/**
 * 资料上传
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
public interface ZiliaoshangchuanDao extends BaseMapper<ZiliaoshangchuanEntity> {
	
	List<ZiliaoshangchuanView> selectListView(@Param("ew") QueryWrapper<ZiliaoshangchuanEntity> wrapper);

	List<ZiliaoshangchuanView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<ZiliaoshangchuanEntity> wrapper);
	
	ZiliaoshangchuanView selectView(@Param("ew") QueryWrapper<ZiliaoshangchuanEntity> wrapper);


}
