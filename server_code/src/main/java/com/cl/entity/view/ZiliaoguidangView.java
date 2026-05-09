package com.cl.entity.view;

import com.cl.entity.ZiliaoguidangEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 资料归档
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
@TableName("ziliaoguidang")
public class ZiliaoguidangView  extends ZiliaoguidangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZiliaoguidangView(){
	}
 
 	public ZiliaoguidangView(ZiliaoguidangEntity ziliaoguidangEntity){
 	try {
			BeanUtils.copyProperties(ziliaoguidangEntity,this);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}



}
