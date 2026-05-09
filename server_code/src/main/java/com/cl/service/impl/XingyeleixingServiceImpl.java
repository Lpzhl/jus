package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.XingyeleixingDao;
import com.cl.entity.XingyeleixingEntity;
import com.cl.service.XingyeleixingService;
import com.cl.entity.view.XingyeleixingView;

@Service("xingyeleixingService")
public class XingyeleixingServiceImpl extends ServiceImpl<XingyeleixingDao, XingyeleixingEntity> implements XingyeleixingService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XingyeleixingEntity> page = baseMapper.selectPage(new Query<XingyeleixingEntity>(params).getPage(),new QueryWrapper<XingyeleixingEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<XingyeleixingEntity> wrapper) {
        Page<XingyeleixingEntity> page = baseMapper.selectPage(new Query<XingyeleixingEntity>(params).getPage(),wrapper);
        Page<XingyeleixingView> pageVo = (Page<XingyeleixingView>)page.convert(XingyeleixingView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<XingyeleixingView> selectListView(QueryWrapper<XingyeleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XingyeleixingView selectView(QueryWrapper<XingyeleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
