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
import cl.obam.pasteleria.lapalmera.model.Comuna;
import cl.obam.pasteleria.lapalmera.service.CiudadService;
import cl.obam.pasteleria.lapalmera.service.ComunaService;
import cl.obam.pasteleria.lapalmera.view.ComunaVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class ComunaSeviceTest {
	
	@Autowired
	private ComunaService comunaService;
	
	@Autowired
	private CiudadService ciudadService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			List<Comuna> listComuna = comunaService.getAll();
			Assert.assertNotNull(listComuna);
			List<Object> list = new ArrayList<Object>();
			for (Comuna comuna : listComuna) {
				list.add(new ComunaVO(comuna.getCodigo(),
						comuna.getNombre(),
						comuna.getCiudad().getNombre()));
			}
			Assert.assertTrue(list.size() > 1);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Comuna comuna = new Comuna();
			Assert.assertNotNull(comunaService.getAllEqBy(comuna));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Comuna comuna = new Comuna();
			Assert.assertNotNull(comunaService.getAllNotEqBy(comuna));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Comuna comuna = new Comuna();
			Assert.assertNotNull(comunaService.getAllBeginWithBy(comuna));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Comuna comuna = new Comuna();
			Assert.assertNotNull(comunaService.getAllNotBeginWithBy(comuna));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Comuna comuna = new Comuna();
			Assert.assertNotNull(comunaService.getAllEndWithBy(comuna));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Comuna> list = null;
		try {
			Comuna comuna = new Comuna();
			Assert.assertNotNull(comunaService.getAllNotEndWithBy(comuna));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Comuna comuna = new Comuna();
			Assert.assertNotNull(comunaService.getAllContainBy(comuna));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Comuna comuna = new Comuna();
			Assert.assertNotNull(comunaService.getAllNotContainBy(comuna));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Comuna comuna = new Comuna();
			Assert.assertNotNull(comunaService.getAllIsNullBy(comuna));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Comuna comuna = new Comuna();
			Assert.assertNotNull(comunaService.getAllNotIsNullBy(comuna));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Ciudad ciudad = new Ciudad();
			ciudad.setCodigo("R02C01");
			Ciudad c = ciudadService.get(ciudad.getCodigo());
			Assert.assertNotNull(c);
			Comuna comuna = new Comuna();
			comuna.setCodigo("z");
			comuna.setNombre("z");
			comuna.setCiudad(c);
			Assert.assertEquals(comunaService.save(comuna), true);
			Assert.assertNotNull(comunaService.get(comuna.getCodigo()));
			comuna.setNombre("zz");
			Assert.assertEquals(comunaService.update(comuna), true);			
			Assert.assertEquals(comunaService.delete(comuna.getCodigo()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Comuna comuna = new Comuna();
			comuna.setCodigo("z");
			comuna.setNombre("zz");
			Assert.assertEquals(comunaService.update(comuna), true);
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
			Assert.assertEquals(comunaService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
