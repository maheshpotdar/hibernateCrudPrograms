package com.mahesh.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mahesh.model.Employee;

public class Test_Insert {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// samaja adhi 500 records ahet table madhe ani ata mi 4 object insert karnar
		// ahe.tar to old table purn pane drop kar.navin table tayar kar ani
		// atache he 4 object insert kar. every run la hey honar.

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		/////////////////// transient state object////////////////////////
		// object tayar kela manaje transient state.
		Employee employee = new Employee();
		employee.setEmpName("Mahesh");
		employee.setEmpAddress("jalgav");

		Employee employee2 = new Employee();
		employee2.setEmpName("Ram");
		employee2.setEmpAddress("Patel");

		Employee employee3 = new Employee();
		employee3.setEmpName("Ganesh");
		employee3.setEmpAddress("patil");

		Employee employee4 = new Employee();
		employee4.setEmpName("Jignesh");
		employee4.setEmpAddress("khot");

		///////////////////////////////////////////////////////////////////

		///////////////////// persistant state//////////////////////////////

		// hibernate madhe object dilyawar persistant state.
		// only query lihila .

		/////////////////// SAVE/////////////////////////////////////////////
		int pk = (Integer) session.save(employee);
		System.out.println("First pk: " + pk);

		int pk2 = (Integer) session.save(employee2);
		System.out.println("Second pk: " + pk2);
		// save method la return type manun to insert kelelya object cha primary key
		// fetch karato.

		////////////////// PERSIST////////////////////////////////////////////

		// persist method kahicha return karat nahi void return type.

		session.persist(employee3);

		/////////////////////////////////////////////////////////////////////

		//////////////////////////////// SAVE_OR_UPDATE/////////////////////////////////////
		// save or update return type void.

		session.saveOrUpdate(employee4);

		// commit manaje execute() or executeUpdate().
		session.getTransaction().commit();
		System.out.println("inserted successfully.");
	}

}
