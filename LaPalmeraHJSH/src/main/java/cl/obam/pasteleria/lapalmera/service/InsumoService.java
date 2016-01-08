package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.InsumoDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Insumo;

@Service
public class InsumoService {
	
	@Autowired
	private InsumoDao dao;
	
	public Insumo get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Insumo> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Insumo obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Insumo obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Insumo> getAllEqBy(Insumo insumo) throws DAOException {
		return dao.getAllEqBy(insumo);
	}
	
	public List<Insumo> getAllNotEqBy(Insumo insumo) throws DAOException {
		return dao.getAllNotEqBy(insumo);
	}
	
	public List<Insumo> getAllBeginWithBy(Insumo insumo) throws DAOException {
		return dao.getAllBeginWithBy(insumo);
	}
	
	public List<Insumo> getAllNotBeginWithBy(Insumo insumo) throws DAOException {
		return dao.getAllNotBeginWithBy(insumo);
	}
	
	public List<Insumo> getAllEndWithBy(Insumo insumo) throws DAOException {
		return dao.getAllEndWithBy(insumo);
	}
	
	public List<Insumo> getAllNotEndWithBy(Insumo insumo) throws DAOException {
		return dao.getAllNotEndWithBy(insumo);
	}
	
	public List<Insumo> getAllContainBy(Insumo insumo) throws DAOException {
		return dao.getAllContainBy(insumo);
	}
	
	public List<Insumo> getAllNotContainBy(Insumo insumo) throws DAOException {
		return dao.getAllNotContainBy(insumo);
	}
	
	public List<Insumo> getAllIsNullBy(Insumo insumo) throws DAOException {
		return dao.getAllIsNullBy(insumo);
	}
	
	public List<Insumo> getAllNotIsNullBy(Insumo insumo) throws DAOException {
		return dao.getAllNotIsNullBy(insumo);
	}
}