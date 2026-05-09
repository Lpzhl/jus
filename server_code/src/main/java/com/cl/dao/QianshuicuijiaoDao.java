package com.cl.dao;

import com.cl.entity.QianshuicuijiaoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QianshuicuijiaoView;


/**
 * 欠税催缴
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
public interface QianshuicuijiaoDao extends BaseMapper<QianshuicuijiaoEntity> {
	
	List<QianshuicuijiaoView> selectListView(@Param("ew") QueryWrapper<QianshuicuijiaoEntity> wrapper);

	List<QianshuicuijiaoView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<QianshuicuijiaoEntity> wrapper);
	
	QianshuicuijiaoView selectView(@Param("ew") QueryWrapper<QianshuicuijiaoEntity> wrapper);


}
