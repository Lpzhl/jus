package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ShuikuanjiaonaDao;
import com.cl.entity.ShuikuanjiaonaEntity;
import com.cl.service.ShuikuanjiaonaService;
import com.cl.entity.view.ShuikuanjiaonaView;

@Service("shuikuanjiaonaService")
public class ShuikuanjiaonaServiceImpl extends ServiceImpl<ShuikuanjiaonaDao, ShuikuanjiaonaEntity> implements ShuikuanjiaonaService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShuikuanjiaonaEntity> page = baseMapper.selectPage(new Query<ShuikuanjiaonaEntity>(params).getPage(),new QueryWrapper<ShuikuanjiaonaEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ShuikuanjiaonaEntity> wrapper) {
        Page<ShuikuanjiaonaEntity> page = baseMapper.selectPage(new Query<ShuikuanjiaonaEntity>(params).getPage(),wrapper);
        Page<ShuikuanjiaonaView> pageVo = (Page<ShuikuanjiaonaView>)page.convert(ShuikuanjiaonaView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<ShuikuanjiaonaView> selectListView(QueryWrapper<ShuikuanjiaonaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShuikuanjiaonaView selectView(QueryWrapper<ShuikuanjiaonaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, QueryWrapper<ShuikuanjiaonaEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, QueryWrapper<ShuikuanjiaonaEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, QueryWrapper<ShuikuanjiaonaEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
