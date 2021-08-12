package com.polymath;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
	public static void main(String[] args) {
		
		Employees emp = new Employees();
		emp.setEid(10);
		emp.setEname("ABC");
		
		emp.setEid(30);
		emp.setEname("WEE");
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Employees.class);
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session =  sf.openSession();
		
		Transaction tx =  session.beginTransaction();
		
		session.save(emp);
		
		tx.commit();
	}

}
