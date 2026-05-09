package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChathelperEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChathelperView;


/**
 * 聊天助手
 *
 * @author 
 * @email 
 * @date 2026-04-30 18:52:45
 */
public interface ChathelperService extends IService<ChathelperEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChathelperView> selectListView(QueryWrapper<ChathelperEntity> wrapper);
   	
   	ChathelperView selectView(@Param("ew") QueryWrapper<ChathelperEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<ChathelperEntity> wrapper);
   	

}

