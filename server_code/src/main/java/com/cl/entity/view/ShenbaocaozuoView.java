package com.cl.entity.view;

import com.cl.entity.ShenbaocaozuoEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 申报操作
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
@TableName("shenbaocaozuo")
public class ShenbaocaozuoView  extends ShenbaocaozuoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShenbaocaozuoView(){
	}
 
 	public ShenbaocaozuoView(ShenbaocaozuoEntity shenbaocaozuoEntity){
 	try {
			BeanUtils.copyProperties(shenbaocaozuoEntity,this);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}



}
