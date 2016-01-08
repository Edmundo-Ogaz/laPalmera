package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.ConfirmacionPedidoDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Confirmacionpedido;

@Service
public class ConfirmacionPedidoService {
	
	@Autowired
	private ConfirmacionPedidoDao dao;
	
	public Confirmacionpedido get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Confirmacionpedido> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Confirmacionpedido obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Confirmacionpedido obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Confirmacionpedido> getAllEqBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		return dao.getAllEqBy(confirmacionPedido);
	}
	
	public List<Confirmacionpedido> getAllNotEqBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		return dao.getAllNotEqBy(confirmacionPedido);
	}
	
	public List<Confirmacionpedido> getAllBeginWithBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		return dao.getAllBeginWithBy(confirmacionPedido);
	}
	
	public List<Confirmacionpedido> getAllNotBeginWithBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		return dao.getAllNotBeginWithBy(confirmacionPedido);
	}
	
	public List<Confirmacionpedido> getAllEndWithBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		return dao.getAllEndWithBy(confirmacionPedido);
	}
	
	public List<Confirmacionpedido> getAllNotEndWithBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		return dao.getAllNotEndWithBy(confirmacionPedido);
	}
	
	public List<Confirmacionpedido> getAllContainBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		return dao.getAllContainBy(confirmacionPedido);
	}
	
	public List<Confirmacionpedido> getAllNotContainBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		return dao.getAllNotContainBy(confirmacionPedido);
	}
	
	public List<Confirmacionpedido> getAllIsNullBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		return dao.getAllIsNullBy(confirmacionPedido);
	}
	
	public List<Confirmacionpedido> getAllNotIsNullBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		return dao.getAllNotIsNullBy(confirmacionPedido);
	}
}