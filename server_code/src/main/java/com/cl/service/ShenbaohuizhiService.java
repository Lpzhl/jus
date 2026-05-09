package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShenbaohuizhiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShenbaohuizhiView;


/**
 * 申报回执
 *
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
public interface ShenbaohuizhiService extends IService<ShenbaohuizhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShenbaohuizhiView> selectListView(QueryWrapper<ShenbaohuizhiEntity> wrapper);
   	
   	ShenbaohuizhiView selectView(@Param("ew") QueryWrapper<ShenbaohuizhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<ShenbaohuizhiEntity> wrapper);
   	

}

