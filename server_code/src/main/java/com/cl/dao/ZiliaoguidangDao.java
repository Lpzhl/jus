package com.cl.dao;

import com.cl.entity.ZiliaoguidangEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiliaoguidangView;


/**
 * 资料归档
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
public interface ZiliaoguidangDao extends BaseMapper<ZiliaoguidangEntity> {
	
	List<ZiliaoguidangView> selectListView(@Param("ew") QueryWrapper<ZiliaoguidangEntity> wrapper);

	List<ZiliaoguidangView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<ZiliaoguidangEntity> wrapper);
	
	ZiliaoguidangView selectView(@Param("ew") QueryWrapper<ZiliaoguidangEntity> wrapper);


}
