package com.tng.javafx.timesheet.weekview;

import com.tng.javafx.timesheet.project.Project;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class WeekView {
	private final IntegerProperty sun;
	private final IntegerProperty mon;
	private final IntegerProperty tus;
	private final IntegerProperty wed;
	private final IntegerProperty thu;
	private final IntegerProperty fri;
	private final IntegerProperty sat;

	private final ObjectProperty<Project> project;
	private final IntegerProperty total;

	public WeekView(Project project, Integer mon, Integer tus, Integer wed, Integer thu, Integer fri, Integer sat,
			Integer sun) {
		this.sun = new SimpleIntegerProperty(sun);
		this.mon = new SimpleIntegerProperty(mon);
		this.tus = new SimpleIntegerProperty(tus);
		this.wed = new SimpleIntegerProperty(wed);
		this.thu = new SimpleIntegerProperty(thu);
		this.fri = new SimpleIntegerProperty(fri);
		this.sat = new SimpleIntegerProperty(sat);
		this.project = new SimpleObjectProperty<Project>(project);
		this.total = new SimpleIntegerProperty(sun + mon + tus + wed + thu + fri + sat);
		// System.out.println(this.total);
	}

	public ObjectProperty<Project> getProject() {
		return project;
	}

	public IntegerProperty getTotal() {
		return total;
	}

	public IntegerProperty getSun() {
		return sun;
	}

	public IntegerProperty getMon() {
		return mon;
	}

	public IntegerProperty getTus() {
		return tus;
	}

	public IntegerProperty getWed() {
		return wed;
	}

	public IntegerProperty getThu() {
		return thu;
	}

	public IntegerProperty getFri() {
		return fri;
	}

	public IntegerProperty getSat() {
		return sat;
	}

}
