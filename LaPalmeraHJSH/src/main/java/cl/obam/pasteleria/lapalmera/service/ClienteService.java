package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.ClienteDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Cliente;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.ClienteVO;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteDao dao;
	
	public ClienteVO get(String rut) throws DAOException {
		return Mapper.from(dao.get(rut));
	}
	
	public List<Cliente> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Cliente obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Cliente obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Cliente> getAllEqBy(Cliente area) throws DAOException {
		return dao.getAllEqBy(area);
	}
	
	public List<Cliente> getAllNotEqBy(Cliente area) throws DAOException {
		return dao.getAllNotEqBy(area);
	}
	
	public List<Cliente> getAllBeginWithBy(Cliente area) throws DAOException {
		return dao.getAllBeginWithBy(area);
	}
	
	public List<Cliente> getAllNotBeginWithBy(Cliente area) throws DAOException {
		return dao.getAllNotBeginWithBy(area);
	}
	
	public List<Cliente> getAllEndWithBy(Cliente area) throws DAOException {
		return dao.getAllEndWithBy(area);
	}
	
	public List<Cliente> getAllNotEndWithBy(Cliente area) throws DAOException {
		return dao.getAllNotEndWithBy(area);
	}
	
	public List<Cliente> getAllContainBy(Cliente area) throws DAOException {
		return dao.getAllContainBy(area);
	}
	
	public List<Cliente> getAllNotContainBy(Cliente area) throws DAOException {
		return dao.getAllNotContainBy(area);
	}
	
	public List<Cliente> getAllIsNullBy(Cliente area) throws DAOException {
		return dao.getAllIsNullBy(area);
	}
	
	public List<Cliente> getAllNotIsNullBy(Cliente area) throws DAOException {
		return dao.getAllNotIsNullBy(area);
	}
}