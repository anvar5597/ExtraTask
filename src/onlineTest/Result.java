package onlineTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Result {

    public static Long countObject = 0L;
    private final Long id ;
    private User user;
    private Subject subject;
    private Integer score;

    private LocalDateTime date;

    public Result(User user, Subject subject , Integer score , LocalDateTime date) {
        countObject++;
        this.id = countObject;
        this.user = user;
        this.score = score;
        this.subject = subject;
        this.date = date;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
