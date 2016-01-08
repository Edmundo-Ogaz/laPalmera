package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.FamiliaDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Familia;

@Service
public class FamiliaService {
	
	@Autowired
	private FamiliaDao dao;
	
	public Familia get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Familia> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Familia obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Familia obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Familia> getAllEqBy(Familia familia) throws DAOException {
		return dao.getAllEqBy(familia);
	}
	
	public List<Familia> getAllNotEqBy(Familia familia) throws DAOException {
		return dao.getAllNotEqBy(familia);
	}
	
	public List<Familia> getAllBeginWithBy(Familia familia) throws DAOException {
		return dao.getAllBeginWithBy(familia);
	}
	
	public List<Familia> getAllNotBeginWithBy(Familia familia) throws DAOException {
		return dao.getAllNotBeginWithBy(familia);
	}
	
	public List<Familia> getAllEndWithBy(Familia familia) throws DAOException {
		return dao.getAllEndWithBy(familia);
	}
	
	public List<Familia> getAllNotEndWithBy(Familia familia) throws DAOException {
		return dao.getAllNotEndWithBy(familia);
	}
	
	public List<Familia> getAllContainBy(Familia familia) throws DAOException {
		return dao.getAllContainBy(familia);
	}
	
	public List<Familia> getAllNotContainBy(Familia familia) throws DAOException {
		return dao.getAllNotContainBy(familia);
	}
	
	public List<Familia> getAllIsNullBy(Familia familia) throws DAOException {
		return dao.getAllIsNullBy(familia);
	}
	
	public List<Familia> getAllNotIsNullBy(Familia familia) throws DAOException {
		return dao.getAllNotIsNullBy(familia);
	}
}