package com.tng.javafx.timesheet.project;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProjectData {
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("test");

	public Project getProject(int id) {
		//Project project = em.find(Project.class, i);
		return null;
	}

}
