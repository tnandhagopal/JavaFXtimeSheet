package com.tng.javafx.timesheet.weekview;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.tng.javafx.timesheet.Session;
import com.tng.javafx.timesheet.employee.Employee;
import com.tng.javafx.timesheet.employee.EmployeeData;
import com.tng.javafx.timesheet.employee.EmployeeProject;
import com.tng.javafx.timesheet.employee.EmployeeProjectData;
import com.tng.javafx.timesheet.employee.EmployeeTimeSheet;
import com.tng.javafx.timesheet.employee.EmployeeTimeSheetData;
import com.tng.javafx.timesheet.project.Project;
import com.tng.javafx.timesheet.project.ProjectData;
import com.tng.javafx.timesheet.project.TestData;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class WeekViewController {

	@FXML
	private TableColumn<WeekView, Project> colProject;

	@FXML
	private TableColumn<WeekView, EmployeeTimeSheet> colMon;

	@FXML
	private TableColumn<WeekView, EmployeeTimeSheet> colTus;

	@FXML
	private TableColumn<WeekView, EmployeeTimeSheet> colWed;

	@FXML
	private TableColumn<WeekView, EmployeeTimeSheet> colThu;

	@FXML
	private TableColumn<WeekView, EmployeeTimeSheet> colFri;

	@FXML
	private TableColumn<WeekView, EmployeeTimeSheet> colSat;

	@FXML
	private TableColumn<WeekView, EmployeeTimeSheet> colSun;

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

	@FXML
	private Label labelDates;

	private LocalDate firstOfCurrentWeek;

	private HashMap<DayOfWeek, TableColumn<WeekView, EmployeeTimeSheet>> hmTableColumn = new HashMap<DayOfWeek, TableColumn<WeekView, EmployeeTimeSheet>>();

	private ObservableList<WeekView> masterData = FXCollections.observableArrayList();
	private ObservableList<Project> project = FXCollections.observableArrayList();

	private ProjectData projectData = new ProjectData();

	private EmployeeData employeeData = new EmployeeData();

	private EmployeeProjectData employeeProjectData = new EmployeeProjectData();

	private Employee employee;

	List<EmployeeProject> employeeProjectList = null;

	@FXML
	public void initialize() {
		System.out.println("initialize");
		tableWeekView.setEditable(true);
		// testDB();

		// employee = employeeData.getEmployees("Nandhagopal");
		employee = Session.getEmployee();
		System.out.println(employee.getFirstName());

		employeeProjectList = employeeProjectData.getEmployeeProjects(employee);
		project = projectData.getProjectsObservableList(employee);

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

		colProject.setCellFactory(column -> {
			return new TableCell<WeekView, Project>() {
				@Override
				protected void updateItem(Project item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(item.getName());
					}
				}
			};
		});

		colProject.setCellFactory(ComboBoxTableCell.forTableColumn(new StringConverter<Project>() {

			@Override
			public String toString(Project project) {
				return project.getName();
			}

			@Override
			public Project fromString(String string) {
				return null;
			}

		}, project));

		colProject.setOnEditCommit(edit -> System.out.println(edit.getNewValue().getName()));

		colMon.setCellValueFactory(cellData -> cellData.getValue().getMon());
		colMon.setCellFactory(column -> {
			return new TableCell<WeekView, EmployeeTimeSheet>() {
				@Override
				protected void updateItem(EmployeeTimeSheet item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(String.valueOf(item.getTime()));
					}
				}
			};
		});

		colMon.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<EmployeeTimeSheet>() {
			@Override
			public String toString(EmployeeTimeSheet employeeTimeSheet) {
				try {
					return employeeTimeSheet.getTimeString();
				} catch (Exception e) {
					return null;
				}
			}

			@Override
			public EmployeeTimeSheet fromString(String string) {
				return null;
			}
		}));

		colMon.setOnEditCommit(edit -> {
			System.out.println(edit.getNewValue().toString());

		});

		colTus.setCellValueFactory(cellData -> cellData.getValue().getTus());
		colTus.setCellFactory(column -> {
			return new TableCell<WeekView, EmployeeTimeSheet>() {
				@Override
				protected void updateItem(EmployeeTimeSheet item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(String.valueOf(item.getTime()));
					}
				}
			};
		});

//		colTus.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
//		colTus.setOnEditCommit(edit -> System.out.println(edit.getNewValue().toString()));

		colWed.setCellValueFactory(cellData -> cellData.getValue().getWed());
		colWed.setCellFactory(column -> {
			return new TableCell<WeekView, EmployeeTimeSheet>() {
				@Override
				protected void updateItem(EmployeeTimeSheet item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(String.valueOf(item.getTime()));
					}
				}
			};
		});
