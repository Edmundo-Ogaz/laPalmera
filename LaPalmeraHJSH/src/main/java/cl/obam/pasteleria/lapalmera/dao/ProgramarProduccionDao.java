package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
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
import cl.obam.pasteleria.lapalmera.model.Ubicacion;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.ProgramaProduccionVO;

@Repository
public class ProgramarProduccionDao {
	
	private static final Logger LOG = Logger.getLogger(ProgramarProduccionDao.class);

	public ProgramaProduccionVO get(String codigo) throws DAOException {
		LOG.debug("ProgramaProduccionDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Programaproduccion programarProduccion = null;
		try {
			tx = session.beginTransaction();		
			programarProduccion = (Programaproduccion) session.createQuery("from Programaproduccion where codigo = ?").setString(0, codigo).uniqueResult();		
			getData(programarProduccion);
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return Mapper.from(programarProduccion);
	}
	
	@SuppressWarnings("unchecked")
	public List<Programaproduccion> getAll() throws DAOException {
		LOG.debug("ProgramarProduccionDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Programaproduccion> listProgramarProduccion = null;
		try {
			tx = session.beginTransaction();		
			listProgramarProduccion = (List<Programaproduccion>) session.createQuery("from Programaproduccion ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProgramarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Programaproduccion> getAllEqBy(Programaproduccion programarProduccion) throws DAOException {
		LOG.debug("ProgramarProduccionDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Programaproduccion> listProgramarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Programaproduccion where 1 = 1 ");
			query.append(programarProduccion.getOrdenfabricacion() instanceof Ordenfabricacion && programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() instanceof String && !programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion().isEmpty() ? "and CODIGOORDENFABRICACION = '"  + programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() + "' " : "");
			query.append(programarProduccion.getProducto().getCodigoproducto() instanceof String && !programarProduccion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + programarProduccion.getProducto().getCodigoproducto() + "' " : "");
			
			listProgramarProduccion = (List<Programaproduccion>) session.createQuery(query.toString()).list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProgramarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Programaproduccion> getAllNotEqBy(Programaproduccion programarProduccion) throws DAOException {
		LOG.debug("ProgramarProduccionDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Programaproduccion> listProgramarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Programaproduccion where 1 = 1 ");
			query.append(programarProduccion.getOrdenfabricacion() instanceof Ordenfabricacion && programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() instanceof String && !programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion().isEmpty() ? "and CODIGOORDENFABRICACION = '"  + programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() + "' " : "");
			query.append(programarProduccion.getProducto().getCodigoproducto() instanceof String && !programarProduccion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + programarProduccion.getProducto().getCodigoproducto() + "' " : "");
			
			listProgramarProduccion = (List<Programaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProgramarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Programaproduccion> getAllBeginWithBy(Programaproduccion programarProduccion) throws DAOException {
		LOG.debug("ProgramarProduccionDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Programaproduccion> listProgramarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Programaproduccion  where 1 = 1 ");
			query.append(programarProduccion.getOrdenfabricacion() instanceof Ordenfabricacion && programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() instanceof String && !programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion().isEmpty() ? "and CODIGOORDENFABRICACION = '"  + programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() + "' " : "");
			query.append(programarProduccion.getProducto().getCodigoproducto() instanceof String && !programarProduccion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + programarProduccion.getProducto().getCodigoproducto() + "' " : "");
			
			listProgramarProduccion = (List<Programaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProgramarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Programaproduccion> getAllNotBeginWithBy(Programaproduccion programarProduccion) throws DAOException {
		LOG.debug("ProgramarProduccionDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Programaproduccion> listProgramarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Programaproduccion  where 1 = 1 ");
			query.append(programarProduccion.getOrdenfabricacion() instanceof Ordenfabricacion && programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() instanceof String && !programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion().isEmpty() ? "and CODIGOORDENFABRICACION = '"  + programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() + "' " : "");
			query.append(programarProduccion.getProducto().getCodigoproducto() instanceof String && !programarProduccion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + programarProduccion.getProducto().getCodigoproducto() + "' " : "");
			
			listProgramarProduccion = (List<Programaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProgramarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Programaproduccion> getAllEndWithBy(Programaproduccion programarProduccion) throws DAOException {
		LOG.debug("ProgramarProduccionDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Programaproduccion> listProgramarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Programaproduccion  where 1 = 1 ");
			query.append(programarProduccion.getOrdenfabricacion() instanceof Ordenfabricacion && programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() instanceof String && !programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion().isEmpty() ? "and CODIGOORDENFABRICACION = '"  + programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() + "' " : "");
			query.append(programarProduccion.getProducto().getCodigoproducto() instanceof String && !programarProduccion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + programarProduccion.getProducto().getCodigoproducto() + "' " : "");
			
			listProgramarProduccion = (List<Programaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProgramarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Programaproduccion> getAllNotEndWithBy(Programaproduccion programarProduccion) throws DAOException {
		LOG.debug("ProgramarProduccionDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Programaproduccion> listProgramarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Programaproduccion  where 1 = 1 ");
			query.append(programarProduccion.getOrdenfabricacion() instanceof Ordenfabricacion && programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() instanceof String && !programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion().isEmpty() ? "and CODIGOORDENFABRICACION = '"  + programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() + "' " : "");
			query.append(programarProduccion.getProducto().getCodigoproducto() instanceof String && !programarProduccion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + programarProduccion.getProducto().getCodigoproducto() + "' " : "");
			
			listProgramarProduccion = (List<Programaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProgramarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Programaproduccion> getAllContainBy(Programaproduccion programarProduccion) throws DAOException {
		LOG.debug("ProgramarProduccionDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Programaproduccion> listProgramarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Programaproduccion  where 1 = 1 ");
			query.append(programarProduccion.getOrdenfabricacion() instanceof Ordenfabricacion && programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() instanceof String && !programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion().isEmpty() ? "and CODIGOORDENFABRICACION = '"  + programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() + "' " : "");
			query.append(programarProduccion.getProducto().getCodigoproducto() instanceof String && !programarProduccion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + programarProduccion.getProducto().getCodigoproducto() + "' " : "");
			
			listProgramarProduccion = (List<Programaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProgramarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Programaproduccion> getAllNotContainBy(Programaproduccion programarProduccion) throws DAOException {
		LOG.debug("ProgramarProduccionDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Programaproduccion> listProgramarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Programaproduccion  where 1 = 1 ");
			query.append(programarProduccion.getOrdenfabricacion() instanceof Ordenfabricacion && programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() instanceof String && !programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion().isEmpty() ? "and CODIGOORDENFABRICACION = '"  + programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() + "' " : "");
			query.append(programarProduccion.getProducto().getCodigoproducto() instanceof String && !programarProduccion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + programarProduccion.getProducto().getCodigoproducto() + "' " : "");
			
			listProgramarProduccion = (List<Programaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProgramarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Programaproduccion> getAllIsNullBy(Programaproduccion programarProduccion) throws DAOException {
		LOG.debug("ProgramarProduccionDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Programaproduccion> listProgramarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Programaproduccion  where 1 = 1 ");
			query.append(programarProduccion.getOrdenfabricacion() instanceof Ordenfabricacion && programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() instanceof String && !programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion().isEmpty() ? "and CODIGOORDENFABRICACION = '"  + programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() + "' " : "");
			query.append(programarProduccion.getProducto().getCodigoproducto() instanceof String && !programarProduccion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + programarProduccion.getProducto().getCodigoproducto() + "' " : "");
			
			listProgramarProduccion = (List<Programaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProgramarProduccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Programaproduccion> getAllNotIsNullBy(Programaproduccion programarProduccion) throws DAOException {
		LOG.debug("ProgramarProduccionDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Programaproduccion> listProgramarProduccion = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Programaproduccion  where 1 = 1 ");
			query.append(programarProduccion.getOrdenfabricacion() instanceof Ordenfabricacion && programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() instanceof String && !programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion().isEmpty() ? "and CODIGOORDENFABRICACION = '"  + programarProduccion.getOrdenfabricacion().getCodigoordenfabricacion() + "' " : "");
			query.append(programarProduccion.getProducto().getCodigoproducto() instanceof String && !programarProduccion.getProducto().getCodigoproducto().isEmpty() ? "and NOMBRE = '" + programarProduccion.getProducto().getCodigoproducto() + "' " : "");
			
			listProgramarProduccion = (List<Programaproduccion>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProgramarProduccion;
	}
	
	public boolean save(Programaproduccion obj) throws DAOException {
		LOG.debug("ProgramarProduccionDao save");
		
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
	
	public boolean update(Programaproduccion obj) throws DAOException {
		LOG.debug("ProgramarProduccionDao update");
		
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
		LOG.debug("ProgramarProduccionDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Programaproduccion programarProduccion = (Programaproduccion) session.get(Programaproduccion.class, codigo);
			session.delete(programarProduccion);
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
	
	private void getData(Programaproduccion programaProduccion) {
		programaProduccion.getProducto().getFamilia().getNombrefamilia();
		programaProduccion.getProducto().getSubfamilia().getNombresubfamilia();
		programaProduccion.getProducto().getOtracaracteristica().getNombreotracaracteristica();
		programaProduccion.getLineaproduccion().getNombrelineaproduccion();
		programaProduccion.getProducto().getUnidadmedida();
		programaProduccion.getProducto().getUnidadmedida().getNombre();
		programaProduccion.getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
		programaProduccion.getProducto().getTipoproducto().getNombre();
		
		programaProduccion.getOrdenfabricacion().getEstadoordenfabricacion().getNombre();
		
		programaProduccion.getOrdenfabricacion().getPedido().getCliente().getNombre();
		programaProduccion.getOrdenfabricacion().getPedido().getCliente().getComuna().getCiudad().getRegion().getNombre();
		programaProduccion.getOrdenfabricacion().getPedido().getCliente().getTipocliente().getNombre();
		programaProduccion.getOrdenfabricacion().getPedido().getEstadopedido().getNombre();
		programaProduccion.getOrdenfabricacion().getPedido().getDespachopedido().getEntrega().getDescripcion();
		
		for(Detallepedido detallePedido : programaProduccion.getOrdenfabricacion().getPedido().getDetallepedidos()) {
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
		
		for(Entregainsumo entregaInsumo : programaProduccion.getOrdenfabricacion().getEntregainsumos()) {
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
		for(Devolucioninsumo devolucionInsumo : programaProduccion.getOrdenfabricacion().getDevolucioninsumos()) {
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
		
		for(Capturaproduccion capturaproduccion : programaProduccion.getCapturaproduccions()) {
			capturaproduccion.getProducto().getNombreproducto();
			capturaproduccion.getProducto().getFamilia().getNombrefamilia();
			capturaproduccion.getProducto().getSubfamilia().getNombresubfamilia();
			capturaproduccion.getProducto().getSubfamilia().getFamilia().getNombrefamilia();
			capturaproduccion.getProducto().getOtracaracteristica().getNombreotracaracteristica();
			capturaproduccion.getProducto().getUnidadmedida().getNombre();
			capturaproduccion.getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
			capturaproduccion.getProducto().getTipoproducto().getNombre();
			for(Funcionario funcionario : capturaproduccion.getFuncionarios()) {
				funcionario.getArea().getNombre();
				funcionario.getCargo().getNombre();
			}
		}
	}
	
}