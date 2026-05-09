package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FapiaohexiaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FapiaohexiaoView;


/**
 * 发票核销
 *
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
public interface FapiaohexiaoService extends IService<FapiaohexiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FapiaohexiaoView> selectListView(QueryWrapper<FapiaohexiaoEntity> wrapper);
   	
   	FapiaohexiaoView selectView(@Param("ew") QueryWrapper<FapiaohexiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<FapiaohexiaoEntity> wrapper);
   	

}

