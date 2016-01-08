package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Despachopedido;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class DespachoPedidoDao {
	
	private static final Logger LOG = Logger.getLogger(DespachoPedidoDao.class);

	public Despachopedido get(String codigo) throws DAOException {
		LOG.debug("DespachoPedidoDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Despachopedido despachoPedido = null;
		try {
			tx = session.beginTransaction();		
			despachoPedido = (Despachopedido) session.createQuery("from Despachopedido where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return despachoPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Despachopedido> getAll() throws DAOException {
		LOG.debug("DespachoPedidoDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Despachopedido> listDespachoPedido = null;
		try {
			tx = session.beginTransaction();		
			listDespachoPedido = (List<Despachopedido>) session.createQuery("from Despachopedido ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDespachoPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Despachopedido> getAllEqBy(Despachopedido despachoPedido) throws DAOException {
		LOG.debug("DespachoPedidoDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Despachopedido> listDespachoPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Despachopedido where 1 = 1 ");
			query.append(despachoPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + despachoPedido.getNumeropedido() + "' " : "");
			query.append(despachoPedido.getNombrecliente() instanceof String && !despachoPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + despachoPedido.getNombrecliente() + "' " : "");
			
			listDespachoPedido = (List<Despachopedido>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDespachoPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Despachopedido> getAllNotEqBy(Despachopedido despachoPedido) throws DAOException {
		LOG.debug("DespachoPedidoDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Despachopedido> listDespachoPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Despachopedido where 1 = 1 ");
			query.append(despachoPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + despachoPedido.getNumeropedido() + "' " : "");
			query.append(despachoPedido.getNombrecliente() instanceof String && !despachoPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + despachoPedido.getNombrecliente() + "' " : "");
			
			listDespachoPedido = (List<Despachopedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDespachoPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Despachopedido> getAllBeginWithBy(Despachopedido despachoPedido) throws DAOException {
		LOG.debug("DespachoPedidoDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Despachopedido> listDespachoPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Despachopedido  where 1 = 1 ");
			query.append(despachoPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + despachoPedido.getNumeropedido() + "' " : "");
			query.append(despachoPedido.getNombrecliente() instanceof String && !despachoPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + despachoPedido.getNombrecliente() + "' " : "");
			
			listDespachoPedido = (List<Despachopedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDespachoPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Despachopedido> getAllNotBeginWithBy(Despachopedido despachoPedido) throws DAOException {
		LOG.debug("DespachoPedidoDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Despachopedido> listDespachoPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Despachopedido  where 1 = 1 ");
			query.append(despachoPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + despachoPedido.getNumeropedido() + "' " : "");
			query.append(despachoPedido.getNombrecliente() instanceof String && !despachoPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + despachoPedido.getNombrecliente() + "' " : "");
			
			listDespachoPedido = (List<Despachopedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDespachoPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Despachopedido> getAllEndWithBy(Despachopedido despachoPedido) throws DAOException {
		LOG.debug("DespachoPedidoDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Despachopedido> listDespachoPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Despachopedido  where 1 = 1 ");
			query.append(despachoPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + despachoPedido.getNumeropedido() + "' " : "");
			query.append(despachoPedido.getNombrecliente() instanceof String && !despachoPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + despachoPedido.getNombrecliente() + "' " : "");
			
			listDespachoPedido = (List<Despachopedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDespachoPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Despachopedido> getAllNotEndWithBy(Despachopedido despachoPedido) throws DAOException {
		LOG.debug("DespachoPedidoDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Despachopedido> listDespachoPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Despachopedido  where 1 = 1 ");
			query.append(despachoPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + despachoPedido.getNumeropedido() + "' " : "");
			query.append(despachoPedido.getNombrecliente() instanceof String && !despachoPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + despachoPedido.getNombrecliente() + "' " : "");
			
			listDespachoPedido = (List<Despachopedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDespachoPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Despachopedido> getAllContainBy(Despachopedido despachoPedido) throws DAOException {
		LOG.debug("DespachoPedidoDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Despachopedido> listDespachoPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Despachopedido  where 1 = 1 ");
			query.append(despachoPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + despachoPedido.getNumeropedido() + "' " : "");
			query.append(despachoPedido.getNombrecliente() instanceof String && !despachoPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + despachoPedido.getNombrecliente() + "' " : "");
			
			listDespachoPedido = (List<Despachopedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDespachoPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Despachopedido> getAllNotContainBy(Despachopedido despachoPedido) throws DAOException {
		LOG.debug("DespachoPedidoDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Despachopedido> listDespachoPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Despachopedido  where 1 = 1 ");
			query.append(despachoPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + despachoPedido.getNumeropedido() + "' " : "");
			query.append(despachoPedido.getNombrecliente() instanceof String && !despachoPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + despachoPedido.getNombrecliente() + "' " : "");
			
			listDespachoPedido = (List<Despachopedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDespachoPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Despachopedido> getAllIsNullBy(Despachopedido despachoPedido) throws DAOException {
		LOG.debug("DespachoPedidoDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Despachopedido> listDespachoPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Despachopedido  where 1 = 1 ");
			query.append(despachoPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + despachoPedido.getNumeropedido() + "' " : "");
			query.append(despachoPedido.getNombrecliente() instanceof String && !despachoPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + despachoPedido.getNombrecliente() + "' " : "");
			
			listDespachoPedido = (List<Despachopedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDespachoPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Despachopedido> getAllNotIsNullBy(Despachopedido despachoPedido) throws DAOException {
		LOG.debug("DespachoPedidoDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Despachopedido> listDespachoPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Despachopedido  where 1 = 1 ");
			query.append(despachoPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + despachoPedido.getNumeropedido() + "' " : "");
			query.append(despachoPedido.getNombrecliente() instanceof String && !despachoPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + despachoPedido.getNombrecliente() + "' " : "");
			
			listDespachoPedido = (List<Despachopedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDespachoPedido;
	}
	
	public boolean save(Despachopedido obj) throws DAOException {
		LOG.debug("DespachoPedidoDao save");
		
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
	
	public boolean update(Despachopedido obj) throws DAOException {
		LOG.debug("DespachoPedidoDao update");
		
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
		LOG.debug("DespachoPedidoDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Despachopedido despachoPedido = (Despachopedido) session.get(Despachopedido.class, codigo);
			session.delete(despachoPedido);
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