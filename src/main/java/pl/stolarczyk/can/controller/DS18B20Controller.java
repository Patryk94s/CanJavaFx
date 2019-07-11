package pl.stolarczyk.can.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import eu.hansolo.medusa.Gauge;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import jssc.SerialPortException;
import pl.stolarczyk.can.mode.Alert;

public class DS18B20Controller implements Initializable {

	@FXML
	private Gauge gauge;

	public OptionsController op;

	@FXML
	private TextField tempValue;

	@FXML
	private TextField idValue;

	@FXML
	private Button buttonStart;

	@FXML
	private Button buttonStop;

	private pl.stolarczyk.can.mode.Alert alert;

	private Timeline timeline;

	void odbior() {

		byte[] temperatureHumidityArduino;
		try {
			temperatureHumidityArduino = op.serialPort.readBytes();

			if (temperatureHumidityArduino != null) {

				String str = new String((temperatureHumidityArduino));

				String[] sensors = str.split(";");

				double temperature = Double.parseDouble(sensors[1]);
				double id = Double.parseDouble(sensors[0]);

				gauge.setValue(temperature);

				tempValue.setText(String.valueOf(temperature) + " °C");

				idValue.setText(String.valueOf(id));
				System.out.println("ID: " + sensors[0]);
				System.out.println("Temp: " + sensors[1]);

			}
		} catch (SerialPortException e) {

			e.printStackTrace();
		}
	}

	@FXML
	void StartTempOnAction(ActionEvent event) throws SerialPortException {

		if (!op.serialPort.isOpened()) {

			Alert.info("Port is must be open correctly!");
		}

		if (op.serialPort != null && op.serialPort.isOpened()) {

			if (timeline != null) {
				timeline.stop();
			}

			timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
				byte[] temperatureHumidityArduino;

				@Override
				public void handle(ActionEvent event) {

					try {
						temperatureHumidityArduino = op.serialPort.readBytes();

						if (temperatureHumidityArduino != null) {

							String str = new String((temperatureHumidityArduino));

							String[] sensors = str.split(";");

							double temperature = Double.parseDouble(sensors[1]);
							double id = Double.parseDouble(sensors[0]);

							gauge.setValue(temperature);
							tempValue.setText(String.valueOf(temperature) + " °C");

							idValue.setText(String.valueOf(id));

							System.out.println("ID: " + sensors[0]);
							System.out.println("Temp: " + sensors[1]);

						}

					} catch (SerialPortException e) {

						alert.info("Port closed! Please open port!");
					} catch (NumberFormatException e) {
						alert.info("Port closed! Please open port!");
					} catch (IllegalStateException e) {

						alert.info("Port closed! Please open port!");

					}

				}

			}));

			timeline.setCycleCount(Timeline.INDEFINITE);
			timeline.playFromStart();

		}

	}

	@FXML
	void StopTempOnAction(ActionEvent event) throws InterruptedException, SerialPortException {

		try {
			if (op.serialPort != null && op.serialPort.isOpened()) {

				alert.info("Timer closed!");
				timeline.pause();
				;
				gauge.setValue(0);

				tempValue.setText(" ");
				idValue.setText(" ");
			} else {
				timeline.stop();
				op.serialPort.closePort();

			}
		} catch (RuntimeException e) {

			Alert.info("Port is must be open correctly!");
		}

		if (!op.serialPort.isOpened()) {

			Alert.info("Port is must be open correctly!");
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 
		   
		 }
	
	
    
	}
  
	

