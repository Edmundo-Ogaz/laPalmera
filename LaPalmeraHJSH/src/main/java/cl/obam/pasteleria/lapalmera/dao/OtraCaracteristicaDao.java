package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Otracaracteristica;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class OtraCaracteristicaDao {
	
	private static final Logger LOG = Logger.getLogger(OtraCaracteristicaDao.class);

	public Otracaracteristica get(String codigo) throws DAOException {
		LOG.debug("OtraCaracteristicaDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Otracaracteristica otraCaracteristica = null;
		try {
			tx = session.beginTransaction();		
			otraCaracteristica = (Otracaracteristica) session.createQuery("from Otracaracteristica where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return otraCaracteristica;
	}
	
	@SuppressWarnings("unchecked")
	public List<Otracaracteristica> getAll() throws DAOException {
		LOG.debug("OtraCaracteristicaDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Otracaracteristica> listOtraCaracteristica = null;
		try {
			tx = session.beginTransaction();		
			listOtraCaracteristica = (List<Otracaracteristica>) session.createQuery("from Otracaracteristica ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOtraCaracteristica;
	}
	
	@SuppressWarnings("unchecked")
	public List<Otracaracteristica> getAllEqBy(Otracaracteristica otraCaracteristica) throws DAOException {
		LOG.debug("OtraCaracteristicaDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Otracaracteristica> listOtraCaracteristica = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Otracaracteristica where 1 = 1 ");
			query.append(otraCaracteristica.getCodigootracaracteristica() instanceof String && !otraCaracteristica.getCodigootracaracteristica().isEmpty() ? "and CODIGO = '"  + otraCaracteristica.getCodigootracaracteristica() + "' " : "");
			query.append(otraCaracteristica.getNombreotracaracteristica() instanceof String && !otraCaracteristica.getNombreotracaracteristica().isEmpty() ? "and NOMBRE = '" + otraCaracteristica.getNombreotracaracteristica() + "' " : "");
			
			listOtraCaracteristica = (List<Otracaracteristica>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOtraCaracteristica;
	}
	
	@SuppressWarnings("unchecked")
	public List<Otracaracteristica> getAllNotEqBy(Otracaracteristica otraCaracteristica) throws DAOException {
		LOG.debug("OtraCaracteristicaDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Otracaracteristica> listOtraCaracteristica = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Otracaracteristica where 1 = 1 ");
			query.append(otraCaracteristica.getCodigootracaracteristica() instanceof String && !otraCaracteristica.getCodigootracaracteristica().isEmpty() ? "and CODIGO = '"  + otraCaracteristica.getCodigootracaracteristica() + "' " : "");
			query.append(otraCaracteristica.getNombreotracaracteristica() instanceof String && !otraCaracteristica.getNombreotracaracteristica().isEmpty() ? "and NOMBRE = '" + otraCaracteristica.getNombreotracaracteristica() + "' " : "");
			
			listOtraCaracteristica = (List<Otracaracteristica>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOtraCaracteristica;
	}
	
	@SuppressWarnings("unchecked")
	public List<Otracaracteristica> getAllBeginWithBy(Otracaracteristica otraCaracteristica) throws DAOException {
		LOG.debug("OtraCaracteristicaDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Otracaracteristica> listOtraCaracteristica = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Otracaracteristica  where 1 = 1 ");
			query.append(otraCaracteristica.getCodigootracaracteristica() instanceof String && !otraCaracteristica.getCodigootracaracteristica().isEmpty() ? "and CODIGO = '"  + otraCaracteristica.getCodigootracaracteristica() + "' " : "");
			query.append(otraCaracteristica.getNombreotracaracteristica() instanceof String && !otraCaracteristica.getNombreotracaracteristica().isEmpty() ? "and NOMBRE = '" + otraCaracteristica.getNombreotracaracteristica() + "' " : "");
			
			listOtraCaracteristica = (List<Otracaracteristica>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOtraCaracteristica;
	}
	
	@SuppressWarnings("unchecked")
	public List<Otracaracteristica> getAllNotBeginWithBy(Otracaracteristica otraCaracteristica) throws DAOException {
		LOG.debug("OtraCaracteristicaDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Otracaracteristica> listOtraCaracteristica = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Otracaracteristica  where 1 = 1 ");
			query.append(otraCaracteristica.getCodigootracaracteristica() instanceof String && !otraCaracteristica.getCodigootracaracteristica().isEmpty() ? "and CODIGO = '"  + otraCaracteristica.getCodigootracaracteristica() + "' " : "");
			query.append(otraCaracteristica.getNombreotracaracteristica() instanceof String && !otraCaracteristica.getNombreotracaracteristica().isEmpty() ? "and NOMBRE = '" + otraCaracteristica.getNombreotracaracteristica() + "' " : "");
			
			listOtraCaracteristica = (List<Otracaracteristica>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOtraCaracteristica;
	}
	
	@SuppressWarnings("unchecked")
	public List<Otracaracteristica> getAllEndWithBy(Otracaracteristica otraCaracteristica) throws DAOException {
		LOG.debug("OtraCaracteristicaDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Otracaracteristica> listOtraCaracteristica = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Otracaracteristica  where 1 = 1 ");
			query.append(otraCaracteristica.getCodigootracaracteristica() instanceof String && !otraCaracteristica.getCodigootracaracteristica().isEmpty() ? "and CODIGO = '"  + otraCaracteristica.getCodigootracaracteristica() + "' " : "");
			query.append(otraCaracteristica.getNombreotracaracteristica() instanceof String && !otraCaracteristica.getNombreotracaracteristica().isEmpty() ? "and NOMBRE = '" + otraCaracteristica.getNombreotracaracteristica() + "' " : "");
			
			listOtraCaracteristica = (List<Otracaracteristica>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOtraCaracteristica;
	}
	
	@SuppressWarnings("unchecked")
	public List<Otracaracteristica> getAllNotEndWithBy(Otracaracteristica otraCaracteristica) throws DAOException {
		LOG.debug("OtraCaracteristicaDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Otracaracteristica> listOtraCaracteristica = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Otracaracteristica  where 1 = 1 ");
			query.append(otraCaracteristica.getCodigootracaracteristica() instanceof String && !otraCaracteristica.getCodigootracaracteristica().isEmpty() ? "and CODIGO = '"  + otraCaracteristica.getCodigootracaracteristica() + "' " : "");
			query.append(otraCaracteristica.getNombreotracaracteristica() instanceof String && !otraCaracteristica.getNombreotracaracteristica().isEmpty() ? "and NOMBRE = '" + otraCaracteristica.getNombreotracaracteristica() + "' " : "");
			
			listOtraCaracteristica = (List<Otracaracteristica>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOtraCaracteristica;
	}
	
	@SuppressWarnings("unchecked")
	public List<Otracaracteristica> getAllContainBy(Otracaracteristica otraCaracteristica) throws DAOException {
		LOG.debug("OtraCaracteristicaDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Otracaracteristica> listOtraCaracteristica = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Otracaracteristica  where 1 = 1 ");
			query.append(otraCaracteristica.getCodigootracaracteristica() instanceof String && !otraCaracteristica.getCodigootracaracteristica().isEmpty() ? "and CODIGO = '"  + otraCaracteristica.getCodigootracaracteristica() + "' " : "");
			query.append(otraCaracteristica.getNombreotracaracteristica() instanceof String && !otraCaracteristica.getNombreotracaracteristica().isEmpty() ? "and NOMBRE = '" + otraCaracteristica.getNombreotracaracteristica() + "' " : "");
			
			listOtraCaracteristica = (List<Otracaracteristica>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOtraCaracteristica;
	}
	
	@SuppressWarnings("unchecked")
	public List<Otracaracteristica> getAllNotContainBy(Otracaracteristica otraCaracteristica) throws DAOException {
		LOG.debug("OtraCaracteristicaDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Otracaracteristica> listOtraCaracteristica = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Otracaracteristica  where 1 = 1 ");
			query.append(otraCaracteristica.getCodigootracaracteristica() instanceof String && !otraCaracteristica.getCodigootracaracteristica().isEmpty() ? "and CODIGO = '"  + otraCaracteristica.getCodigootracaracteristica() + "' " : "");
			query.append(otraCaracteristica.getNombreotracaracteristica() instanceof String && !otraCaracteristica.getNombreotracaracteristica().isEmpty() ? "and NOMBRE = '" + otraCaracteristica.getNombreotracaracteristica() + "' " : "");
			
			listOtraCaracteristica = (List<Otracaracteristica>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOtraCaracteristica;
	}
	
	@SuppressWarnings("unchecked")
	public List<Otracaracteristica> getAllIsNullBy(Otracaracteristica otraCaracteristica) throws DAOException {
		LOG.debug("OtraCaracteristicaDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Otracaracteristica> listOtraCaracteristica = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Otracaracteristica  where 1 = 1 ");
			query.append(otraCaracteristica.getCodigootracaracteristica() instanceof String && !otraCaracteristica.getCodigootracaracteristica().isEmpty() ? "and CODIGO = '"  + otraCaracteristica.getCodigootracaracteristica() + "' " : "");
			query.append(otraCaracteristica.getNombreotracaracteristica() instanceof String && !otraCaracteristica.getNombreotracaracteristica().isEmpty() ? "and NOMBRE = '" + otraCaracteristica.getNombreotracaracteristica() + "' " : "");
			
			listOtraCaracteristica = (List<Otracaracteristica>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOtraCaracteristica;
	}
	
	@SuppressWarnings("unchecked")
	public List<Otracaracteristica> getAllNotIsNullBy(Otracaracteristica otraCaracteristica) throws DAOException {
		LOG.debug("OtraCaracteristicaDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Otracaracteristica> listOtraCaracteristica = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Otracaracteristica  where 1 = 1 ");
			query.append(otraCaracteristica.getCodigootracaracteristica() instanceof String && !otraCaracteristica.getCodigootracaracteristica().isEmpty() ? "and CODIGO = '"  + otraCaracteristica.getCodigootracaracteristica() + "' " : "");
			query.append(otraCaracteristica.getNombreotracaracteristica() instanceof String && !otraCaracteristica.getNombreotracaracteristica().isEmpty() ? "and NOMBRE = '" + otraCaracteristica.getNombreotracaracteristica() + "' " : "");
			
			listOtraCaracteristica = (List<Otracaracteristica>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOtraCaracteristica;
	}
	
	public boolean save(Otracaracteristica obj) throws DAOException {
		LOG.debug("OtraCaracteristicaDao save");
		
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
	
	public boolean update(Otracaracteristica obj) throws DAOException {
		LOG.debug("OtraCaracteristicaDao update");
		
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
		LOG.debug("OtraCaracteristicaDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Otracaracteristica otraCaracteristica = (Otracaracteristica) session.get(Otracaracteristica.class, codigo);
			session.delete(otraCaracteristica);
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