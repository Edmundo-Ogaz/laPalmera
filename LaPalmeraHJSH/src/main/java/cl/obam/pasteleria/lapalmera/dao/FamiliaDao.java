package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Familia;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class FamiliaDao {
	
	private static final Logger LOG = Logger.getLogger(FamiliaDao.class);

	public Familia get(String codigo) throws DAOException {
		LOG.debug("FamiliaDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Familia familia = null;
		try {
			tx = session.beginTransaction();		
			familia = (Familia) session.createQuery("from Familia where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return familia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Familia> getAll() throws DAOException {
		LOG.debug("FamiliaDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Familia> listFamilia = null;
		try {
			tx = session.beginTransaction();		
			listFamilia = (List<Familia>) session.createQuery("from Familia ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Familia> getAllEqBy(Familia familia) throws DAOException {
		LOG.debug("FamiliaDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Familia> listFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Familia where 1 = 1 ");
			query.append(familia.getCodigofamilia() instanceof String && !familia.getCodigofamilia().isEmpty() ? "and CODIGO = '"  + familia.getCodigofamilia() + "' " : "");
			query.append(familia.getNombrefamilia() instanceof String && !familia.getNombrefamilia().isEmpty() ? "and NOMBRE = '" + familia.getNombrefamilia() + "' " : "");
			
			listFamilia = (List<Familia>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Familia> getAllNotEqBy(Familia familia) throws DAOException {
		LOG.debug("FamiliaDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Familia> listFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Familia where 1 = 1 ");
			query.append(familia.getCodigofamilia() instanceof String && !familia.getCodigofamilia().isEmpty() ? "and CODIGO = '"  + familia.getCodigofamilia() + "' " : "");
			query.append(familia.getNombrefamilia() instanceof String && !familia.getNombrefamilia().isEmpty() ? "and NOMBRE = '" + familia.getNombrefamilia() + "' " : "");
			
			listFamilia = (List<Familia>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Familia> getAllBeginWithBy(Familia familia) throws DAOException {
		LOG.debug("FamiliaDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Familia> listFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Familia  where 1 = 1 ");
			query.append(familia.getCodigofamilia() instanceof String && !familia.getCodigofamilia().isEmpty() ? "and CODIGO = '"  + familia.getCodigofamilia() + "' " : "");
			query.append(familia.getNombrefamilia() instanceof String && !familia.getNombrefamilia().isEmpty() ? "and NOMBRE = '" + familia.getNombrefamilia() + "' " : "");
			
			listFamilia = (List<Familia>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Familia> getAllNotBeginWithBy(Familia familia) throws DAOException {
		LOG.debug("FamiliaDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Familia> listFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Familia  where 1 = 1 ");
			query.append(familia.getCodigofamilia() instanceof String && !familia.getCodigofamilia().isEmpty() ? "and CODIGO = '"  + familia.getCodigofamilia() + "' " : "");
			query.append(familia.getNombrefamilia() instanceof String && !familia.getNombrefamilia().isEmpty() ? "and NOMBRE = '" + familia.getNombrefamilia() + "' " : "");
			
			listFamilia = (List<Familia>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Familia> getAllEndWithBy(Familia familia) throws DAOException {
		LOG.debug("FamiliaDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Familia> listFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Familia  where 1 = 1 ");
			query.append(familia.getCodigofamilia() instanceof String && !familia.getCodigofamilia().isEmpty() ? "and CODIGO = '"  + familia.getCodigofamilia() + "' " : "");
			query.append(familia.getNombrefamilia() instanceof String && !familia.getNombrefamilia().isEmpty() ? "and NOMBRE = '" + familia.getNombrefamilia() + "' " : "");
			
			listFamilia = (List<Familia>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Familia> getAllNotEndWithBy(Familia familia) throws DAOException {
		LOG.debug("FamiliaDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Familia> listFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Familia  where 1 = 1 ");
			query.append(familia.getCodigofamilia() instanceof String && !familia.getCodigofamilia().isEmpty() ? "and CODIGO = '"  + familia.getCodigofamilia() + "' " : "");
			query.append(familia.getNombrefamilia() instanceof String && !familia.getNombrefamilia().isEmpty() ? "and NOMBRE = '" + familia.getNombrefamilia() + "' " : "");
			
			listFamilia = (List<Familia>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Familia> getAllContainBy(Familia familia) throws DAOException {
		LOG.debug("FamiliaDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Familia> listFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Familia  where 1 = 1 ");
			query.append(familia.getCodigofamilia() instanceof String && !familia.getCodigofamilia().isEmpty() ? "and CODIGO = '"  + familia.getCodigofamilia() + "' " : "");
			query.append(familia.getNombrefamilia() instanceof String && !familia.getNombrefamilia().isEmpty() ? "and NOMBRE = '" + familia.getNombrefamilia() + "' " : "");
			
			listFamilia = (List<Familia>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Familia> getAllNotContainBy(Familia familia) throws DAOException {
		LOG.debug("FamiliaDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Familia> listFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Familia  where 1 = 1 ");
			query.append(familia.getCodigofamilia() instanceof String && !familia.getCodigofamilia().isEmpty() ? "and CODIGO = '"  + familia.getCodigofamilia() + "' " : "");
			query.append(familia.getNombrefamilia() instanceof String && !familia.getNombrefamilia().isEmpty() ? "and NOMBRE = '" + familia.getNombrefamilia() + "' " : "");
			
			listFamilia = (List<Familia>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Familia> getAllIsNullBy(Familia familia) throws DAOException {
		LOG.debug("FamiliaDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Familia> listFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Familia  where 1 = 1 ");
			query.append(familia.getCodigofamilia() instanceof String && !familia.getCodigofamilia().isEmpty() ? "and CODIGO = '"  + familia.getCodigofamilia() + "' " : "");
			query.append(familia.getNombrefamilia() instanceof String && !familia.getNombrefamilia().isEmpty() ? "and NOMBRE = '" + familia.getNombrefamilia() + "' " : "");
			
			listFamilia = (List<Familia>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Familia> getAllNotIsNullBy(Familia familia) throws DAOException {
		LOG.debug("FamiliaDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Familia> listFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Familia  where 1 = 1 ");
			query.append(familia.getCodigofamilia() instanceof String && !familia.getCodigofamilia().isEmpty() ? "and CODIGO = '"  + familia.getCodigofamilia() + "' " : "");
			query.append(familia.getNombrefamilia() instanceof String && !familia.getNombrefamilia().isEmpty() ? "and NOMBRE = '" + familia.getNombrefamilia() + "' " : "");
			
			listFamilia = (List<Familia>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFamilia;
	}
	
	public boolean save(Familia obj) throws DAOException {
		LOG.debug("FamiliaDao save");
		
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
	
	public boolean update(Familia obj) throws DAOException {
		LOG.debug("FamiliaDao update");
		
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
		LOG.debug("FamiliaDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Familia familia = (Familia) session.get(Familia.class, codigo);
			session.delete(familia);
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