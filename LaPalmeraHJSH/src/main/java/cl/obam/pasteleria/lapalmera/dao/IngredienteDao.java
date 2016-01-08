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
import cl.obam.pasteleria.lapalmera.model.IngredienteId;
import cl.obam.pasteleria.lapalmera.model.Producto;
import cl.obam.pasteleria.lapalmera.model.Ubicacion;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class IngredienteDao {
	
	private static final Logger LOG = Logger.getLogger(IngredienteDao.class);

	public Ingrediente get(String codigo) throws DAOException {
		LOG.debug("IngredienteDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Ingrediente ingrediente = null;
		try {
			tx = session.beginTransaction();		
			ingrediente = (Ingrediente) session.createQuery("from Ingrediente where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return ingrediente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ingrediente> getAll() throws DAOException {
		LOG.debug("IngredienteDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ingrediente> listIngrediente = null;
		try {
			tx = session.beginTransaction();		
			listIngrediente = (List<Ingrediente>) session.createQuery("from Ingrediente ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listIngrediente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ingrediente> getAllEqBy(Ingrediente ingrediente) throws DAOException {
		LOG.debug("IngredienteDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ingrediente> listIngrediente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ingrediente i where 1 = 1 ");
			query.append(ingrediente.getProductoByCodigoproducto() != null && ingrediente.getProductoByCodigoproducto().getCodigoproducto() instanceof String && !ingrediente.getProductoByCodigoproducto().getCodigoproducto().isEmpty()? "and productoByCodigoproducto.codigoproducto = '" + ingrediente.getProductoByCodigoproducto().getCodigoproducto() + "' " : "");
			query.append(ingrediente.getProductoByCodigoinsumo() != null && ingrediente.getProductoByCodigoinsumo().getCodigoproducto() instanceof String && !ingrediente.getProductoByCodigoinsumo().getCodigoproducto().isEmpty()? "and productoByCodigoinsumo.codigoproducto = '" + ingrediente.getProductoByCodigoinsumo().getCodigoproducto() + "' " : "");
			query.append(ingrediente.getCarga() != 0  ? "and carga = '" + ingrediente.getCarga() + "' " : "");
			query.append(ingrediente.getUnidadmedida() != null && ingrediente.getUnidadmedida().getCodigo() instanceof String && !ingrediente.getUnidadmedida().getCodigo().isEmpty() ? "and unidadmedida.codigo = '"  + ingrediente.getUnidadmedida().getCodigo() + "' " : "");
						
			listIngrediente = (List<Ingrediente>) session.createQuery(query.toString()).list();
			for(Ingrediente obj : listIngrediente) {
				obj.getUnidadmedida().getNombre();
				obj.getUnidadmedida().getFamilia().getNombrefamilia();
				
				obj.getProductoByCodigoproducto().getFamilia().getNombrefamilia();
				obj.getProductoByCodigoproducto().getSubfamilia().getNombresubfamilia();
				obj.getProductoByCodigoproducto().getSubfamilia().getFamilia().getNombrefamilia();
				obj.getProductoByCodigoproducto().getOtracaracteristica().getCodigootracaracteristica();
				obj.getProductoByCodigoproducto().getUnidadmedida().getNombre();
				obj.getProductoByCodigoproducto().getUnidadmedida().getFamilia().getNombrefamilia();
				obj.getProductoByCodigoproducto().getTipoproducto().getNombre();
//				for(Ubicacion ubicacion : obj.getProductoByCodigoproducto().getUbicacions()) {
//					ubicacion.getBodega().getNombre();
//					ubicacion.getUnidadmedida().getNombre();
//				}
				
				obj.getProductoByCodigoinsumo();
				obj.getProductoByCodigoinsumo().getFamilia().getNombrefamilia();
				obj.getProductoByCodigoinsumo().getSubfamilia().getNombresubfamilia();
				obj.getProductoByCodigoinsumo().getOtracaracteristica().getNombreotracaracteristica();
				obj.getProductoByCodigoinsumo().getUnidadmedida().getNombre();
				obj.getProductoByCodigoinsumo().getUnidadmedida().getFamilia().getNombrefamilia();
				obj.getProductoByCodigoinsumo().getTipoproducto().getNombre();
				obj.getProductoByCodigoinsumo().getStock().getProducto();
				obj.getProductoByCodigoinsumo().getStock().getStockdisponible();
				obj.getProductoByCodigoinsumo().getStock().getStockcomprometido();
				obj.getProductoByCodigoinsumo().getStock().getUnidadmedida().getNombre();
				obj.getProductoByCodigoinsumo().getStock().getUnidadmedida().getFamilia().getNombrefamilia();
				for(Ubicacion ubicacion : obj.getProductoByCodigoinsumo().getUbicacions()) {
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
		return listIngrediente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ingrediente> getAllNotEqBy(Ingrediente ingrediente) throws DAOException {
		LOG.debug("IngredienteDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ingrediente> listIngrediente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ingrediente where 1 = 1 ");
			query.append(ingrediente.getUnidadmedida() != null && ingrediente.getUnidadmedida().getCodigo() instanceof String && !ingrediente.getUnidadmedida().getCodigo().isEmpty() ? "and CODIGO = '"  + ingrediente.getUnidadmedida().getCodigo() + "' " : "");
			query.append(ingrediente.getCarga() != 0  ? "and NOMBRE = '" + ingrediente.getCarga() + "' " : "");
			
			listIngrediente = (List<Ingrediente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listIngrediente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ingrediente> getAllBeginWithBy(Ingrediente ingrediente) throws DAOException {
		LOG.debug("IngredienteDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ingrediente> listIngrediente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ingrediente  where 1 = 1 ");
			query.append(ingrediente.getUnidadmedida() != null && ingrediente.getUnidadmedida().getCodigo() instanceof String && !ingrediente.getUnidadmedida().getCodigo().isEmpty() ? "and CODIGO = '"  + ingrediente.getUnidadmedida().getCodigo() + "' " : "");
			query.append(ingrediente.getCarga() != 0  ? "and NOMBRE = '" + ingrediente.getCarga() + "' " : "");
			
			listIngrediente = (List<Ingrediente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listIngrediente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ingrediente> getAllNotBeginWithBy(Ingrediente ingrediente) throws DAOException {
		LOG.debug("IngredienteDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ingrediente> listIngrediente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ingrediente  where 1 = 1 ");
			query.append(ingrediente.getUnidadmedida() != null && ingrediente.getUnidadmedida().getCodigo() instanceof String && !ingrediente.getUnidadmedida().getCodigo().isEmpty() ? "and CODIGO = '"  + ingrediente.getUnidadmedida().getCodigo() + "' " : "");
			query.append(ingrediente.getCarga() != 0  ? "and NOMBRE = '" + ingrediente.getCarga() + "' " : "");
			
			listIngrediente = (List<Ingrediente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listIngrediente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ingrediente> getAllEndWithBy(Ingrediente ingrediente) throws DAOException {
		LOG.debug("IngredienteDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ingrediente> listIngrediente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ingrediente  where 1 = 1 ");
			query.append(ingrediente.getUnidadmedida() != null && ingrediente.getUnidadmedida().getCodigo() instanceof String && !ingrediente.getUnidadmedida().getCodigo().isEmpty() ? "and CODIGO = '"  + ingrediente.getUnidadmedida().getCodigo() + "' " : "");
			query.append(ingrediente.getCarga() != 0  ? "and NOMBRE = '" + ingrediente.getCarga() + "' " : "");
			
			listIngrediente = (List<Ingrediente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listIngrediente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ingrediente> getAllNotEndWithBy(Ingrediente ingrediente) throws DAOException {
		LOG.debug("IngredienteDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ingrediente> listIngrediente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ingrediente  where 1 = 1 ");
			query.append(ingrediente.getUnidadmedida() != null && ingrediente.getUnidadmedida().getCodigo() instanceof String && !ingrediente.getUnidadmedida().getCodigo().isEmpty() ? "and CODIGO = '"  + ingrediente.getUnidadmedida().getCodigo() + "' " : "");
			query.append(ingrediente.getCarga() != 0  ? "and NOMBRE = '" + ingrediente.getCarga() + "' " : "");
			
			listIngrediente = (List<Ingrediente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listIngrediente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ingrediente> getAllContainBy(Ingrediente ingrediente) throws DAOException {
		LOG.debug("IngredienteDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ingrediente> listIngrediente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ingrediente  where 1 = 1 ");
			query.append(ingrediente.getUnidadmedida() != null && ingrediente.getUnidadmedida().getCodigo() instanceof String && !ingrediente.getUnidadmedida().getCodigo().isEmpty() ? "and CODIGO = '"  + ingrediente.getUnidadmedida().getCodigo() + "' " : "");
			query.append(ingrediente.getCarga() != 0  ? "and NOMBRE = '" + ingrediente.getCarga() + "' " : "");
			
			listIngrediente = (List<Ingrediente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listIngrediente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ingrediente> getAllNotContainBy(Ingrediente ingrediente) throws DAOException {
		LOG.debug("IngredienteDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ingrediente> listIngrediente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ingrediente  where 1 = 1 ");
			query.append(ingrediente.getUnidadmedida() != null && ingrediente.getUnidadmedida().getCodigo() instanceof String && !ingrediente.getUnidadmedida().getCodigo().isEmpty() ? "and CODIGO = '"  + ingrediente.getUnidadmedida().getCodigo() + "' " : "");
			query.append(ingrediente.getCarga() != 0  ? "and NOMBRE = '" + ingrediente.getCarga() + "' " : "");
			
			listIngrediente = (List<Ingrediente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listIngrediente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ingrediente> getAllIsNullBy(Ingrediente ingrediente) throws DAOException {
		LOG.debug("IngredienteDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ingrediente> listIngrediente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ingrediente  where 1 = 1 ");
			query.append(ingrediente.getUnidadmedida() != null && ingrediente.getUnidadmedida().getCodigo() instanceof String && !ingrediente.getUnidadmedida().getCodigo().isEmpty() ? "and CODIGO = '"  + ingrediente.getUnidadmedida().getCodigo() + "' " : "");
			query.append(ingrediente.getCarga() != 0  ? "and NOMBRE = '" + ingrediente.getCarga() + "' " : "");
			
			listIngrediente = (List<Ingrediente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listIngrediente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ingrediente> getAllNotIsNullBy(Ingrediente ingrediente) throws DAOException {
		LOG.debug("IngredienteDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Ingrediente> listIngrediente = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Ingrediente  where 1 = 1 ");
			query.append(ingrediente.getUnidadmedida() != null && ingrediente.getUnidadmedida().getCodigo() instanceof String && !ingrediente.getUnidadmedida().getCodigo().isEmpty() ? "and CODIGO = '"  + ingrediente.getUnidadmedida().getCodigo() + "' " : "");
			query.append(ingrediente.getCarga() != 0  ? "and NOMBRE = '" + ingrediente.getCarga() + "' " : "");
			
			listIngrediente = (List<Ingrediente>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listIngrediente;
	}
	
	public boolean save(Ingrediente obj) throws DAOException {
		LOG.debug("IngredienteDao save");
		
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
	
	public boolean update(Ingrediente obj) throws DAOException {
		LOG.debug("IngredienteDao update");
		
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
		LOG.debug("IngredienteDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Ingrediente ingrediente = (Ingrediente) session.get(Ingrediente.class, id);
			session.delete(ingrediente);
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