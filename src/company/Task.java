package company;

import java.time.Duration;
import java.time.LocalDateTime;

public class Task {
    private String name;
    private TaskStatus status;
    private Member executor;
    private LocalDateTime assignmentTime;
    private LocalDateTime finishedTime;

    public Task (String name, TaskStatus status, Member executor, LocalDateTime assignmentTime, LocalDateTime finishedTime) throws IllegalArgumentException {
        if(name.isEmpty())
            throw new IllegalArgumentException("Name field must be filled out.");

        this.name = name;
        this.status = status;
        this.executor = executor;
        this.assignmentTime = assignmentTime;
        this.finishedTime = finishedTime;
    }

    public void setStatus(TaskStatus status) {
        if(status != this.status) {
            this.status = status;
            
            if(status == TaskStatus.DONE)
                finishedTime = LocalDateTime.now();
            else
                finishedTime = null;
        }
    }

    public void setExecutor(Member executor) throws IllegalArgumentException {
        if(status == TaskStatus.DONE)
            throw new IllegalArgumentException("Cannot change executor if status is done.");

        if(executor != this.executor) {
            this.executor = executor;
            assignmentTime = LocalDateTime.now();
            finishedTime = null;
        }
    }

    public String getName() {
        return name;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Member getExecutor() {
        return executor;
    }

    public long getElapsedTime() {
        long elapsedTime;

        if(finishedTime != null && assignmentTime != null)
            elapsedTime = Duration.between(assignmentTime, finishedTime).toSeconds();
        else if(assignmentTime != null)
            elapsedTime = Duration.between(assignmentTime, LocalDateTime.now()).toSeconds();
        else
            elapsedTime = 0L;

        return elapsedTime;
    }
}
