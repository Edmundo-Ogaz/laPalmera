package cl.obam.pasteleria.lapalmera.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Comuna;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class ComunaDao {
	
	private static final Logger LOG = Logger.getLogger(ComunaDao.class);

	public Comuna get(String codigo) throws DAOException {
		LOG.debug("ComunaDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Comuna comuna = null;
		try {
			tx = session.beginTransaction();		
			comuna = (Comuna) session.createQuery("from Comuna where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return comuna;
	}
	
	@SuppressWarnings("unchecked")
	public List<Comuna> getAll() throws DAOException {
		LOG.debug("ComunaDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Comuna> listComuna = null;
		try {
			tx = session.beginTransaction();		
			listComuna = (List<Comuna>) session.createQuery("from Comuna ").list();
			for(Comuna comuna : listComuna) {
				comuna.getCiudad().getNombre();
				comuna.getCiudad().getRegion().getNombre();
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listComuna;
	}
	
	@SuppressWarnings("unchecked")
	public List<Comuna> getAllEqBy(Comuna comuna) throws DAOException {
		LOG.debug("ComunaDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Comuna> listComuna = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Comuna where 1 = 1 ");
			query.append(comuna.getCodigo() instanceof String && !comuna.getCodigo().isEmpty() ? "and CODIGO = '"  + comuna.getCodigo() + "' " : "");
			query.append(comuna.getNombre() instanceof String && !comuna.getCodigo().isEmpty() ? "and NOMBRE = '" + comuna.getNombre() + "' " : "");
			
			listComuna = (List<Comuna>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listComuna;
	}
	
	@SuppressWarnings("unchecked")
	public List<Comuna> getAllNotEqBy(Comuna comuna) throws DAOException {
		LOG.debug("ComunaDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Comuna> listComuna = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Comuna where 1 = 1 ");
			query.append(comuna.getCodigo() instanceof String && !comuna.getCodigo().isEmpty() ? "and CODIGO != '"  + comuna.getCodigo() + "' " : "");
			query.append(comuna.getNombre() instanceof String && !comuna.getCodigo().isEmpty() ? "and NOMBRE != '" + comuna.getNombre() + "' " : "");
			
			listComuna = (List<Comuna>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listComuna;
	}
	
	@SuppressWarnings("unchecked")
	public List<Comuna> getAllBeginWithBy(Comuna comuna) throws DAOException {
		LOG.debug("ComunaDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Comuna> listComuna = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Comuna  where 1 = 1 ");
			query.append(comuna.getCodigo() instanceof String && !comuna.getCodigo().isEmpty() ? "and CODIGO like '" + comuna.getCodigo() + "%' " : "");
			query.append(comuna.getNombre() instanceof String && !comuna.getCodigo().isEmpty() ? "and NOMBRE like '" + comuna.getNombre() + "%' " : "");
			
			listComuna = (List<Comuna>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listComuna;
	}
	
	@SuppressWarnings("unchecked")
	public List<Comuna> getAllNotBeginWithBy(Comuna comuna) throws DAOException {
		LOG.debug("ComunaDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Comuna> listComuna = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Comuna  where 1 = 1 ");
			query.append(comuna.getCodigo() instanceof String && !comuna.getCodigo().isEmpty() ? "and CODIGO not like '" + comuna.getCodigo() + "%' " : "");
			query.append(comuna.getNombre() instanceof String && !comuna.getCodigo().isEmpty() ? "and NOMBRE not like '" + comuna.getNombre() + "%' " : "");
			
			listComuna = (List<Comuna>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listComuna;
	}
	
	@SuppressWarnings("unchecked")
	public List<Comuna> getAllEndWithBy(Comuna comuna) throws DAOException {
		LOG.debug("ComunaDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Comuna> listComuna = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Comuna  where 1 = 1 ");
			query.append(comuna.getCodigo() instanceof String && !comuna.getCodigo().isEmpty() ? "and CODIGO like '%" + comuna.getCodigo() + "' " : "");
			query.append(comuna.getNombre() instanceof String && !comuna.getCodigo().isEmpty() ? "and NOMBRE like '%" + comuna.getNombre() + "' " : "");
			
			listComuna = (List<Comuna>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listComuna;
	}
	
	@SuppressWarnings("unchecked")
	public List<Comuna> getAllNotEndWithBy(Comuna comuna) throws DAOException {
		LOG.debug("ComunaDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Comuna> listComuna = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Comuna  where 1 = 1 ");
			query.append(comuna.getCodigo() instanceof String && !comuna.getCodigo().isEmpty() ? "and CODIGO not like '%" + comuna.getCodigo() + "' " : "");
			query.append(comuna.getNombre() instanceof String && !comuna.getCodigo().isEmpty() ? "and NOMBRE not like '%" + comuna.getNombre() + "' " : "");
			
			listComuna = (List<Comuna>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listComuna;
	}
	
	@SuppressWarnings("unchecked")
	public List<Comuna> getAllContainBy(Comuna comuna) throws DAOException {
		LOG.debug("ComunaDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Comuna> listComuna = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Comuna  where 1 = 1 ");
			query.append(comuna.getCodigo() instanceof String && !comuna.getCodigo().isEmpty() ? "and CODIGO like '%" + comuna.getCodigo() + "%' " : "");
			query.append(comuna.getNombre() instanceof String && !comuna.getCodigo().isEmpty() ? "and NOMBRE like '%" + comuna.getNombre() + "%' " : "");
			
			listComuna = (List<Comuna>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listComuna;
	}
	
	@SuppressWarnings("unchecked")
	public List<Comuna> getAllNotContainBy(Comuna comuna) throws DAOException {
		LOG.debug("ComunaDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Comuna> listComuna = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Comuna  where 1 = 1 ");
			query.append(comuna.getCodigo() instanceof String && !comuna.getCodigo().isEmpty() ? "and CODIGO not like '%" + comuna.getCodigo() + "%' " : "");
			query.append(comuna.getNombre() instanceof String && !comuna.getCodigo().isEmpty() ? "and NOMBRE not like '%" + comuna.getNombre() + "%' " : "");
			
			listComuna = (List<Comuna>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listComuna;
	}
	
	@SuppressWarnings("unchecked")
	public List<Comuna> getAllIsNullBy(Comuna comuna) throws DAOException {
		LOG.debug("ComunaDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Comuna> listComuna = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Comuna  where 1 = 1 ");
			query.append(comuna.getCodigo() instanceof String && !comuna.getCodigo().isEmpty() ? "and CODIGO = null " : "");
			query.append(comuna.getNombre() instanceof String && !comuna.getCodigo().isEmpty() ? "and NOMBRE = null " : "");
			
			listComuna = (List<Comuna>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listComuna;
	}
	
	@SuppressWarnings("unchecked")
	public List<Comuna> getAllNotIsNullBy(Comuna comuna) throws DAOException {
		LOG.debug("ComunaDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Comuna> listComuna = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Comuna  where 1 = 1 ");
			query.append(comuna.getCodigo() instanceof String && !comuna.getCodigo().isEmpty() ? "and CODIGO not like null " : "");
			query.append(comuna.getNombre() instanceof String && !comuna.getCodigo().isEmpty() ? "and NOMBRE not like null " : "");
			
			listComuna = (List<Comuna>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listComuna;
	}
	
	public boolean save(Comuna obj) throws DAOException {
		LOG.debug("ComunaDao save");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		    session.save(obj);
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
	
	public boolean update(Comuna obj) throws DAOException {
		LOG.debug("ComunaDao update");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		    session.update(obj);
		    tx.commit();
		    resp = false;
		}catch (Exception e) {
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
	
	public boolean delete(String id) throws DAOException {
		LOG.debug("ComunaDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Comuna comuna = (Comuna) session.get(Comuna.class, id);
			session.delete(comuna);
		    tx.commit();
		    resp = true;
		}catch (Exception e) {
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