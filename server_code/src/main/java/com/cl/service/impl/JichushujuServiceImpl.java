package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.JichushujuDao;
import com.cl.entity.JichushujuEntity;
import com.cl.service.JichushujuService;
import com.cl.entity.view.JichushujuView;

@Service("jichushujuService")
public class JichushujuServiceImpl extends ServiceImpl<JichushujuDao, JichushujuEntity> implements JichushujuService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JichushujuEntity> page = baseMapper.selectPage(new Query<JichushujuEntity>(params).getPage(),new QueryWrapper<JichushujuEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<JichushujuEntity> wrapper) {
        Page<JichushujuEntity> page = baseMapper.selectPage(new Query<JichushujuEntity>(params).getPage(),wrapper);
        Page<JichushujuView> pageVo = (Page<JichushujuView>)page.convert(JichushujuView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<JichushujuView> selectListView(QueryWrapper<JichushujuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JichushujuView selectView(QueryWrapper<JichushujuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, QueryWrapper<JichushujuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, QueryWrapper<JichushujuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, QueryWrapper<JichushujuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
