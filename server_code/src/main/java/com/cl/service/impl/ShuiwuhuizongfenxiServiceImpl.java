package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ShuiwuhuizongfenxiDao;
import com.cl.entity.ShuiwuhuizongfenxiEntity;
import com.cl.service.ShuiwuhuizongfenxiService;
import com.cl.entity.view.ShuiwuhuizongfenxiView;

@Service("shuiwuhuizongfenxiService")
public class ShuiwuhuizongfenxiServiceImpl extends ServiceImpl<ShuiwuhuizongfenxiDao, ShuiwuhuizongfenxiEntity> implements ShuiwuhuizongfenxiService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShuiwuhuizongfenxiEntity> page = baseMapper.selectPage(new Query<ShuiwuhuizongfenxiEntity>(params).getPage(),new QueryWrapper<ShuiwuhuizongfenxiEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ShuiwuhuizongfenxiEntity> wrapper) {
        Page<ShuiwuhuizongfenxiEntity> page = baseMapper.selectPage(new Query<ShuiwuhuizongfenxiEntity>(params).getPage(),wrapper);
        Page<ShuiwuhuizongfenxiView> pageVo = (Page<ShuiwuhuizongfenxiView>)page.convert(ShuiwuhuizongfenxiView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<ShuiwuhuizongfenxiView> selectListView(QueryWrapper<ShuiwuhuizongfenxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShuiwuhuizongfenxiView selectView(QueryWrapper<ShuiwuhuizongfenxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
