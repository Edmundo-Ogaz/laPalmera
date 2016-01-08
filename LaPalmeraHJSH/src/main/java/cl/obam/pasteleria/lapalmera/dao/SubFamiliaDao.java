package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Subfamilia;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class SubFamiliaDao {
	
	private static final Logger LOG = Logger.getLogger(SubFamiliaDao.class);

	public Subfamilia get(String codigo) throws DAOException {
		LOG.debug("SubFamiliaDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Subfamilia subFamilia = null;
		try {
			tx = session.beginTransaction();		
			subFamilia = (Subfamilia) session.createQuery("from Subfamilia where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return subFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Subfamilia> getAll() throws DAOException {
		LOG.debug("SubFamiliaDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Subfamilia> listSubFamilia = null;
		try {
			tx = session.beginTransaction();		
			listSubFamilia = (List<Subfamilia>) session.createQuery("from Subfamilia ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listSubFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Subfamilia> getAllEqBy(Subfamilia subFamilia) throws DAOException {
		LOG.debug("SubFamiliaDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Subfamilia> listSubFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Subfamilia where 1 = 1 ");
			query.append(subFamilia.getCodigosubfamilia() instanceof String && !subFamilia.getCodigosubfamilia().isEmpty() ? "and CODIGO = '"  + subFamilia.getCodigosubfamilia() + "' " : "");
			query.append(subFamilia.getNombresubfamilia() instanceof String && !subFamilia.getNombresubfamilia().isEmpty() ? "and NOMBRE = '" + subFamilia.getNombresubfamilia() + "' " : "");
			
			listSubFamilia = (List<Subfamilia>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listSubFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Subfamilia> getAllNotEqBy(Subfamilia subFamilia) throws DAOException {
		LOG.debug("SubFamiliaDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Subfamilia> listSubFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Subfamilia where 1 = 1 ");
			query.append(subFamilia.getCodigosubfamilia() instanceof String && !subFamilia.getCodigosubfamilia().isEmpty() ? "and CODIGO = '"  + subFamilia.getCodigosubfamilia() + "' " : "");
			query.append(subFamilia.getNombresubfamilia() instanceof String && !subFamilia.getNombresubfamilia().isEmpty() ? "and NOMBRE = '" + subFamilia.getNombresubfamilia() + "' " : "");
			
			listSubFamilia = (List<Subfamilia>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listSubFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Subfamilia> getAllBeginWithBy(Subfamilia subFamilia) throws DAOException {
		LOG.debug("SubFamiliaDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Subfamilia> listSubFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Subfamilia  where 1 = 1 ");
			query.append(subFamilia.getCodigosubfamilia() instanceof String && !subFamilia.getCodigosubfamilia().isEmpty() ? "and CODIGO = '"  + subFamilia.getCodigosubfamilia() + "' " : "");
			query.append(subFamilia.getNombresubfamilia() instanceof String && !subFamilia.getNombresubfamilia().isEmpty() ? "and NOMBRE = '" + subFamilia.getNombresubfamilia() + "' " : "");
			
			listSubFamilia = (List<Subfamilia>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listSubFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Subfamilia> getAllNotBeginWithBy(Subfamilia subFamilia) throws DAOException {
		LOG.debug("SubFamiliaDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Subfamilia> listSubFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Subfamilia  where 1 = 1 ");
			query.append(subFamilia.getCodigosubfamilia() instanceof String && !subFamilia.getCodigosubfamilia().isEmpty() ? "and CODIGO = '"  + subFamilia.getCodigosubfamilia() + "' " : "");
			query.append(subFamilia.getNombresubfamilia() instanceof String && !subFamilia.getNombresubfamilia().isEmpty() ? "and NOMBRE = '" + subFamilia.getNombresubfamilia() + "' " : "");
			
			listSubFamilia = (List<Subfamilia>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listSubFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Subfamilia> getAllEndWithBy(Subfamilia subFamilia) throws DAOException {
		LOG.debug("SubFamiliaDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Subfamilia> listSubFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Subfamilia  where 1 = 1 ");
			query.append(subFamilia.getCodigosubfamilia() instanceof String && !subFamilia.getCodigosubfamilia().isEmpty() ? "and CODIGO = '"  + subFamilia.getCodigosubfamilia() + "' " : "");
			query.append(subFamilia.getNombresubfamilia() instanceof String && !subFamilia.getNombresubfamilia().isEmpty() ? "and NOMBRE = '" + subFamilia.getNombresubfamilia() + "' " : "");
			
			listSubFamilia = (List<Subfamilia>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listSubFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Subfamilia> getAllNotEndWithBy(Subfamilia subFamilia) throws DAOException {
		LOG.debug("SubFamiliaDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Subfamilia> listSubFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Subfamilia  where 1 = 1 ");
			query.append(subFamilia.getCodigosubfamilia() instanceof String && !subFamilia.getCodigosubfamilia().isEmpty() ? "and CODIGO = '"  + subFamilia.getCodigosubfamilia() + "' " : "");
			query.append(subFamilia.getNombresubfamilia() instanceof String && !subFamilia.getNombresubfamilia().isEmpty() ? "and NOMBRE = '" + subFamilia.getNombresubfamilia() + "' " : "");
			
			listSubFamilia = (List<Subfamilia>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listSubFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Subfamilia> getAllContainBy(Subfamilia subFamilia) throws DAOException {
		LOG.debug("SubFamiliaDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Subfamilia> listSubFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Subfamilia  where 1 = 1 ");
			query.append(subFamilia.getCodigosubfamilia() instanceof String && !subFamilia.getCodigosubfamilia().isEmpty() ? "and CODIGO = '"  + subFamilia.getCodigosubfamilia() + "' " : "");
			query.append(subFamilia.getNombresubfamilia() instanceof String && !subFamilia.getNombresubfamilia().isEmpty() ? "and NOMBRE = '" + subFamilia.getNombresubfamilia() + "' " : "");
			
			listSubFamilia = (List<Subfamilia>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listSubFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Subfamilia> getAllNotContainBy(Subfamilia subFamilia) throws DAOException {
		LOG.debug("SubFamiliaDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Subfamilia> listSubFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Subfamilia  where 1 = 1 ");
			query.append(subFamilia.getCodigosubfamilia() instanceof String && !subFamilia.getCodigosubfamilia().isEmpty() ? "and CODIGO = '"  + subFamilia.getCodigosubfamilia() + "' " : "");
			query.append(subFamilia.getNombresubfamilia() instanceof String && !subFamilia.getNombresubfamilia().isEmpty() ? "and NOMBRE = '" + subFamilia.getNombresubfamilia() + "' " : "");
			
			listSubFamilia = (List<Subfamilia>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listSubFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Subfamilia> getAllIsNullBy(Subfamilia subFamilia) throws DAOException {
		LOG.debug("SubFamiliaDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Subfamilia> listSubFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Subfamilia  where 1 = 1 ");
			query.append(subFamilia.getCodigosubfamilia() instanceof String && !subFamilia.getCodigosubfamilia().isEmpty() ? "and CODIGO = '"  + subFamilia.getCodigosubfamilia() + "' " : "");
			query.append(subFamilia.getNombresubfamilia() instanceof String && !subFamilia.getNombresubfamilia().isEmpty() ? "and NOMBRE = '" + subFamilia.getNombresubfamilia() + "' " : "");
			
			listSubFamilia = (List<Subfamilia>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listSubFamilia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Subfamilia> getAllNotIsNullBy(Subfamilia subFamilia) throws DAOException {
		LOG.debug("SubFamiliaDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Subfamilia> listSubFamilia = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Subfamilia  where 1 = 1 ");
			query.append(subFamilia.getCodigosubfamilia() instanceof String && !subFamilia.getCodigosubfamilia().isEmpty() ? "and CODIGO = '"  + subFamilia.getCodigosubfamilia() + "' " : "");
			query.append(subFamilia.getNombresubfamilia() instanceof String && !subFamilia.getNombresubfamilia().isEmpty() ? "and NOMBRE = '" + subFamilia.getNombresubfamilia() + "' " : "");
			
			listSubFamilia = (List<Subfamilia>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listSubFamilia;
	}
	
	public boolean save(Subfamilia obj) throws DAOException {
		LOG.debug("SubFamiliaDao save");
		
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
	
	public boolean update(Subfamilia obj) throws DAOException {
		LOG.debug("SubFamiliaDao update");
		
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
		LOG.debug("SubFamiliaDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Subfamilia subFamilia = (Subfamilia) session.get(Subfamilia.class, codigo);
			session.delete(subFamilia);
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