package onlineTest;

public class Result {

    public static Long countObject = 0L;
    private final Long id ;
    private User user;
    private Subject subject;

    public Result(User user, Subject subject) {
        countObject++;
        this.id = countObject;
        this.user = user;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
