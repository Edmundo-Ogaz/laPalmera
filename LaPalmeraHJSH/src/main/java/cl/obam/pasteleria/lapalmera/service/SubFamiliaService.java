package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.SubFamiliaDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Subfamilia;

@Service
public class SubFamiliaService {
	
	@Autowired
	private SubFamiliaDao dao;
	
	public Subfamilia get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Subfamilia> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Subfamilia obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Subfamilia obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Subfamilia> getAllEqBy(Subfamilia area) throws DAOException {
		return dao.getAllEqBy(area);
	}
	
	public List<Subfamilia> getAllNotEqBy(Subfamilia area) throws DAOException {
		return dao.getAllNotEqBy(area);
	}
	
	public List<Subfamilia> getAllBeginWithBy(Subfamilia area) throws DAOException {
		return dao.getAllBeginWithBy(area);
	}
	
	public List<Subfamilia> getAllNotBeginWithBy(Subfamilia area) throws DAOException {
		return dao.getAllNotBeginWithBy(area);
	}
	
	public List<Subfamilia> getAllEndWithBy(Subfamilia area) throws DAOException {
		return dao.getAllEndWithBy(area);
	}
	
	public List<Subfamilia> getAllNotEndWithBy(Subfamilia area) throws DAOException {
		return dao.getAllNotEndWithBy(area);
	}
	
	public List<Subfamilia> getAllContainBy(Subfamilia area) throws DAOException {
		return dao.getAllContainBy(area);
	}
	
	public List<Subfamilia> getAllNotContainBy(Subfamilia area) throws DAOException {
		return dao.getAllNotContainBy(area);
	}
	
	public List<Subfamilia> getAllIsNullBy(Subfamilia area) throws DAOException {
		return dao.getAllIsNullBy(area);
	}
	
	public List<Subfamilia> getAllNotIsNullBy(Subfamilia area) throws DAOException {
		return dao.getAllNotIsNullBy(area);
	}
}