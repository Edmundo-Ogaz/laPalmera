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
import cl.obam.pasteleria.lapalmera.model.Detalledevolucioninsumo;
import cl.obam.pasteleria.lapalmera.service.DetalleDevolucionInsumoService;
import cl.obam.pasteleria.lapalmera.view.DetalleDevolucionInsumoVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class DetalleDevolucionInsumoSeviceTest {
	
	@Autowired
	private DetalleDevolucionInsumoService detalleDevolucionInsumoService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			List<Detalledevolucioninsumo> listDetalleDevolucionInsumo = detalleDevolucionInsumoService.getAll();
			Assert.assertNotNull(listDetalleDevolucionInsumo);
			List<Object> list = new ArrayList<Object>();
			for (Detalledevolucioninsumo detalleDevolucionInsumo : listDetalleDevolucionInsumo) {
				list.add(new DetalleDevolucionInsumoVO(detalleDevolucionInsumo.getCorrelativodevolucioninsumo(),
						detalleDevolucionInsumo.getProducto().getNombreproducto(),
						detalleDevolucionInsumo.getCodigounidadmedida()));
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
			Detalledevolucioninsumo detalleDevolucionInsumo = new Detalledevolucioninsumo();
			Assert.assertNotNull(detalleDevolucionInsumoService.getAllEqBy(detalleDevolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Detalledevolucioninsumo detalleDevolucionInsumo = new Detalledevolucioninsumo();
			Assert.assertNotNull(detalleDevolucionInsumoService.getAllNotEqBy(detalleDevolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Detalledevolucioninsumo detalleDevolucionInsumo = new Detalledevolucioninsumo();
			Assert.assertNotNull(detalleDevolucionInsumoService.getAllBeginWithBy(detalleDevolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Detalledevolucioninsumo detalleDevolucionInsumo = new Detalledevolucioninsumo();
			Assert.assertNotNull(detalleDevolucionInsumoService.getAllNotBeginWithBy(detalleDevolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Detalledevolucioninsumo detalleDevolucionInsumo = new Detalledevolucioninsumo();
			Assert.assertNotNull(detalleDevolucionInsumoService.getAllEndWithBy(detalleDevolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Detalledevolucioninsumo> list = null;
		try {
			Detalledevolucioninsumo detalleDevolucionInsumo = new Detalledevolucioninsumo();
			Assert.assertNotNull(detalleDevolucionInsumoService.getAllNotEndWithBy(detalleDevolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Detalledevolucioninsumo detalleDevolucionInsumo = new Detalledevolucioninsumo();
			Assert.assertNotNull(detalleDevolucionInsumoService.getAllContainBy(detalleDevolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Detalledevolucioninsumo detalleDevolucionInsumo = new Detalledevolucioninsumo();
			Assert.assertNotNull(detalleDevolucionInsumoService.getAllNotContainBy(detalleDevolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Detalledevolucioninsumo detalleDevolucionInsumo = new Detalledevolucioninsumo();
			Assert.assertNotNull(detalleDevolucionInsumoService.getAllIsNullBy(detalleDevolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Detalledevolucioninsumo detalleDevolucionInsumo = new Detalledevolucioninsumo();
			Assert.assertNotNull(detalleDevolucionInsumoService.getAllNotIsNullBy(detalleDevolucionInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Detalledevolucioninsumo detalleDevolucionInsumo = new Detalledevolucioninsumo();
			detalleDevolucionInsumo.setCorrelativodevolucioninsumo(1);
			detalleDevolucionInsumo.setCantidaddevolucioninsumo(10);
			Assert.assertEquals(detalleDevolucionInsumoService.save(detalleDevolucionInsumo), true);
			Assert.assertNotNull(detalleDevolucionInsumoService.get(String.valueOf(detalleDevolucionInsumo.getCorrelativodevolucioninsumo())));
			detalleDevolucionInsumo.setCantidaddevolucioninsumo(100);
			Assert.assertEquals(detalleDevolucionInsumoService.update(detalleDevolucionInsumo), true);			
			Assert.assertEquals(detalleDevolucionInsumoService.delete(detalleDevolucionInsumo.getCodigounidadmedida()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Detalledevolucioninsumo detalleDevolucionInsumo = new Detalledevolucioninsumo();
			detalleDevolucionInsumo.setCorrelativodevolucioninsumo(1);
			detalleDevolucionInsumo.setCantidaddevolucioninsumo(100);
			Assert.assertEquals(detalleDevolucionInsumoService.update(detalleDevolucionInsumo), true);
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
			Assert.assertEquals(detalleDevolucionInsumoService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
