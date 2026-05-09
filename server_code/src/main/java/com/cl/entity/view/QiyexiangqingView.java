package com.cl.entity.view;

import com.cl.entity.QiyexiangqingEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 企业详情
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
@TableName("qiyexiangqing")
public class QiyexiangqingView  extends QiyexiangqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public QiyexiangqingView(){
	}
 
 	public QiyexiangqingView(QiyexiangqingEntity qiyexiangqingEntity){
 	try {
			BeanUtils.copyProperties(qiyexiangqingEntity,this);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}



}