//		colWed.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
//		colWed.setOnEditCommit(edit -> System.out.println(edit.getNewValue().toString()));

		colThu.setCellValueFactory(cellData -> cellData.getValue().getThu());
		colThu.setCellFactory(column -> {
			return new TableCell<WeekView, EmployeeTimeSheet>() {
				@Override
				protected void updateItem(EmployeeTimeSheet item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(String.valueOf(item.getTime()));
					}
				}
			};
		});
//		colThu.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
//		colThu.setOnEditCommit(edit -> System.out.println(edit.getNewValue().toString()));

		colFri.setCellValueFactory(cellData -> cellData.getValue().getFri());
		colFri.setCellFactory(column -> {
			return new TableCell<WeekView, EmployeeTimeSheet>() {
				@Override
				protected void updateItem(EmployeeTimeSheet item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(String.valueOf(item.getTime()));
					}
				}
			};
		});
//		colFri.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
//		colFri.setOnEditCommit(edit -> System.out.println(edit.getNewValue().toString()));

		colSat.setCellValueFactory(cellData -> cellData.getValue().getSat());
		colSat.setCellFactory(column -> {
			return new TableCell<WeekView, EmployeeTimeSheet>() {
				@Override
				protected void updateItem(EmployeeTimeSheet item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(String.valueOf(item.getTime()));
					}
				}
			};
		});
//		colSat.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
//		colSat.setOnEditCommit(edit -> System.out.println(edit.getNewValue().toString()));

		colSun.setCellValueFactory(cellData -> cellData.getValue().getSun());
		colSun.setCellFactory(column -> {
			return new TableCell<WeekView, EmployeeTimeSheet>() {
				@Override
				protected void updateItem(EmployeeTimeSheet item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(String.valueOf(item.getTime()));
					}
				}
			};
		});

//		colSun.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
//		colSun.setOnEditCommit(edit -> System.out.println(edit.getNewValue().toString()));

		colTotal.setCellValueFactory(cellData -> cellData.getValue().getTotal());

		FilteredList<WeekView> filteredData = new FilteredList<>(masterData, p -> masterData.indexOf(p) < 4);
		SortedList<WeekView> sortedData = new SortedList<>(filteredData);
		tableWeekView.setItems(sortedData);

	}

	private void setWeekView(LocalDate firstOfCurrentWeek) {
		masterData.clear();
		LocalDate lastOfCurrentWeek = firstOfCurrentWeek.plusDays(6);

		employeeProjectList.stream().forEach(employeeProject -> {

			List<EmployeeTimeSheet> listETS1 = new EmployeeTimeSheetData().getEmployeeTimeSheets(employeeProject);

			listETS1.stream().forEach(q -> System.out.println(q.getDay()));

			List<EmployeeTimeSheet> listETS12 = new EmployeeTimeSheetData().getEmployeeTimeSheets();

			listETS12.stream().forEach(q -> System.out.println(q.getDay()));

			List<EmployeeTimeSheet> listETS = new EmployeeTimeSheetData().getEmployeeTimeSheets(employeeProject,
					firstOfCurrentWeek, lastOfCurrentWeek);
			masterData.add(new WeekView(listETS, employeeProject.getProject()));
		});

		colMon.setText(colMon.getText() + "  " + firstOfCurrentWeek.format(DateTimeFormatter.ofPattern("dd")));
		colTus.setText(colTus.getText() + "  " + firstOfCurrentWeek.format(DateTimeFormatter.ofPattern("dd")));

		labelDates.setText(firstOfCurrentWeek.format(DateTimeFormatter.ofPattern("dd MMM YYYY")) + "   to   "
				+ lastOfCurrentWeek.format(DateTimeFormatter.ofPattern("dd MMM YYYY")));

		for (LocalDate ld = firstOfCurrentWeek; ld.isBefore(lastOfCurrentWeek.plusDays(1)); ld = ld.plusDays(1)) {
			TableColumn<?, ?> tableColumn = (TableColumn<?, ?>) hmTableColumn.get(ld.getDayOfWeek());
			tableColumn.setText(ld.format(DateTimeFormatter.ofPattern("E, dd MMM")));

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

	private boolean validation(int value) {
		diplay();
		if (value > 24 || value < 0) {
			System.out.println("Numeric value can not more than 24 and less then 0!!");
			return false;
		}
		return true;

	}

	private void diplay() {
		masterData.forEach(ee -> System.out.println(ee.getMon()));
	}

	private void setMasterData() {
		// masterData;
	}
}
