package com.tng.javafx.timesheet.weekview;

import com.tng.javafx.timesheet.Session;
import com.tng.javafx.timesheet.employee.EmployeeData;
import com.tng.javafx.timesheet.login.LoginApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WeekViewApplications extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("WeekView.fxml"));
			primaryStage.setTitle("Time sheet Application");
			primaryStage.setScene(new Scene(root, 1000, 500));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void launch() {
		Stage primaryStage = LoginApplication.getWindow();
		try {
			Parent root = FXMLLoader.load(WeekViewApplications.class.getResource("WeekView.fxml"));
			primaryStage.setTitle("Time sheet Application");
			primaryStage.setScene(new Scene(root, 1000, 500));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Session.setEmployee(new EmployeeData().getEmployees("Nandhagopal"));
		launch(args);
	}
}
