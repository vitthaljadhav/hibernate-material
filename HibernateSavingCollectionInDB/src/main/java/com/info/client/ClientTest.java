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
			Address address1 = new Address();
			address1.setCity_name("Karve-Nagar");
			address1.setPin_code("413578");
			address1.setState_name("MH");
			
			Address address2 = new Address();
			address2.setCity_name("Nagar");
			address2.setPin_code("425000");
			address2.setState_name("MH");
			
			Empolyee empolyee = new Empolyee();
			empolyee.setEmp_name("Banti");
			empolyee.setEmp_salary(135000d);
			empolyee.setDate_of_join(new Date());
			empolyee.getAddressList().add(address1);
			empolyee.getAddressList().add(address2);
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
