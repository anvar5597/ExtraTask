package onlineTest;

import java.util.*;

public class OnlineTestDemo {
    public static Scanner scanner = new Scanner(System.in);
    public static User currentUser = null;

    public static List<User> users = new ArrayList<>();

    public static List<Subject> subjects = new ArrayList<>();

    public static void main(String[] args) {
// users
        //a111
        users.add(new User("Anvar", "admin", "12345", "1"));
        users.add(new User("Anvar", "anvar", "12345", "2"));
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("A.c^2 = a^2 + b^2", true));
        answers.add(new Answer("B.c^2 = a^2 - b^2", false));
        answers.add(new Answer("C.c^3 = a^3 - b^3", false));
        List<Question> question = new ArrayList<>();
        question.add(new Question("Pifagor formulasi", answers, false, "Anvar"));
        question.add(new Question("Uchburchak yuzi", answers, false, "Anvar"));
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
            int choose = scanner.nextInt();
            switch (choose) {
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
            }
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
                    for (Answer answer : answers) {
                        if (answer != null) {
                            System.out.print(answer.getText() + "\t");
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
        subjects.add(new Subject(subjectName, null, 0));
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

        int choose = scanner.nextInt();
        switch (choose) {
            case 1 -> testSolution();
            default -> {
                System.out.println("Uzr !");
                showDashboard();
            }
        }
    }

    private static void testSolution() {
        System.out.println("Qaysi mavzudan yechmoqchisiz №: ");
        for (Subject subject : subjects) {
            System.out.println(subject.getId() + " " + subject.getName());
        }
        long ch = scanner.nextLong();
        for (Subject subject : subjects) {
            int result = 0;
            if (subject.getId().equals(ch)) {
                List<Question> questions1 = subject.getQuestionList();
                int qcnt = 0;
                for (Question question : questions1) {
                    question.setCheck(false);
                    System.out.println(++qcnt + " " + question.getText());
                    List<Answer> answers = question.getAnswerList();
                    for (Answer answer : answers) {
                        if (answer != null) {
                            System.out.print(answer.getText() + "\t");
                        }
                    }
                    System.out.print("Javob №: ");
                    int answer1 = scanner.nextInt();
                    int anawerN = 0;
                    String s2 ="";
                    for (Answer answer : answers) {
                        if (answer != null) {
                            if(++anawerN == answer1 && answer.getStatus()) {
                                result++;
                                break;
                            }
                        }
                    }
                    /*for (Answer answer : answers) {
                        if (answer != null) {
                            if(answer.getText().equals(s2)) {
                                question.setCheck(true);
                                break;
                            }
                        }
                    }*/

                    if (question.getCheck()){
                        result++;
                    }
                }
                System.out.println("Sizning  natijangiz: " + result);
            }
        }
        showDashboard();
    }


}
