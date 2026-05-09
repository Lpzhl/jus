package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShuikuanjiaonaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShuikuanjiaonaView;


/**
 * 税款缴纳
 *
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
public interface ShuikuanjiaonaService extends IService<ShuikuanjiaonaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShuikuanjiaonaView> selectListView(QueryWrapper<ShuikuanjiaonaEntity> wrapper);
   	
   	ShuikuanjiaonaView selectView(@Param("ew") QueryWrapper<ShuikuanjiaonaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<ShuikuanjiaonaEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,QueryWrapper<ShuikuanjiaonaEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,QueryWrapper<ShuikuanjiaonaEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,QueryWrapper<ShuikuanjiaonaEntity> wrapper);



}

