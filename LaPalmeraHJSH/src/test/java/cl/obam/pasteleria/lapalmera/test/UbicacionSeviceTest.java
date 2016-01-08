package cl.obam.pasteleria.lapalmera.test;

import java.util.List;

import junit.framework.Assert;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Ubicacion;
import cl.obam.pasteleria.lapalmera.service.UbicacionService;
import cl.obam.pasteleria.lapalmera.view.CapturaProduccionVO;
import cl.obam.pasteleria.lapalmera.view.UbicacionVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class UbicacionSeviceTest {
	
	@Autowired
	private UbicacionService ubicacionService;
	
	@Test
	@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(ubicacionService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			String json = "{\"producto\" : {\"codigo\" : \"T01E01D01\"}}";
			ObjectMapper mapper = new ObjectMapper();
			UbicacionVO ubicacionVO = mapper.readValue(json, UbicacionVO.class);

			Assert.assertNotNull(ubicacionService.getAllEqBy(ubicacionVO));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotEqBy() {
		
		try {
			Ubicacion ubicacion = new Ubicacion();
			Assert.assertNotNull(ubicacionService.getAllNotEqBy(ubicacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Ubicacion ubicacion = new Ubicacion();
			Assert.assertNotNull(ubicacionService.getAllBeginWithBy(ubicacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Ubicacion ubicacion = new Ubicacion();
			Assert.assertNotNull(ubicacionService.getAllNotBeginWithBy(ubicacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllEndWithBy() {
		
		try {
			Ubicacion ubicacion = new Ubicacion();
			Assert.assertNotNull(ubicacionService.getAllEndWithBy(ubicacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotEndWithBy() {
		
		List<Ubicacion> list = null;
		try {
			Ubicacion ubicacion = new Ubicacion();
			Assert.assertNotNull(ubicacionService.getAllNotEndWithBy(ubicacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllContainBy() {
		
		try {
			Ubicacion ubicacion = new Ubicacion();
			Assert.assertNotNull(ubicacionService.getAllContainBy(ubicacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotContainBy() {
		
		try {
			Ubicacion ubicacion = new Ubicacion();
			Assert.assertNotNull(ubicacionService.getAllNotContainBy(ubicacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllIsNullBy() {
		
		try {
			Ubicacion ubicacion = new Ubicacion();
			Assert.assertNotNull(ubicacionService.getAllIsNullBy(ubicacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Ubicacion ubicacion = new Ubicacion();
			Assert.assertNotNull(ubicacionService.getAllNotIsNullBy(ubicacion));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	@Ignore
	public void save() {
		
		try {
			UbicacionVO ubicacionVO = new UbicacionVO();
			Assert.assertEquals(ubicacionService.save(ubicacionVO), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			UbicacionVO ubicacionVO = new UbicacionVO();
			Assert.assertEquals(ubicacionService.update(ubicacionVO), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void delete() {
		
		try {
			UbicacionVO ubicacionVO = new UbicacionVO();
			Assert.assertEquals(ubicacionService.delete(ubicacionVO), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
