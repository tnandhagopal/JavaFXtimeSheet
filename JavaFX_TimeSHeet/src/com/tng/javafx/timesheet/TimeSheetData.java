package com.tng.javafx.timesheet;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TimeSheetData {
	private ObservableList<TimeSheet> masterData = FXCollections.observableArrayList();

	public TimeSheetData() {
		masterData.add(new TimeSheet("8", "5", "5", "5", "5", "5", "5"));
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println(cal.getTime().toString());
		System.out.println(cal.getFirstDayOfWeek() + "|");
		LocalDate firstOfCurrentMonth = LocalDate.now().with(ChronoField.DAY_OF_MONTH, 1);
		System.out.println(firstOfCurrentMonth.getDayOfWeek().getValue() );
		
	}

	public ObservableList<TimeSheet> getMasterData() {
		return masterData;
	}

	public void setMasterData(ObservableList<TimeSheet> masterData) {
		this.masterData = masterData;
	}

}
