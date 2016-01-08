package cl.obam.pasteleria.lapalmera.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Bodega;
import cl.obam.pasteleria.lapalmera.model.Estadopedido;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class EstadoPedidoDao {
	
	private static final Logger LOG = Logger.getLogger(EstadoPedidoDao.class);
	
	@SuppressWarnings("unchecked")
	public List<Estadopedido> getAll() throws DAOException {
		LOG.debug("EstadoPedidoDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Estadopedido> listEstadoPedido = null;
		try {
			tx = session.beginTransaction();		
			listEstadoPedido = (List<Estadopedido>) session.createQuery("from Estadopedido ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEstadoPedido;
	}
}