package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Bodega;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class BodegaDao {
	
	private static final Logger LOG = Logger.getLogger(BodegaDao.class);

	public Bodega get(String codigo) throws DAOException {
		LOG.debug("BodegaDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Bodega bodega = null;
		try {
			tx = session.beginTransaction();		
			bodega = (Bodega) session.createQuery("from Bodega where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return bodega;
	}
	
	@SuppressWarnings("unchecked")
	public List<Bodega> getAll() throws DAOException {
		LOG.debug("BodegaDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Bodega> listBodega = null;
		try {
			tx = session.beginTransaction();		
			listBodega = (List<Bodega>) session.createQuery("from Bodega ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listBodega;
	}
	
	@SuppressWarnings("unchecked")
	public List<Bodega> getAllEqBy(Bodega bodega) throws DAOException {
		LOG.debug("BodegaDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Bodega> listBodega = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Bodega where 1 = 1 ");
			query.append(bodega.getCodigo() instanceof String && !bodega.getCodigo().isEmpty() ? "and CODIGO = '"  + bodega.getCodigo() + "' " : "");
			query.append(bodega.getNombre() instanceof String && !bodega.getCodigo().isEmpty() ? "and NOMBRE = '" + bodega.getNombre() + "' " : "");
			
			listBodega = (List<Bodega>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listBodega;
	}
	
	@SuppressWarnings("unchecked")
	public List<Bodega> getAllNotEqBy(Bodega bodega) throws DAOException {
		LOG.debug("BodegaDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Bodega> listBodega = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Bodega where 1 = 1 ");
			query.append(bodega.getCodigo() instanceof String && !bodega.getCodigo().isEmpty() ? "and CODIGO != '"  + bodega.getCodigo() + "' " : "");
			query.append(bodega.getNombre() instanceof String && !bodega.getCodigo().isEmpty() ? "and NOMBRE != '" + bodega.getNombre() + "' " : "");
			
			listBodega = (List<Bodega>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listBodega;
	}
	
	@SuppressWarnings("unchecked")
	public List<Bodega> getAllBeginWithBy(Bodega bodega) throws DAOException {
		LOG.debug("BodegaDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Bodega> listBodega = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Bodega  where 1 = 1 ");
			query.append(bodega.getCodigo() instanceof String && !bodega.getCodigo().isEmpty() ? "and CODIGO like '" + bodega.getCodigo() + "%' " : "");
			query.append(bodega.getNombre() instanceof String && !bodega.getCodigo().isEmpty() ? "and NOMBRE like '" + bodega.getNombre() + "%' " : "");
			
			listBodega = (List<Bodega>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listBodega;
	}
	
	@SuppressWarnings("unchecked")
	public List<Bodega> getAllNotBeginWithBy(Bodega bodega) throws DAOException {
		LOG.debug("BodegaDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Bodega> listBodega = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Bodega  where 1 = 1 ");
			query.append(bodega.getCodigo() instanceof String && !bodega.getCodigo().isEmpty() ? "and CODIGO not like '" + bodega.getCodigo() + "%' " : "");
			query.append(bodega.getNombre() instanceof String && !bodega.getCodigo().isEmpty() ? "and NOMBRE not like '" + bodega.getNombre() + "%' " : "");
			
			listBodega = (List<Bodega>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listBodega;
	}
	
	@SuppressWarnings("unchecked")
	public List<Bodega> getAllEndWithBy(Bodega bodega) throws DAOException {
		LOG.debug("BodegaDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Bodega> listBodega = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Bodega  where 1 = 1 ");
			query.append(bodega.getCodigo() instanceof String && !bodega.getCodigo().isEmpty() ? "and CODIGO like '%" + bodega.getCodigo() + "' " : "");
			query.append(bodega.getNombre() instanceof String && !bodega.getCodigo().isEmpty() ? "and NOMBRE like '%" + bodega.getNombre() + "' " : "");
			
			listBodega = (List<Bodega>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listBodega;
	}
	
	@SuppressWarnings("unchecked")
	public List<Bodega> getAllNotEndWithBy(Bodega bodega) throws DAOException {
		LOG.debug("BodegaDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Bodega> listBodega = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Bodega  where 1 = 1 ");
			query.append(bodega.getCodigo() instanceof String && !bodega.getCodigo().isEmpty() ? "and CODIGO not like '%" + bodega.getCodigo() + "' " : "");
			query.append(bodega.getNombre() instanceof String && !bodega.getCodigo().isEmpty() ? "and NOMBRE not like '%" + bodega.getNombre() + "' " : "");
			
			listBodega = (List<Bodega>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listBodega;
	}
	
	@SuppressWarnings("unchecked")
	public List<Bodega> getAllContainBy(Bodega bodega) throws DAOException {
		LOG.debug("BodegaDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Bodega> listBodega = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Bodega  where 1 = 1 ");
			query.append(bodega.getCodigo() instanceof String && !bodega.getCodigo().isEmpty() ? "and CODIGO like '%" + bodega.getCodigo() + "%' " : "");
			query.append(bodega.getNombre() instanceof String && !bodega.getCodigo().isEmpty() ? "and NOMBRE like '%" + bodega.getNombre() + "%' " : "");
			
			listBodega = (List<Bodega>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listBodega;
	}
	
	@SuppressWarnings("unchecked")
	public List<Bodega> getAllNotContainBy(Bodega bodega) throws DAOException {
		LOG.debug("BodegaDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Bodega> listBodega = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Bodega  where 1 = 1 ");
			query.append(bodega.getCodigo() instanceof String && !bodega.getCodigo().isEmpty() ? "and CODIGO not like '%" + bodega.getCodigo() + "%' " : "");
			query.append(bodega.getNombre() instanceof String && !bodega.getCodigo().isEmpty() ? "and NOMBRE not like '%" + bodega.getNombre() + "%' " : "");
			
			listBodega = (List<Bodega>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listBodega;
	}
	
	@SuppressWarnings("unchecked")
	public List<Bodega> getAllIsNullBy(Bodega bodega) throws DAOException {
		LOG.debug("BodegaDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Bodega> listBodega = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Bodega  where 1 = 1 ");
			query.append(bodega.getCodigo() instanceof String && !bodega.getCodigo().isEmpty() ? "and CODIGO = null " : "");
			query.append(bodega.getNombre() instanceof String && !bodega.getCodigo().isEmpty() ? "and NOMBRE = null " : "");
			
			listBodega = (List<Bodega>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listBodega;
	}
	
	@SuppressWarnings("unchecked")
	public List<Bodega> getAllNotIsNullBy(Bodega bodega) throws DAOException {
		LOG.debug("BodegaDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Bodega> listBodega = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Bodega  where 1 = 1 ");
			query.append(bodega.getCodigo() instanceof String && !bodega.getCodigo().isEmpty() ? "and CODIGO not like null " : "");
			query.append(bodega.getNombre() instanceof String && !bodega.getCodigo().isEmpty() ? "and NOMBRE not like null " : "");
			
			listBodega = (List<Bodega>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listBodega;
	}
	
	public boolean save(Bodega obj) throws DAOException {
		LOG.debug("BodegaDao save");
		
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
	
	public boolean update(Bodega obj) throws DAOException {
		LOG.debug("BodegaDao update");
		
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
		LOG.debug("BodegaDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Bodega bodega = (Bodega) session.get(Bodega.class, codigo);
			session.delete(bodega);
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