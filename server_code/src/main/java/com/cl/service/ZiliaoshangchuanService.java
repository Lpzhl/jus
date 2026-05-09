package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZiliaoshangchuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiliaoshangchuanView;


/**
 * 资料上传
 *
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
public interface ZiliaoshangchuanService extends IService<ZiliaoshangchuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZiliaoshangchuanView> selectListView(QueryWrapper<ZiliaoshangchuanEntity> wrapper);
   	
   	ZiliaoshangchuanView selectView(@Param("ew") QueryWrapper<ZiliaoshangchuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<ZiliaoshangchuanEntity> wrapper);
   	

}

