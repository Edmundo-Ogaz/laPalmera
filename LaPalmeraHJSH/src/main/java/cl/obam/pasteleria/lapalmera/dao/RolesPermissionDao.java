package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Rolespermission;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class RolesPermissionDao {
	
	private static final Logger LOG = Logger.getLogger(RolesPermissionDao.class);

	public Rolespermission get(String codigo) throws DAOException {
		LOG.debug("RolesPermissionDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Rolespermission rolesPermission = null;
		try {
			tx = session.beginTransaction();		
			rolesPermission = (Rolespermission) session.createQuery("from Rolespermission where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return rolesPermission;
	}
	
	@SuppressWarnings("unchecked")
	public List<Rolespermission> getAll() throws DAOException {
		LOG.debug("RolesPermissionDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Rolespermission> listRolesPermission = null;
		try {
			tx = session.beginTransaction();		
			listRolesPermission = (List<Rolespermission>) session.createQuery("from Rolespermission ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRolesPermission;
	}
	
	@SuppressWarnings("unchecked")
	public List<Rolespermission> getAllEqBy(Rolespermission rolesPermission) throws DAOException {
		LOG.debug("RolesPermissionDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Rolespermission> listRolesPermission = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Rolespermission where 1 = 1 ");
			query.append(rolesPermission.getId() instanceof Integer ? "and CODIGO = '"  + rolesPermission.getId() + "' " : "");
			query.append(rolesPermission.getRoleName() instanceof String && !rolesPermission.getRoleName().isEmpty() ? "and NOMBRE = '" + rolesPermission.getRoleName() + "' " : "");
			
			listRolesPermission = (List<Rolespermission>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRolesPermission;
	}
	
	@SuppressWarnings("unchecked")
	public List<Rolespermission> getAllNotEqBy(Rolespermission rolesPermission) throws DAOException {
		LOG.debug("RolesPermissionDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Rolespermission> listRolesPermission = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Rolespermission where 1 = 1 ");
			query.append(rolesPermission.getId() instanceof Integer ? "and CODIGO = '"  + rolesPermission.getId() + "' " : "");
			query.append(rolesPermission.getRoleName() instanceof String && !rolesPermission.getRoleName().isEmpty() ? "and NOMBRE = '" + rolesPermission.getRoleName() + "' " : "");
			
			listRolesPermission = (List<Rolespermission>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRolesPermission;
	}
	
	@SuppressWarnings("unchecked")
	public List<Rolespermission> getAllBeginWithBy(Rolespermission rolesPermission) throws DAOException {
		LOG.debug("RolesPermissionDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Rolespermission> listRolesPermission = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Rolespermission  where 1 = 1 ");
			query.append(rolesPermission.getId() instanceof Integer ? "and CODIGO = '"  + rolesPermission.getId() + "' " : "");
			query.append(rolesPermission.getRoleName() instanceof String && !rolesPermission.getRoleName().isEmpty() ? "and NOMBRE = '" + rolesPermission.getRoleName() + "' " : "");
			
			listRolesPermission = (List<Rolespermission>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRolesPermission;
	}
	
	@SuppressWarnings("unchecked")
	public List<Rolespermission> getAllNotBeginWithBy(Rolespermission rolesPermission) throws DAOException {
		LOG.debug("RolesPermissionDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Rolespermission> listRolesPermission = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Rolespermission  where 1 = 1 ");
			query.append(rolesPermission.getId() instanceof Integer ? "and CODIGO = '"  + rolesPermission.getId() + "' " : "");
			query.append(rolesPermission.getRoleName() instanceof String && !rolesPermission.getRoleName().isEmpty() ? "and NOMBRE = '" + rolesPermission.getRoleName() + "' " : "");
			
			listRolesPermission = (List<Rolespermission>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRolesPermission;
	}
	
	@SuppressWarnings("unchecked")
	public List<Rolespermission> getAllEndWithBy(Rolespermission rolesPermission) throws DAOException {
		LOG.debug("RolesPermissionDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Rolespermission> listRolesPermission = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Rolespermission  where 1 = 1 ");
			query.append(rolesPermission.getId() instanceof Integer ? "and CODIGO = '"  + rolesPermission.getId() + "' " : "");
			query.append(rolesPermission.getRoleName() instanceof String && !rolesPermission.getRoleName().isEmpty() ? "and NOMBRE = '" + rolesPermission.getRoleName() + "' " : "");
			
			listRolesPermission = (List<Rolespermission>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRolesPermission;
	}
	
	@SuppressWarnings("unchecked")
	public List<Rolespermission> getAllNotEndWithBy(Rolespermission rolesPermission) throws DAOException {
		LOG.debug("RolesPermissionDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Rolespermission> listRolesPermission = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Rolespermission  where 1 = 1 ");
			query.append(rolesPermission.getId() instanceof Integer ? "and CODIGO = '"  + rolesPermission.getId() + "' " : "");
			query.append(rolesPermission.getRoleName() instanceof String && !rolesPermission.getRoleName().isEmpty() ? "and NOMBRE = '" + rolesPermission.getRoleName() + "' " : "");
			
			listRolesPermission = (List<Rolespermission>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRolesPermission;
	}
	
	@SuppressWarnings("unchecked")
	public List<Rolespermission> getAllContainBy(Rolespermission rolesPermission) throws DAOException {
		LOG.debug("RolesPermissionDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Rolespermission> listRolesPermission = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Rolespermission  where 1 = 1 ");
			query.append(rolesPermission.getId() instanceof Integer ? "and CODIGO = '"  + rolesPermission.getId() + "' " : "");
			query.append(rolesPermission.getRoleName() instanceof String && !rolesPermission.getRoleName().isEmpty() ? "and NOMBRE = '" + rolesPermission.getRoleName() + "' " : "");
			
			listRolesPermission = (List<Rolespermission>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRolesPermission;
	}
	
	@SuppressWarnings("unchecked")
	public List<Rolespermission> getAllNotContainBy(Rolespermission rolesPermission) throws DAOException {
		LOG.debug("RolesPermissionDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Rolespermission> listRolesPermission = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Rolespermission  where 1 = 1 ");
			query.append(rolesPermission.getId() instanceof Integer ? "and CODIGO = '"  + rolesPermission.getId() + "' " : "");
			query.append(rolesPermission.getRoleName() instanceof String && !rolesPermission.getRoleName().isEmpty() ? "and NOMBRE = '" + rolesPermission.getRoleName() + "' " : "");
			
			listRolesPermission = (List<Rolespermission>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRolesPermission;
	}
	
	@SuppressWarnings("unchecked")
	public List<Rolespermission> getAllIsNullBy(Rolespermission rolesPermission) throws DAOException {
		LOG.debug("RolesPermissionDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Rolespermission> listRolesPermission = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Rolespermission  where 1 = 1 ");
			query.append(rolesPermission.getId() instanceof Integer ? "and CODIGO = '"  + rolesPermission.getId() + "' " : "");
			query.append(rolesPermission.getRoleName() instanceof String && !rolesPermission.getRoleName().isEmpty() ? "and NOMBRE = '" + rolesPermission.getRoleName() + "' " : "");
			
			listRolesPermission = (List<Rolespermission>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRolesPermission;
	}
	
	@SuppressWarnings("unchecked")
	public List<Rolespermission> getAllNotIsNullBy(Rolespermission rolesPermission) throws DAOException {
		LOG.debug("RolesPermissionDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Rolespermission> listRolesPermission = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Rolespermission  where 1 = 1 ");
			query.append(rolesPermission.getId() instanceof Integer ? "and CODIGO = '"  + rolesPermission.getId() + "' " : "");
			query.append(rolesPermission.getRoleName() instanceof String && !rolesPermission.getRoleName().isEmpty() ? "and NOMBRE = '" + rolesPermission.getRoleName() + "' " : "");
			
			listRolesPermission = (List<Rolespermission>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listRolesPermission;
	}
	
	public boolean save(Rolespermission obj) throws DAOException {
		LOG.debug("RolesPermissionDao save");
		
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
	
	public boolean update(Rolespermission obj) throws DAOException {
		LOG.debug("RolesPermissionDao update");
		
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
		LOG.debug("RolesPermissionDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Rolespermission rolesPermission = (Rolespermission) session.get(Rolespermission.class, codigo);
			session.delete(rolesPermission);
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