package com.tng.javafx.timesheet.login;

import com.tng.javafx.timesheet.Session;
import com.tng.javafx.timesheet.employee.Employee;
import com.tng.javafx.timesheet.employee.EmployeeData;
import com.tng.javafx.timesheet.weekview.WeekViewApplications;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private TextField txtUserName;

	@FXML
	private Button btnLogin;

	@FXML
	private Label labelStatusLog;

	@FXML
	private TextField txtPassword;

	private EmployeeData employeeData = new EmployeeData();

	@FXML
	public void initialize() {
		System.out.println("initialize");

	}

	@FXML
	void handleLogin(ActionEvent event) {
		System.out.println(txtUserName.getText());
		System.out.println(txtPassword.getText());

		if (txtUserName.getText() != null & txtPassword.getText() != null & !txtPassword.getText().isEmpty()
				& !txtUserName.getText().isEmpty()) {
			Employee employee = employeeData.login(txtUserName.getText(), txtPassword.getText());
			if (employee != null) {
				Session.setEmployee(employee);
				labelStatusLog.setText("Login Success.");

				// labelStatusLog.get

				Stage primaryStage = LoginApplication.getWindow();

				try {
					Parent root = FXMLLoader.load(WeekViewApplications.class.getResource("WeekView.fxml"));
					primaryStage.setTitle("Time sheet week view");
					primaryStage.setScene(new Scene(root, 1000, 500));
					primaryStage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				labelStatusLog.setText("Wrong User or password !!");
			}
		} else {
			labelStatusLog.setText("User and password are mandatory!!");
		}
	}

}
