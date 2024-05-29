import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import company.Manager;
import components.MembersTab;
import components.TasksTab;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        Manager manager = new Manager();
        MembersTab membersTab = new MembersTab(manager);
        TasksTab tasksTab = new TasksTab(manager);

        tabPane.getTabs().addAll(membersTab, tasksTab);

        StackPane root = new StackPane();
        root.getChildren().add(tabPane);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.setResizable(true);
        primaryStage.setTitle("tManager");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
