package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.QiyexiangqingDao;
import com.cl.entity.QiyexiangqingEntity;
import com.cl.service.QiyexiangqingService;
import com.cl.entity.view.QiyexiangqingView;

@Service("qiyexiangqingService")
public class QiyexiangqingServiceImpl extends ServiceImpl<QiyexiangqingDao, QiyexiangqingEntity> implements QiyexiangqingService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QiyexiangqingEntity> page = baseMapper.selectPage(new Query<QiyexiangqingEntity>(params).getPage(),new QueryWrapper<QiyexiangqingEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<QiyexiangqingEntity> wrapper) {
        Page<QiyexiangqingEntity> page = baseMapper.selectPage(new Query<QiyexiangqingEntity>(params).getPage(),wrapper);
        Page<QiyexiangqingView> pageVo = (Page<QiyexiangqingView>)page.convert(QiyexiangqingView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<QiyexiangqingView> selectListView(QueryWrapper<QiyexiangqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QiyexiangqingView selectView(QueryWrapper<QiyexiangqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
