package cl.obam.pasteleria.lapalmera.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.BodegaDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Bodega;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.BodegaVO;

@Service
public class BodegaService {
	
	@Autowired
	private BodegaDao dao;
	
	public BodegaVO get(String codigo) throws DAOException {
		return Mapper.from(dao.get(codigo));
	}
	
	public List<BodegaVO> getAll() throws DAOException {		
		List<BodegaVO> list = new LinkedList<BodegaVO>();
		for (Bodega bodega : dao.getAll()) {
			list.add(Mapper.from(bodega));
		}
		return list;
	}
	
	public boolean save(Bodega obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Bodega obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Bodega> getAllEqBy(Bodega bodega) throws DAOException {
		return dao.getAllEqBy(bodega);
	}
	
	public List<Bodega> getAllNotEqBy(Bodega bodega) throws DAOException {
		return dao.getAllNotEqBy(bodega);
	}
	
	public List<Bodega> getAllBeginWithBy(Bodega bodega) throws DAOException {
		return dao.getAllBeginWithBy(bodega);
	}
	
	public List<Bodega> getAllNotBeginWithBy(Bodega bodega) throws DAOException {
		return dao.getAllNotBeginWithBy(bodega);
	}
	
	public List<Bodega> getAllEndWithBy(Bodega bodega) throws DAOException {
		return dao.getAllEndWithBy(bodega);
	}
	
	public List<Bodega> getAllNotEndWithBy(Bodega bodega) throws DAOException {
		return dao.getAllNotEndWithBy(bodega);
	}
	
	public List<Bodega> getAllContainBy(Bodega bodega) throws DAOException {
		return dao.getAllContainBy(bodega);
	}
	
	public List<Bodega> getAllNotContainBy(Bodega bodega) throws DAOException {
		return dao.getAllNotContainBy(bodega);
	}
	
	public List<Bodega> getAllIsNullBy(Bodega bodega) throws DAOException {
		return dao.getAllIsNullBy(bodega);
	}
	
	public List<Bodega> getAllNotIsNullBy(Bodega bodega) throws DAOException {
		return dao.getAllNotIsNullBy(bodega);
	}
}