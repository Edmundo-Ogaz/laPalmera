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
import cl.obam.pasteleria.lapalmera.model.Usuario;
import cl.obam.pasteleria.lapalmera.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class UsuarioSeviceTest {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(usuarioService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Usuario usuario = new Usuario();
			Assert.assertNotNull(usuarioService.getAllEqBy(usuario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Usuario usuario = new Usuario();
			Assert.assertNotNull(usuarioService.getAllNotEqBy(usuario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Usuario usuario = new Usuario();
			Assert.assertNotNull(usuarioService.getAllBeginWithBy(usuario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Usuario usuario = new Usuario();
			Assert.assertNotNull(usuarioService.getAllNotBeginWithBy(usuario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Usuario usuario = new Usuario();
			Assert.assertNotNull(usuarioService.getAllEndWithBy(usuario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Usuario> list = null;
		try {
			Usuario usuario = new Usuario();
			Assert.assertNotNull(usuarioService.getAllNotEndWithBy(usuario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Usuario usuario = new Usuario();
			Assert.assertNotNull(usuarioService.getAllContainBy(usuario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Usuario usuario = new Usuario();
			Assert.assertNotNull(usuarioService.getAllNotContainBy(usuario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Usuario usuario = new Usuario();
			Assert.assertNotNull(usuarioService.getAllIsNullBy(usuario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Usuario usuario = new Usuario();
			Assert.assertNotNull(usuarioService.getAllNotIsNullBy(usuario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Usuario usuario = new Usuario();
			usuario.setLoginusuario("z");
			usuario.setPasswordusuario("z");
			Assert.assertEquals(usuarioService.save(usuario), true);
			Assert.assertNotNull(usuarioService.get(usuario.getLoginusuario()));
			usuario.setPasswordusuario("zz");
			Assert.assertEquals(usuarioService.update(usuario), true);			
			Assert.assertEquals(usuarioService.delete(usuario.getLoginusuario()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Usuario usuario = new Usuario();
			usuario.setLoginusuario("z");
			usuario.setPasswordusuario("z");
			Assert.assertEquals(usuarioService.update(usuario), true);
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
			Assert.assertEquals(usuarioService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
