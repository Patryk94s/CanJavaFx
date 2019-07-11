package pl.stolarczyk.can.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Predicate;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import jssc.SerialPortException;

public class CanReadController implements Initializable {

	@FXML
	private TableView<CanTable> table;

	@FXML
	private TableColumn<CanTable, String> id;
	@FXML
	private TableColumn<CanTable, String> ext;

	@FXML
	private TableColumn<CanTable, String> rtr;

	@FXML
	private TableColumn<CanTable, String> length;

	@FXML
	private TableColumn<CanTable, String> data;

	@FXML
	private TextField Id_filter;

	@FXML
	private Label recvCount;

	@FXML
	private CheckBox recvStopShow;

	@FXML
	private Button readCAN;

	public OptionsController op;

	public ObservableList<CanTable> list = FXCollections.observableArrayList();

	private Timeline timeline;

	private pl.stolarczyk.can.mode.Alert alert;

	@FXML
	void readCANOnAction(ActionEvent event) throws SerialPortException, ArrayIndexOutOfBoundsException {

		Alert al = new Alert(AlertType.INFORMATION);

		if (timeline != null) {
			timeline.stop();
		}

		timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				try {
					byte[] b = op.serialPort.readBytes();

					if (b != null) {

						String str = new String((b));

						String[] sensors = str.split(";");

						list.add(new CanTable(sensors[0], sensors[1], sensors[2], sensors[3], sensors[4]));

						System.out.println("ID " + sensors[0]);
						System.out.println("EXT " + sensors[1]);
						System.out.println("RTR" + sensors[2]);

						System.out.println("LENGTH " + sensors[3]);
						System.out.println("DATA " + sensors[4]);

						Platform.runLater(() -> {
							recvCount.setText(
									String.valueOf((Integer.parseInt(recvCount.getText()) + sensors[2].length())));

						});
					}

				}

				catch (Exception e) {

					al.setContentText("Selected port or baud rate are not correct! Application must be closed!");
					al.setOnHidden(evt -> Platform.exit());

					al.show();

				}

			}

		}));

		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.playFromStart();

		setTable();
		table.setItems(null);

		table.setItems(list);

	}

	@FXML
	void readCANOnActionSingle(ActionEvent event) {

		try {
			byte[] b = op.serialPort.readBytes();
			if (recvStopShow.isSelected()) {
				op.serialPort.readHexString();
				return;
			}

			if (b != null) {

				String str = new String((b));

				String[] sensors = str.split(";");

				list.add(new CanTable(sensors[0], sensors[1], sensors[2], sensors[3], sensors[4]));

				System.out.println("ID " + sensors[0]);
				System.out.println("EXT " + sensors[1]);
				System.out.println("RTR" + sensors[2]);

				System.out.println("LENGTH " + sensors[3]);
				System.out.println("DATA " + sensors[4]);

				Platform.runLater(() -> {
					recvCount.setText(String.valueOf((Integer.parseInt(recvCount.getText()) + sensors[2].length())));
				});

			}

		}

		catch (SerialPortException | ArrayIndexOutOfBoundsException e) {

			alert.info("Selected port or baud rate are not correct!");

		}

		setTable();
		table.setItems(null);

		table.setItems(list);

	}

	@FXML
	void ResetStatCAN(ActionEvent event) {
		recvCount.setText("0");
	}

	public void setTable() {

		id.setCellValueFactory(new PropertyValueFactory<CanTable, String>("id"));
		ext.setCellValueFactory(new PropertyValueFactory<CanTable, String>("ext"));
		rtr.setCellValueFactory(new PropertyValueFactory<CanTable, String>("rtr"));
		length.setCellValueFactory(new PropertyValueFactory<CanTable, String>("length"));
		data.setCellValueFactory(new PropertyValueFactory<CanTable, String>("data"));

	}

	@FXML

	void StopShow(ActionEvent event) throws SerialPortException {

		try {
			if (op.serialPort != null && op.serialPort.isOpened())
				if (recvStopShow.isSelected()) {
					timeline.pause();
				}

		} catch (Exception e) {

			alert.info("No data to read!");
		}

	}

	@FXML
	void ResetStatButton(ActionEvent event) {
		recvCount.setText("0");
	}

	@FXML
	void Id_filter_On_Action(KeyEvent event) {

		FilteredList<CanTable> filterData = new FilteredList<>(list, p -> true);

		Id_filter.textProperty().addListener((obsevable, oldvalue, newvalue) -> {

			filterData.setPredicate((Predicate<? super CanTable>) user -> {

				if (newvalue == null || newvalue.isEmpty()) {

					return true;

				}
				String typeText = newvalue.toLowerCase();

				if (user.getId().contains(newvalue)) {

					return true;
				}

				return false;

			});

		});
		SortedList<CanTable> sortedData = new SortedList<>(filterData);

		sortedData.comparatorProperty().bind(table.comparatorProperty());
		table.setItems(sortedData);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
