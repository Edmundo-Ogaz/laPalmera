package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Detallepedido;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class DetallePedidoDao {
	
	private static final Logger LOG = Logger.getLogger(DetallePedidoDao.class);

	public Detallepedido get(String codigo) throws DAOException {
		LOG.debug("DetallePedidoDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Detallepedido detallePedido = null;
		try {
			tx = session.beginTransaction();		
			detallePedido = (Detallepedido) session.createQuery("from Detallepedido where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return detallePedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detallepedido> getAll() throws DAOException {
		LOG.debug("DetallePedidoDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detallepedido> listDetallePedido = null;
		try {
			tx = session.beginTransaction();		
			listDetallePedido = (List<Detallepedido>) session.createQuery("from Detallepedido ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetallePedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detallepedido> getAllEqBy(Detallepedido detallePedido) throws DAOException {
		LOG.debug("DetallePedidoDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detallepedido> listDetallePedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detallepedido where 1 = 1 ");
			query.append(detallePedido.getProducto().getCodigoproducto() instanceof String && !detallePedido.getProducto().getCodigoproducto().isEmpty() ? "and CODIGO = '"  + detallePedido.getProducto().getCodigoproducto() + "' " : "");
			query.append(detallePedido.getPedido().getNumeropedido() != 0 ? "and NOMBRE = '" + detallePedido.getPedido().getNumeropedido() + "' " : "");
			
			listDetallePedido = (List<Detallepedido>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetallePedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detallepedido> getAllNotEqBy(Detallepedido detallePedido) throws DAOException {
		LOG.debug("DetallePedidoDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detallepedido> listDetallePedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detallepedido where 1 = 1 ");
			query.append(detallePedido.getProducto().getCodigoproducto() instanceof String && !detallePedido.getProducto().getCodigoproducto().isEmpty() ? "and CODIGO = '"  + detallePedido.getProducto().getCodigoproducto() + "' " : "");
			query.append(detallePedido.getPedido().getNumeropedido() != 0 ? "and NOMBRE = '" + detallePedido.getPedido().getNumeropedido() + "' " : "");
			
			listDetallePedido = (List<Detallepedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetallePedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detallepedido> getAllBeginWithBy(Detallepedido detallePedido) throws DAOException {
		LOG.debug("DetallePedidoDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detallepedido> listDetallePedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detallepedido  where 1 = 1 ");
			query.append(detallePedido.getProducto().getCodigoproducto() instanceof String && !detallePedido.getProducto().getCodigoproducto().isEmpty() ? "and CODIGO = '"  + detallePedido.getProducto().getCodigoproducto() + "' " : "");
			query.append(detallePedido.getPedido().getNumeropedido() != 0 ? "and NOMBRE = '" + detallePedido.getPedido().getNumeropedido() + "' " : "");
			
			listDetallePedido = (List<Detallepedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetallePedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detallepedido> getAllNotBeginWithBy(Detallepedido detallePedido) throws DAOException {
		LOG.debug("DetallePedidoDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detallepedido> listDetallePedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detallepedido  where 1 = 1 ");
			query.append(detallePedido.getProducto().getCodigoproducto() instanceof String && !detallePedido.getProducto().getCodigoproducto().isEmpty() ? "and CODIGO = '"  + detallePedido.getProducto().getCodigoproducto() + "' " : "");
			query.append(detallePedido.getPedido().getNumeropedido() != 0 ? "and NOMBRE = '" + detallePedido.getPedido().getNumeropedido() + "' " : "");
			
			listDetallePedido = (List<Detallepedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetallePedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detallepedido> getAllEndWithBy(Detallepedido detallePedido) throws DAOException {
		LOG.debug("DetallePedidoDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detallepedido> listDetallePedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detallepedido  where 1 = 1 ");
			query.append(detallePedido.getProducto().getCodigoproducto() instanceof String && !detallePedido.getProducto().getCodigoproducto().isEmpty() ? "and CODIGO = '"  + detallePedido.getProducto().getCodigoproducto() + "' " : "");
			query.append(detallePedido.getPedido().getNumeropedido() != 0 ? "and NOMBRE = '" + detallePedido.getPedido().getNumeropedido() + "' " : "");
			
			listDetallePedido = (List<Detallepedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetallePedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detallepedido> getAllNotEndWithBy(Detallepedido detallePedido) throws DAOException {
		LOG.debug("DetallePedidoDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detallepedido> listDetallePedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detallepedido  where 1 = 1 ");
			query.append(detallePedido.getProducto().getCodigoproducto() instanceof String && !detallePedido.getProducto().getCodigoproducto().isEmpty() ? "and CODIGO = '"  + detallePedido.getProducto().getCodigoproducto() + "' " : "");
			query.append(detallePedido.getPedido().getNumeropedido() != 0 ? "and NOMBRE = '" + detallePedido.getPedido().getNumeropedido() + "' " : "");
			
			listDetallePedido = (List<Detallepedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetallePedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detallepedido> getAllContainBy(Detallepedido detallePedido) throws DAOException {
		LOG.debug("DetallePedidoDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detallepedido> listDetallePedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detallepedido  where 1 = 1 ");
			query.append(detallePedido.getProducto().getCodigoproducto() instanceof String && !detallePedido.getProducto().getCodigoproducto().isEmpty() ? "and CODIGO = '"  + detallePedido.getProducto().getCodigoproducto() + "' " : "");
			query.append(detallePedido.getPedido().getNumeropedido() != 0 ? "and NOMBRE = '" + detallePedido.getPedido().getNumeropedido() + "' " : "");
			
			listDetallePedido = (List<Detallepedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetallePedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detallepedido> getAllNotContainBy(Detallepedido detallePedido) throws DAOException {
		LOG.debug("DetallePedidoDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detallepedido> listDetallePedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detallepedido  where 1 = 1 ");
			query.append(detallePedido.getProducto().getCodigoproducto() instanceof String && !detallePedido.getProducto().getCodigoproducto().isEmpty() ? "and CODIGO = '"  + detallePedido.getProducto().getCodigoproducto() + "' " : "");
			query.append(detallePedido.getPedido().getNumeropedido() != 0 ? "and NOMBRE = '" + detallePedido.getPedido().getNumeropedido() + "' " : "");
			
			listDetallePedido = (List<Detallepedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetallePedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detallepedido> getAllIsNullBy(Detallepedido detallePedido) throws DAOException {
		LOG.debug("DetallePedidoDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detallepedido> listDetallePedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detallepedido  where 1 = 1 ");
			query.append(detallePedido.getProducto().getCodigoproducto() instanceof String && !detallePedido.getProducto().getCodigoproducto().isEmpty() ? "and CODIGO = '"  + detallePedido.getProducto().getCodigoproducto() + "' " : "");
			query.append(detallePedido.getPedido().getNumeropedido() != 0 ? "and NOMBRE = '" + detallePedido.getPedido().getNumeropedido() + "' " : "");
			
			listDetallePedido = (List<Detallepedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetallePedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detallepedido> getAllNotIsNullBy(Detallepedido detallePedido) throws DAOException {
		LOG.debug("DetallePedidoDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detallepedido> listDetallePedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detallepedido  where 1 = 1 ");
			query.append(detallePedido.getProducto().getCodigoproducto() instanceof String && !detallePedido.getProducto().getCodigoproducto().isEmpty() ? "and CODIGO = '"  + detallePedido.getProducto().getCodigoproducto() + "' " : "");
			query.append(detallePedido.getPedido().getNumeropedido() != 0 ? "and NOMBRE = '" + detallePedido.getPedido().getNumeropedido() + "' " : "");
			
			listDetallePedido = (List<Detallepedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetallePedido;
	}
	
	public boolean save(Detallepedido obj) throws DAOException {
		LOG.debug("DetallePedidoDao save");
		
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
	
	public boolean update(Detallepedido obj) throws DAOException {
		LOG.debug("DetallePedidoDao update");
		
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
		LOG.debug("DetallePedidoDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Detallepedido detallePedido = (Detallepedido) session.get(Detallepedido.class, codigo);
			session.delete(detallePedido);
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