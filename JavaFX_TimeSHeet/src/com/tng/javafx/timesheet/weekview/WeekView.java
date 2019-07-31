package com.tng.javafx.timesheet.weekview;

import java.time.DayOfWeek;
import java.util.List;

import com.tng.javafx.timesheet.employee.EmployeeTimeSheet;
import com.tng.javafx.timesheet.project.Project;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class WeekView {
	private final ObjectProperty<EmployeeTimeSheet> sun;
	private final ObjectProperty<EmployeeTimeSheet> mon;
	private final ObjectProperty<EmployeeTimeSheet> tus;
	private final ObjectProperty<EmployeeTimeSheet> wed;
	private final ObjectProperty<EmployeeTimeSheet> thu;
	private final ObjectProperty<EmployeeTimeSheet> fri;
	private final ObjectProperty<EmployeeTimeSheet> sat;

	private final ObjectProperty<Project> project;
	private final IntegerProperty total;

	public WeekView(Project project, EmployeeTimeSheet mon, EmployeeTimeSheet tus, EmployeeTimeSheet wed,
			EmployeeTimeSheet thu, EmployeeTimeSheet fri, EmployeeTimeSheet sat, EmployeeTimeSheet sun) {
		this.sun = new SimpleObjectProperty<EmployeeTimeSheet>(sun);
		this.mon = new SimpleObjectProperty<EmployeeTimeSheet>(mon);
		this.tus = new SimpleObjectProperty<EmployeeTimeSheet>(tus);
		this.wed = new SimpleObjectProperty<EmployeeTimeSheet>(wed);
		this.thu = new SimpleObjectProperty<EmployeeTimeSheet>(thu);
		this.fri = new SimpleObjectProperty<EmployeeTimeSheet>(fri);
		this.sat = new SimpleObjectProperty<EmployeeTimeSheet>(sat);
		this.project = new SimpleObjectProperty<Project>(project);
		this.total = new SimpleIntegerProperty(sun.getTime() + mon.getTime() + tus.getTime() + wed.getTime()
				+ thu.getTime() + fri.getTime() + sat.getTime());
		// System.out.println(this.total);
	}

	public WeekView(List<EmployeeTimeSheet> employeeTimeSheet, Project project) {

		System.out.println("employeeTimeSheet.size = " + employeeTimeSheet.size());

		this.sun = new SimpleObjectProperty<EmployeeTimeSheet>(employeeTimeSheet.stream()
				.filter(ets -> DayOfWeek.SUNDAY.equals(ets.getDay().getDayOfWeek())).findAny().orElse(null));

		this.mon = new SimpleObjectProperty<EmployeeTimeSheet>(employeeTimeSheet.stream()
				.filter(ets -> DayOfWeek.MONDAY.equals(ets.getDay().getDayOfWeek())).findAny().orElse(null));

		this.tus = new SimpleObjectProperty<EmployeeTimeSheet>(employeeTimeSheet.stream()
				.filter(ets -> DayOfWeek.TUESDAY.equals(ets.getDay().getDayOfWeek())).findAny().orElse(null));

		this.wed = new SimpleObjectProperty<EmployeeTimeSheet>(employeeTimeSheet.stream()
				.filter(ets -> DayOfWeek.WEDNESDAY.equals(ets.getDay().getDayOfWeek())).findAny().orElse(null));

		this.thu = new SimpleObjectProperty<EmployeeTimeSheet>(employeeTimeSheet.stream()
				.filter(ets -> DayOfWeek.THURSDAY.equals(ets.getDay().getDayOfWeek())).findAny().orElse(null));

		this.fri = new SimpleObjectProperty<EmployeeTimeSheet>(employeeTimeSheet.stream()
				.filter(ets -> DayOfWeek.FRIDAY.equals(ets.getDay().getDayOfWeek())).findAny().orElse(null));

		this.sat = new SimpleObjectProperty<EmployeeTimeSheet>(employeeTimeSheet.stream()
				.filter(ets -> DayOfWeek.SATURDAY.equals(ets.getDay().getDayOfWeek())).findAny().orElse(null));

		this.project = new SimpleObjectProperty<Project>(project);

		this.total = new SimpleIntegerProperty(10);
//		this.total = new SimpleIntegerProperty(this.sun.getValue().getTime() + this.mon.getValue().getTime()
//				+ this.tus.getValue().getTime() + this.wed.getValue().getTime() + this.thu.getValue().getTime()
//				+ this.fri.getValue().getTime() + this.sat.getValue().getTime());

	}

	public ObjectProperty<Project> getProject() {
		return project;
	}

	public IntegerProperty getTotal() {
		return total;
	}

	public ObjectProperty<EmployeeTimeSheet> getSun() {
		return sun;
	}

	public ObjectProperty<EmployeeTimeSheet> getMon() {
		return mon;
	}

	public ObjectProperty<EmployeeTimeSheet> getTus() {
		return tus;
	}

	public ObjectProperty<EmployeeTimeSheet> getWed() {
		return wed;
	}

	public ObjectProperty<EmployeeTimeSheet> getThu() {
		return thu;
	}

	public ObjectProperty<EmployeeTimeSheet> getFri() {
		return fri;
	}

	public ObjectProperty<EmployeeTimeSheet> getSat() {
		return sat;
	}

}
