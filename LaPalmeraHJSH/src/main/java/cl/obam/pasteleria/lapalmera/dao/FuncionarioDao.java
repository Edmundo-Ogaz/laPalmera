package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Funcionario;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class FuncionarioDao {
	
	private static final Logger LOG = Logger.getLogger(FuncionarioDao.class);

	public Funcionario get(String rutfuncionario) throws DAOException {
		LOG.debug("FuncionarioDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Funcionario funcionario = null;
		try {
			tx = session.beginTransaction();		
			funcionario = (Funcionario) session.createQuery("from Funcionario where rutfuncionario = ?").setString(0, rutfuncionario).uniqueResult();		
			funcionario.getArea().getNombre();
			funcionario.getCargo().getNombre();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return funcionario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> getAll() throws DAOException {
		LOG.debug("FuncionarioDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Funcionario> listFuncionario = null;
		try {
			tx = session.beginTransaction();		
			listFuncionario = (List<Funcionario>) session.createQuery("from Funcionario ").list();
			for(Funcionario funcionario : listFuncionario) {
				funcionario.getArea().getNombre();
				funcionario.getCargo().getNombre();
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFuncionario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> getAllEqBy(Funcionario funcionario) throws DAOException {
		LOG.debug("FuncionarioDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Funcionario> listFuncionario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Funcionario where 1 = 1 ");
			query.append(funcionario.getRutfuncionario() instanceof String && !funcionario.getRutfuncionario().isEmpty() ? "and CODIGO = '"  + funcionario.getRutfuncionario() + "' " : "");
			query.append(funcionario.getNombre() instanceof String && !funcionario.getNombre().isEmpty() ? "and NOMBRE = '" + funcionario.getNombre() + "' " : "");
			
			listFuncionario = (List<Funcionario>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFuncionario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> getAllNotEqBy(Funcionario funcionario) throws DAOException {
		LOG.debug("FuncionarioDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Funcionario> listFuncionario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Funcionario where 1 = 1 ");
			query.append(funcionario.getRutfuncionario() instanceof String && !funcionario.getRutfuncionario().isEmpty() ? "and CODIGO = '"  + funcionario.getRutfuncionario() + "' " : "");
			query.append(funcionario.getNombre() instanceof String && !funcionario.getNombre().isEmpty() ? "and NOMBRE = '" + funcionario.getNombre() + "' " : "");
			
			listFuncionario = (List<Funcionario>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFuncionario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> getAllBeginWithBy(Funcionario funcionario) throws DAOException {
		LOG.debug("FuncionarioDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Funcionario> listFuncionario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Funcionario  where 1 = 1 ");
			query.append(funcionario.getRutfuncionario() instanceof String && !funcionario.getRutfuncionario().isEmpty() ? "and CODIGO = '"  + funcionario.getRutfuncionario() + "' " : "");
			query.append(funcionario.getNombre() instanceof String && !funcionario.getNombre().isEmpty() ? "and NOMBRE = '" + funcionario.getNombre() + "' " : "");
			
			listFuncionario = (List<Funcionario>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFuncionario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> getAllNotBeginWithBy(Funcionario funcionario) throws DAOException {
		LOG.debug("FuncionarioDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Funcionario> listFuncionario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Funcionario  where 1 = 1 ");
			query.append(funcionario.getRutfuncionario() instanceof String && !funcionario.getRutfuncionario().isEmpty() ? "and CODIGO = '"  + funcionario.getRutfuncionario() + "' " : "");
			query.append(funcionario.getNombre() instanceof String && !funcionario.getNombre().isEmpty() ? "and NOMBRE = '" + funcionario.getNombre() + "' " : "");
			
			listFuncionario = (List<Funcionario>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFuncionario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> getAllEndWithBy(Funcionario funcionario) throws DAOException {
		LOG.debug("FuncionarioDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Funcionario> listFuncionario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Funcionario  where 1 = 1 ");
			query.append(funcionario.getRutfuncionario() instanceof String && !funcionario.getRutfuncionario().isEmpty() ? "and CODIGO = '"  + funcionario.getRutfuncionario() + "' " : "");
			query.append(funcionario.getNombre() instanceof String && !funcionario.getNombre().isEmpty() ? "and NOMBRE = '" + funcionario.getNombre() + "' " : "");
			
			listFuncionario = (List<Funcionario>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFuncionario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> getAllNotEndWithBy(Funcionario funcionario) throws DAOException {
		LOG.debug("FuncionarioDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Funcionario> listFuncionario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Funcionario  where 1 = 1 ");
			query.append(funcionario.getRutfuncionario() instanceof String && !funcionario.getRutfuncionario().isEmpty() ? "and CODIGO = '"  + funcionario.getRutfuncionario() + "' " : "");
			query.append(funcionario.getNombre() instanceof String && !funcionario.getNombre().isEmpty() ? "and NOMBRE = '" + funcionario.getNombre() + "' " : "");
			
			listFuncionario = (List<Funcionario>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFuncionario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> getAllContainBy(Funcionario funcionario) throws DAOException {
		LOG.debug("FuncionarioDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Funcionario> listFuncionario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Funcionario  where 1 = 1 ");
			query.append(funcionario.getRutfuncionario() instanceof String && !funcionario.getRutfuncionario().isEmpty() ? "and CODIGO = '"  + funcionario.getRutfuncionario() + "' " : "");
			query.append(funcionario.getNombre() instanceof String && !funcionario.getNombre().isEmpty() ? "and NOMBRE = '" + funcionario.getNombre() + "' " : "");
			
			listFuncionario = (List<Funcionario>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFuncionario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> getAllNotContainBy(Funcionario funcionario) throws DAOException {
		LOG.debug("FuncionarioDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Funcionario> listFuncionario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Funcionario  where 1 = 1 ");
			query.append(funcionario.getRutfuncionario() instanceof String && !funcionario.getRutfuncionario().isEmpty() ? "and CODIGO = '"  + funcionario.getRutfuncionario() + "' " : "");
			query.append(funcionario.getNombre() instanceof String && !funcionario.getNombre().isEmpty() ? "and NOMBRE = '" + funcionario.getNombre() + "' " : "");
			
			listFuncionario = (List<Funcionario>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFuncionario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> getAllIsNullBy(Funcionario funcionario) throws DAOException {
		LOG.debug("FuncionarioDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Funcionario> listFuncionario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Funcionario  where 1 = 1 ");
			query.append(funcionario.getRutfuncionario() instanceof String && !funcionario.getRutfuncionario().isEmpty() ? "and CODIGO = '"  + funcionario.getRutfuncionario() + "' " : "");
			query.append(funcionario.getNombre() instanceof String && !funcionario.getNombre().isEmpty() ? "and NOMBRE = '" + funcionario.getNombre() + "' " : "");
			
			listFuncionario = (List<Funcionario>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFuncionario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> getAllNotIsNullBy(Funcionario funcionario) throws DAOException {
		LOG.debug("FuncionarioDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Funcionario> listFuncionario = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Funcionario  where 1 = 1 ");
			query.append(funcionario.getRutfuncionario() instanceof String && !funcionario.getRutfuncionario().isEmpty() ? "and CODIGO = '"  + funcionario.getRutfuncionario() + "' " : "");
			query.append(funcionario.getNombre() instanceof String && !funcionario.getNombre().isEmpty() ? "and NOMBRE = '" + funcionario.getNombre() + "' " : "");
			
			listFuncionario = (List<Funcionario>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listFuncionario;
	}
	
	public boolean save(Funcionario obj) throws DAOException {
		LOG.debug("FuncionarioDao save");
		
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
	
	public boolean update(Funcionario obj) throws DAOException {
		LOG.debug("FuncionarioDao update");
		
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
		LOG.debug("FuncionarioDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Funcionario funcionario = (Funcionario) session.get(Funcionario.class, codigo);
			session.delete(funcionario);
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