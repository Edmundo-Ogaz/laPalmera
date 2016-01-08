package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.DetallePedidoDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Detallepedido;

@Service
public class DetallePedidoService {
	
	@Autowired
	private DetallePedidoDao dao;
	
	public Detallepedido get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Detallepedido> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Detallepedido obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Detallepedido obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Detallepedido> getAllEqBy(Detallepedido detallePedido) throws DAOException {
		return dao.getAllEqBy(detallePedido);
	}
	
	public List<Detallepedido> getAllNotEqBy(Detallepedido detallePedido) throws DAOException {
		return dao.getAllNotEqBy(detallePedido);
	}
	
	public List<Detallepedido> getAllBeginWithBy(Detallepedido detallePedido) throws DAOException {
		return dao.getAllBeginWithBy(detallePedido);
	}
	
	public List<Detallepedido> getAllNotBeginWithBy(Detallepedido detallePedido) throws DAOException {
		return dao.getAllNotBeginWithBy(detallePedido);
	}
	
	public List<Detallepedido> getAllEndWithBy(Detallepedido detallePedido) throws DAOException {
		return dao.getAllEndWithBy(detallePedido);
	}
	
	public List<Detallepedido> getAllNotEndWithBy(Detallepedido detallePedido) throws DAOException {
		return dao.getAllNotEndWithBy(detallePedido);
	}
	
	public List<Detallepedido> getAllContainBy(Detallepedido detallePedido) throws DAOException {
		return dao.getAllContainBy(detallePedido);
	}
	
	public List<Detallepedido> getAllNotContainBy(Detallepedido detallePedido) throws DAOException {
		return dao.getAllNotContainBy(detallePedido);
	}
	
	public List<Detallepedido> getAllIsNullBy(Detallepedido detallePedido) throws DAOException {
		return dao.getAllIsNullBy(detallePedido);
	}
	
	public List<Detallepedido> getAllNotIsNullBy(Detallepedido detallePedido) throws DAOException {
		return dao.getAllNotIsNullBy(detallePedido);
	}
}