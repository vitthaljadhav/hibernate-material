package com.info.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.info.domain.Empolyee;
import com.info.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		Empolyee empolyee1 = null;
		try {
		Session session = HibernateUtil.getSessionFactroy().openSession();
			/*
			 * Empolyee empolyee = new Empolyee(); 
			 * empolyee.setEmp_name("Mahi");
			 * empolyee.setEmp_salary(135000d); 
			 * empolyee.setDate_of_join(new Date());
			 */
			Transaction tx = session.getTransaction();
			tx.begin();
			empolyee1 = session.get(Empolyee.class, 1);
			System.out.println(empolyee1);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		empolyee1.setEmp_name("sachin Tendulkar");
		try {
			Session session = HibernateUtil.getSessionFactroy().openSession();
			Transaction tx = session.getTransaction();
			tx.begin();
			Empolyee empolyee2 = session.get(Empolyee.class, 1);
		//	session.update(empolyee1);//RE    ->org.hibernate.NonUniqueObjectException: A different object with the same identifier value was already associated with the session : [com.info.domain.Empolyee#1]
			session.merge(empolyee1);// solve the Above Problem
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
