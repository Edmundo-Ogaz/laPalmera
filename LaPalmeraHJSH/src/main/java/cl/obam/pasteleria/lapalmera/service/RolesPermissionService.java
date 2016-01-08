package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.RolesPermissionDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Rolespermission;

@Service
public class RolesPermissionService {
	
	@Autowired
	private RolesPermissionDao dao;
	
	public Rolespermission get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Rolespermission> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Rolespermission obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Rolespermission obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Rolespermission> getAllEqBy(Rolespermission rolesPermission) throws DAOException {
		return dao.getAllEqBy(rolesPermission);
	}
	
	public List<Rolespermission> getAllNotEqBy(Rolespermission rolesPermission) throws DAOException {
		return dao.getAllNotEqBy(rolesPermission);
	}
	
	public List<Rolespermission> getAllBeginWithBy(Rolespermission rolesPermission) throws DAOException {
		return dao.getAllBeginWithBy(rolesPermission);
	}
	
	public List<Rolespermission> getAllNotBeginWithBy(Rolespermission rolesPermission) throws DAOException {
		return dao.getAllNotBeginWithBy(rolesPermission);
	}
	
	public List<Rolespermission> getAllEndWithBy(Rolespermission rolesPermission) throws DAOException {
		return dao.getAllEndWithBy(rolesPermission);
	}
	
	public List<Rolespermission> getAllNotEndWithBy(Rolespermission rolesPermission) throws DAOException {
		return dao.getAllNotEndWithBy(rolesPermission);
	}
	
	public List<Rolespermission> getAllContainBy(Rolespermission rolesPermission) throws DAOException {
		return dao.getAllContainBy(rolesPermission);
	}
	
	public List<Rolespermission> getAllNotContainBy(Rolespermission rolesPermission) throws DAOException {
		return dao.getAllNotContainBy(rolesPermission);
	}
	
	public List<Rolespermission> getAllIsNullBy(Rolespermission rolesPermission) throws DAOException {
		return dao.getAllIsNullBy(rolesPermission);
	}
	
	public List<Rolespermission> getAllNotIsNullBy(Rolespermission rolesPermission) throws DAOException {
		return dao.getAllNotIsNullBy(rolesPermission);
	}
}