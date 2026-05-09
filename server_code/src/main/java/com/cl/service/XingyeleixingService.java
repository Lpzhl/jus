package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XingyeleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XingyeleixingView;


/**
 * 行业类型
 *
 * @author 
 * @email 
 * @date 2026-04-30 18:52:45
 */
public interface XingyeleixingService extends IService<XingyeleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XingyeleixingView> selectListView(QueryWrapper<XingyeleixingEntity> wrapper);
   	
   	XingyeleixingView selectView(@Param("ew") QueryWrapper<XingyeleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<XingyeleixingEntity> wrapper);
   	

}

