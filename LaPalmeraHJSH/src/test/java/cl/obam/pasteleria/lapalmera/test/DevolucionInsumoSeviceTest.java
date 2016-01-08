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
import cl.obam.pasteleria.lapalmera.model.Devolucioninsumo;
import cl.obam.pasteleria.lapalmera.service.DevolucionInsumoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class DevolucionInsumoSeviceTest {
	
	@Autowired
	private DevolucionInsumoService devolucionInsumoService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(devolucionInsumoService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Devolucioninsumo devolucionInsumo = new Devolucioninsumo();
			Assert.assertNotNull(devolucionInsumoService.getAllEqBy(devolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Devolucioninsumo devolucionInsumo = new Devolucioninsumo();
			Assert.assertNotNull(devolucionInsumoService.getAllNotEqBy(devolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Devolucioninsumo devolucionInsumo = new Devolucioninsumo();
			Assert.assertNotNull(devolucionInsumoService.getAllBeginWithBy(devolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Devolucioninsumo devolucionInsumo = new Devolucioninsumo();
			Assert.assertNotNull(devolucionInsumoService.getAllNotBeginWithBy(devolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Devolucioninsumo devolucionInsumo = new Devolucioninsumo();
			Assert.assertNotNull(devolucionInsumoService.getAllEndWithBy(devolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Devolucioninsumo> list = null;
		try {
			Devolucioninsumo devolucionInsumo = new Devolucioninsumo();
			Assert.assertNotNull(devolucionInsumoService.getAllNotEndWithBy(devolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Devolucioninsumo devolucionInsumo = new Devolucioninsumo();
			Assert.assertNotNull(devolucionInsumoService.getAllContainBy(devolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Devolucioninsumo devolucionInsumo = new Devolucioninsumo();
			Assert.assertNotNull(devolucionInsumoService.getAllNotContainBy(devolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Devolucioninsumo devolucionInsumo = new Devolucioninsumo();
			Assert.assertNotNull(devolucionInsumoService.getAllIsNullBy(devolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Devolucioninsumo devolucionInsumo = new Devolucioninsumo();
			Assert.assertNotNull(devolucionInsumoService.getAllNotIsNullBy(devolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Devolucioninsumo devolucionInsumo = new Devolucioninsumo();
			devolucionInsumo.setCorrelativoentregainsumo(1);
			devolucionInsumo.setObservacion("z");
			Assert.assertEquals(devolucionInsumoService.save(devolucionInsumo), true);
			Assert.assertNotNull(devolucionInsumoService.get(devolucionInsumo.getCorrelativoentregainsumo().toString()));
			devolucionInsumo.setObservacion("zz");
			Assert.assertEquals(devolucionInsumoService.update(devolucionInsumo), true);			
			Assert.assertEquals(devolucionInsumoService.delete(devolucionInsumo.getCorrelativoentregainsumo().toString()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Devolucioninsumo devolucionInsumo = new Devolucioninsumo();
			devolucionInsumo.setCorrelativoentregainsumo(1);
			devolucionInsumo.setObservacion("zz");
			Assert.assertEquals(devolucionInsumoService.update(devolucionInsumo), true);
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
			Assert.assertEquals(devolucionInsumoService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
