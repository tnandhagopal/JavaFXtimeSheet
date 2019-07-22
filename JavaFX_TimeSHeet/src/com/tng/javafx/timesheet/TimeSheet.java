package com.tng.javafx.timesheet;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TimeSheet {
	private final StringProperty sun;
	private final StringProperty mon;
	private final StringProperty tus;
	private final StringProperty wed;
	private final StringProperty thu;
	private final StringProperty fri;
	private final StringProperty sat;

	public TimeSheet(String sun, String mon, String tus, String wed, String thu, String fri, String sat) {
		this.sun = new SimpleStringProperty(sun);
		this.mon = new SimpleStringProperty(mon);
		this.tus = new SimpleStringProperty(tus);
		this.wed = new SimpleStringProperty(wed);
		this.thu = new SimpleStringProperty(thu);
		this.fri = new SimpleStringProperty(fri);
		this.sat = new SimpleStringProperty(sat);
	}

	public StringProperty getSun() {
		return sun;
	}

	public StringProperty getMon() {
		return mon;
	}

	public StringProperty getTus() {
		return tus;
	}

	public StringProperty getWed() {
		return wed;
	}

	public StringProperty getThu() {
		return thu;
	}

	public StringProperty getFri() {
		return fri;
	}

	public StringProperty getSat() {
		return sat;
	}

}
