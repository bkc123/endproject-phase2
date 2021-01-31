
package com.hcl.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hcl.model.User;
import com.hcl.util.HibernateUtil;

public class UserDao {
	
	//methods to saveUser from the from
	public void saveUser(User user) {
		Transaction t= null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			t = session.beginTransaction();
			session.save(user); // save transaction
			t.commit();	// commit transaction
		}catch(Exception e) {
			if (t !=null) {
				t.rollback();
			}
			e.printStackTrace();
		}
	}
	
	// methods to validate username and password
	public boolean validate(String userName, String password) {

        Transaction t = null;//start Transaction
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            t= session.beginTransaction();// begin Transaction
            // get an user object
            user = (User) session.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName", userName)
                .uniqueResult();

            if (user != null && user.getPassword().equals(password)) {
                return true;
            }
            // commit transaction
            t.commit();
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
}
