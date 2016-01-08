package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Region;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class RegionDao {
	
	private static final Logger LOG = Logger.getLogger(RegionDao.class);

	public Region get(String codigo) throws DAOException {
		LOG.debug("RegionDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Region region = null;
		try {
			tx = session.beginTransaction();		
			region = (Region) session.createQuery("from Region where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return region;
	}
	
	@SuppressWarnings("unchecked")
	public List<Region> getAll() throws DAOException {
		LOG.debug("RegionDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Region> listRegion = null;
		try {
			tx = session.beginTransaction();		
			listRegion = (List<Region>) session.createQuery("from Region ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRegion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Region> getAllEqBy(Region region) throws DAOException {
		LOG.debug("RegionDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Region> listRegion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Region where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO = '"  + region.getCodigo() + "' " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE = '" + region.getNombre() + "' " : "");
			
			listRegion = (List<Region>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRegion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Region> getAllNotEqBy(Region region) throws DAOException {
		LOG.debug("RegionDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Region> listRegion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Region where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO != '"  + region.getCodigo() + "' " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE != '" + region.getNombre() + "' " : "");
			
			listRegion = (List<Region>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRegion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Region> getAllBeginWithBy(Region region) throws DAOException {
		LOG.debug("RegionDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Region> listRegion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Region  where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO like '" + region.getCodigo() + "%' " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE like '" + region.getNombre() + "%' " : "");
			
			listRegion = (List<Region>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRegion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Region> getAllNotBeginWithBy(Region region) throws DAOException {
		LOG.debug("RegionDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Region> listRegion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Region  where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO not like '" + region.getCodigo() + "%' " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE not like '" + region.getNombre() + "%' " : "");
			
			listRegion = (List<Region>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRegion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Region> getAllEndWithBy(Region region) throws DAOException {
		LOG.debug("RegionDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Region> listRegion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Region  where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO like '%" + region.getCodigo() + "' " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE like '%" + region.getNombre() + "' " : "");
			
			listRegion = (List<Region>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRegion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Region> getAllNotEndWithBy(Region region) throws DAOException {
		LOG.debug("RegionDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Region> listRegion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Region  where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO not like '%" + region.getCodigo() + "' " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE not like '%" + region.getNombre() + "' " : "");
			
			listRegion = (List<Region>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRegion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Region> getAllContainBy(Region region) throws DAOException {
		LOG.debug("RegionDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Region> listRegion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Region  where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO like '%" + region.getCodigo() + "%' " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE like '%" + region.getNombre() + "%' " : "");
			
			listRegion = (List<Region>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRegion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Region> getAllNotContainBy(Region region) throws DAOException {
		LOG.debug("RegionDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Region> listRegion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Region  where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO not like '%" + region.getCodigo() + "%' " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE not like '%" + region.getNombre() + "%' " : "");
			
			listRegion = (List<Region>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRegion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Region> getAllIsNullBy(Region region) throws DAOException {
		LOG.debug("RegionDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Region> listRegion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Region  where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO = null " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE = null " : "");
			
			listRegion = (List<Region>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRegion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Region> getAllNotIsNullBy(Region region) throws DAOException {
		LOG.debug("RegionDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Region> listRegion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Region  where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO not like null " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE not like null " : "");
			
			listRegion = (List<Region>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRegion;
	}
	
	public boolean save(Region obj) throws DAOException {
		LOG.debug("RegionDao save");
		
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
	
	public boolean update(Region obj) throws DAOException {
		LOG.debug("RegionDao update");
		
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
		LOG.debug("RegionDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Region region = (Region) session.get(Region.class, codigo);
			session.delete(region);
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