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
import cl.obam.pasteleria.lapalmera.model.Fichatecnica;
import cl.obam.pasteleria.lapalmera.service.FichaTecnicaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class FichaTecnicaSeviceTest {
	
	@Autowired
	private FichaTecnicaService fichaTecnicaService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(fichaTecnicaService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Fichatecnica fichaTecnica = new Fichatecnica();
			Assert.assertNotNull(fichaTecnicaService.getAllEqBy(fichaTecnica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Fichatecnica fichaTecnica = new Fichatecnica();
			Assert.assertNotNull(fichaTecnicaService.getAllNotEqBy(fichaTecnica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Fichatecnica fichaTecnica = new Fichatecnica();
			Assert.assertNotNull(fichaTecnicaService.getAllBeginWithBy(fichaTecnica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Fichatecnica fichaTecnica = new Fichatecnica();
			Assert.assertNotNull(fichaTecnicaService.getAllNotBeginWithBy(fichaTecnica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Fichatecnica fichaTecnica = new Fichatecnica();
			Assert.assertNotNull(fichaTecnicaService.getAllEndWithBy(fichaTecnica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Fichatecnica> list = null;
		try {
			Fichatecnica fichaTecnica = new Fichatecnica();
			Assert.assertNotNull(fichaTecnicaService.getAllNotEndWithBy(fichaTecnica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Fichatecnica fichaTecnica = new Fichatecnica();
			Assert.assertNotNull(fichaTecnicaService.getAllContainBy(fichaTecnica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Fichatecnica fichaTecnica = new Fichatecnica();
			Assert.assertNotNull(fichaTecnicaService.getAllNotContainBy(fichaTecnica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Fichatecnica fichaTecnica = new Fichatecnica();
			Assert.assertNotNull(fichaTecnicaService.getAllIsNullBy(fichaTecnica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Fichatecnica fichaTecnica = new Fichatecnica();
			Assert.assertNotNull(fichaTecnicaService.getAllNotIsNullBy(fichaTecnica));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Fichatecnica fichaTecnica = new Fichatecnica();
			fichaTecnica.setDescripcion("z");
			Assert.assertEquals(fichaTecnicaService.save(fichaTecnica), true);
			Assert.assertNotNull(fichaTecnicaService.get(fichaTecnica.getDescripcion()));
			fichaTecnica.setDescripcion("zz");
			Assert.assertEquals(fichaTecnicaService.update(fichaTecnica), true);			
			Assert.assertEquals(fichaTecnicaService.delete(fichaTecnica.getDescripcion()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Fichatecnica fichaTecnica = new Fichatecnica();
			fichaTecnica.setDescripcion("z");
			Assert.assertEquals(fichaTecnicaService.update(fichaTecnica), true);
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
			Assert.assertEquals(fichaTecnicaService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
