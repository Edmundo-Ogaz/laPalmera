package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.CargoDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Cargo;

@Service
public class CargoService {
	
	@Autowired
	private CargoDao dao;
	
	public Cargo get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Cargo> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Cargo obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Cargo obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Cargo> getAllEqBy(Cargo cargo) throws DAOException {
		return dao.getAllEqBy(cargo);
	}
	
	public List<Cargo> getAllNotEqBy(Cargo cargo) throws DAOException {
		return dao.getAllNotEqBy(cargo);
	}
	
	public List<Cargo> getAllBeginWithBy(Cargo cargo) throws DAOException {
		return dao.getAllBeginWithBy(cargo);
	}
	
	public List<Cargo> getAllNotBeginWithBy(Cargo cargo) throws DAOException {
		return dao.getAllNotBeginWithBy(cargo);
	}
	
	public List<Cargo> getAllEndWithBy(Cargo cargo) throws DAOException {
		return dao.getAllEndWithBy(cargo);
	}
	
	public List<Cargo> getAllNotEndWithBy(Cargo cargo) throws DAOException {
		return dao.getAllNotEndWithBy(cargo);
	}
	
	public List<Cargo> getAllContainBy(Cargo cargo) throws DAOException {
		return dao.getAllContainBy(cargo);
	}
	
	public List<Cargo> getAllNotContainBy(Cargo cargo) throws DAOException {
		return dao.getAllNotContainBy(cargo);
	}
	
	public List<Cargo> getAllIsNullBy(Cargo cargo) throws DAOException {
		return dao.getAllIsNullBy(cargo);
	}
	
	public List<Cargo> getAllNotIsNullBy(Cargo cargo) throws DAOException {
		return dao.getAllNotIsNullBy(cargo);
	}
}