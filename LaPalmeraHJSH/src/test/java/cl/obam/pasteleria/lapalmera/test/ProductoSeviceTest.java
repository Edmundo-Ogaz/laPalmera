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
import cl.obam.pasteleria.lapalmera.model.Producto;
import cl.obam.pasteleria.lapalmera.service.ProductoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class ProductoSeviceTest {
	
	@Autowired
	private ProductoService productoService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(productoService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Producto producto = new Producto();
			Assert.assertNotNull(productoService.getAllEqBy(producto));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Producto producto = new Producto();
			Assert.assertNotNull(productoService.getAllNotEqBy(producto));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Producto producto = new Producto();
			Assert.assertNotNull(productoService.getAllBeginWithBy(producto));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Producto producto = new Producto();
			Assert.assertNotNull(productoService.getAllNotBeginWithBy(producto));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Producto producto = new Producto();
			Assert.assertNotNull(productoService.getAllEndWithBy(producto));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Producto> list = null;
		try {
			Producto producto = new Producto();
			Assert.assertNotNull(productoService.getAllNotEndWithBy(producto));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Producto producto = new Producto();
			Assert.assertNotNull(productoService.getAllContainBy(producto));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Producto producto = new Producto();
			Assert.assertNotNull(productoService.getAllNotContainBy(producto));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Producto producto = new Producto();
			Assert.assertNotNull(productoService.getAllIsNullBy(producto));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Producto producto = new Producto();
			Assert.assertNotNull(productoService.getAllNotIsNullBy(producto));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Producto producto = new Producto();
			producto.setCodigoproducto("z");
			producto.setNombreproducto("z");
			Assert.assertEquals(productoService.save(producto), true);
			Assert.assertNotNull(productoService.get(producto.getCodigoproducto()));
			producto.setNombreproducto("zz");
			Assert.assertEquals(productoService.update(producto), true);			
			Assert.assertEquals(productoService.delete(producto.getCodigoproducto()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Producto producto = new Producto();
			producto.setCodigoproducto("z");
			producto.setNombreproducto("zz");
			Assert.assertEquals(productoService.update(producto), true);
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
			Assert.assertEquals(productoService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
