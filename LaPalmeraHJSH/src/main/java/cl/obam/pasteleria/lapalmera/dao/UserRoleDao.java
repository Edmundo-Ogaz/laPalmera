package cl.obam.pasteleria.lapalmera.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.model.Userrole;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class UserRoleDao {

	public void grabar(Userrole obj) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		    session.save(obj);
		    tx.commit();
		}catch (Exception e) {
			System.out.println("Fatal " + e.getMessage());
			if (tx != null && tx.isActive()){
				try {
					tx.rollback();
				} catch (HibernateException e1) {
					System.out.println("Fatal al tratar de hacer rollback " + e.getMessage());
					throw new Exception("Error al grabar Campo y en rollback",e);
				}
			}
			throw new Exception("Error al Nivel persistencia",e);
		} finally {
			session.close();
		}
	}
}
