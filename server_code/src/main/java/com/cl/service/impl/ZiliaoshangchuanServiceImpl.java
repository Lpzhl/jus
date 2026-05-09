package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ZiliaoshangchuanDao;
import com.cl.entity.ZiliaoshangchuanEntity;
import com.cl.service.ZiliaoshangchuanService;
import com.cl.entity.view.ZiliaoshangchuanView;

@Service("ziliaoshangchuanService")
public class ZiliaoshangchuanServiceImpl extends ServiceImpl<ZiliaoshangchuanDao, ZiliaoshangchuanEntity> implements ZiliaoshangchuanService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZiliaoshangchuanEntity> page = baseMapper.selectPage(new Query<ZiliaoshangchuanEntity>(params).getPage(),new QueryWrapper<ZiliaoshangchuanEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ZiliaoshangchuanEntity> wrapper) {
        Page<ZiliaoshangchuanEntity> page = baseMapper.selectPage(new Query<ZiliaoshangchuanEntity>(params).getPage(),wrapper);
        Page<ZiliaoshangchuanView> pageVo = (Page<ZiliaoshangchuanView>)page.convert(ZiliaoshangchuanView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<ZiliaoshangchuanView> selectListView(QueryWrapper<ZiliaoshangchuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZiliaoshangchuanView selectView(QueryWrapper<ZiliaoshangchuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
