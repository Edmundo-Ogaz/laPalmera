package cl.obam.pasteleria.lapalmera.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Ciudad;
import cl.obam.pasteleria.lapalmera.model.Region;
import cl.obam.pasteleria.lapalmera.service.CiudadService;
import cl.obam.pasteleria.lapalmera.service.RegionService;
import cl.obam.pasteleria.lapalmera.view.CiudadVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class CiudadSeviceTest {
	
	@Autowired
	private CiudadService ciudadService;
	
	@Autowired
	private RegionService regionService;
	
	@SuppressWarnings("deprecation")
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			List<Ciudad> listCiudad = ciudadService.getAll();
			Assert.assertNotNull(listCiudad);
			List<Object> list = new ArrayList<Object>();
			for (Ciudad ciudad : listCiudad) {
				list.add(new CiudadVO(ciudad.getCodigo(), ciudad.getNombre(), ciudad.getRegion().getNombre()));
			}
			Assert.assertTrue(listCiudad.size() > 1);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Ciudad ciudad = new Ciudad();
			Assert.assertNotNull(ciudadService.getAllEqBy(ciudad));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Ciudad ciudad = new Ciudad();
			Assert.assertNotNull(ciudadService.getAllNotEqBy(ciudad));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Ciudad ciudad = new Ciudad();
			Assert.assertNotNull(ciudadService.getAllBeginWithBy(ciudad));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Ciudad ciudad = new Ciudad();
			Assert.assertNotNull(ciudadService.getAllNotBeginWithBy(ciudad));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Ciudad ciudad = new Ciudad();
			Assert.assertNotNull(ciudadService.getAllEndWithBy(ciudad));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Ciudad> list = null;
		try {
			Ciudad ciudad = new Ciudad();
			Assert.assertNotNull(ciudadService.getAllNotEndWithBy(ciudad));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Ciudad ciudad = new Ciudad();
			Assert.assertNotNull(ciudadService.getAllContainBy(ciudad));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Ciudad ciudad = new Ciudad();
			Assert.assertNotNull(ciudadService.getAllNotContainBy(ciudad));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Ciudad ciudad = new Ciudad();
			Assert.assertNotNull(ciudadService.getAllIsNullBy(ciudad));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Ciudad ciudad = new Ciudad();
			Assert.assertNotNull(ciudadService.getAllNotIsNullBy(ciudad));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Region region = new Region();
			region.setCodigo("A");
			Region r = regionService.get(region.getCodigo());
			Assert.assertNotNull(r);
			Ciudad ciudad = new Ciudad();
			ciudad.setCodigo("z");
			ciudad.setNombre("z");
			ciudad.setRegion(r);
			Assert.assertEquals(ciudadService.create(ciudad), true);
			Assert.assertNotNull(ciudadService.get(ciudad.getCodigo()));
			ciudad.setNombre("zz");
			Assert.assertEquals(ciudadService.update(ciudad), true);			
			Assert.assertEquals(ciudadService.delete(ciudad.getCodigo()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Ciudad ciudad = new Ciudad();
			ciudad.setCodigo("z");
			ciudad.setNombre("zz");
			Assert.assertEquals(ciudadService.update(ciudad), true);
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
			Assert.assertEquals(ciudadService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
