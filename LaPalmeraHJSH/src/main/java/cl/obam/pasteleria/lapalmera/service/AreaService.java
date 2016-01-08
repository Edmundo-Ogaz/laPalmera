package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.AreaDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Area;

@Service
public class AreaService {
	
	@Autowired
	private AreaDao dao;
	
	public Area get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Area> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Area obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Area obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Area> getAllEqBy(Area area) throws DAOException {
		return dao.getAllEqBy(area);
	}
	
	public List<Area> getAllNotEqBy(Area area) throws DAOException {
		return dao.getAllNotEqBy(area);
	}
	
	public List<Area> getAllBeginWithBy(Area area) throws DAOException {
		return dao.getAllBeginWithBy(area);
	}
	
	public List<Area> getAllNotBeginWithBy(Area area) throws DAOException {
		return dao.getAllNotBeginWithBy(area);
	}
	
	public List<Area> getAllEndWithBy(Area area) throws DAOException {
		return dao.getAllEndWithBy(area);
	}
	
	public List<Area> getAllNotEndWithBy(Area area) throws DAOException {
		return dao.getAllNotEndWithBy(area);
	}
	
	public List<Area> getAllContainBy(Area area) throws DAOException {
		return dao.getAllContainBy(area);
	}
	
	public List<Area> getAllNotContainBy(Area area) throws DAOException {
		return dao.getAllNotContainBy(area);
	}
	
	public List<Area> getAllIsNullBy(Area area) throws DAOException {
		return dao.getAllIsNullBy(area);
	}
	
	public List<Area> getAllNotIsNullBy(Area area) throws DAOException {
		return dao.getAllNotIsNullBy(area);
	}
}