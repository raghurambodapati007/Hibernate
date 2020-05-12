package com.infosys.infybank.customerdemo02hql;

  import org.hibernate.Query;
  import org.hibernate.Session;
  import org.hibernate.SessionFactory;
  import org.hibernate.cfg.Configuration;
  import org.hibernate.service.ServiceRegistry;
  import org.hibernate.service.ServiceRegistryBuilder;
  public class DeleteDemo {
    
    public static void main(String[] args) {
	    SessionFactory sessionFactory;
	    ServiceRegistry serviceRegistry;
	    Configuration cfg = new Configuration().configure("/com/infosys/infybank/customerdemo02hql/hibernate.cfg.xml");                    
        cfg.addAnnotatedClass(Customer.class);
        serviceRegistry = new ServiceRegistryBuilder().applySettings(      
                          cfg.getProperties()).buildServiceRegistry();
        sessionFactory = cfg.buildSessionFactory(serviceRegistry);
   
        Session session = sessionFactory.openSession();
        session.beginTransaction();
    try{
      
          
      //Delete Operation
      Query query = session.createQuery("delete Customer cust where cust.customerId=1002");
      int update = query.executeUpdate();
      if(update == 0 || update == 1){
         System.out.println(update + " row affected");
      }
      else{
         System.out.println(update + " rows affected");  
      }
      session.getTransaction().commit();
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    finally {
      session.close();
    }
  }
}