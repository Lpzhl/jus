package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.QianshuicuijiaoDao;
import com.cl.entity.QianshuicuijiaoEntity;
import com.cl.service.QianshuicuijiaoService;
import com.cl.entity.view.QianshuicuijiaoView;

@Service("qianshuicuijiaoService")
public class QianshuicuijiaoServiceImpl extends ServiceImpl<QianshuicuijiaoDao, QianshuicuijiaoEntity> implements QianshuicuijiaoService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QianshuicuijiaoEntity> page = baseMapper.selectPage(new Query<QianshuicuijiaoEntity>(params).getPage(),new QueryWrapper<QianshuicuijiaoEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<QianshuicuijiaoEntity> wrapper) {
        Page<QianshuicuijiaoEntity> page = baseMapper.selectPage(new Query<QianshuicuijiaoEntity>(params).getPage(),wrapper);
        Page<QianshuicuijiaoView> pageVo = (Page<QianshuicuijiaoView>)page.convert(QianshuicuijiaoView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<QianshuicuijiaoView> selectListView(QueryWrapper<QianshuicuijiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QianshuicuijiaoView selectView(QueryWrapper<QianshuicuijiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
