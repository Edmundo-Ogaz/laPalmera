package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.TipoClienteDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Tipocliente;

@Service
public class TipoClienteService {
	
	@Autowired
	private TipoClienteDao dao;
	
	public Tipocliente get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Tipocliente> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Tipocliente obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Tipocliente obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Tipocliente> getAllEqBy(Tipocliente region) throws DAOException {
		return dao.getAllEqBy(region);
	}
	
	public List<Tipocliente> getAllNotEqBy(Tipocliente region) throws DAOException {
		return dao.getAllNotEqBy(region);
	}
	
	public List<Tipocliente> getAllBeginWithBy(Tipocliente region) throws DAOException {
		return dao.getAllBeginWithBy(region);
	}
	
	public List<Tipocliente> getAllNotBeginWithBy(Tipocliente region) throws DAOException {
		return dao.getAllNotBeginWithBy(region);
	}
	
	public List<Tipocliente> getAllEndWithBy(Tipocliente region) throws DAOException {
		return dao.getAllEndWithBy(region);
	}
	
	public List<Tipocliente> getAllNotEndWithBy(Tipocliente region) throws DAOException {
		return dao.getAllNotEndWithBy(region);
	}
	
	public List<Tipocliente> getAllContainBy(Tipocliente region) throws DAOException {
		return dao.getAllContainBy(region);
	}
	
	public List<Tipocliente> getAllNotContainBy(Tipocliente region) throws DAOException {
		return dao.getAllNotContainBy(region);
	}
	
	public List<Tipocliente> getAllIsNullBy(Tipocliente region) throws DAOException {
		return dao.getAllIsNullBy(region);
	}
	
	public List<Tipocliente> getAllNotIsNullBy(Tipocliente region) throws DAOException {
		return dao.getAllNotIsNullBy(region);
	}
}