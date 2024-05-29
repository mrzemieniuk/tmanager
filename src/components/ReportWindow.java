package components;

import company.Manager;
import company.Member;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class ReportWindow extends Window {
    private Manager manager;

    public ReportWindow(Manager manager) {
        this.manager = manager;

        setTitle("Report");
    }

    public void prepare() {
        Label reportLabel = new Label(generateReport());

        getRoot().getChildren().clear();
        getRoot().getChildren().add(reportLabel);
    }

    public String generateReport() {
        StringBuilder string = new StringBuilder();

        for (Member member : manager.getMembers()) {
            try {
                string.append(member.getSurname()).append(" ").append(member.getName()).append(" - task count: ").append(member.getTaskCount(manager.getTasks())).append("\n");
            } catch (IllegalArgumentException e) {
                showAlert(AlertType.ERROR, "Error", e.getMessage());
            }
        }

        return string.toString();
    }
}
