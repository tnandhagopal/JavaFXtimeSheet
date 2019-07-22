package com.tng.javafx.timesheet.weekview;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tng.javafx.timesheet.project.TestData;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.layout.VBox;

public class WeekViewController {

	@FXML
	private TableColumn<WeekView, String> colProject;

	@FXML
	private TableColumn<WeekView, Number> colMon;

	@FXML
	private TableColumn<WeekView, Number> colTus;

	@FXML
	private TableColumn<WeekView, Number> colWed;

	@FXML
	private TableColumn<WeekView, Number> colThu;

	@FXML
	private TableColumn<WeekView, Number> colFri;

	@FXML
	private TableColumn<WeekView, Number> colSat;

	@FXML
	private TableColumn<WeekView, Number> colSun;

	@FXML
	private TableColumn<WeekView, Number> colTotal;

	@FXML
	private TableView<WeekView> tableWeekView;

	@FXML
	private VBox vboxWeekView;

	@FXML
	private Hyperlink hlForward;

	@FXML
	private Hyperlink hlBackward;

	LocalDate firstOfCurrentWeek;

	HashMap<DayOfWeek, Object> hmTableColumn = new HashMap<DayOfWeek, Object>();

	private ObservableList<WeekView> masterData = FXCollections.observableArrayList();

	@FXML
	public void initialize() {
		System.out.println("initialize");
		testDB();
		masterData.add(new WeekView("rrr", 1, 2, 3, 4, 5, 6, 7));

		hmTableColumn.put(DayOfWeek.MONDAY, colMon);
		hmTableColumn.put(DayOfWeek.TUESDAY, colTus);
		hmTableColumn.put(DayOfWeek.WEDNESDAY, colWed);
		hmTableColumn.put(DayOfWeek.THURSDAY, colThu);
		hmTableColumn.put(DayOfWeek.FRIDAY, colFri);
		hmTableColumn.put(DayOfWeek.SATURDAY, colSat);
		hmTableColumn.put(DayOfWeek.SUNDAY, colSun);

		firstOfCurrentWeek = LocalDate.now().with(ChronoField.DAY_OF_WEEK, 1);
		setWeekView(firstOfCurrentWeek);

		colProject.setCellValueFactory(cellData -> cellData.getValue().getProject());
		colProject.setCellFactory(ComboBoxTableCell.forTableColumn("Friends", "Family", "Work Contacts"));
		colProject.setOnEditCommit(edit -> System.out.println(edit.getNewValue()));

		colMon.setCellValueFactory(cellData -> cellData.getValue().getMon());
		colTus.setCellValueFactory(cellData -> cellData.getValue().getTus());
		colWed.setCellValueFactory(cellData -> cellData.getValue().getWed());
		colThu.setCellValueFactory(cellData -> cellData.getValue().getThu());
		colFri.setCellValueFactory(cellData -> cellData.getValue().getFri());
		colSat.setCellValueFactory(cellData -> cellData.getValue().getSat());
		colSun.setCellValueFactory(cellData -> cellData.getValue().getSun());
		colTotal.setCellValueFactory(cellData -> cellData.getValue().getTotal());

		FilteredList<WeekView> filteredData = new FilteredList<>(masterData, p -> masterData.indexOf(p) < 4);
		SortedList<WeekView> sortedData = new SortedList<>(filteredData);
		tableWeekView.setItems(sortedData);

	}

	private void setWeekView(LocalDate firstOfCurrentWeek) {
		colMon.setText(colMon.getText() + "  " + firstOfCurrentWeek.format(DateTimeFormatter.ofPattern("dd")));
		colTus.setText(colTus.getText() + "  " + firstOfCurrentWeek.format(DateTimeFormatter.ofPattern("dd")));
		LocalDate lastOfCurrentWeek = firstOfCurrentWeek.plusDays(6);

		for (LocalDate ld = firstOfCurrentWeek; ld.isBefore(lastOfCurrentWeek.plusDays(1)); ld = ld.plusDays(1)) {
			TableColumn<?, ?> tableColumn = (TableColumn<?, ?>) hmTableColumn.get(ld.getDayOfWeek());
			tableColumn.setText(ld.format(DateTimeFormatter.ofPattern("E, dd MMM YY")));
		}

	}

	@FXML
	void handleBackward(ActionEvent event) {
		firstOfCurrentWeek = firstOfCurrentWeek.minusWeeks(1);
		setWeekView(firstOfCurrentWeek);
	}

	@FXML
	void handleForward(ActionEvent event) {
		firstOfCurrentWeek = firstOfCurrentWeek.plusWeeks(1);
		setWeekView(firstOfCurrentWeek);
	}

	private void testDB() {

		new TestData();

	}

}