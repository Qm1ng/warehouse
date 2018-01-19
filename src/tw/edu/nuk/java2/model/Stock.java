package tw.edu.nuk.java2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Stock")
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
	private String stockBrand;
	
	@Column
	private String stockSection;
	
	@Column
	private long stockNum;
	
	@Column
	private long stockMin;
	
	public long getStockId() {
		return stockId;
	}
	public void setStockId(long stockId) {
		this.stockId = stockId;
	}
	
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	public String getStockCategory() {
		return stockCategory;
	}
	
	public void setStockCategory(String stockCategory) {
		this.stockCategory = stockCategory;
	}
	
	public String getStockBrand() {
		return stockBrand;
	}
	
	public void setStockBrand(String stockBrand) {
		this.stockBrand = stockBrand;
	}
	
	public String getStockSection() {
		return stockSection;
	}
	
	public void setStockSection(String stockSection) {
		this.stockSection = stockSection;
	}
	
	public long getStockNum() {
		return stockNum;
	}
	public void setStockNum(long stockNum) {
		this.stockNum = stockNum;
	}
	
	public long getStockMin() {
		return stockMin;
	}
	public void setStockMin(long stockMin) {
		this.stockMin = stockMin;
	}
}
