package com.tng.javafx.timesheet.employee;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeLeaveData {
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("test");
	private static String QUERY_ALL = "select e from EmployeeLeave e where e.id is not null";

	public EmployeeLeave getEmployeeLeave(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		// EntityTransaction tx = em.getTransaction();

		EmployeeLeave employeeLeave = em.find(EmployeeLeave.class, id);

		em.close();
		return employeeLeave;
	}

	public List<EmployeeLeave> getEmployeeLeaves() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		List<EmployeeLeave> ff = em.createQuery(QUERY_ALL, EmployeeLeave.class).getResultList();
		em.close();

		return ff;
	}

	public ObservableList<EmployeeLeave> getEmployeeLeavesObservableList() {
		ObservableList<EmployeeLeave> employeeLeave = FXCollections.observableArrayList();
		List<EmployeeLeave> lp = getEmployeeLeaves();

		lp.stream().forEach(p -> employeeLeave.add(p));

		return employeeLeave;
	}

	public boolean setEmployeeLeave(EmployeeLeave employeeLeave) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		if (em.find(EmployeeLeave.class, employeeLeave.getId()) == null) {

			if (employeeLeave.getCreatedDate() == null) {
				employeeLeave.setCreatedDate(LocalDate.now());
			}

			tx.begin();
			em.persist(employeeLeave);
			tx.commit();
		}
		em.close();

		return true;

	}
}
