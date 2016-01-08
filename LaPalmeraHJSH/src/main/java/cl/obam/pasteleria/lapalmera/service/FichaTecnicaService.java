package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.FichaTecnicaDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Fichatecnica;

@Service
public class FichaTecnicaService {
	
	@Autowired
	private FichaTecnicaDao dao;
	
	public Fichatecnica get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Fichatecnica> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Fichatecnica obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Fichatecnica obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Fichatecnica> getAllEqBy(Fichatecnica fichaTecnica) throws DAOException {
		return dao.getAllEqBy(fichaTecnica);
	}
	
	public List<Fichatecnica> getAllNotEqBy(Fichatecnica fichaTecnica) throws DAOException {
		return dao.getAllNotEqBy(fichaTecnica);
	}
	
	public List<Fichatecnica> getAllBeginWithBy(Fichatecnica fichaTecnica) throws DAOException {
		return dao.getAllBeginWithBy(fichaTecnica);
	}
	
	public List<Fichatecnica> getAllNotBeginWithBy(Fichatecnica fichaTecnica) throws DAOException {
		return dao.getAllNotBeginWithBy(fichaTecnica);
	}
	
	public List<Fichatecnica> getAllEndWithBy(Fichatecnica fichaTecnica) throws DAOException {
		return dao.getAllEndWithBy(fichaTecnica);
	}
	
	public List<Fichatecnica> getAllNotEndWithBy(Fichatecnica fichaTecnica) throws DAOException {
		return dao.getAllNotEndWithBy(fichaTecnica);
	}
	
	public List<Fichatecnica> getAllContainBy(Fichatecnica fichaTecnica) throws DAOException {
		return dao.getAllContainBy(fichaTecnica);
	}
	
	public List<Fichatecnica> getAllNotContainBy(Fichatecnica fichaTecnica) throws DAOException {
		return dao.getAllNotContainBy(fichaTecnica);
	}
	
	public List<Fichatecnica> getAllIsNullBy(Fichatecnica fichaTecnica) throws DAOException {
		return dao.getAllIsNullBy(fichaTecnica);
	}
	
	public List<Fichatecnica> getAllNotIsNullBy(Fichatecnica fichaTecnica) throws DAOException {
		return dao.getAllNotIsNullBy(fichaTecnica);
	}
}