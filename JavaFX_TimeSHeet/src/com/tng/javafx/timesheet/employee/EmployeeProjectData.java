package com.tng.javafx.timesheet.employee;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeProjectData {
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("test");
	private static String QUERY_ALL = "select ep from EmployeeProject ep where ep.id is not null";
	private static String QUERY_EP_E = "select ep from EmployeeProject ep where ep.employee.id = :e_id";

	public EmployeeProject getEmployeeProject(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		// EntityTransaction tx = em.getTransaction();

		EmployeeProject employeeProject = em.find(EmployeeProject.class, id);

		em.close();
		return employeeProject;
	}

	public List<EmployeeProject> getEmployeeProjects() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		List<EmployeeProject> ff = em.createQuery(QUERY_ALL, EmployeeProject.class).getResultList();
		em.close();

		return ff;
	}

	public List<EmployeeProject> getEmployeeProjects(Employee employee) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		List<EmployeeProject> ff = em.createQuery(QUERY_EP_E, EmployeeProject.class)
				.setParameter("e_id", employee.getId()).getResultList();
		em.close();

		return ff;
	}

	public ObservableList<EmployeeProject> getEmployeeProjectsObservableList() {
		ObservableList<EmployeeProject> employeeProject = FXCollections.observableArrayList();
		List<EmployeeProject> lp = getEmployeeProjects();

		lp.stream().forEach(p -> employeeProject.add(p));

		return employeeProject;
	}

	public boolean setEmployeeProject(EmployeeProject employeeProject) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		if (em.find(EmployeeProject.class, employeeProject.getId()) == null) {

			if (employeeProject.getCreatedDate() == null) {
				employeeProject.setCreatedDate(LocalDate.now());
			}

			tx.begin();
			em.persist(employeeProject);
			tx.commit();
		}
		em.close();

		return true;

	}
}
