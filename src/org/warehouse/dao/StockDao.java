package org.warehouse.dao;

import java.util.List;
import java.util.Map;

import org.warehouse.model.Stock;

public interface StockDao {
	Stock get(long stockId);
	void saveOrUpdate(Stock stock);
	void delete(Stock stock);
	void delete(long stockId);
	List<Stock> search(Map<String,String> conditions);
}
