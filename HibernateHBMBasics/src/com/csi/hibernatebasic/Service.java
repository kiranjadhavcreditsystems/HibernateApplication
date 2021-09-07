package com.csi.hibernatebasic;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Service {

	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Employee e1 = new Employee();

		e1.setEmpName("MAHESH");
		e1.setEmpSalary(6565766.89);
		
		e1.setEmpEmailId("MAHESH.AHIRE@CSI.COM");

		session.save(e1);
		transaction.commit();
		
		getAllData();
		

	}
	
	static void getAllData()
	{
		Session session = factory.openSession();
		
		List<Employee> empList = session.createQuery("from Employee").list();
		
		empList.forEach(System.out::println);
	}
}
