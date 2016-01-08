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
import cl.obam.pasteleria.lapalmera.model.Ingrediente;
import cl.obam.pasteleria.lapalmera.service.IngredienteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class IngredienteSeviceTest {
	
	@Autowired
	private IngredienteService ingredienteService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(ingredienteService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Ingrediente ingrediente = new Ingrediente();
			Assert.assertNotNull(ingredienteService.getAllEqBy(ingrediente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Ingrediente ingrediente = new Ingrediente();
			Assert.assertNotNull(ingredienteService.getAllNotEqBy(ingrediente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Ingrediente ingrediente = new Ingrediente();
			Assert.assertNotNull(ingredienteService.getAllBeginWithBy(ingrediente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Ingrediente ingrediente = new Ingrediente();
			Assert.assertNotNull(ingredienteService.getAllNotBeginWithBy(ingrediente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Ingrediente ingrediente = new Ingrediente();
			Assert.assertNotNull(ingredienteService.getAllEndWithBy(ingrediente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Ingrediente> list = null;
		try {
			Ingrediente ingrediente = new Ingrediente();
			Assert.assertNotNull(ingredienteService.getAllNotEndWithBy(ingrediente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Ingrediente ingrediente = new Ingrediente();
			Assert.assertNotNull(ingredienteService.getAllContainBy(ingrediente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Ingrediente ingrediente = new Ingrediente();
			Assert.assertNotNull(ingredienteService.getAllNotContainBy(ingrediente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Ingrediente ingrediente = new Ingrediente();
			Assert.assertNotNull(ingredienteService.getAllIsNullBy(ingrediente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Ingrediente ingrediente = new Ingrediente();
			Assert.assertNotNull(ingredienteService.getAllNotIsNullBy(ingrediente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Ingrediente ingrediente = new Ingrediente();
			ingrediente.setCodigounidadmedida("z");
			ingrediente.setCarga(1);
			Assert.assertEquals(ingredienteService.create(ingrediente), true);
			Assert.assertNotNull(ingredienteService.get(ingrediente.getCodigounidadmedida()));
			ingrediente.setCarga(11);
			Assert.assertEquals(ingredienteService.update(ingrediente), true);			
			Assert.assertEquals(ingredienteService.delete(ingrediente.getCodigounidadmedida()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Ingrediente ingrediente = new Ingrediente();
			ingrediente.setCodigounidadmedida("z");
			ingrediente.setCarga(11);
			Assert.assertEquals(ingredienteService.update(ingrediente), true);
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
			Assert.assertEquals(ingredienteService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
