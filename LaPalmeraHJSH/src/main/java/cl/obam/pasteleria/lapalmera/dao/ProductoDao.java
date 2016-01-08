package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Ingrediente;
import cl.obam.pasteleria.lapalmera.model.Producto;
import cl.obam.pasteleria.lapalmera.model.Ubicacion;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.ProductoVO;

@Repository
public class ProductoDao {
	
	private static final Logger LOG = Logger.getLogger(ProductoDao.class);

	public Producto get(String codigo) throws DAOException {
		LOG.debug("ProductoDao get " + codigo);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Producto producto = null;
		try {
			tx = session.beginTransaction();
			producto = (Producto) session.createQuery("from Producto where codigoproducto = ?").setString(0, codigo).uniqueResult();
			producto.getFamilia().getNombrefamilia();
			producto.getSubfamilia().getNombresubfamilia();
			producto.getSubfamilia().getFamilia().getNombrefamilia();
			producto.getOtracaracteristica().getNombreotracaracteristica();
			producto.getUnidadmedida().getNombre();
			producto.getUnidadmedida().getFamilia().getNombrefamilia();
			producto.getTipoproducto().getNombre();
			//producto.getStock();
			if(producto.getStock() != null) {
				producto.getStock().getUnidadmedida().getFamilia().getNombrefamilia();
			}
			for(Ubicacion ubicacion : producto.getUbicacions()) {
				ubicacion.getBodega().getNombre();
				//ubicacion.getUnidadmedida().getNombre();
				ubicacion.getUnidadmedida().getFamilia().getNombrefamilia();
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return producto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> getAll() throws DAOException {
		LOG.debug("ProductoDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Producto> listProducto = null;
		try {
			tx = session.beginTransaction();		
			listProducto = (List<Producto>) session.createQuery("from Producto ").list();
			for(Producto obj : listProducto) {
				obj.getFamilia().getNombrefamilia();
				obj.getSubfamilia().getNombresubfamilia();
				obj.getOtracaracteristica().getNombreotracaracteristica();
				obj.getUnidadmedida().getNombre();
				obj.getUnidadmedida().getFamilia().getNombrefamilia();
				obj.getTipoproducto().getNombre();
				for(Ubicacion ubicacion : obj.getUbicacions()) {
					ubicacion.getBodega().getNombre();
					ubicacion.getUnidadmedida().getNombre();
				}
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProducto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> getAllEqBy(Producto producto) throws DAOException {
		LOG.debug("ProductoDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Producto> listProducto = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Producto where 1 = 1 ");
			query.append(producto.getCodigoproducto() instanceof String && !producto.getCodigoproducto().isEmpty() ? "and CODIGOPRODUCTO = '"  + producto.getCodigoproducto() + "' " : "");
			query.append(producto.getNombreproducto() instanceof String && !producto.getNombreproducto().isEmpty() ? "and NOMBRE = '" + producto.getNombreproducto() + "' " : "");
			query.append(producto.getTipoproducto() != null &&
					producto.getTipoproducto().getCodigo() instanceof String && 
					!producto.getTipoproducto().getCodigo().isEmpty() ? 
							"and tipoproducto.codigo = '" + producto.getTipoproducto().getCodigo() + "' " : "");
			
			listProducto = (List<Producto>) session.createQuery(query.toString()).list();
			for(Producto obj : listProducto) {
				obj.getFamilia().getNombrefamilia();
				obj.getSubfamilia().getNombresubfamilia();
				obj.getSubfamilia().getFamilia().getNombrefamilia();
				obj.getOtracaracteristica().getNombreotracaracteristica();
				obj.getUnidadmedida().getNombre();
				obj.getTipoproducto().getNombre();
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProducto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> getAllNotEqBy(Producto producto) throws DAOException {
		LOG.debug("ProductoDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Producto> listProducto = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Producto where 1 = 1 ");
			query.append(producto.getCodigoproducto() instanceof String && 
					!producto.getCodigoproducto().isEmpty() ? 
							"and CODIGO != '"  + producto.getCodigoproducto() + "' " : "");
			query.append(producto.getNombreproducto() instanceof String && 
					!producto.getNombreproducto().isEmpty() ? 
							"and NOMBRE != '" + producto.getNombreproducto() + "' " : "");
			query.append(producto.getTipoproducto() != null &&
					producto.getTipoproducto().getCodigo() instanceof String && 
					!producto.getTipoproducto().getCodigo().isEmpty() ? 
							"and tipoproducto.codigo != '" + producto.getTipoproducto().getCodigo() + "' " : "");
			
			listProducto = (List<Producto>) session.createQuery(query.toString()).list();
			for(Producto obj : listProducto) {
				obj.getFamilia().getNombrefamilia();
				obj.getSubfamilia().getNombresubfamilia();
				obj.getSubfamilia().getFamilia().getNombrefamilia();
				obj.getOtracaracteristica().getNombreotracaracteristica();
				obj.getUnidadmedida().getNombre();
				obj.getUnidadmedida().getFamilia().getNombrefamilia();
				obj.getTipoproducto().getNombre();
				for(Ubicacion ubicacion : obj.getUbicacions()) {
					ubicacion.getBodega().getNombre();
					ubicacion.getUnidadmedida().getNombre();
					ubicacion.getUnidadmedida().getFamilia().getNombrefamilia();
				}
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProducto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> getAllBeginWithBy(Producto producto) throws DAOException {
		LOG.debug("ProductoDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Producto> listProducto = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Producto  where 1 = 1 ");
			query.append(producto.getCodigoproducto() instanceof String && !producto.getCodigoproducto().isEmpty() ? "and CODIGO = '"  + producto.getCodigoproducto() + "' " : "");
			query.append(producto.getNombreproducto() instanceof String && !producto.getNombreproducto().isEmpty() ? "and NOMBRE = '" + producto.getNombreproducto() + "' " : "");
			
			listProducto = (List<Producto>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProducto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> getAllNotBeginWithBy(Producto producto) throws DAOException {
		LOG.debug("ProductoDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Producto> listProducto = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Producto  where 1 = 1 ");
			query.append(producto.getCodigoproducto() instanceof String && !producto.getCodigoproducto().isEmpty() ? "and CODIGO = '"  + producto.getCodigoproducto() + "' " : "");
			query.append(producto.getNombreproducto() instanceof String && !producto.getNombreproducto().isEmpty() ? "and NOMBRE = '" + producto.getNombreproducto() + "' " : "");
			
			listProducto = (List<Producto>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProducto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> getAllEndWithBy(Producto producto) throws DAOException {
		LOG.debug("ProductoDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Producto> listProducto = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Producto  where 1 = 1 ");
			query.append(producto.getCodigoproducto() instanceof String && !producto.getCodigoproducto().isEmpty() ? "and CODIGO = '"  + producto.getCodigoproducto() + "' " : "");
			query.append(producto.getNombreproducto() instanceof String && !producto.getNombreproducto().isEmpty() ? "and NOMBRE = '" + producto.getNombreproducto() + "' " : "");
			
			listProducto = (List<Producto>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProducto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> getAllNotEndWithBy(Producto producto) throws DAOException {
		LOG.debug("ProductoDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Producto> listProducto = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Producto  where 1 = 1 ");
			query.append(producto.getCodigoproducto() instanceof String && !producto.getCodigoproducto().isEmpty() ? "and CODIGO = '"  + producto.getCodigoproducto() + "' " : "");
			query.append(producto.getNombreproducto() instanceof String && !producto.getNombreproducto().isEmpty() ? "and NOMBRE = '" + producto.getNombreproducto() + "' " : "");
			
			listProducto = (List<Producto>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProducto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> getAllContainBy(Producto producto) throws DAOException {
		LOG.debug("ProductoDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Producto> listProducto = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Producto  where 1 = 1 ");
			query.append(producto.getCodigoproducto() instanceof String && !producto.getCodigoproducto().isEmpty() ? "and CODIGO = '"  + producto.getCodigoproducto() + "' " : "");
			query.append(producto.getNombreproducto() instanceof String && !producto.getNombreproducto().isEmpty() ? "and NOMBRE = '" + producto.getNombreproducto() + "' " : "");
			
			listProducto = (List<Producto>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProducto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> getAllNotContainBy(Producto producto) throws DAOException {
		LOG.debug("ProductoDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Producto> listProducto = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Producto  where 1 = 1 ");
			query.append(producto.getCodigoproducto() instanceof String && !producto.getCodigoproducto().isEmpty() ? "and CODIGO = '"  + producto.getCodigoproducto() + "' " : "");
			query.append(producto.getNombreproducto() instanceof String && !producto.getNombreproducto().isEmpty() ? "and NOMBRE = '" + producto.getNombreproducto() + "' " : "");
			
			listProducto = (List<Producto>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProducto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> getAllIsNullBy(Producto producto) throws DAOException {
		LOG.debug("ProductoDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Producto> listProducto = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Producto  where 1 = 1 ");
			query.append(producto.getCodigoproducto() instanceof String && !producto.getCodigoproducto().isEmpty() ? "and CODIGO = '"  + producto.getCodigoproducto() + "' " : "");
			query.append(producto.getNombreproducto() instanceof String && !producto.getNombreproducto().isEmpty() ? "and NOMBRE = '" + producto.getNombreproducto() + "' " : "");
			
			listProducto = (List<Producto>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProducto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> getAllNotIsNullBy(Producto producto) throws DAOException {
		LOG.debug("ProductoDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Producto> listProducto = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Producto  where 1 = 1 ");
			query.append(producto.getCodigoproducto() instanceof String && !producto.getCodigoproducto().isEmpty() ? "and CODIGO = '"  + producto.getCodigoproducto() + "' " : "");
			query.append(producto.getNombreproducto() instanceof String && !producto.getNombreproducto().isEmpty() ? "and NOMBRE = '" + producto.getNombreproducto() + "' " : "");
			
			listProducto = (List<Producto>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listProducto;
	}
	
	public boolean save(Producto obj) throws DAOException {
		LOG.debug("ProductoDao save");
		
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
	
	public boolean update(Producto obj) throws DAOException {
		LOG.debug("ProductoDao update");
		
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
		LOG.debug("ProductoDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Producto producto = (Producto) session.get(Producto.class, codigo);
			session.delete(producto);
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
	
	public ProductoVO ingreso(ProductoVO productoVO) throws DAOException {
		LOG.debug("ProductoDao ingreso");
		
		Producto producto = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();

			producto = Mapper.from(productoVO, productoVO.getStock(), productoVO.getUbicacions());
			
			session.saveOrUpdate(producto.getStock());
			
		    for(Ubicacion ubicacion : producto.getUbicacions()) {
		    	session.save(ubicacion);
		    }
		    
		    tx.commit();

		} catch (Exception e) {
			LOG.error("Fatal " + e.getMessage(), e);
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
		return Mapper.from(producto);
	}
}