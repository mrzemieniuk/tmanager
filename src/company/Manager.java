package company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Manager {
    private ObservableList<Member> members;
    private ObservableList<Task> tasks;

    public Manager() {
        members = FXCollections.observableArrayList();
        tasks = FXCollections.observableArrayList();
    }

    public void addMember(Member member) throws IllegalArgumentException {
        if (member == null)
            throw new IllegalArgumentException("Member cannot be null");
        if (members.contains(member))
            throw new IllegalArgumentException("Member already exists");

        members.add(member);
    }

    public void addTask(Task task) throws IllegalArgumentException {
        if (task == null)
            throw new IllegalArgumentException("Task cannot be null");
        if (tasks.contains(task))
            throw new IllegalArgumentException("Task already exists");

        tasks.add(task);
    }

    public ObservableList<Member> getMembers() {
        return members;
    }

    public ObservableList<Task> getTasks() {
        return tasks;
    }

    public Member getMember(int selectedIndex) throws IndexOutOfBoundsException {
        if (selectedIndex < 0 || selectedIndex >= members.size())
            throw new IndexOutOfBoundsException("Invalid member index");

        return members.get(selectedIndex);
    }

    public Task getTask(int selectedIndex) throws IndexOutOfBoundsException {
        if (selectedIndex < 0 || selectedIndex >= tasks.size())
            throw new IndexOutOfBoundsException("Invalid task index");

        return tasks.get(selectedIndex);
    }
}
