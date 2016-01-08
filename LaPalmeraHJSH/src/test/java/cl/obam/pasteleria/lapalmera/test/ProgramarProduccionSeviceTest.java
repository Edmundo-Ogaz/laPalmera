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
import cl.obam.pasteleria.lapalmera.model.Programarproduccion;
import cl.obam.pasteleria.lapalmera.service.ProgramarProduccionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class ProgramarProduccionSeviceTest {
	
	@Autowired
	private ProgramarProduccionService programarProduccionService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(programarProduccionService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Programarproduccion programarProduccion = new Programarproduccion();
			Assert.assertNotNull(programarProduccionService.getAllEqBy(programarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Programarproduccion programarProduccion = new Programarproduccion();
			Assert.assertNotNull(programarProduccionService.getAllNotEqBy(programarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Programarproduccion programarProduccion = new Programarproduccion();
			Assert.assertNotNull(programarProduccionService.getAllBeginWithBy(programarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Programarproduccion programarProduccion = new Programarproduccion();
			Assert.assertNotNull(programarProduccionService.getAllNotBeginWithBy(programarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Programarproduccion programarProduccion = new Programarproduccion();
			Assert.assertNotNull(programarProduccionService.getAllEndWithBy(programarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Programarproduccion> list = null;
		try {
			Programarproduccion programarProduccion = new Programarproduccion();
			Assert.assertNotNull(programarProduccionService.getAllNotEndWithBy(programarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Programarproduccion programarProduccion = new Programarproduccion();
			Assert.assertNotNull(programarProduccionService.getAllContainBy(programarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Programarproduccion programarProduccion = new Programarproduccion();
			Assert.assertNotNull(programarProduccionService.getAllNotContainBy(programarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Programarproduccion programarProduccion = new Programarproduccion();
			Assert.assertNotNull(programarProduccionService.getAllIsNullBy(programarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Programarproduccion programarProduccion = new Programarproduccion();
			Assert.assertNotNull(programarProduccionService.getAllNotIsNullBy(programarProduccion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Programarproduccion programarProduccion = new Programarproduccion();
			programarProduccion.setCodigoordenfabricacion("z");
			programarProduccion.setCodigoproducto("z");
			Assert.assertEquals(programarProduccionService.save(programarProduccion), true);
			Assert.assertNotNull(programarProduccionService.get(programarProduccion.getCodigoordenfabricacion()));
			programarProduccion.setCodigoproducto("zz");
			Assert.assertEquals(programarProduccionService.update(programarProduccion), true);			
			Assert.assertEquals(programarProduccionService.delete(programarProduccion.getCodigoordenfabricacion()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Programarproduccion programarProduccion = new Programarproduccion();
			programarProduccion.setCodigoordenfabricacion("z");
			programarProduccion.setCodigoproducto("zz");
			Assert.assertEquals(programarProduccionService.update(programarProduccion), true);
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
			Assert.assertEquals(programarProduccionService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}