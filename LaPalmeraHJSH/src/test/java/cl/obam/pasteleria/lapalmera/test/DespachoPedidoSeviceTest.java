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
import cl.obam.pasteleria.lapalmera.model.Despachopedido;
import cl.obam.pasteleria.lapalmera.service.DespachoPedidoService;
import cl.obam.pasteleria.lapalmera.view.DespachoPedidoVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class DespachoPedidoSeviceTest {
	
	@Autowired
	private DespachoPedidoService despachoPedidoService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			List<Despachopedido> listDespachoPedido = despachoPedidoService.getAll();
			Assert.assertNotNull(listDespachoPedido);
			List<Object> list = new ArrayList<Object>();
			for (Despachopedido despachoPedido : listDespachoPedido) {
				list.add(new DespachoPedidoVO(despachoPedido.getNumeropedido(),
						despachoPedido.getNombrecliente(),
						despachoPedido.getEntrega(),
						despachoPedido.getFechaentregadespacho(),
						despachoPedido.getHoraentregadespacho()));
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
			Despachopedido despachoPedido = new Despachopedido();
			Assert.assertNotNull(despachoPedidoService.getAllEqBy(despachoPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Despachopedido despachoPedido = new Despachopedido();
			Assert.assertNotNull(despachoPedidoService.getAllNotEqBy(despachoPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Despachopedido despachoPedido = new Despachopedido();
			Assert.assertNotNull(despachoPedidoService.getAllBeginWithBy(despachoPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Despachopedido despachoPedido = new Despachopedido();
			Assert.assertNotNull(despachoPedidoService.getAllNotBeginWithBy(despachoPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Despachopedido despachoPedido = new Despachopedido();
			Assert.assertNotNull(despachoPedidoService.getAllEndWithBy(despachoPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Despachopedido> list = null;
		try {
			Despachopedido despachoPedido = new Despachopedido();
			Assert.assertNotNull(despachoPedidoService.getAllNotEndWithBy(despachoPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Despachopedido despachoPedido = new Despachopedido();
			Assert.assertNotNull(despachoPedidoService.getAllContainBy(despachoPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Despachopedido despachoPedido = new Despachopedido();
			Assert.assertNotNull(despachoPedidoService.getAllNotContainBy(despachoPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Despachopedido despachoPedido = new Despachopedido();
			Assert.assertNotNull(despachoPedidoService.getAllIsNullBy(despachoPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Despachopedido despachoPedido = new Despachopedido();
			Assert.assertNotNull(despachoPedidoService.getAllNotIsNullBy(despachoPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Despachopedido despachoPedido = new Despachopedido();
			despachoPedido.setNumeropedido(1);
			despachoPedido.setNombrecliente("z");
			Assert.assertEquals(despachoPedidoService.save(despachoPedido), true);
			Assert.assertNotNull(despachoPedidoService.get(String.valueOf(despachoPedido.getNumeropedido())));
			despachoPedido.setNombrecliente("zz");
			Assert.assertEquals(despachoPedidoService.update(despachoPedido), true);			
			Assert.assertEquals(despachoPedidoService.delete(String.valueOf(despachoPedido.getNumeropedido())), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Despachopedido despachoPedido = new Despachopedido();
			despachoPedido.setNumeropedido(11);
			despachoPedido.setNombrecliente("zz");
			Assert.assertEquals(despachoPedidoService.update(despachoPedido), true);
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
			Assert.assertEquals(despachoPedidoService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
