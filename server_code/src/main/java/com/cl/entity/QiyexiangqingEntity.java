package com.cl.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;


/**
 * 企业详情
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
@TableName("qiyexiangqing")
public class QiyexiangqingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public QiyexiangqingEntity() {
		
	}
	
	public QiyexiangqingEntity(T t) {
		try {
			BeanUtils.copyProperties(t,this);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 企业名称
	 */
					
	private String qiyemingcheng;
	
	/**
	 * 税负异常
	 */
					
	private String shuifuyichang;
	
	/**
	 * 逾期申报
	 */
					
	private String yuqishenbao;
	
	/**
	 * 风险点
	 */
					
	private Double fengxiandian;
	
	/**
	 * 创建时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date chuangjianshijian;
	

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：企业名称
	 */
	public void setQiyemingcheng(String qiyemingcheng) {
		this.qiyemingcheng = qiyemingcheng;
	}
	/**
	 * 获取：企业名称
	 */
	public String getQiyemingcheng() {
		return qiyemingcheng;
	}
	/**
	 * 设置：税负异常
	 */
	public void setShuifuyichang(String shuifuyichang) {
		this.shuifuyichang = shuifuyichang;
	}
	/**
	 * 获取：税负异常
	 */
	public String getShuifuyichang() {
		return shuifuyichang;
	}
	/**
	 * 设置：逾期申报
	 */
	public void setYuqishenbao(String yuqishenbao) {
		this.yuqishenbao = yuqishenbao;
	}
	/**
	 * 获取：逾期申报
	 */
	public String getYuqishenbao() {
		return yuqishenbao;
	}
	/**
	 * 设置：风险点
	 */
	public void setFengxiandian(Double fengxiandian) {
		this.fengxiandian = fengxiandian;
	}
	/**
	 * 获取：风险点
	 */
	public Double getFengxiandian() {
		return fengxiandian;
	}
	/**
	 * 设置：创建时间
	 */
	public void setChuangjianshijian(Date chuangjianshijian) {
		this.chuangjianshijian = chuangjianshijian;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getChuangjianshijian() {
		return chuangjianshijian;
	}

}
