package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Detalledevolucioninsumo;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class DetalleDevolucionInsumoDao {
	
	private static final Logger LOG = Logger.getLogger(DetalleDevolucionInsumoDao.class);

	public Detalledevolucioninsumo get(String codigo) throws DAOException {
		LOG.debug("DetalleDevolucionInsumoDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Detalledevolucioninsumo Detalledevolucioninsumo = null;
		try {
			tx = session.beginTransaction();		
			Detalledevolucioninsumo = (Detalledevolucioninsumo) session.createQuery("from Detalledevolucioninsumo where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return Detalledevolucioninsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalledevolucioninsumo> getAll() throws DAOException {
		LOG.debug("DetalleDevolucionInsumoDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalledevolucioninsumo> listDetalleDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();		
			listDetalleDevolucionInsumo = (List<Detalledevolucioninsumo>) session.createQuery("from Detalledevolucioninsumo ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalledevolucioninsumo> getAllEqBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		LOG.debug("DetalleDevolucionInsumoDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalledevolucioninsumo> listDetalleDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalledevolucioninsumo where 1 = 1 ");
			query.append(detalleDevolucionInsumo.getCorrelativodevolucioninsumo() != 0 ? "and CODIGO = '"  + detalleDevolucionInsumo.getCorrelativodevolucioninsumo() + "' " : "");
			query.append(detalleDevolucionInsumo.getCantidaddevolucioninsumo() instanceof Integer ? "and NOMBRE = '" + detalleDevolucionInsumo.getCantidaddevolucioninsumo() + "' " : "");
			
			listDetalleDevolucionInsumo = (List<Detalledevolucioninsumo>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalledevolucioninsumo> getAllNotEqBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		LOG.debug("DetalleDevolucionInsumoDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalledevolucioninsumo> listDetalleDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalledevolucioninsumo where 1 = 1 ");
			query.append(detalleDevolucionInsumo.getCorrelativodevolucioninsumo() != 0 ? "and CODIGO = '"  + detalleDevolucionInsumo.getCorrelativodevolucioninsumo() + "' " : "");
			query.append(detalleDevolucionInsumo.getCantidaddevolucioninsumo() instanceof Integer ? "and NOMBRE = '" + detalleDevolucionInsumo.getCantidaddevolucioninsumo() + "' " : "");
			
			listDetalleDevolucionInsumo = (List<Detalledevolucioninsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalledevolucioninsumo> getAllBeginWithBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		LOG.debug("DetalleDevolucionInsumoDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalledevolucioninsumo> listDetalleDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalledevolucioninsumo  where 1 = 1 ");
			query.append(detalleDevolucionInsumo.getCorrelativodevolucioninsumo() != 0 ? "and CODIGO = '"  + detalleDevolucionInsumo.getCorrelativodevolucioninsumo() + "' " : "");
			query.append(detalleDevolucionInsumo.getCantidaddevolucioninsumo() instanceof Integer ? "and NOMBRE = '" + detalleDevolucionInsumo.getCantidaddevolucioninsumo() + "' " : "");
			
			listDetalleDevolucionInsumo = (List<Detalledevolucioninsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalledevolucioninsumo> getAllNotBeginWithBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		LOG.debug("DetalleDevolucionInsumoDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalledevolucioninsumo> listDetalleDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalledevolucioninsumo  where 1 = 1 ");
			query.append(detalleDevolucionInsumo.getCorrelativodevolucioninsumo() != 0 ? "and CODIGO = '"  + detalleDevolucionInsumo.getCorrelativodevolucioninsumo() + "' " : "");
			query.append(detalleDevolucionInsumo.getCantidaddevolucioninsumo() instanceof Integer ? "and NOMBRE = '" + detalleDevolucionInsumo.getCantidaddevolucioninsumo() + "' " : "");
			
			listDetalleDevolucionInsumo = (List<Detalledevolucioninsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalledevolucioninsumo> getAllEndWithBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		LOG.debug("DetalleDevolucionInsumoDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalledevolucioninsumo> listDetalleDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalledevolucioninsumo  where 1 = 1 ");
			query.append(detalleDevolucionInsumo.getCorrelativodevolucioninsumo() != 0 ? "and CODIGO = '"  + detalleDevolucionInsumo.getCorrelativodevolucioninsumo() + "' " : "");
			query.append(detalleDevolucionInsumo.getCantidaddevolucioninsumo() instanceof Integer ? "and NOMBRE = '" + detalleDevolucionInsumo.getCantidaddevolucioninsumo() + "' " : "");
			
			listDetalleDevolucionInsumo = (List<Detalledevolucioninsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalledevolucioninsumo> getAllNotEndWithBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		LOG.debug("DetalleDevolucionInsumoDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalledevolucioninsumo> listDetalleDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalledevolucioninsumo  where 1 = 1 ");
			query.append(detalleDevolucionInsumo.getCorrelativodevolucioninsumo() != 0 ? "and CODIGO = '"  + detalleDevolucionInsumo.getCorrelativodevolucioninsumo() + "' " : "");
			query.append(detalleDevolucionInsumo.getCantidaddevolucioninsumo() instanceof Integer ? "and NOMBRE = '" + detalleDevolucionInsumo.getCantidaddevolucioninsumo() + "' " : "");
			
			listDetalleDevolucionInsumo = (List<Detalledevolucioninsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalledevolucioninsumo> getAllContainBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		LOG.debug("DetalleDevolucionInsumoDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalledevolucioninsumo> listDetalleDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalledevolucioninsumo  where 1 = 1 ");
			query.append(detalleDevolucionInsumo.getCorrelativodevolucioninsumo() != 0 ? "and CODIGO = '"  + detalleDevolucionInsumo.getCorrelativodevolucioninsumo() + "' " : "");
			query.append(detalleDevolucionInsumo.getCantidaddevolucioninsumo() instanceof Integer ? "and NOMBRE = '" + detalleDevolucionInsumo.getCantidaddevolucioninsumo() + "' " : "");
			
			listDetalleDevolucionInsumo = (List<Detalledevolucioninsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalledevolucioninsumo> getAllNotContainBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		LOG.debug("DetalleDevolucionInsumoDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalledevolucioninsumo> listDetalleDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalledevolucioninsumo  where 1 = 1 ");
			query.append(detalleDevolucionInsumo.getCorrelativodevolucioninsumo() != 0 ? "and CODIGO = '"  + detalleDevolucionInsumo.getCorrelativodevolucioninsumo() + "' " : "");
			query.append(detalleDevolucionInsumo.getCantidaddevolucioninsumo() instanceof Integer ? "and NOMBRE = '" + detalleDevolucionInsumo.getCantidaddevolucioninsumo() + "' " : "");
			
			listDetalleDevolucionInsumo = (List<Detalledevolucioninsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalledevolucioninsumo> getAllIsNullBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		LOG.debug("DetalleDevolucionInsumoDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalledevolucioninsumo> listDetalleDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalledevolucioninsumo  where 1 = 1 ");
			query.append(detalleDevolucionInsumo.getCorrelativodevolucioninsumo() != 0 ? "and CODIGO = '"  + detalleDevolucionInsumo.getCorrelativodevolucioninsumo() + "' " : "");
			query.append(detalleDevolucionInsumo.getCantidaddevolucioninsumo() instanceof Integer ? "and NOMBRE = '" + detalleDevolucionInsumo.getCantidaddevolucioninsumo() + "' " : "");
			
			listDetalleDevolucionInsumo = (List<Detalledevolucioninsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleDevolucionInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalledevolucioninsumo> getAllNotIsNullBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		LOG.debug("DetalleDevolucionInsumoDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalledevolucioninsumo> listDetalleDevolucionInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalledevolucioninsumo  where 1 = 1 ");
			query.append(detalleDevolucionInsumo.getCorrelativodevolucioninsumo() != 0 ? "and CODIGO = '"  + detalleDevolucionInsumo.getCorrelativodevolucioninsumo() + "' " : "");
			query.append(detalleDevolucionInsumo.getCantidaddevolucioninsumo() instanceof Integer ? "and NOMBRE = '" + detalleDevolucionInsumo.getCantidaddevolucioninsumo() + "' " : "");
			
			listDetalleDevolucionInsumo = (List<Detalledevolucioninsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleDevolucionInsumo;
	}
	
	public boolean save(Detalledevolucioninsumo obj) throws DAOException {
		LOG.debug("DetalleDevolucionInsumoDao save");
		
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
	
	public boolean update(Detalledevolucioninsumo obj) throws DAOException {
		LOG.debug("DetalleDevolucionInsumoDao update");
		
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
		LOG.debug("DetalleDevolucionInsumoDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Detalledevolucioninsumo detalleDevolucionInsumo = (Detalledevolucioninsumo) session.get(Detalledevolucioninsumo.class, codigo);
			session.delete(detalleDevolucionInsumo);
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