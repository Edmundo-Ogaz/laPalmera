package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Conceptotecnico;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class ConceptoTecnicoDao {
	
	private static final Logger LOG = Logger.getLogger(ConceptoTecnicoDao.class);

	public Conceptotecnico get(String codigo) throws DAOException {
		LOG.debug("ConceptoTecnicoDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Conceptotecnico conceptoTecnico = null;
		try {
			tx = session.beginTransaction();		
			conceptoTecnico = (Conceptotecnico) session.createQuery("from Conceptotecnico where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return conceptoTecnico;
	}
	
	@SuppressWarnings("unchecked")
	public List<Conceptotecnico> getAll() throws DAOException {
		LOG.debug("ConceptoTecnicoDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Conceptotecnico> listConceptoTecnico = null;
		try {
			tx = session.beginTransaction();		
			listConceptoTecnico = (List<Conceptotecnico>) session.createQuery("from Conceptotecnico ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConceptoTecnico;
	}
	
	@SuppressWarnings("unchecked")
	public List<Conceptotecnico> getAllEqBy(Conceptotecnico conceptoTecnico) throws DAOException {
		LOG.debug("ConceptoTecnicoDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Conceptotecnico> listConceptoTecnico = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Conceptotecnico where 1 = 1 ");
			query.append(conceptoTecnico.getCodigoconceptotecnico() instanceof String && !conceptoTecnico.getCodigoconceptotecnico().isEmpty() ? "and CODIGO = '"  + conceptoTecnico.getCodigoconceptotecnico() + "' " : "");
			query.append(conceptoTecnico.getNombreconceptotecnico() instanceof String && !conceptoTecnico.getNombreconceptotecnico().isEmpty() ? "and NOMBRE = '" + conceptoTecnico.getNombreconceptotecnico() + "' " : "");
			
			listConceptoTecnico = (List<Conceptotecnico>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConceptoTecnico;
	}
	
	@SuppressWarnings("unchecked")
	public List<Conceptotecnico> getAllNotEqBy(Conceptotecnico conceptoTecnico) throws DAOException {
		LOG.debug("ConceptoTecnicoDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Conceptotecnico> listConceptoTecnico = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Conceptotecnico where 1 = 1 ");
			query.append(conceptoTecnico.getCodigoconceptotecnico() instanceof String && !conceptoTecnico.getCodigoconceptotecnico().isEmpty() ? "and CODIGO = '"  + conceptoTecnico.getCodigoconceptotecnico() + "' " : "");
			query.append(conceptoTecnico.getNombreconceptotecnico() instanceof String && !conceptoTecnico.getNombreconceptotecnico().isEmpty() ? "and NOMBRE = '" + conceptoTecnico.getNombreconceptotecnico() + "' " : "");
			
			listConceptoTecnico = (List<Conceptotecnico>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConceptoTecnico;
	}
	
	@SuppressWarnings("unchecked")
	public List<Conceptotecnico> getAllBeginWithBy(Conceptotecnico conceptoTecnico) throws DAOException {
		LOG.debug("ConceptoTecnicoDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Conceptotecnico> listConceptoTecnico = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Conceptotecnico  where 1 = 1 ");
			query.append(conceptoTecnico.getCodigoconceptotecnico() instanceof String && !conceptoTecnico.getCodigoconceptotecnico().isEmpty() ? "and CODIGO = '"  + conceptoTecnico.getCodigoconceptotecnico() + "' " : "");
			query.append(conceptoTecnico.getNombreconceptotecnico() instanceof String && !conceptoTecnico.getNombreconceptotecnico().isEmpty() ? "and NOMBRE = '" + conceptoTecnico.getNombreconceptotecnico() + "' " : "");
			
			listConceptoTecnico = (List<Conceptotecnico>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConceptoTecnico;
	}
	
	@SuppressWarnings("unchecked")
	public List<Conceptotecnico> getAllNotBeginWithBy(Conceptotecnico conceptoTecnico) throws DAOException {
		LOG.debug("ConceptoTecnicoDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Conceptotecnico> listConceptoTecnico = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Conceptotecnico  where 1 = 1 ");
			query.append(conceptoTecnico.getCodigoconceptotecnico() instanceof String && !conceptoTecnico.getCodigoconceptotecnico().isEmpty() ? "and CODIGO = '"  + conceptoTecnico.getCodigoconceptotecnico() + "' " : "");
			query.append(conceptoTecnico.getNombreconceptotecnico() instanceof String && !conceptoTecnico.getNombreconceptotecnico().isEmpty() ? "and NOMBRE = '" + conceptoTecnico.getNombreconceptotecnico() + "' " : "");
			
			listConceptoTecnico = (List<Conceptotecnico>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConceptoTecnico;
	}
	
	@SuppressWarnings("unchecked")
	public List<Conceptotecnico> getAllEndWithBy(Conceptotecnico conceptoTecnico) throws DAOException {
		LOG.debug("ConceptoTecnicoDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Conceptotecnico> listConceptoTecnico = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Conceptotecnico  where 1 = 1 ");
			query.append(conceptoTecnico.getCodigoconceptotecnico() instanceof String && !conceptoTecnico.getCodigoconceptotecnico().isEmpty() ? "and CODIGO = '"  + conceptoTecnico.getCodigoconceptotecnico() + "' " : "");
			query.append(conceptoTecnico.getNombreconceptotecnico() instanceof String && !conceptoTecnico.getNombreconceptotecnico().isEmpty() ? "and NOMBRE = '" + conceptoTecnico.getNombreconceptotecnico() + "' " : "");
			
			listConceptoTecnico = (List<Conceptotecnico>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConceptoTecnico;
	}
	
	@SuppressWarnings("unchecked")
	public List<Conceptotecnico> getAllNotEndWithBy(Conceptotecnico conceptoTecnico) throws DAOException {
		LOG.debug("ConceptoTecnicoDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Conceptotecnico> listConceptoTecnico = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Conceptotecnico  where 1 = 1 ");
			query.append(conceptoTecnico.getCodigoconceptotecnico() instanceof String && !conceptoTecnico.getCodigoconceptotecnico().isEmpty() ? "and CODIGO = '"  + conceptoTecnico.getCodigoconceptotecnico() + "' " : "");
			query.append(conceptoTecnico.getNombreconceptotecnico() instanceof String && !conceptoTecnico.getNombreconceptotecnico().isEmpty() ? "and NOMBRE = '" + conceptoTecnico.getNombreconceptotecnico() + "' " : "");
			
			listConceptoTecnico = (List<Conceptotecnico>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConceptoTecnico;
	}
	
	@SuppressWarnings("unchecked")
	public List<Conceptotecnico> getAllContainBy(Conceptotecnico conceptoTecnico) throws DAOException {
		LOG.debug("ConceptoTecnicoDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Conceptotecnico> listConceptoTecnico = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Conceptotecnico  where 1 = 1 ");
			query.append(conceptoTecnico.getCodigoconceptotecnico() instanceof String && !conceptoTecnico.getCodigoconceptotecnico().isEmpty() ? "and CODIGO = '"  + conceptoTecnico.getCodigoconceptotecnico() + "' " : "");
			query.append(conceptoTecnico.getNombreconceptotecnico() instanceof String && !conceptoTecnico.getNombreconceptotecnico().isEmpty() ? "and NOMBRE = '" + conceptoTecnico.getNombreconceptotecnico() + "' " : "");
			
			listConceptoTecnico = (List<Conceptotecnico>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConceptoTecnico;
	}
	
	@SuppressWarnings("unchecked")
	public List<Conceptotecnico> getAllNotContainBy(Conceptotecnico conceptoTecnico) throws DAOException {
		LOG.debug("ConceptoTecnicoDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Conceptotecnico> listConceptoTecnico = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Conceptotecnico  where 1 = 1 ");
			query.append(conceptoTecnico.getCodigoconceptotecnico() instanceof String && !conceptoTecnico.getCodigoconceptotecnico().isEmpty() ? "and CODIGO = '"  + conceptoTecnico.getCodigoconceptotecnico() + "' " : "");
			query.append(conceptoTecnico.getNombreconceptotecnico() instanceof String && !conceptoTecnico.getNombreconceptotecnico().isEmpty() ? "and NOMBRE = '" + conceptoTecnico.getNombreconceptotecnico() + "' " : "");
			
			listConceptoTecnico = (List<Conceptotecnico>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConceptoTecnico;
	}
	
	@SuppressWarnings("unchecked")
	public List<Conceptotecnico> getAllIsNullBy(Conceptotecnico conceptoTecnico) throws DAOException {
		LOG.debug("ConceptoTecnicoDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Conceptotecnico> listConceptoTecnico = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Conceptotecnico  where 1 = 1 ");
			query.append(conceptoTecnico.getCodigoconceptotecnico() instanceof String && !conceptoTecnico.getCodigoconceptotecnico().isEmpty() ? "and CODIGO = '"  + conceptoTecnico.getCodigoconceptotecnico() + "' " : "");
			query.append(conceptoTecnico.getNombreconceptotecnico() instanceof String && !conceptoTecnico.getNombreconceptotecnico().isEmpty() ? "and NOMBRE = '" + conceptoTecnico.getNombreconceptotecnico() + "' " : "");
			
			listConceptoTecnico = (List<Conceptotecnico>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConceptoTecnico;
	}
	
	@SuppressWarnings("unchecked")
	public List<Conceptotecnico> getAllNotIsNullBy(Conceptotecnico conceptoTecnico) throws DAOException {
		LOG.debug("ConceptoTecnicoDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Conceptotecnico> listConceptoTecnico = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Conceptotecnico  where 1 = 1 ");
			query.append(conceptoTecnico.getCodigoconceptotecnico() instanceof String && !conceptoTecnico.getCodigoconceptotecnico().isEmpty() ? "and CODIGO = '"  + conceptoTecnico.getCodigoconceptotecnico() + "' " : "");
			query.append(conceptoTecnico.getNombreconceptotecnico() instanceof String && !conceptoTecnico.getNombreconceptotecnico().isEmpty() ? "and NOMBRE = '" + conceptoTecnico.getNombreconceptotecnico() + "' " : "");
			
			listConceptoTecnico = (List<Conceptotecnico>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listConceptoTecnico;
	}
	
	public boolean save(Conceptotecnico obj) throws DAOException {
		LOG.debug("ConceptoTecnicoDao save");
		
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
	
	public boolean update(Conceptotecnico obj) throws DAOException {
		LOG.debug("ConceptoTecnicoDao update");
		
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
		LOG.debug("ConceptoTecnicoDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Conceptotecnico conceptoTecnico = (Conceptotecnico) session.get(Conceptotecnico.class, codigo);
			session.delete(conceptoTecnico);
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