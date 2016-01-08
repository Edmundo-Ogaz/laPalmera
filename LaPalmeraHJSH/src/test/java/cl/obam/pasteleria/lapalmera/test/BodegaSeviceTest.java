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


import cl.obam.pasteleria.lapalmera.cons.OperacionEnum;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Area;
import cl.obam.pasteleria.lapalmera.model.Bodega;
import cl.obam.pasteleria.lapalmera.service.BodegaService;
import cl.obam.pasteleria.lapalmera.view.AreaVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class BodegaSeviceTest {
	
	@Autowired
	private BodegaService bodegaService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			List<Bodega> listBodega = bodegaService.getAll();
			Assert.assertNotNull(listBodega);
			List<Object> list = new ArrayList<Object>();
			for (Bodega bodega : listBodega) {
				list.add(new AreaVO(bodega.getCodigo(), bodega.getNombre()));
			}
			Assert.assertTrue(listBodega.size() > 1);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Bodega bodega = new Bodega();
			Assert.assertNotNull(bodegaService.getAllEqBy(bodega));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Bodega bodega = new Bodega();
			Assert.assertNotNull(bodegaService.getAllNotEqBy(bodega));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Bodega bodega = new Bodega();
			Assert.assertNotNull(bodegaService.getAllBeginWithBy(bodega));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Bodega bodega = new Bodega();
			Assert.assertNotNull(bodegaService.getAllNotBeginWithBy(bodega));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Bodega bodega = new Bodega();
			Assert.assertNotNull(bodegaService.getAllEndWithBy(bodega));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Bodega> list = null;
		try {
			Bodega bodega = new Bodega();
			Assert.assertNotNull(bodegaService.getAllNotEndWithBy(bodega));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Bodega bodega = new Bodega();
			Assert.assertNotNull(bodegaService.getAllContainBy(bodega));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Bodega bodega = new Bodega();
			Assert.assertNotNull(bodegaService.getAllNotContainBy(bodega));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Bodega bodega = new Bodega();
			Assert.assertNotNull(bodegaService.getAllIsNullBy(bodega));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Bodega bodega = new Bodega();
			Assert.assertNotNull(bodegaService.getAllNotIsNullBy(bodega));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Bodega bodega = new Bodega();
			bodega.setCodigo("z");
			bodega.setNombre("z");
			Assert.assertEquals(bodegaService.save(bodega), true);
			Assert.assertNotNull(bodegaService.get(bodega.getCodigo()));
			bodega.setNombre("zz");
			Assert.assertEquals(bodegaService.update(bodega), true);			
			Assert.assertEquals(bodegaService.delete(bodega.getCodigo()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Bodega bodega = new Bodega();
			bodega.setCodigo("z");
			bodega.setNombre("zz");
			Assert.assertEquals(bodegaService.update(bodega), true);
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
			Assert.assertEquals(bodegaService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
