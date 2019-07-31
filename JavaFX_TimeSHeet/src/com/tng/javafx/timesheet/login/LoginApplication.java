package com.tng.javafx.timesheet.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApplication extends Application {

	private static Stage window;

	public static Stage getWindow() {
		return window;
	}

	public static void setWindow(Stage window) {
		LoginApplication.window = window;
	}

	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			primaryStage.setTitle("Time sheet Application");
			primaryStage.setScene(new Scene(root, 600, 400));
			primaryStage.setFullScreen(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
