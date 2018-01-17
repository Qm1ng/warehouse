package org.warehouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.warehouse.dao.StockDao;
import org.warehouse.model.Stock;

@Controller
public class CategoryController {
	
	@Autowired
	private StockDao stockDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public void setReview(@RequestParam(value="stockName", defaultValue="") String stockName,
							@RequestParam(value="stockCategory", defaultValue="") String stockCategory,
							@RequestParam(value="stockNum", defaultValue="") String stockNum, Model model) {
		Map<String, String> conditions = new HashMap<String, String>();
		conditions.put("stockName", stockName);
		conditions.put("stockCategory", stockCategory);
		conditions.put("stockNum", stockNum);
		model.addAttribute("stocks", stockDao.search(conditions));
		model.addAttribute("stockName", stockName);
		model.addAttribute("stockCategory", stockCategory);
		model.addAttribute("stockNum", stockNum);
		
		return "SearchResult";
		
	}
	
	@RequestMapping(value="/category", method=RequestMethod.GET)
    public String setCategory(@RequestParam(value="user", defaultValue="User")
    							String userName, Model model) {
		model.addAttribute("categoryName", userName);
    	return "Category";
    }
    
    @RequestMapping(value="/category/{categoryName}", method=RequestMethod.GET)
    public String setCategoryName(Model model, @PathVariable(value="categoryName")
    								String categoryName) {
    	model.addAttribute("categoryName", categoryName);
    	return "Category";
    }

}
