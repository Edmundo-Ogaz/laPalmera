package cl.obam.pasteleria.lapalmera.test;

import java.util.List;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import cl.obam.pasteleria.lapalmera.cons.OperacionEnum;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Stock;
import cl.obam.pasteleria.lapalmera.service.StockService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class StockSeviceTest {
	
	@Autowired
	private StockService stockService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(stockService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Stock stock = new Stock();
			Assert.assertNotNull(stockService.getAllEqBy(stock));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Stock stock = new Stock();
			Assert.assertNotNull(stockService.getAllNotEqBy(stock));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Stock stock = new Stock();
			Assert.assertNotNull(stockService.getAllBeginWithBy(stock));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Stock stock = new Stock();
			Assert.assertNotNull(stockService.getAllNotBeginWithBy(stock));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Stock stock = new Stock();
			Assert.assertNotNull(stockService.getAllEndWithBy(stock));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Stock> list = null;
		try {
			Stock stock = new Stock();
			Assert.assertNotNull(stockService.getAllNotEndWithBy(stock));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Stock stock = new Stock();
			Assert.assertNotNull(stockService.getAllContainBy(stock));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Stock stock = new Stock();
			Assert.assertNotNull(stockService.getAllNotContainBy(stock));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Stock stock = new Stock();
			Assert.assertNotNull(stockService.getAllIsNullBy(stock));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Stock stock = new Stock();
			Assert.assertNotNull(stockService.getAllNotIsNullBy(stock));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Stock stock = new Stock();
			stock.setCodigoproducto("z");
			stock.setCodigounidadmedida("z");
			Assert.assertEquals(stockService.save(stock), true);
			Assert.assertNotNull(stockService.get(stock.getCodigoproducto()));
			stock.setCodigounidadmedida("zz");
			Assert.assertEquals(stockService.update(stock), true);			
			Assert.assertEquals(stockService.delete(stock.getCodigoproducto()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Stock stock = new Stock();
			stock.setCodigoproducto("z");
			stock.setCodigounidadmedida("zz");
			Assert.assertEquals(stockService.update(stock), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void delete() {
		
		try {
			String id = "z";
			Assert.assertEquals(stockService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
