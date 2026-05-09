package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.SystemNoticeEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.SystemNoticeView;


/**
 * 系统公告
 *
 * @author 
 * @email 
 * @date 2026-04-30 18:52:45
 */
public interface SystemNoticeService extends IService<SystemNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SystemNoticeView> selectListView(QueryWrapper<SystemNoticeEntity> wrapper);
   	
   	SystemNoticeView selectView(@Param("ew") QueryWrapper<SystemNoticeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<SystemNoticeEntity> wrapper);
   	

}

