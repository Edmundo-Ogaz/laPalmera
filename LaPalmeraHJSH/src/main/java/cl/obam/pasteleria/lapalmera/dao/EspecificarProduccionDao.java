package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Especificarproduccion;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class EspecificarProduccionDao {
	
	private static final Logger LOG = Logger.getLogger(EspecificarProduccionDao.class);

	public Especificarproduccion get(String codigo) throws DAOException {
		LOG.debug("EspecificarProduccionDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Especificarproduccion especificarProduccion = null;
		try {
			tx = session.beginTransaction();		
			especificarProduccion = (Especificarproduccion) session.createQuery("from Especificarproduccion where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return especificarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Especificarproduccion> getAll() throws DAOException {
		LOG.debug("EspecificarProduccionDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Especificarproduccion> listEspecificarProduccion = null;
		try {
			tx = session.beginTransaction();		
			listEspecificarProduccion = (List<Especificarproduccion>) session.createQuery("from Especificarproduccion ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEspecificarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Especificarproduccion> getAllEqBy(Especificarproduccion especificarProduccion) throws DAOException {
		LOG.debug("EspecificarProduccionDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Especificarproduccion> listEspecificarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Especificarproduccion where 1 = 1 ");
			query.append(especificarProduccion.getCodigolineaproduccion() instanceof String && !especificarProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + especificarProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(especificarProduccion.getCodigoordenfabricacion() instanceof String && !especificarProduccion.getCodigoordenfabricacion().isEmpty() ? "and NOMBRE = '" + especificarProduccion.getCodigoordenfabricacion() + "' " : "");
			
			listEspecificarProduccion = (List<Especificarproduccion>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEspecificarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Especificarproduccion> getAllNotEqBy(Especificarproduccion especificarProduccion) throws DAOException {
		LOG.debug("EspecificarProduccionDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Especificarproduccion> listEspecificarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Especificarproduccion where 1 = 1 ");
			query.append(especificarProduccion.getCodigolineaproduccion() instanceof String && !especificarProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + especificarProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(especificarProduccion.getCodigoordenfabricacion() instanceof String && !especificarProduccion.getCodigoordenfabricacion().isEmpty() ? "and NOMBRE = '" + especificarProduccion.getCodigoordenfabricacion() + "' " : "");
			
			listEspecificarProduccion = (List<Especificarproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEspecificarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Especificarproduccion> getAllBeginWithBy(Especificarproduccion especificarProduccion) throws DAOException {
		LOG.debug("EspecificarProduccionDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Especificarproduccion> listEspecificarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Especificarproduccion  where 1 = 1 ");
			query.append(especificarProduccion.getCodigolineaproduccion() instanceof String && !especificarProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + especificarProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(especificarProduccion.getCodigoordenfabricacion() instanceof String && !especificarProduccion.getCodigoordenfabricacion().isEmpty() ? "and NOMBRE = '" + especificarProduccion.getCodigoordenfabricacion() + "' " : "");
			
			listEspecificarProduccion = (List<Especificarproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEspecificarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Especificarproduccion> getAllNotBeginWithBy(Especificarproduccion especificarProduccion) throws DAOException {
		LOG.debug("EspecificarProduccionDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Especificarproduccion> listEspecificarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Especificarproduccion  where 1 = 1 ");
			query.append(especificarProduccion.getCodigolineaproduccion() instanceof String && !especificarProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + especificarProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(especificarProduccion.getCodigoordenfabricacion() instanceof String && !especificarProduccion.getCodigoordenfabricacion().isEmpty() ? "and NOMBRE = '" + especificarProduccion.getCodigoordenfabricacion() + "' " : "");
			
			listEspecificarProduccion = (List<Especificarproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEspecificarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Especificarproduccion> getAllEndWithBy(Especificarproduccion especificarProduccion) throws DAOException {
		LOG.debug("EspecificarProduccionDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Especificarproduccion> listEspecificarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Especificarproduccion  where 1 = 1 ");
			query.append(especificarProduccion.getCodigolineaproduccion() instanceof String && !especificarProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + especificarProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(especificarProduccion.getCodigoordenfabricacion() instanceof String && !especificarProduccion.getCodigoordenfabricacion().isEmpty() ? "and NOMBRE = '" + especificarProduccion.getCodigoordenfabricacion() + "' " : "");
			
			listEspecificarProduccion = (List<Especificarproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEspecificarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Especificarproduccion> getAllNotEndWithBy(Especificarproduccion especificarProduccion) throws DAOException {
		LOG.debug("EspecificarProduccionDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Especificarproduccion> listEspecificarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Especificarproduccion  where 1 = 1 ");
			query.append(especificarProduccion.getCodigolineaproduccion() instanceof String && !especificarProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + especificarProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(especificarProduccion.getCodigoordenfabricacion() instanceof String && !especificarProduccion.getCodigoordenfabricacion().isEmpty() ? "and NOMBRE = '" + especificarProduccion.getCodigoordenfabricacion() + "' " : "");
			
			listEspecificarProduccion = (List<Especificarproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEspecificarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Especificarproduccion> getAllContainBy(Especificarproduccion especificarProduccion) throws DAOException {
		LOG.debug("EspecificarProduccionDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Especificarproduccion> listEspecificarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Especificarproduccion  where 1 = 1 ");
			query.append(especificarProduccion.getCodigolineaproduccion() instanceof String && !especificarProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + especificarProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(especificarProduccion.getCodigoordenfabricacion() instanceof String && !especificarProduccion.getCodigoordenfabricacion().isEmpty() ? "and NOMBRE = '" + especificarProduccion.getCodigoordenfabricacion() + "' " : "");
			
			listEspecificarProduccion = (List<Especificarproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEspecificarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Especificarproduccion> getAllNotContainBy(Especificarproduccion especificarProduccion) throws DAOException {
		LOG.debug("EspecificarProduccionDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Especificarproduccion> listEspecificarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Especificarproduccion  where 1 = 1 ");
			query.append(especificarProduccion.getCodigolineaproduccion() instanceof String && !especificarProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + especificarProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(especificarProduccion.getCodigoordenfabricacion() instanceof String && !especificarProduccion.getCodigoordenfabricacion().isEmpty() ? "and NOMBRE = '" + especificarProduccion.getCodigoordenfabricacion() + "' " : "");
			
			listEspecificarProduccion = (List<Especificarproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEspecificarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Especificarproduccion> getAllIsNullBy(Especificarproduccion especificarProduccion) throws DAOException {
		LOG.debug("EspecificarProduccionDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Especificarproduccion> listEspecificarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Especificarproduccion  where 1 = 1 ");
			query.append(especificarProduccion.getCodigolineaproduccion() instanceof String && !especificarProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + especificarProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(especificarProduccion.getCodigoordenfabricacion() instanceof String && !especificarProduccion.getCodigoordenfabricacion().isEmpty() ? "and NOMBRE = '" + especificarProduccion.getCodigoordenfabricacion() + "' " : "");
			
			listEspecificarProduccion = (List<Especificarproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEspecificarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Especificarproduccion> getAllNotIsNullBy(Especificarproduccion especificarProduccion) throws DAOException {
		LOG.debug("EspecificarProduccionDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Especificarproduccion> listEspecificarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Especificarproduccion  where 1 = 1 ");
			query.append(especificarProduccion.getCodigolineaproduccion() instanceof String && !especificarProduccion.getCodigolineaproduccion().isEmpty() ? "and CODIGO = '"  + especificarProduccion.getCodigolineaproduccion() + "' " : "");
			query.append(especificarProduccion.getCodigoordenfabricacion() instanceof String && !especificarProduccion.getCodigoordenfabricacion().isEmpty() ? "and NOMBRE = '" + especificarProduccion.getCodigoordenfabricacion() + "' " : "");
			
			listEspecificarProduccion = (List<Especificarproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEspecificarProduccion;
	}
	
	public boolean save(Especificarproduccion obj) throws DAOException {
		LOG.debug("EspecificarProduccionDao save");
		
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
	
	public boolean update(Especificarproduccion obj) throws DAOException {
		LOG.debug("EspecificarProduccionDao update");
		
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
		LOG.debug("EspecificarProduccionDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Especificarproduccion especificarProduccion = (Especificarproduccion) session.get(Especificarproduccion.class, codigo);
			session.delete(especificarProduccion);
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