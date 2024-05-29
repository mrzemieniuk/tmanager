package components;

import company.Manager;
import company.Task;
import javafx.scene.control.Alert.AlertType;

public class NewTaskWindow extends Window {
    private Manager manager;
    private TasksTab tasksTab;

    public NewTaskWindow(Manager manager, TasksTab tasksTab) {
        this.manager = manager;
        this.tasksTab = tasksTab;

        setTitle("Add a new task");
        addTextField("Name");
        addSubmitButton();
    }

    public void onSubmit(String[] data) {
        try { 
            Task newTask = new Task(data[0], null, null, null, null);
            manager.addTask(newTask);
            tasksTab.refreshTable();
            close();
            clearTextFields();
            showAlert(AlertType.INFORMATION, "Success", "New task added successfully.");
        } catch (IllegalArgumentException e) {
            showAlert(AlertType.ERROR, "Error", e.getMessage());
        }
    }
}
