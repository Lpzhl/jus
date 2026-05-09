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
 * 欠税催缴
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2026-04-30 18:52:46
 */
@TableName("qianshuicuijiao")
public class QianshuicuijiaoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public QianshuicuijiaoEntity() {
		
	}
	
	public QianshuicuijiaoEntity(T t) {
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
	 * 申报回执
	 */
					
	private String shenbaohuizhi;
	
	/**
	 * 企业名称
	 */
					
	private String qiyemingcheng;
	
	/**
	 * 税款金额
	 */
					
	private Double shuikuanjine;
	
	/**
	 * 催缴时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date cuijiaoshijian;
	

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
	 * 设置：申报回执
	 */
	public void setShenbaohuizhi(String shenbaohuizhi) {
		this.shenbaohuizhi = shenbaohuizhi;
	}
	/**
	 * 获取：申报回执
	 */
	public String getShenbaohuizhi() {
		return shenbaohuizhi;
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
	 * 设置：催缴时间
	 */
	public void setCuijiaoshijian(Date cuijiaoshijian) {
		this.cuijiaoshijian = cuijiaoshijian;
	}
	/**
	 * 获取：催缴时间
	 */
	public Date getCuijiaoshijian() {
		return cuijiaoshijian;
	}

}
