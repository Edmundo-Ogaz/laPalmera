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
import cl.obam.pasteleria.lapalmera.model.Area;
import cl.obam.pasteleria.lapalmera.service.AreaService;
import cl.obam.pasteleria.lapalmera.view.AreaVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class AreaSeviceTest {
	
	@Autowired
	private AreaService areaService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			List<Area> listArea = areaService.getAll();
			Assert.assertNotNull(listArea);
			List<Object> list = new ArrayList<Object>();
			for (Area area : listArea) {
				list.add(new AreaVO(area.getCodigo(), area.getNombre()));
			}
			Assert.assertTrue(listArea.size() > 1);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Area area = new Area();
			Assert.assertNotNull(areaService.getAllEqBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Area area = new Area();
			Assert.assertNotNull(areaService.getAllNotEqBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Area area = new Area();
			Assert.assertNotNull(areaService.getAllBeginWithBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Area area = new Area();
			Assert.assertNotNull(areaService.getAllNotBeginWithBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Area area = new Area();
			Assert.assertNotNull(areaService.getAllEndWithBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Area> list = null;
		try {
			Area area = new Area();
			Assert.assertNotNull(areaService.getAllNotEndWithBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Area area = new Area();
			Assert.assertNotNull(areaService.getAllContainBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Area area = new Area();
			Assert.assertNotNull(areaService.getAllNotContainBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Area area = new Area();
			Assert.assertNotNull(areaService.getAllIsNullBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Area area = new Area();
			Assert.assertNotNull(areaService.getAllNotIsNullBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Area area = new Area();
			area.setCodigo("z");
			area.setNombre("z");
			Assert.assertEquals(areaService.save(area), true);
			Assert.assertNotNull(areaService.get(area.getCodigo()));
			area.setNombre("zz");
			Assert.assertEquals(areaService.update(area), true);			
			Assert.assertEquals(areaService.delete(area.getCodigo()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Area area = new Area();
			area.setCodigo("z");
			area.setNombre("zz");
			Assert.assertEquals(areaService.update(area), true);
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
