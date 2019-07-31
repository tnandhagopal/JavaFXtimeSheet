package com.tng.javafx.timesheet.project;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.QueryHint;

import com.tng.javafx.timesheet.employee.Employee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProjectData {
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("test");
	private static String QUERY_ALL = "select p from Project p where p.id is not null";
	private static String QUERY_EP_E = "select ep.project from EmployeeProject ep where ep.employee.id = :e_id";

	public Project getProject(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		// EntityTransaction tx = em.getTransaction();

		Project project = em.find(Project.class, id);

		em.close();
		return project;
	}

	public List<Project> getProjects() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		List<Project> ff = em.createQuery(QUERY_ALL, Project.class).getResultList();
		em.close();

		return ff;
	}

	public List<Project> getProjects(Employee employee) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		List<Project> ff = em.createQuery(QUERY_EP_E, Project.class).setParameter("e_id", employee.getId())
				.getResultList();
		em.close();

		return ff;
	}

	public ObservableList<Project> getProjectsObservableList() {
		ObservableList<Project> project = FXCollections.observableArrayList();
		List<Project> lp = getProjects();

		lp.stream().forEach(p -> project.add(p));

		return project;
	}

	public ObservableList<Project> getProjectsObservableList(Employee employee) {
		ObservableList<Project> project = FXCollections.observableArrayList();
		List<Project> lp = getProjects(employee);

		lp.stream().forEach(p -> project.add(p));

		return project;
	}

	public boolean setProject(Project project) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		if (em.find(Project.class, project.getId()) == null) {
			tx.begin();
			em.persist(project);
			tx.commit();
		}
		em.close();

		return true;

	}

}
