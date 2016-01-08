package cl.obam.pasteleria.lapalmera.dao;

import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Detallepedido;
import cl.obam.pasteleria.lapalmera.model.Ordenfabricacion;
import cl.obam.pasteleria.lapalmera.model.Pedido;
import cl.obam.pasteleria.lapalmera.model.Programaproduccion;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class SolicitudProductoDao {
	
	private static final Logger LOG = Logger.getLogger(SolicitudProductoDao.class);

	public boolean create(Pedido cabezapedido) throws DAOException {
		LOG.debug("SolicitudProductoDao save");
		
		boolean resp = false;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.saveOrUpdate(cabezapedido.getCliente());
			
			session.save(cabezapedido);
			
			for(Detallepedido detallePedido : cabezapedido.getDetallepedidos()) {
				detallePedido.setPedido(cabezapedido);
				session.save(detallePedido);
			}
			
			cabezapedido.getDespachopedido().setPedido(cabezapedido);
		    session.save(cabezapedido.getDespachopedido());
		    
		    cabezapedido.getConfirmacionpedido().setPedido(cabezapedido);
		    session.save(cabezapedido.getConfirmacionpedido());
		    
		    if(cabezapedido.getOrdenfabricacions() instanceof Set) {
			    int numeroOrdenFabricacion = 1;
			    int numeroProgramaProduccion = 1;
			    for(Ordenfabricacion ordenfabricacion : cabezapedido.getOrdenfabricacions()) {
			    	ordenfabricacion.setCodigoordenfabricacion(cabezapedido.getNumeropedido() + "-" + numeroOrdenFabricacion);
			    	ordenfabricacion.setPedido(cabezapedido);
			    	session.save(ordenfabricacion);
			    	
			    	for(Programaproduccion programaProduccion : ordenfabricacion.getProgramaproduccions()) {
			    		programaProduccion.setCodigo(ordenfabricacion.getCodigoordenfabricacion() + "-" + numeroProgramaProduccion);
			    		programaProduccion.setOrdenfabricacion(ordenfabricacion);
			    		session.save(programaProduccion);
			    		numeroProgramaProduccion++;
			    	}

			    	numeroOrdenFabricacion++;
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
	
	public boolean update(Pedido cabezapedido) throws DAOException {
		LOG.debug("SolicitudProductoDao update");
		
		boolean resp = false;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.saveOrUpdate(cabezapedido.getCliente());
			
			session.update(cabezapedido);
			
			for(Detallepedido detallePedido : cabezapedido.getDetallepedidos()) {
				detallePedido.setPedido(cabezapedido);
				session.saveOrUpdate(detallePedido);
			}
			
			cabezapedido.getDespachopedido().setPedido(cabezapedido);
			cabezapedido.getDespachopedido().setNumeropedido(cabezapedido.getNumeropedido());
		    session.update(cabezapedido.getDespachopedido());
		    
		    cabezapedido.getConfirmacionpedido().setPedido(cabezapedido);
		    cabezapedido.getConfirmacionpedido().setNumeropedido(cabezapedido.getNumeropedido());
		    session.update(cabezapedido.getConfirmacionpedido());
		    
		    if(cabezapedido.getOrdenfabricacions() instanceof Set) {
			    for(Ordenfabricacion ordenFabricacion : cabezapedido.getOrdenfabricacions()) {
			    	
			    	ordenFabricacion.setPedido(cabezapedido);
			    	//session.save(ordenFabricacion);
			    	session.saveOrUpdate(ordenFabricacion);
			    	
			    	for(Programaproduccion programaProduccion : ordenFabricacion.getProgramaproduccions()) {			    		
			    		programaProduccion.setOrdenfabricacion(ordenFabricacion);
			    		session.saveOrUpdate(programaProduccion);
			    	}			    	
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
	
	public boolean updateOld(Pedido obj) throws DAOException {
		LOG.debug("CabezaPedidoDao update");
		
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
		LOG.debug("CabezaPedidoDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Pedido cabezaPedido = (Pedido) session.get(Pedido.class, codigo);
			session.delete(cabezaPedido);
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