package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.QiyeEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QiyeView;


/**
 * 企业
 *
 * @author 
 * @email 
 * @date 2026-04-30 18:52:45
 */
public interface QiyeService extends IService<QiyeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QiyeView> selectListView(QueryWrapper<QiyeEntity> wrapper);
   	
   	QiyeView selectView(@Param("ew") QueryWrapper<QiyeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<QiyeEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,QueryWrapper<QiyeEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,QueryWrapper<QiyeEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,QueryWrapper<QiyeEntity> wrapper);



}

