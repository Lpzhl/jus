package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.FapiaolingyongDao;
import com.cl.entity.FapiaolingyongEntity;
import com.cl.service.FapiaolingyongService;
import com.cl.entity.view.FapiaolingyongView;

@Service("fapiaolingyongService")
public class FapiaolingyongServiceImpl extends ServiceImpl<FapiaolingyongDao, FapiaolingyongEntity> implements FapiaolingyongService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FapiaolingyongEntity> page = baseMapper.selectPage(new Query<FapiaolingyongEntity>(params).getPage(),new QueryWrapper<FapiaolingyongEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<FapiaolingyongEntity> wrapper) {
        Page<FapiaolingyongEntity> page = baseMapper.selectPage(new Query<FapiaolingyongEntity>(params).getPage(),wrapper);
        Page<FapiaolingyongView> pageVo = (Page<FapiaolingyongView>)page.convert(FapiaolingyongView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<FapiaolingyongView> selectListView(QueryWrapper<FapiaolingyongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FapiaolingyongView selectView(QueryWrapper<FapiaolingyongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, QueryWrapper<FapiaolingyongEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, QueryWrapper<FapiaolingyongEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, QueryWrapper<FapiaolingyongEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
