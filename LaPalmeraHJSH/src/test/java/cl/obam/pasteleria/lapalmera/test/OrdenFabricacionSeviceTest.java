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
import cl.obam.pasteleria.lapalmera.model.Ordenfabricacion;
import cl.obam.pasteleria.lapalmera.service.OrdenFabricacionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class OrdenFabricacionSeviceTest {
	
	@Autowired
	private OrdenFabricacionService ordenFabricacionService;
	
	@Test
	//@Ignore
	public void get() {
		
		try {
			String codigoOrdenFabricacion = "7-1";
			Assert.assertNotNull(ordenFabricacionService.get(codigoOrdenFabricacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(ordenFabricacionService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void getAllEqBy() {
		
		try {
			Ordenfabricacion ordenFabricacion = new Ordenfabricacion();
			Assert.assertNotNull(ordenFabricacionService.getAllEqBy(ordenFabricacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotEqBy() {
		
		try {
			Ordenfabricacion ordenFabricacion = new Ordenfabricacion();
			Assert.assertNotNull(ordenFabricacionService.getAllNotEqBy(ordenFabricacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Ordenfabricacion ordenFabricacion = new Ordenfabricacion();
			Assert.assertNotNull(ordenFabricacionService.getAllBeginWithBy(ordenFabricacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Ordenfabricacion ordenFabricacion = new Ordenfabricacion();
			Assert.assertNotNull(ordenFabricacionService.getAllNotBeginWithBy(ordenFabricacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllEndWithBy() {
		
		try {
			Ordenfabricacion ordenFabricacion = new Ordenfabricacion();
			Assert.assertNotNull(ordenFabricacionService.getAllEndWithBy(ordenFabricacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotEndWithBy() {
		
		List<Ordenfabricacion> list = null;
		try {
			Ordenfabricacion ordenFabricacion = new Ordenfabricacion();
			Assert.assertNotNull(ordenFabricacionService.getAllNotEndWithBy(ordenFabricacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllContainBy() {
		
		try {
			Ordenfabricacion ordenFabricacion = new Ordenfabricacion();
			Assert.assertNotNull(ordenFabricacionService.getAllContainBy(ordenFabricacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotContainBy() {
		
		try {
			Ordenfabricacion ordenFabricacion = new Ordenfabricacion();
			Assert.assertNotNull(ordenFabricacionService.getAllNotContainBy(ordenFabricacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllIsNullBy() {
		
		try {
			Ordenfabricacion ordenFabricacion = new Ordenfabricacion();
			Assert.assertNotNull(ordenFabricacionService.getAllIsNullBy(ordenFabricacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Ordenfabricacion ordenFabricacion = new Ordenfabricacion();
			Assert.assertNotNull(ordenFabricacionService.getAllNotIsNullBy(ordenFabricacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	@Ignore
	public void save() {
		
		try {
			Ordenfabricacion ordenFabricacion = new Ordenfabricacion();
			ordenFabricacion.setCodigoordenfabricacion("z");
			ordenFabricacion.setCantidadproducto(1);
			Assert.assertEquals(ordenFabricacionService.save(ordenFabricacion), true);
			Assert.assertNotNull(ordenFabricacionService.get(ordenFabricacion.getCodigoordenfabricacion()));
			ordenFabricacion.setCantidadproducto(11);
			Assert.assertEquals(ordenFabricacionService.update(ordenFabricacion), true);			
			Assert.assertEquals(ordenFabricacionService.delete(ordenFabricacion.getCodigoordenfabricacion()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Ordenfabricacion ordenFabricacion = new Ordenfabricacion();
			ordenFabricacion.setCodigoordenfabricacion("z");
			ordenFabricacion.setCantidadproducto(1);
			Assert.assertEquals(ordenFabricacionService.update(ordenFabricacion), true);
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
			Assert.assertEquals(ordenFabricacionService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
