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
import cl.obam.pasteleria.lapalmera.model.Detallepedido;
import cl.obam.pasteleria.lapalmera.service.DetallePedidoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class DetallePedidoSeviceTest {
	
	@Autowired
	private DetallePedidoService detallePedidoService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(detallePedidoService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Detallepedido detallePedido = new Detallepedido();
			Assert.assertNotNull(detallePedidoService.getAllEqBy(detallePedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Detallepedido detallePedido = new Detallepedido();
			Assert.assertNotNull(detallePedidoService.getAllNotEqBy(detallePedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Detallepedido detallePedido = new Detallepedido();
			Assert.assertNotNull(detallePedidoService.getAllBeginWithBy(detallePedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Detallepedido detallePedido = new Detallepedido();
			Assert.assertNotNull(detallePedidoService.getAllNotBeginWithBy(detallePedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Detallepedido detallePedido = new Detallepedido();
			Assert.assertNotNull(detallePedidoService.getAllEndWithBy(detallePedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Detallepedido> list = null;
		try {
			Detallepedido detallePedido = new Detallepedido();
			Assert.assertNotNull(detallePedidoService.getAllNotEndWithBy(detallePedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Detallepedido detallePedido = new Detallepedido();
			Assert.assertNotNull(detallePedidoService.getAllContainBy(detallePedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Detallepedido detallePedido = new Detallepedido();
			Assert.assertNotNull(detallePedidoService.getAllNotContainBy(detallePedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Detallepedido detallePedido = new Detallepedido();
			Assert.assertNotNull(detallePedidoService.getAllIsNullBy(detallePedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Detallepedido detallePedido = new Detallepedido();
			Assert.assertNotNull(detallePedidoService.getAllNotIsNullBy(detallePedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Detallepedido detallePedido = new Detallepedido();
			detallePedido.setNumeropedido(1);
			detallePedido.setCantidadproducto(1);
			Assert.assertEquals(detallePedidoService.save(detallePedido), true);
			Assert.assertNotNull(detallePedidoService.get(Integer.toString(detallePedido.getNumeropedido())));
			detallePedido.setNumeropedido(11);
			Assert.assertEquals(detallePedidoService.update(detallePedido), true);			
			Assert.assertEquals(detallePedidoService.delete(Integer.toString(detallePedido.getNumeropedido())), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Detallepedido detallePedido = new Detallepedido();
			detallePedido.setNumeropedido(1);
			detallePedido.setNumeropedido(11);
			Assert.assertEquals(detallePedidoService.update(detallePedido), true);
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
			Assert.assertEquals(detallePedidoService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
