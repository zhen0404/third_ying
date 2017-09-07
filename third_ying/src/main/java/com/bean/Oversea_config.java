package com.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table
public class Oversea_config {

	private int id;
	private String title;
	private String content;
	private int sortColum;
	private String child_title;
	private String description;
	private String user_type;
	private Date updTime;
	private Date addTime;
	private String oversea_icon;
	private Date start_date;
	private Date end_date;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSortColum() {
		return sortColum;
	}
	public void setSortColum(int sortColum) {
		this.sortColum = sortColum;
	}
	public String getChild_title() {
		return child_title;
	}
	public void setChild_title(String child_title) {
		this.child_title = child_title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getUpdTime() {
		return updTime;
	}
	public void setUpdTime(String updTime) {
		this.updTime = updTime;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getOversea_icon() {
		return oversea_icon;
	}
	public void setOversea_icon(String oversea_icon) {
		this.oversea_icon = oversea_icon;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
