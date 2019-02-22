package com.info.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.info.domain.Address;
import com.info.domain.Empolyee;
import com.info.util.HibernateUtil;

public class ClientTest {
	public static void main(String[] args) {
		try {

			Session session = HibernateUtil.getSessionFactroy().openSession();
			Address address = new Address();

			address.setCity_name("Karve-Nagar");
			address.setPin_code("413578");
			address.setState_name("MH");
			
			
			Empolyee empolyee = new Empolyee();
			empolyee.setEmp_name("Banti");
			empolyee.setEmp_salary(135000d);
			empolyee.setDate_of_join(new Date());
			empolyee.setAddress(address);
			address.setEmployee(empolyee);
			
			
			
			Transaction tx = session.getTransaction();
			tx.begin();
			session.save(empolyee);
			//session.save(address);
		
			System.out.println("-----------------------access from parent side-------------------");
			Empolyee empolyee2 = session.get(Empolyee.class, 1);
			System.out.println(empolyee2);
			Address address3 = empolyee2.getAddress();
			System.out.println(address3);
			
			System.out.println("----------------------access from Child side----------------");
			Address address2 = session.get(Address.class, 1);
			System.out.println(address2);
			Empolyee employee3 = address2.getEmployee();
			System.out.println(employee3);
			
			tx.commit();
			System.out.println("Successfully create Data");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
