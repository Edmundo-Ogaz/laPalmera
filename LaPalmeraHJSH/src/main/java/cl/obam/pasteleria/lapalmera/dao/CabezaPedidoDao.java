package cl.obam.pasteleria.lapalmera.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Despachopedido;
import cl.obam.pasteleria.lapalmera.model.Detallepedido;
import cl.obam.pasteleria.lapalmera.model.Entrega;
import cl.obam.pasteleria.lapalmera.model.Ordenfabricacion;
import cl.obam.pasteleria.lapalmera.model.Pedido;
import cl.obam.pasteleria.lapalmera.model.Programaproduccion;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.CabezaPedidoVO;

@Repository
public class CabezaPedidoDao {
	
	private static final Logger LOG = Logger.getLogger(CabezaPedidoDao.class);

	public Pedido get(String codigo) throws DAOException {
		LOG.debug("CabezaPedidoDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Pedido cabezaPedido = null;
		try {
			tx = session.beginTransaction();		
			cabezaPedido = (Pedido) session.createQuery("from Pedido where numeropedido = ?").setString(0, codigo).uniqueResult();
			cabezaPedido.getEstadopedido().getNombre();
			cabezaPedido.getCliente().getComuna();
			cabezaPedido.getCliente().getComuna().getCiudad().getNombre();
			cabezaPedido.getCliente().getComuna().getCiudad().getRegion().getNombre();
			cabezaPedido.getCliente().getTipocliente().getNombre();
			for(Detallepedido detallePedido : cabezaPedido.getDetallepedidos()) {
				detallePedido.getProducto().getNombreproducto();
				detallePedido.getProducto().getFamilia().getNombrefamilia();
				detallePedido.getProducto().getSubfamilia().getNombresubfamilia();
				detallePedido.getProducto().getOtracaracteristica().getNombreotracaracteristica();
				detallePedido.getProducto().getUnidadmedida().getNombre();
				detallePedido.getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
				detallePedido.getProducto().getTipoproducto().getNombre();
			}
			if(cabezaPedido.getDespachopedido() instanceof Despachopedido && 
					cabezaPedido.getDespachopedido().getEntrega() instanceof Entrega) {
				cabezaPedido.getDespachopedido().getEntrega().getDescripcion();
			}
			cabezaPedido.getConfirmacionpedido();
			for(Ordenfabricacion ordenFabricacion : cabezaPedido.getOrdenfabricacions()) {
				ordenFabricacion.getProducto().getNombreproducto();
				ordenFabricacion.getProducto().getFamilia().getNombrefamilia();
				ordenFabricacion.getProducto().getSubfamilia().getNombresubfamilia();
				ordenFabricacion.getProducto().getOtracaracteristica().getNombreotracaracteristica();
				ordenFabricacion.getProducto().getUnidadmedida().getNombre();
				ordenFabricacion.getProducto().getTipoproducto().getNombre();
				ordenFabricacion.getEstadoordenfabricacion().getNombre();
				for(Programaproduccion programaProduccion : ordenFabricacion.getProgramaproduccions()) {
					programaProduccion.getLineaproduccion().getNombrelineaproduccion();					
				}
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return cabezaPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> getAll() throws DAOException {
		LOG.debug("PedidoDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Pedido> listPedido = null;
		try {
			tx = session.beginTransaction();		
			listPedido = (List<Pedido>) session.createQuery("from Pedido ").list();
			for(Pedido obj : listPedido) {
				obj.getEstadopedido().getNombre();
				obj.getCliente().getComuna().getNombre();
				obj.getCliente().getComuna().getCiudad().getNombre();
				obj.getCliente().getComuna().getCiudad().getRegion().getNombre();
				obj.getCliente().getTipocliente().getNombre();
				for(Detallepedido detallePedido : obj.getDetallepedidos()) {
					detallePedido.getProducto().getNombreproducto();
					detallePedido.getProducto().getFamilia().getNombrefamilia();
					detallePedido.getProducto().getSubfamilia().getNombresubfamilia();
					detallePedido.getProducto().getOtracaracteristica().getNombreotracaracteristica();
					detallePedido.getProducto().getUnidadmedida().getNombre();
					detallePedido.getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
					detallePedido.getProducto().getTipoproducto().getNombre();
				}
				if(obj.getDespachopedido() instanceof Despachopedido && 
						obj.getDespachopedido().getEntrega() instanceof Entrega) {
					obj.getDespachopedido().getEntrega().getDescripcion();
				}
				obj.getConfirmacionpedido();
				for(Ordenfabricacion ordenFabricacion : obj.getOrdenfabricacions()) {
					ordenFabricacion.getProducto().getNombreproducto();
					ordenFabricacion.getProducto().getFamilia().getNombrefamilia();
					ordenFabricacion.getProducto().getSubfamilia().getNombresubfamilia();
					ordenFabricacion.getProducto().getOtracaracteristica().getNombreotracaracteristica();
					ordenFabricacion.getProducto().getUnidadmedida().getNombre();
					ordenFabricacion.getProducto().getTipoproducto().getNombre();
					ordenFabricacion.getEstadoordenfabricacion().getNombre();
					for(Programaproduccion programaProduccion : ordenFabricacion.getProgramaproduccions()) {
						programaProduccion.getLineaproduccion().getNombrelineaproduccion();					
					}
				}
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> getAllEqBy(Pedido cabezaPedido) throws DAOException {
		LOG.debug("CabezaPedidoDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Pedido> listCabezaPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Pedido where 1 = 1 ");
			query.append(cabezaPedido.getNumeropedido() instanceof Integer ? "and NUMEROPEDIDO = '"  + cabezaPedido.getNumeropedido() + "' " : "");
			query.append(cabezaPedido.getCliente() != null && cabezaPedido.getCliente().getRut() instanceof String && !cabezaPedido.getCliente().getRut().isEmpty() ? "and RUTCLIENTE = '" + cabezaPedido.getCliente().getRut() + "' " : "");
			query.append(cabezaPedido.getEstadopedido() != null && cabezaPedido.getEstadopedido().getCodigo() instanceof String && !cabezaPedido.getEstadopedido().getCodigo().isEmpty() ? "and CODIGOESTADOPEDIDO = '" + cabezaPedido.getEstadopedido().getCodigo() + "' " : "");
			
			listCabezaPedido = (List<Pedido>) session.createQuery(query.toString()).list();
			for(Pedido obj : listCabezaPedido) {
				obj.getEstadopedido().getNombre();
				obj.getCliente().getComuna().getNombre();
				obj.getCliente().getComuna().getCiudad().getNombre();
				obj.getCliente().getComuna().getCiudad().getRegion().getNombre();
				obj.getCliente().getTipocliente().getNombre();
				for(Detallepedido detallePedido : obj.getDetallepedidos()) {
					detallePedido.getProducto().getNombreproducto();
					detallePedido.getProducto().getFamilia().getNombrefamilia();
					detallePedido.getProducto().getSubfamilia().getNombresubfamilia();
					detallePedido.getProducto().getOtracaracteristica().getNombreotracaracteristica();
					detallePedido.getProducto().getUnidadmedida().getNombre();
					detallePedido.getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
					detallePedido.getProducto().getTipoproducto().getNombre();
				}
				if(obj.getDespachopedido() instanceof Despachopedido && 
						obj.getDespachopedido().getEntrega() instanceof Entrega) {
					obj.getDespachopedido().getEntrega().getDescripcion();
				}
				obj.getConfirmacionpedido();
				for(Ordenfabricacion ordenFabricacion : obj.getOrdenfabricacions()) {
					ordenFabricacion.getProducto().getNombreproducto();
					ordenFabricacion.getProducto().getFamilia().getNombrefamilia();
					ordenFabricacion.getProducto().getSubfamilia().getNombresubfamilia();
					ordenFabricacion.getProducto().getOtracaracteristica().getNombreotracaracteristica();
					ordenFabricacion.getProducto().getUnidadmedida().getNombre();
					ordenFabricacion.getProducto().getTipoproducto().getNombre();
					ordenFabricacion.getEstadoordenfabricacion().getNombre();
					for(Programaproduccion programaProduccion : ordenFabricacion.getProgramaproduccions()) {
						programaProduccion.getLineaproduccion().getNombrelineaproduccion();					
					}
				}
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCabezaPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<CabezaPedidoVO> getAllEqBy(CabezaPedidoVO cabezaPedido) throws DAOException {
		LOG.debug("CabezaPedidoDao getAllEqBy");
		
		Transaction tx = null;
		List<CabezaPedidoVO> list = new ArrayList<CabezaPedidoVO>();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Pedido where 1 = 1 ");
			query.append(cabezaPedido.getNumeroPedido() instanceof Integer ? "and NUMEROPEDIDO = '"  + cabezaPedido.getNumeroPedido() + "' " : "");
			query.append(cabezaPedido.getCliente() != null && cabezaPedido.getCliente().getRut() instanceof String && !cabezaPedido.getCliente().getRut().isEmpty() ? "and RUTCLIENTE = '" + cabezaPedido.getCliente().getRut() + "' " : "");
			query.append(cabezaPedido.getEstadoPedido() != null && cabezaPedido.getEstadoPedido().getCodigo() instanceof String && !cabezaPedido.getEstadoPedido().getCodigo().isEmpty() ? "and CODIGOESTADOPEDIDO = '" + cabezaPedido.getEstadoPedido().getCodigo() + "' " : "");
			query.append(cabezaPedido.getFechaInicio() instanceof String && !cabezaPedido.getFechaInicio().isEmpty() ? "and FECHAPEDIDO >= '"  + cabezaPedido.getFechaInicio() + "' " : "");
			query.append(cabezaPedido.getFechaTermino() instanceof String && !cabezaPedido.getFechaTermino().isEmpty() ? "and FECHAPEDIDO <= '"  + cabezaPedido.getFechaTermino() + "' " : "");
			
			List<Pedido> listCabezaPedido = (List<Pedido>) session.createQuery(query.toString()).list();
			
			CabezaPedidoVO obj = null;
			for(Pedido pedido : listCabezaPedido) {
				pedido.getEstadopedido().getNombre();
				pedido.getCliente().getComuna().getNombre();
				pedido.getCliente().getComuna().getCiudad().getNombre();
				pedido.getCliente().getComuna().getCiudad().getRegion().getNombre();
				pedido.getCliente().getTipocliente().getNombre();
				for(Detallepedido detallePedido : pedido.getDetallepedidos()) {
					detallePedido.getProducto().getNombreproducto();
					detallePedido.getProducto().getFamilia().getNombrefamilia();
					detallePedido.getProducto().getSubfamilia().getNombresubfamilia();
					detallePedido.getProducto().getOtracaracteristica().getNombreotracaracteristica();
					detallePedido.getProducto().getUnidadmedida().getNombre();
					detallePedido.getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
					detallePedido.getProducto().getTipoproducto().getNombre();
				}
				if(pedido.getDespachopedido() instanceof Despachopedido && 
						pedido.getDespachopedido().getEntrega() instanceof Entrega) {
					pedido.getDespachopedido().getEntrega().getDescripcion();
				}
				pedido.getConfirmacionpedido();
				for(Ordenfabricacion ordenFabricacion : pedido.getOrdenfabricacions()) {
					ordenFabricacion.getProducto().getNombreproducto();
					ordenFabricacion.getProducto().getFamilia().getNombrefamilia();
					ordenFabricacion.getProducto().getSubfamilia().getNombresubfamilia();
					ordenFabricacion.getProducto().getOtracaracteristica().getNombreotracaracteristica();
					ordenFabricacion.getProducto().getUnidadmedida().getNombre();
					ordenFabricacion.getProducto().getTipoproducto().getNombre();
					ordenFabricacion.getEstadoordenfabricacion().getNombre();
					for(Programaproduccion programaProduccion : ordenFabricacion.getProgramaproduccions()) {
						programaProduccion.getLineaproduccion().getNombrelineaproduccion();					
					}					
				}
				obj = Mapper.from(pedido);
				list.add(obj);
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> getAllNotEqBy(Pedido cabezaPedido) throws DAOException {
		LOG.debug("CabezaPedidoDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Pedido> listCabezaPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Pedido where 1 = 1 ");
			query.append(cabezaPedido.getNumeropedido() instanceof Integer ? "and CODIGO = '"  + cabezaPedido.getNumeropedido() + "' " : "");
			query.append(cabezaPedido.getCliente() != null && cabezaPedido.getCliente().getRut() instanceof String && !cabezaPedido.getCliente().getRut().isEmpty() ? "and Cliente.rut = '" + cabezaPedido.getCliente().getRut() + "' " : "");
			
			listCabezaPedido = (List<Pedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCabezaPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> getAllBeginWithBy(Pedido cabezaPedido) throws DAOException {
		LOG.debug("CabezaPedidoDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Pedido> listCabezaPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Pedido  where 1 = 1 ");
			query.append(cabezaPedido.getNumeropedido() instanceof Integer ? "and CODIGO = '"  + cabezaPedido.getNumeropedido() + "' " : "");
			query.append(cabezaPedido.getCliente() != null && cabezaPedido.getCliente().getRut() instanceof String && !cabezaPedido.getCliente().getRut().isEmpty() ? "and Cliente.rut = '" + cabezaPedido.getCliente().getRut() + "' " : "");
			
			listCabezaPedido = (List<Pedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCabezaPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> getAllNotBeginWithBy(Pedido cabezaPedido) throws DAOException {
		LOG.debug("CabezaPedidoDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Pedido> listCabezaPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Pedido  where 1 = 1 ");
			query.append(cabezaPedido.getNumeropedido() instanceof Integer ? "and CODIGO = '"  + cabezaPedido.getNumeropedido() + "' " : "");
			query.append(cabezaPedido.getCliente() != null && cabezaPedido.getCliente().getRut() instanceof String && !cabezaPedido.getCliente().getRut().isEmpty() ? "and Cliente.rut = '" + cabezaPedido.getCliente().getRut() + "' " : "");
			
			listCabezaPedido = (List<Pedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCabezaPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> getAllEndWithBy(Pedido cabezaPedido) throws DAOException {
		LOG.debug("CabezaPedidoDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Pedido> listCabezaPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Pedido  where 1 = 1 ");
			query.append(cabezaPedido.getNumeropedido() instanceof Integer ? "and CODIGO = '"  + cabezaPedido.getNumeropedido() + "' " : "");
			query.append(cabezaPedido.getCliente() != null && cabezaPedido.getCliente().getRut() instanceof String && !cabezaPedido.getCliente().getRut().isEmpty() ? "and Cliente.rut = '" + cabezaPedido.getCliente().getRut() + "' " : "");
			
			listCabezaPedido = (List<Pedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCabezaPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> getAllNotEndWithBy(Pedido cabezaPedido) throws DAOException {
		LOG.debug("CabezaPedidoDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Pedido> listCabezaPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Pedido  where 1 = 1 ");
			query.append(cabezaPedido.getNumeropedido() instanceof Integer ? "and CODIGO = '"  + cabezaPedido.getNumeropedido() + "' " : "");
			query.append(cabezaPedido.getCliente() != null && cabezaPedido.getCliente().getRut() instanceof String && !cabezaPedido.getCliente().getRut().isEmpty() ? "and Cliente.rut = '" + cabezaPedido.getCliente().getRut() + "' " : "");
			
			listCabezaPedido = (List<Pedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCabezaPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> getAllContainBy(Pedido cabezaPedido) throws DAOException {
		LOG.debug("CabezaPedidoDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Pedido> listCabezaPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Pedido  where 1 = 1 ");
			query.append(cabezaPedido.getNumeropedido() instanceof Integer ? "and CODIGO = '"  + cabezaPedido.getNumeropedido() + "' " : "");
			query.append(cabezaPedido.getCliente() != null && cabezaPedido.getCliente().getRut() instanceof String && !cabezaPedido.getCliente().getRut().isEmpty() ? "and Cliente.rut = '" + cabezaPedido.getCliente().getRut() + "' " : "");
			
			listCabezaPedido = (List<Pedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCabezaPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> getAllNotContainBy(Pedido cabezaPedido) throws DAOException {
		LOG.debug("CabezaPedidoDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Pedido> listCabezaPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Pedido  where 1 = 1 ");
			query.append(cabezaPedido.getNumeropedido() instanceof Integer ? "and CODIGO = '"  + cabezaPedido.getNumeropedido() + "' " : "");
			query.append(cabezaPedido.getCliente() != null && cabezaPedido.getCliente().getRut() instanceof String && !cabezaPedido.getCliente().getRut().isEmpty() ? "and Cliente.rut = '" + cabezaPedido.getCliente().getRut() + "' " : "");
			
			listCabezaPedido = (List<Pedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCabezaPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> getAllIsNullBy(Pedido cabezaPedido) throws DAOException {
		LOG.debug("CabezaPedidoDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Pedido> listCabezaPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Pedido  where 1 = 1 ");
			query.append(cabezaPedido.getNumeropedido() instanceof Integer ? "and CODIGO = '"  + cabezaPedido.getNumeropedido() + "' " : "");
			query.append(cabezaPedido.getCliente() != null && cabezaPedido.getCliente().getRut() instanceof String && !cabezaPedido.getCliente().getRut().isEmpty() ? "and Cliente.rut = '" + cabezaPedido.getCliente().getRut() + "' " : "");
			
			listCabezaPedido = (List<Pedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCabezaPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> getAllNotIsNullBy(Pedido cabezaPedido) throws DAOException {
		LOG.debug("CabezaPedidoDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Pedido> listCabezaPedido = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Pedido  where 1 = 1 ");
			query.append(cabezaPedido.getNumeropedido() instanceof Integer ? "and CODIGO = '"  + cabezaPedido.getNumeropedido() + "' " : "");
			query.append(cabezaPedido.getCliente() != null && cabezaPedido.getCliente().getRut() instanceof String && !cabezaPedido.getCliente().getRut().isEmpty() ? "and Cliente.rut = '" + cabezaPedido.getCliente().getRut() + "' " : "");
			
			listCabezaPedido = (List<Pedido>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listCabezaPedido;
	}
	
	public boolean save(Pedido obj) throws DAOException {
		LOG.debug("CabezaPedidoDao save");
		
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
	
	public boolean update(Pedido obj) throws DAOException {
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