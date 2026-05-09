package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.QianshuicuijiaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QianshuicuijiaoView;


/**
 * 欠税催缴
 *
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
public interface QianshuicuijiaoService extends IService<QianshuicuijiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QianshuicuijiaoView> selectListView(QueryWrapper<QianshuicuijiaoEntity> wrapper);
   	
   	QianshuicuijiaoView selectView(@Param("ew") QueryWrapper<QianshuicuijiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<QianshuicuijiaoEntity> wrapper);
   	

}

