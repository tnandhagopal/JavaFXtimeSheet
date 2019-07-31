package com.tng.javafx.timesheet.project;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.derby.tools.sysinfo;

import com.tng.javafx.timesheet.employee.Employee;
import com.tng.javafx.timesheet.employee.EmployeeProject;
import com.tng.javafx.timesheet.employee.EmployeeTimeSheet;
import com.tng.javafx.timesheet.weekview.Test;

public class TestData {

	public TestData() {
		testDB();
	}

	private void testDB() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

//		Test test = em.find(Test.class, 1);
//
//		if (test == null) {
//			System.out.format("new record");
//			test = new Test();
//			test.id = 1;	
//			test.data = "a";
//
//			tx.begin();
//			em.persist(test);
//			tx.commit();
//		}
//
//		System.out.format("Test{id=%s, data=%s}\n", test.id, test.data);

		for (int i = 1; i <= 10; i++) {
			Project project = em.find(Project.class, i);
			if (project == null) {
				System.out.format("new project record");
				project = new Project();
				project.setId(i);
				project.setCode("W00" + i);
				project.setName("Avalog-Testing-" + i);

				tx.begin();
				em.persist(project);
				tx.commit();

			}
			System.out.format("Project{Id=%s, Code=%s, Name=%s}\n", project.getId(), project.getCode(),
					project.getName());
		}

		Employee emp = new Employee();
		emp.setEmployeeID("51314542");
		emp.setPassword("create@123");
		emp.setFirstName("Nandhagopal");
		emp.setSecondName("Thangavelu");
		emp.setContactNo("93374742");
		emp.setMaikId("tnandhagopal@gmail.com");
		tx.begin();
		em.persist(emp);
		tx.commit();

		Employee emp2 = new Employee();
		emp2.setEmployeeID("51314543");
		emp2.setPassword("create@143");
		emp2.setFirstName("Adhavan");
		emp2.setSecondName("Nandhagopal");
		emp2.setContactNo("93374742");
		emp2.setMaikId("nadhavan@gmail.com");
		tx.begin();
		em.persist(emp2);
		tx.commit();

		EmployeeProject ep = new EmployeeProject();
		ep.setEmployee(emp);
		ep.setProject(em.find(Project.class, 1));
		tx.begin();
		em.persist(ep);
		tx.commit();

		EmployeeProject ep2 = new EmployeeProject();
		ep2.setEmployee(emp);
		ep2.setProject(em.find(Project.class, 2));
		tx.begin();
		em.persist(ep2);
		tx.commit();

		EmployeeProject ep3 = new EmployeeProject();
		ep3.setEmployee(emp2);
		ep3.setProject(em.find(Project.class, 3));
		tx.begin();
		em.persist(ep3);
		tx.commit();

		EmployeeProject ep4 = new EmployeeProject();
		ep4.setEmployee(emp2);
		ep4.setProject(em.find(Project.class, 4));
		tx.begin();
		em.persist(ep4);
		tx.commit();

		LocalDate firstOfCurrentMonth = LocalDate.now().with(ChronoField.DAY_OF_MONTH, 1);
		for (LocalDate ld = firstOfCurrentMonth; ld
				.isBefore(firstOfCurrentMonth.plusMonths(1)); ld = ld.plusDays(1)) {
			EmployeeTimeSheet et = new EmployeeTimeSheet();
			et.setEmployee(emp);
			et.setEmployeeProject(ep);
			et.setDay(ld);
			et.setTime(8);
			et.setCreatedBy("Admin");
			et.setCreatedDate(LocalDate.now());

			tx.begin();
			em.persist(et);
			tx.commit();
			
			System.out.println("injected");
		}
		em.close();
		emf.close();
	}

}
