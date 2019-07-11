package pl.stolarczyk.can.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import jssc.SerialPortList;

public class MainController implements Initializable {

	@FXML
	private OptionsController tab3Controller;

	@FXML
	private Tab tabOptions;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		System.out.println("Aplikacja dziala");
		tab3Controller.init(this);

		tabOptions.setOnSelectionChanged(new EventHandler<Event>() {
			@Override
			public void handle(Event t) {
				if (tabOptions.isSelected()) {

					tab3Controller.getComboBoxPort().getItems().clear();
					tab3Controller.getComboBoxParity().getItems().clear();
					tab3Controller.getComboBoxStop().getItems().clear();

					String[] ports = SerialPortList.getPortNames();
					if (ports.length != 0) {
						for (String s : ports) {
							tab3Controller.getComboBoxPort().getItems().add(s);
						}
						tab3Controller.getComboBoxPort().setValue(ports[0]);
					}

					String[] checks = new String[] { "NONE", "ODD", "EVEN", "MARK", "SPACE" };
					for (String s : checks) {
						tab3Controller.getComboBoxParity().getItems().add(s);
					}
					tab3Controller.getComboBoxParity().setValue("NONE");

					String[] stopbits = new String[] { "1", "2" };

					for (String s : stopbits) {
						tab3Controller.getComboBoxStop().getItems().add(s);
					}
					tab3Controller.getComboBoxStop().setValue("1");

				}
			}
		});
		;

	}

}
