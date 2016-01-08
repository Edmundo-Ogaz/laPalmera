package cl.obam.pasteleria.lapalmera.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Ubicacion;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class UbicacionDao {
	
	private static final Logger LOG = Logger.getLogger(UbicacionDao.class);

	public Ubicacion get(int id) throws DAOException {
		LOG.debug("UbicacionDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Ubicacion ubicacion = null;
		try {
			tx = session.beginTransaction();		
			ubicacion = (Ubicacion) session.createQuery("from Ubicacion where id = ?").setInteger(0, id).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return ubicacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ubicacion> getAll() throws DAOException {
		LOG.debug("UbicacionDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ubicacion> listUbicacion = null;
		try {
			tx = session.beginTransaction();		
			listUbicacion = (List<Ubicacion>) session.createQuery("from Ubicacion ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUbicacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ubicacion> getAllEqBy(Ubicacion ubicacion) throws DAOException {
		LOG.debug("UbicacionDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ubicacion> listUbicacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ubicacion where 1 = 1 ");
			query.append(ubicacion.getProducto() != null && ubicacion.getProducto().getCodigoproducto() instanceof String && !ubicacion.getProducto().getCodigoproducto().isEmpty() ? "and producto.codigoproducto = '"  + ubicacion.getProducto().getCodigoproducto() + "' " : "");
			query.append(ubicacion.getBodega() != null && ubicacion.getBodega().getCodigo() instanceof String && !ubicacion.getBodega().getCodigo().isEmpty() ? "and bodega.codigo = '"  + ubicacion.getBodega().getCodigo() + "' " : "");
			query.append(ubicacion.getFechaingreso() != null ? "and fechaingreso = '"  + 
					new SimpleDateFormat("yyyy-MM-dd").format(ubicacion.getFechaingreso()) + "' " : "");
			query.append(ubicacion.getFechavencimiento() != null ? "and fechavencimiento = '"  + 
					new SimpleDateFormat("yyyy-MM-dd").format(ubicacion.getFechavencimiento()) + "' " : "");
			query.append(ubicacion.getCantidad() != null ? "and cantidad = "  + ubicacion.getCantidad() + " " : "");
			query.append(ubicacion.getUnidadmedida() != null && ubicacion.getUnidadmedida().getCodigo() instanceof String && !ubicacion.getUnidadmedida().getCodigo().isEmpty() ? "and unidadmedida.codigo = '"  + ubicacion.getUnidadmedida().getCodigo() + "' " : "");
			query.append(ubicacion.getObservacionubicacion() instanceof String && !ubicacion.getObservacionubicacion().isEmpty() ? "and observacionubicacion = '" + ubicacion.getObservacionubicacion() + "' " : "");
			
			listUbicacion = (List<Ubicacion>) session.createQuery(query.toString()).list();
			for(Ubicacion obj : listUbicacion) {
				obj.getProducto().getFamilia().getNombrefamilia();
				obj.getProducto().getSubfamilia().getNombresubfamilia();
				obj.getProducto().getSubfamilia().getFamilia().getNombrefamilia();
				obj.getProducto().getOtracaracteristica().getNombreotracaracteristica();
				obj.getProducto().getUnidadmedida().getNombre();
				obj.getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
				obj.getProducto().getTipoproducto().getNombre();
				obj.getBodega().getNombre();
				obj.getUnidadmedida().getNombre();
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUbicacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ubicacion> getAllNotEqBy(Ubicacion ubicacion) throws DAOException {
		LOG.debug("UbicacionDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ubicacion> listUbicacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ubicacion where 1 = 1 ");
			query.append(ubicacion.getUnidadmedida() != null && ubicacion.getUnidadmedida().getCodigo() instanceof String && !ubicacion.getUnidadmedida().getCodigo().isEmpty() ? "and CODIGO = '"  + ubicacion.getUnidadmedida().getCodigo() + "' " : "");
			query.append(ubicacion.getObservacionubicacion() instanceof String && !ubicacion.getObservacionubicacion().isEmpty() ? "and NOMBRE = '" + ubicacion.getObservacionubicacion() + "' " : "");
			
			listUbicacion = (List<Ubicacion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUbicacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ubicacion> getAllBeginWithBy(Ubicacion ubicacion) throws DAOException {
		LOG.debug("UbicacionDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ubicacion> listUbicacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ubicacion  where 1 = 1 ");
			query.append(ubicacion.getUnidadmedida() != null && ubicacion.getUnidadmedida().getCodigo() instanceof String && !ubicacion.getUnidadmedida().getCodigo().isEmpty() ? "and CODIGO = '"  + ubicacion.getUnidadmedida().getCodigo() + "' " : "");
			query.append(ubicacion.getObservacionubicacion() instanceof String && !ubicacion.getObservacionubicacion().isEmpty() ? "and NOMBRE = '" + ubicacion.getObservacionubicacion() + "' " : "");
			
			listUbicacion = (List<Ubicacion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUbicacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ubicacion> getAllNotBeginWithBy(Ubicacion ubicacion) throws DAOException {
		LOG.debug("UbicacionDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ubicacion> listUbicacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ubicacion  where 1 = 1 ");
			query.append(ubicacion.getUnidadmedida() != null && ubicacion.getUnidadmedida().getCodigo() instanceof String && !ubicacion.getUnidadmedida().getCodigo().isEmpty() ? "and CODIGO = '"  + ubicacion.getUnidadmedida().getCodigo() + "' " : "");
			query.append(ubicacion.getObservacionubicacion() instanceof String && !ubicacion.getObservacionubicacion().isEmpty() ? "and NOMBRE = '" + ubicacion.getObservacionubicacion() + "' " : "");
			
			listUbicacion = (List<Ubicacion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUbicacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ubicacion> getAllEndWithBy(Ubicacion ubicacion) throws DAOException {
		LOG.debug("UbicacionDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ubicacion> listUbicacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ubicacion  where 1 = 1 ");
			query.append(ubicacion.getUnidadmedida() != null && ubicacion.getUnidadmedida().getCodigo() instanceof String && !ubicacion.getUnidadmedida().getCodigo().isEmpty() ? "and CODIGO = '"  + ubicacion.getUnidadmedida().getCodigo() + "' " : "");
			query.append(ubicacion.getObservacionubicacion() instanceof String && !ubicacion.getObservacionubicacion().isEmpty() ? "and NOMBRE = '" + ubicacion.getObservacionubicacion() + "' " : "");
			
			listUbicacion = (List<Ubicacion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUbicacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ubicacion> getAllNotEndWithBy(Ubicacion ubicacion) throws DAOException {
		LOG.debug("UbicacionDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ubicacion> listUbicacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ubicacion  where 1 = 1 ");
			query.append(ubicacion.getUnidadmedida() != null && ubicacion.getUnidadmedida().getCodigo() instanceof String && !ubicacion.getUnidadmedida().getCodigo().isEmpty() ? "and CODIGO = '"  + ubicacion.getUnidadmedida().getCodigo() + "' " : "");
			query.append(ubicacion.getObservacionubicacion() instanceof String && !ubicacion.getObservacionubicacion().isEmpty() ? "and NOMBRE = '" + ubicacion.getObservacionubicacion() + "' " : "");
			
			listUbicacion = (List<Ubicacion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUbicacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ubicacion> getAllContainBy(Ubicacion ubicacion) throws DAOException {
		LOG.debug("UbicacionDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ubicacion> listUbicacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ubicacion  where 1 = 1 ");
			query.append(ubicacion.getUnidadmedida() != null && ubicacion.getUnidadmedida().getCodigo() instanceof String && !ubicacion.getUnidadmedida().getCodigo().isEmpty() ? "and CODIGO = '"  + ubicacion.getUnidadmedida().getCodigo() + "' " : "");
			query.append(ubicacion.getObservacionubicacion() instanceof String && !ubicacion.getObservacionubicacion().isEmpty() ? "and NOMBRE = '" + ubicacion.getObservacionubicacion() + "' " : "");
			
			listUbicacion = (List<Ubicacion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUbicacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ubicacion> getAllNotContainBy(Ubicacion ubicacion) throws DAOException {
		LOG.debug("UbicacionDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ubicacion> listUbicacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ubicacion  where 1 = 1 ");
			query.append(ubicacion.getUnidadmedida() != null && ubicacion.getUnidadmedida().getCodigo() instanceof String && !ubicacion.getUnidadmedida().getCodigo().isEmpty() ? "and CODIGO = '"  + ubicacion.getUnidadmedida().getCodigo() + "' " : "");
			query.append(ubicacion.getObservacionubicacion() instanceof String && !ubicacion.getObservacionubicacion().isEmpty() ? "and NOMBRE = '" + ubicacion.getObservacionubicacion() + "' " : "");
			
			listUbicacion = (List<Ubicacion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUbicacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ubicacion> getAllIsNullBy(Ubicacion ubicacion) throws DAOException {
		LOG.debug("UbicacionDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ubicacion> listUbicacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ubicacion  where 1 = 1 ");
			query.append(ubicacion.getUnidadmedida() != null && ubicacion.getUnidadmedida().getCodigo() instanceof String && !ubicacion.getUnidadmedida().getCodigo().isEmpty() ? "and CODIGO = '"  + ubicacion.getUnidadmedida().getCodigo() + "' " : "");
			query.append(ubicacion.getObservacionubicacion() instanceof String && !ubicacion.getObservacionubicacion().isEmpty() ? "and NOMBRE = '" + ubicacion.getObservacionubicacion() + "' " : "");
			
			listUbicacion = (List<Ubicacion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUbicacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ubicacion> getAllNotIsNullBy(Ubicacion ubicacion) throws DAOException {
		LOG.debug("UbicacionDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ubicacion> listUbicacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ubicacion  where 1 = 1 ");
			query.append(ubicacion.getUnidadmedida() != null && ubicacion.getUnidadmedida().getCodigo() instanceof String && !ubicacion.getUnidadmedida().getCodigo().isEmpty() ? "and CODIGO = '"  + ubicacion.getUnidadmedida().getCodigo() + "' " : "");
			query.append(ubicacion.getObservacionubicacion() instanceof String && !ubicacion.getObservacionubicacion().isEmpty() ? "and NOMBRE = '" + ubicacion.getObservacionubicacion() + "' " : "");
			
			listUbicacion = (List<Ubicacion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listUbicacion;
	}
	
	public boolean save(Ubicacion obj) throws DAOException {
		LOG.debug("UbicacionDao save");
		
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
	
	public boolean update(Ubicacion obj) throws DAOException {
		LOG.debug("UbicacionDao update");
		
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
	
	public boolean delete(int id) throws DAOException {
		LOG.debug("UbicacionDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Ubicacion ubicacion = (Ubicacion) session.get(Ubicacion.class, id);
			session.delete(ubicacion);
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