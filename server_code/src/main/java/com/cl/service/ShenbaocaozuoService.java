package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShenbaocaozuoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShenbaocaozuoView;


/**
 * 申报操作
 *
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
public interface ShenbaocaozuoService extends IService<ShenbaocaozuoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShenbaocaozuoView> selectListView(QueryWrapper<ShenbaocaozuoEntity> wrapper);
   	
   	ShenbaocaozuoView selectView(@Param("ew") QueryWrapper<ShenbaocaozuoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<ShenbaocaozuoEntity> wrapper);
   	

}

