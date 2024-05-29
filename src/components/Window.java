package components;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import java.util.Arrays;

public class Window extends Stage {
    private TextField[] textFields;
    private VBox root;

    public Window() {
        root = new VBox();
        textFields = new TextField[0];
        setScene(new Scene(root, 200, 200));
    }

    public void addTextField(String name) {
        TextField newTextField = new TextField();
        TextField[] newTextFields = Arrays.copyOf(textFields, textFields.length + 1);
        newTextFields[textFields.length] = newTextField;
        textFields = newTextFields;

        Label labelField = new Label(name);

        root.getChildren().addAll(labelField, newTextField);
    }

    public void addSubmitButton() {
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> onSubmit(getTextFields()));
        root.getChildren().add(submitButton);
    }

    public String[] getTextFields() {
        String[] textFields = new String[this.textFields.length];

        for(int i = 0; i < this.textFields.length; i++) {
            textFields[i] = this.textFields[i].getText();
        }

        return textFields;
    }

    public void clearTextFields() {
        for (TextField textField : textFields) {
            textField.clear();
        }
    }

    public VBox getRoot() {
        return root;
    }

    public void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void prepare() {};
    public void onSubmit(String[] data) {};
}
