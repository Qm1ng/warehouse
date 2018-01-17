package org.warehouse.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.warehouse.dao.StockDao;
import org.warehouse.model.Stock;


public class StockDaoImpl implements StockDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Stock get(long stockId) {
		// TODO Auto-generated method stub
		return (Stock)sessionFactory.getCurrentSession().get(Stock.class, stockId);
	}

	@Override
	public void saveOrUpdate(Stock stock) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(stock);
	}

	@Override
	public void delete(Stock stock) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(stock);
	}

	@Override
	public void delete(long stockId) {
		// TODO Auto-generated method stub
		Stock stock = get(stockId);
		if (stock != null)
			delete(stock);
	}

	@Override
	public List<Stock> search(Map<String, String> conditions) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Stock.class);
		for (Map.Entry<String, String> entry : conditions.entrySet()) {
			criteria.add(Restrictions.like(entry.getKey(), makeLikeString(entry.getValue())));
		}
		criteria.addOrder(Order.asc("custid"));		
		
		return criteria.list();
	}
	
	private String makeLikeString(String str) {
		String retVal = str.replace("%", "");
		retVal = "%" + retVal + "%";
		
		return retVal;
	}

}
