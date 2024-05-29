package company;

import javafx.collections.ObservableList;

public class Member {
    private String surname;
    private String name;

    public Member(String surname, String name) throws IllegalArgumentException {
        if(surname.isEmpty() || name.isEmpty())
            throw new IllegalArgumentException("All fields must be filled out.");

        this.surname = surname;
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getTaskCount(ObservableList<Task> tasks) throws IllegalArgumentException {
        if(tasks == null)
            throw new IllegalArgumentException("Task list is null");

        int taskCount = 0;

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getExecutor() == this)
                taskCount++;
        }

        return taskCount;
    }
}
