package com.infosys.infybank.customerdemo03crudhibernate5;

public interface ICustomer {
        public void addCustomer(Customer custObj);
        public void readCustomer(int customerId);
        public void updateCustomer(Integer customerId, String customerName);
        public void deleteCustomer(Integer customerId);
}
