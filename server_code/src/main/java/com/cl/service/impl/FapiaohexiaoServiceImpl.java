package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.FapiaohexiaoDao;
import com.cl.entity.FapiaohexiaoEntity;
import com.cl.service.FapiaohexiaoService;
import com.cl.entity.view.FapiaohexiaoView;

@Service("fapiaohexiaoService")
public class FapiaohexiaoServiceImpl extends ServiceImpl<FapiaohexiaoDao, FapiaohexiaoEntity> implements FapiaohexiaoService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FapiaohexiaoEntity> page = baseMapper.selectPage(new Query<FapiaohexiaoEntity>(params).getPage(),new QueryWrapper<FapiaohexiaoEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<FapiaohexiaoEntity> wrapper) {
        Page<FapiaohexiaoEntity> page = baseMapper.selectPage(new Query<FapiaohexiaoEntity>(params).getPage(),wrapper);
        Page<FapiaohexiaoView> pageVo = (Page<FapiaohexiaoView>)page.convert(FapiaohexiaoView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<FapiaohexiaoView> selectListView(QueryWrapper<FapiaohexiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FapiaohexiaoView selectView(QueryWrapper<FapiaohexiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
