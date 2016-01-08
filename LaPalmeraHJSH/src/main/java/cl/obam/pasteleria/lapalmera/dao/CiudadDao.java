package cl.obam.pasteleria.lapalmera.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Ciudad;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class CiudadDao {
	
	private static final Logger LOG = Logger.getLogger(CiudadDao.class);

	public Ciudad get(String codigo) throws DAOException {
		LOG.debug("CiudadDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Ciudad ciudad = null;
		try {
			tx = session.beginTransaction();		
			ciudad = (Ciudad) session.createQuery("from Ciudad where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return ciudad;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ciudad> getAll() throws DAOException {
		LOG.debug("CiudadDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ciudad> listCiudad = null;
		try {
			tx = session.beginTransaction();		
			listCiudad = (List<Ciudad>) session.createQuery("from Ciudad ").list();
			for(Ciudad ciudad : listCiudad) {
				ciudad.getRegion().getNombre();
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCiudad;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ciudad> getAllEqBy(Ciudad ciudad) throws DAOException {
		LOG.debug("CiudadDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ciudad> listCiudad = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ciudad where 1 = 1 ");
			query.append(ciudad.getCodigo() instanceof String && !ciudad.getCodigo().isEmpty() ? "and CODIGO = '"  + ciudad.getCodigo() + "' " : "");
			query.append(ciudad.getNombre() instanceof String && !ciudad.getCodigo().isEmpty() ? "and NOMBRE = '" + ciudad.getNombre() + "' " : "");
			
			listCiudad = (List<Ciudad>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCiudad;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ciudad> getAllNotEqBy(Ciudad ciudad) throws DAOException {
		LOG.debug("CiudadDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ciudad> listCiudad = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ciudad where 1 = 1 ");
			query.append(ciudad.getCodigo() instanceof String && !ciudad.getCodigo().isEmpty() ? "and CODIGO != '"  + ciudad.getCodigo() + "' " : "");
			query.append(ciudad.getNombre() instanceof String && !ciudad.getCodigo().isEmpty() ? "and NOMBRE != '" + ciudad.getNombre() + "' " : "");
			
			listCiudad = (List<Ciudad>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCiudad;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ciudad> getAllBeginWithBy(Ciudad ciudad) throws DAOException {
		LOG.debug("CiudadDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ciudad> listCiudad = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ciudad  where 1 = 1 ");
			query.append(ciudad.getCodigo() instanceof String && !ciudad.getCodigo().isEmpty() ? "and CODIGO like '" + ciudad.getCodigo() + "%' " : "");
			query.append(ciudad.getNombre() instanceof String && !ciudad.getCodigo().isEmpty() ? "and NOMBRE like '" + ciudad.getNombre() + "%' " : "");
			
			listCiudad = (List<Ciudad>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCiudad;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ciudad> getAllNotBeginWithBy(Ciudad ciudad) throws DAOException {
		LOG.debug("CiudadDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ciudad> listCiudad = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ciudad  where 1 = 1 ");
			query.append(ciudad.getCodigo() instanceof String && !ciudad.getCodigo().isEmpty() ? "and CODIGO not like '" + ciudad.getCodigo() + "%' " : "");
			query.append(ciudad.getNombre() instanceof String && !ciudad.getCodigo().isEmpty() ? "and NOMBRE not like '" + ciudad.getNombre() + "%' " : "");
			
			listCiudad = (List<Ciudad>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCiudad;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ciudad> getAllEndWithBy(Ciudad ciudad) throws DAOException {
		LOG.debug("CiudadDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ciudad> listCiudad = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ciudad  where 1 = 1 ");
			query.append(ciudad.getCodigo() instanceof String && !ciudad.getCodigo().isEmpty() ? "and CODIGO like '%" + ciudad.getCodigo() + "' " : "");
			query.append(ciudad.getNombre() instanceof String && !ciudad.getCodigo().isEmpty() ? "and NOMBRE like '%" + ciudad.getNombre() + "' " : "");
			
			listCiudad = (List<Ciudad>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCiudad;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ciudad> getAllNotEndWithBy(Ciudad ciudad) throws DAOException {
		LOG.debug("CiudadDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ciudad> listCiudad = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ciudad  where 1 = 1 ");
			query.append(ciudad.getCodigo() instanceof String && !ciudad.getCodigo().isEmpty() ? "and CODIGO not like '%" + ciudad.getCodigo() + "' " : "");
			query.append(ciudad.getNombre() instanceof String && !ciudad.getCodigo().isEmpty() ? "and NOMBRE not like '%" + ciudad.getNombre() + "' " : "");
			
			listCiudad = (List<Ciudad>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCiudad;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ciudad> getAllContainBy(Ciudad ciudad) throws DAOException {
		LOG.debug("CiudadDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ciudad> listCiudad = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ciudad  where 1 = 1 ");
			query.append(ciudad.getCodigo() instanceof String && !ciudad.getCodigo().isEmpty() ? "and CODIGO like '%" + ciudad.getCodigo() + "%' " : "");
			query.append(ciudad.getNombre() instanceof String && !ciudad.getCodigo().isEmpty() ? "and NOMBRE like '%" + ciudad.getNombre() + "%' " : "");
			
			listCiudad = (List<Ciudad>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCiudad;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ciudad> getAllNotContainBy(Ciudad ciudad) throws DAOException {
		LOG.debug("CiudadDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ciudad> listCiudad = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ciudad  where 1 = 1 ");
			query.append(ciudad.getCodigo() instanceof String && !ciudad.getCodigo().isEmpty() ? "and CODIGO not like '%" + ciudad.getCodigo() + "%' " : "");
			query.append(ciudad.getNombre() instanceof String && !ciudad.getCodigo().isEmpty() ? "and NOMBRE not like '%" + ciudad.getNombre() + "%' " : "");
			
			listCiudad = (List<Ciudad>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCiudad;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ciudad> getAllIsNullBy(Ciudad ciudad) throws DAOException {
		LOG.debug("CiudadDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ciudad> listCiudad = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ciudad  where 1 = 1 ");
			query.append(ciudad.getCodigo() instanceof String && !ciudad.getCodigo().isEmpty() ? "and CODIGO = null " : "");
			query.append(ciudad.getNombre() instanceof String && !ciudad.getCodigo().isEmpty() ? "and NOMBRE = null " : "");
			
			listCiudad = (List<Ciudad>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCiudad;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ciudad> getAllNotIsNullBy(Ciudad ciudad) throws DAOException {
		LOG.debug("CiudadDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ciudad> listCiudad = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ciudad  where 1 = 1 ");
			query.append(ciudad.getCodigo() instanceof String && !ciudad.getCodigo().isEmpty() ? "and CODIGO not like null " : "");
			query.append(ciudad.getNombre() instanceof String && !ciudad.getCodigo().isEmpty() ? "and NOMBRE not like null " : "");
			
			listCiudad = (List<Ciudad>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCiudad;
	}
	
	public boolean save(Ciudad obj) throws DAOException {
		LOG.debug("CiudadDao save");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		    session.save(obj);
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
	
	public boolean update(Ciudad obj) throws DAOException {
		LOG.debug("CiudadDao update");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		    session.update(obj);
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
	
	public boolean delete(String id) throws DAOException {
		LOG.debug("CiudadDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Ciudad ciudad = (Ciudad) session.get(Ciudad.class, id);
			session.delete(ciudad);
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
