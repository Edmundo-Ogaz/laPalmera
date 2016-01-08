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
import cl.obam.pasteleria.lapalmera.model.Otracaracteristica;
import cl.obam.pasteleria.lapalmera.service.OtraCaracteristicaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class OtraCaracteristicaSeviceTest {
	
	@Autowired
	private OtraCaracteristicaService otraCaracteristicaService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(otraCaracteristicaService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Otracaracteristica otraCaracteristica = new Otracaracteristica();
			Assert.assertNotNull(otraCaracteristicaService.getAllEqBy(otraCaracteristica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Otracaracteristica otraCaracteristica = new Otracaracteristica();
			Assert.assertNotNull(otraCaracteristicaService.getAllNotEqBy(otraCaracteristica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Otracaracteristica otraCaracteristica = new Otracaracteristica();
			Assert.assertNotNull(otraCaracteristicaService.getAllBeginWithBy(otraCaracteristica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Otracaracteristica otraCaracteristica = new Otracaracteristica();
			Assert.assertNotNull(otraCaracteristicaService.getAllNotBeginWithBy(otraCaracteristica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Otracaracteristica otraCaracteristica = new Otracaracteristica();
			Assert.assertNotNull(otraCaracteristicaService.getAllEndWithBy(otraCaracteristica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Otracaracteristica> list = null;
		try {
			Otracaracteristica otraCaracteristica = new Otracaracteristica();
			Assert.assertNotNull(otraCaracteristicaService.getAllNotEndWithBy(otraCaracteristica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Otracaracteristica otraCaracteristica = new Otracaracteristica();
			Assert.assertNotNull(otraCaracteristicaService.getAllContainBy(otraCaracteristica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Otracaracteristica otraCaracteristica = new Otracaracteristica();
			Assert.assertNotNull(otraCaracteristicaService.getAllNotContainBy(otraCaracteristica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Otracaracteristica otraCaracteristica = new Otracaracteristica();
			Assert.assertNotNull(otraCaracteristicaService.getAllIsNullBy(otraCaracteristica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Otracaracteristica otraCaracteristica = new Otracaracteristica();
			Assert.assertNotNull(otraCaracteristicaService.getAllNotIsNullBy(otraCaracteristica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Otracaracteristica otraCaracteristica = new Otracaracteristica();
			otraCaracteristica.setCodigootracaracteristica("z");
			otraCaracteristica.setNombreotracaracteristica("z");
			Assert.assertEquals(otraCaracteristicaService.save(otraCaracteristica), true);
			Assert.assertNotNull(otraCaracteristicaService.get(otraCaracteristica.getCodigootracaracteristica()));
			otraCaracteristica.setNombreotracaracteristica("zz");
			Assert.assertEquals(otraCaracteristicaService.update(otraCaracteristica), true);			
			Assert.assertEquals(otraCaracteristicaService.delete(otraCaracteristica.getCodigootracaracteristica()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Otracaracteristica otraCaracteristica = new Otracaracteristica();
			otraCaracteristica.setCodigootracaracteristica("z");
			otraCaracteristica.setNombreotracaracteristica("zz");
			Assert.assertEquals(otraCaracteristicaService.update(otraCaracteristica), true);
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
			Assert.assertEquals(otraCaracteristicaService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
