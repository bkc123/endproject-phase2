package com.hcl.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.hcl.model.User;

//import javax.security.auth.login.Configuration;

public class HibernateUtil {

	public static void main(String[] args) {
		Transaction t= null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t= session.beginTransaction(); // begin the session
			User u = new User("Binod","Chhantyal","bkc@hcl.com", "bkc", "123", "male", "listening music", "USA");
			session.save(u);// save the session
			t.commit();// commit the session
			/*User u1 = session.find(User.class);
			//System.out.println("here is the details of u:" + u1);
			List<User> listOfUser = session.createQuery("from User").getResultList();
			for (User a: listOfUser) {
				System.out.println("++++++++++++++++++++++");
				System.out.println("hee is is the list of all users");
				System.out.println(a);
			}*/
			session.close();
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	
	}
	
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(com.hcl.model.User.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().
				applySettings(configuration.getProperties());
		SessionFactory factory= configuration.buildSessionFactory(builder.build());
		//Session session = factory.openSession();
        return factory;
        
    }

}
