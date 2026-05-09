package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShuiwuhuizongfenxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShuiwuhuizongfenxiView;


/**
 * 税务汇总分析
 *
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
public interface ShuiwuhuizongfenxiService extends IService<ShuiwuhuizongfenxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShuiwuhuizongfenxiView> selectListView(QueryWrapper<ShuiwuhuizongfenxiEntity> wrapper);
   	
   	ShuiwuhuizongfenxiView selectView(@Param("ew") QueryWrapper<ShuiwuhuizongfenxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<ShuiwuhuizongfenxiEntity> wrapper);
   	

}

