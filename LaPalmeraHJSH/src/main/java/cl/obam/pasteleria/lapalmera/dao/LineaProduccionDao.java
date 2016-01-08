package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Lineaproduccion;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class LineaProduccionDao {
	
	private static final Logger LOG = Logger.getLogger(LineaProduccionDao.class);

	public Lineaproduccion get(String codigo) throws DAOException {
		LOG.debug("LineaProduccionDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Lineaproduccion lineaProduccion = null;
		try {
			tx = session.beginTransaction();		
			lineaProduccion = (Lineaproduccion) session.createQuery("from Lineaproduccion where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return lineaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Lineaproduccion> getAll() throws DAOException {
		LOG.debug("LineaProduccionDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Lineaproduccion> listLineaProduccion = null;
		try {
			tx = session.beginTransaction();		
			listLineaProduccion = (List<Lineaproduccion>) session.createQuery("from Lineaproduccion ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listLineaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Lineaproduccion> getAllEqBy(Lineaproduccion lineaProduccion) throws DAOException {
		LOG.debug("LineaProduccionDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Lineaproduccion> listLineaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Lineaproduccion where 1 = 1 ");
			query.append(lineaProduccion.getCodigolineaproduccion() instanceof String && !lineaProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + lineaProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(lineaProduccion.getNombrelineaproduccion() instanceof String && !lineaProduccion.getNombrelineaproduccion().isEmpty() ? "and NOMBRE = '" + lineaProduccion.getNombrelineaproduccion() + "' " : "");
			
			listLineaProduccion = (List<Lineaproduccion>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listLineaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Lineaproduccion> getAllNotEqBy(Lineaproduccion lineaProduccion) throws DAOException {
		LOG.debug("LineaProduccionDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Lineaproduccion> listLineaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Lineaproduccion where 1 = 1 ");
			query.append(lineaProduccion.getCodigolineaproduccion() instanceof String && !lineaProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + lineaProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(lineaProduccion.getNombrelineaproduccion() instanceof String && !lineaProduccion.getNombrelineaproduccion().isEmpty() ? "and NOMBRE = '" + lineaProduccion.getNombrelineaproduccion() + "' " : "");
			
			listLineaProduccion = (List<Lineaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listLineaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Lineaproduccion> getAllBeginWithBy(Lineaproduccion lineaProduccion) throws DAOException {
		LOG.debug("LineaProduccionDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Lineaproduccion> listLineaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Lineaproduccion  where 1 = 1 ");
			query.append(lineaProduccion.getCodigolineaproduccion() instanceof String && !lineaProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + lineaProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(lineaProduccion.getNombrelineaproduccion() instanceof String && !lineaProduccion.getNombrelineaproduccion().isEmpty() ? "and NOMBRE = '" + lineaProduccion.getNombrelineaproduccion() + "' " : "");
			
			listLineaProduccion = (List<Lineaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listLineaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Lineaproduccion> getAllNotBeginWithBy(Lineaproduccion lineaProduccion) throws DAOException {
		LOG.debug("LineaProduccionDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Lineaproduccion> listLineaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Lineaproduccion  where 1 = 1 ");
			query.append(lineaProduccion.getCodigolineaproduccion() instanceof String && !lineaProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + lineaProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(lineaProduccion.getNombrelineaproduccion() instanceof String && !lineaProduccion.getNombrelineaproduccion().isEmpty() ? "and NOMBRE = '" + lineaProduccion.getNombrelineaproduccion() + "' " : "");
			
			listLineaProduccion = (List<Lineaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listLineaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Lineaproduccion> getAllEndWithBy(Lineaproduccion lineaProduccion) throws DAOException {
		LOG.debug("LineaProduccionDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Lineaproduccion> listLineaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Lineaproduccion  where 1 = 1 ");
			query.append(lineaProduccion.getCodigolineaproduccion() instanceof String && !lineaProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + lineaProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(lineaProduccion.getNombrelineaproduccion() instanceof String && !lineaProduccion.getNombrelineaproduccion().isEmpty() ? "and NOMBRE = '" + lineaProduccion.getNombrelineaproduccion() + "' " : "");
			
			listLineaProduccion = (List<Lineaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listLineaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Lineaproduccion> getAllNotEndWithBy(Lineaproduccion lineaProduccion) throws DAOException {
		LOG.debug("LineaProduccionDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Lineaproduccion> listLineaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Lineaproduccion  where 1 = 1 ");
			query.append(lineaProduccion.getCodigolineaproduccion() instanceof String && !lineaProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + lineaProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(lineaProduccion.getNombrelineaproduccion() instanceof String && !lineaProduccion.getNombrelineaproduccion().isEmpty() ? "and NOMBRE = '" + lineaProduccion.getNombrelineaproduccion() + "' " : "");
			
			listLineaProduccion = (List<Lineaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listLineaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Lineaproduccion> getAllContainBy(Lineaproduccion lineaProduccion) throws DAOException {
		LOG.debug("LineaProduccionDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Lineaproduccion> listLineaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Lineaproduccion  where 1 = 1 ");
			query.append(lineaProduccion.getCodigolineaproduccion() instanceof String && !lineaProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + lineaProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(lineaProduccion.getNombrelineaproduccion() instanceof String && !lineaProduccion.getNombrelineaproduccion().isEmpty() ? "and NOMBRE = '" + lineaProduccion.getNombrelineaproduccion() + "' " : "");
			
			listLineaProduccion = (List<Lineaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listLineaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Lineaproduccion> getAllNotContainBy(Lineaproduccion lineaProduccion) throws DAOException {
		LOG.debug("LineaProduccionDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Lineaproduccion> listLineaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Lineaproduccion  where 1 = 1 ");
			query.append(lineaProduccion.getCodigolineaproduccion() instanceof String && !lineaProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + lineaProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(lineaProduccion.getNombrelineaproduccion() instanceof String && !lineaProduccion.getNombrelineaproduccion().isEmpty() ? "and NOMBRE = '" + lineaProduccion.getNombrelineaproduccion() + "' " : "");
			
			listLineaProduccion = (List<Lineaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listLineaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Lineaproduccion> getAllIsNullBy(Lineaproduccion lineaProduccion) throws DAOException {
		LOG.debug("LineaProduccionDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Lineaproduccion> listLineaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Lineaproduccion  where 1 = 1 ");
			query.append(lineaProduccion.getCodigolineaproduccion() instanceof String && !lineaProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + lineaProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(lineaProduccion.getNombrelineaproduccion() instanceof String && !lineaProduccion.getNombrelineaproduccion().isEmpty() ? "and NOMBRE = '" + lineaProduccion.getNombrelineaproduccion() + "' " : "");
			
			listLineaProduccion = (List<Lineaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listLineaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Lineaproduccion> getAllNotIsNullBy(Lineaproduccion lineaProduccion) throws DAOException {
		LOG.debug("LineaProduccionDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Lineaproduccion> listLineaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Lineaproduccion  where 1 = 1 ");
			query.append(lineaProduccion.getCodigolineaproduccion() instanceof String && !lineaProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + lineaProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(lineaProduccion.getNombrelineaproduccion() instanceof String && !lineaProduccion.getNombrelineaproduccion().isEmpty() ? "and NOMBRE = '" + lineaProduccion.getNombrelineaproduccion() + "' " : "");
			
			listLineaProduccion = (List<Lineaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listLineaProduccion;
	}
	
	public boolean save(Lineaproduccion obj) throws DAOException {
		LOG.debug("LineaProduccionDao save");
		
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
	
	public boolean update(Lineaproduccion obj) throws DAOException {
		LOG.debug("LineaProduccionDao update");
		
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
		LOG.debug("LineaProduccionDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Lineaproduccion lineaProduccion = (Lineaproduccion) session.get(Lineaproduccion.class, codigo);
			session.delete(lineaProduccion);
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