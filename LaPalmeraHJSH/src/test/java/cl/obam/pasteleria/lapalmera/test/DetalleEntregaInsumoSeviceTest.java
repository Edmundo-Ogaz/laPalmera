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
import cl.obam.pasteleria.lapalmera.model.Detalleentregainsumo;
import cl.obam.pasteleria.lapalmera.service.DetalleEntregaInsumoService;
import cl.obam.pasteleria.lapalmera.view.DetalleEntregaInsumoVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class DetalleEntregaInsumoSeviceTest {
	
	@Autowired
	private DetalleEntregaInsumoService detalleEntregaInsumoService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(detalleEntregaInsumoService.getAll());
			List<Detalleentregainsumo> listDetalleEntregaInsumo = detalleEntregaInsumoService.getAll();
			Assert.assertNotNull(listDetalleEntregaInsumo);
			List<Object> list = new ArrayList<Object>();
			for (Detalleentregainsumo detalleEntregaInsumo : listDetalleEntregaInsumo) {
				list.add(new DetalleEntregaInsumoVO(detalleEntregaInsumo.getCorrelativoentregainsumo(),
						detalleEntregaInsumo.getProducto().getNombreproducto(),
						detalleEntregaInsumo.getCantidadentregainsumo(),
						detalleEntregaInsumo.getUnidadmedida()));
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
			Detalleentregainsumo detalleEntregaInsumo = new Detalleentregainsumo();
			Assert.assertNotNull(detalleEntregaInsumoService.getAllEqBy(detalleEntregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Detalleentregainsumo detalleEntregaInsumo = new Detalleentregainsumo();
			Assert.assertNotNull(detalleEntregaInsumoService.getAllNotEqBy(detalleEntregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Detalleentregainsumo detalleEntregaInsumo = new Detalleentregainsumo();
			Assert.assertNotNull(detalleEntregaInsumoService.getAllBeginWithBy(detalleEntregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Detalleentregainsumo detalleEntregaInsumo = new Detalleentregainsumo();
			Assert.assertNotNull(detalleEntregaInsumoService.getAllNotBeginWithBy(detalleEntregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Detalleentregainsumo detalleEntregaInsumo = new Detalleentregainsumo();
			Assert.assertNotNull(detalleEntregaInsumoService.getAllEndWithBy(detalleEntregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Detalleentregainsumo> list = null;
		try {
			Detalleentregainsumo detalleEntregaInsumo = new Detalleentregainsumo();
			Assert.assertNotNull(detalleEntregaInsumoService.getAllNotEndWithBy(detalleEntregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Detalleentregainsumo detalleEntregaInsumo = new Detalleentregainsumo();
			Assert.assertNotNull(detalleEntregaInsumoService.getAllContainBy(detalleEntregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Detalleentregainsumo detalleEntregaInsumo = new Detalleentregainsumo();
			Assert.assertNotNull(detalleEntregaInsumoService.getAllNotContainBy(detalleEntregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Detalleentregainsumo detalleEntregaInsumo = new Detalleentregainsumo();
			Assert.assertNotNull(detalleEntregaInsumoService.getAllIsNullBy(detalleEntregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Detalleentregainsumo detalleEntregaInsumo = new Detalleentregainsumo();
			Assert.assertNotNull(detalleEntregaInsumoService.getAllNotIsNullBy(detalleEntregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Detalleentregainsumo detalleEntregaInsumo = new Detalleentregainsumo();
			detalleEntregaInsumo.setCorrelativoentregainsumo(1);
			detalleEntregaInsumo.setCodigounidadmedida("z");
			Assert.assertEquals(detalleEntregaInsumoService.save(detalleEntregaInsumo), true);
			Assert.assertNotNull(detalleEntregaInsumoService.get(Integer.toString(detalleEntregaInsumo.getCorrelativoentregainsumo())));
			detalleEntregaInsumo.setCodigounidadmedida("zz");
			Assert.assertEquals(detalleEntregaInsumoService.update(detalleEntregaInsumo), true);			
			Assert.assertEquals(detalleEntregaInsumoService.delete(Integer.toString(detalleEntregaInsumo.getCorrelativoentregainsumo())), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Detalleentregainsumo detalleEntregaInsumo = new Detalleentregainsumo();
			detalleEntregaInsumo.setCorrelativoentregainsumo(1);
			detalleEntregaInsumo.setCodigounidadmedida("zz");
			Assert.assertEquals(detalleEntregaInsumoService.update(detalleEntregaInsumo), true);
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
			Assert.assertEquals(detalleEntregaInsumoService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
