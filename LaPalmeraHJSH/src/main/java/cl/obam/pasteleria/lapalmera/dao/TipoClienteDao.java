package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Tipocliente;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class TipoClienteDao {
	
	private static final Logger LOG = Logger.getLogger(TipoClienteDao.class);

	public Tipocliente get(String codigo) throws DAOException {
		LOG.debug("TipoClienteDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Tipocliente region = null;
		try {
			tx = session.beginTransaction();		
			region = (Tipocliente) session.createQuery("from Tipocliente where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return region;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tipocliente> getAll() throws DAOException {
		LOG.debug("TipoClienteDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Tipocliente> listTipoCliente = null;
		try {
			tx = session.beginTransaction();		
			listTipoCliente = (List<Tipocliente>) session.createQuery("from Tipocliente ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listTipoCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tipocliente> getAllEqBy(Tipocliente region) throws DAOException {
		LOG.debug("TipoClienteDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Tipocliente> listTipoCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Tipocliente where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO = '"  + region.getCodigo() + "' " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE = '" + region.getNombre() + "' " : "");
			
			listTipoCliente = (List<Tipocliente>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listTipoCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tipocliente> getAllNotEqBy(Tipocliente region) throws DAOException {
		LOG.debug("TipoclienteDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Tipocliente> listTipoCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Tipocliente where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO != '"  + region.getCodigo() + "' " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE != '" + region.getNombre() + "' " : "");
			
			listTipoCliente = (List<Tipocliente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listTipoCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tipocliente> getAllBeginWithBy(Tipocliente region) throws DAOException {
		LOG.debug("TipoClienteDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Tipocliente> listTipoCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Tipocliente  where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO like '" + region.getCodigo() + "%' " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE like '" + region.getNombre() + "%' " : "");
			
			listTipoCliente = (List<Tipocliente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listTipoCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tipocliente> getAllNotBeginWithBy(Tipocliente region) throws DAOException {
		LOG.debug("TipoClienteDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Tipocliente> listTipoCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Tipocliente  where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO not like '" + region.getCodigo() + "%' " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE not like '" + region.getNombre() + "%' " : "");
			
			listTipoCliente = (List<Tipocliente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listTipoCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tipocliente> getAllEndWithBy(Tipocliente region) throws DAOException {
		LOG.debug("TipoClienteDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Tipocliente> listTipoCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Tipocliente  where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO like '%" + region.getCodigo() + "' " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE like '%" + region.getNombre() + "' " : "");
			
			listTipoCliente = (List<Tipocliente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listTipoCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tipocliente> getAllNotEndWithBy(Tipocliente region) throws DAOException {
		LOG.debug("TipoClienteDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Tipocliente> listTipoCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Tipocliente  where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO not like '%" + region.getCodigo() + "' " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE not like '%" + region.getNombre() + "' " : "");
			
			listTipoCliente = (List<Tipocliente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listTipoCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tipocliente> getAllContainBy(Tipocliente region) throws DAOException {
		LOG.debug("TipoclienteDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Tipocliente> listTipoCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Tipocliente  where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO like '%" + region.getCodigo() + "%' " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE like '%" + region.getNombre() + "%' " : "");
			
			listTipoCliente = (List<Tipocliente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listTipoCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tipocliente> getAllNotContainBy(Tipocliente region) throws DAOException {
		LOG.debug("TipoclienteDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Tipocliente> listTipoCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Tipocliente  where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO not like '%" + region.getCodigo() + "%' " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE not like '%" + region.getNombre() + "%' " : "");
			
			listTipoCliente = (List<Tipocliente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listTipoCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tipocliente> getAllIsNullBy(Tipocliente region) throws DAOException {
		LOG.debug("TipoClienteDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Tipocliente> listTipoCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Tipocliente  where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO = null " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE = null " : "");
			
			listTipoCliente = (List<Tipocliente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listTipoCliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tipocliente> getAllNotIsNullBy(Tipocliente region) throws DAOException {
		LOG.debug("TipoClienteDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Tipocliente> listTipoCliente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Tipocliente  where 1 = 1 ");
			query.append(region.getCodigo() instanceof String && !region.getCodigo().isEmpty() ? "and CODIGO not like null " : "");
			query.append(region.getNombre() instanceof String && !region.getCodigo().isEmpty() ? "and NOMBRE not like null " : "");
			
			listTipoCliente = (List<Tipocliente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listTipoCliente;
	}
	
	public boolean save(Tipocliente obj) throws DAOException {
		LOG.debug("TipoClienteDao save");
		
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
	
	public boolean update(Tipocliente obj) throws DAOException {
		LOG.debug("TipoClienteDao update");
		
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
		LOG.debug("TipoClienteDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Tipocliente region = (Tipocliente) session.get(Tipocliente.class, codigo);
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