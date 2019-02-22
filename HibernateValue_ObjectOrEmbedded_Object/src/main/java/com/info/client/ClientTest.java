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
			
			Transaction tx = session.getTransaction();
			tx.begin();
			Integer save = (Integer)session.save(empolyee);
			System.out.println(save);
			tx.commit();
			System.out.println("Successfully create Data");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
