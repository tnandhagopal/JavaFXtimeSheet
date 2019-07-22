package com.tng.javafx.timesheet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.Map.Entry;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class TimeSheetController {

	@FXML
	private Label day_Label_0_1;

	@FXML
	private TextField day_Text_0_2;

	@FXML
	private TextField day_Text_2_1;

	@FXML
	private Label day_Label_0_2;

	@FXML
	private TextField day_Text_0_3;

	@FXML
	private Label day_Label_2_1;

	@FXML
	private TextField day_Text_2_2;

	@FXML
	private Label day_Label_0_3;

	@FXML
	private TextField day_Text_0_4;

	@FXML
	private TextField day_Text_4_1;

	@FXML
	private Label day_Label_2_2;

	@FXML
	private TextField day_Text_2_3;

	@FXML
	private Label day_Label_0_4;

	@FXML
	private TextField day_Text_0_5;

	@FXML
	private TextField day_Text_0_1;

	@FXML
	private Label day_Label_6_3;

	@FXML
	private TextField day_Text_6_4;

	@FXML
	private Label day_Label_4_5;

	@FXML
	private TextField day_Text_4_6;

	@FXML
	private Label day_Label_6_4;

	@FXML
	private TextField day_Text_6_5;

	@FXML
	private Label day_Label_4_6;

	@FXML
	private Label day_Label_6_5;

	@FXML
	private TextField day_Text_6_6;

	@FXML
	private Label day_Label_6_6;

	@FXML
	private Label day_Label_4_1;

	@FXML
	private TextField day_Text_4_2;

	@FXML
	private Label day_Label_2_3;

	@FXML
	private TextField day_Text_2_4;

	@FXML
	private Label day_Label_0_5;

	@FXML
	private TextField day_Text_0_6;

	@FXML
	private TextField day_Text_6_1;

	@FXML
	private Label day_Label_4_2;

	@FXML
	private TextField day_Text_4_3;

	@FXML
	private Label day_Label_2_4;

	@FXML
	private TextField day_Text_2_5;

	@FXML
	private Label day_Label_0_6;

	@FXML
	private Label day_Label_6_1;

	@FXML
	private TextField day_Text_6_2;

	@FXML
	private Label day_Label_4_3;

	@FXML
	private TextField day_Text_4_4;

	@FXML
	private Label day_Label_2_5;

	@FXML
	private TextField day_Text_2_6;

	@FXML
	private Label day_Label_6_2;

	@FXML
	private TextField day_Text_6_3;

	@FXML
	private Label day_Label_4_4;

	@FXML
	private TextField day_Text_4_5;

	@FXML
	private Label day_Label_2_6;

	@FXML
	private Hyperlink linkForward;

	@FXML
	private Label labelMonthYear;

	@FXML
	private GridPane gridPane;

	@FXML
	private Hyperlink linkBackward;

	@FXML
	private TextField day_Text_1_1;

	@FXML
	private Label day_Label_1_1;

	@FXML
	private TextField day_Text_1_2;

	@FXML
	private TextField day_Text_3_1;

	@FXML
	private Label day_Label_1_2;

	@FXML
	private TextField day_Text_1_3;

	@FXML
	private Label week;

	@FXML
	private Label day_Label_3_1;

	@FXML
	private TextField day_Text_3_2;

	@FXML
	private Label day_Label_1_3;

	@FXML
	private TextField day_Text_1_4;

	@FXML
	private Label day_Label_5_4;

	@FXML
	private TextField day_Text_5_5;

	@FXML
	private Label day_Label_3_6;

	@FXML
	private Label day_Label_5_5;

	@FXML
	private TextField day_Text_5_6;

	@FXML
	private Label day_Label_5_6;

	@FXML
	private TextField day_Text_5_1;

	@FXML
	private Label day_Label_3_2;

	@FXML
	private TextField day_Text_3_3;

	@FXML
	private Label day_Label_1_4;

	@FXML
	private TextField day_Text_1_5;

	@FXML
	private Label day_Label_5_1;

	@FXML
	private TextField day_Text_5_2;

	@FXML
	private Label day_Label_3_3;

	@FXML
	private TextField day_Text_3_4;

	@FXML
	private Label day_Label_1_5;

	@FXML
	private TextField day_Text_1_6;

	@FXML
	private Label day_Label_5_2;

	@FXML
	private TextField day_Text_5_3;

	@FXML
	private Label day_Label_3_4;

	@FXML
	private TextField day_Text_3_5;

	@FXML
	private Label day_Label_1_6;

	@FXML
	private Label day_Label_5_3;

	@FXML
	private TextField day_Text_5_4;

	@FXML
	private Label day_Label_3_5;

	@FXML
	private TextField day_Text_3_6;

	HashMap<String, Label> mLabel = new HashMap<String, Label>();
	HashMap<String, TextField> mText = new HashMap<String, TextField>();

	LocalDate firstOfCurrentMonth;

	@FXML
	public void initialize() {
		System.out.println("initialize");

		firstOfCurrentMonth = LocalDate.now().with(ChronoField.DAY_OF_MONTH, 1);

		// labelMonthYear.setText(firstOfCurrentMonth.format(DateTimeFormatter.ofPattern("MMMM
		// YYYY")));

		mLabel.put("0_1", day_Label_0_1);
		mLabel.put("1_1", day_Label_1_1);
		mLabel.put("2_1", day_Label_2_1);
		mLabel.put("3_1", day_Label_3_1);
		mLabel.put("4_1", day_Label_4_1);
		mLabel.put("5_1", day_Label_5_1);
		mLabel.put("6_1", day_Label_6_1);
		mLabel.put("0_2", day_Label_0_2);
		mLabel.put("1_2", day_Label_1_2);
		mLabel.put("2_2", day_Label_2_2);
		mLabel.put("3_2", day_Label_3_2);
		mLabel.put("4_2", day_Label_4_2);
		mLabel.put("5_2", day_Label_5_2);
		mLabel.put("6_2", day_Label_6_2);
		mLabel.put("0_3", day_Label_0_3);
		mLabel.put("1_3", day_Label_1_3);
		mLabel.put("2_3", day_Label_2_3);
		mLabel.put("3_3", day_Label_3_3);
		mLabel.put("4_3", day_Label_4_3);
		mLabel.put("5_3", day_Label_5_3);
		mLabel.put("6_3", day_Label_6_3);
		mLabel.put("0_4", day_Label_0_4);
		mLabel.put("1_4", day_Label_1_4);
		mLabel.put("2_4", day_Label_2_4);
		mLabel.put("3_4", day_Label_3_4);
		mLabel.put("4_4", day_Label_4_4);
		mLabel.put("5_4", day_Label_5_4);
		mLabel.put("6_4", day_Label_6_4);
		mLabel.put("0_5", day_Label_0_5);
		mLabel.put("1_5", day_Label_1_5);
		mLabel.put("2_5", day_Label_2_5);
		mLabel.put("3_5", day_Label_3_5);
		mLabel.put("4_5", day_Label_4_5);
		mLabel.put("5_5", day_Label_5_5);
		mLabel.put("6_5", day_Label_6_5);
		mLabel.put("0_6", day_Label_0_6);
		mLabel.put("1_6", day_Label_1_6);
		mLabel.put("2_6", day_Label_2_6);
		mLabel.put("3_6", day_Label_3_6);
		mLabel.put("4_6", day_Label_4_6);
		mLabel.put("5_6", day_Label_5_6);
		mLabel.put("6_6", day_Label_6_6);

		mText.put("0_1", day_Text_0_1);
		mText.put("1_1", day_Text_1_1);
		mText.put("2_1", day_Text_2_1);
		mText.put("3_1", day_Text_3_1);
		mText.put("4_1", day_Text_4_1);
		mText.put("5_1", day_Text_5_1);
		mText.put("6_1", day_Text_6_1);
		mText.put("0_2", day_Text_0_2);
		mText.put("1_2", day_Text_1_2);
		mText.put("2_2", day_Text_2_2);
		mText.put("3_2", day_Text_3_2);
		mText.put("4_2", day_Text_4_2);
		mText.put("5_2", day_Text_5_2);
		mText.put("6_2", day_Text_6_2);
		mText.put("0_3", day_Text_0_3);
		mText.put("1_3", day_Text_1_3);
		mText.put("2_3", day_Text_2_3);
		mText.put("3_3", day_Text_3_3);
		mText.put("4_3", day_Text_4_3);
		mText.put("5_3", day_Text_5_3);
		mText.put("6_3", day_Text_6_3);
		mText.put("0_4", day_Text_0_4);
		mText.put("1_4", day_Text_1_4);
		mText.put("2_4", day_Text_2_4);
		mText.put("3_4", day_Text_3_4);
		mText.put("4_4", day_Text_4_4);
		mText.put("5_4", day_Text_5_4);
		mText.put("6_4", day_Text_6_4);
		mText.put("0_5", day_Text_0_5);
		mText.put("1_5", day_Text_1_5);
		mText.put("2_5", day_Text_2_5);
		mText.put("3_5", day_Text_3_5);
		mText.put("4_5", day_Text_4_5);
		mText.put("5_5", day_Text_5_5);
		mText.put("6_5", day_Text_6_5);
		mText.put("0_6", day_Text_0_6);
		mText.put("1_6", day_Text_1_6);
		mText.put("2_6", day_Text_2_6);
		mText.put("3_6", day_Text_3_6);
		mText.put("4_6", day_Text_4_6);
		mText.put("5_6", day_Text_5_6);
		mText.put("6_6", day_Text_6_6);

		setCalender(firstOfCurrentMonth);

	}

	@FXML
	private void handleBackword(ActionEvent e) {
		firstOfCurrentMonth = firstOfCurrentMonth.minusMonths(1);
		setCalender(firstOfCurrentMonth);
	}

	@FXML
	private void handleForword(ActionEvent e) {
		firstOfCurrentMonth = firstOfCurrentMonth.plusMonths(1);
		setCalender(firstOfCurrentMonth);
	}

	private void setCalender(LocalDate firstOfCurrentMonth) {

		labelMonthYear.setText(firstOfCurrentMonth.format(DateTimeFormatter.ofPattern("MMMM YYYY")));

		for (Entry<String, Label> mL : mLabel.entrySet()) {
			mL.getValue().setText(null);
		}

		for (Entry<String, TextField> mT : mText.entrySet()) {
			TextField tf = mT.getValue();
			tf.setVisible(false);
			tf.clear();
		}

		LocalDate lastOfCurrentMonth = firstOfCurrentMonth.with(TemporalAdjusters.lastDayOfMonth());
		// System.out.println("Last Date : " + lastOfCurrentMonth);

		int j = 1;
		for (LocalDate ld = firstOfCurrentMonth; ld.isBefore(lastOfCurrentMonth.plusDays(1)); ld = ld.plusDays(1)) {
			// System.out.println(ld.toString());

			int i = ld.getDayOfWeek().getValue();
			if (i == 7)
				i = 0;

			// System.out.println(ld.getDayOfWeek() + " : " + ld.getDayOfWeek().getValue());

			Label dayLabel = mLabel.get(i + "_" + j);
			dayLabel.setText(ld.format(DateTimeFormatter.ofPattern("dd")));

			TextField dayText = mText.get(i + "_" + j);
			dayText.setVisible(true);
			dayText.setText(8 + " hrs");

			if (i == 6)
				j++;

		}
	}

}
