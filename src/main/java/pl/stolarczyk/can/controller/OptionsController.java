package pl.stolarczyk.can.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortException;
import jssc.SerialPortList;
import pl.stolarczyk.can.mode.Alert;

public class OptionsController implements Initializable {

	private MainController main;

	@FXML
	public ComboBox<String> comboBoxPort;

	public ComboBox<String> getComboBoxPort() {
		return comboBoxPort;
	}

	public void setComboBoxPort(ComboBox<String> comboBoxPort) {
		this.comboBoxPort = comboBoxPort;
	}

	public ComboBox<String> getComboBoxBaudRate() {
		return comboBoxBaudRate;
	}

	public void setComboBoxBaudRate(ComboBox<String> comboBoxBaudRate) {
		this.comboBoxBaudRate = comboBoxBaudRate;
	}

	public ComboBox<String> getComboBoxData() {
		return comboBoxData;
	}

	public void setComboBoxData(ComboBox<String> comboBoxData) {
		this.comboBoxData = comboBoxData;
	}

	public ComboBox<String> getComboBoxParity() {
		return comboBoxParity;
	}

	public void setComboBoxParity(ComboBox<String> comboBoxParity) {
		this.comboBoxParity = comboBoxParity;
	}

	public ComboBox<String> getComboBoxStop() {
		return comboBoxStop;
	}

	public void setComboBoxStop(ComboBox<String> comboBoxStop) {
		this.comboBoxStop = comboBoxStop;
	}

	public Button getButtonRefresh() {
		return buttonRefresh;
	}

	public void setButtonRefresh(Button buttonRefresh) {
		this.buttonRefresh = buttonRefresh;
	}

	public Button getButtonCancel() {
		return buttonCancel;
	}

	public void setButtonCancel(Button buttonCancel) {
		this.buttonCancel = buttonCancel;
	}

	public Button getButtonDefault() {
		return buttonDefault;
	}

	public void setButtonDefault(Button buttonDefault) {
		this.buttonDefault = buttonDefault;
	}

	public Button getButtonConnect() {
		return buttonConnect;
	}

	public void setButtonConnect(Button buttonConnect) {
		this.buttonConnect = buttonConnect;
	}

	public Button getButtonStop() {
		return buttonStop;
	}

	public void setButtonStop(Button buttonStop) {
		this.buttonStop = buttonStop;
	}

	@FXML
	private ComboBox<String> comboBoxBaudRate;

	@FXML
	private ComboBox<String> comboBoxData;

	@FXML
	private ComboBox<String> comboBoxParity;

	@FXML
	private ComboBox<String> comboBoxStop;

	@FXML
	private Button buttonRefresh;

	@FXML
	private Button buttonCancel;

	@FXML
	private Button buttonDefault;

	@FXML
	private Button buttonConnect;

	@FXML
	private Button buttonStop;

	@FXML
	private Button buttonClear;

	public static SerialPort serialPort = null;
	private pl.stolarczyk.can.mode.Alert alert;

	@FXML
	void buttonStopClick(ActionEvent event) {

		if (serialPort != null && serialPort.isOpened())
			try {
				serialPort.closePort();

				Alert.info("Port closed!");
				comboBoxPort.setDisable(false);
				comboBoxBaudRate.setDisable(false);
				comboBoxData.setDisable(false);
				comboBoxParity.setDisable(false);
				comboBoxStop.setDisable(false);
				return;
			} catch (SerialPortException e) {
				alert.info("Connection failed!");

			}

	}

	@FXML
	void buttonConnectClick(ActionEvent event) {

		serialPort = new SerialPort((String) comboBoxPort.getValue());
		try {
			serialPort.openPort();
			alert.info("Port open!");
			serialPort.setParams(new Integer((String) comboBoxBaudRate.getValue()),
					new Integer((String) comboBoxData.getValue()), new Integer((String) comboBoxStop.getValue()),
					comboBoxBaudRate.getValue().equals("NONE") ? 0
							: comboBoxBaudRate.getValue().equals("ODD") ? 1
									: comboBoxBaudRate.getValue().equals("EVEN") ? 2
											: comboBoxBaudRate.getValue().equals("SPACE") ? 3 : 0);

			serialPort.purgePort(SerialPort.PURGE_RXCLEAR);
			serialPort.purgePort(SerialPort.PURGE_TXCLEAR);
			serialPort.setEventsMask(SerialPort.MASK_RXCHAR);

			comboBoxPort.setDisable(true);
			comboBoxBaudRate.setDisable(true);
			comboBoxParity.setDisable(true);
			comboBoxData.setDisable(true);
			comboBoxStop.setDisable(true);

		} catch (SerialPortException e) {

			alert.info("Connection failed!");

		}

	}

	@FXML
	void buttonCancelOnAction(ActionEvent event) {

		comboBoxPort.setValue(" ");
		comboBoxBaudRate.setValue("9600");
		comboBoxData.setValue("8");
		comboBoxParity.setValue("NONE");
		comboBoxStop.setValue("1");

	}

	@FXML
	void buttonDefaultClick(ActionEvent event) {

		comboBoxPort.setValue("COM3");
		comboBoxBaudRate.setValue("115200");
		comboBoxData.setValue("8");
		comboBoxParity.setValue("NONE");
		comboBoxStop.setValue("1");
	}

	@FXML
	void buttonClearOnAction(ActionEvent event) {

		comboBoxPort.setValue(" ");
		comboBoxBaudRate.setValue(" ");
		comboBoxData.setValue(" ");
		comboBoxParity.setValue(" ");
		comboBoxStop.setValue(" ");

	}

	void findPorts() {

		comboBoxPort.getItems().clear();
		comboBoxParity.getItems().clear();
		comboBoxStop.getItems().clear();

		for (String s : SerialPortList.getPortNames())
			comboBoxPort.getItems().add(s);

		String[] checks = new String[] { "NONE", "ODD", "EVEN", "MARK", "SPACE" };
		for (String s : checks) {
			comboBoxParity.getItems().add(s);
		}
		comboBoxParity.setValue("NONE");

		String[] stopbits = new String[] { "1", "2" };

		for (String s : stopbits) {
			comboBoxStop.getItems().add(s);
		}
		comboBoxStop.setValue("1");

	}

	public ObservableList<String> getListData() {
		return listData;
	}

	public void setListData(ObservableList<String> listData) {
		this.listData = listData;
	}

	public ObservableList<String> getListBaud() {
		return listBaud;
	}

	public void setListBaud(ObservableList<String> listBaud) {
		this.listBaud = listBaud;
	}

	ObservableList<String> listData = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9");
	ObservableList<String> listBaud = FXCollections.observableArrayList("2400", "4800", "9600", "14400", "19200",
			"28800", "38400", "57600", "76800", "115200", "230400");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		comboBoxData.setItems(listData);
		comboBoxBaudRate.setItems(listBaud);

		comboBoxData.setValue("8");
		comboBoxBaudRate.setValue("9600");

	}

	public void init(MainController mainController) {

		main = mainController;

	}

}
