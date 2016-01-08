package cl.obam.pasteleria.lapalmera.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Stock;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class StockDao {
	
	private static final Logger LOG = Logger.getLogger(StockDao.class);

	public Stock get(String codigoProducto) throws DAOException {
		LOG.debug("StockDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Stock stock = null;
		try {
			tx = session.beginTransaction();		
			stock = (Stock) session.createQuery("from Stock where codigoproducto = ?").setString(0, codigoProducto).uniqueResult();
			if(stock instanceof Stock) {
				stock.getUnidadmedida().getNombre();
				stock.getUnidadmedida().getFamilia().getNombrefamilia();
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return stock;
	}
	
	@SuppressWarnings("unchecked")
	public List<Stock> getAll() throws DAOException {
		LOG.debug("StockDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Stock> listStock = null;
		try {
			tx = session.beginTransaction();		
			listStock = (List<Stock>) session.createQuery("from Stock ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listStock;
	}
	
	@SuppressWarnings("unchecked")
	public List<Stock> getAllEqBy(Stock stock) throws DAOException {
		LOG.debug("StockDao getAllEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Stock> listStock = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Stock where 1 = 1 ");
			query.append(stock.getCodigoproducto() instanceof String && !stock.getCodigoproducto().isEmpty() ? "and codigoproducto = '"  + stock.getCodigoproducto() + "' " : "");
			query.append(stock.getUnidadmedida() != null && stock.getUnidadmedida().getCodigo() instanceof String && !stock.getUnidadmedida().getCodigo().isEmpty() ? "and unidadmedida.codigo = '" + stock.getUnidadmedida().getCodigo() + "' " : "");
			
			listStock = (List<Stock>) session.createQuery(query.toString()).list();
			for(Stock obj : listStock) {
				obj.getUnidadmedida().getNombre();
				obj.getUnidadmedida().getFamilia().getNombrefamilia();
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listStock;
	}
	
	@SuppressWarnings("unchecked")
	public List<Stock> getAllNotEqBy(Stock stock) throws DAOException {
		LOG.debug("StockDao getAllNotEqBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Stock> listStock = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Stock where 1 = 1 ");
			query.append(stock.getCodigoproducto() instanceof String && !stock.getCodigoproducto().isEmpty() ? "and CODIGO = '"  + stock.getCodigoproducto() + "' " : "");
			query.append(stock.getUnidadmedida() != null && stock.getUnidadmedida().getCodigo() instanceof String && !stock.getUnidadmedida().getCodigo().isEmpty() ? "and NOMBRE = '" + stock.getUnidadmedida().getCodigo() + "' " : "");
			
			listStock = (List<Stock>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listStock;
	}
	
	@SuppressWarnings("unchecked")
	public List<Stock> getAllBeginWithBy(Stock stock) throws DAOException {
		LOG.debug("StockDao getAllBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Stock> listStock = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Stock  where 1 = 1 ");
			query.append(stock.getCodigoproducto() instanceof String && !stock.getCodigoproducto().isEmpty() ? "and CODIGO = '"  + stock.getCodigoproducto() + "' " : "");
			query.append(stock.getUnidadmedida() != null && stock.getUnidadmedida().getCodigo() instanceof String && !stock.getUnidadmedida().getCodigo().isEmpty() ? "and NOMBRE = '" + stock.getUnidadmedida().getCodigo() + "' " : "");
			
			listStock = (List<Stock>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listStock;
	}
	
	@SuppressWarnings("unchecked")
	public List<Stock> getAllNotBeginWithBy(Stock stock) throws DAOException {
		LOG.debug("StockDao getAllNotBeginWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Stock> listStock = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Stock  where 1 = 1 ");
			query.append(stock.getCodigoproducto() instanceof String && !stock.getCodigoproducto().isEmpty() ? "and CODIGO = '"  + stock.getCodigoproducto() + "' " : "");
			query.append(stock.getUnidadmedida() != null && stock.getUnidadmedida().getCodigo() instanceof String && !stock.getUnidadmedida().getCodigo().isEmpty() ? "and NOMBRE = '" + stock.getUnidadmedida().getCodigo() + "' " : "");
			
			listStock = (List<Stock>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listStock;
	}
	
	@SuppressWarnings("unchecked")
	public List<Stock> getAllEndWithBy(Stock stock) throws DAOException {
		LOG.debug("StockDao getAllEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Stock> listStock = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Stock  where 1 = 1 ");
			query.append(stock.getCodigoproducto() instanceof String && !stock.getCodigoproducto().isEmpty() ? "and CODIGO = '"  + stock.getCodigoproducto() + "' " : "");
			query.append(stock.getUnidadmedida() != null && stock.getUnidadmedida().getCodigo() instanceof String && !stock.getUnidadmedida().getCodigo().isEmpty() ? "and NOMBRE = '" + stock.getUnidadmedida().getCodigo() + "' " : "");
			
			listStock = (List<Stock>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listStock;
	}
	
	@SuppressWarnings("unchecked")
	public List<Stock> getAllNotEndWithBy(Stock stock) throws DAOException {
		LOG.debug("StockDao getAllNotEndWithBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Stock> listStock = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Stock  where 1 = 1 ");
			query.append(stock.getCodigoproducto() instanceof String && !stock.getCodigoproducto().isEmpty() ? "and CODIGO = '"  + stock.getCodigoproducto() + "' " : "");
			query.append(stock.getUnidadmedida() != null && stock.getUnidadmedida().getCodigo() instanceof String && !stock.getUnidadmedida().getCodigo().isEmpty() ? "and NOMBRE = '" + stock.getUnidadmedida().getCodigo() + "' " : "");
			
			listStock = (List<Stock>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listStock;
	}
	
	@SuppressWarnings("unchecked")
	public List<Stock> getAllContainBy(Stock stock) throws DAOException {
		LOG.debug("StockDao getAllContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Stock> listStock = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Stock  where 1 = 1 ");
			query.append(stock.getCodigoproducto() instanceof String && !stock.getCodigoproducto().isEmpty() ? "and CODIGO = '"  + stock.getCodigoproducto() + "' " : "");
			query.append(stock.getUnidadmedida() != null && stock.getUnidadmedida().getCodigo() instanceof String && !stock.getUnidadmedida().getCodigo().isEmpty() ? "and NOMBRE = '" + stock.getUnidadmedida().getCodigo() + "' " : "");
			
			listStock = (List<Stock>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listStock;
	}
	
	@SuppressWarnings("unchecked")
	public List<Stock> getAllNotContainBy(Stock stock) throws DAOException {
		LOG.debug("StockDao getAllNotContainBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Stock> listStock = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Stock  where 1 = 1 ");
			query.append(stock.getCodigoproducto() instanceof String && !stock.getCodigoproducto().isEmpty() ? "and CODIGO = '"  + stock.getCodigoproducto() + "' " : "");
			query.append(stock.getUnidadmedida() != null && stock.getUnidadmedida().getCodigo() instanceof String && !stock.getUnidadmedida().getCodigo().isEmpty() ? "and NOMBRE = '" + stock.getUnidadmedida().getCodigo() + "' " : "");
			
			listStock = (List<Stock>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listStock;
	}
	
	@SuppressWarnings("unchecked")
	public List<Stock> getAllIsNullBy(Stock stock) throws DAOException {
		LOG.debug("StockDao getAllIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Stock> listStock = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Stock  where 1 = 1 ");
			query.append(stock.getCodigoproducto() instanceof String && !stock.getCodigoproducto().isEmpty() ? "and CODIGO = '"  + stock.getCodigoproducto() + "' " : "");
			query.append(stock.getUnidadmedida() != null && stock.getUnidadmedida().getCodigo() instanceof String && !stock.getUnidadmedida().getCodigo().isEmpty() ? "and NOMBRE = '" + stock.getUnidadmedida().getCodigo() + "' " : "");
			
			listStock = (List<Stock>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listStock;
	}
	
	@SuppressWarnings("unchecked")
	public List<Stock> getAllNotIsNullBy(Stock stock) throws DAOException {
		LOG.debug("StockDao getAllNotIsNullBy");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Stock> listStock = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("from Stock  where 1 = 1 ");
			query.append(stock.getCodigoproducto() instanceof String && !stock.getCodigoproducto().isEmpty() ? "and CODIGO = '"  + stock.getCodigoproducto() + "' " : "");
			query.append(stock.getUnidadmedida() != null && stock.getUnidadmedida().getCodigo() instanceof String && !stock.getUnidadmedida().getCodigo().isEmpty() ? "and NOMBRE = '" + stock.getUnidadmedida().getCodigo() + "' " : "");
			
			listStock = (List<Stock>) session.createQuery(query.toString()).list();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listStock;
	}
	
	public boolean save(Stock obj) throws DAOException {
		LOG.debug("StockDao save");
		
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
	
	public boolean update(Stock obj) throws DAOException {
		LOG.debug("StockDao update");
		
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
		LOG.debug("StockDao delete");
		
		boolean resp = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Stock stock = (Stock) session.get(Stock.class, codigo);
			session.delete(stock);
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