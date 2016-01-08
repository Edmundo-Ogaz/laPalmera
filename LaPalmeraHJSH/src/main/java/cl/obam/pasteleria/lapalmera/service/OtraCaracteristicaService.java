package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.OtraCaracteristicaDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Otracaracteristica;

@Service
public class OtraCaracteristicaService {
	
	@Autowired
	private OtraCaracteristicaDao dao;
	
	public Otracaracteristica get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Otracaracteristica> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Otracaracteristica obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Otracaracteristica obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Otracaracteristica> getAllEqBy(Otracaracteristica otraCaracteristica) throws DAOException {
		return dao.getAllEqBy(otraCaracteristica);
	}
	
	public List<Otracaracteristica> getAllNotEqBy(Otracaracteristica otraCaracteristica) throws DAOException {
		return dao.getAllNotEqBy(otraCaracteristica);
	}
	
	public List<Otracaracteristica> getAllBeginWithBy(Otracaracteristica otraCaracteristica) throws DAOException {
		return dao.getAllBeginWithBy(otraCaracteristica);
	}
	
	public List<Otracaracteristica> getAllNotBeginWithBy(Otracaracteristica otraCaracteristica) throws DAOException {
		return dao.getAllNotBeginWithBy(otraCaracteristica);
	}
	
	public List<Otracaracteristica> getAllEndWithBy(Otracaracteristica otraCaracteristica) throws DAOException {
		return dao.getAllEndWithBy(otraCaracteristica);
	}
	
	public List<Otracaracteristica> getAllNotEndWithBy(Otracaracteristica otraCaracteristica) throws DAOException {
		return dao.getAllNotEndWithBy(otraCaracteristica);
	}
	
	public List<Otracaracteristica> getAllContainBy(Otracaracteristica otraCaracteristica) throws DAOException {
		return dao.getAllContainBy(otraCaracteristica);
	}
	
	public List<Otracaracteristica> getAllNotContainBy(Otracaracteristica otraCaracteristica) throws DAOException {
		return dao.getAllNotContainBy(otraCaracteristica);
	}
	
	public List<Otracaracteristica> getAllIsNullBy(Otracaracteristica otraCaracteristica) throws DAOException {
		return dao.getAllIsNullBy(otraCaracteristica);
	}
	
	public List<Otracaracteristica> getAllNotIsNullBy(Otracaracteristica otraCaracteristica) throws DAOException {
		return dao.getAllNotIsNullBy(otraCaracteristica);
	}
}