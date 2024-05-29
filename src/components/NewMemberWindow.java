package components;

import company.Manager;
import company.Member;
import javafx.scene.control.Alert.AlertType;

public class NewMemberWindow extends Window {
    private Manager manager;
    private MembersTab membersTab;
    private static TasksTab tasksTab;

    NewMemberWindow(Manager manager, MembersTab membersTab) {
        this.manager = manager;
        this.membersTab = membersTab;

        setTitle("Add a new member");
        addTextField("Surname");
        addTextField("Name");
        addSubmitButton();
    }

    public static void setTasksTab(TasksTab tasksTab) {
        NewMemberWindow.tasksTab = tasksTab;
    }

    @Override
    public void onSubmit(String[] data) {
        try {
            Member newMember = new Member(data[0], data[1]);
            manager.addMember(newMember);
            membersTab.refreshTable();
            tasksTab.refreshMenu();
            close();
            clearTextFields();
            showAlert(AlertType.INFORMATION, "Success", "New member added successfully.");
        } catch (IllegalArgumentException e) {
            showAlert(AlertType.ERROR, "Error", e.getMessage());
        }
    }
}
