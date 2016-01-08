package cl.obam.pasteleria.lapalmera.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Capturaproduccion;
import cl.obam.pasteleria.lapalmera.model.Funcionario;
import cl.obam.pasteleria.lapalmera.model.Ubicacion;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class CapturaProduccionDao {
	
	private static final Logger LOG = Logger.getLogger(CapturaProduccionDao.class);

	public Capturaproduccion get(Integer correlativoProduccion) throws DAOException {
		LOG.debug("CapturaProduccionDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Capturaproduccion capturaProduccion = null;
		try {
			tx = session.beginTransaction();		
			capturaProduccion = (Capturaproduccion) session.createQuery("from Capturaproduccion where correlativoproduccion = ?").setInteger(0, correlativoProduccion).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return capturaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Capturaproduccion> getAll() throws DAOException {
		LOG.debug("CapturaProduccionDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Capturaproduccion> listCapturaProduccion = null;
		try {
			tx = session.beginTransaction();		
			listCapturaProduccion = (List<Capturaproduccion>) session.createQuery("from Capturaproduccion ").list();
			for(Capturaproduccion obj : listCapturaProduccion) {
				obj.getProducto().getFamilia().getNombrefamilia();
				obj.getProducto().getSubfamilia().getNombresubfamilia();
				obj.getProducto().getSubfamilia().getFamilia().getNombrefamilia();
				obj.getProducto().getOtracaracteristica().getNombreotracaracteristica();
				obj.getProducto().getUnidadmedida().getNombre();
				obj.getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
				obj.getProducto().getTipoproducto().getNombre();
				obj.getProgramaproduccion().getProducto().getFamilia().getNombrefamilia();
				obj.getProgramaproduccion().getProducto().getSubfamilia().getNombresubfamilia();
				obj.getProgramaproduccion().getProducto().getOtracaracteristica().getNombreotracaracteristica();
				obj.getProgramaproduccion().getProducto().getUnidadmedida().getNombre();
				obj.getProgramaproduccion().getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
				obj.getProgramaproduccion().getProducto().getTipoproducto().getNombre();
				obj.getProgramaproduccion().getLineaproduccion().getNombrelineaproduccion();
				for(Funcionario funcionario : obj.getFuncionarios()) {
					funcionario.getArea().getNombre();
					funcionario.getCargo().getNombre();
				}
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCapturaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Capturaproduccion> getAllEqBy(Capturaproduccion capturaProduccion) throws DAOException {
		LOG.debug("CapturaProduccionDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Capturaproduccion> listCapturaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Capturaproduccion where 1 = 1 ");
			query.append(capturaProduccion.getCorrelativoproduccion() instanceof Integer ? 
					"and correlativoproduccion = '"  + capturaProduccion.getCorrelativoproduccion() + "' " : "");
			query.append(capturaProduccion.getProgramaproduccion() != null && 
					capturaProduccion.getProgramaproduccion().getCodigo() instanceof String && 
					!capturaProduccion.getProgramaproduccion().getCodigo().isEmpty() ? 
							"and ordenfabricacion.codigoordenfabricacion = '" + capturaProduccion.getProgramaproduccion().getCodigo() + "' " : "");
			
			listCapturaProduccion = (List<Capturaproduccion>) session.createQuery(query.toString()).list();
			for(Capturaproduccion obj : listCapturaProduccion) {
				obj.getProducto().getFamilia().getNombrefamilia();
				obj.getProducto().getSubfamilia().getNombresubfamilia();
				obj.getProducto().getSubfamilia().getFamilia().getNombrefamilia();
				obj.getProducto().getOtracaracteristica().getNombreotracaracteristica();
				obj.getProducto().getUnidadmedida().getNombre();
				obj.getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
				obj.getProducto().getTipoproducto().getNombre();
				for(Ubicacion ubicacion : obj.getProducto().getUbicacions()) {
					ubicacion.getBodega().getNombre();
				}
				obj.getProgramaproduccion().getProducto().getFamilia().getNombrefamilia();
				obj.getProgramaproduccion().getProducto().getSubfamilia().getNombresubfamilia();
				obj.getProgramaproduccion().getProducto().getOtracaracteristica().getNombreotracaracteristica();
				obj.getProgramaproduccion().getProducto().getUnidadmedida().getNombre();
				obj.getProgramaproduccion().getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
				obj.getProgramaproduccion().getProducto().getTipoproducto().getNombre();
				obj.getProgramaproduccion().getLineaproduccion().getNombrelineaproduccion();
				for(Funcionario funcionario : obj.getFuncionarios()) {
					funcionario.getArea().getNombre();
					funcionario.getCargo().getNombre();
				}
//				for(Entregainsumo entregaInsumo : obj.getOrdenfabricacion().getEntregainsumos()) {
//					entregaInsumo.getObservacion();
//					entregaInsumo.getFuncionario().getArea().getNombre();
//					entregaInsumo.getFuncionario().getCargo().getNombre();
//					entregaInsumo.getDetalleentregainsumo().getProducto().getNombreproducto();
//					entregaInsumo.getDetalleentregainsumo().getProducto().getFamilia().getNombrefamilia();
//					entregaInsumo.getDetalleentregainsumo().getProducto().getSubfamilia().getNombresubfamilia();
//					entregaInsumo.getDetalleentregainsumo().getProducto().getSubfamilia().getFamilia().getNombrefamilia();
//					entregaInsumo.getDetalleentregainsumo().getProducto().getOtracaracteristica().getNombreotracaracteristica();
//					entregaInsumo.getDetalleentregainsumo().getProducto().getUnidadmedida().getNombre();
//					entregaInsumo.getDetalleentregainsumo().getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
//					entregaInsumo.getDetalleentregainsumo().getProducto().getTipoproducto().getNombre();
//					entregaInsumo.getDetalleentregainsumo().getUnidadmedida().getNombre();
//					entregaInsumo.getDetalleentregainsumo().getUnidadmedida().getFamilia().getNombrefamilia();
//				}
//				for(Devolucioninsumo devolucionInsumo : obj.getOrdenfabricacion().getDevolucioninsumos()) {
//					devolucionInsumo.getObservacion();
//					devolucionInsumo.getFuncionario().getArea().getNombre();
//					devolucionInsumo.getFuncionario().getCargo().getNombre();
//					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getNombreproducto();
//					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getFamilia().getNombrefamilia();
//					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getSubfamilia().getNombresubfamilia();
//					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getSubfamilia().getFamilia().getNombrefamilia();
//					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getOtracaracteristica().getNombreotracaracteristica();
//					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getUnidadmedida().getNombre();
//					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
//					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getTipoproducto().getNombre();
//				}
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCapturaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Capturaproduccion> getAllNotEqBy(Capturaproduccion capturaProduccion) throws DAOException {
		LOG.debug("CapturaProduccionDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Capturaproduccion> listCapturaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Capturaproduccion where 1 = 1 ");
			query.append(capturaProduccion.getCorrelativoproduccion() instanceof Integer ? "and CODIGO = '"  + capturaProduccion.getCorrelativoproduccion() + "' " : "");
			query.append(capturaProduccion.getProgramaproduccion().getCodigo() instanceof String && !capturaProduccion.getProgramaproduccion().getCodigo().isEmpty() ? "and NOMBRE = '" + capturaProduccion.getProgramaproduccion().getCodigo() + "' " : "");
			
			listCapturaProduccion = (List<Capturaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCapturaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Capturaproduccion> getAllBeginWithBy(Capturaproduccion capturaProduccion) throws DAOException {
		LOG.debug("CapturaProduccionDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Capturaproduccion> listCapturaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Capturaproduccion  where 1 = 1 ");
			query.append(capturaProduccion.getCorrelativoproduccion() instanceof Integer ? "and CODIGO = '"  + capturaProduccion.getCorrelativoproduccion() + "' " : "");
			query.append(capturaProduccion.getProgramaproduccion().getCodigo() instanceof String && !capturaProduccion.getProgramaproduccion().getCodigo().isEmpty() ? "and NOMBRE = '" + capturaProduccion.getProgramaproduccion().getCodigo() + "' " : "");
			
			listCapturaProduccion = (List<Capturaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCapturaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Capturaproduccion> getAllNotBeginWithBy(Capturaproduccion capturaProduccion) throws DAOException {
		LOG.debug("CapturaProduccionDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Capturaproduccion> listCapturaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Capturaproduccion  where 1 = 1 ");
			query.append(capturaProduccion.getCorrelativoproduccion() instanceof Integer ? "and CODIGO = '"  + capturaProduccion.getCorrelativoproduccion() + "' " : "");
			query.append(capturaProduccion.getProgramaproduccion().getCodigo() instanceof String && !capturaProduccion.getProgramaproduccion().getCodigo().isEmpty() ? "and NOMBRE = '" + capturaProduccion.getProgramaproduccion().getCodigo() + "' " : "");
			
			listCapturaProduccion = (List<Capturaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCapturaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Capturaproduccion> getAllEndWithBy(Capturaproduccion capturaProduccion) throws DAOException {
		LOG.debug("CapturaProduccionDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Capturaproduccion> listCapturaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Capturaproduccion  where 1 = 1 ");
			query.append(capturaProduccion.getCorrelativoproduccion() instanceof Integer ? "and CODIGO = '"  + capturaProduccion.getCorrelativoproduccion() + "' " : "");
			query.append(capturaProduccion.getProgramaproduccion().getCodigo() instanceof String && !capturaProduccion.getProgramaproduccion().getCodigo().isEmpty() ? "and NOMBRE = '" + capturaProduccion.getProgramaproduccion().getCodigo() + "' " : "");
			
			listCapturaProduccion = (List<Capturaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCapturaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Capturaproduccion> getAllNotEndWithBy(Capturaproduccion capturaProduccion) throws DAOException {
		LOG.debug("CapturaProduccionDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Capturaproduccion> listCapturaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Capturaproduccion  where 1 = 1 ");
			query.append(capturaProduccion.getCorrelativoproduccion() instanceof Integer ? "and CODIGO = '"  + capturaProduccion.getCorrelativoproduccion() + "' " : "");
			query.append(capturaProduccion.getProgramaproduccion().getCodigo() instanceof String && !capturaProduccion.getProgramaproduccion().getCodigo().isEmpty() ? "and NOMBRE = '" + capturaProduccion.getProgramaproduccion().getCodigo() + "' " : "");
			
			listCapturaProduccion = (List<Capturaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCapturaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Capturaproduccion> getAllContainBy(Capturaproduccion capturaProduccion) throws DAOException {
		LOG.debug("CapturaProduccionDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Capturaproduccion> listCapturaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Capturaproduccion  where 1 = 1 ");
			query.append(capturaProduccion.getCorrelativoproduccion() instanceof Integer ? "and CODIGO = '"  + capturaProduccion.getCorrelativoproduccion() + "' " : "");
			query.append(capturaProduccion.getProgramaproduccion().getCodigo() instanceof String && !capturaProduccion.getProgramaproduccion().getCodigo().isEmpty() ? "and NOMBRE = '" + capturaProduccion.getProgramaproduccion().getCodigo() + "' " : "");
			
			listCapturaProduccion = (List<Capturaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCapturaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Capturaproduccion> getAllNotContainBy(Capturaproduccion capturaProduccion) throws DAOException {
		LOG.debug("CapturaProduccionDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Capturaproduccion> listCapturaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Capturaproduccion  where 1 = 1 ");
			query.append(capturaProduccion.getCorrelativoproduccion() instanceof Integer ? "and CODIGO = '"  + capturaProduccion.getCorrelativoproduccion() + "' " : "");
			query.append(capturaProduccion.getProgramaproduccion().getCodigo() instanceof String && !capturaProduccion.getProgramaproduccion().getCodigo().isEmpty() ? "and NOMBRE = '" + capturaProduccion.getProgramaproduccion().getCodigo() + "' " : "");
			
			listCapturaProduccion = (List<Capturaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCapturaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Capturaproduccion> getAllIsNullBy(Capturaproduccion capturaProduccion) throws DAOException {
		LOG.debug("CapturaProduccionDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Capturaproduccion> listCapturaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Capturaproduccion  where 1 = 1 ");
			query.append(capturaProduccion.getCorrelativoproduccion() instanceof Integer ? "and CODIGO = '"  + capturaProduccion.getCorrelativoproduccion() + "' " : "");
			query.append(capturaProduccion.getProgramaproduccion().getCodigo() instanceof String && !capturaProduccion.getProgramaproduccion().getCodigo().isEmpty() ? "and NOMBRE = '" + capturaProduccion.getProgramaproduccion().getCodigo() + "' " : "");
			
			listCapturaProduccion = (List<Capturaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCapturaProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Capturaproduccion> getAllNotIsNullBy(Capturaproduccion capturaProduccion) throws DAOException {
		LOG.debug("CapturaProduccionDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Capturaproduccion> listCapturaProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Capturaproduccion  where 1 = 1 ");
			query.append(capturaProduccion.getCorrelativoproduccion() instanceof Integer ? "and CODIGO = '"  + capturaProduccion.getCorrelativoproduccion() + "' " : "");
			query.append(capturaProduccion.getProgramaproduccion().getCodigo() instanceof String && !capturaProduccion.getProgramaproduccion().getCodigo().isEmpty() ? "and NOMBRE = '" + capturaProduccion.getProgramaproduccion().getCodigo() + "' " : "");
			
			listCapturaProduccion = (List<Capturaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCapturaProduccion;
	}
	
	public boolean save(Capturaproduccion capturaProduccion) throws DAOException {
		LOG.debug("CapturaProduccionDao save");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		    session.save(capturaProduccion);
		    if(capturaProduccion.getProducto().getStock().getCodigoproducto() == null || 
		    		capturaProduccion.getProducto().getStock().getCodigoproducto().isEmpty()) {
				session.save(capturaProduccion.getProducto().getStock());
			} else {
				session.update(capturaProduccion.getProducto().getStock());
		    }
		    for(Ubicacion ubicacion : capturaProduccion.getProducto().getUbicacions()) {
		    	session.save(ubicacion);
		    }
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
	
	public boolean update(Capturaproduccion obj) throws DAOException {
		LOG.debug("CapturaProduccionDao update");
		
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
	
	public boolean delete(Integer correlativoProduccion) throws DAOException {
		LOG.debug("CapturaProduccionDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Capturaproduccion capturaProduccion = (Capturaproduccion) session.get(Capturaproduccion.class, correlativoProduccion);
			session.delete(capturaProduccion);
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