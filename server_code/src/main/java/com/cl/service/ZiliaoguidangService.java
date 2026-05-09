package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZiliaoguidangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiliaoguidangView;


/**
 * 资料归档
 *
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
public interface ZiliaoguidangService extends IService<ZiliaoguidangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZiliaoguidangView> selectListView(QueryWrapper<ZiliaoguidangEntity> wrapper);
   	
   	ZiliaoguidangView selectView(@Param("ew") QueryWrapper<ZiliaoguidangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<ZiliaoguidangEntity> wrapper);
   	

}

