package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Confirmacionpedido;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class ConfirmacionPedidoDao {
	
	private static final Logger LOG = Logger.getLogger(ConfirmacionPedidoDao.class);

	public Confirmacionpedido get(String codigo) throws DAOException {
		LOG.debug("ConfirmacionPedidoDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Confirmacionpedido confirmacionPedido = null;
		try {
			tx = session.beginTransaction();		
			confirmacionPedido = (Confirmacionpedido) session.createQuery("from Confirmacionpedido where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return confirmacionPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Confirmacionpedido> getAll() throws DAOException {
		LOG.debug("ConfirmacionPedidoDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Confirmacionpedido> listConfirmacionPedido = null;
		try {
			tx = session.beginTransaction();		
			listConfirmacionPedido = (List<Confirmacionpedido>) session.createQuery("from Confirmacionpedido ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConfirmacionPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Confirmacionpedido> getAllEqBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		LOG.debug("ConfirmacionPedidoDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Confirmacionpedido> listConfirmacionPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Confirmacionpedido where 1 = 1 ");
			query.append(confirmacionPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + confirmacionPedido.getNumeropedido() + "' " : "");
			query.append(confirmacionPedido.getNombrecliente() instanceof String && !confirmacionPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + confirmacionPedido.getNombrecliente() + "' " : "");
			
			listConfirmacionPedido = (List<Confirmacionpedido>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConfirmacionPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Confirmacionpedido> getAllNotEqBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		LOG.debug("ConfirmacionPedidoDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Confirmacionpedido> listConfirmacionPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Confirmacionpedido where 1 = 1 ");
			query.append(confirmacionPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + confirmacionPedido.getNumeropedido() + "' " : "");
			query.append(confirmacionPedido.getNombrecliente() instanceof String && !confirmacionPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + confirmacionPedido.getNombrecliente() + "' " : "");
			
			listConfirmacionPedido = (List<Confirmacionpedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConfirmacionPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Confirmacionpedido> getAllBeginWithBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		LOG.debug("ConfirmacionPedidoDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Confirmacionpedido> listConfirmacionPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Confirmacionpedido  where 1 = 1 ");
			query.append(confirmacionPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + confirmacionPedido.getNumeropedido() + "' " : "");
			query.append(confirmacionPedido.getNombrecliente() instanceof String && !confirmacionPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + confirmacionPedido.getNombrecliente() + "' " : "");
			
			listConfirmacionPedido = (List<Confirmacionpedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConfirmacionPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Confirmacionpedido> getAllNotBeginWithBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		LOG.debug("ConfirmacionPedidoDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Confirmacionpedido> listConfirmacionPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Confirmacionpedido  where 1 = 1 ");
			query.append(confirmacionPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + confirmacionPedido.getNumeropedido() + "' " : "");
			query.append(confirmacionPedido.getNombrecliente() instanceof String && !confirmacionPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + confirmacionPedido.getNombrecliente() + "' " : "");
			
			listConfirmacionPedido = (List<Confirmacionpedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConfirmacionPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Confirmacionpedido> getAllEndWithBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		LOG.debug("ConfirmacionPedidoDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Confirmacionpedido> listConfirmacionPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Confirmacionpedido  where 1 = 1 ");
			query.append(confirmacionPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + confirmacionPedido.getNumeropedido() + "' " : "");
			query.append(confirmacionPedido.getNombrecliente() instanceof String && !confirmacionPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + confirmacionPedido.getNombrecliente() + "' " : "");
			
			listConfirmacionPedido = (List<Confirmacionpedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConfirmacionPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Confirmacionpedido> getAllNotEndWithBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		LOG.debug("ConfirmacionPedidoDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Confirmacionpedido> listConfirmacionPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Confirmacionpedido  where 1 = 1 ");
			query.append(confirmacionPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + confirmacionPedido.getNumeropedido() + "' " : "");
			query.append(confirmacionPedido.getNombrecliente() instanceof String && !confirmacionPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + confirmacionPedido.getNombrecliente() + "' " : "");
			
			listConfirmacionPedido = (List<Confirmacionpedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConfirmacionPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Confirmacionpedido> getAllContainBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		LOG.debug("ConfirmacionPedidoDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Confirmacionpedido> listConfirmacionPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Confirmacionpedido  where 1 = 1 ");
			query.append(confirmacionPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + confirmacionPedido.getNumeropedido() + "' " : "");
			query.append(confirmacionPedido.getNombrecliente() instanceof String && !confirmacionPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + confirmacionPedido.getNombrecliente() + "' " : "");
			
			listConfirmacionPedido = (List<Confirmacionpedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConfirmacionPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Confirmacionpedido> getAllNotContainBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		LOG.debug("ConfirmacionPedidoDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Confirmacionpedido> listConfirmacionPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Confirmacionpedido  where 1 = 1 ");
			query.append(confirmacionPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + confirmacionPedido.getNumeropedido() + "' " : "");
			query.append(confirmacionPedido.getNombrecliente() instanceof String && !confirmacionPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + confirmacionPedido.getNombrecliente() + "' " : "");
			
			listConfirmacionPedido = (List<Confirmacionpedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConfirmacionPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Confirmacionpedido> getAllIsNullBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		LOG.debug("ConfirmacionPedidoDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Confirmacionpedido> listConfirmacionPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Confirmacionpedido  where 1 = 1 ");
			query.append(confirmacionPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + confirmacionPedido.getNumeropedido() + "' " : "");
			query.append(confirmacionPedido.getNombrecliente() instanceof String && !confirmacionPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + confirmacionPedido.getNombrecliente() + "' " : "");
			
			listConfirmacionPedido = (List<Confirmacionpedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConfirmacionPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Confirmacionpedido> getAllNotIsNullBy(Confirmacionpedido confirmacionPedido) throws DAOException {
		LOG.debug("ConfirmacionPedidoDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Confirmacionpedido> listConfirmacionPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Confirmacionpedido  where 1 = 1 ");
			query.append(confirmacionPedido.getNumeropedido() != 0 ? "and CODIGO = '"  + confirmacionPedido.getNumeropedido() + "' " : "");
			query.append(confirmacionPedido.getNombrecliente() instanceof String && !confirmacionPedido.getNombrecliente().isEmpty() ? "and NOMBRE = '" + confirmacionPedido.getNombrecliente() + "' " : "");
			
			listConfirmacionPedido = (List<Confirmacionpedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConfirmacionPedido;
	}
	
	public boolean save(Confirmacionpedido obj) throws DAOException {
		LOG.debug("ConfirmacionPedidoDao save");
		
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
	
	public boolean update(Confirmacionpedido obj) throws DAOException {
		LOG.debug("ConfirmacionPedidoDao update");
		
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
		LOG.debug("ConfirmacionPedidoDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Confirmacionpedido confirmacionPedido = (Confirmacionpedido) session.get(Confirmacionpedido.class, codigo);
			session.delete(confirmacionPedido);
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