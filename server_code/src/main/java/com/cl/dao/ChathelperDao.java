package com.cl.dao;

import com.cl.entity.ChathelperEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChathelperView;


/**
 * 聊天助手
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:45
 */
public interface ChathelperDao extends BaseMapper<ChathelperEntity> {
	
	List<ChathelperView> selectListView(@Param("ew") QueryWrapper<ChathelperEntity> wrapper);

	List<ChathelperView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<ChathelperEntity> wrapper);
	
	ChathelperView selectView(@Param("ew") QueryWrapper<ChathelperEntity> wrapper);


}
