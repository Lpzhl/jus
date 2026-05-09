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
 * 税款缴纳
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
@TableName("shuikuanjiaona")
public class ShuikuanjiaonaEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShuikuanjiaonaEntity() {
		
	}
	
	public ShuikuanjiaonaEntity(T t) {
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
	 * 年份
	 */
					
	private String nianfen;
	
	/**
	 * 月份
	 */
					
	private String yuefen;
	
	/**
	 * 销项发票
	 */
					
	private String xiaoxiangfapiao;
	
	/**
	 * 进项发票
	 */
					
	private String jinxiangfapiao;
	
	/**
	 * 营收
	 */
					
	private Double yingshou;
	
	/**
	 * 成本费用
	 */
					
	private Double chengbenfeiyong;
	
	/**
	 * 申报时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date shenbaoshijian;
	
	/**
	 * 完税凭证
	 */
					
	private String wanshuipingzheng;
	
	/**
	 * 企业名称
	 */
					
	private String qiyemingcheng;
	
	/**
	 * 税款金额
	 */
					
	private Double shuikuanjine;
	
	/**
	 * 失效时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date reversetime;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	/**
	 * 总费用
	 */
					
	private Double zongfeiyong;
	
	/**
	 * 跨表用户id
	 */
					
	private Long crossuserid;
	
	/**
	 * 跨表主键id
	 */
					
	private Long crossrefid;
	

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
	 * 设置：年份
	 */
	public void setNianfen(String nianfen) {
		this.nianfen = nianfen;
	}
	/**
	 * 获取：年份
	 */
	public String getNianfen() {
		return nianfen;
	}
	/**
	 * 设置：月份
	 */
	public void setYuefen(String yuefen) {
		this.yuefen = yuefen;
	}
	/**
	 * 获取：月份
	 */
	public String getYuefen() {
		return yuefen;
	}
	/**
	 * 设置：销项发票
	 */
	public void setXiaoxiangfapiao(String xiaoxiangfapiao) {
		this.xiaoxiangfapiao = xiaoxiangfapiao;
	}
	/**
	 * 获取：销项发票
	 */
	public String getXiaoxiangfapiao() {
		return xiaoxiangfapiao;
	}
	/**
	 * 设置：进项发票
	 */
	public void setJinxiangfapiao(String jinxiangfapiao) {
		this.jinxiangfapiao = jinxiangfapiao;
	}
	/**
	 * 获取：进项发票
	 */
	public String getJinxiangfapiao() {
		return jinxiangfapiao;
	}
	/**
	 * 设置：营收
	 */
	public void setYingshou(Double yingshou) {
		this.yingshou = yingshou;
	}
	/**
	 * 获取：营收
	 */
	public Double getYingshou() {
		return yingshou;
	}
	/**
	 * 设置：成本费用
	 */
	public void setChengbenfeiyong(Double chengbenfeiyong) {
		this.chengbenfeiyong = chengbenfeiyong;
	}
	/**
	 * 获取：成本费用
	 */
	public Double getChengbenfeiyong() {
		return chengbenfeiyong;
	}
	/**
	 * 设置：申报时间
	 */
	public void setShenbaoshijian(Date shenbaoshijian) {
		this.shenbaoshijian = shenbaoshijian;
	}
	/**
	 * 获取：申报时间
	 */
	public Date getShenbaoshijian() {
		return shenbaoshijian;
	}
	/**
	 * 设置：完税凭证
	 */
	public void setWanshuipingzheng(String wanshuipingzheng) {
		this.wanshuipingzheng = wanshuipingzheng;
	}
	/**
	 * 获取：完税凭证
	 */
	public String getWanshuipingzheng() {
		return wanshuipingzheng;
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
	 * 设置：税款金额
	 */
	public void setShuikuanjine(Double shuikuanjine) {
		this.shuikuanjine = shuikuanjine;
	}
	/**
	 * 获取：税款金额
	 */
	public Double getShuikuanjine() {
		return shuikuanjine;
	}
	/**
	 * 设置：失效时间
	 */
	public void setReversetime(Date reversetime) {
		this.reversetime = reversetime;
	}
	/**
	 * 获取：失效时间
	 */
	public Date getReversetime() {
		return reversetime;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
	/**
	 * 设置：总费用
	 */
	public void setZongfeiyong(Double zongfeiyong) {
		this.zongfeiyong = zongfeiyong;
	}
	/**
	 * 获取：总费用
	 */
	public Double getZongfeiyong() {
		return zongfeiyong;
	}
	/**
	 * 设置：跨表用户id
	 */
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
	/**
	 * 设置：跨表主键id
	 */
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}

}
