package pl.stolarczyk.can.mode;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Alert {

	public static void info(String wiad) {

		Stage view = new Stage();
		view.setTitle("Info");
		view.setMinWidth(250);
		view.setMaxHeight(150);

		Label label = new Label();
		label.setText(wiad);
		Button button = new Button("Confirm");
		button.setOnAction(e -> view.close());

		VBox grup = new VBox(2);

		grup.getChildren().addAll(label, button);
		grup.setAlignment(Pos.CENTER);

		Scene scene = new Scene(grup);
		view.setScene(scene);
		view.showAndWait();
	}

}
