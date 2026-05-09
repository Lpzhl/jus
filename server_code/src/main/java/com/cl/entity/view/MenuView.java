package com.cl.entity.view;

import com.cl.entity.MenuEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 菜单
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2026-04-30 18:52:44
 */
@TableName("menu")
public class MenuView  extends MenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MenuView(){
	}
 
 	public MenuView(MenuEntity menuEntity){
 	try {
			BeanUtils.copyProperties(menuEntity,this);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}



}
