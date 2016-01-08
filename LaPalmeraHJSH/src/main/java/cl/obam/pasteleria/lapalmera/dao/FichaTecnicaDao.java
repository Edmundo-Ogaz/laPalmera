package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Fichatecnica;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class FichaTecnicaDao {
	
	private static final Logger LOG = Logger.getLogger(FichaTecnicaDao.class);

	public Fichatecnica get(String codigo) throws DAOException {
		LOG.debug("FichaTecnicaDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Fichatecnica fichaTecnica = null;
		try {
			tx = session.beginTransaction();		
			fichaTecnica = (Fichatecnica) session.createQuery("from Fichatecnica where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return fichaTecnica;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fichatecnica> getAll() throws DAOException {
		LOG.debug("FichaTecnicaDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Fichatecnica> listArea = null;
		try {
			tx = session.beginTransaction();		
			listArea = (List<Fichatecnica>) session.createQuery("from Fichatecnica ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fichatecnica> getAllEqBy(Fichatecnica fichaTecnica) throws DAOException {
		LOG.debug("FichaTecnicaDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Fichatecnica> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Fichatecnica where 1 = 1 ");
			query.append(fichaTecnica.getDescripcion() instanceof String && !fichaTecnica.getDescripcion().isEmpty() ? "and CODIGO = '"  + fichaTecnica.getDescripcion() + "' " : "");
			
			listArea = (List<Fichatecnica>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fichatecnica> getAllNotEqBy(Fichatecnica fichaTecnica) throws DAOException {
		LOG.debug("FichaTecnicaDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Fichatecnica> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Fichatecnica where 1 = 1 ");
			query.append(fichaTecnica.getDescripcion() instanceof String && !fichaTecnica.getDescripcion().isEmpty() ? "and CODIGO = '"  + fichaTecnica.getDescripcion() + "' " : "");
			
			listArea = (List<Fichatecnica>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fichatecnica> getAllBeginWithBy(Fichatecnica fichaTecnica) throws DAOException {
		LOG.debug("FichaTecnicaDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Fichatecnica> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Fichatecnica  where 1 = 1 ");
			query.append(fichaTecnica.getDescripcion() instanceof String && !fichaTecnica.getDescripcion().isEmpty() ? "and CODIGO = '"  + fichaTecnica.getDescripcion() + "' " : "");
			
			listArea = (List<Fichatecnica>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fichatecnica> getAllNotBeginWithBy(Fichatecnica fichaTecnica) throws DAOException {
		LOG.debug("FichaTecnicaDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Fichatecnica> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Fichatecnica  where 1 = 1 ");
			query.append(fichaTecnica.getDescripcion() instanceof String && !fichaTecnica.getDescripcion().isEmpty() ? "and CODIGO = '"  + fichaTecnica.getDescripcion() + "' " : "");
			
			listArea = (List<Fichatecnica>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fichatecnica> getAllEndWithBy(Fichatecnica fichaTecnica) throws DAOException {
		LOG.debug("FichaTecnicaDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Fichatecnica> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Fichatecnica  where 1 = 1 ");
			query.append(fichaTecnica.getDescripcion() instanceof String && !fichaTecnica.getDescripcion().isEmpty() ? "and CODIGO = '"  + fichaTecnica.getDescripcion() + "' " : "");
			
			listArea = (List<Fichatecnica>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fichatecnica> getAllNotEndWithBy(Fichatecnica fichaTecnica) throws DAOException {
		LOG.debug("FichaTecnicaDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Fichatecnica> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Fichatecnica  where 1 = 1 ");
			query.append(fichaTecnica.getDescripcion() instanceof String && !fichaTecnica.getDescripcion().isEmpty() ? "and CODIGO = '"  + fichaTecnica.getDescripcion() + "' " : "");
			
			listArea = (List<Fichatecnica>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fichatecnica> getAllContainBy(Fichatecnica fichaTecnica) throws DAOException {
		LOG.debug("FichaTecnicaDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Fichatecnica> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Fichatecnica  where 1 = 1 ");
			query.append(fichaTecnica.getDescripcion() instanceof String && !fichaTecnica.getDescripcion().isEmpty() ? "and CODIGO = '"  + fichaTecnica.getDescripcion() + "' " : "");
			
			listArea = (List<Fichatecnica>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fichatecnica> getAllNotContainBy(Fichatecnica fichaTecnica) throws DAOException {
		LOG.debug("FichaTecnicaDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Fichatecnica> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Fichatecnica  where 1 = 1 ");
			query.append(fichaTecnica.getDescripcion() instanceof String && !fichaTecnica.getDescripcion().isEmpty() ? "and CODIGO = '"  + fichaTecnica.getDescripcion() + "' " : "");
			
			listArea = (List<Fichatecnica>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fichatecnica> getAllIsNullBy(Fichatecnica fichaTecnica) throws DAOException {
		LOG.debug("FichaTecnicaDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Fichatecnica> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Fichatecnica  where 1 = 1 ");
			query.append(fichaTecnica.getDescripcion() instanceof String && !fichaTecnica.getDescripcion().isEmpty() ? "and CODIGO = '"  + fichaTecnica.getDescripcion() + "' " : "");
			
			listArea = (List<Fichatecnica>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fichatecnica> getAllNotIsNullBy(Fichatecnica fichaTecnica) throws DAOException {
		LOG.debug("FichaTecnicaDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Fichatecnica> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Fichatecnica  where 1 = 1 ");
			query.append(fichaTecnica.getDescripcion() instanceof String && !fichaTecnica.getDescripcion().isEmpty() ? "and CODIGO = '"  + fichaTecnica.getDescripcion() + "' " : "");
			
			listArea = (List<Fichatecnica>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	public boolean save(Fichatecnica obj) throws DAOException {
		LOG.debug("FichaTecnicaDao save");
		
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
	
	public boolean update(Fichatecnica obj) throws DAOException {
		LOG.debug("FichaTecnicaDao update");
		
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
		LOG.debug("FichaTecnicaDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Fichatecnica fichaTecnica = (Fichatecnica) session.get(Fichatecnica.class, codigo);
			session.delete(fichaTecnica);
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