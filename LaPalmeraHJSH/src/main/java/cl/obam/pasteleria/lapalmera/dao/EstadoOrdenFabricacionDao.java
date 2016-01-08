package cl.obam.pasteleria.lapalmera.dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Estadoordenfabricacion;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.EstadoOrdenFabricacionVO;

@Repository
public class EstadoOrdenFabricacionDao {
	
	private static final Logger LOG = Logger.getLogger(EstadoOrdenFabricacionDao.class);
	
	@SuppressWarnings("unchecked")
	public List<EstadoOrdenFabricacionVO> getAll() throws DAOException {
		LOG.debug("EstadoOrdenFabricacionDao getAll");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<EstadoOrdenFabricacionVO> list = null;
		try {
			tx = session.beginTransaction();		
			List<Estadoordenfabricacion> listEstadoOrdenFabricacion = (List<Estadoordenfabricacion>) session.createQuery("from Estadoordenfabricacion ").list();
			
			list = new LinkedList<EstadoOrdenFabricacionVO>();
			EstadoOrdenFabricacionVO obj = null;
			for(Estadoordenfabricacion  estadoOrdenFabricacion : listEstadoOrdenFabricacion) {
				obj = Mapper.from(estadoOrdenFabricacion);
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
}