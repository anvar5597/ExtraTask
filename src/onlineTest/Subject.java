package onlineTest;

import java.util.List;

public class Subject {
    public static Long countObject = 0L;
    private final Long id ;
    private String name;
    private List<Question> questionList;
    private Integer score;

    public Subject(String name, List<Question> questionList, Integer score) {
        countObject++;
        this.id = countObject;
        this.name = name;
        this.questionList = questionList;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", questionList=" + questionList +
                ", score=" + score +
                '}';
    }
}
