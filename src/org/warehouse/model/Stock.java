package org.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long stockId;
	
	@Column
	private String stockName;
	
	@Column
	private String stockCategory;
	
	@Column
	private int stockNum;
	
	public long getStockId() {
		return stockId;
	}
	public void setStockId(long stockId) {
		stockId = this.stockId;
	}
	
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		stockName = this.stockName;
	}
	
	public int getStockNum() {
		return stockNum;
	}
	public void setStockNum(long stockNum) {
		stockNum = this.stockNum;
	}
	
}
