package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Unidadmedida;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class UnidadMedidaDao {
	
	private static final Logger LOG = Logger.getLogger(UnidadMedidaDao.class);

	public Unidadmedida get(String codigo) throws DAOException {
		LOG.debug("UnidadMedidaDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Unidadmedida unidadMedida = null;
		try {
			tx = session.beginTransaction();		
			unidadMedida = (Unidadmedida) session.createQuery("from Unidadmedida where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return unidadMedida;
	}
	
	@SuppressWarnings("unchecked")
	public List<Unidadmedida> getAll() throws DAOException {
		LOG.debug("UnidadMedidaDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Unidadmedida> listUnidadMedida = null;
		try {
			tx = session.beginTransaction();		
			listUnidadMedida = (List<Unidadmedida>) session.createQuery("from Unidadmedida ").list();
			for(Unidadmedida unidadMedida : listUnidadMedida) {
				unidadMedida.getFamilia().getNombrefamilia();
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUnidadMedida;
	}
	
	@SuppressWarnings("unchecked")
	public List<Unidadmedida> getAllEqBy(Unidadmedida unidadMedida) throws DAOException {
		LOG.debug("UnidadMedidaDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Unidadmedida> listUnidadMedida = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Unidadmedida where 1 = 1 ");
			query.append(unidadMedida.getCodigo() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and CODIGO = '"  + unidadMedida.getCodigo() + "' " : "");
			query.append(unidadMedida.getNombre() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and NOMBRE = '" + unidadMedida.getNombre() + "' " : "");
			query.append(unidadMedida.getFamilia() != null && 
					unidadMedida.getFamilia().getCodigofamilia() instanceof String && 
					!unidadMedida.getFamilia().getCodigofamilia().isEmpty() ? "and familia.codigofamilia = '" + unidadMedida.getFamilia().getCodigofamilia() + "' " : "");
			listUnidadMedida = (List<Unidadmedida>) session.createQuery(query.toString()).list();
			for(Unidadmedida obj : listUnidadMedida) {
				obj.getFamilia().getNombrefamilia();
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUnidadMedida;
	}
	
	@SuppressWarnings("unchecked")
	public List<Unidadmedida> getAllNotEqBy(Unidadmedida unidadMedida) throws DAOException {
		LOG.debug("UnidadMedidaDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Unidadmedida> listUnidadMedida = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Unidadmedida where 1 = 1 ");
			query.append(unidadMedida.getCodigo() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and CODIGO != '"  + unidadMedida.getCodigo() + "' " : "");
			query.append(unidadMedida.getNombre() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and NOMBRE != '" + unidadMedida.getNombre() + "' " : "");
			
			listUnidadMedida = (List<Unidadmedida>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUnidadMedida;
	}
	
	@SuppressWarnings("unchecked")
	public List<Unidadmedida> getAllBeginWithBy(Unidadmedida unidadMedida) throws DAOException {
		LOG.debug("UnidadMedidaDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Unidadmedida> listUnidadMedida = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Unidadmedida  where 1 = 1 ");
			query.append(unidadMedida.getCodigo() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and CODIGO like '" + unidadMedida.getCodigo() + "%' " : "");
			query.append(unidadMedida.getNombre() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and NOMBRE like '" + unidadMedida.getNombre() + "%' " : "");
			
			listUnidadMedida = (List<Unidadmedida>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUnidadMedida;
	}
	
	@SuppressWarnings("unchecked")
	public List<Unidadmedida> getAllNotBeginWithBy(Unidadmedida unidadMedida) throws DAOException {
		LOG.debug("UnidadMedidaDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Unidadmedida> listUnidadMedida = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Unidadmedida  where 1 = 1 ");
			query.append(unidadMedida.getCodigo() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and CODIGO not like '" + unidadMedida.getCodigo() + "%' " : "");
			query.append(unidadMedida.getNombre() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and NOMBRE not like '" + unidadMedida.getNombre() + "%' " : "");
			
			listUnidadMedida = (List<Unidadmedida>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUnidadMedida;
	}
	
	@SuppressWarnings("unchecked")
	public List<Unidadmedida> getAllEndWithBy(Unidadmedida unidadMedida) throws DAOException {
		LOG.debug("UnidadMedidaDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Unidadmedida> listUnidadMedida = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Unidadmedida  where 1 = 1 ");
			query.append(unidadMedida.getCodigo() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and CODIGO like '%" + unidadMedida.getCodigo() + "' " : "");
			query.append(unidadMedida.getNombre() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and NOMBRE like '%" + unidadMedida.getNombre() + "' " : "");
			
			listUnidadMedida = (List<Unidadmedida>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUnidadMedida;
	}
	
	@SuppressWarnings("unchecked")
	public List<Unidadmedida> getAllNotEndWithBy(Unidadmedida unidadMedida) throws DAOException {
		LOG.debug("UnidadMedidaDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Unidadmedida> listUnidadMedida = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Unidadmedida  where 1 = 1 ");
			query.append(unidadMedida.getCodigo() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and CODIGO not like '%" + unidadMedida.getCodigo() + "' " : "");
			query.append(unidadMedida.getNombre() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and NOMBRE not like '%" + unidadMedida.getNombre() + "' " : "");
			
			listUnidadMedida = (List<Unidadmedida>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUnidadMedida;
	}
	
	@SuppressWarnings("unchecked")
	public List<Unidadmedida> getAllContainBy(Unidadmedida unidadMedida) throws DAOException {
		LOG.debug("UnidadMedidaDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Unidadmedida> listUnidadMedida = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Unidadmedida  where 1 = 1 ");
			query.append(unidadMedida.getCodigo() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and CODIGO like '%" + unidadMedida.getCodigo() + "%' " : "");
			query.append(unidadMedida.getNombre() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and NOMBRE like '%" + unidadMedida.getNombre() + "%' " : "");
			
			listUnidadMedida = (List<Unidadmedida>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUnidadMedida;
	}
	
	@SuppressWarnings("unchecked")
	public List<Unidadmedida> getAllNotContainBy(Unidadmedida unidadMedida) throws DAOException {
		LOG.debug("UnidadMedidaDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Unidadmedida> listUnidadMedida = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Unidadmedida  where 1 = 1 ");
			query.append(unidadMedida.getCodigo() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and CODIGO not like '%" + unidadMedida.getCodigo() + "%' " : "");
			query.append(unidadMedida.getNombre() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and NOMBRE not like '%" + unidadMedida.getNombre() + "%' " : "");
			
			listUnidadMedida = (List<Unidadmedida>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUnidadMedida;
	}
	
	@SuppressWarnings("unchecked")
	public List<Unidadmedida> getAllIsNullBy(Unidadmedida unidadMedida) throws DAOException {
		LOG.debug("UnidadMedidaDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Unidadmedida> listUnidadMedida = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Unidadmedida  where 1 = 1 ");
			query.append(unidadMedida.getCodigo() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and CODIGO = null " : "");
			query.append(unidadMedida.getNombre() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and NOMBRE = null " : "");
			
			listUnidadMedida = (List<Unidadmedida>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUnidadMedida;
	}
	
	@SuppressWarnings("unchecked")
	public List<Unidadmedida> getAllNotIsNullBy(Unidadmedida unidadMedida) throws DAOException {
		LOG.debug("UnidadMedidaDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Unidadmedida> listUnidadMedida = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Unidadmedida  where 1 = 1 ");
			query.append(unidadMedida.getCodigo() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and CODIGO not like null " : "");
			query.append(unidadMedida.getNombre() instanceof String && !unidadMedida.getCodigo().isEmpty() ? "and NOMBRE not like null " : "");
			
			listUnidadMedida = (List<Unidadmedida>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUnidadMedida;
	}
	
	public boolean save(Unidadmedida obj) throws DAOException {
		LOG.debug("UnidadMedidaDao save");
		
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
	
	public boolean update(Unidadmedida obj) throws DAOException {
		LOG.debug("UnidadMedidaDao update");
		
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
		LOG.debug("UnidadMedidaDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Unidadmedida unidadMedida = (Unidadmedida) session.get(Unidadmedida.class, codigo);
			session.delete(unidadMedida);
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