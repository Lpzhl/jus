package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JichushujuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JichushujuView;


/**
 * 基础数据
 *
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
public interface JichushujuService extends IService<JichushujuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JichushujuView> selectListView(QueryWrapper<JichushujuEntity> wrapper);
   	
   	JichushujuView selectView(@Param("ew") QueryWrapper<JichushujuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<JichushujuEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,QueryWrapper<JichushujuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,QueryWrapper<JichushujuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,QueryWrapper<JichushujuEntity> wrapper);



}

