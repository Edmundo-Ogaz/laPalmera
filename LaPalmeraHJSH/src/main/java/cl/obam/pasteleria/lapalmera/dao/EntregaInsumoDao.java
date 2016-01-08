package cl.obam.pasteleria.lapalmera.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Detalleentregainsumo;
import cl.obam.pasteleria.lapalmera.model.Entregainsumo;
import cl.obam.pasteleria.lapalmera.model.Ordenfabricacion;
import cl.obam.pasteleria.lapalmera.model.Programaproduccion;
import cl.obam.pasteleria.lapalmera.model.Ubicacion;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class EntregaInsumoDao {
	
	private static final Logger LOG = Logger.getLogger(EntregaInsumoDao.class);

	public Entregainsumo get(String codigo) throws DAOException {
		LOG.debug("EntregaInsumoDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Entregainsumo entregaInsumo = null;
		try {
			tx = session.beginTransaction();		
			entregaInsumo = (Entregainsumo) session.createQuery("from Entregainsumo where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return entregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entregainsumo> getAll() throws DAOException {
		LOG.debug("EntregaInsumoDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Entregainsumo> listEntregaInsumo = null;
		try {
			tx = session.beginTransaction();		
			listEntregaInsumo = (List<Entregainsumo>) session.createQuery("from Entregainsumo ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entregainsumo> getAllEqBy(Entregainsumo entregaInsumo) throws DAOException {
		LOG.debug("EntregaInsumoDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Entregainsumo> entregaInsumos = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Entregainsumo where 1 = 1 ");
			query.append(entregaInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + entregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(entregaInsumo.getObservacion() instanceof String && 
						!entregaInsumo.getObservacion().isEmpty() ? 
								"and NOMBRE = '" + entregaInsumo.getObservacion() + "' " : "");
			query.append(entregaInsumo.getOrdenfabricacion() instanceof Ordenfabricacion && 
						entregaInsumo.getOrdenfabricacion().getCodigoordenfabricacion() instanceof String && 
						!entregaInsumo.getOrdenfabricacion().getCodigoordenfabricacion().isEmpty() ? 
								"and ordenfabricacion.codigoordenfabricacion = '" + entregaInsumo.getOrdenfabricacion().getCodigoordenfabricacion() + "' " : "");
			entregaInsumos = (List<Entregainsumo>) session.createQuery(query.toString()).list();
			for(Entregainsumo obj : entregaInsumos) {
				obj.getOrdenfabricacion().getProducto();
				obj.getOrdenfabricacion().getProducto().getUnidadmedida();
				obj.getOrdenfabricacion().getProducto().getTipoproducto().getNombre();
				obj.getOrdenfabricacion().getPedido();
				obj.getOrdenfabricacion().getEstadoordenfabricacion().getNombre();
				for(Programaproduccion programaProduccion : obj.getOrdenfabricacion().getProgramaproduccions()) {
					programaProduccion.getLineaproduccion().getNombrelineaproduccion();					
				}
				obj.getOrdenfabricacion().getPedido().getNumeropedido();				
				obj.getFuncionario().getArea().getNombre();
				obj.getFuncionario().getCargo().getNombre();
				obj.getDetalleentregainsumo().getProducto();
				obj.getDetalleentregainsumo().getProducto().getUnidadmedida();
				obj.getDetalleentregainsumo().getProducto().getUnidadmedida().getNombre();
				obj.getDetalleentregainsumo().getProducto().getTipoproducto().getNombre();
				for(Entregainsumo ordenFabricacionEntregaInsumo : obj.getOrdenfabricacion().getEntregainsumos()) {
					ordenFabricacionEntregaInsumo.getFuncionario().getArea().getNombre();
					ordenFabricacionEntregaInsumo.getFuncionario().getCargo().getNombre();
					ordenFabricacionEntregaInsumo.getDetalleentregainsumo().getProducto();
					ordenFabricacionEntregaInsumo.getDetalleentregainsumo().getProducto().getUnidadmedida();
					ordenFabricacionEntregaInsumo.getDetalleentregainsumo().getProducto().getUnidadmedida().getNombre();
					ordenFabricacionEntregaInsumo.getDetalleentregainsumo().getProducto().getTipoproducto().getNombre();
				}
			}
			
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return entregaInsumos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entregainsumo> getAllNotEqBy(Entregainsumo entregaInsumo) throws DAOException {
		LOG.debug("EntregaInsumoDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Entregainsumo> listEntregaInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Entregainsumo where 1 = 1 ");
			query.append(entregaInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + entregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(entregaInsumo.getObservacion() instanceof String && !entregaInsumo.getObservacion().isEmpty() ? "and NOMBRE = '" + entregaInsumo.getObservacion() + "' " : "");
			
			listEntregaInsumo = (List<Entregainsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entregainsumo> getAllBeginWithBy(Entregainsumo entregaInsumo) throws DAOException {
		LOG.debug("EntregaInsumoDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Entregainsumo> listEntregaInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Entregainsumo  where 1 = 1 ");
			query.append(entregaInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + entregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(entregaInsumo.getObservacion() instanceof String && !entregaInsumo.getObservacion().isEmpty() ? "and NOMBRE = '" + entregaInsumo.getObservacion() + "' " : "");
			
			listEntregaInsumo = (List<Entregainsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entregainsumo> getAllNotBeginWithBy(Entregainsumo entregaInsumo) throws DAOException {
		LOG.debug("EntregaInsumoDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Entregainsumo> listEntregaInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Entregainsumo  where 1 = 1 ");
			query.append(entregaInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + entregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(entregaInsumo.getObservacion() instanceof String && !entregaInsumo.getObservacion().isEmpty() ? "and NOMBRE = '" + entregaInsumo.getObservacion() + "' " : "");
			
			listEntregaInsumo = (List<Entregainsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entregainsumo> getAllEndWithBy(Entregainsumo entregaInsumo) throws DAOException {
		LOG.debug("EntregaInsumoDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Entregainsumo> listEntregaInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Entregainsumo  where 1 = 1 ");
			query.append(entregaInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + entregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(entregaInsumo.getObservacion() instanceof String && !entregaInsumo.getObservacion().isEmpty() ? "and NOMBRE = '" + entregaInsumo.getObservacion() + "' " : "");
			
			listEntregaInsumo = (List<Entregainsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entregainsumo> getAllNotEndWithBy(Entregainsumo entregaInsumo) throws DAOException {
		LOG.debug("EntregaInsumoDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Entregainsumo> listEntregaInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Entregainsumo  where 1 = 1 ");
			query.append(entregaInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + entregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(entregaInsumo.getObservacion() instanceof String && !entregaInsumo.getObservacion().isEmpty() ? "and NOMBRE = '" + entregaInsumo.getObservacion() + "' " : "");
			
			listEntregaInsumo = (List<Entregainsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entregainsumo> getAllContainBy(Entregainsumo entregaInsumo) throws DAOException {
		LOG.debug("EntregaInsumoDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Entregainsumo> listEntregaInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Entregainsumo  where 1 = 1 ");
			query.append(entregaInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + entregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(entregaInsumo.getObservacion() instanceof String && !entregaInsumo.getObservacion().isEmpty() ? "and NOMBRE = '" + entregaInsumo.getObservacion() + "' " : "");
			
			listEntregaInsumo = (List<Entregainsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entregainsumo> getAllNotContainBy(Entregainsumo entregaInsumo) throws DAOException {
		LOG.debug("EntregaInsumoDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Entregainsumo> listEntregaInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Entregainsumo  where 1 = 1 ");
			query.append(entregaInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + entregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(entregaInsumo.getObservacion() instanceof String && !entregaInsumo.getObservacion().isEmpty() ? "and NOMBRE = '" + entregaInsumo.getObservacion() + "' " : "");
			
			listEntregaInsumo = (List<Entregainsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entregainsumo> getAllIsNullBy(Entregainsumo entregaInsumo) throws DAOException {
		LOG.debug("EntregaInsumoDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Entregainsumo> listEntregaInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Entregainsumo  where 1 = 1 ");
			query.append(entregaInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + entregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(entregaInsumo.getObservacion() instanceof String && !entregaInsumo.getObservacion().isEmpty() ? "and NOMBRE = '" + entregaInsumo.getObservacion() + "' " : "");
			
			listEntregaInsumo = (List<Entregainsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEntregaInsumo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entregainsumo> getAllNotIsNullBy(Entregainsumo entregaInsumo) throws DAOException {
		LOG.debug("EntregaInsumoDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Entregainsumo> listEntregaInsumo = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Entregainsumo  where 1 = 1 ");
			query.append(entregaInsumo.getCorrelativoentregainsumo() instanceof Integer ? "and CODIGO = '"  + entregaInsumo.getCorrelativoentregainsumo() + "' " : "");
			query.append(entregaInsumo.getObservacion() instanceof String && !entregaInsumo.getObservacion().isEmpty() ? "and NOMBRE = '" + entregaInsumo.getObservacion() + "' " : "");
			
			listEntregaInsumo = (List<Entregainsumo>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEntregaInsumo;
	}
	
	public boolean save(Entregainsumo entregaInsumo) throws DAOException {
		LOG.debug("EntregaInsumoDao save");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(entregaInsumo);
		    session.save(entregaInsumo.getDetalleentregainsumo());
		    session.update(entregaInsumo.getDetalleentregainsumo().getProducto().getStock());
		    for(Ubicacion ubicacion : entregaInsumo.getDetalleentregainsumo().getProducto().getUbicacions()) {
		    	if(ubicacion.getCantidad() == 0) {
		    		session.delete(ubicacion);
		    	} else {
		    		session.update(ubicacion);
		    	}
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
	
	public boolean update(Entregainsumo obj) throws DAOException {
		LOG.debug("EntregaInsumoDao update");
		
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
	
	public boolean delete(int codigo) throws DAOException {
		LOG.debug("EntregaInsumoDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			Detalleentregainsumo detalleEntregaInsumo = (Detalleentregainsumo) session.get(Detalleentregainsumo.class, codigo);
			session.delete(detalleEntregaInsumo);
			
			Entregainsumo entregaInsumo = (Entregainsumo) session.get(Entregainsumo.class, codigo);
			session.delete(entregaInsumo);
		    
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