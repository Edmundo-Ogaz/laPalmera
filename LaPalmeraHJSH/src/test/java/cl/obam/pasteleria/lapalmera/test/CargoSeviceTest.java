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
import cl.obam.pasteleria.lapalmera.model.Cargo;
import cl.obam.pasteleria.lapalmera.service.CargoService;
import cl.obam.pasteleria.lapalmera.view.CargoVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class CargoSeviceTest {
	
	@Autowired
	private CargoService cargoService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			List<Cargo> listCargo = cargoService.getAll();
			Assert.assertNotNull(listCargo);
			List<Object> list = new ArrayList<Object>();
			for (Cargo cargo : listCargo) {
				list.add(new CargoVO(cargo.getCodigo(),
						cargo.getNombre()));
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
			Cargo cargo = new Cargo();
			Assert.assertNotNull(cargoService.getAllEqBy(cargo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Cargo cargo = new Cargo();
			Assert.assertNotNull(cargoService.getAllNotEqBy(cargo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Cargo cargo = new Cargo();
			Assert.assertNotNull(cargoService.getAllBeginWithBy(cargo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Cargo cargo = new Cargo();
			Assert.assertNotNull(cargoService.getAllNotBeginWithBy(cargo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Cargo cargo = new Cargo();
			Assert.assertNotNull(cargoService.getAllEndWithBy(cargo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Cargo> list = null;
		try {
			Cargo cargo = new Cargo();
			Assert.assertNotNull(cargoService.getAllNotEndWithBy(cargo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Cargo cargo = new Cargo();
			Assert.assertNotNull(cargoService.getAllContainBy(cargo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Cargo cargo = new Cargo();
			Assert.assertNotNull(cargoService.getAllNotContainBy(cargo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Cargo cargo = new Cargo();
			Assert.assertNotNull(cargoService.getAllIsNullBy(cargo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Cargo cargo = new Cargo();
			Assert.assertNotNull(cargoService.getAllNotIsNullBy(cargo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Cargo cargo = new Cargo();
			cargo.setCodigo("z");
			cargo.setNombre("z");
			Assert.assertEquals(cargoService.save(cargo), true);
			Assert.assertNotNull(cargoService.get(cargo.getCodigo()));
			cargo.setNombre("zz");
			Assert.assertEquals(cargoService.update(cargo), true);			
			Assert.assertEquals(cargoService.delete(cargo.getCodigo()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Cargo cargo = new Cargo();
			cargo.setCodigo("z");
			cargo.setNombre("zz");
			Assert.assertEquals(cargoService.update(cargo), true);
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
			Assert.assertEquals(cargoService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
