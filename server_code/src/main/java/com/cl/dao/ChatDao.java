package com.cl.dao;

import com.cl.entity.ChatEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChatView;


/**
 * 咨询问题
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:45
 */
public interface ChatDao extends BaseMapper<ChatEntity> {
	
	List<ChatView> selectListView(@Param("ew") QueryWrapper<ChatEntity> wrapper);

	List<ChatView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<ChatEntity> wrapper);
	
	ChatView selectView(@Param("ew") QueryWrapper<ChatEntity> wrapper);


}
