package onlineTest;

import java.util.List;

public class Question {
    public static Long countObject = 0L;
    private final Long id ;
    private String  text;
    private List<Answer> answerList;
    private Boolean check;
    private String userAnswer;

    public Question(String text, List<Answer> answerList, Boolean check, String userAnswer) {
        countObject++;
        this.id = countObject;
        this.text = text;
        this.answerList = answerList;
        this.check = check;
        this.userAnswer = userAnswer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
}

