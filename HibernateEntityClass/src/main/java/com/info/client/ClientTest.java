package com.info.client;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.info.domain.Empolyee;
import com.info.util.HibernateUtil;

public class ClientTest {
	public static void main(String[] args) {
		try {

			Session session = HibernateUtil.getSessionFactroy().openSession();

			Empolyee empolyee = new Empolyee();
			empolyee.setEmp_name("Banti");
			empolyee.setEmp_salary(135000d);
			empolyee.setDate_of_join(new Date());
			Transaction tx = session.getTransaction();
			tx.begin();
			Serializable save = session.save(empolyee);
			tx.commit();
			System.out.println("Successfully create Data");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
