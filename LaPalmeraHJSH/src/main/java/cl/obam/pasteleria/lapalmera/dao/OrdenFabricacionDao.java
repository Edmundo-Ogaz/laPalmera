package cl.obam.pasteleria.lapalmera.dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Capturaproduccion;
import cl.obam.pasteleria.lapalmera.model.Detallepedido;
import cl.obam.pasteleria.lapalmera.model.Devolucioninsumo;
import cl.obam.pasteleria.lapalmera.model.Entregainsumo;
import cl.obam.pasteleria.lapalmera.model.Funcionario;
import cl.obam.pasteleria.lapalmera.model.Ordenfabricacion;
import cl.obam.pasteleria.lapalmera.model.Programaproduccion;
import cl.obam.pasteleria.lapalmera.model.Programaproduccion;
import cl.obam.pasteleria.lapalmera.model.Ubicacion;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.EstadoOrdenFabricacionVO;
import cl.obam.pasteleria.lapalmera.view.OrdenFabricacionVO;

@Repository
public class OrdenFabricacionDao {
	
	private static final Logger LOG = Logger.getLogger(OrdenFabricacionDao.class);

	public Ordenfabricacion get(String codigo) throws DAOException {
		LOG.debug("OrdenFabricacionDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Ordenfabricacion ordenFabricacion = null;
		try {
			tx = session.beginTransaction();		
			ordenFabricacion = (Ordenfabricacion) session.createQuery("from Ordenfabricacion where codigoordenfabricacion = ?").setString(0, codigo).uniqueResult();		
			if(ordenFabricacion instanceof Ordenfabricacion) {
				ordenFabricacion.getProducto().getFamilia().getNombrefamilia();
				ordenFabricacion.getProducto().getSubfamilia().getNombresubfamilia();
				ordenFabricacion.getProducto().getOtracaracteristica().getNombreotracaracteristica();
				ordenFabricacion.getProducto().getUnidadmedida().getNombre();
				ordenFabricacion.getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
				ordenFabricacion.getProducto().getTipoproducto().getNombre();
				for(Ubicacion ubicacion : ordenFabricacion.getProducto().getUbicacions()) {
					ubicacion.getBodega().getNombre();
					ubicacion.getUnidadmedida().getNombre();
				}
				ordenFabricacion.getEstadoordenfabricacion().getNombre();
				for(Programaproduccion programaProduccion : ordenFabricacion.getProgramaproduccions()) {
					programaProduccion.getLineaproduccion().getNombrelineaproduccion();					
				}				
				ordenFabricacion.getPedido().getCliente().getNombre();
//				ordenFabricacion.getPedido().getCliente().getComuna().getNombre();
//				ordenFabricacion.getPedido().getCliente().getComuna().getCiudad().getNombre();
				ordenFabricacion.getPedido().getCliente().getComuna().getCiudad().getRegion().getNombre();
				ordenFabricacion.getPedido().getCliente().getTipocliente().getNombre();
				ordenFabricacion.getPedido().getEstadopedido().getNombre();
				ordenFabricacion.getPedido().getDespachopedido().getEntrega().getDescripcion();
				
				for(Detallepedido detallePedido : ordenFabricacion.getPedido().getDetallepedidos()) {
					detallePedido.getProducto().getFamilia().getNombrefamilia();
					detallePedido.getProducto().getSubfamilia().getNombresubfamilia();
					detallePedido.getProducto().getOtracaracteristica().getNombreotracaracteristica();
					detallePedido.getProducto().getUnidadmedida().getNombre();
					detallePedido.getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
					detallePedido.getProducto().getTipoproducto().getNombre();
					for(Ubicacion ubicacion : detallePedido.getProducto().getUbicacions()) {
						ubicacion.getBodega().getNombre();
						ubicacion.getUnidadmedida().getNombre();
					}
				}
				
				for(Entregainsumo entregaInsumo : ordenFabricacion.getEntregainsumos()) {
					entregaInsumo.getObservacion();
					entregaInsumo.getFuncionario().getArea().getNombre();
					entregaInsumo.getFuncionario().getCargo().getNombre();
					entregaInsumo.getDetalleentregainsumo().getProducto().getNombreproducto();
					entregaInsumo.getDetalleentregainsumo().getProducto().getFamilia().getNombrefamilia();
					entregaInsumo.getDetalleentregainsumo().getProducto().getSubfamilia().getNombresubfamilia();
					entregaInsumo.getDetalleentregainsumo().getProducto().getSubfamilia().getFamilia().getNombrefamilia();
					entregaInsumo.getDetalleentregainsumo().getProducto().getOtracaracteristica().getNombreotracaracteristica();
					entregaInsumo.getDetalleentregainsumo().getProducto().getUnidadmedida().getNombre();
					entregaInsumo.getDetalleentregainsumo().getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
					entregaInsumo.getDetalleentregainsumo().getProducto().getTipoproducto().getNombre();
					entregaInsumo.getDetalleentregainsumo().getUnidadmedida().getNombre();
					entregaInsumo.getDetalleentregainsumo().getUnidadmedida().getFamilia().getNombrefamilia();
					for(Ubicacion ubicacion : entregaInsumo.getDetalleentregainsumo().getProducto().getUbicacions()) {
						ubicacion.getBodega().getNombre();
						ubicacion.getUnidadmedida().getNombre();
					}
				}
				for(Devolucioninsumo devolucionInsumo : ordenFabricacion.getDevolucioninsumos()) {
					devolucionInsumo.getObservacion();
					devolucionInsumo.getFuncionario().getArea().getNombre();
					devolucionInsumo.getFuncionario().getCargo().getNombre();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getNombreproducto();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getFamilia().getNombrefamilia();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getSubfamilia().getNombresubfamilia();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getSubfamilia().getFamilia().getNombrefamilia();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getOtracaracteristica().getNombreotracaracteristica();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getUnidadmedida().getNombre();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getTipoproducto().getNombre();
					for(Ubicacion ubicacion : devolucionInsumo.getDetalledevolucioninsumo().getProducto().getUbicacions()) {
						ubicacion.getBodega().getNombre();
						ubicacion.getUnidadmedida().getNombre();
					}
				}
			}
			tx.commit();	
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return ordenFabricacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ordenfabricacion> getAll() throws DAOException {
		LOG.debug("OrdenFabricacionDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ordenfabricacion> listOrdenFabricacion = null;
		try {
			tx = session.beginTransaction();		
			listOrdenFabricacion = (List<Ordenfabricacion>) session.createQuery("from Ordenfabricacion ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOrdenFabricacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ordenfabricacion> getAllEqBy(Ordenfabricacion ordenFabricacion) throws DAOException {
		LOG.debug("OrdenFabricacionDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ordenfabricacion> listOrdenFabricacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ordenfabricacion where 1 = 1 ");
			query.append(ordenFabricacion.getCodigoordenfabricacion() instanceof String && !ordenFabricacion.getCodigoordenfabricacion().isEmpty() ? "and CODIGO = '"  + ordenFabricacion.getCodigoordenfabricacion() + "' " : "");
			query.append(ordenFabricacion.getProducto() != null && ordenFabricacion.getProducto().getCodigoproducto() instanceof String && !ordenFabricacion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + ordenFabricacion.getProducto().getCodigoproducto() + "' " : "");
			query.append(ordenFabricacion.getPedido() != null && ordenFabricacion.getPedido().getNumeropedido() instanceof Integer ? "and pedido.numeropedido = '" + ordenFabricacion.getPedido().getNumeropedido() + "' " : "");
			
			listOrdenFabricacion = (List<Ordenfabricacion>) session.createQuery(query.toString()).list();
			for(Ordenfabricacion obj : listOrdenFabricacion) {
				obj.getProducto().getFamilia().getNombrefamilia();
				obj.getProducto().getSubfamilia().getNombresubfamilia();
				obj.getProducto().getOtracaracteristica().getNombreotracaracteristica();
				obj.getProducto().getUnidadmedida().getNombre();
				obj.getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
				obj.getProducto().getTipoproducto().getNombre();
				ordenFabricacion.getEstadoordenfabricacion().getNombre();
				for(Programaproduccion programarProduccion : ordenFabricacion.getProgramaproduccions()) {
					programarProduccion.getLineaproduccion().getNombrelineaproduccion();					
				}				
				obj.getPedido().getCliente().getNombre();
				obj.getPedido().getEstadopedido().getNombre();
				for(Detallepedido detallePedido : obj.getPedido().getDetallepedidos()) {
					detallePedido.getProducto().getFamilia().getNombrefamilia();
					detallePedido.getProducto().getSubfamilia().getNombresubfamilia();
					detallePedido.getProducto().getOtracaracteristica().getNombreotracaracteristica();
					detallePedido.getProducto().getUnidadmedida().getNombre();
					detallePedido.getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
					detallePedido.getProducto().getTipoproducto().getNombre();
					for(Ubicacion ubicacion : detallePedido.getProducto().getUbicacions()) {
						ubicacion.getBodega().getNombre();
						ubicacion.getUnidadmedida().getNombre();
					}
				}
				for(Entregainsumo entregaInsumo : obj.getEntregainsumos()) {
					entregaInsumo.getObservacion();
					entregaInsumo.getFuncionario().getArea().getNombre();
					entregaInsumo.getFuncionario().getCargo().getNombre();
					entregaInsumo.getDetalleentregainsumo().getProducto().getNombreproducto();
					entregaInsumo.getDetalleentregainsumo().getProducto().getFamilia().getNombrefamilia();
					entregaInsumo.getDetalleentregainsumo().getProducto().getSubfamilia().getNombresubfamilia();
					entregaInsumo.getDetalleentregainsumo().getProducto().getSubfamilia().getFamilia().getNombrefamilia();
					entregaInsumo.getDetalleentregainsumo().getProducto().getOtracaracteristica().getNombreotracaracteristica();
					entregaInsumo.getDetalleentregainsumo().getProducto().getUnidadmedida().getNombre();
					entregaInsumo.getDetalleentregainsumo().getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
					entregaInsumo.getDetalleentregainsumo().getProducto().getTipoproducto().getNombre();
				}
				for(Devolucioninsumo devolucionInsumo : obj.getDevolucioninsumos()) {
					devolucionInsumo.getObservacion();
					devolucionInsumo.getFuncionario().getArea().getNombre();
					devolucionInsumo.getFuncionario().getCargo().getNombre();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getNombreproducto();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getFamilia().getNombrefamilia();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getSubfamilia().getNombresubfamilia();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getSubfamilia().getFamilia().getNombrefamilia();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getOtracaracteristica().getNombreotracaracteristica();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getUnidadmedida().getNombre();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getTipoproducto().getNombre();
				}
//				for(Capturaproduccion capturaproduccion : obj.getCapturaproduccions()) {
//					capturaproduccion.getProducto().getNombreproducto();
//					capturaproduccion.getProducto().getFamilia().getNombrefamilia();
//					capturaproduccion.getProducto().getSubfamilia().getNombresubfamilia();
//					capturaproduccion.getProducto().getSubfamilia().getFamilia().getNombrefamilia();
//					capturaproduccion.getProducto().getOtracaracteristica().getNombreotracaracteristica();
//					capturaproduccion.getProducto().getUnidadmedida().getNombre();
//					capturaproduccion.getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
//					capturaproduccion.getProducto().getTipoproducto().getNombre();
//					for(Funcionario funcionario : capturaproduccion.getFuncionarios()) {
//						funcionario.getArea().getNombre();
//						funcionario.getCargo().getNombre();
//					}
//				}
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOrdenFabricacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<OrdenFabricacionVO> getAllEqBy(OrdenFabricacionVO ordenFabricacionVO) throws DAOException {
		LOG.debug("OrdenFabricacionDao getAllEqBy");
		
		Transaction tx = null;
		List<OrdenFabricacionVO> list = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ordenfabricacion where 1 = 1 ");
			query.append(ordenFabricacionVO.getCodigoOrdenFabricacion() instanceof String && !ordenFabricacionVO.getCodigoOrdenFabricacion().isEmpty() ? "and CODIGOORDENFABRICACION = '"  + ordenFabricacionVO.getCodigoOrdenFabricacion() + "' " : "");			
			query.append(ordenFabricacionVO.getFechaInicio() instanceof String && !ordenFabricacionVO.getFechaInicio().isEmpty() ? "and FECHAINGRESOORDENFABRICACION >= '"  + ordenFabricacionVO.getFechaInicio() + "' " : "");
			query.append(ordenFabricacionVO.getFechaTermino() instanceof String && !ordenFabricacionVO.getFechaTermino().isEmpty() ? "and FECHAINGRESOORDENFABRICACION <= '"  + ordenFabricacionVO.getFechaTermino() + "' " : "");
			query.append(ordenFabricacionVO.getEstadoOrdenFabricacion() instanceof EstadoOrdenFabricacionVO && ordenFabricacionVO.getEstadoOrdenFabricacion().getCodigo() instanceof String && !ordenFabricacionVO.getEstadoOrdenFabricacion().getCodigo().isEmpty() ? "and CODIGOESTADOORDENFABRICACION = '"  + ordenFabricacionVO.getEstadoOrdenFabricacion().getCodigo() + "' " : "");
			
			List<Ordenfabricacion> listOrdenFabricacion = (List<Ordenfabricacion>) session.createQuery(query.toString()).list();
			
			list = new LinkedList<OrdenFabricacionVO>();
			OrdenFabricacionVO obj = null;
			for(Ordenfabricacion ordenFabricacion : listOrdenFabricacion) {
				ordenFabricacion.getProducto().getFamilia().getNombrefamilia();
				ordenFabricacion.getProducto().getSubfamilia().getNombresubfamilia();
				ordenFabricacion.getProducto().getOtracaracteristica().getNombreotracaracteristica();
				ordenFabricacion.getProducto().getUnidadmedida().getNombre();
				ordenFabricacion.getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
				ordenFabricacion.getProducto().getTipoproducto().getNombre();				
				ordenFabricacion.getEstadoordenfabricacion().getNombre();
				
				for(Programaproduccion programarProduccion : ordenFabricacion.getProgramaproduccions()) {
					programarProduccion.getLineaproduccion().getNombrelineaproduccion();					
				}
				
				ordenFabricacion.getPedido().getCliente().getNombre();
				ordenFabricacion.getPedido().getEstadopedido().getNombre();
				for(Detallepedido detallePedido : ordenFabricacion.getPedido().getDetallepedidos()) {
					detallePedido.getProducto().getFamilia().getNombrefamilia();
					detallePedido.getProducto().getSubfamilia().getNombresubfamilia();
					detallePedido.getProducto().getOtracaracteristica().getNombreotracaracteristica();
					detallePedido.getProducto().getUnidadmedida().getNombre();
					detallePedido.getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
					detallePedido.getProducto().getTipoproducto().getNombre();
					for(Ubicacion ubicacion : detallePedido.getProducto().getUbicacions()) {
						ubicacion.getBodega().getNombre();
						ubicacion.getUnidadmedida().getNombre();
					}
				}
				
				for(Entregainsumo entregaInsumo : ordenFabricacion.getEntregainsumos()) {
					entregaInsumo.getObservacion();
					entregaInsumo.getFuncionario().getArea().getNombre();
					entregaInsumo.getFuncionario().getCargo().getNombre();
					entregaInsumo.getDetalleentregainsumo().getProducto().getNombreproducto();
					entregaInsumo.getDetalleentregainsumo().getProducto().getFamilia().getNombrefamilia();
					entregaInsumo.getDetalleentregainsumo().getProducto().getSubfamilia().getNombresubfamilia();
					entregaInsumo.getDetalleentregainsumo().getProducto().getSubfamilia().getFamilia().getNombrefamilia();
					entregaInsumo.getDetalleentregainsumo().getProducto().getOtracaracteristica().getNombreotracaracteristica();
					entregaInsumo.getDetalleentregainsumo().getProducto().getUnidadmedida().getNombre();
					entregaInsumo.getDetalleentregainsumo().getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
					entregaInsumo.getDetalleentregainsumo().getProducto().getTipoproducto().getNombre();
				}
				
				for(Devolucioninsumo devolucionInsumo : ordenFabricacion.getDevolucioninsumos()) {
					devolucionInsumo.getObservacion();
					devolucionInsumo.getFuncionario().getArea().getNombre();
					devolucionInsumo.getFuncionario().getCargo().getNombre();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getNombreproducto();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getFamilia().getNombrefamilia();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getSubfamilia().getNombresubfamilia();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getSubfamilia().getFamilia().getNombrefamilia();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getOtracaracteristica().getNombreotracaracteristica();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getUnidadmedida().getNombre();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
					devolucionInsumo.getDetalledevolucioninsumo().getProducto().getTipoproducto().getNombre();
				}
				
//				for(Capturaproduccion capturaproduccion : ordenFabricacion.getCapturaproduccions()) {
//					capturaproduccion.getProducto().getNombreproducto();
//					capturaproduccion.getProducto().getFamilia().getNombrefamilia();
//					capturaproduccion.getProducto().getSubfamilia().getNombresubfamilia();
//					capturaproduccion.getProducto().getSubfamilia().getFamilia().getNombrefamilia();
//					capturaproduccion.getProducto().getOtracaracteristica().getNombreotracaracteristica();
//					capturaproduccion.getProducto().getUnidadmedida().getNombre();
//					capturaproduccion.getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
//					capturaproduccion.getProducto().getTipoproducto().getNombre();
//					for(Funcionario funcionario : capturaproduccion.getFuncionarios()) {
//						funcionario.getArea().getNombre();
//						funcionario.getCargo().getNombre();
//					}
//				}
				obj = Mapper.from(ordenFabricacion);
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
	public List<Ordenfabricacion> getAllNotEqBy(Ordenfabricacion ordenFabricacion) throws DAOException {
		LOG.debug("OrdenFabricacionDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ordenfabricacion> listOrdenFabricacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ordenfabricacion where 1 = 1 ");
			query.append(ordenFabricacion.getCodigoordenfabricacion() instanceof String && !ordenFabricacion.getCodigoordenfabricacion().isEmpty() ? "and CODIGO = '"  + ordenFabricacion.getCodigoordenfabricacion() + "' " : "");
			query.append(ordenFabricacion.getProducto().getCodigoproducto() instanceof String && !ordenFabricacion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + ordenFabricacion.getProducto().getCodigoproducto() + "' " : "");
			
			listOrdenFabricacion = (List<Ordenfabricacion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOrdenFabricacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ordenfabricacion> getAllBeginWithBy(Ordenfabricacion ordenFabricacion) throws DAOException {
		LOG.debug("OrdenFabricacionDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ordenfabricacion> listOrdenFabricacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ordenfabricacion  where 1 = 1 ");
			query.append(ordenFabricacion.getCodigoordenfabricacion() instanceof String && !ordenFabricacion.getCodigoordenfabricacion().isEmpty() ? "and CODIGO = '"  + ordenFabricacion.getCodigoordenfabricacion() + "' " : "");
			query.append(ordenFabricacion.getProducto().getCodigoproducto() instanceof String && !ordenFabricacion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + ordenFabricacion.getProducto().getCodigoproducto() + "' " : "");
			
			listOrdenFabricacion = (List<Ordenfabricacion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOrdenFabricacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ordenfabricacion> getAllNotBeginWithBy(Ordenfabricacion ordenFabricacion) throws DAOException {
		LOG.debug("OrdenFabricacionDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ordenfabricacion> listOrdenFabricacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ordenfabricacion  where 1 = 1 ");
			query.append(ordenFabricacion.getCodigoordenfabricacion() instanceof String && !ordenFabricacion.getCodigoordenfabricacion().isEmpty() ? "and CODIGO = '"  + ordenFabricacion.getCodigoordenfabricacion() + "' " : "");
			query.append(ordenFabricacion.getProducto().getCodigoproducto() instanceof String && !ordenFabricacion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + ordenFabricacion.getProducto().getCodigoproducto() + "' " : "");
			
			listOrdenFabricacion = (List<Ordenfabricacion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOrdenFabricacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ordenfabricacion> getAllEndWithBy(Ordenfabricacion ordenFabricacion) throws DAOException {
		LOG.debug("OrdenFabricacionDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ordenfabricacion> listOrdenFabricacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ordenfabricacion  where 1 = 1 ");
			query.append(ordenFabricacion.getCodigoordenfabricacion() instanceof String && !ordenFabricacion.getCodigoordenfabricacion().isEmpty() ? "and CODIGO = '"  + ordenFabricacion.getCodigoordenfabricacion() + "' " : "");
			query.append(ordenFabricacion.getProducto().getCodigoproducto() instanceof String && !ordenFabricacion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + ordenFabricacion.getProducto().getCodigoproducto() + "' " : "");
			
			listOrdenFabricacion = (List<Ordenfabricacion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOrdenFabricacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ordenfabricacion> getAllNotEndWithBy(Ordenfabricacion ordenFabricacion) throws DAOException {
		LOG.debug("OrdenFabricacionDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ordenfabricacion> listOrdenFabricacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ordenfabricacion  where 1 = 1 ");
			query.append(ordenFabricacion.getCodigoordenfabricacion() instanceof String && !ordenFabricacion.getCodigoordenfabricacion().isEmpty() ? "and CODIGO = '"  + ordenFabricacion.getCodigoordenfabricacion() + "' " : "");
			query.append(ordenFabricacion.getProducto().getCodigoproducto() instanceof String && !ordenFabricacion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + ordenFabricacion.getProducto().getCodigoproducto() + "' " : "");
			
			listOrdenFabricacion = (List<Ordenfabricacion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOrdenFabricacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ordenfabricacion> getAllContainBy(Ordenfabricacion ordenFabricacion) throws DAOException {
		LOG.debug("OrdenFabricacionDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ordenfabricacion> listOrdenFabricacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ordenfabricacion  where 1 = 1 ");
			query.append(ordenFabricacion.getCodigoordenfabricacion() instanceof String && !ordenFabricacion.getCodigoordenfabricacion().isEmpty() ? "and CODIGO = '"  + ordenFabricacion.getCodigoordenfabricacion() + "' " : "");
			query.append(ordenFabricacion.getProducto().getCodigoproducto() instanceof String && !ordenFabricacion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + ordenFabricacion.getProducto().getCodigoproducto() + "' " : "");
			
			listOrdenFabricacion = (List<Ordenfabricacion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOrdenFabricacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ordenfabricacion> getAllNotContainBy(Ordenfabricacion ordenFabricacion) throws DAOException {
		LOG.debug("OrdenFabricacionDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ordenfabricacion> listOrdenFabricacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ordenfabricacion  where 1 = 1 ");
			query.append(ordenFabricacion.getCodigoordenfabricacion() instanceof String && !ordenFabricacion.getCodigoordenfabricacion().isEmpty() ? "and CODIGO = '"  + ordenFabricacion.getCodigoordenfabricacion() + "' " : "");
			query.append(ordenFabricacion.getProducto().getCodigoproducto() instanceof String && !ordenFabricacion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + ordenFabricacion.getProducto().getCodigoproducto() + "' " : "");
			
			listOrdenFabricacion = (List<Ordenfabricacion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOrdenFabricacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ordenfabricacion> getAllIsNullBy(Ordenfabricacion ordenFabricacion) throws DAOException {
		LOG.debug("OrdenFabricacionDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ordenfabricacion> listOrdenFabricacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ordenfabricacion  where 1 = 1 ");
			query.append(ordenFabricacion.getCodigoordenfabricacion() instanceof String && !ordenFabricacion.getCodigoordenfabricacion().isEmpty() ? "and CODIGO = '"  + ordenFabricacion.getCodigoordenfabricacion() + "' " : "");
			query.append(ordenFabricacion.getProducto().getCodigoproducto() instanceof String && !ordenFabricacion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + ordenFabricacion.getProducto().getCodigoproducto() + "' " : "");
			
			listOrdenFabricacion = (List<Ordenfabricacion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOrdenFabricacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ordenfabricacion> getAllNotIsNullBy(Ordenfabricacion ordenFabricacion) throws DAOException {
		LOG.debug("OrdenFabricacionDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ordenfabricacion> listOrdenFabricacion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ordenfabricacion  where 1 = 1 ");
			query.append(ordenFabricacion.getCodigoordenfabricacion() instanceof String && !ordenFabricacion.getCodigoordenfabricacion().isEmpty() ? "and CODIGO = '"  + ordenFabricacion.getCodigoordenfabricacion() + "' " : "");
			query.append(ordenFabricacion.getProducto().getCodigoproducto() instanceof String && !ordenFabricacion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + ordenFabricacion.getProducto().getCodigoproducto() + "' " : "");
			
			listOrdenFabricacion = (List<Ordenfabricacion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listOrdenFabricacion;
	}
	
	public boolean save(Ordenfabricacion ordenFabricacion) throws DAOException {
		LOG.debug("OrdenFabricacionDao update");
		
		boolean resp = false;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			    	
	    	session.saveOrUpdate(ordenFabricacion);
	    	
	    	for(Programaproduccion programarProduccion : ordenFabricacion.getProgramaproduccions()) {			    		
	    		programarProduccion.setOrdenfabricacion(ordenFabricacion);
	    		session.saveOrUpdate(programarProduccion);
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
	
	public boolean create(Ordenfabricacion ordenFabricacion) throws DAOException {
		LOG.debug("OrdenFabricacionDao create");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();			
			session.save(ordenFabricacion);
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
	
	public boolean update(Ordenfabricacion ordenFabricacion) throws DAOException {
		LOG.debug("OrdenFabricacionDao update");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();			
			session.update(ordenFabricacion);
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
		LOG.debug("OrdenFabricacionDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Ordenfabricacion ordenFabricacion = (Ordenfabricacion) session.get(Ordenfabricacion.class, codigo);
			session.delete(ordenFabricacion);
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