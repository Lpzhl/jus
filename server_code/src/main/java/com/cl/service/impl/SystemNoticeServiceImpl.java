package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.SystemNoticeDao;
import com.cl.entity.SystemNoticeEntity;
import com.cl.service.SystemNoticeService;
import com.cl.entity.view.SystemNoticeView;

@Service("systemNoticeService")
public class SystemNoticeServiceImpl extends ServiceImpl<SystemNoticeDao, SystemNoticeEntity> implements SystemNoticeService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SystemNoticeEntity> page = baseMapper.selectPage(new Query<SystemNoticeEntity>(params).getPage(),new QueryWrapper<SystemNoticeEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<SystemNoticeEntity> wrapper) {
        Page<SystemNoticeEntity> page = baseMapper.selectPage(new Query<SystemNoticeEntity>(params).getPage(),wrapper);
        Page<SystemNoticeView> pageVo = (Page<SystemNoticeView>)page.convert(SystemNoticeView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<SystemNoticeView> selectListView(QueryWrapper<SystemNoticeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SystemNoticeView selectView(QueryWrapper<SystemNoticeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
