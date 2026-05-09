package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ShenbaocaozuoDao;
import com.cl.entity.ShenbaocaozuoEntity;
import com.cl.service.ShenbaocaozuoService;
import com.cl.entity.view.ShenbaocaozuoView;

@Service("shenbaocaozuoService")
public class ShenbaocaozuoServiceImpl extends ServiceImpl<ShenbaocaozuoDao, ShenbaocaozuoEntity> implements ShenbaocaozuoService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenbaocaozuoEntity> page = baseMapper.selectPage(new Query<ShenbaocaozuoEntity>(params).getPage(),new QueryWrapper<ShenbaocaozuoEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ShenbaocaozuoEntity> wrapper) {
        Page<ShenbaocaozuoEntity> page = baseMapper.selectPage(new Query<ShenbaocaozuoEntity>(params).getPage(),wrapper);
        Page<ShenbaocaozuoView> pageVo = (Page<ShenbaocaozuoView>)page.convert(ShenbaocaozuoView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<ShenbaocaozuoView> selectListView(QueryWrapper<ShenbaocaozuoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenbaocaozuoView selectView(QueryWrapper<ShenbaocaozuoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
