package com.tng.javafx.timesheet.project;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

	@Id
	public int id;

	@Basic
	public String code;
	
	@Basic
	public String name;
}
