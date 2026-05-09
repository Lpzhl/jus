package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.FapiaokaijuDao;
import com.cl.entity.FapiaokaijuEntity;
import com.cl.service.FapiaokaijuService;
import com.cl.entity.view.FapiaokaijuView;

@Service("fapiaokaijuService")
public class FapiaokaijuServiceImpl extends ServiceImpl<FapiaokaijuDao, FapiaokaijuEntity> implements FapiaokaijuService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FapiaokaijuEntity> page = baseMapper.selectPage(new Query<FapiaokaijuEntity>(params).getPage(),new QueryWrapper<FapiaokaijuEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<FapiaokaijuEntity> wrapper) {
        Page<FapiaokaijuEntity> page = baseMapper.selectPage(new Query<FapiaokaijuEntity>(params).getPage(),wrapper);
        Page<FapiaokaijuView> pageVo = (Page<FapiaokaijuView>)page.convert(FapiaokaijuView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<FapiaokaijuView> selectListView(QueryWrapper<FapiaokaijuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FapiaokaijuView selectView(QueryWrapper<FapiaokaijuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, QueryWrapper<FapiaokaijuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, QueryWrapper<FapiaokaijuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, QueryWrapper<FapiaokaijuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
