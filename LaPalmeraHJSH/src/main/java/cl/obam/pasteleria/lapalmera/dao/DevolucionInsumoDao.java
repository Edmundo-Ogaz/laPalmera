package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Devolucioninsumo;
import cl.obam.pasteleria.lapalmera.model.Ubicacion;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class DevolucionInsumoDao {
	
	private static final Logger LOG = Logger.getLogger(DevolucionInsumoDao.class);

	public Devolucioninsumo get(String codigo) throws DAOException {
		LOG.debug("DevolucionInsumoDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Devolucioninsumo devolucionInsumo = null;
		try {
			tx = session.beginTransaction();		
			devolucionInsumo = (Devolucioninsumo) session.createQuery("from Devolucioninsumo where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return devolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Devolucioninsumo> getAll() throws DAOException {
		LOG.debug("DevolucionInsumoDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Devolucioninsumo> listDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();		
			listDevolucionInsumo = (List<Devolucioninsumo>) session.createQuery("from Devolucioninsumo ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Devolucioninsumo> getAllEqBy(Devolucioninsumo devolucionInsumo) throws DAOException {
		LOG.debug("DevolucionInsumoDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Devolucioninsumo> listDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Devolucioninsumo where 1 = 1 ");
			query.append(devolucionInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + devolucionInsumo.getCorrelativoentregainsumo() + "' " : "");
			
			listDevolucionInsumo = (List<Devolucioninsumo>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Devolucioninsumo> getAllNotEqBy(Devolucioninsumo devolucionInsumo) throws DAOException {
		LOG.debug("DevolucionInsumoDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Devolucioninsumo> listDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Devolucioninsumo where 1 = 1 ");
			query.append(devolucionInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + devolucionInsumo.getCorrelativoentregainsumo() + "' " : "");
			
			listDevolucionInsumo = (List<Devolucioninsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Devolucioninsumo> getAllBeginWithBy(Devolucioninsumo devolucionInsumo) throws DAOException {
		LOG.debug("DevolucionInsumoDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Devolucioninsumo> listDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Devolucioninsumo  where 1 = 1 ");
			query.append(devolucionInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + devolucionInsumo.getCorrelativoentregainsumo() + "' " : "");
			
			listDevolucionInsumo = (List<Devolucioninsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Devolucioninsumo> getAllNotBeginWithBy(Devolucioninsumo devolucionInsumo) throws DAOException {
		LOG.debug("DevolucionInsumoDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Devolucioninsumo> listDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Devolucioninsumo  where 1 = 1 ");
			query.append(devolucionInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + devolucionInsumo.getCorrelativoentregainsumo() + "' " : "");
			
			listDevolucionInsumo = (List<Devolucioninsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Devolucioninsumo> getAllEndWithBy(Devolucioninsumo devolucionInsumo) throws DAOException {
		LOG.debug("DevolucionInsumoDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Devolucioninsumo> listDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Devolucioninsumo  where 1 = 1 ");
			query.append(devolucionInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + devolucionInsumo.getCorrelativoentregainsumo() + "' " : "");
			
			listDevolucionInsumo = (List<Devolucioninsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Devolucioninsumo> getAllNotEndWithBy(Devolucioninsumo devolucionInsumo) throws DAOException {
		LOG.debug("DevolucionInsumoDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Devolucioninsumo> listDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Devolucioninsumo  where 1 = 1 ");
			query.append(devolucionInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + devolucionInsumo.getCorrelativoentregainsumo() + "' " : "");
			
			listDevolucionInsumo = (List<Devolucioninsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Devolucioninsumo> getAllContainBy(Devolucioninsumo devolucionInsumo) throws DAOException {
		LOG.debug("DevolucionInsumoDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Devolucioninsumo> listDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Devolucioninsumo  where 1 = 1 ");
			query.append(devolucionInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + devolucionInsumo.getCorrelativoentregainsumo() + "' " : "");
			
			listDevolucionInsumo = (List<Devolucioninsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Devolucioninsumo> getAllNotContainBy(Devolucioninsumo devolucionInsumo) throws DAOException {
		LOG.debug("DevolucionInsumoDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Devolucioninsumo> listDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Devolucioninsumo  where 1 = 1 ");
			query.append(devolucionInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + devolucionInsumo.getCorrelativoentregainsumo() + "' " : "");
			
			listDevolucionInsumo = (List<Devolucioninsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Devolucioninsumo> getAllIsNullBy(Devolucioninsumo devolucionInsumo) throws DAOException {
		LOG.debug("DevolucionInsumoDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Devolucioninsumo> listDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Devolucioninsumo  where 1 = 1 ");
			query.append(devolucionInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + devolucionInsumo.getCorrelativoentregainsumo() + "' " : "");
			
			listDevolucionInsumo = (List<Devolucioninsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Devolucioninsumo> getAllNotIsNullBy(Devolucioninsumo devolucionInsumo) throws DAOException {
		LOG.debug("DevolucionInsumoDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Devolucioninsumo> listDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Devolucioninsumo  where 1 = 1 ");
			query.append(devolucionInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + devolucionInsumo.getCorrelativoentregainsumo() + "' " : "");
			
			listDevolucionInsumo = (List<Devolucioninsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDevolucionInsumo;
	}
	
	public boolean save(Devolucioninsumo devolucionInsumo) throws DAOException {
		LOG.debug("DevolucionInsumoDao save");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(devolucionInsumo);
		    session.save(devolucionInsumo.getDetalledevolucioninsumo());
		    session.update(devolucionInsumo.getDetalledevolucioninsumo().getProducto().getStock());
		    for(Ubicacion ubicacion : devolucionInsumo.getDetalledevolucioninsumo().getProducto().getUbicacions()) {
		    		session.save(ubicacion);
		    }
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
	
	public boolean update(Devolucioninsumo obj) throws DAOException {
		LOG.debug("DevolucionInsumoDao update");
		
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
		LOG.debug("DevolucionInsumoDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Devolucioninsumo devolucionInsumo = (Devolucioninsumo) session.get(Devolucioninsumo.class, codigo);
			session.delete(devolucionInsumo);
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