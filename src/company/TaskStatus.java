package company;

public enum TaskStatus {
    TO_DO("To do"),
    IN_PROGRESS("In progress"),
    DONE("Done");

    private final String text;

    TaskStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}