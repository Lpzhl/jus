package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FapiaozuofeiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FapiaozuofeiView;


/**
 * 发票作废
 *
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
public interface FapiaozuofeiService extends IService<FapiaozuofeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FapiaozuofeiView> selectListView(QueryWrapper<FapiaozuofeiEntity> wrapper);
   	
   	FapiaozuofeiView selectView(@Param("ew") QueryWrapper<FapiaozuofeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<FapiaozuofeiEntity> wrapper);
   	

}

