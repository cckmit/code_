package com.mika.credit.common.entity;

import java.util.Date;


public class MqRecord<T> extends BaseEntity {

	/** 最后一次通知时间 **/
	private Date lastNotifyTime;

	/** 通知次数 **/
	private Integer notifyTimes = 0;

	/** 限制通知次数 **/
	private Integer limitNotifyTimes = 5;

	private Integer mqStatus = 101;

	private Integer mqType = 0;

	private T content;

	public Date getLastNotifyTime() {
		return lastNotifyTime;
	}

	public void setLastNotifyTime(Date lastNotifyTime) {
		this.lastNotifyTime = lastNotifyTime;
	}

	public Integer getNotifyTimes() {
		return notifyTimes;
	}

	public void setNotifyTimes(Integer notifyTimes) {
		this.notifyTimes = notifyTimes;
	}

	public Integer getLimitNotifyTimes() {
		return limitNotifyTimes;
	}

	public void setLimitNotifyTimes(Integer limitNotifyTimes) {
		this.limitNotifyTimes = limitNotifyTimes;
	}

	public Integer getMqStatus() {
		return mqStatus;
	}

	public void setMqStatus(Integer mqStatus) {
		this.mqStatus = mqStatus;
	}

	public Integer getMqType() {
		return mqType;
	}

	public void setMqType(Integer mqType) {
		this.mqType = mqType;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
}
