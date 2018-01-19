package tw.edu.nuk.java2.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tw.edu.nuk.java2.dao.StockDao;
import tw.edu.nuk.java2.model.Stock;

@Component
public class StockDaoImpl implements StockDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Stock get(long stockId) {
		return (Stock)sessionFactory.getCurrentSession().get(Stock.class, stockId);

	}

	@Override
	public void saveOrUpdate(Stock stock) {
		sessionFactory.getCurrentSession().saveOrUpdate(stock);

	}

	@Override
	public void delete(Stock stock) {
		sessionFactory.getCurrentSession().delete(stock);

	}

	@Override
	public void delete(long stockId) {
		Stock stock = get(stockId);
		if (stock != null)
			delete(stock);
	}

	@Override
	public List<Stock> search(Map<String, String> conditions) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Stock.class);
		for (Map.Entry<String, String> entry : conditions.entrySet()) {
			criteria.add(Restrictions.like(entry.getKey(), makeLikeString(entry.getValue())));
		}
		criteria.addOrder(Order.asc("stockId"));		
		
		return criteria.list();
	}
	
	@Override
	public List<Stock> searchDistinct(Map<String, String> conditions) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Stock.class);
		for (Map.Entry<String, String> entry : conditions.entrySet()) {
			criteria.add(Restrictions.like(entry.getKey(), makeLikeString(entry.getValue())));
		}
		criteria.addOrder(Order.asc("stockId"));		
		criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}
	
	private String makeLikeString(String str) {
		String retVal = str.replace("%", "");
		retVal = "%" + retVal + "%";
		
		return retVal;
	}

}
