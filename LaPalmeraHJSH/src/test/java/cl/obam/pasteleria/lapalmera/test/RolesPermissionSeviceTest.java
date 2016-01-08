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
import cl.obam.pasteleria.lapalmera.model.Rolespermission;
import cl.obam.pasteleria.lapalmera.service.RolesPermissionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class RolesPermissionSeviceTest {
	
	@Autowired
	private RolesPermissionService rolesPermissionService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(rolesPermissionService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Rolespermission rolesPermission = new Rolespermission();
			Assert.assertNotNull(rolesPermissionService.getAllEqBy(rolesPermission));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Rolespermission rolesPermission = new Rolespermission();
			Assert.assertNotNull(rolesPermissionService.getAllNotEqBy(rolesPermission));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Rolespermission rolesPermission = new Rolespermission();
			Assert.assertNotNull(rolesPermissionService.getAllBeginWithBy(rolesPermission));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Rolespermission rolesPermission = new Rolespermission();
			Assert.assertNotNull(rolesPermissionService.getAllNotBeginWithBy(rolesPermission));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Rolespermission rolesPermission = new Rolespermission();
			Assert.assertNotNull(rolesPermissionService.getAllEndWithBy(rolesPermission));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Rolespermission> list = null;
		try {
			Rolespermission rolesPermission = new Rolespermission();
			Assert.assertNotNull(rolesPermissionService.getAllNotEndWithBy(rolesPermission));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Rolespermission rolesPermission = new Rolespermission();
			Assert.assertNotNull(rolesPermissionService.getAllContainBy(rolesPermission));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Rolespermission rolesPermission = new Rolespermission();
			Assert.assertNotNull(rolesPermissionService.getAllNotContainBy(rolesPermission));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Rolespermission rolesPermission = new Rolespermission();
			Assert.assertNotNull(rolesPermissionService.getAllIsNullBy(rolesPermission));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Rolespermission rolesPermission = new Rolespermission();
			Assert.assertNotNull(rolesPermissionService.getAllNotIsNullBy(rolesPermission));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Rolespermission rolesPermission = new Rolespermission();
			rolesPermission.setId(1);
			rolesPermission.setRoleName("z");
			Assert.assertEquals(rolesPermissionService.save(rolesPermission), true);
			Assert.assertNotNull(rolesPermissionService.get(Integer.toString(rolesPermission.getId())));
			rolesPermission.setRoleName("zz");
			Assert.assertEquals(rolesPermissionService.update(rolesPermission), true);			
			Assert.assertEquals(rolesPermissionService.delete(Integer.toString(rolesPermission.getId())), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Rolespermission rolesPermission = new Rolespermission();
			rolesPermission.setId(1);
			rolesPermission.setRoleName("zz");
			Assert.assertEquals(rolesPermissionService.update(rolesPermission), true);
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
			Assert.assertEquals(rolesPermissionService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
