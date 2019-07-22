package com.tng.javafx.timesheet.project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tng.javafx.timesheet.weekview.Test;

public class TestData {

	public TestData() {
		testDB();
	}

	private void testDB() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		Test test = em.find(Test.class, 1);

		if (test == null) {
			System.out.format("new record");
			test = new Test();
			test.id = 1;
			test.data = "a";

			tx.begin();
			em.persist(test);
			tx.commit();
		}

		System.out.format("Test{id=%s, data=%s}\n", test.id, test.data);

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

		em.close();
		emf.close();

	}

}
