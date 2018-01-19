package tw.edu.nuk.java2.dao;
import java.util.List;
import java.util.Map;

import tw.edu.nuk.java2.model.Stock;


public interface StockDao {
	Stock get(long stockId);
	void saveOrUpdate(Stock stock);
	void delete(Stock stock);
	void delete(long stockId);
	List<Stock> search(Map<String,String> conditions);
	List<Stock> searchDistinct(Map<String,String> conditions);
}
