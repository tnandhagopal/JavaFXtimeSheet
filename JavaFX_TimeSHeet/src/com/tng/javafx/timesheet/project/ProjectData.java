package com.tng.javafx.timesheet.project;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProjectData {
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("test");
	private static String QUERY_ALL = "select p from Project p where p.id is not null";

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

	public ObservableList<Project> getProjectsObservableList() {
		// System.out.println("1");
		ObservableList<Project> project = FXCollections.observableArrayList();
//		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
//
//		project = (ObservableList<Project>) em.createQuery(QUERY_ALL, Project.class).setParameter(1, "English")
//				.getResultList();
//		em.close();

		List<Project> lp = getProjects();
		// project = (ObservableList<Project>) getProjects();

		lp.stream().forEach(p -> project.add(p));

//		for (Project p : lp) {
//			project.add(p);
//			// System.out.println(p.getName());
//		}

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
