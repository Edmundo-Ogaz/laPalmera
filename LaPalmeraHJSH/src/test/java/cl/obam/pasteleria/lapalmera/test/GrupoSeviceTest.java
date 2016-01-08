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
import cl.obam.pasteleria.lapalmera.model.Grupo;
import cl.obam.pasteleria.lapalmera.service.GrupoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class GrupoSeviceTest {
	
	@Autowired
	private GrupoService grupoService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(grupoService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Grupo grupo = new Grupo();
			Assert.assertNotNull(grupoService.getAllEqBy(grupo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Grupo grupo = new Grupo();
			Assert.assertNotNull(grupoService.getAllNotEqBy(grupo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Grupo grupo = new Grupo();
			Assert.assertNotNull(grupoService.getAllBeginWithBy(grupo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Grupo grupo = new Grupo();
			Assert.assertNotNull(grupoService.getAllNotBeginWithBy(grupo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Grupo grupo = new Grupo();
			Assert.assertNotNull(grupoService.getAllEndWithBy(grupo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Grupo> list = null;
		try {
			Grupo grupo = new Grupo();
			Assert.assertNotNull(grupoService.getAllNotEndWithBy(grupo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Grupo grupo = new Grupo();
			Assert.assertNotNull(grupoService.getAllContainBy(grupo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Grupo grupo = new Grupo();
			Assert.assertNotNull(grupoService.getAllNotContainBy(grupo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Grupo grupo = new Grupo();
			Assert.assertNotNull(grupoService.getAllIsNullBy(grupo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Grupo grupo = new Grupo();
			Assert.assertNotNull(grupoService.getAllNotIsNullBy(grupo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Grupo grupo = new Grupo();
			grupo.setCodigo("z");
			grupo.setNombre("z");
			Assert.assertEquals(grupoService.save(grupo), true);
			Assert.assertNotNull(grupoService.get(grupo.getCodigo()));
			grupo.setNombre("zz");
			Assert.assertEquals(grupoService.update(grupo), true);			
			Assert.assertEquals(grupoService.delete(grupo.getCodigo()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Grupo grupo = new Grupo();
			grupo.setCodigo("z");
			grupo.setNombre("zz");
			Assert.assertEquals(grupoService.update(grupo), true);
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
			Assert.assertEquals(grupoService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
