package cl.obam.pasteleria.lapalmera.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.User;
import cl.obam.pasteleria.lapalmera.util.HibernateUtil;

@Repository
public class UserDao {

	public User getUser(String username) throws DAOException {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		User user = null;
		try {
			tx = session.beginTransaction();		
			user = (User) session.createQuery("from User where username=?").setString(0, username).uniqueResult();		
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return user;
	}
	
	public void grabar(User obj) throws Exception {
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
