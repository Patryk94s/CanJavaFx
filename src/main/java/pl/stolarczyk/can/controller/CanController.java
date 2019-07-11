package pl.stolarczyk.can.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import jssc.SerialPort;
import jssc.SerialPortException;
import pl.stolarczyk.can.mode.Alert;

public class CanController implements Initializable {

	@FXML
	private TextArea sendArea;

	@FXML
	private TextArea readArea;

	@FXML
	private Button buttonSend;

	@FXML
	private TextField fieldByte1;

	@FXML
	private TextField fieldByte2;

	@FXML
	private TextField fieldByte3;

	@FXML
	private TextField fieldByte4;

	@FXML
	private TextField fieldByte5;

	@FXML
	private TextField fieldByte6;

	@FXML
	private TextField fieldByte7;

	@FXML
	private TextField fieldByte8;

	@FXML
	private TextField fieldCanID;

	@FXML
	private ComboBox<String> comboBoxLength;

	@FXML
	private CheckBox checkBoxSM;

	@FXML
	private CheckBox checkBoxEM;

	@FXML
	private ComboBox<String> comboBoxBaudRate;

	@FXML
	private Button buttonReadCan;

	@FXML
	private Button button_clear;

	@FXML
	void button_clear_Action(ActionEvent event) {

		sendArea.clear();

	}

	public OptionsController op;

	private CanFrame canFrame = new CanFrame();

