package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ShenbaohuizhiDao;
import com.cl.entity.ShenbaohuizhiEntity;
import com.cl.service.ShenbaohuizhiService;
import com.cl.entity.view.ShenbaohuizhiView;

@Service("shenbaohuizhiService")
public class ShenbaohuizhiServiceImpl extends ServiceImpl<ShenbaohuizhiDao, ShenbaohuizhiEntity> implements ShenbaohuizhiService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenbaohuizhiEntity> page = baseMapper.selectPage(new Query<ShenbaohuizhiEntity>(params).getPage(),new QueryWrapper<ShenbaohuizhiEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ShenbaohuizhiEntity> wrapper) {
        Page<ShenbaohuizhiEntity> page = baseMapper.selectPage(new Query<ShenbaohuizhiEntity>(params).getPage(),wrapper);
        Page<ShenbaohuizhiView> pageVo = (Page<ShenbaohuizhiView>)page.convert(ShenbaohuizhiView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<ShenbaohuizhiView> selectListView(QueryWrapper<ShenbaohuizhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenbaohuizhiView selectView(QueryWrapper<ShenbaohuizhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
