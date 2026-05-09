package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.QiyeDao;
import com.cl.entity.QiyeEntity;
import com.cl.service.QiyeService;
import com.cl.entity.view.QiyeView;

@Service("qiyeService")
public class QiyeServiceImpl extends ServiceImpl<QiyeDao, QiyeEntity> implements QiyeService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QiyeEntity> page = baseMapper.selectPage(new Query<QiyeEntity>(params).getPage(),new QueryWrapper<QiyeEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<QiyeEntity> wrapper) {
        Page<QiyeEntity> page = baseMapper.selectPage(new Query<QiyeEntity>(params).getPage(),wrapper);
        Page<QiyeView> pageVo = (Page<QiyeView>)page.convert(QiyeView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<QiyeView> selectListView(QueryWrapper<QiyeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QiyeView selectView(QueryWrapper<QiyeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, QueryWrapper<QiyeEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, QueryWrapper<QiyeEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, QueryWrapper<QiyeEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
