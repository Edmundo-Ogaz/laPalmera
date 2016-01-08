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
import cl.obam.pasteleria.lapalmera.model.Especificarproduccion;
import cl.obam.pasteleria.lapalmera.service.EspecificarProduccionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class EspecificarProduccionSeviceTest {
	
	@Autowired
	private EspecificarProduccionService especificarProduccionService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(especificarProduccionService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Especificarproduccion especificarProduccion = new Especificarproduccion();
			Assert.assertNotNull(especificarProduccionService.getAllEqBy(especificarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Especificarproduccion especificarProduccion = new Especificarproduccion();
			Assert.assertNotNull(especificarProduccionService.getAllNotEqBy(especificarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Especificarproduccion especificarProduccion = new Especificarproduccion();
			Assert.assertNotNull(especificarProduccionService.getAllBeginWithBy(especificarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Especificarproduccion especificarProduccion = new Especificarproduccion();
			Assert.assertNotNull(especificarProduccionService.getAllNotBeginWithBy(especificarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Especificarproduccion especificarProduccion = new Especificarproduccion();
			Assert.assertNotNull(especificarProduccionService.getAllEndWithBy(especificarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Especificarproduccion> list = null;
		try {
			Especificarproduccion especificarProduccion = new Especificarproduccion();
			Assert.assertNotNull(especificarProduccionService.getAllNotEndWithBy(especificarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Especificarproduccion especificarProduccion = new Especificarproduccion();
			Assert.assertNotNull(especificarProduccionService.getAllContainBy(especificarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Especificarproduccion especificarProduccion = new Especificarproduccion();
			Assert.assertNotNull(especificarProduccionService.getAllNotContainBy(especificarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Especificarproduccion especificarProduccion = new Especificarproduccion();
			Assert.assertNotNull(especificarProduccionService.getAllIsNullBy(especificarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Especificarproduccion especificarProduccion = new Especificarproduccion();
			Assert.assertNotNull(especificarProduccionService.getAllNotIsNullBy(especificarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Especificarproduccion especificarProduccion = new Especificarproduccion();
			especificarProduccion.setCodigolineaproduccion("z");
			especificarProduccion.setCodigoordenfabricacion("z");
			Assert.assertEquals(especificarProduccionService.save(especificarProduccion), true);
			Assert.assertNotNull(especificarProduccionService.get(especificarProduccion.getCodigolineaproduccion()));
			especificarProduccion.setCodigoordenfabricacion("zz");
			Assert.assertEquals(especificarProduccionService.update(especificarProduccion), true);			
			Assert.assertEquals(especificarProduccionService.delete(especificarProduccion.getCodigolineaproduccion()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Especificarproduccion especificarProduccion = new Especificarproduccion();
			especificarProduccion.setCodigolineaproduccion("z");
			especificarProduccion.setCodigoproducto("zz");
			Assert.assertEquals(especificarProduccionService.update(especificarProduccion), true);
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
			Assert.assertEquals(especificarProduccionService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
