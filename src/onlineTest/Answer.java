package onlineTest;

public class Answer {
    public static Long countObject = 0L;
    private final Long id ;
    private String text;
    private Boolean status;

    public Answer(String text, Boolean status) {
        countObject++;
        this.id = countObject;
        this.text = text;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
