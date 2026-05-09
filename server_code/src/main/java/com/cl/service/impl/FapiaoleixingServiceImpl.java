package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.FapiaoleixingDao;
import com.cl.entity.FapiaoleixingEntity;
import com.cl.service.FapiaoleixingService;
import com.cl.entity.view.FapiaoleixingView;

@Service("fapiaoleixingService")
public class FapiaoleixingServiceImpl extends ServiceImpl<FapiaoleixingDao, FapiaoleixingEntity> implements FapiaoleixingService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FapiaoleixingEntity> page = baseMapper.selectPage(new Query<FapiaoleixingEntity>(params).getPage(),new QueryWrapper<FapiaoleixingEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<FapiaoleixingEntity> wrapper) {
        Page<FapiaoleixingEntity> page = baseMapper.selectPage(new Query<FapiaoleixingEntity>(params).getPage(),wrapper);
        Page<FapiaoleixingView> pageVo = (Page<FapiaoleixingView>)page.convert(FapiaoleixingView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<FapiaoleixingView> selectListView(QueryWrapper<FapiaoleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FapiaoleixingView selectView(QueryWrapper<FapiaoleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, QueryWrapper<FapiaoleixingEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, QueryWrapper<FapiaoleixingEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, QueryWrapper<FapiaoleixingEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
