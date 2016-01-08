package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Productolinea;
import cl.obam.pasteleria.lapalmera.model.Ubicacion;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class ProductoLineaDao {
	
	private static final Logger LOG = Logger.getLogger(ProductoLineaDao.class);

	public Productolinea get(String codigo) throws DAOException {
		LOG.debug("ProductoLineaDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Productolinea productoLinea = null;
		try {
			tx = session.beginTransaction();	
			//TODO unico result pero llega null
			productoLinea = (Productolinea) session.createQuery("from Productolinea where codigoproducto = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return productoLinea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Productolinea> getAll() throws DAOException {
		LOG.debug("ProductoLineaDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Productolinea> listProductoLinea = null;
		try {
			tx = session.beginTransaction();		
			listProductoLinea = (List<Productolinea>) session.createQuery("from Productolinea ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProductoLinea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Productolinea> getAllEqBy(Productolinea productoLinea) throws DAOException {
		LOG.debug("ProductoLineaDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Productolinea> listProductoLinea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Productolinea where 1 = 1 ");
			query.append(productoLinea.getProducto() != null && productoLinea.getProducto().getCodigoproducto() instanceof String && !productoLinea.getProducto().getCodigoproducto().isEmpty() ? "and producto.codigoproducto= '"  + productoLinea.getProducto().getCodigoproducto() + "' " : "");
			query.append(productoLinea.getLineaproduccion() != null && productoLinea.getLineaproduccion().getCodigolineaproduccion() instanceof String && !productoLinea.getLineaproduccion().getCodigolineaproduccion().isEmpty() ? "and lineaproduccion.codigolineaproduccion= '"  + productoLinea.getLineaproduccion().getCodigolineaproduccion() + "' " : "");
			query.append(productoLinea.getPrioridad() != 0 ? "and prioridad= '"  + productoLinea.getPrioridad() + "' " : "");
			
			listProductoLinea = (List<Productolinea>) session.createQuery(query.toString()).list();
			for(Productolinea productolinea : listProductoLinea) {
				productolinea.getProducto().getFamilia().getNombrefamilia();
				productolinea.getProducto().getSubfamilia().getNombresubfamilia();
				productolinea.getProducto().getSubfamilia().getFamilia().getNombrefamilia();
				productolinea.getProducto().getOtracaracteristica().getNombreotracaracteristica();
				productolinea.getProducto().getUnidadmedida().getNombre();
				productolinea.getProducto().getUnidadmedida().getFamilia().getNombrefamilia();
				productolinea.getProducto().getTipoproducto().getNombre();
				for(Ubicacion ubicacion : productolinea.getProducto().getUbicacions()) {
					ubicacion.getBodega().getNombre();
					ubicacion.getUnidadmedida().getNombre();
				}
				
				productolinea.getLineaproduccion().getCodigolineaproduccion();
				productolinea.getLineaproduccion().getNombrelineaproduccion();
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProductoLinea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Productolinea> getAllNotEqBy(Productolinea productoLinea) throws DAOException {
		LOG.debug("ProductoLineaDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Productolinea> listProductoLinea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Productolinea where 1 = 1 ");
			query.append(productoLinea.getProducto().getCodigoproducto() instanceof String && !productoLinea.getProducto().getCodigoproducto().isEmpty() ? "and CODIGO = '"  + productoLinea.getProducto().getCodigoproducto() + "' " : "");
			
			listProductoLinea = (List<Productolinea>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProductoLinea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Productolinea> getAllBeginWithBy(Productolinea productoLinea) throws DAOException {
		LOG.debug("ProductoLineaDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Productolinea> listProductoLinea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Productolinea  where 1 = 1 ");
			query.append(productoLinea.getProducto().getCodigoproducto() instanceof String && !productoLinea.getProducto().getCodigoproducto().isEmpty() ? "and CODIGO = '"  + productoLinea.getProducto().getCodigoproducto() + "' " : "");
			
			listProductoLinea = (List<Productolinea>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProductoLinea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Productolinea> getAllNotBeginWithBy(Productolinea productoLinea) throws DAOException {
		LOG.debug("ProductoLineaDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Productolinea> listProductoLinea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Productolinea  where 1 = 1 ");
			query.append(productoLinea.getProducto().getCodigoproducto() instanceof String && !productoLinea.getProducto().getCodigoproducto().isEmpty() ? "and CODIGO = '"  + productoLinea.getProducto().getCodigoproducto() + "' " : "");
			
			listProductoLinea = (List<Productolinea>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProductoLinea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Productolinea> getAllEndWithBy(Productolinea productoLinea) throws DAOException {
		LOG.debug("ProductoLineaDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Productolinea> listProductoLinea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Productolinea  where 1 = 1 ");
			query.append(productoLinea.getProducto().getCodigoproducto() instanceof String && !productoLinea.getProducto().getCodigoproducto().isEmpty() ? "and CODIGO = '"  + productoLinea.getProducto().getCodigoproducto() + "' " : "");
			
			listProductoLinea = (List<Productolinea>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProductoLinea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Productolinea> getAllNotEndWithBy(Productolinea productoLinea) throws DAOException {
		LOG.debug("ProductoLineaDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Productolinea> listProductoLinea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Productolinea  where 1 = 1 ");
			query.append(productoLinea.getProducto().getCodigoproducto() instanceof String && !productoLinea.getProducto().getCodigoproducto().isEmpty() ? "and CODIGO = '"  + productoLinea.getProducto().getCodigoproducto() + "' " : "");
			
			listProductoLinea = (List<Productolinea>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProductoLinea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Productolinea> getAllContainBy(Productolinea productoLinea) throws DAOException {
		LOG.debug("ProductoLineaDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Productolinea> listProductoLinea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Productolinea  where 1 = 1 ");
			query.append(productoLinea.getProducto().getCodigoproducto() instanceof String && !productoLinea.getProducto().getCodigoproducto().isEmpty() ? "and CODIGO = '"  + productoLinea.getProducto().getCodigoproducto() + "' " : "");
			
			listProductoLinea = (List<Productolinea>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProductoLinea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Productolinea> getAllNotContainBy(Productolinea productoLinea) throws DAOException {
		LOG.debug("ProductoLineaDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Productolinea> listProductoLinea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Productolinea  where 1 = 1 ");
			query.append(productoLinea.getProducto().getCodigoproducto() instanceof String && !productoLinea.getProducto().getCodigoproducto().isEmpty() ? "and CODIGO = '"  + productoLinea.getProducto().getCodigoproducto() + "' " : "");
			
			listProductoLinea = (List<Productolinea>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProductoLinea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Productolinea> getAllIsNullBy(Productolinea productoLinea) throws DAOException {
		LOG.debug("ProductoLineaDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Productolinea> listProductoLinea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Productolinea  where 1 = 1 ");
			query.append(productoLinea.getProducto().getCodigoproducto() instanceof String && !productoLinea.getProducto().getCodigoproducto().isEmpty() ? "and CODIGO = '"  + productoLinea.getProducto().getCodigoproducto() + "' " : "");
			
			listProductoLinea = (List<Productolinea>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProductoLinea;
	}
	
	@SuppressWarnings("unchecked")
	public List<Productolinea> getAllNotIsNullBy(Productolinea productoLinea) throws DAOException {
		LOG.debug("ProductoLineaDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Productolinea> listProductoLinea = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Productolinea  where 1 = 1 ");
			query.append(productoLinea.getProducto().getCodigoproducto() instanceof String && !productoLinea.getProducto().getCodigoproducto().isEmpty() ? "and CODIGO = '"  + productoLinea.getProducto().getCodigoproducto() + "' " : "");
			
			listProductoLinea = (List<Productolinea>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProductoLinea;
	}
	
	public boolean save(Productolinea obj) throws DAOException {
		LOG.debug("ProductoLineaDao save");
		
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
	
	public boolean update(Productolinea obj) throws DAOException {
		LOG.debug("ProductoLineaDao update");
		
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
		LOG.debug("ProductoLineaDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Productolinea productoLinea = (Productolinea) session.get(Productolinea.class, codigo);
			session.delete(productoLinea);
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