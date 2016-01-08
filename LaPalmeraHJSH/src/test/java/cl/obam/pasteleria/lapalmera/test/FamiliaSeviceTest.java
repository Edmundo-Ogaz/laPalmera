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
import cl.obam.pasteleria.lapalmera.model.Familia;
import cl.obam.pasteleria.lapalmera.service.FamiliaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class FamiliaSeviceTest {
	
	@Autowired
	private FamiliaService areaService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(areaService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Familia familia = new Familia();
			Assert.assertNotNull(areaService.getAllEqBy(familia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Familia familia = new Familia();
			Assert.assertNotNull(areaService.getAllNotEqBy(familia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Familia familia = new Familia();
			Assert.assertNotNull(areaService.getAllBeginWithBy(familia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Familia familia = new Familia();
			Assert.assertNotNull(areaService.getAllNotBeginWithBy(familia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Familia familia = new Familia();
			Assert.assertNotNull(areaService.getAllEndWithBy(familia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Familia> list = null;
		try {
			Familia familia = new Familia();
			Assert.assertNotNull(areaService.getAllNotEndWithBy(familia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Familia familia = new Familia();
			Assert.assertNotNull(areaService.getAllContainBy(familia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Familia familia = new Familia();
			Assert.assertNotNull(areaService.getAllNotContainBy(familia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Familia familia = new Familia();
			Assert.assertNotNull(areaService.getAllIsNullBy(familia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Familia familia = new Familia();
			Assert.assertNotNull(areaService.getAllNotIsNullBy(familia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Familia familia = new Familia();
			familia.setCodigofamilia("z");
			familia.setNombrefamilia("z");
			Assert.assertEquals(areaService.save(familia), true);
			Assert.assertNotNull(areaService.get(familia.getCodigofamilia()));
			familia.setNombrefamilia("zz");
			Assert.assertEquals(areaService.update(familia), true);			
			Assert.assertEquals(areaService.delete(familia.getCodigofamilia()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Familia familia = new Familia();
			familia.setCodigofamilia("z");
			familia.setNombrefamilia("zz");
			Assert.assertEquals(areaService.update(familia), true);
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
			Assert.assertEquals(areaService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
