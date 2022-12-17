package onlineTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class OnlineTestDemo {
    public static Scanner scanner = new Scanner(System.in);
    public static User currentUser = null;

    public static List<User> users = new ArrayList<>();

    public static List<Subject> subjects = new ArrayList<>();
    public static List<Result> results = new ArrayList<>();


    public static void main(String[] args) {
// users
        //a111
        users.add(new User("Anvar", "admin", "12345", "1"));
        users.add(new User("Anvar", "anvar", "12345", "2"));
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("c^2 = a^2 + b^2", true));
        answers.add(new Answer("c^2 = a^2 - b^2", false));
        answers.add(new Answer("c^3 = a^3 - b^3", false));
        List<Answer> answers1 = new ArrayList<>();
        answers1.add(new Answer("S=a*b/2", true));
        answers1.add(new Answer("S=a*b/4", false));
        answers1.add(new Answer("S=a+b/2", false));
        List<Answer> answers2 = new ArrayList<>();
        answers2.add(new Answer("S=(a+b)/2", true));
        answers2.add(new Answer("S=(a-b)/2", false));
        answers2.add(new Answer("S=(a+b)/3", false));
        List<Answer> answers3 = new ArrayList<>();
        answers3.add(new Answer("a^2 + 2ab + b^2 ", true));
        answers3.add(new Answer("a^2 + ab + b^2", false));
        answers3.add(new Answer("a + 2ab + b", false));
        List<Answer> answers4 = new ArrayList<>();
        answers4.add(new Answer("(a+b)(a^2 + ab + b^2) ", true));
        answers4.add(new Answer("(a-b)(a^2 + ab + b^2)", false));
        answers4.add(new Answer("(a+b)(a + 2ab + b)", false));
        List<Question> question = new ArrayList<>();
        question.add(new Question("Pifagor formulasi", answers, false, "Anvar"));
        question.add(new Question("Uchburchak yuzi", answers1, false, "Anvar"));
        question.add(new Question("O`rta arifmetik", answers2, false, "Anvar"));
        question.add(new Question("(a+b)^2 = ...", answers3, false, "Anvar"));
        question.add(new Question("a^3+b^3 = ... ", answers4, false, "Anvar"));

        List<Question> question1 = new ArrayList<>();
        question1.add(new Question("1.Pifagor formulasi", answers, false, "Anvar"));

        subjects.add(new Subject("Matematika", question, 0));
        subjects.add(new Subject("Fizika", question1, 0));

//        currentUser = users.get(0);
//        showAdminDashboard();

        BoshEkran:
        while (true) {

            System.out.println("      Online test");
            System.out.println("1.Login");
//            System.out.println("2.Registration");
            System.out.println("3.All users");
            System.out.println("4.Log out");
            System.out.println("5.Exit");
            int choose1 = scanner.nextInt();
            switch (choose1) {
                case 1 -> login();
//                case 2 -> registration();
                case 3 -> showAllUsers();
                case 4 -> currentUser = null;
                case 5 -> {
                    break BoshEkran;
                }
            }

        }

  /*      List<Question> questionList = new ArrayList<>();
        List<Answer> answerList = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Javob: ");
            String javob = scanner.next();
            boolean chek = scanner.nextBoolean();
            answerList.add(new Answer(javob, chek));
        }*/
//        questionList.add(new Question("laskfjsalkdj", answerList, false, ""));
//        answerList.add(new Answer("A. Text1", false));
//        answerList.add(new Answer("B. Text2", true));
//        answerList.add(new Answer("C. Text3", false));


    }

    private static void login() {
        scanner = new Scanner(System.in);
        System.out.print("Email: ");
        String login = scanner.nextLine();
        System.out.print("password: ");
        String password = scanner.nextLine();

        if (chekEmail(login, password)) {
            initCurrentAccount(login);
            if (currentUser.getRole().equals("1")) {
                showAdminDashboard();
            } else if (currentUser != null)
                showDashboard();
        } else {
            System.out.println("Something went wrong!");
        }
    }

    // admin


    private static void showAdminDashboard() {
        System.out.println("-------Admin oynasi-------------");
        System.out.println("1.Yangi mavzu yaratish");
        System.out.println("2.Mavzular ro`yhati");
        System.out.println("3.Yangi test yaratish");
        System.out.println("4.Testning javobini o`zgartirish");
        System.out.println("5.Testlarni ko`rish");
        System.out.println("7.Foydalanuvchilar ro`yhati");
//        System.out.println("8.Foydalanuvchilarning natijalarini ko`rish");
        System.out.println("0.Chiqish");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1 -> addSubject();
            case 2 -> showSubject();
            case 3 -> addQuestion();
            case 4 -> changeAnswer();
            case 5 -> showQuestion();
            case 7 -> showAllUsers();
            case 0 -> currentUser = null;
//            case 8 -> showAllUsersResult();
            default -> {
                System.out.println("Uzur noto`g`ri raqam!");
                showAdminDashboard();
            }

        }
    }

    private static void logOut() {
    }

    private static void showQuestion() {
        for (Subject subject : subjects) {
            System.out.println(subject.getId() + " " + subject.getName());
        }
        System.out.print("Qaysi mavzudan testlarni ko`rmoqchisiz: ");
        long ch = scanner.nextLong();
        for (Subject subject : subjects) {
            if (subject.getId().equals(ch)) {
                List<Question> s = subject.getQuestionList();
                int qcnt = 0;
                for (Question question : s) {
                    System.out.println(++qcnt + " " + question.getText());
                    List<Answer> answers = question.getAnswerList();
                    int cc = 0;
                    for (Answer answer : answers) {
                        if (answer != null) {
                            cc++;
                            switch (cc) {
                                case 1 -> System.out.print("A.");
                                case 2 -> System.out.print("B.");
                                case 3 -> System.out.print("C.");
                            }
                            System.out.print(answer.getText() + "\t\t");
                        }
                    }
                    System.out.println();
                }
            }
        }
        showAdminDashboard();
    }

    private static void showSubject() {
        for (Subject subject : subjects) {
            System.out.println(subject.getId() + " " + subject.getName());
        }
      /*  for (Subject subject : subjects) {
            System.out.println(subject.getQuestionList());
        }*/
        showAdminDashboard();
    }

    private static void showAllUsersResult() {
        for (Subject subject : subjects) {
            System.out.println(subject.getId() + " " + subject.getName());
        }
        long ch = scanner.nextLong();
        for (Subject subject : subjects) {
            if (subject.getId().equals(ch)) {
                List<Question> s = subject.getQuestionList();
                int qcnt = 0;
                for (Question question : s) {
                    System.out.println(++qcnt + " " + question.getText());
                }
                long anwerId = scanner.nextLong();
                int q1 = 0;
                for (Question question : s) {
                    if (question != null) {
                        if (++q1 == anwerId) {
                            List<Answer> answers = question.getAnswerList();
                            long anwercnt = 0;
                            for (Answer answer : answers) {
                                System.out.println(++anwercnt + " " + answer.getText());
                            }
                            long ans = scanner.nextLong();
                            long anwercnt1 = 0;
                            for (Answer answer : answers) {
                                if (answer != null) {
                                    if (ans == ++anwercnt1) {
                                        System.out.println("Oldingi javob: " + answer.getText());
                                        scanner = new Scanner(System.in);
                                        String s1 = scanner.nextLine();
                                        answer.setText(s1);
                                    }
                                }
                            }
                            showAdminDashboard();
                        }
                    }
                }
            }
        }
    }

    private static void changeAnswer() {
        for (Subject subject : subjects) {
            System.out.println(subject.getId() + " " + subject.getName());
        }
        long ch = scanner.nextLong();
        for (Subject subject : subjects) {
            if (subject.getId().equals(ch)) {
                List<Question> s = subject.getQuestionList();
                int qcnt = 0;
                for (Question question : s) {
                    System.out.println(++qcnt + " " + question.getText());
                }
                long anwerId = scanner.nextLong();
                int q1 = 0;
                for (Question question : s) {
                    if (question != null) {
                        if (++q1 == anwerId) {
                            List<Answer> answers = question.getAnswerList();
                            long anwercnt = 0;
                            for (Answer answer : answers) {
                                System.out.println(++anwercnt + " " + answer.getText());
                            }
                            long ans = scanner.nextLong();
                            long anwercnt1 = 0;
                            for (Answer answer : answers) {
                                if (answer != null) {
                                    if (ans == ++anwercnt1) {
                                        System.out.println("Oldingi javob: " + answer.getText());
                                        scanner = new Scanner(System.in);
                                        String s1 = scanner.nextLine();
                                        answer.setText(s1);
                                    }
                                }
                            }
                            showAdminDashboard();
                        }
                    }
                }
            }
        }
    }

    private static void addQuestion() {
        scanner = new Scanner(System.in);
        for (Subject subject : subjects) {
            System.out.println(subject.getId() + " " + subject.getName());
        }
        System.out.print("Nechanchi mavzuga qo`shmoqchisiz: ");
        int i = scanner.nextInt();
        Long subjectId = (long) i;
        System.out.println("Birinchi to`g`ri javobni yozing!");
        System.out.println("Savolni yo`zing: ");
        scanner = new Scanner(System.in);
        String question = scanner.nextLine();
        List<Answer> answers = new ArrayList<>();
        System.out.println("A: ");
        scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        answers.add(new Answer(a, true));
        System.out.println("B: ");
        scanner = new Scanner(System.in);
        String b = scanner.nextLine();
        answers.add(new Answer(b, false));
        System.out.println("C: ");
        scanner = new Scanner(System.in);
        String c = scanner.nextLine();
        answers.add(new Answer(c, false));
        System.out.println("D: ");
        scanner = new Scanner(System.in);
        String d = scanner.nextLine();
        answers.add(new Answer(d, false));
        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question(question, answers, false, ""));
        for (Subject subject : subjects) {
            if (subject.getId().equals(subjectId)) {
                List<Question> q = subject.getQuestionList();
                q.addAll(questionList);
            }
        }
        showAdminDashboard();
    }

    private static void addSubject() {
        scanner = new Scanner(System.in);
        for (Subject subject : subjects) {
            System.out.println(subject.getId() + " " + subject.getName());
        }
        System.out.print("Yangi mavzuni kiriting: ");
        String subjectName = scanner.nextLine();
        subjects.add(new Subject(subjectName, new ArrayList<>(), 0));
        showAdminDashboard();
    }

    private static void registration() {
        scanner = new Scanner(System.in);
        System.out.print("Ismingizni kiriting:  ");
        String name = scanner.nextLine();
        System.out.print("Emailingizni kiriting:  ");
        String email = scanner.next();
        mavjudEmealniTekshirish:
        while (true) {
            boolean unicEmail = false;
            for (User user : users) {
                if (user != null) {
                    if (user.getEmail().equals(email)) {
                        System.out.println("Bunday login mavjud!\nLogin: ");
                        email = scanner.next();
                    } else {
                        unicEmail = true;
                    }
                }
                break;
            }
            if (unicEmail) {
                break mavjudEmealniTekshirish;
            }
        }

    }

    private static void showAllUsers() {
        for (User user : users) {
            if (user != null) {
                System.out.println(user.getId() + " " + user.getName());
            }
        }
    }


    private static void initCurrentAccount(String email) {
        for (User user : users) {
            if (user != null) {
                if (user.getEmail().equals(email))
                    currentUser = user;
            }
        }
    }

    private static boolean chekEmail(String email, String password) {
        for (User user : users) {
            if (user != null) {
                if (user.getEmail().equals(email) && user.getPasword().equals(password))
                    return true;

            }
        }
        return false;
    }


