package com.tng.javafx.timesheet.employee;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeTimeSheetData {
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("test");
	private static String QUERY_ALL = "select e from EmployeeTimeSheet e where e.id is not null";
	private static String QUERY_EMP = "select e from EmployeeTimeSheet e where e.employeeProject.id = :epID and e.day BETWEEN :startDate AND :endDate ";
	private static String QUERY_EMP_1 = "select e from EmployeeTimeSheet e where e.employeeProject.id = :epID";

	public EmployeeTimeSheet getEmployeeTimeSheet(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		// EntityTransaction tx = em.getTransaction();

		EmployeeTimeSheet employeeTimeSheet = em.find(EmployeeTimeSheet.class, id);

		em.close();
		return employeeTimeSheet;
	}

	public List<EmployeeTimeSheet> getEmployeeTimeSheets() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		List<EmployeeTimeSheet> ff = em.createQuery(QUERY_ALL, EmployeeTimeSheet.class).getResultList();
		em.close();

		return ff;
	}

	public List<EmployeeTimeSheet> getEmployeeTimeSheets(EmployeeProject employeeProject, LocalDate startDate,
			LocalDate endDate) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		List<EmployeeTimeSheet> ff = em.createQuery(QUERY_EMP, EmployeeTimeSheet.class)
				.setParameter("epID", employeeProject.getId()).setParameter("startDate", startDate)
				.setParameter("endDate", endDate).getResultList();
		em.close();

		return ff;
	}

	public List<EmployeeTimeSheet> getEmployeeTimeSheets(EmployeeProject employeeProject) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		List<EmployeeTimeSheet> ff = em.createQuery(QUERY_EMP_1, EmployeeTimeSheet.class)
				.setParameter("epID", employeeProject.getId()).getResultList();
		em.close();

		return ff;
	}

	public ObservableList<EmployeeTimeSheet> getEmployeeTimeSheetsObservableList() {
		ObservableList<EmployeeTimeSheet> employeeTimeSheet = FXCollections.observableArrayList();
		List<EmployeeTimeSheet> lp = getEmployeeTimeSheets();

		lp.stream().forEach(p -> employeeTimeSheet.add(p));

		return employeeTimeSheet;
	}

	public boolean setEmployeeTimeSheet(EmployeeTimeSheet employeeTimeSheet) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		if (em.find(EmployeeTimeSheet.class, employeeTimeSheet.getId()) == null) {

			if (employeeTimeSheet.getCreatedDate() == null) {
				employeeTimeSheet.setCreatedDate(LocalDate.now());
			}

			tx.begin();
			em.persist(employeeTimeSheet);
			tx.commit();
		}
		em.close();

		return true;

	}
}
