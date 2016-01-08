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
import cl.obam.pasteleria.lapalmera.model.Cliente;
import cl.obam.pasteleria.lapalmera.service.ClienteService;
import cl.obam.pasteleria.lapalmera.view.ClienteVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class ClienteSeviceTest {
	
	@Autowired
	private ClienteService clienteService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			List<Cliente> listCiudad = clienteService.getAll();
			Assert.assertNotNull(listCiudad);
			List<Object> list = new ArrayList<Object>();
			for (Cliente ciudad : listCiudad) {
				list.add(new ClienteVO(ciudad.getRutcliente(),
						ciudad.getComuna().getNombre(),
						ciudad.getTipocliente().getNombre(),
						ciudad.getNombre(),
						ciudad.getDireccion(),
						ciudad.getFechanacimiento(),
						ciudad.getTelefono(),
						ciudad.getEmail(),
						ciudad.getPaginawebcliente(),
						ciudad.getObservacion(),
						ciudad.getCelular()));
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
			Cliente cliente = new Cliente();
			Assert.assertNotNull(clienteService.getAllEqBy(cliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Cliente cliente = new Cliente();
			Assert.assertNotNull(clienteService.getAllNotEqBy(cliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Cliente cliente = new Cliente();
			Assert.assertNotNull(clienteService.getAllBeginWithBy(cliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Cliente cliente = new Cliente();
			Assert.assertNotNull(clienteService.getAllNotBeginWithBy(cliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Cliente cliente = new Cliente();
			Assert.assertNotNull(clienteService.getAllEndWithBy(cliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Cliente> list = null;
		try {
			Cliente cliente = new Cliente();
			Assert.assertNotNull(clienteService.getAllNotEndWithBy(cliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Cliente cliente = new Cliente();
			Assert.assertNotNull(clienteService.getAllContainBy(cliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Cliente cliente = new Cliente();
			Assert.assertNotNull(clienteService.getAllNotContainBy(cliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Cliente cliente = new Cliente();
			Assert.assertNotNull(clienteService.getAllIsNullBy(cliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Cliente cliente = new Cliente();
			Assert.assertNotNull(clienteService.getAllNotIsNullBy(cliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Cliente cliente = new Cliente();
			cliente.setRutcliente("z");
			cliente.setNombre("z");
			Assert.assertEquals(clienteService.save(cliente), true);
			Assert.assertNotNull(clienteService.get(cliente.getRutcliente()));
			cliente.setNombre("zz");
			Assert.assertEquals(clienteService.update(cliente), true);			
			Assert.assertEquals(clienteService.delete(cliente.getRutcliente()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Cliente cliente = new Cliente();
			cliente.setRutcliente("z");
			cliente.setNombre("zz");
			Assert.assertEquals(clienteService.update(cliente), true);
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
			Assert.assertEquals(clienteService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
