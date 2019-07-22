package com.tng.javafx.timesheet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TimeSheetController1 {

	@FXML
	private TableView<TimeSheet> timeSheet;

	@FXML
	private TableColumn<TimeSheet, String> sun;

	@FXML
	private TableColumn<TimeSheet, String> mon;

	@FXML
	private TableColumn<TimeSheet, String> tus;

	@FXML
	private TableColumn<TimeSheet, String> wed;

	@FXML
	private TableColumn<TimeSheet, String> thu;

	@FXML
	private TableColumn<TimeSheet, String> fri;

	@FXML
	private TableColumn<TimeSheet, String> sat;

	private ObservableList<TimeSheet> masterData = FXCollections.observableArrayList();

	@FXML
	public void initialize() {
		System.out.println("initialize");

		// masterData.add(new TimeSheet("8", "5", "5", "5", "5", "5", "5"));

		masterData.addAll(new TimeSheetData().getMasterData());

		sun.setCellValueFactory(cellData -> cellData.getValue().getSun());
		mon.setCellValueFactory(cellData -> cellData.getValue().getMon());
		tus.setCellValueFactory(cellData -> cellData.getValue().getTus());
		wed.setCellValueFactory(cellData -> cellData.getValue().getWed());
		thu.setCellValueFactory(cellData -> cellData.getValue().getThu());
		fri.setCellValueFactory(cellData -> cellData.getValue().getFri());
		sat.setCellValueFactory(cellData -> cellData.getValue().getSat());

		timeSheet.setItems(masterData);
	}
}
