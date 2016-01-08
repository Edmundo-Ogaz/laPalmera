package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Detalleentregainsumo;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class DetalleEntregaInsumoDao {
	
	private static final Logger LOG = Logger.getLogger(DetalleEntregaInsumoDao.class);

	public Detalleentregainsumo get(String codigo) throws DAOException {
		LOG.debug("DetalleEntregaInsumoDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Detalleentregainsumo detalleEntregaInsumo = null;
		try {
			tx = session.beginTransaction();		
			detalleEntregaInsumo = (Detalleentregainsumo) session.createQuery("from Detalleentregainsumo where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return detalleEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalleentregainsumo> getAll() throws DAOException {
		LOG.debug("DetalleEntregaInsumoDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalleentregainsumo> listDetalleEntregaInsumo = null;
		try {
			tx = session.beginTransaction();		
			listDetalleEntregaInsumo = (List<Detalleentregainsumo>) session.createQuery("from Detalleentregainsumo ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalleentregainsumo> getAllEqBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		LOG.debug("DetalleEntregaInsumoDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalleentregainsumo> listDetalleEntregaInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalleentregainsumo where 1 = 1 ");
			query.append(detalleEntregaInsumo.getCorrelativoentregainsumo() != 0 ? "and CODIGO = '"  + detalleEntregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(detalleEntregaInsumo.getUnidadmedida() != null && detalleEntregaInsumo.getUnidadmedida().getCodigo() instanceof String && !detalleEntregaInsumo.getUnidadmedida().getCodigo().isEmpty() ? "and NOMBRE = '" + detalleEntregaInsumo.getUnidadmedida().getCodigo() + "' " : "");
			
			listDetalleEntregaInsumo = (List<Detalleentregainsumo>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalleentregainsumo> getAllNotEqBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		LOG.debug("DetalleEntregaInsumoDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalleentregainsumo> listDetalleEntregaInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalleentregainsumo where 1 = 1 ");
			query.append(detalleEntregaInsumo.getCorrelativoentregainsumo() != 0 ? "and CODIGO = '"  + detalleEntregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(detalleEntregaInsumo.getUnidadmedida() != null && detalleEntregaInsumo.getUnidadmedida().getCodigo() instanceof String && !detalleEntregaInsumo.getUnidadmedida().getCodigo().isEmpty() ? "and NOMBRE = '" + detalleEntregaInsumo.getUnidadmedida().getCodigo() + "' " : "");
			
			listDetalleEntregaInsumo = (List<Detalleentregainsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalleentregainsumo> getAllBeginWithBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		LOG.debug("DetalleEntregaInsumoDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalleentregainsumo> listDetalleEntregaInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalleentregainsumo  where 1 = 1 ");
			query.append(detalleEntregaInsumo.getCorrelativoentregainsumo() != 0 ? "and CODIGO = '"  + detalleEntregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(detalleEntregaInsumo.getUnidadmedida() != null && detalleEntregaInsumo.getUnidadmedida().getCodigo() instanceof String && !detalleEntregaInsumo.getUnidadmedida().getCodigo().isEmpty() ? "and NOMBRE = '" + detalleEntregaInsumo.getUnidadmedida().getCodigo() + "' " : "");
			
			listDetalleEntregaInsumo = (List<Detalleentregainsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalleentregainsumo> getAllNotBeginWithBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		LOG.debug("DetalleEntregaInsumoDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalleentregainsumo> listDetalleEntregaInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalleentregainsumo  where 1 = 1 ");
			query.append(detalleEntregaInsumo.getCorrelativoentregainsumo() != 0 ? "and CODIGO = '"  + detalleEntregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(detalleEntregaInsumo.getUnidadmedida() != null && detalleEntregaInsumo.getUnidadmedida().getCodigo() instanceof String && !detalleEntregaInsumo.getUnidadmedida().getCodigo().isEmpty() ? "and NOMBRE = '" + detalleEntregaInsumo.getUnidadmedida().getCodigo() + "' " : "");
			
			listDetalleEntregaInsumo = (List<Detalleentregainsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalleentregainsumo> getAllEndWithBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		LOG.debug("DetalleEntregaInsumoDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalleentregainsumo> listDetalleEntregaInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalleentregainsumo  where 1 = 1 ");
			query.append(detalleEntregaInsumo.getCorrelativoentregainsumo() != 0 ? "and CODIGO = '"  + detalleEntregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(detalleEntregaInsumo.getUnidadmedida() != null && detalleEntregaInsumo.getUnidadmedida().getCodigo() instanceof String && !detalleEntregaInsumo.getUnidadmedida().getCodigo().isEmpty() ? "and NOMBRE = '" + detalleEntregaInsumo.getUnidadmedida().getCodigo() + "' " : "");
			
			listDetalleEntregaInsumo = (List<Detalleentregainsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalleentregainsumo> getAllNotEndWithBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		LOG.debug("DetalleEntregaInsumoDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalleentregainsumo> listDetalleEntregaInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalleentregainsumo  where 1 = 1 ");
			query.append(detalleEntregaInsumo.getCorrelativoentregainsumo() != 0 ? "and CODIGO = '"  + detalleEntregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(detalleEntregaInsumo.getUnidadmedida() != null && detalleEntregaInsumo.getUnidadmedida().getCodigo() instanceof String && !detalleEntregaInsumo.getUnidadmedida().getCodigo().isEmpty() ? "and NOMBRE = '" + detalleEntregaInsumo.getUnidadmedida().getCodigo() + "' " : "");
			
			listDetalleEntregaInsumo = (List<Detalleentregainsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalleentregainsumo> getAllContainBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		LOG.debug("DetalleEntregaInsumoDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalleentregainsumo> listDetalleEntregaInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalleentregainsumo  where 1 = 1 ");
			query.append(detalleEntregaInsumo.getCorrelativoentregainsumo() != 0 ? "and CODIGO = '"  + detalleEntregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(detalleEntregaInsumo.getUnidadmedida() != null && detalleEntregaInsumo.getUnidadmedida().getCodigo() instanceof String && !detalleEntregaInsumo.getUnidadmedida().getCodigo().isEmpty() ? "and NOMBRE = '" + detalleEntregaInsumo.getUnidadmedida().getCodigo() + "' " : "");
			
			listDetalleEntregaInsumo = (List<Detalleentregainsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalleentregainsumo> getAllNotContainBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		LOG.debug("DetalleEntregaInsumoDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalleentregainsumo> listDetalleEntregaInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalleentregainsumo  where 1 = 1 ");
			query.append(detalleEntregaInsumo.getCorrelativoentregainsumo() != 0 ? "and CODIGO = '"  + detalleEntregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(detalleEntregaInsumo.getUnidadmedida() != null && detalleEntregaInsumo.getUnidadmedida().getCodigo() instanceof String && !detalleEntregaInsumo.getUnidadmedida().getCodigo().isEmpty() ? "and NOMBRE = '" + detalleEntregaInsumo.getUnidadmedida().getCodigo() + "' " : "");
			
			listDetalleEntregaInsumo = (List<Detalleentregainsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalleentregainsumo> getAllIsNullBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		LOG.debug("DetalleEntregaInsumoDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalleentregainsumo> listDetalleEntregaInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalleentregainsumo  where 1 = 1 ");
			query.append(detalleEntregaInsumo.getCorrelativoentregainsumo() != 0 ? "and CODIGO = '"  + detalleEntregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(detalleEntregaInsumo.getUnidadmedida() != null && detalleEntregaInsumo.getUnidadmedida().getCodigo() instanceof String && !detalleEntregaInsumo.getUnidadmedida().getCodigo().isEmpty() ? "and NOMBRE = '" + detalleEntregaInsumo.getUnidadmedida().getCodigo() + "' " : "");
			
			listDetalleEntregaInsumo = (List<Detalleentregainsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Detalleentregainsumo> getAllNotIsNullBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		LOG.debug("DetalleEntregaInsumoDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Detalleentregainsumo> listDetalleEntregaInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Detalleentregainsumo  where 1 = 1 ");
			query.append(detalleEntregaInsumo.getCorrelativoentregainsumo() != 0 ? "and CODIGO = '"  + detalleEntregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(detalleEntregaInsumo.getUnidadmedida() != null && detalleEntregaInsumo.getUnidadmedida().getCodigo() instanceof String && !detalleEntregaInsumo.getUnidadmedida().getCodigo().isEmpty() ? "and NOMBRE = '" + detalleEntregaInsumo.getUnidadmedida().getCodigo() + "' " : "");
			
			listDetalleEntregaInsumo = (List<Detalleentregainsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listDetalleEntregaInsumo;
	}
	
	public boolean save(Detalleentregainsumo obj) throws DAOException {
		LOG.debug("DetalleEntregaInsumoDao save");
		
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
					throw new DAOException("Error al grabar Campo y en rollback", e);
				}
			}
			throw new DAOException("Error al Nivel persistencia", e);
		} finally {
			session.close();
		}
		return resp;
	}
	
	public boolean update(Detalleentregainsumo obj) throws DAOException {
		LOG.debug("DetalleEntregaInsumoDao update");
		
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
		LOG.debug("DetalleEntregaInsumoDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Detalleentregainsumo detalleEntregaInsumo = (Detalleentregainsumo) session.get(Detalleentregainsumo.class, codigo);
			session.delete(detalleEntregaInsumo);
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