//   User

    private static void showDashboard() {
        System.out.println("------Online test---------");
        System.out.println("1.Test yechish");
        System.out.println("2.Natijalarni ko`rish");
        System.out.println("3.Chiqish");

        int choose = scanner.nextInt();
        switch (choose) {
            case 1 -> testSolution();
            case 2 -> showResult();
            case 3 -> currentUser = null;
            default -> {
                System.out.println("Uzr !");
                showDashboard();
            }
        }
    }

    private static void showResult() {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        for (Result result : results) {
            if (result != null && result.getUser().equals(currentUser))
                System.out.println("Siz " + result.getDate().format(myFormatObj) + " kuni " + result.getSubject().getName() + " fanidan " + result.getScore() + " ball oldingiz");
        }
        showDashboard();
    }

    private static void testSolution() {
        System.out.println("Qaysi mavzudan yechmoqchisiz №: ");
        StringBuilder trueAnswer = new StringBuilder();
        StringBuilder checkanswer = new StringBuilder();
        for (Subject subject : subjects) {
            System.out.println(subject.getId() + " " + subject.getName());
        }
        long ch = scanner.nextLong();
        for (Subject subject : subjects) {
            int result = 0;
            if (subject.getId().equals(ch)) {
                List<Question> questions1 = new ArrayList<>(subject.getQuestionList());
                List<Question> questions2 = new ArrayList<>();
                System.out.print("Nechtalik test yechoqchisiz: ");
                int chooeseQuestion = scanner.nextInt();
                Random rand = new Random();
                for (int i = chooeseQuestion; i >0; i--) {
                    int randQ = rand.nextInt(i);
                    String textQ = questions1.get(randQ).getText();
                    List<Answer> answers = new ArrayList<>(questions1.get(randQ).getAnswerList());
                    boolean bb = questions1.get(randQ).getCheck();
                    String user = questions1.get(randQ).getUserAnswer();
                    questions2.add(new Question(textQ,answers,bb,user));
                    questions1.remove(randQ);
                }
                int qcnt = 0;
                for (Question question : questions2) {
                    question.setCheck(false);
                    System.out.println(++qcnt + " " + question.getText());

                    int ccc = 0;
                    List<Answer> answerList = new ArrayList<>(question.getAnswerList());
                    List<Answer> answers = new ArrayList<>();
                    int ansnum = 3;

                    for (int i = 0; i < 3; i++) {
                        int randn = rand.nextInt(ansnum--);
                        String text = answerList.get(randn).getText();
                        boolean b = answerList.get(randn).getStatus();
                        Answer aaa = new Answer(text, b);
                        answers.add(aaa);
                        answerList.remove(randn);
                    }
                    for (Answer answer : answers) {
                        if (answer != null) {
                            ccc++;
                            switch (ccc) {
                                case 1 -> {
                                    System.out.print("A.");
                                }
                                case 2 -> {
                                    System.out.print("B.");
                                }
                                case 3 -> {
                                    System.out.print("C.");
                                }
                            }
                            if (answer.getStatus()) {
                                switch (ccc) {
                                    case 1 -> {
                                        trueAnswer.append("A" + " ");
                                    }
                                    case 2 -> {
                                        trueAnswer.append("B" + " ");
                                    }
                                    case 3 -> {
                                        trueAnswer.append("C" + " ");
                                    }
                                }
                            }

                            System.out.print(answer.getText() + "\t\t");

                        }

                    }
                    System.out.print("\nJavob №: ");
                    int answer1 = scanner.nextInt();
                    switch (answer1) {
                        case 1 -> checkanswer.append("A" + " ");
                        case 2 -> checkanswer.append("B" + " ");
                        case 3 -> checkanswer.append("C" + " ");
                    }
                    int anawerN = 0;
                    String s2 = "";
                    for (Answer answer : answers) {
                        if (answer != null) {
                            if (++anawerN == answer1 && answer.getStatus()) {
                                result++;
                                break;
                            }
                        }
                    }

                    subject.setScore(result);
                    if (question.getCheck()) {
                        result++;
                    }

                }
                LocalDateTime date = LocalDateTime.now();

                results.add(new Result(currentUser, subject, result, date));
                System.out.println("Sizning  natijangiz: " + result + " " + 100. * result / (questions2.size()) + "%");
                System.out.println("Sizning javobingiz: " + checkanswer);
                System.out.println("To`g`ri javob: " + trueAnswer);
            }
        }
        showDashboard();
    }

}

