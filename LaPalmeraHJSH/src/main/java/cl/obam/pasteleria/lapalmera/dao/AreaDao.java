package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Area;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class AreaDao {
	
	private static final Logger LOG = Logger.getLogger(AreaDao.class);

	public Area get(String codigo) throws DAOException {
		LOG.debug("AreaDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Area area = null;
		try {
			tx = session.beginTransaction();		
			area = (Area) session.createQuery("from Area where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return area;
	}
	
	@SuppressWarnings("unchecked")
	public List<Area> getAll() throws DAOException {
		LOG.debug("AreaDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Area> listArea = null;
		try {
			tx = session.beginTransaction();		
			listArea = (List<Area>) session.createQuery("from Area ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Area> getAllEqBy(Area area) throws DAOException {
		LOG.debug("AreaDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Area> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Area where 1 = 1 ");
			query.append(area.getCodigo() instanceof String && !area.getCodigo().isEmpty() ? "and CODIGO = '"  + area.getCodigo() + "' " : "");
			query.append(area.getNombre() instanceof String && !area.getCodigo().isEmpty() ? "and NOMBRE = '" + area.getNombre() + "' " : "");
			
			listArea = (List<Area>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Area> getAllNotEqBy(Area area) throws DAOException {
		LOG.debug("AreaDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Area> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Area where 1 = 1 ");
			query.append(area.getCodigo() instanceof String && !area.getCodigo().isEmpty() ? "and CODIGO != '"  + area.getCodigo() + "' " : "");
			query.append(area.getNombre() instanceof String && !area.getCodigo().isEmpty() ? "and NOMBRE != '" + area.getNombre() + "' " : "");
			
			listArea = (List<Area>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Area> getAllBeginWithBy(Area area) throws DAOException {
		LOG.debug("AreaDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Area> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Area  where 1 = 1 ");
			query.append(area.getCodigo() instanceof String && !area.getCodigo().isEmpty() ? "and CODIGO like '" + area.getCodigo() + "%' " : "");
			query.append(area.getNombre() instanceof String && !area.getCodigo().isEmpty() ? "and NOMBRE like '" + area.getNombre() + "%' " : "");
			
			listArea = (List<Area>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Area> getAllNotBeginWithBy(Area area) throws DAOException {
		LOG.debug("AreaDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Area> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Area  where 1 = 1 ");
			query.append(area.getCodigo() instanceof String && !area.getCodigo().isEmpty() ? "and CODIGO not like '" + area.getCodigo() + "%' " : "");
			query.append(area.getNombre() instanceof String && !area.getCodigo().isEmpty() ? "and NOMBRE not like '" + area.getNombre() + "%' " : "");
			
			listArea = (List<Area>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Area> getAllEndWithBy(Area area) throws DAOException {
		LOG.debug("AreaDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Area> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Area  where 1 = 1 ");
			query.append(area.getCodigo() instanceof String && !area.getCodigo().isEmpty() ? "and CODIGO like '%" + area.getCodigo() + "' " : "");
			query.append(area.getNombre() instanceof String && !area.getCodigo().isEmpty() ? "and NOMBRE like '%" + area.getNombre() + "' " : "");
			
			listArea = (List<Area>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Area> getAllNotEndWithBy(Area area) throws DAOException {
		LOG.debug("AreaDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Area> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Area  where 1 = 1 ");
			query.append(area.getCodigo() instanceof String && !area.getCodigo().isEmpty() ? "and CODIGO not like '%" + area.getCodigo() + "' " : "");
			query.append(area.getNombre() instanceof String && !area.getCodigo().isEmpty() ? "and NOMBRE not like '%" + area.getNombre() + "' " : "");
			
			listArea = (List<Area>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Area> getAllContainBy(Area area) throws DAOException {
		LOG.debug("AreaDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Area> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Area  where 1 = 1 ");
			query.append(area.getCodigo() instanceof String && !area.getCodigo().isEmpty() ? "and CODIGO like '%" + area.getCodigo() + "%' " : "");
			query.append(area.getNombre() instanceof String && !area.getCodigo().isEmpty() ? "and NOMBRE like '%" + area.getNombre() + "%' " : "");
			
			listArea = (List<Area>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Area> getAllNotContainBy(Area area) throws DAOException {
		LOG.debug("AreaDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Area> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Area  where 1 = 1 ");
			query.append(area.getCodigo() instanceof String && !area.getCodigo().isEmpty() ? "and CODIGO not like '%" + area.getCodigo() + "%' " : "");
			query.append(area.getNombre() instanceof String && !area.getCodigo().isEmpty() ? "and NOMBRE not like '%" + area.getNombre() + "%' " : "");
			
			listArea = (List<Area>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Area> getAllIsNullBy(Area area) throws DAOException {
		LOG.debug("AreaDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Area> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Area  where 1 = 1 ");
			query.append(area.getCodigo() instanceof String && !area.getCodigo().isEmpty() ? "and CODIGO = null " : "");
			query.append(area.getNombre() instanceof String && !area.getCodigo().isEmpty() ? "and NOMBRE = null " : "");
			
			listArea = (List<Area>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Area> getAllNotIsNullBy(Area area) throws DAOException {
		LOG.debug("AreaDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Area> listArea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Area  where 1 = 1 ");
			query.append(area.getCodigo() instanceof String && !area.getCodigo().isEmpty() ? "and CODIGO not like null " : "");
			query.append(area.getNombre() instanceof String && !area.getCodigo().isEmpty() ? "and NOMBRE not like null " : "");
			
			listArea = (List<Area>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listArea;
	}
	
	public boolean save(Area obj) throws DAOException {
		LOG.debug("AreaDao save");
		
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
	
	public boolean update(Area obj) throws DAOException {
		LOG.debug("AreaDao update");
		
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
		LOG.debug("AreaDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Area area = (Area) session.get(Area.class, codigo);
			session.delete(area);
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