package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ZiliaoguidangDao;
import com.cl.entity.ZiliaoguidangEntity;
import com.cl.service.ZiliaoguidangService;
import com.cl.entity.view.ZiliaoguidangView;

@Service("ziliaoguidangService")
public class ZiliaoguidangServiceImpl extends ServiceImpl<ZiliaoguidangDao, ZiliaoguidangEntity> implements ZiliaoguidangService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZiliaoguidangEntity> page = baseMapper.selectPage(new Query<ZiliaoguidangEntity>(params).getPage(),new QueryWrapper<ZiliaoguidangEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ZiliaoguidangEntity> wrapper) {
        Page<ZiliaoguidangEntity> page = baseMapper.selectPage(new Query<ZiliaoguidangEntity>(params).getPage(),wrapper);
        Page<ZiliaoguidangView> pageVo = (Page<ZiliaoguidangView>)page.convert(ZiliaoguidangView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<ZiliaoguidangView> selectListView(QueryWrapper<ZiliaoguidangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZiliaoguidangView selectView(QueryWrapper<ZiliaoguidangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
