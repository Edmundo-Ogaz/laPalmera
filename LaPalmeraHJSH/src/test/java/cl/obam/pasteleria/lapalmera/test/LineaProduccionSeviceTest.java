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
import cl.obam.pasteleria.lapalmera.model.Lineaproduccion;
import cl.obam.pasteleria.lapalmera.service.LineaProduccionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class LineaProduccionSeviceTest {
	
	@Autowired
	private LineaProduccionService lineaProduccionService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(lineaProduccionService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Lineaproduccion lineaProduccion = new Lineaproduccion();
			Assert.assertNotNull(lineaProduccionService.getAllEqBy(lineaProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Lineaproduccion lineaProduccion = new Lineaproduccion();
			Assert.assertNotNull(lineaProduccionService.getAllNotEqBy(lineaProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Lineaproduccion lineaProduccion = new Lineaproduccion();
			Assert.assertNotNull(lineaProduccionService.getAllBeginWithBy(lineaProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Lineaproduccion lineaProduccion = new Lineaproduccion();
			Assert.assertNotNull(lineaProduccionService.getAllNotBeginWithBy(lineaProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Lineaproduccion lineaProduccion = new Lineaproduccion();
			Assert.assertNotNull(lineaProduccionService.getAllEndWithBy(lineaProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Lineaproduccion> list = null;
		try {
			Lineaproduccion lineaProduccion = new Lineaproduccion();
			Assert.assertNotNull(lineaProduccionService.getAllNotEndWithBy(lineaProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Lineaproduccion lineaProduccion = new Lineaproduccion();
			Assert.assertNotNull(lineaProduccionService.getAllContainBy(lineaProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Lineaproduccion lineaProduccion = new Lineaproduccion();
			Assert.assertNotNull(lineaProduccionService.getAllNotContainBy(lineaProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Lineaproduccion lineaProduccion = new Lineaproduccion();
			Assert.assertNotNull(lineaProduccionService.getAllIsNullBy(lineaProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Lineaproduccion lineaProduccion = new Lineaproduccion();
			Assert.assertNotNull(lineaProduccionService.getAllNotIsNullBy(lineaProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Lineaproduccion lineaProduccion = new Lineaproduccion();
			lineaProduccion.setCodigolineaproduccion("z");
			lineaProduccion.setNombrelineaproduccion("z");
			Assert.assertEquals(lineaProduccionService.save(lineaProduccion), true);
			Assert.assertNotNull(lineaProduccionService.get(lineaProduccion.getCodigolineaproduccion()));
			lineaProduccion.setNombrelineaproduccion("zz");
			Assert.assertEquals(lineaProduccionService.update(lineaProduccion), true);			
			Assert.assertEquals(lineaProduccionService.delete(lineaProduccion.getCodigolineaproduccion()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Lineaproduccion lineaProduccion = new Lineaproduccion();
			lineaProduccion.setCodigolineaproduccion("z");
			lineaProduccion.setNombrelineaproduccion("zz");
			Assert.assertEquals(lineaProduccionService.update(lineaProduccion), true);
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
			Assert.assertEquals(lineaProduccionService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}