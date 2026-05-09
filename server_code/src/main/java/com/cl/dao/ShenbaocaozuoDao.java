package com.cl.dao;

import com.cl.entity.ShenbaocaozuoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShenbaocaozuoView;


/**
 * 申报操作
 * 
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
public interface ShenbaocaozuoDao extends BaseMapper<ShenbaocaozuoEntity> {
	
	List<ShenbaocaozuoView> selectListView(@Param("ew") QueryWrapper<ShenbaocaozuoEntity> wrapper);

	List<ShenbaocaozuoView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<ShenbaocaozuoEntity> wrapper);
	
	ShenbaocaozuoView selectView(@Param("ew") QueryWrapper<ShenbaocaozuoEntity> wrapper);


}
