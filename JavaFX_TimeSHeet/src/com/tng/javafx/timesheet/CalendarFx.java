package com.tng.javafx.timesheet;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Random;

import com.sun.javafx.scene.control.skin.DatePickerSkin;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Callback;

public class CalendarFx extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			ObservableList<String> images = FXCollections.observableArrayList("sunny.png", "kweather.png", "cloud.png",
					"sun_rain.png", "showers.png");
			DatePicker date_picker = new DatePicker();
			date_picker.setShowWeekNumbers(false);

			date_picker.setDayCellFactory(new Callback<DatePicker, DateCell>() {

				@Override
				public DateCell call(DatePicker param) {

					return new DateCell() {
						@Override
						public void updateItem(LocalDate item, boolean empty) {
							super.updateItem(item, empty);

							if (empty || item == null) {
								setText(null);
								setGraphic(null);

							} else {

								StackPane cell_pane = new StackPane();

								Circle circle = new Circle(20);

								Label label = new Label();
								label.setText(getText());
								// label.setFont(Fonts.bebasNeue(17));//Enzo library font
								// label.setTextFill(Color.AQUA);
								label.setLabelFor(circle);
								CheckBox cb = new CheckBox();
								cell_pane.getChildren().addAll(circle, label, cb);

								// item.get(ChronoField.DAY_OF_WEEK) returns an int from 1 to 7(Monday-Sunday)
								// DayOfWeek.of(int) return the name of the day of week. type ENUM.

								DayOfWeek day = DayOfWeek.of(item.get(ChronoField.DAY_OF_WEEK));

								if (day.equals(DayOfWeek.SATURDAY)) {
									setStyle("-fx-background-color:blue;");// saturday cells blue background
								} else if (day.equals(DayOfWeek.SUNDAY)) {
									setStyle("-fx-background-color:green;");// sunday cells green background
								} else {
									setStyle("-fx-background-color:grey;"); // weekdays grey
								}
								setGraphic(cell_pane);
								setText("");// dont show any text in the cells

							}

						}
					};
				};
			});

			@SuppressWarnings("restriction")
			// DatePickerSkin datePickerSkin = new DatePickerSkin(new
			// DatePicker(LocalDate.now()));
			DatePickerSkin datePickerSkin = new DatePickerSkin(date_picker);
			@SuppressWarnings("restriction")
			Node popupContent = datePickerSkin.getPopupContent();

			root.setCenter(popupContent);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
