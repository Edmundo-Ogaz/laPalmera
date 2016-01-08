package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Insumo;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class InsumoDao {
	
	private static final Logger LOG = Logger.getLogger(InsumoDao.class);

	public Insumo get(String codigo) throws DAOException {
		LOG.debug("InsumoDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Insumo insumo = null;
		try {
			tx = session.beginTransaction();		
			insumo = (Insumo) session.createQuery("from Insumo where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return insumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Insumo> getAll() throws DAOException {
		LOG.debug("InsumoDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Insumo> listInsumo = null;
		try {
			tx = session.beginTransaction();		
			listInsumo = (List<Insumo>) session.createQuery("from Insumo ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Insumo> getAllEqBy(Insumo insumo) throws DAOException {
		LOG.debug("InsumoDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Insumo> listInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Insumo where 1 = 1 ");
			query.append(insumo.getCodigoinsumo() instanceof String && !insumo.getCodigoinsumo().isEmpty() ? "and CODIGO = '"  + insumo.getCodigoinsumo() + "' " : "");
			query.append(insumo.getCodigounidadmedida() instanceof String && !insumo.getCodigounidadmedida().isEmpty() ? "and NOMBRE = '" + insumo.getCodigounidadmedida() + "' " : "");
			
			listInsumo = (List<Insumo>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Insumo> getAllNotEqBy(Insumo insumo) throws DAOException {
		LOG.debug("InsumoDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Insumo> listInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Insumo where 1 = 1 ");
			query.append(insumo.getCodigoinsumo() instanceof String && !insumo.getCodigoinsumo().isEmpty() ? "and CODIGO = '"  + insumo.getCodigoinsumo() + "' " : "");
			query.append(insumo.getCodigounidadmedida() instanceof String && !insumo.getCodigounidadmedida().isEmpty() ? "and NOMBRE = '" + insumo.getCodigounidadmedida() + "' " : "");
			
			listInsumo = (List<Insumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Insumo> getAllBeginWithBy(Insumo insumo) throws DAOException {
		LOG.debug("InsumoDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Insumo> listInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Insumo  where 1 = 1 ");
			query.append(insumo.getCodigoinsumo() instanceof String && !insumo.getCodigoinsumo().isEmpty() ? "and CODIGO = '"  + insumo.getCodigoinsumo() + "' " : "");
			query.append(insumo.getCodigounidadmedida() instanceof String && !insumo.getCodigounidadmedida().isEmpty() ? "and NOMBRE = '" + insumo.getCodigounidadmedida() + "' " : "");
			
			listInsumo = (List<Insumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Insumo> getAllNotBeginWithBy(Insumo insumo) throws DAOException {
		LOG.debug("InsumoDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Insumo> listInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Insumo  where 1 = 1 ");
			query.append(insumo.getCodigoinsumo() instanceof String && !insumo.getCodigoinsumo().isEmpty() ? "and CODIGO = '"  + insumo.getCodigoinsumo() + "' " : "");
			query.append(insumo.getCodigounidadmedida() instanceof String && !insumo.getCodigounidadmedida().isEmpty() ? "and NOMBRE = '" + insumo.getCodigounidadmedida() + "' " : "");
			
			listInsumo = (List<Insumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Insumo> getAllEndWithBy(Insumo insumo) throws DAOException {
		LOG.debug("InsumoDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Insumo> listInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Insumo  where 1 = 1 ");
			query.append(insumo.getCodigoinsumo() instanceof String && !insumo.getCodigoinsumo().isEmpty() ? "and CODIGO = '"  + insumo.getCodigoinsumo() + "' " : "");
			query.append(insumo.getCodigounidadmedida() instanceof String && !insumo.getCodigounidadmedida().isEmpty() ? "and NOMBRE = '" + insumo.getCodigounidadmedida() + "' " : "");
			
			listInsumo = (List<Insumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Insumo> getAllNotEndWithBy(Insumo insumo) throws DAOException {
		LOG.debug("InsumoDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Insumo> listInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Insumo  where 1 = 1 ");
			query.append(insumo.getCodigoinsumo() instanceof String && !insumo.getCodigoinsumo().isEmpty() ? "and CODIGO = '"  + insumo.getCodigoinsumo() + "' " : "");
			query.append(insumo.getCodigounidadmedida() instanceof String && !insumo.getCodigounidadmedida().isEmpty() ? "and NOMBRE = '" + insumo.getCodigounidadmedida() + "' " : "");
			
			listInsumo = (List<Insumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Insumo> getAllContainBy(Insumo insumo) throws DAOException {
		LOG.debug("InsumoDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Insumo> listInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Insumo  where 1 = 1 ");
			query.append(insumo.getCodigoinsumo() instanceof String && !insumo.getCodigoinsumo().isEmpty() ? "and CODIGO = '"  + insumo.getCodigoinsumo() + "' " : "");
			query.append(insumo.getCodigounidadmedida() instanceof String && !insumo.getCodigounidadmedida().isEmpty() ? "and NOMBRE = '" + insumo.getCodigounidadmedida() + "' " : "");
			
			listInsumo = (List<Insumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Insumo> getAllNotContainBy(Insumo insumo) throws DAOException {
		LOG.debug("InsumoDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Insumo> listInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Insumo  where 1 = 1 ");
			query.append(insumo.getCodigoinsumo() instanceof String && !insumo.getCodigoinsumo().isEmpty() ? "and CODIGO = '"  + insumo.getCodigoinsumo() + "' " : "");
			query.append(insumo.getCodigounidadmedida() instanceof String && !insumo.getCodigounidadmedida().isEmpty() ? "and NOMBRE = '" + insumo.getCodigounidadmedida() + "' " : "");
			
			listInsumo = (List<Insumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Insumo> getAllIsNullBy(Insumo insumo) throws DAOException {
		LOG.debug("InsumoDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Insumo> listInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Insumo  where 1 = 1 ");
			query.append(insumo.getCodigoinsumo() instanceof String && !insumo.getCodigoinsumo().isEmpty() ? "and CODIGO = '"  + insumo.getCodigoinsumo() + "' " : "");
			query.append(insumo.getCodigounidadmedida() instanceof String && !insumo.getCodigounidadmedida().isEmpty() ? "and NOMBRE = '" + insumo.getCodigounidadmedida() + "' " : "");
			
			listInsumo = (List<Insumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Insumo> getAllNotIsNullBy(Insumo insumo) throws DAOException {
		LOG.debug("InsumoDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Insumo> listInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Insumo  where 1 = 1 ");
			query.append(insumo.getCodigoinsumo() instanceof String && !insumo.getCodigoinsumo().isEmpty() ? "and CODIGO = '"  + insumo.getCodigoinsumo() + "' " : "");
			query.append(insumo.getCodigounidadmedida() instanceof String && !insumo.getCodigounidadmedida().isEmpty() ? "and NOMBRE = '" + insumo.getCodigounidadmedida() + "' " : "");
			
			listInsumo = (List<Insumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listInsumo;
	}
	
	public boolean save(Insumo obj) throws DAOException {
		LOG.debug("InsumoDao save");
		
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
	
	public boolean update(Insumo obj) throws DAOException {
		LOG.debug("InsumoDao update");
		
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
		LOG.debug("InsumoDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Insumo insumo = (Insumo) session.get(Insumo.class, codigo);
			session.delete(insumo);
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