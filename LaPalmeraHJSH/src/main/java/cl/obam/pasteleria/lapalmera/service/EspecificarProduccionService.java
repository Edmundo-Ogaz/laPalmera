package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.EspecificarProduccionDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Especificarproduccion;

@Service
public class EspecificarProduccionService {
	
	@Autowired
	private EspecificarProduccionDao dao;
	
	public Especificarproduccion get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Especificarproduccion> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Especificarproduccion obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Especificarproduccion obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Especificarproduccion> getAllEqBy(Especificarproduccion especificarProduccion) throws DAOException {
		return dao.getAllEqBy(especificarProduccion);
	}
	
	public List<Especificarproduccion> getAllNotEqBy(Especificarproduccion especificarProduccion) throws DAOException {
		return dao.getAllNotEqBy(especificarProduccion);
	}
	
	public List<Especificarproduccion> getAllBeginWithBy(Especificarproduccion especificarProduccion) throws DAOException {
		return dao.getAllBeginWithBy(especificarProduccion);
	}
	
	public List<Especificarproduccion> getAllNotBeginWithBy(Especificarproduccion especificarProduccion) throws DAOException {
		return dao.getAllNotBeginWithBy(especificarProduccion);
	}
	
	public List<Especificarproduccion> getAllEndWithBy(Especificarproduccion especificarProduccion) throws DAOException {
		return dao.getAllEndWithBy(especificarProduccion);
	}
	
	public List<Especificarproduccion> getAllNotEndWithBy(Especificarproduccion especificarProduccion) throws DAOException {
		return dao.getAllNotEndWithBy(especificarProduccion);
	}
	
	public List<Especificarproduccion> getAllContainBy(Especificarproduccion especificarProduccion) throws DAOException {
		return dao.getAllContainBy(especificarProduccion);
	}
	
	public List<Especificarproduccion> getAllNotContainBy(Especificarproduccion especificarProduccion) throws DAOException {
		return dao.getAllNotContainBy(especificarProduccion);
	}
	
	public List<Especificarproduccion> getAllIsNullBy(Especificarproduccion especificarProduccion) throws DAOException {
		return dao.getAllIsNullBy(especificarProduccion);
	}
	
	public List<Especificarproduccion> getAllNotIsNullBy(Especificarproduccion especificarProduccion) throws DAOException {
		return dao.getAllNotIsNullBy(especificarProduccion);
	}
}