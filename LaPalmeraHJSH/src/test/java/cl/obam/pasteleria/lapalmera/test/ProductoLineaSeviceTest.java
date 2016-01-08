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
import cl.obam.pasteleria.lapalmera.model.Productolinea;
import cl.obam.pasteleria.lapalmera.service.ProductoLineaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class ProductoLineaSeviceTest {
	
	@Autowired
	private ProductoLineaService productoLineaService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(productoLineaService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Productolinea productoLinea = new Productolinea();
			Assert.assertNotNull(productoLineaService.getAllEqBy(productoLinea));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Productolinea productoLinea = new Productolinea();
			Assert.assertNotNull(productoLineaService.getAllNotEqBy(productoLinea));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Productolinea productoLinea = new Productolinea();
			Assert.assertNotNull(productoLineaService.getAllBeginWithBy(productoLinea));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Productolinea productoLinea = new Productolinea();
			Assert.assertNotNull(productoLineaService.getAllNotBeginWithBy(productoLinea));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Productolinea productoLinea = new Productolinea();
			Assert.assertNotNull(productoLineaService.getAllEndWithBy(productoLinea));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Productolinea> list = null;
		try {
			Productolinea productoLinea = new Productolinea();
			Assert.assertNotNull(productoLineaService.getAllNotEndWithBy(productoLinea));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Productolinea productoLinea = new Productolinea();
			Assert.assertNotNull(productoLineaService.getAllContainBy(productoLinea));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Productolinea productoLinea = new Productolinea();
			Assert.assertNotNull(productoLineaService.getAllNotContainBy(productoLinea));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Productolinea productoLinea = new Productolinea();
			Assert.assertNotNull(productoLineaService.getAllIsNullBy(productoLinea));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Productolinea productoLinea = new Productolinea();
			Assert.assertNotNull(productoLineaService.getAllNotIsNullBy(productoLinea));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Productolinea productoLinea = new Productolinea();
			productoLinea.setCodigoproducto("z");			
			Assert.assertEquals(productoLineaService.create(productoLinea), true);
			Assert.assertNotNull(productoLineaService.get(productoLinea.getCodigoproducto()));			
			Assert.assertEquals(productoLineaService.update(productoLinea), true);			
			Assert.assertEquals(productoLineaService.delete(productoLinea.getCodigoproducto()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Productolinea productoLinea = new Productolinea();
			productoLinea.setCodigoproducto("z");
			Assert.assertEquals(productoLineaService.update(productoLinea), true);
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
			Assert.assertEquals(productoLineaService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}