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
 * 发票作废
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
@TableName("fapiaozuofei")
public class FapiaozuofeiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public FapiaozuofeiEntity() {
		
	}
	
	public FapiaozuofeiEntity(T t) {
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
	 * 发票名称
	 */
					
	private String fapiaomingcheng;
	
	/**
	 * 发票类型
	 */
					
	private String fapiaoleixing;
	
	/**
	 * 作废时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date zuofeishijian;
	
	/**
	 * 企业名称
	 */
					
	private String qiyemingcheng;
	
	/**
	 * 发票图片
	 */
					
	private String fapiaotupian;
	

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
	 * 设置：发票名称
	 */
	public void setFapiaomingcheng(String fapiaomingcheng) {
		this.fapiaomingcheng = fapiaomingcheng;
	}
	/**
	 * 获取：发票名称
	 */
	public String getFapiaomingcheng() {
		return fapiaomingcheng;
	}
	/**
	 * 设置：发票类型
	 */
	public void setFapiaoleixing(String fapiaoleixing) {
		this.fapiaoleixing = fapiaoleixing;
	}
	/**
	 * 获取：发票类型
	 */
	public String getFapiaoleixing() {
		return fapiaoleixing;
	}
	/**
	 * 设置：作废时间
	 */
	public void setZuofeishijian(Date zuofeishijian) {
		this.zuofeishijian = zuofeishijian;
	}
	/**
	 * 获取：作废时间
	 */
	public Date getZuofeishijian() {
		return zuofeishijian;
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
	 * 设置：发票图片
	 */
	public void setFapiaotupian(String fapiaotupian) {
		this.fapiaotupian = fapiaotupian;
	}
	/**
	 * 获取：发票图片
	 */
	public String getFapiaotupian() {
		return fapiaotupian;
	}

}
