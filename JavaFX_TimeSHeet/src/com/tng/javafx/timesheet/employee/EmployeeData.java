package com.tng.javafx.timesheet.employee;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeData {
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("test");
	private static String QUERY_ALL = "select e from Employee e where e.id is not null";
	private static String QUERY_NAME = "select e from Employee e where e.firstName = :firstName";
	private static String QUERY_LOGIN = "select e from Employee e where e.employeeID = :userName and e.password = :password";

	public Employee getEmployee(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		// EntityTransaction tx = em.getTransaction();

		Employee employee = em.find(Employee.class, id);

		em.close();
		return employee;
	}

	public Employee login(String userName, String password) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		Employee employee;

		try {
			employee = em.createQuery(QUERY_LOGIN, Employee.class).setParameter("userName", userName)
					.setParameter("password", password).getSingleResult();
			return employee;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<Employee> getEmployees() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		List<Employee> ff = em.createQuery(QUERY_ALL, Employee.class).getResultList();
		em.close();

		return ff;
	}

	public ObservableList<Employee> getEmployeesObservableList() {
		ObservableList<Employee> employee = FXCollections.observableArrayList();
		List<Employee> lp = getEmployees();

		lp.stream().forEach(p -> employee.add(p));

		return employee;
	}

	public Employee getEmployees(String firstName) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		Employee employee = em.createQuery(QUERY_NAME, Employee.class).setParameter("firstName", firstName)
				.getSingleResult();
		return employee;
	}

//	public ObservableList<Employee> getEmployeesObservableList(String firatName) {
//		ObservableList<Employee> employee = FXCollections.observableArrayList();
//		List<Employee> lp = getEmployees(firatName);
//
//		lp.stream().forEach(p -> employee.add(p));
//
//		return employee;
//	}

	public boolean setEmployee(Employee employee) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		if (em.find(Employee.class, employee.getId()) == null) {

			if (employee.getCreatedDate() == null) {
				employee.setCreatedDate(LocalDate.now());
			}

			tx.begin();
			em.persist(employee);
			tx.commit();
		}
		em.close();

		return true;

	}
}
