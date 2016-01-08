package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.GrupoDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Grupo;

@Service
public class GrupoService {
	
	@Autowired
	private GrupoDao dao;
	
	public Grupo get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Grupo> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Grupo obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Grupo obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Grupo> getAllEqBy(Grupo grupo) throws DAOException {
		return dao.getAllEqBy(grupo);
	}
	
	public List<Grupo> getAllNotEqBy(Grupo grupo) throws DAOException {
		return dao.getAllNotEqBy(grupo);
	}
	
	public List<Grupo> getAllBeginWithBy(Grupo grupo) throws DAOException {
		return dao.getAllBeginWithBy(grupo);
	}
	
	public List<Grupo> getAllNotBeginWithBy(Grupo grupo) throws DAOException {
		return dao.getAllNotBeginWithBy(grupo);
	}
	
	public List<Grupo> getAllEndWithBy(Grupo grupo) throws DAOException {
		return dao.getAllEndWithBy(grupo);
	}
	
	public List<Grupo> getAllNotEndWithBy(Grupo grupo) throws DAOException {
		return dao.getAllNotEndWithBy(grupo);
	}
	
	public List<Grupo> getAllContainBy(Grupo grupo) throws DAOException {
		return dao.getAllContainBy(grupo);
	}
	
	public List<Grupo> getAllNotContainBy(Grupo grupo) throws DAOException {
		return dao.getAllNotContainBy(grupo);
	}
	
	public List<Grupo> getAllIsNullBy(Grupo grupo) throws DAOException {
		return dao.getAllIsNullBy(grupo);
	}
	
	public List<Grupo> getAllNotIsNullBy(Grupo grupo) throws DAOException {
		return dao.getAllNotIsNullBy(grupo);
	}
}