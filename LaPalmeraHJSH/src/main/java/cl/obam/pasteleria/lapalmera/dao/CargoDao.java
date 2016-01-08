package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Cargo;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class CargoDao {
	
	private static final Logger LOG = Logger.getLogger(CargoDao.class);

	public Cargo get(String codigo) throws DAOException {
		LOG.debug("CargoDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Cargo cargo = null;
		try {
			tx = session.beginTransaction();		
			cargo = (Cargo) session.createQuery("from Cargo where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return cargo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cargo> getAll() throws DAOException {
		LOG.debug("CargoDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cargo> listCargo = null;
		try {
			tx = session.beginTransaction();		
			listCargo = (List<Cargo>) session.createQuery("from Cargo ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCargo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cargo> getAllEqBy(Cargo cargo) throws DAOException {
		LOG.debug("CargoDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cargo> listCargo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cargo where 1 = 1 ");
			query.append(cargo.getCodigo() instanceof String && !cargo.getCodigo().isEmpty() ? "and CODIGO = '"  + cargo.getCodigo() + "' " : "");
			query.append(cargo.getNombre() instanceof String && !cargo.getCodigo().isEmpty() ? "and NOMBRE = '" + cargo.getNombre() + "' " : "");
			
			listCargo = (List<Cargo>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCargo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cargo> getAllNotEqBy(Cargo cargo) throws DAOException {
		LOG.debug("CargoDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cargo> listCargo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cargo where 1 = 1 ");
			query.append(cargo.getCodigo() instanceof String && !cargo.getCodigo().isEmpty() ? "and CODIGO != '"  + cargo.getCodigo() + "' " : "");
			query.append(cargo.getNombre() instanceof String && !cargo.getCodigo().isEmpty() ? "and NOMBRE != '" + cargo.getNombre() + "' " : "");
			
			listCargo = (List<Cargo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCargo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cargo> getAllBeginWithBy(Cargo cargo) throws DAOException {
		LOG.debug("CargoDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cargo> listCargo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cargo  where 1 = 1 ");
			query.append(cargo.getCodigo() instanceof String && !cargo.getCodigo().isEmpty() ? "and CODIGO like '" + cargo.getCodigo() + "%' " : "");
			query.append(cargo.getNombre() instanceof String && !cargo.getCodigo().isEmpty() ? "and NOMBRE like '" + cargo.getNombre() + "%' " : "");
			
			listCargo = (List<Cargo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCargo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cargo> getAllNotBeginWithBy(Cargo cargo) throws DAOException {
		LOG.debug("CargoDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cargo> listCargo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cargo  where 1 = 1 ");
			query.append(cargo.getCodigo() instanceof String && !cargo.getCodigo().isEmpty() ? "and CODIGO not like '" + cargo.getCodigo() + "%' " : "");
			query.append(cargo.getNombre() instanceof String && !cargo.getCodigo().isEmpty() ? "and NOMBRE not like '" + cargo.getNombre() + "%' " : "");
			
			listCargo = (List<Cargo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCargo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cargo> getAllEndWithBy(Cargo cargo) throws DAOException {
		LOG.debug("CargoDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cargo> listCargo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cargo  where 1 = 1 ");
			query.append(cargo.getCodigo() instanceof String && !cargo.getCodigo().isEmpty() ? "and CODIGO like '%" + cargo.getCodigo() + "' " : "");
			query.append(cargo.getNombre() instanceof String && !cargo.getCodigo().isEmpty() ? "and NOMBRE like '%" + cargo.getNombre() + "' " : "");
			
			listCargo = (List<Cargo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCargo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cargo> getAllNotEndWithBy(Cargo cargo) throws DAOException {
		LOG.debug("CargoDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cargo> listCargo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cargo  where 1 = 1 ");
			query.append(cargo.getCodigo() instanceof String && !cargo.getCodigo().isEmpty() ? "and CODIGO not like '%" + cargo.getCodigo() + "' " : "");
			query.append(cargo.getNombre() instanceof String && !cargo.getCodigo().isEmpty() ? "and NOMBRE not like '%" + cargo.getNombre() + "' " : "");
			
			listCargo = (List<Cargo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCargo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cargo> getAllContainBy(Cargo cargo) throws DAOException {
		LOG.debug("CargoDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cargo> listCargo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cargo  where 1 = 1 ");
			query.append(cargo.getCodigo() instanceof String && !cargo.getCodigo().isEmpty() ? "and CODIGO like '%" + cargo.getCodigo() + "%' " : "");
			query.append(cargo.getNombre() instanceof String && !cargo.getCodigo().isEmpty() ? "and NOMBRE like '%" + cargo.getNombre() + "%' " : "");
			
			listCargo = (List<Cargo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCargo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cargo> getAllNotContainBy(Cargo cargo) throws DAOException {
		LOG.debug("CargoDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cargo> listCargo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cargo  where 1 = 1 ");
			query.append(cargo.getCodigo() instanceof String && !cargo.getCodigo().isEmpty() ? "and CODIGO not like '%" + cargo.getCodigo() + "%' " : "");
			query.append(cargo.getNombre() instanceof String && !cargo.getCodigo().isEmpty() ? "and NOMBRE not like '%" + cargo.getNombre() + "%' " : "");
			
			listCargo = (List<Cargo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCargo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cargo> getAllIsNullBy(Cargo cargo) throws DAOException {
		LOG.debug("CargoDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cargo> listCargo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cargo  where 1 = 1 ");
			query.append(cargo.getCodigo() instanceof String && !cargo.getCodigo().isEmpty() ? "and CODIGO = null " : "");
			query.append(cargo.getNombre() instanceof String && !cargo.getCodigo().isEmpty() ? "and NOMBRE = null " : "");
			
			listCargo = (List<Cargo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCargo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cargo> getAllNotIsNullBy(Cargo cargo) throws DAOException {
		LOG.debug("CargoDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cargo> listCargo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Cargo  where 1 = 1 ");
			query.append(cargo.getCodigo() instanceof String && !cargo.getCodigo().isEmpty() ? "and CODIGO not like null " : "");
			query.append(cargo.getNombre() instanceof String && !cargo.getCodigo().isEmpty() ? "and NOMBRE not like null " : "");
			
			listCargo = (List<Cargo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCargo;
	}
	
	public boolean save(Cargo obj) throws DAOException {
		LOG.debug("CargoDao save");
		
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
	
	public boolean update(Cargo obj) throws DAOException {
		LOG.debug("CargoDao update");
		
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
		LOG.debug("CargoDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Cargo cargo = (Cargo) session.get(Cargo.class, codigo);
			session.delete(cargo);
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