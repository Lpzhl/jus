package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FapiaoleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FapiaoleixingView;


/**
 * 发票类型
 *
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
public interface FapiaoleixingService extends IService<FapiaoleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FapiaoleixingView> selectListView(QueryWrapper<FapiaoleixingEntity> wrapper);
   	
   	FapiaoleixingView selectView(@Param("ew") QueryWrapper<FapiaoleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<FapiaoleixingEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,QueryWrapper<FapiaoleixingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,QueryWrapper<FapiaoleixingEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,QueryWrapper<FapiaoleixingEntity> wrapper);



}

