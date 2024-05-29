package components;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class GeneralTab extends Tab {
    private VBox container = new VBox();
    protected TableView<String[]> tableView;
    protected ContextMenu contextMenu = new ContextMenu();

    public GeneralTab(String name) {
        super(name);
        setClosable(false);
        setContent(container);
    }

    public void createTable(String[] columnNames) {
        tableView = new TableView<>();

        for (int i = 0; i < columnNames.length; i++) {
            final int index = i;
            TableColumn<String[], String> column = new TableColumn<>(columnNames[i]);
            column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()[index]));
            tableView.getColumns().add(column);
        }

        tableView.setRowFactory(tv -> {
            TableRow<String[]> row = new TableRow<>();
            row.contextMenuProperty().bind(
                javafx.beans.binding.Bindings.when(row.emptyProperty())
                    .then((ContextMenu) null)
                    .otherwise(contextMenu)
            );
            return row;
        });
        
        container.getChildren().add(tableView);
    }

    public void addContextMenuItem(String itemName, javafx.event.EventHandler<javafx.event.ActionEvent> eventHandler) {
        MenuItem menuItem = new MenuItem(itemName);
        menuItem.setOnAction(eventHandler);
        contextMenu.getItems().add(menuItem);
    }

    public void addButton(String name, Window window) {
        Button button = new Button(name);
        button.setOnAction(e -> {
            window.prepare();
            window.show();
        });
        container.getChildren().add(button);
    }

    public void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
