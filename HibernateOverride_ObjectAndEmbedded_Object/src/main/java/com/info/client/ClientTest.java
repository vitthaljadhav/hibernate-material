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
			Address homeaddress = new Address();

			homeaddress.setCity_name("Karve-Nagar");
			homeaddress.setPin_code("413578");
			homeaddress.setState_name("MH");
			
			Address officeaddress = new Address();

			officeaddress.setCity_name("Nagar");
			officeaddress.setPin_code("400012");
			officeaddress.setState_name("WA");
			
			
			Empolyee empolyee = new Empolyee();
			empolyee.setEmp_name("Banti");
			empolyee.setEmp_salary(135000d);
			empolyee.setDate_of_join(new Date());
			empolyee.setHomeAddress(homeaddress);
			empolyee.setOfficeAddress(officeaddress);
			
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
