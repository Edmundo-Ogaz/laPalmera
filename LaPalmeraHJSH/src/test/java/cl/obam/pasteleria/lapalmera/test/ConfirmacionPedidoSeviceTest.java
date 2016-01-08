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
import cl.obam.pasteleria.lapalmera.model.Confirmacionpedido;
import cl.obam.pasteleria.lapalmera.service.ConfirmacionPedidoService;
import cl.obam.pasteleria.lapalmera.view.ConfirmacionPedidoVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class ConfirmacionPedidoSeviceTest {
	
	@Autowired
	private ConfirmacionPedidoService confirmacionPedidoService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			List<Confirmacionpedido> listConfirmacionPedido = confirmacionPedidoService.getAll();
			Assert.assertNotNull(listConfirmacionPedido);
			List<Object> list = new ArrayList<Object>();
			for (Confirmacionpedido confirmacionPedido : listConfirmacionPedido) {
				list.add(new ConfirmacionPedidoVO(confirmacionPedido.getNumeropedido(),
						confirmacionPedido.getNombrecliente(),
						confirmacionPedido.getApellidocliente(),
						confirmacionPedido.getDireccioncliente(),
						confirmacionPedido.getTelefonocliente()));
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
			Confirmacionpedido confirmacionPedido = new Confirmacionpedido();
			Assert.assertNotNull(confirmacionPedidoService.getAllEqBy(confirmacionPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Confirmacionpedido confirmacionPedido = new Confirmacionpedido();
			Assert.assertNotNull(confirmacionPedidoService.getAllNotEqBy(confirmacionPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Confirmacionpedido confirmacionPedido = new Confirmacionpedido();
			Assert.assertNotNull(confirmacionPedidoService.getAllBeginWithBy(confirmacionPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Confirmacionpedido confirmacionPedido = new Confirmacionpedido();
			Assert.assertNotNull(confirmacionPedidoService.getAllNotBeginWithBy(confirmacionPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Confirmacionpedido confirmacionPedido = new Confirmacionpedido();
			Assert.assertNotNull(confirmacionPedidoService.getAllEndWithBy(confirmacionPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Confirmacionpedido> list = null;
		try {
			Confirmacionpedido confirmacionPedido = new Confirmacionpedido();
			Assert.assertNotNull(confirmacionPedidoService.getAllNotEndWithBy(confirmacionPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Confirmacionpedido confirmacionPedido = new Confirmacionpedido();
			Assert.assertNotNull(confirmacionPedidoService.getAllContainBy(confirmacionPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Confirmacionpedido confirmacionPedido = new Confirmacionpedido();
			Assert.assertNotNull(confirmacionPedidoService.getAllNotContainBy(confirmacionPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Confirmacionpedido confirmacionPedido = new Confirmacionpedido();
			Assert.assertNotNull(confirmacionPedidoService.getAllIsNullBy(confirmacionPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Confirmacionpedido confirmacionPedido = new Confirmacionpedido();
			Assert.assertNotNull(confirmacionPedidoService.getAllNotIsNullBy(confirmacionPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Confirmacionpedido confirmacionPedido = new Confirmacionpedido();
			confirmacionPedido.setNumeropedido(1);
			confirmacionPedido.setNombrecliente("z");
			Assert.assertEquals(confirmacionPedidoService.save(confirmacionPedido), true);
			Assert.assertNotNull(confirmacionPedidoService.get(Integer.toString(confirmacionPedido.getNumeropedido())));
			confirmacionPedido.setNombrecliente("zz");
			Assert.assertEquals(confirmacionPedidoService.update(confirmacionPedido), true);			
			Assert.assertEquals(confirmacionPedidoService.delete(Integer.toString(confirmacionPedido.getNumeropedido())), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Confirmacionpedido confirmacionPedido = new Confirmacionpedido();
			confirmacionPedido.setNumeropedido(11);
			confirmacionPedido.setNombrecliente("zz");
			Assert.assertEquals(confirmacionPedidoService.update(confirmacionPedido), true);
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
			Assert.assertEquals(confirmacionPedidoService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
