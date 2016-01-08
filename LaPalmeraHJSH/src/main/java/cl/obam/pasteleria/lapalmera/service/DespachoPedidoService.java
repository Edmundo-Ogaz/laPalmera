package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.DespachoPedidoDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Despachopedido;

@Service
public class DespachoPedidoService {
	
	@Autowired
	private DespachoPedidoDao dao;
	
	public Despachopedido get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Despachopedido> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Despachopedido obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Despachopedido obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Despachopedido> getAllEqBy(Despachopedido despachoPedido) throws DAOException {
		return dao.getAllEqBy(despachoPedido);
	}
	
	public List<Despachopedido> getAllNotEqBy(Despachopedido despachoPedido) throws DAOException {
		return dao.getAllNotEqBy(despachoPedido);
	}
	
	public List<Despachopedido> getAllBeginWithBy(Despachopedido despachoPedido) throws DAOException {
		return dao.getAllBeginWithBy(despachoPedido);
	}
	
	public List<Despachopedido> getAllNotBeginWithBy(Despachopedido despachoPedido) throws DAOException {
		return dao.getAllNotBeginWithBy(despachoPedido);
	}
	
	public List<Despachopedido> getAllEndWithBy(Despachopedido despachoPedido) throws DAOException {
		return dao.getAllEndWithBy(despachoPedido);
	}
	
	public List<Despachopedido> getAllNotEndWithBy(Despachopedido despachoPedido) throws DAOException {
		return dao.getAllNotEndWithBy(despachoPedido);
	}
	
	public List<Despachopedido> getAllContainBy(Despachopedido despachoPedido) throws DAOException {
		return dao.getAllContainBy(despachoPedido);
	}
	
	public List<Despachopedido> getAllNotContainBy(Despachopedido despachoPedido) throws DAOException {
		return dao.getAllNotContainBy(despachoPedido);
	}
	
	public List<Despachopedido> getAllIsNullBy(Despachopedido despachoPedido) throws DAOException {
		return dao.getAllIsNullBy(despachoPedido);
	}
	
	public List<Despachopedido> getAllNotIsNullBy(Despachopedido despachoPedido) throws DAOException {
		return dao.getAllNotIsNullBy(despachoPedido);
	}
}