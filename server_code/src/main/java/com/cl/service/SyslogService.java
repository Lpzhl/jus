package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.SyslogEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.SyslogView;


/**
 * 操作日志
 *
 * @author 
 * @email 
 * @date 2026-04-30 18:52:45
 */
public interface SyslogService extends IService<SyslogEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SyslogView> selectListView(QueryWrapper<SyslogEntity> wrapper);
   	
   	SyslogView selectView(@Param("ew") QueryWrapper<SyslogEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<SyslogEntity> wrapper);
   	

}

