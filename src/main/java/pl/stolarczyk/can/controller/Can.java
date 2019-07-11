package pl.stolarczyk.can.controller;

import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import jssc.SerialPort;
import jssc.SerialPortEventListener;
import jssc.SerialPortList;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

public class Can implements Initializable {

	@FXML
	private Tab tabOptions;

	@FXML
	private OptionsController tab2Controller;

	private static SerialPort serialPort = null;

	@FXML
	void buttonCancelClick(MouseEvent event) {
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		tabOptions.setOnSelectionChanged(new EventHandler<Event>() {
			@Override
			public void handle(Event t) {
				if (tabOptions.isSelected()) {

				}
			}
		});
		;

		// findPorts();
		/*
		 * Options.setOnSelectionChanged(new EventHandler<Event>(){
		 * 
		 * @Override public void handle(Event t) { if (Options.isSelected()) {
		 * 
		 * } } });
		 */

		// defaultClick.addEventHandler(ActionEvent.ACTION, handler);

		// comboBoxData.setItems(listData);
		// comboBoxBaudRate.setItems(listBaud);

		/*
		 * 
		 * tabOptions.setOnSelectionChanged(new EventHandler<Event>() {
		 * 
		 * @Override public void handle(Event t) { if (tabOptions.isSelected()) {
		 * 
		 * String[] ports = SerialPortList.getPortNames(); if(ports.length!=0) { for
		 * (String s : ports) { tab2Controller.getComboBoxBaudRate().getItems().add(s);
		 * } tab2Controller.getComboBoxBaudRate().setValue(ports[0]); }
		 * 
		 * // tab2Controller.getComboBoxData().setItems("5");
		 * 
		 * // tab2Controller.getComboBoxBaudRate().getItems().clear(); //
		 * comboBoxParity.getItems().clear(); // comboBoxStop.getItems().clear();
		 * 
		 * // tab2Controller.getComboBoxBaudRate().setValue("9600");
		 * 
		 * // System.out.println("Dzia�a");
		 * 
		 * } } });;
		 * 
		 * 
		 * 
		 */
		/*
		 * 
		 * 
		 * 
		 * comboBoxPort.getItems().clear(); comboBoxParity.getItems().clear();
		 * comboBoxStop.getItems().clear();
		 * 
		 * 
		 * 
		 * 
		 * for (String s : SerialPortList.getPortNames())
		 * comboBoxPort.getItems().add(s);
		 * 
		 * String[] checks = new String[]{ "NONE","ODD","EVEN","MARK","SPACE" }; for
		 * (String s:checks) { comboBoxParity.getItems().add(s); }
		 * comboBoxParity.setValue("NONE");
		 * 
		 * 
		 * String[] stopbits = new String[]{ "1","2" };
		 * 
		 * for (String s:stopbits) { comboBoxStop.getItems().add(s); }
		 * comboBoxStop.setValue("1");
		 * 
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

		/*
		 * 
		 * public static void main(String[] args) { // TODO Auto-generated method stub
		 * 
		 * }
		 */

	}

}
