package com.cbs.model;

import java.sql.Time;

public class CabModel {

	Integer cabId, cabNo;
	Boolean status;
	String StartTime;
	String EndTime;
	public Integer getCabId() {
		return cabId;
	}
	public void setCabId(Integer cabId) {
		this.cabId = cabId;
	}
	public Integer getCabNo() {
		return cabNo;
	}
	public void setCabNo(Integer cabNo) {
		this.cabNo = cabNo;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(boolean b) {
		this.status = b;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String string) {
		this.StartTime = string;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		this.EndTime = endTime;
	}
}
