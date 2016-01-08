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
import cl.obam.pasteleria.lapalmera.model.Tipocliente;
import cl.obam.pasteleria.lapalmera.service.TipoClienteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class TipoClienteSeviceTest {
	
	@Autowired
	private TipoClienteService tipoClienteService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(tipoClienteService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Tipocliente tipoCliente = new Tipocliente();
			Assert.assertNotNull(tipoClienteService.getAllEqBy(tipoCliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Tipocliente tipoCliente = new Tipocliente();
			Assert.assertNotNull(tipoClienteService.getAllNotEqBy(tipoCliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Tipocliente tipoCliente = new Tipocliente();
			Assert.assertNotNull(tipoClienteService.getAllBeginWithBy(tipoCliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Tipocliente tipoCliente = new Tipocliente();
			Assert.assertNotNull(tipoClienteService.getAllNotBeginWithBy(tipoCliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Tipocliente tipoCliente = new Tipocliente();
			Assert.assertNotNull(tipoClienteService.getAllEndWithBy(tipoCliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Tipocliente> list = null;
		try {
			Tipocliente tipoCliente = new Tipocliente();
			Assert.assertNotNull(tipoClienteService.getAllNotEndWithBy(tipoCliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Tipocliente tipoCliente = new Tipocliente();
			Assert.assertNotNull(tipoClienteService.getAllContainBy(tipoCliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Tipocliente tipoCliente = new Tipocliente();
			Assert.assertNotNull(tipoClienteService.getAllNotContainBy(tipoCliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Tipocliente tipoCliente = new Tipocliente();
			Assert.assertNotNull(tipoClienteService.getAllIsNullBy(tipoCliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Tipocliente tipoCliente = new Tipocliente();
			Assert.assertNotNull(tipoClienteService.getAllNotIsNullBy(tipoCliente));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Tipocliente tipoCliente = new Tipocliente();
			tipoCliente.setCodigo("z");
			tipoCliente.setNombre("z");
			Assert.assertEquals(tipoClienteService.save(tipoCliente), true);
			Assert.assertNotNull(tipoClienteService.get(tipoCliente.getCodigo()));
			tipoCliente.setNombre("zz");
			Assert.assertEquals(tipoClienteService.update(tipoCliente), true);			
			Assert.assertEquals(tipoClienteService.delete(tipoCliente.getCodigo()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Tipocliente tipoCliente = new Tipocliente();
			tipoCliente.setCodigo("z");
			tipoCliente.setNombre("zz");
			Assert.assertEquals(tipoClienteService.update(tipoCliente), true);
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
			Assert.assertEquals(tipoClienteService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
