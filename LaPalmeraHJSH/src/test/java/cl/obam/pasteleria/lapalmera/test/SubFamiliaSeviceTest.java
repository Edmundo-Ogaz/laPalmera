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
import cl.obam.pasteleria.lapalmera.model.Subfamilia;
import cl.obam.pasteleria.lapalmera.service.SubFamiliaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class SubFamiliaSeviceTest {
	
	@Autowired
	private SubFamiliaService subFamiliaService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(subFamiliaService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Subfamilia subFamilia = new Subfamilia();
			Assert.assertNotNull(subFamiliaService.getAllEqBy(subFamilia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Subfamilia subFamilia = new Subfamilia();
			Assert.assertNotNull(subFamiliaService.getAllNotEqBy(subFamilia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Subfamilia subFamilia = new Subfamilia();
			Assert.assertNotNull(subFamiliaService.getAllBeginWithBy(subFamilia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Subfamilia subFamilia = new Subfamilia();
			Assert.assertNotNull(subFamiliaService.getAllNotBeginWithBy(subFamilia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Subfamilia subFamilia = new Subfamilia();
			Assert.assertNotNull(subFamiliaService.getAllEndWithBy(subFamilia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Subfamilia> list = null;
		try {
			Subfamilia subFamilia = new Subfamilia();
			Assert.assertNotNull(subFamiliaService.getAllNotEndWithBy(subFamilia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Subfamilia subFamilia = new Subfamilia();
			Assert.assertNotNull(subFamiliaService.getAllContainBy(subFamilia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Subfamilia subFamilia = new Subfamilia();
			Assert.assertNotNull(subFamiliaService.getAllNotContainBy(subFamilia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Subfamilia subFamilia = new Subfamilia();
			Assert.assertNotNull(subFamiliaService.getAllIsNullBy(subFamilia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Subfamilia subFamilia = new Subfamilia();
			Assert.assertNotNull(subFamiliaService.getAllNotIsNullBy(subFamilia));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Subfamilia subFamilia = new Subfamilia();
			subFamilia.setCodigosubfamilia("z");
			subFamilia.setNombresubfamilia("z");
			Assert.assertEquals(subFamiliaService.save(subFamilia), true);
			Assert.assertNotNull(subFamiliaService.get(subFamilia.getCodigosubfamilia()));
			subFamilia.setNombresubfamilia("zz");
			Assert.assertEquals(subFamiliaService.update(subFamilia), true);			
			Assert.assertEquals(subFamiliaService.delete(subFamilia.getCodigosubfamilia()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Subfamilia subFamilia = new Subfamilia();
			subFamilia.setCodigosubfamilia("z");
			subFamilia.setNombresubfamilia("zz");
			Assert.assertEquals(subFamiliaService.update(subFamilia), true);
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
			Assert.assertEquals(subFamiliaService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
