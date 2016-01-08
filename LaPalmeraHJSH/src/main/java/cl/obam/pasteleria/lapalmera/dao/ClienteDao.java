package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Cliente;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class ClienteDao {
	
	private static final Logger LOG = Logger.getLogger(ClienteDao.class);

	public Cliente get(String rut) throws DAOException {
		LOG.debug("ClienteDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Cliente cliente = null;
		try {
			tx = session.beginTransaction();		
			cliente = (Cliente) session.createQuery("from Cliente where rut = ?").setString(0, rut).uniqueResult();
			if(cliente instanceof Cliente) {
				cliente.getComuna().getNombre();
				cliente.getComuna().getCiudad().getNombre();
				cliente.getComuna().getCiudad().getRegion().getNombre();
				cliente.getTipocliente().getNombre();
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return cliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getAll() throws DAOException {
		LOG.debug("ClienteDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cliente> listCliente = null;
		try {
			tx = session.beginTransaction();		
			listCliente = (List<Cliente>) session.createQuery("from Cliente ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getAllEqBy(Cliente cliente) throws DAOException {
		LOG.debug("ClienteDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cliente> listCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cliente where 1 = 1 ");
			query.append(cliente.getDireccion() instanceof String && !cliente.getDireccion().isEmpty() ? "and CODIGO = '"  + cliente.getDireccion() + "' " : "");
			
			listCliente = (List<Cliente>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getAllNotEqBy(Cliente cliente) throws DAOException {
		LOG.debug("ClienteDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cliente> listCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cliente where 1 = 1 ");
			query.append(cliente.getDireccion() instanceof String && !cliente.getDireccion().isEmpty() ? "and CODIGO = '"  + cliente.getDireccion() + "' " : "");
			
			listCliente = (List<Cliente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getAllBeginWithBy(Cliente cliente) throws DAOException {
		LOG.debug("ClienteDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cliente> listCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cliente  where 1 = 1 ");
			query.append(cliente.getDireccion() instanceof String && !cliente.getDireccion().isEmpty() ? "and CODIGO = '"  + cliente.getDireccion() + "' " : "");
			
			listCliente = (List<Cliente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getAllNotBeginWithBy(Cliente cliente) throws DAOException {
		LOG.debug("ClienteDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cliente> listCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cliente  where 1 = 1 ");
			query.append(cliente.getDireccion() instanceof String && !cliente.getDireccion().isEmpty() ? "and CODIGO = '"  + cliente.getDireccion() + "' " : "");
			
			listCliente = (List<Cliente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getAllEndWithBy(Cliente cliente) throws DAOException {
		LOG.debug("ClienteDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cliente> listCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cliente  where 1 = 1 ");
			query.append(cliente.getDireccion() instanceof String && !cliente.getDireccion().isEmpty() ? "and CODIGO = '"  + cliente.getDireccion() + "' " : "");
			
			listCliente = (List<Cliente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getAllNotEndWithBy(Cliente cliente) throws DAOException {
		LOG.debug("ClienteDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cliente> listCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cliente  where 1 = 1 ");
			query.append(cliente.getDireccion() instanceof String && !cliente.getDireccion().isEmpty() ? "and CODIGO = '"  + cliente.getDireccion() + "' " : "");
			
			listCliente = (List<Cliente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getAllContainBy(Cliente cliente) throws DAOException {
		LOG.debug("ClienteDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cliente> listCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cliente  where 1 = 1 ");
			query.append(cliente.getDireccion() instanceof String && !cliente.getDireccion().isEmpty() ? "and CODIGO = '"  + cliente.getDireccion() + "' " : "");
			
			listCliente = (List<Cliente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getAllNotContainBy(Cliente cliente) throws DAOException {
		LOG.debug("ClienteDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cliente> listCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cliente  where 1 = 1 ");
			query.append(cliente.getDireccion() instanceof String && !cliente.getDireccion().isEmpty() ? "and CODIGO = '"  + cliente.getDireccion() + "' " : "");
			
			listCliente = (List<Cliente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getAllIsNullBy(Cliente cliente) throws DAOException {
		LOG.debug("ClienteDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cliente> listCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cliente  where 1 = 1 ");
			query.append(cliente.getDireccion() instanceof String && !cliente.getDireccion().isEmpty() ? "and CODIGO = '"  + cliente.getDireccion() + "' " : "");
			
			listCliente = (List<Cliente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getAllNotIsNullBy(Cliente cliente) throws DAOException {
		LOG.debug("ClienteDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cliente> listCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cliente  where 1 = 1 ");
			query.append(cliente.getDireccion() instanceof String && !cliente.getDireccion().isEmpty() ? "and CODIGO = '"  + cliente.getDireccion() + "' " : "");
			
			listCliente = (List<Cliente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCliente;
	}
	
	public boolean save(Cliente obj) throws DAOException {
		LOG.debug("ClienteDao save");
		
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
	
	public boolean update(Cliente obj) throws DAOException {
		LOG.debug("ClienteDao update");
		
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
		LOG.debug("ClienteDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Cliente cliente = (Cliente) session.get(Cliente.class, codigo);
			session.delete(cliente);
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