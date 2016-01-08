package cl.obam.pasteleria.lapalmera.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.ComunaDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Comuna;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.ComunaVO;

@Service
public class ComunaService {
	
	@Autowired
	private ComunaDao dao;
	
	public Comuna get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<ComunaVO> getAll() throws DAOException {
		List<ComunaVO> comunasVO = new LinkedList<ComunaVO>();
		for(Comuna comuna : dao.getAll()) {
			comunasVO.add(Mapper.from(comuna));
		}
		return comunasVO;
	}
	
	public boolean save(Comuna obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Comuna obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Comuna> getAllEqBy(Comuna comuna) throws DAOException {
		return dao.getAllEqBy(comuna);
	}
	
	public List<Comuna> getAllNotEqBy(Comuna comuna) throws DAOException {
		return dao.getAllNotEqBy(comuna);
	}
	
	public List<Comuna> getAllBeginWithBy(Comuna comuna) throws DAOException {
		return dao.getAllBeginWithBy(comuna);
	}
	
	public List<Comuna> getAllNotBeginWithBy(Comuna comuna) throws DAOException {
		return dao.getAllNotBeginWithBy(comuna);
	}
	
	public List<Comuna> getAllEndWithBy(Comuna comuna) throws DAOException {
		return dao.getAllEndWithBy(comuna);
	}
	
	public List<Comuna> getAllNotEndWithBy(Comuna comuna) throws DAOException {
		return dao.getAllNotEndWithBy(comuna);
	}
	
	public List<Comuna> getAllContainBy(Comuna comuna) throws DAOException {
		return dao.getAllContainBy(comuna);
	}
	
	public List<Comuna> getAllNotContainBy(Comuna comuna) throws DAOException {
		return dao.getAllNotContainBy(comuna);
	}
	
	public List<Comuna> getAllIsNullBy(Comuna comuna) throws DAOException {
		return dao.getAllIsNullBy(comuna);
	}
	
	public List<Comuna> getAllNotIsNullBy(Comuna comuna) throws DAOException {
		return dao.getAllNotIsNullBy(comuna);
	}
}