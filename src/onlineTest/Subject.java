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
}
