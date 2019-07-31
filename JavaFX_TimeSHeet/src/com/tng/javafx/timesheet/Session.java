package com.tng.javafx.timesheet;

import com.tng.javafx.timesheet.employee.Employee;

public class Session {

	private static Employee employee;

	public static Employee getEmployee() {
		return employee;
	}

	public static void setEmployee(Employee employee) {
		Session.employee = employee;
	}
}
