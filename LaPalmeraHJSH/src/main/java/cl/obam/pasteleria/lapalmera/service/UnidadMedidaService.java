package cl.obam.pasteleria.lapalmera.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.UnidadMedidaDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Unidadmedida;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.UnidadMedidaVO;

@Service
public class UnidadMedidaService {
	
	@Autowired
	private UnidadMedidaDao dao;
	
	public UnidadMedidaVO get(String codigo) throws DAOException {
		return Mapper.from(dao.get(codigo));
	}
	
	public List<UnidadMedidaVO> getAll() throws DAOException {
		List<UnidadMedidaVO> list = new LinkedList<UnidadMedidaVO>();
		for (Unidadmedida unidadMedida : dao.getAll()) {
			list.add(Mapper.from(unidadMedida));
		}
		return list;
	}
	
	public boolean save(Unidadmedida obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Unidadmedida obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<UnidadMedidaVO> getAllEqBy(UnidadMedidaVO unidadMedidaVO) throws DAOException {
		List<UnidadMedidaVO> unidadMedidasVO = new LinkedList<UnidadMedidaVO>();
		for(Unidadmedida unidadMedida : dao.getAllEqBy(Mapper.from(unidadMedidaVO))) {
			unidadMedidasVO.add(Mapper.from(unidadMedida));
		}
		return unidadMedidasVO;
	}
	
	public List<Unidadmedida> getAllNotEqBy(Unidadmedida unidadMedida) throws DAOException {
		return dao.getAllNotEqBy(unidadMedida);
	}
	
	public List<Unidadmedida> getAllBeginWithBy(Unidadmedida unidadMedida) throws DAOException {
		return dao.getAllBeginWithBy(unidadMedida);
	}
	
	public List<Unidadmedida> getAllNotBeginWithBy(Unidadmedida unidadMedida) throws DAOException {
		return dao.getAllNotBeginWithBy(unidadMedida);
	}
	
	public List<Unidadmedida> getAllEndWithBy(Unidadmedida unidadMedida) throws DAOException {
		return dao.getAllEndWithBy(unidadMedida);
	}
	
	public List<Unidadmedida> getAllNotEndWithBy(Unidadmedida unidadMedida) throws DAOException {
		return dao.getAllNotEndWithBy(unidadMedida);
	}
	
	public List<Unidadmedida> getAllContainBy(Unidadmedida unidadMedida) throws DAOException {
		return dao.getAllContainBy(unidadMedida);
	}
	
	public List<Unidadmedida> getAllNotContainBy(Unidadmedida unidadMedida) throws DAOException {
		return dao.getAllNotContainBy(unidadMedida);
	}
	
	public List<Unidadmedida> getAllIsNullBy(Unidadmedida unidadMedida) throws DAOException {
		return dao.getAllIsNullBy(unidadMedida);
	}
	
	public List<Unidadmedida> getAllNotIsNullBy(Unidadmedida unidadMedida) throws DAOException {
		return dao.getAllNotIsNullBy(unidadMedida);
	}
}