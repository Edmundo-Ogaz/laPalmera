package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.ProgramarProduccionDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Programaproduccion;
import cl.obam.pasteleria.lapalmera.view.ProgramaProduccionVO;

@Service
public class ProgramarProduccionService {
	
	@Autowired
	private ProgramarProduccionDao dao;
	
	public ProgramaProduccionVO get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Programaproduccion> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Programaproduccion obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Programaproduccion obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Programaproduccion> getAllEqBy(Programaproduccion programaProduccion) throws DAOException {
		return dao.getAllEqBy(programaProduccion);
	}
	
	public List<Programaproduccion> getAllNotEqBy(Programaproduccion programaProduccion) throws DAOException {
		return dao.getAllNotEqBy(programaProduccion);
	}
	
	public List<Programaproduccion> getAllBeginWithBy(Programaproduccion programaProduccion) throws DAOException {
		return dao.getAllBeginWithBy(programaProduccion);
	}
	
	public List<Programaproduccion> getAllNotBeginWithBy(Programaproduccion programaProduccion) throws DAOException {
		return dao.getAllNotBeginWithBy(programaProduccion);
	}
	
	public List<Programaproduccion> getAllEndWithBy(Programaproduccion programaProduccion) throws DAOException {
		return dao.getAllEndWithBy(programaProduccion);
	}
	
	public List<Programaproduccion> getAllNotEndWithBy(Programaproduccion programaProduccion) throws DAOException {
		return dao.getAllNotEndWithBy(programaProduccion);
	}
	
	public List<Programaproduccion> getAllContainBy(Programaproduccion programaProduccion) throws DAOException {
		return dao.getAllContainBy(programaProduccion);
	}
	
	public List<Programaproduccion> getAllNotContainBy(Programaproduccion programaProduccion) throws DAOException {
		return dao.getAllNotContainBy(programaProduccion);
	}
	
	public List<Programaproduccion> getAllIsNullBy(Programaproduccion programaProduccion) throws DAOException {
		return dao.getAllIsNullBy(programaProduccion);
	}
	
	public List<Programaproduccion> getAllNotIsNullBy(Programaproduccion programaProduccion) throws DAOException {
		return dao.getAllNotIsNullBy(programaProduccion);
	}
}