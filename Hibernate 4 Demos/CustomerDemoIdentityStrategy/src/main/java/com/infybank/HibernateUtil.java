package com.infybank;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private HibernateUtil()
	{
		
	}
	static {
	  try {
	   Configuration cfg = new Configuration().configure("/com/infybank/Hibernate.cfg.xml");
	   ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties())
	     .buildServiceRegistry();
	   sessionFactory = cfg.buildSessionFactory(serviceRegistry);
	  } catch (Exception ex) {
	   System.err.println("Initial SessionFactory creation failed. " + ex);
	   throw new ExceptionInInitializerError(ex);
	  }
	}
	 public static SessionFactory getSessionFactory() {
	  return sessionFactory;
	  }

}
