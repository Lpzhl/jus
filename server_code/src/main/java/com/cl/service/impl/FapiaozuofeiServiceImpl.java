package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.FapiaozuofeiDao;
import com.cl.entity.FapiaozuofeiEntity;
import com.cl.service.FapiaozuofeiService;
import com.cl.entity.view.FapiaozuofeiView;

@Service("fapiaozuofeiService")
public class FapiaozuofeiServiceImpl extends ServiceImpl<FapiaozuofeiDao, FapiaozuofeiEntity> implements FapiaozuofeiService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FapiaozuofeiEntity> page = baseMapper.selectPage(new Query<FapiaozuofeiEntity>(params).getPage(),new QueryWrapper<FapiaozuofeiEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<FapiaozuofeiEntity> wrapper) {
        Page<FapiaozuofeiEntity> page = baseMapper.selectPage(new Query<FapiaozuofeiEntity>(params).getPage(),wrapper);
        Page<FapiaozuofeiView> pageVo = (Page<FapiaozuofeiView>)page.convert(FapiaozuofeiView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<FapiaozuofeiView> selectListView(QueryWrapper<FapiaozuofeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FapiaozuofeiView selectView(QueryWrapper<FapiaozuofeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
