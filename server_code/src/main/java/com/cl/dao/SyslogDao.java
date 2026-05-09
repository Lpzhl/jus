package com.cl.dao;

import com.cl.entity.SyslogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.SyslogView;


/**
 * 操作日志
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:45
 */
public interface SyslogDao extends BaseMapper<SyslogEntity> {
	
	List<SyslogView> selectListView(@Param("ew") QueryWrapper<SyslogEntity> wrapper);

	List<SyslogView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<SyslogEntity> wrapper);
	
	SyslogView selectView(@Param("ew") QueryWrapper<SyslogEntity> wrapper);


}
