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
 * 企业
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2026-04-30 18:52:45
 */
@TableName("qiye")
public class QiyeEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public QiyeEntity() {
		
	}
	
	public QiyeEntity(T t) {
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
	@TableId
	private Long id;
	/**
	 * 企业名称
	 */
					
	private String qiyemingcheng;
	
	/**
	 * 企业电话
	 */
					
	private String qiyedianhua;
	
	/**
	 * 统一社会信用代码
	 */
					
	private String tongyishehuixinyongdaima;
	
	/**
	 * 密码
	 */
					
	private String mima;
	
	/**
	 * 行业类型
	 */
					
	private String xingyeleixing;
	
	/**
	 * 头像
	 */
					
	private String touxiang;
	
	/**
	 * 最大密码输错次数
	 */
					
	private Integer maxPasswordWrong;
	
	/**
	 * 用户锁定状态
	 */
					
	private Integer isLocked;
	

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
	 * 设置：企业电话
	 */
	public void setQiyedianhua(String qiyedianhua) {
		this.qiyedianhua = qiyedianhua;
	}
	/**
	 * 获取：企业电话
	 */
	public String getQiyedianhua() {
		return qiyedianhua;
	}
	/**
	 * 设置：统一社会信用代码
	 */
	public void setTongyishehuixinyongdaima(String tongyishehuixinyongdaima) {
		this.tongyishehuixinyongdaima = tongyishehuixinyongdaima;
	}
	/**
	 * 获取：统一社会信用代码
	 */
	public String getTongyishehuixinyongdaima() {
		return tongyishehuixinyongdaima;
	}
	/**
	 * 设置：密码
	 */
	public void setMima(String mima) {
		this.mima = mima;
	}
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
	/**
	 * 设置：行业类型
	 */
	public void setXingyeleixing(String xingyeleixing) {
		this.xingyeleixing = xingyeleixing;
	}
	/**
	 * 获取：行业类型
	 */
	public String getXingyeleixing() {
		return xingyeleixing;
	}
	/**
	 * 设置：头像
	 */
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
	/**
	 * 设置：最大密码输错次数
	 */
	public void setMaxPasswordWrong(Integer maxPasswordWrong) {
		this.maxPasswordWrong = maxPasswordWrong;
	}
	/**
	 * 获取：最大密码输错次数
	 */
	public Integer getMaxPasswordWrong() {
		return maxPasswordWrong;
	}
	/**
	 * 设置：用户锁定状态
	 */
	public void setIsLocked(Integer isLocked) {
		this.isLocked = isLocked;
	}
	/**
	 * 获取：用户锁定状态
	 */
	public Integer getIsLocked() {
		return isLocked;
	}

}
