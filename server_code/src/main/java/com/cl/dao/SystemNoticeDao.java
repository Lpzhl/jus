package com.cl.dao;

import com.cl.entity.SystemNoticeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.SystemNoticeView;


/**
 * 系统公告
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:45
 */
public interface SystemNoticeDao extends BaseMapper<SystemNoticeEntity> {
	
	List<SystemNoticeView> selectListView(@Param("ew") QueryWrapper<SystemNoticeEntity> wrapper);

	List<SystemNoticeView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<SystemNoticeEntity> wrapper);
	
	SystemNoticeView selectView(@Param("ew") QueryWrapper<SystemNoticeEntity> wrapper);


}
