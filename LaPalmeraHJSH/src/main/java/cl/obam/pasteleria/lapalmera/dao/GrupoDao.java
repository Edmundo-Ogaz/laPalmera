package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Grupo;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class GrupoDao {
	
	private static final Logger LOG = Logger.getLogger(GrupoDao.class);

	public Grupo get(String codigo) throws DAOException {
		LOG.debug("GrupoDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Grupo grupo = null;
		try {
			tx = session.beginTransaction();		
			grupo = (Grupo) session.createQuery("from Grupo where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return grupo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Grupo> getAll() throws DAOException {
		LOG.debug("GrupoDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Grupo> listGrupo = null;
		try {
			tx = session.beginTransaction();		
			listGrupo = (List<Grupo>) session.createQuery("from Grupo ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listGrupo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Grupo> getAllEqBy(Grupo grupo) throws DAOException {
		LOG.debug("GrupoDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Grupo> listGrupo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Grupo where 1 = 1 ");
			query.append(grupo.getCodigo() instanceof String && !grupo.getCodigo().isEmpty() ? "and CODIGO = '"  + grupo.getCodigo() + "' " : "");
			query.append(grupo.getNombre() instanceof String && !grupo.getCodigo().isEmpty() ? "and NOMBRE = '" + grupo.getNombre() + "' " : "");
			
			listGrupo = (List<Grupo>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listGrupo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Grupo> getAllNotEqBy(Grupo grupo) throws DAOException {
		LOG.debug("GrupoDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Grupo> listGrupo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Grupo where 1 = 1 ");
			query.append(grupo.getCodigo() instanceof String && !grupo.getCodigo().isEmpty() ? "and CODIGO != '"  + grupo.getCodigo() + "' " : "");
			query.append(grupo.getNombre() instanceof String && !grupo.getCodigo().isEmpty() ? "and NOMBRE != '" + grupo.getNombre() + "' " : "");
			
			listGrupo = (List<Grupo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listGrupo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Grupo> getAllBeginWithBy(Grupo grupo) throws DAOException {
		LOG.debug("GrupoDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Grupo> listGrupo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Grupo  where 1 = 1 ");
			query.append(grupo.getCodigo() instanceof String && !grupo.getCodigo().isEmpty() ? "and CODIGO like '" + grupo.getCodigo() + "%' " : "");
			query.append(grupo.getNombre() instanceof String && !grupo.getCodigo().isEmpty() ? "and NOMBRE like '" + grupo.getNombre() + "%' " : "");
			
			listGrupo = (List<Grupo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listGrupo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Grupo> getAllNotBeginWithBy(Grupo grupo) throws DAOException {
		LOG.debug("GrupoDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Grupo> listGrupo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Grupo  where 1 = 1 ");
			query.append(grupo.getCodigo() instanceof String && !grupo.getCodigo().isEmpty() ? "and CODIGO not like '" + grupo.getCodigo() + "%' " : "");
			query.append(grupo.getNombre() instanceof String && !grupo.getCodigo().isEmpty() ? "and NOMBRE not like '" + grupo.getNombre() + "%' " : "");
			
			listGrupo = (List<Grupo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listGrupo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Grupo> getAllEndWithBy(Grupo grupo) throws DAOException {
		LOG.debug("GrupoDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Grupo> listGrupo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Grupo  where 1 = 1 ");
			query.append(grupo.getCodigo() instanceof String && !grupo.getCodigo().isEmpty() ? "and CODIGO like '%" + grupo.getCodigo() + "' " : "");
			query.append(grupo.getNombre() instanceof String && !grupo.getCodigo().isEmpty() ? "and NOMBRE like '%" + grupo.getNombre() + "' " : "");
			
			listGrupo = (List<Grupo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listGrupo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Grupo> getAllNotEndWithBy(Grupo grupo) throws DAOException {
		LOG.debug("GrupoDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Grupo> listGrupo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Grupo  where 1 = 1 ");
			query.append(grupo.getCodigo() instanceof String && !grupo.getCodigo().isEmpty() ? "and CODIGO not like '%" + grupo.getCodigo() + "' " : "");
			query.append(grupo.getNombre() instanceof String && !grupo.getCodigo().isEmpty() ? "and NOMBRE not like '%" + grupo.getNombre() + "' " : "");
			
			listGrupo = (List<Grupo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listGrupo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Grupo> getAllContainBy(Grupo grupo) throws DAOException {
		LOG.debug("GrupoDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Grupo> listGrupo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Grupo  where 1 = 1 ");
			query.append(grupo.getCodigo() instanceof String && !grupo.getCodigo().isEmpty() ? "and CODIGO like '%" + grupo.getCodigo() + "%' " : "");
			query.append(grupo.getNombre() instanceof String && !grupo.getCodigo().isEmpty() ? "and NOMBRE like '%" + grupo.getNombre() + "%' " : "");
			
			listGrupo = (List<Grupo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listGrupo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Grupo> getAllNotContainBy(Grupo grupo) throws DAOException {
		LOG.debug("GrupoDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Grupo> listGrupo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Grupo  where 1 = 1 ");
			query.append(grupo.getCodigo() instanceof String && !grupo.getCodigo().isEmpty() ? "and CODIGO not like '%" + grupo.getCodigo() + "%' " : "");
			query.append(grupo.getNombre() instanceof String && !grupo.getCodigo().isEmpty() ? "and NOMBRE not like '%" + grupo.getNombre() + "%' " : "");
			
			listGrupo = (List<Grupo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listGrupo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Grupo> getAllIsNullBy(Grupo grupo) throws DAOException {
		LOG.debug("GrupoDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Grupo> listGrupo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Grupo  where 1 = 1 ");
			query.append(grupo.getCodigo() instanceof String && !grupo.getCodigo().isEmpty() ? "and CODIGO = null " : "");
			query.append(grupo.getNombre() instanceof String && !grupo.getCodigo().isEmpty() ? "and NOMBRE = null " : "");
			
			listGrupo = (List<Grupo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listGrupo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Grupo> getAllNotIsNullBy(Grupo grupo) throws DAOException {
		LOG.debug("GrupoDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Grupo> listGrupo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Grupo  where 1 = 1 ");
			query.append(grupo.getCodigo() instanceof String && !grupo.getCodigo().isEmpty() ? "and CODIGO not like null " : "");
			query.append(grupo.getNombre() instanceof String && !grupo.getCodigo().isEmpty() ? "and NOMBRE not like null " : "");
			
			listGrupo = (List<Grupo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listGrupo;
	}
	
	public boolean save(Grupo obj) throws DAOException {
		LOG.debug("GrupoDao save");
		
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
	
	public boolean update(Grupo obj) throws DAOException {
		LOG.debug("GrupoDao update");
		
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
		LOG.debug("GrupoDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Grupo grupo = (Grupo) session.get(Grupo.class, codigo);
			session.delete(grupo);
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