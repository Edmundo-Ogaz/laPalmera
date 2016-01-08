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
import cl.obam.pasteleria.lapalmera.model.Insumo;
import cl.obam.pasteleria.lapalmera.service.InsumoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class InsumoSeviceTest {
	
	@Autowired
	private InsumoService insumoService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(insumoService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Insumo insumo = new Insumo();
			Assert.assertNotNull(insumoService.getAllEqBy(insumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Insumo insumo = new Insumo();
			Assert.assertNotNull(insumoService.getAllNotEqBy(insumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Insumo insumo = new Insumo();
			Assert.assertNotNull(insumoService.getAllBeginWithBy(insumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Insumo insumo = new Insumo();
			Assert.assertNotNull(insumoService.getAllNotBeginWithBy(insumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Insumo insumo = new Insumo();
			Assert.assertNotNull(insumoService.getAllEndWithBy(insumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Insumo> list = null;
		try {
			Insumo insumo = new Insumo();
			Assert.assertNotNull(insumoService.getAllNotEndWithBy(insumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Insumo insumo = new Insumo();
			Assert.assertNotNull(insumoService.getAllContainBy(insumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Insumo insumo = new Insumo();
			Assert.assertNotNull(insumoService.getAllNotContainBy(insumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Insumo insumo = new Insumo();
			Assert.assertNotNull(insumoService.getAllIsNullBy(insumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Insumo insumo = new Insumo();
			Assert.assertNotNull(insumoService.getAllNotIsNullBy(insumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Insumo insumo = new Insumo();
			insumo.setCodigoinsumo("z");
			insumo.setCodigounidadmedida("z");
			Assert.assertEquals(insumoService.save(insumo), true);
			Assert.assertNotNull(insumoService.get(insumo.getCodigoinsumo()));
			insumo.setCodigounidadmedida("zz");
			Assert.assertEquals(insumoService.update(insumo), true);			
			Assert.assertEquals(insumoService.delete(insumo.getCodigoinsumo()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Insumo insumo = new Insumo();
			insumo.setCodigoinsumo("z");
			insumo.setCodigounidadmedida("zz");
			Assert.assertEquals(insumoService.update(insumo), true);
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
			Assert.assertEquals(insumoService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
