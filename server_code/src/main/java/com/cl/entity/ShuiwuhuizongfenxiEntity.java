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
 * 税务汇总分析
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2026-04-30 18:52:47
 */
@TableName("shuiwuhuizongfenxi")
public class ShuiwuhuizongfenxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShuiwuhuizongfenxiEntity() {
		
	}
	
	public ShuiwuhuizongfenxiEntity(T t) {
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
	 * 企业月度
	 */
					
	private String qiyeyuedu;
	
	/**
	 * 年度税务汇总报表
	 */
					
	private String niandushuiwuhuizongbaobiao;
	
	/**
	 * 税负变化
	 */
					
	private String shuifubianhua;
	
	/**
	 * 申报通过率
	 */
					
	private Double shenbaotongguolv;
	
	/**
	 * 企业名称
	 */
					
	private String qiyemingcheng;
	

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
	 * 设置：企业月度
	 */
	public void setQiyeyuedu(String qiyeyuedu) {
		this.qiyeyuedu = qiyeyuedu;
	}
	/**
	 * 获取：企业月度
	 */
	public String getQiyeyuedu() {
		return qiyeyuedu;
	}
	/**
	 * 设置：年度税务汇总报表
	 */
	public void setNiandushuiwuhuizongbaobiao(String niandushuiwuhuizongbaobiao) {
		this.niandushuiwuhuizongbaobiao = niandushuiwuhuizongbaobiao;
	}
	/**
	 * 获取：年度税务汇总报表
	 */
	public String getNiandushuiwuhuizongbaobiao() {
		return niandushuiwuhuizongbaobiao;
	}
	/**
	 * 设置：税负变化
	 */
	public void setShuifubianhua(String shuifubianhua) {
		this.shuifubianhua = shuifubianhua;
	}
	/**
	 * 获取：税负变化
	 */
	public String getShuifubianhua() {
		return shuifubianhua;
	}
	/**
	 * 设置：申报通过率
	 */
	public void setShenbaotongguolv(Double shenbaotongguolv) {
		this.shenbaotongguolv = shenbaotongguolv;
	}
	/**
	 * 获取：申报通过率
	 */
	public Double getShenbaotongguolv() {
		return shenbaotongguolv;
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

}
