package tw.edu.nuk.java2.controller;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tw.edu.nuk.java2.dao.StockDao;
import tw.edu.nuk.java2.model.Stock;

@Controller
public class StockService {
	
	@Autowired
	private StockDao stockDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String setWelcome(Model model) {
		return "Welcome";
	}
	
	@RequestMapping(value="/overview", method=RequestMethod.GET)
	@Transactional
	public String setOverview(Model model) {
		Map<String, String> conditions = new HashMap<String, String>();
    	model.addAttribute("stocks", stockDao.search(conditions));
		return "Overview";
	}
	
	@RequestMapping(value="/restock", method=RequestMethod.GET)
	@Transactional
	public String setRestock(@RequestParam(value="stockId", defaultValue="") String stockId,
								Model model) {
		Stock stock = stockDao.get(Long.parseLong(stockId));
		model.addAttribute("stock", stock);
		return "Restock";
	}
	
	@RequestMapping(value="/restock", method=RequestMethod.POST)
	@Transactional
	public String doRestock(@ModelAttribute(value="stock") Stock stock,
								Model model) {
		stockDao.saveOrUpdate(stock);
		model.addAttribute("stockId", stock.getStockId());
		model.addAttribute("stockNum", stock.getStockNum());
		model.addAttribute("stockCategory", stock.getStockCategory());
		return "redierct:restock";
	}
	
	@RequestMapping(value="/sales", method=RequestMethod.GET)
	@Transactional
	public String setSales(@RequestParam(value="stockId", defaultValue="") String stockId,
								Model model) {
		Stock stock = stockDao.get(Long.parseLong(stockId));
		model.addAttribute("stock", stock);
		return "Sales";
	}
	
	@RequestMapping(value="/sales", method=RequestMethod.POST)
	@Transactional
	public String doSales(@ModelAttribute(value="stock") Stock stock,
							Model model) {
		stockDao.saveOrUpdate(stock);
		model.addAttribute("stockId", stock.getStockId());
		model.addAttribute("stockNum", stock.getStockNum());
		model.addAttribute("stockCategory", stock.getStockCategory());
		return "redirect:sales";
	}
	
	
	
	

	@RequestMapping(value="/category", method=RequestMethod.GET)
	@Transactional
    public String setCategory(Model model) {
		Map<String, String> conditions = new HashMap<String, String>();
		conditions.put("stockCategory", "");
    	model.addAttribute("stocks", stockDao.searchDistinct(conditions));
    	return "StockCategory";
    }
	
    @RequestMapping(value="/category/{category}", method=RequestMethod.GET)
    @Transactional
    public String setCategoryName(Model model, @PathVariable(value="category")String stockCategory) {
    	Map<String, String> conditions = new HashMap<String, String>();
    	conditions.put("stockCategory", stockCategory);
    	model.addAttribute("stocks", stockDao.search(conditions));
    	model.addAttribute("stockCategory", stockCategory);
    	return "Category";
    }
    
	@RequestMapping(value="/section", method=RequestMethod.GET)
	@Transactional
    public String setSection(Model model) {
		Map<String, String> conditions = new HashMap<String, String>();
		conditions.put("stockSection", "");
    	model.addAttribute("stocks", stockDao.searchDistinct(conditions));
    	return "StockSection";
    }
	
    @RequestMapping(value="/section/{section}", method=RequestMethod.GET)
    @Transactional
    public String setSectionName(Model model, @PathVariable(value="section")String stockSection) {
    	Map<String, String> conditions = new HashMap<String, String>();
    	conditions.put("stockSection", stockSection);
    	model.addAttribute("stocks", stockDao.search(conditions));
    	model.addAttribute("stockSection", stockSection);
    	return "Section";
    }
    
    @RequestMapping(value="/create", method=RequestMethod.GET)
	public String setCreate(Model model) {
    	Stock stock= new Stock();
    	model.addAttribute("stock", stock);
    	return "Create";
	}
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
	@Transactional
	public String doCreate(@ModelAttribute("stock") Stock stock,
								Model model) {
    
    	stockDao.saveOrUpdate(stock);
		model.addAttribute("stockName", stock.getStockName());
		model.addAttribute("stockCategory", stock.getStockCategory());
		model.addAttribute("stockBrand", stock.getStockBrand());
		
    	return "redirect:search";
	}
    
    @RequestMapping(value="/update", method=RequestMethod.GET)
	@Transactional
	public String setUpdate(@RequestParam(value="stockId", defaultValue="") String stockId,
								Model model) {
    	Stock stock = stockDao.get(Long.parseLong(stockId));
    	model.addAttribute("stock", stock);
    	return "Update";
	}
    
    @RequestMapping(value="/update", method=RequestMethod.POST)
	@Transactional
	public String doUpdate(@ModelAttribute(value="stock") Stock stock,
							Model model) {
    	stockDao.saveOrUpdate(stock);
    	model.addAttribute("stockName", stock.getStockName());
    	model.addAttribute("stockCategory", stock.getStockCategory());
    	model.addAttribute("stockBrand", stock.getStockBrand());
    	return "redirect:search";
	}
    
    @RequestMapping(value="/search", method=RequestMethod.GET)
    @Transactional
    public String getSearch(@RequestParam(value="stockName", defaultValue="") String stockName,
    						@RequestParam(value="stockCategory", defaultValue="") String stockCategory,
    						@RequestParam(value="stockBrand", defaultValue="") String stockBrand,
    						Model model) {
    	Map<String, String> conditions = new HashMap<String, String>();
    	conditions.put("stockName", stockName);
    	conditions.put("stockCategory", stockCategory);
    	conditions.put("stockBrand", stockBrand);
    	model.addAttribute("stocks", stockDao.search(conditions));
    	model.addAttribute("stockName", stockName);
    	model.addAttribute("stockCategory", stockCategory);
    	model.addAttribute("stockBrand", stockBrand);
    	return "Search";
    }
    
    @RequestMapping(value="/delete", method=RequestMethod.GET)
	@Transactional
	public String doDelete(@RequestParam(value="stockName", defaultValue="") String stockName,
							@RequestParam(value="stockCategory", defaultValue="") String stockCategory,
							@RequestParam(value="stockBrand", defaultValue="") String stockBrand,
							@RequestParam(value="stockId", defaultValue="") String stockId,
							Model model) {
    	stockDao.delete(Long.parseLong(stockId));
    	return "redirect:overview";
	}
    
}
