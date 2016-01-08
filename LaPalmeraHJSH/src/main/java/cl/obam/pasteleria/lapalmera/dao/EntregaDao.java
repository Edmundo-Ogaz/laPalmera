package cl.obam.pasteleria.lapalmera.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Comuna;
import cl.obam.pasteleria.lapalmera.model.Entrega;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class EntregaDao {
	
	private static final Logger LOG = Logger.getLogger(EntregaDao.class);

	public Entrega get(String codigo) throws DAOException {
		LOG.debug("EntregaDao get");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Entrega entrega = null;
		try {
			tx = session.beginTransaction();		
			entrega = (Entrega) session.createQuery("from Entrega where codigo = ?").setString(0, codigo).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return entrega;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entrega> getAll() throws DAOException {
		LOG.debug("EntregaDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Entrega> listEntrega = null;
		try {
			tx = session.beginTransaction();		
			listEntrega = (List<Entrega>) session.createQuery("from Entrega ").list();
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listEntrega;
	}
}