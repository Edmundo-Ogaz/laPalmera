package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Usuario;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class UsuarioDao {
	
	private static final Logger LOG = Logger.getLogger(UsuarioDao.class);

	public Usuario get(String codigo) throws DAOException {
		LOG.debug("UsuarioDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Usuario usuario = null;
		try {
			tx = session.beginTransaction();		
			usuario = (Usuario) session.createQuery("from Usuario where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return usuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> getAll() throws DAOException {
		LOG.debug("UsuarioDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Usuario> listUsuario = null;
		try {
			tx = session.beginTransaction();		
			listUsuario = (List<Usuario>) session.createQuery("from Usuario ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUsuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> getAllEqBy(Usuario usuario) throws DAOException {
		LOG.debug("UsuarioDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Usuario> listUsuario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Usuario where 1 = 1 ");
			query.append(usuario.getLoginusuario() instanceof String && !usuario.getLoginusuario().isEmpty() ? "and LOGINUSUARIO = '"  + usuario.getLoginusuario() + "' " : "");
			query.append(usuario.getPasswordusuario() instanceof String && !usuario.getPasswordusuario().isEmpty() ? "and PASSWORDUSUARIO = '" + usuario.getPasswordusuario() + "' " : "");
			
			listUsuario = (List<Usuario>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUsuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> getAllNotEqBy(Usuario usuario) throws DAOException {
		LOG.debug("UsuarioDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Usuario> listUsuario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Usuario where 1 = 1 ");
			query.append(usuario.getLoginusuario() instanceof String && !usuario.getLoginusuario().isEmpty() ? "and LOGINUSUARIO = '"  + usuario.getLoginusuario() + "' " : "");
			query.append(usuario.getPasswordusuario() instanceof String && !usuario.getPasswordusuario().isEmpty() ? "and PASSWORDUSUARIO = '" + usuario.getPasswordusuario() + "' " : "");
			
			listUsuario = (List<Usuario>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUsuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> getAllBeginWithBy(Usuario usuario) throws DAOException {
		LOG.debug("UsuarioDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Usuario> listUsuario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Usuario  where 1 = 1 ");
			query.append(usuario.getLoginusuario() instanceof String && !usuario.getLoginusuario().isEmpty() ? "and LOGINUSUARIO = '"  + usuario.getLoginusuario() + "' " : "");
			query.append(usuario.getPasswordusuario() instanceof String && !usuario.getPasswordusuario().isEmpty() ? "and PASSWORDUSUARIO = '" + usuario.getPasswordusuario() + "' " : "");
			
			listUsuario = (List<Usuario>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUsuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> getAllNotBeginWithBy(Usuario usuario) throws DAOException {
		LOG.debug("UsuarioDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Usuario> listUsuario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Usuario  where 1 = 1 ");
			query.append(usuario.getLoginusuario() instanceof String && !usuario.getLoginusuario().isEmpty() ? "and LOGINUSUARIO = '"  + usuario.getLoginusuario() + "' " : "");
			query.append(usuario.getPasswordusuario() instanceof String && !usuario.getPasswordusuario().isEmpty() ? "and PASSWORDUSUARIO = '" + usuario.getPasswordusuario() + "' " : "");
			
			listUsuario = (List<Usuario>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUsuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> getAllEndWithBy(Usuario usuario) throws DAOException {
		LOG.debug("UsuarioDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Usuario> listUsuario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Usuario  where 1 = 1 ");
			query.append(usuario.getLoginusuario() instanceof String && !usuario.getLoginusuario().isEmpty() ? "and LOGINUSUARIO = '"  + usuario.getLoginusuario() + "' " : "");
			query.append(usuario.getPasswordusuario() instanceof String && !usuario.getPasswordusuario().isEmpty() ? "and PASSWORDUSUARIO = '" + usuario.getPasswordusuario() + "' " : "");
			
			listUsuario = (List<Usuario>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUsuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> getAllNotEndWithBy(Usuario usuario) throws DAOException {
		LOG.debug("UsuarioDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Usuario> listUsuario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Usuario  where 1 = 1 ");
			query.append(usuario.getLoginusuario() instanceof String && !usuario.getLoginusuario().isEmpty() ? "and LOGINUSUARIO = '"  + usuario.getLoginusuario() + "' " : "");
			query.append(usuario.getPasswordusuario() instanceof String && !usuario.getPasswordusuario().isEmpty() ? "and PASSWORDUSUARIO = '" + usuario.getPasswordusuario() + "' " : "");
			
			listUsuario = (List<Usuario>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUsuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> getAllContainBy(Usuario usuario) throws DAOException {
		LOG.debug("UsuarioDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Usuario> listUsuario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Usuario  where 1 = 1 ");
			query.append(usuario.getLoginusuario() instanceof String && !usuario.getLoginusuario().isEmpty() ? "and LOGINUSUARIO = '"  + usuario.getLoginusuario() + "' " : "");
			query.append(usuario.getPasswordusuario() instanceof String && !usuario.getPasswordusuario().isEmpty() ? "and PASSWORDUSUARIO = '" + usuario.getPasswordusuario() + "' " : "");
			
			listUsuario = (List<Usuario>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUsuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> getAllNotContainBy(Usuario usuario) throws DAOException {
		LOG.debug("UsuarioDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Usuario> listUsuario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Usuario  where 1 = 1 ");
			query.append(usuario.getLoginusuario() instanceof String && !usuario.getLoginusuario().isEmpty() ? "and LOGINUSUARIO = '"  + usuario.getLoginusuario() + "' " : "");
			query.append(usuario.getPasswordusuario() instanceof String && !usuario.getPasswordusuario().isEmpty() ? "and PASSWORDUSUARIO = '" + usuario.getPasswordusuario() + "' " : "");
			
			listUsuario = (List<Usuario>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUsuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> getAllIsNullBy(Usuario usuario) throws DAOException {
		LOG.debug("UsuarioDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Usuario> listUsuario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Usuario  where 1 = 1 ");
			query.append(usuario.getLoginusuario() instanceof String && !usuario.getLoginusuario().isEmpty() ? "and LOGINUSUARIO = '"  + usuario.getLoginusuario() + "' " : "");
			query.append(usuario.getPasswordusuario() instanceof String && !usuario.getPasswordusuario().isEmpty() ? "and PASSWORDUSUARIO = '" + usuario.getPasswordusuario() + "' " : "");
			
			listUsuario = (List<Usuario>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUsuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> getAllNotIsNullBy(Usuario usuario) throws DAOException {
		LOG.debug("UsuarioDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Usuario> listUsuario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Usuario  where 1 = 1 ");
			query.append(usuario.getLoginusuario() instanceof String && !usuario.getLoginusuario().isEmpty() ? "and LOGINUSUARIO = '"  + usuario.getLoginusuario() + "' " : "");
			query.append(usuario.getPasswordusuario() instanceof String && !usuario.getPasswordusuario().isEmpty() ? "and PASSWORDUSUARIO = '" + usuario.getPasswordusuario() + "' " : "");
			
			listUsuario = (List<Usuario>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUsuario;
	}
	
	public boolean save(Usuario obj) throws DAOException {
		LOG.debug("UsuarioDao save");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		    Serializable s = session.save(obj);
		    tx.commit();
		    resp = true;
		} catch (Exception e) {
			LOG.error("Fatal " + e.getMessage());
			if (tx != null && tx.isActive()){
				try {
					tx.rollback();
				} catch (HibernateException e1) {
					LOG.error("Fatal al tratar de hacer rollback " + e.getMessage());
					throw new DAOException("Error al grabar Campo y en rollback", e);
				}
			}
			throw new DAOException("Error al Nivel persistencia", e);
		} finally {
			session.close();
		}
		return resp;
	}
	
	public boolean update(Usuario obj) throws DAOException {
		LOG.debug("UsuarioDao update");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		    session.update(obj);
		    tx.commit();
		    resp = true;
		} catch (Exception e) {
			LOG.error("Fatal " + e.getMessage());
			if (tx != null && tx.isActive()){
				try {
					tx.rollback();
				} catch (HibernateException e1) {
					LOG.error("Fatal al tratar de hacer rollback " + e.getMessage());
					throw new DAOException("Error al grabar Campo y en rollback",e);
				}
			}
			throw new DAOException("Error al Nivel persistencia",e);
		} finally {
			session.close();
		}
		
		return resp;
	}
	
	public boolean delete(String codigo) throws DAOException {
		LOG.debug("UsuarioDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Usuario usuario = (Usuario) session.get(Usuario.class, codigo);
			session.delete(usuario);
		    tx.commit();
		    resp = true;
		} catch (Exception e) {
			LOG.error("Fatal " + e.getMessage());
			if (tx != null && tx.isActive()){
				try {
					tx.rollback();
				} catch (HibernateException e1) {
					LOG.error("Fatal al tratar de hacer rollback " + e.getMessage());
					throw new DAOException("Error al grabar Campo y en rollback",e);
				}
			}
			throw new DAOException("Error al Nivel persistencia",e);
		} finally {
			session.close();
		}
		
		return resp;
	}
}