package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ChathelperDao;
import com.cl.entity.ChathelperEntity;
import com.cl.service.ChathelperService;
import com.cl.entity.view.ChathelperView;

@Service("chathelperService")
public class ChathelperServiceImpl extends ServiceImpl<ChathelperDao, ChathelperEntity> implements ChathelperService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChathelperEntity> page = baseMapper.selectPage(new Query<ChathelperEntity>(params).getPage(),new QueryWrapper<ChathelperEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ChathelperEntity> wrapper) {
        Page<ChathelperEntity> page = baseMapper.selectPage(new Query<ChathelperEntity>(params).getPage(),wrapper);
        Page<ChathelperView> pageVo = (Page<ChathelperView>)page.convert(ChathelperView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<ChathelperView> selectListView(QueryWrapper<ChathelperEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChathelperView selectView(QueryWrapper<ChathelperEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
