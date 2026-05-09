package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.QiyexiangqingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QiyexiangqingView;


/**
 * 企业详情
 *
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
public interface QiyexiangqingService extends IService<QiyexiangqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QiyexiangqingView> selectListView(QueryWrapper<QiyexiangqingEntity> wrapper);
   	
   	QiyexiangqingView selectView(@Param("ew") QueryWrapper<QiyexiangqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<QiyexiangqingEntity> wrapper);
   	

}

