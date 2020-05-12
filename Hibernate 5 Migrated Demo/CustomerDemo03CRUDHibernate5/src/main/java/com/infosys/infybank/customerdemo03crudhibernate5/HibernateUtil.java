package com.infosys.infybank.customerdemo03crudhibernate5;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtil {
private static final SessionFactory sessionFactory;
private static StandardServiceRegistry standardServiceRegistry;
private HibernateUtil( ) {}
static {
  try {
	  standardServiceRegistry = new StandardServiceRegistryBuilder()	.configure("/com/infosys/infybank/customerdemo03crudhibernate5/Hibernate.cfg.xml").build();
		
		Metadata metaData = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		
		sessionFactory = metaData.getSessionFactoryBuilder().build();
  } catch (Exception ex) {
   System.err.println("Initial SessionFactory creation failed. " + ex);
   throw new ExceptionInInitializerError(ex);
  }
}
 public static SessionFactory getSessionFactory() {
  return sessionFactory;
  }
}
