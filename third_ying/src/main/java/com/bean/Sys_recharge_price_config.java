package com.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Sys_recharge_price_config {
               
	     private int id;
	     private String type;
	     private int market_price;
	     private int sell_price;
	     private Date create_date;
	     private Date update_date;
	    
	     @Id
	     @GeneratedValue
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getMarket_price() {
			return market_price;
		}
		public void setMarket_price(int market_price) {
			this.market_price = market_price;
		}
		public int getSell_price() {
			return sell_price;
		}
		public void setSell_price(int sell_price) {
			this.sell_price = sell_price;
		}
		public Date getCreate_date() {
			return create_date;
		}
		public void setCreate_date(Date create_date) {
			this.create_date = create_date;
		}
		public Date getUpdate_date() {
			return update_date;
		}
		public void setUpdate_date(Date update_date) {
			this.update_date = update_date;
		}
	     
	     
}
