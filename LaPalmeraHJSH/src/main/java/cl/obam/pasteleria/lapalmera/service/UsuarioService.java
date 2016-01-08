package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.UsuarioDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Usuario;

@Service
public class UsuarioService {
	
	private static final Logger LOG = Logger.getLogger(UsuarioService.class);
	
	@Autowired
	private UsuarioDao dao;
	
	public Usuario get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Usuario> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Usuario obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Usuario obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Usuario> getAllEqBy(Usuario usuario) throws DAOException {
		return dao.getAllEqBy(usuario);
	}
	
	public List<Usuario> getAllNotEqBy(Usuario usuario) throws DAOException {
		return dao.getAllNotEqBy(usuario);
	}
	
	public List<Usuario> getAllBeginWithBy(Usuario usuario) throws DAOException {
		return dao.getAllBeginWithBy(usuario);
	}
	
	public List<Usuario> getAllNotBeginWithBy(Usuario usuario) throws DAOException {
		return dao.getAllNotBeginWithBy(usuario);
	}
	
	public List<Usuario> getAllEndWithBy(Usuario usuario) throws DAOException {
		return dao.getAllEndWithBy(usuario);
	}
	
	public List<Usuario> getAllNotEndWithBy(Usuario usuario) throws DAOException {
		return dao.getAllNotEndWithBy(usuario);
	}
	
	public List<Usuario> getAllContainBy(Usuario usuario) throws DAOException {
		return dao.getAllContainBy(usuario);
	}
	
	public List<Usuario> getAllNotContainBy(Usuario usuario) throws DAOException {
		return dao.getAllNotContainBy(usuario);
	}
	
	public List<Usuario> getAllIsNullBy(Usuario usuario) throws DAOException {
		return dao.getAllIsNullBy(usuario);
	}
	
	public List<Usuario> getAllNotIsNullBy(Usuario usuario) throws DAOException {
		return dao.getAllNotIsNullBy(usuario);
	}
	
	public boolean login(String username, String password, Boolean rememberMe) {		
		LOG.debug("UsuarioService login");
		return true;
	}
}