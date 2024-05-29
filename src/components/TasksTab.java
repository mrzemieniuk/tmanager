package components;

import java.util.Timer;
import java.util.TimerTask;
import company.*;
import javafx.scene.control.Alert.AlertType;

public class TasksTab extends GeneralTab {
    private Manager manager;
    
    public TasksTab(Manager manager) {
        super("Tasks");
        this.manager = manager;

        NewTaskWindow newTaskWindow = new NewTaskWindow(manager, this);
        NewMemberWindow.setTasksTab(this);

        createTable(new String[]{"Name", "Status", "Executor", "Time of executing"});
        addButton("Add new task", newTaskWindow);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateElapsedTime();
            }
        }, 0, 1000);
    }

    private void updateElapsedTime() {
        for (int i = 0; i < manager.getTasks().size(); i++) {
            Task task = manager.getTasks().get(i);
            if (task.getExecutor() != null) {
                long elapsedTimeSeconds = task.getElapsedTime();
                String elapsedTime = String.format("%02d:%02d:%02d", elapsedTimeSeconds / 3600, (elapsedTimeSeconds % 3600) / 60, (elapsedTimeSeconds % 60));
                String[] rowData = tableView.getItems().get(i);
                rowData[3] = elapsedTime;
            }
        }
        tableView.refresh();
    }

    public void refreshMenu() {
        contextMenu.getItems().clear();

        addContextMenuItem("Set as: to do", event -> setStatus(TaskStatus.TO_DO));
        addContextMenuItem("Set as: in progress", event -> setStatus(TaskStatus.IN_PROGRESS));
        addContextMenuItem("Set as: done", event -> setStatus(TaskStatus.DONE));

        for(int i = 0; i < manager.getMembers().size(); i++) {
            final int index = i;
            addContextMenuItem("Assign to: " + manager.getMember(index).getName() + " " + manager.getMember(index).getSurname(), event -> setExecutor(manager.getMember(index)));
        }
    }

    public void refreshTable() {
        tableView.getItems().clear();

        for(int i = 0; i < manager.getTasks().size(); i++) {
            String[] rowData = new String[4];

            rowData[0] = manager.getTasks().get(i).getName();
            if(manager.getTasks().get(i).getStatus() != null)
                rowData[1] = manager.getTasks().get(i).getStatus().getText();
            else
                rowData[1] = "";
            if(manager.getTasks().get(i).getExecutor() != null)
                rowData[2] = manager.getTasks().get(i).getExecutor().getSurname() + " " + manager.getTasks().get(i).getExecutor().getName();
            else
                rowData[2] = "";
            rowData[3] = "";

            tableView.getItems().add(rowData);
        }
        
        updateElapsedTime();
    }

    private void setStatus(TaskStatus status) {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        manager.getTask(selectedIndex).setStatus(status);

        refreshTable();
    }

    private void setExecutor(Member member) {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();

        try {
            manager.getTask(selectedIndex).setExecutor(member);
        } catch (IllegalArgumentException e) {
            showAlert(AlertType.ERROR, "Error", e.getMessage());
        }

        refreshTable();
    }
}
