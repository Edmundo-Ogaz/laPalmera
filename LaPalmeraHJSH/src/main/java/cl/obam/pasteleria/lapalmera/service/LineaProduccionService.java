package cl.obam.pasteleria.lapalmera.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.LineaProduccionDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Lineaproduccion;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.LineaProduccionVO;

@Service
public class LineaProduccionService {
	
	@Autowired
	private LineaProduccionDao dao;
	
	public Lineaproduccion get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<LineaProduccionVO> getAll() throws DAOException {
		List<LineaProduccionVO> list = new LinkedList<LineaProduccionVO>();
		for (Lineaproduccion lineaProduccion : dao.getAll()) {
			list.add(Mapper.from(lineaProduccion));
		}
		return list;
	}
	
	public boolean save(Lineaproduccion obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Lineaproduccion obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Lineaproduccion> getAllEqBy(Lineaproduccion lineaProduccion) throws DAOException {
		return dao.getAllEqBy(lineaProduccion);
	}
	
	public List<Lineaproduccion> getAllNotEqBy(Lineaproduccion lineaProduccion) throws DAOException {
		return dao.getAllNotEqBy(lineaProduccion);
	}
	
	public List<Lineaproduccion> getAllBeginWithBy(Lineaproduccion lineaProduccion) throws DAOException {
		return dao.getAllBeginWithBy(lineaProduccion);
	}
	
	public List<Lineaproduccion> getAllNotBeginWithBy(Lineaproduccion lineaProduccion) throws DAOException {
		return dao.getAllNotBeginWithBy(lineaProduccion);
	}
	
	public List<Lineaproduccion> getAllEndWithBy(Lineaproduccion lineaProduccion) throws DAOException {
		return dao.getAllEndWithBy(lineaProduccion);
	}
	
	public List<Lineaproduccion> getAllNotEndWithBy(Lineaproduccion lineaProduccion) throws DAOException {
		return dao.getAllNotEndWithBy(lineaProduccion);
	}
	
	public List<Lineaproduccion> getAllContainBy(Lineaproduccion lineaProduccion) throws DAOException {
		return dao.getAllContainBy(lineaProduccion);
	}
	
	public List<Lineaproduccion> getAllNotContainBy(Lineaproduccion lineaProduccion) throws DAOException {
		return dao.getAllNotContainBy(lineaProduccion);
	}
	
	public List<Lineaproduccion> getAllIsNullBy(Lineaproduccion lineaProduccion) throws DAOException {
		return dao.getAllIsNullBy(lineaProduccion);
	}
	
	public List<Lineaproduccion> getAllNotIsNullBy(Lineaproduccion lineaProduccion) throws DAOException {
		return dao.getAllNotIsNullBy(lineaProduccion);
	}
}