	@FXML
	void readCanOnAction(ActionEvent event) {

		try {

			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ReadCan.fxml"));
			Scene sce = new Scene(root, 750, 550);
			primaryStage.setScene(sce);
			primaryStage.show();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@FXML
	void buttonSendClick(ActionEvent event) {

		if (null == op.serialPort || (!op.serialPort.isOpened())) {

			Alert.info("Port is not open correctly!");

		} else
			try {

				if (sendArea.getText().length() <= 12 && sendArea.getText().contains("#BAUDRATE")) {

					op.serialPort.writeBytes(sendArea.getText().getBytes());

					Alert.info("Baudrate set correctly. Now you can set CAN frame.");
					fieldCanID.setDisable(false);
				}

				else if (sendArea.getText().length() >= 14 && sendArea.getText().contains("#SM")) {

				} else {

					if (sendArea.getText().contains("#SM ")) {
						Alert.info("CAN frame may not set correctly!");
					}
				}

				if (sendArea.getText().isEmpty()) {

					Alert.info("You must set baudrate!");
				}

			}

			catch (Exception e) {

				Alert.info("Port is open correctly!");
			}

	}

	@FXML
	void lengthOnAction(ActionEvent event) {

		if (sendArea.getText().length() == 11) {

			if (comboBoxLength.getValue() == "1") {

				sendArea.setText(sendArea.getText() + comboBoxLength.getValue() + " ");

				fieldByte1.setDisable(false);
				fieldByte2.setDisable(true);
				fieldByte3.setDisable(true);
				fieldByte4.setDisable(true);
				fieldByte5.setDisable(true);
				fieldByte6.setDisable(true);
				fieldByte7.setDisable(true);
				fieldByte8.setDisable(true);

			}
			if (comboBoxLength.getValue() == "2") {

				sendArea.setText(sendArea.getText() + comboBoxLength.getValue() + " ");

				fieldByte1.setDisable(false);
				fieldByte2.setDisable(false);
				fieldByte3.setDisable(true);
				fieldByte4.setDisable(true);
				fieldByte5.setDisable(true);
				fieldByte6.setDisable(true);
				fieldByte7.setDisable(true);
				fieldByte8.setDisable(true);

			}

			if (comboBoxLength.getValue() == "3")

			{
				sendArea.setText(sendArea.getText() + comboBoxLength.getValue() + " ");

				fieldByte1.setDisable(false);
				fieldByte2.setDisable(false);
				fieldByte3.setDisable(false);
				fieldByte4.setDisable(true);
				fieldByte5.setDisable(true);
				fieldByte6.setDisable(true);
				fieldByte7.setDisable(true);
				fieldByte8.setDisable(true);

			}
			if (comboBoxLength.getValue() == "4") {

				sendArea.setText(sendArea.getText() + comboBoxLength.getValue() + " ");

				fieldByte1.setDisable(false);
				fieldByte2.setDisable(false);
				fieldByte3.setDisable(false);
				fieldByte4.setDisable(false);
				fieldByte5.setDisable(true);
				fieldByte6.setDisable(true);
				fieldByte7.setDisable(true);
				fieldByte8.setDisable(true);

			}
			if (comboBoxLength.getValue() == "5") {
				sendArea.setText(sendArea.getText() + comboBoxLength.getValue() + " ");

				fieldByte1.setDisable(false);
				fieldByte2.setDisable(false);
				fieldByte3.setDisable(false);
				fieldByte4.setDisable(false);
				fieldByte5.setDisable(false);
				fieldByte6.setDisable(true);
				fieldByte7.setDisable(true);
				fieldByte8.setDisable(true);

			}
			if (comboBoxLength.getValue() == "6") {

				sendArea.setText(sendArea.getText() + comboBoxLength.getValue() + " ");

				fieldByte1.setDisable(false);
				fieldByte2.setDisable(false);
				fieldByte3.setDisable(false);
				fieldByte4.setDisable(false);
				fieldByte5.setDisable(false);
				fieldByte6.setDisable(false);
				fieldByte7.setDisable(true);
				fieldByte8.setDisable(true);
			}
			if (comboBoxLength.getValue() == "7") {
				sendArea.setText(sendArea.getText() + comboBoxLength.getValue() + " ");

				fieldByte1.setDisable(false);
				fieldByte2.setDisable(false);
				fieldByte3.setDisable(false);
				fieldByte4.setDisable(false);
				fieldByte5.setDisable(false);
				fieldByte6.setDisable(false);
				fieldByte7.setDisable(false);
				fieldByte8.setDisable(true);
			}
			if (comboBoxLength.getValue() == "8") {

				sendArea.setText(sendArea.getText() + comboBoxLength.getValue() + " ");

				fieldByte1.setDisable(false);
				fieldByte2.setDisable(false);
				fieldByte3.setDisable(false);
				fieldByte4.setDisable(false);
				fieldByte5.setDisable(false);
				fieldByte6.setDisable(false);
				fieldByte7.setDisable(false);
				fieldByte8.setDisable(false);

			}

		} else {

			sendArea.setText(sendArea.getText().substring(0, 10) + " ");

			if (comboBoxLength.getValue() == "1") {

				sendArea.setText(sendArea.getText() + comboBoxLength.getValue() + " ");

				fieldByte1.setDisable(false);
				fieldByte2.setDisable(true);
				fieldByte3.setDisable(true);
				fieldByte4.setDisable(true);
				fieldByte5.setDisable(true);
				fieldByte6.setDisable(true);
				fieldByte7.setDisable(true);
				fieldByte8.setDisable(true);

			}

			if (comboBoxLength.getValue() == "2") {

				sendArea.setText(sendArea.getText() + comboBoxLength.getValue() + " ");

				fieldByte1.setDisable(false);
				fieldByte2.setDisable(false);
				fieldByte3.setDisable(true);
				fieldByte4.setDisable(true);
				fieldByte5.setDisable(true);
				fieldByte6.setDisable(true);
				fieldByte7.setDisable(true);
				fieldByte8.setDisable(true);

			}

			if (comboBoxLength.getValue() == "3")

			{
				sendArea.setText(sendArea.getText() + comboBoxLength.getValue() + " ");

				fieldByte1.setDisable(false);
				fieldByte2.setDisable(false);
				fieldByte3.setDisable(false);
				fieldByte4.setDisable(true);
				fieldByte5.setDisable(true);
				fieldByte6.setDisable(true);
				fieldByte7.setDisable(true);
				fieldByte8.setDisable(true);

			}
			if (comboBoxLength.getValue() == "4") {

				sendArea.setText(sendArea.getText() + comboBoxLength.getValue() + " ");

				fieldByte1.setDisable(false);
				fieldByte2.setDisable(false);
				fieldByte3.setDisable(false);
				fieldByte4.setDisable(false);
				fieldByte5.setDisable(true);
				fieldByte6.setDisable(true);
				fieldByte7.setDisable(true);
				fieldByte8.setDisable(true);
			}
			if (comboBoxLength.getValue() == "5") {
				sendArea.setText(sendArea.getText() + comboBoxLength.getValue() + " ");

				fieldByte1.setDisable(false);
				fieldByte2.setDisable(false);
				fieldByte3.setDisable(false);
				fieldByte4.setDisable(false);
				fieldByte5.setDisable(false);
				fieldByte6.setDisable(true);
				fieldByte7.setDisable(true);
				fieldByte8.setDisable(true);

			}
			if (comboBoxLength.getValue() == "6") {

				sendArea.setText(sendArea.getText() + comboBoxLength.getValue() + " ");

				fieldByte1.setDisable(false);
				fieldByte2.setDisable(false);
				fieldByte3.setDisable(false);
				fieldByte4.setDisable(false);
				fieldByte5.setDisable(false);
				fieldByte6.setDisable(false);
				fieldByte7.setDisable(true);
				fieldByte8.setDisable(true);

			}
			if (comboBoxLength.getValue() == "7") {
				sendArea.setText(sendArea.getText() + comboBoxLength.getValue() + " ");

				fieldByte1.setDisable(false);
				fieldByte2.setDisable(false);
				fieldByte3.setDisable(false);
				fieldByte4.setDisable(false);
				fieldByte5.setDisable(false);
				fieldByte6.setDisable(false);
				fieldByte7.setDisable(false);
				fieldByte8.setDisable(true);

			}
			if (comboBoxLength.getValue() == "8") {

				sendArea.setText(sendArea.getText() + comboBoxLength.getValue() + " ");

				fieldByte1.setDisable(false);
				fieldByte2.setDisable(false);
				fieldByte3.setDisable(false);
				fieldByte4.setDisable(false);
				fieldByte5.setDisable(false);
				fieldByte6.setDisable(false);
				fieldByte7.setDisable(false);
				fieldByte8.setDisable(false);

			}

		}

		fieldByte1.setText("");
		fieldByte2.setText("");
		fieldByte3.setText("");
		fieldByte4.setText("");
		fieldByte5.setText("");
		fieldByte6.setText("");
		fieldByte7.setText("");
		fieldByte8.setText("");

	}

	@FXML
	void BaudRateOnAction(ActionEvent event) throws SerialPortException {

		if (comboBoxBaudRate.getValue() == "CAN_500") {

			sendArea.clear();

			sendArea.setText("#BAUDRATE 13");

		}

		else if (comboBoxBaudRate.getValue() == "CAN_5") {

			sendArea.clear();

			sendArea.setText("#BAUDRATE 2");

		}

		else if (comboBoxBaudRate.getValue() == "CAN_10") {

			sendArea.clear();

			sendArea.setText("#BAUDRATE 3");

		}

		else if (comboBoxBaudRate.getValue() == "CAN_20") {

			sendArea.clear();

			sendArea.setText("#BAUDRATE 4");

		}

		else if (comboBoxBaudRate.getValue() == "CAN_33") {

			sendArea.clear();

			sendArea.setText("#BAUDRATE 5");

		}

		else if (comboBoxBaudRate.getValue() == "CAN_40") {

			sendArea.clear();

			sendArea.setText("#BAUDRATE 6");

		}

		else if (comboBoxBaudRate.getValue() == "CAN_50") {

			sendArea.clear();

			sendArea.setText("#BAUDRATE 7");

		}

		else if (comboBoxBaudRate.getValue() == "CAN_50") {

			sendArea.clear();

			sendArea.setText("#BAUDRATE 7");

		}

		else if (comboBoxBaudRate.getValue() == "CAN_50") {

			sendArea.clear();

			sendArea.setText("#BAUDRATE 7");

		}

		else if (comboBoxBaudRate.getValue() == "CAN_50") {

			sendArea.clear();

			sendArea.setText("#BAUDRATE 7");

		}

		else if (comboBoxBaudRate.getValue() == "CAN_80") {

			sendArea.clear();

			sendArea.setText("#BAUDRATE 8");

		}

		else if (comboBoxBaudRate.getValue() == "CAN_100") {

			sendArea.clear();

			sendArea.setText("#BAUDRATE 9");

		}

		else if (comboBoxBaudRate.getValue() == "CAN_125") {

			sendArea.clear();

			sendArea.setText("#BAUDRATE 10");

		}

		else if (comboBoxBaudRate.getValue() == "CAN_200") {

			sendArea.clear();

			sendArea.setText("#BAUDRATE 11");

		}

		else if (comboBoxBaudRate.getValue() == "CAN_250") {

			sendArea.clear();

			sendArea.setText("#BAUDRATE 12");

		}

		else if (comboBoxBaudRate.getValue() == "CAN_1000") {

			sendArea.clear();

			sendArea.setText("#BAUDRATE 14");

		}

	}

	@FXML
	void canidOnAction(ActionEvent event) {

		if (fieldCanID.getLength() == 4) {

			sendArea.setText("SM " + fieldCanID.getText());

		} else {

			Alert.info("Id must be 4 characters long!");

		}

	}

	@FXML
	void onKeyCanID(KeyEvent event) {

		sendArea.setText(" ");

		if (event.getCode() == KeyCode.ENTER) {

			if (fieldCanID.getText().length() == 4) {

				System.out.println("OK");

				String dane = fieldCanID.getText();

				sendArea.setText("#SM " + dane);

				checkBoxSM.setDisable(false);
				checkBoxEM.setDisable(false);

			} else {

				Alert.info("Id must be 4 characters long!");

			}

		}

	}

	@FXML
	void smOnAction(ActionEvent event) {

		if (checkBoxSM.isSelected()) {
			if (sendArea.getText().length() == 8) {

				sendArea.setText(sendArea.getText() + " " + checkBoxSM.getText() + " ");
				comboBoxLength.setDisable(false);

			}
		}

		else if (!(checkBoxSM.isSelected())) {

			sendArea.setText(sendArea.getText().substring(0, 8));

		}

	}

	@FXML
	void emOnAction(ActionEvent event) {

		if (checkBoxEM.isSelected()) {
			if (sendArea.getText().length() == 8) {

				sendArea.setText(sendArea.getText() + " " + checkBoxEM.getText() + " ");
				comboBoxLength.setDisable(false);

			}
		}

		else if (!(checkBoxEM.isSelected())) {

			sendArea.setText(sendArea.getText().substring(0, 8));

		}

	}

	@FXML
	void byte2OnKey(KeyEvent event) {
		sendArea.setText(sendArea.getText().substring(0, 16));

		if (event.getCode() == KeyCode.ENTER) {
			if (sendArea.getText().length() == 16 && fieldByte2.getText().length() == 2) {

				sendArea.setText(sendArea.getText() + fieldByte2.getText() + " ");

			} else {

				Alert.info("Not correct length");

			}
		}
	}

	@FXML
	void byte3OnKey(KeyEvent event) {
		sendArea.setText(sendArea.getText().substring(0, 19));

		if (event.getCode() == KeyCode.ENTER) {
			if (sendArea.getText().length() == 19 && fieldByte3.getText().length() == 2) {

				sendArea.setText(sendArea.getText() + fieldByte3.getText() + " ");

			} else {

				Alert.info("Not correct length");

			}
		}

	}

	@FXML
	void byte4OnKey(KeyEvent event) {

		sendArea.setText(sendArea.getText().substring(0, 22));
		if (event.getCode() == KeyCode.ENTER) {
			if (sendArea.getText().length() == 22 && fieldByte4.getText().length() == 2) {

				sendArea.setText(sendArea.getText() + fieldByte4.getText() + " ");

			} else {

				Alert.info("Not correct length");

			}
		}

	}

	@FXML
	void byte5OnKey(KeyEvent event) {
		sendArea.setText(sendArea.getText().substring(0, 25));
		if (event.getCode() == KeyCode.ENTER) {
			if (sendArea.getText().length() == 25 && fieldByte5.getText().length() == 2) {

				sendArea.setText(sendArea.getText() + fieldByte5.getText() + " ");

			} else {

				Alert.info("Not correct length");

			}
		}

	}

	@FXML
	void byte6OnKey(KeyEvent event) {

		sendArea.setText(sendArea.getText().substring(0, 28));
		if (event.getCode() == KeyCode.ENTER) {
			if (sendArea.getText().length() == 28 && fieldByte6.getText().length() == 2) {

				sendArea.setText(sendArea.getText() + fieldByte6.getText() + " ");

			} else {

				Alert.info("Not correct length");

			}
		}

	}

	@FXML
	void byte7OnKey(KeyEvent event) {

		sendArea.setText(sendArea.getText().substring(0, 31));
		if (event.getCode() == KeyCode.ENTER) {
			if (sendArea.getText().length() == 31 && fieldByte7.getText().length() == 2) {

				sendArea.setText(sendArea.getText() + fieldByte7.getText() + " ");

			} else {

				Alert.info("Not correct length");

			}
		}

	}

	@FXML
	void byte8OnKey(KeyEvent event) {

		sendArea.setText(sendArea.getText().substring(0, 34));

		if (event.getCode() == KeyCode.ENTER) {
			if (sendArea.getText().length() == 34 && fieldByte8.getText().length() == 2) {

				sendArea.setText(sendArea.getText() + fieldByte8.getText());

			}

			else {

				Alert.info("Not correct length");

			}
		}
	}

	@FXML
	void byte1OnKey(KeyEvent event) {

		sendArea.setText(sendArea.getText().substring(0, 13));

		if (event.getCode() == KeyCode.ENTER) {

			if (sendArea.getText().length() == 13 && fieldByte1.getText().length() == 2) {

				sendArea.setText(sendArea.getText() + fieldByte1.getText() + " ");

			} else {

				Alert.info("Not correct length");

			}
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		String[] length = new String[] { "1", "2", "3", "4", "5", "6", "7", "8" };
		for (String s : length) {
			comboBoxLength.getItems().add(s);
		}
		comboBoxLength.setValue("8");

		String[] baudRate = new String[] { "CAN_5", "CAN_10", "CAN_20", "CAN_33", "CAN_40", "CAN_50", "CAN_80",
				"CAN_100", "CAN_125", "CAN_200", "CAN_250", "CAN_500", "CAN_1000" };

		for (String s : baudRate) {
			comboBoxBaudRate.getItems().add(s);
		}
		comboBoxBaudRate.setValue("CAN_500");

		sendArea.setDisable(true);

		fieldCanID.setDisable(true);

		comboBoxLength.setDisable(true);
		checkBoxSM.setDisable(true);
		checkBoxEM.setDisable(true);

		fieldByte1.setDisable(true);
		fieldByte2.setDisable(true);
		fieldByte3.setDisable(true);
		fieldByte4.setDisable(true);
		fieldByte5.setDisable(true);
		fieldByte6.setDisable(true);
		fieldByte7.setDisable(true);
		fieldByte8.setDisable(true);

	}

}
