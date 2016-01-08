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
import cl.obam.pasteleria.lapalmera.model.Unidadmedida;
import cl.obam.pasteleria.lapalmera.service.UnidadMedidaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class UnidadMedidaSeviceTest {
	
	@Autowired
	private UnidadMedidaService unidadMedidaService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(unidadMedidaService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Unidadmedida unidadMedida = new Unidadmedida();
			Assert.assertNotNull(unidadMedidaService.getAllEqBy(unidadMedida));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Unidadmedida unidadMedida = new Unidadmedida();
			Assert.assertNotNull(unidadMedidaService.getAllNotEqBy(unidadMedida));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Unidadmedida unidadMedida = new Unidadmedida();
			Assert.assertNotNull(unidadMedidaService.getAllBeginWithBy(unidadMedida));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Unidadmedida unidadMedida = new Unidadmedida();
			Assert.assertNotNull(unidadMedidaService.getAllNotBeginWithBy(unidadMedida));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Unidadmedida unidadMedida = new Unidadmedida();
			Assert.assertNotNull(unidadMedidaService.getAllEndWithBy(unidadMedida));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Unidadmedida> list = null;
		try {
			Unidadmedida unidadMedida = new Unidadmedida();
			Assert.assertNotNull(unidadMedidaService.getAllNotEndWithBy(unidadMedida));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Unidadmedida unidadMedida = new Unidadmedida();
			Assert.assertNotNull(unidadMedidaService.getAllContainBy(unidadMedida));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Unidadmedida unidadMedida = new Unidadmedida();
			Assert.assertNotNull(unidadMedidaService.getAllNotContainBy(unidadMedida));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Unidadmedida unidadMedida = new Unidadmedida();
			Assert.assertNotNull(unidadMedidaService.getAllIsNullBy(unidadMedida));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Unidadmedida unidadMedida = new Unidadmedida();
			Assert.assertNotNull(unidadMedidaService.getAllNotIsNullBy(unidadMedida));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Unidadmedida unidadMedida = new Unidadmedida();
			unidadMedida.setCodigo("z");
			unidadMedida.setNombre("z");
			Assert.assertEquals(unidadMedidaService.save(unidadMedida), true);
			Assert.assertNotNull(unidadMedidaService.get(unidadMedida.getCodigo()));
			unidadMedida.setNombre("zz");
			Assert.assertEquals(unidadMedidaService.update(unidadMedida), true);			
			Assert.assertEquals(unidadMedidaService.delete(unidadMedida.getCodigo()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Unidadmedida unidadMedida = new Unidadmedida();
			unidadMedida.setCodigo("z");
			unidadMedida.setNombre("zz");
			Assert.assertEquals(unidadMedidaService.update(unidadMedida), true);
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
			Assert.assertEquals(unidadMedidaService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
