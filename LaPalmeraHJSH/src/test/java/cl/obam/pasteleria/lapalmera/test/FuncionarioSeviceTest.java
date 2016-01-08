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
import cl.obam.pasteleria.lapalmera.model.Funcionario;
import cl.obam.pasteleria.lapalmera.service.FuncionarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class FuncionarioSeviceTest {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(funcionarioService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Funcionario funcionario = new Funcionario();
			Assert.assertNotNull(funcionarioService.getAllEqBy(funcionario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Funcionario funcionario = new Funcionario();
			Assert.assertNotNull(funcionarioService.getAllNotEqBy(funcionario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Funcionario funcionario = new Funcionario();
			Assert.assertNotNull(funcionarioService.getAllBeginWithBy(funcionario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Funcionario funcionario = new Funcionario();
			Assert.assertNotNull(funcionarioService.getAllNotBeginWithBy(funcionario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Funcionario funcionario = new Funcionario();
			Assert.assertNotNull(funcionarioService.getAllEndWithBy(funcionario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Funcionario> list = null;
		try {
			Funcionario funcionario = new Funcionario();
			Assert.assertNotNull(funcionarioService.getAllNotEndWithBy(funcionario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Funcionario funcionario = new Funcionario();
			Assert.assertNotNull(funcionarioService.getAllContainBy(funcionario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Funcionario funcionario = new Funcionario();
			Assert.assertNotNull(funcionarioService.getAllNotContainBy(funcionario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Funcionario funcionario = new Funcionario();
			Assert.assertNotNull(funcionarioService.getAllIsNullBy(funcionario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Funcionario funcionario = new Funcionario();
			Assert.assertNotNull(funcionarioService.getAllNotIsNullBy(funcionario));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Funcionario funcionario = new Funcionario();
			funcionario.setRutfuncionario("z");
			funcionario.setNombre("z");
			Assert.assertEquals(funcionarioService.save(funcionario), true);
			Assert.assertNotNull(funcionarioService.get(funcionario.getRutfuncionario()));
			funcionario.setNombre("zz");
			Assert.assertEquals(funcionarioService.update(funcionario), true);			
			Assert.assertEquals(funcionarioService.delete(funcionario.getRutfuncionario()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Funcionario funcionario = new Funcionario();
			funcionario.setRutfuncionario("z");
			funcionario.setNombre("zz");
			Assert.assertEquals(funcionarioService.update(funcionario), true);
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
			Assert.assertEquals(funcionarioService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
