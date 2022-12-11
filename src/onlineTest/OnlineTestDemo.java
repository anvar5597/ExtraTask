package onlineTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineTestDemo {
    public static Scanner scanner = new Scanner(System.in);
    public static User currentUser = null;

    public static List<User> users;


    public static void main(String[] args) {
// users
        //a11
        users.add(new User("Anvar", "admin", "12345", "1"));
        users.add(new User("Anvar", "olimov@gmail.com", "12345", "2"));
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("A.c^2 = a^2 + b^2",true));
        answers.add(new Answer("A.c^2 = a^2 - b^2",false));
        answers.add(new Answer("A.c^3 = a^3 - b^3",false));
        List<Question> question = new ArrayList<>();
        question.add(new Question("1.Pifagor formulasi" , answers,false,"Anvar"));
        List<Subject> subjects=new ArrayList<>();
        subjects.add(new Subject("Matematika",question,0));

// test
//        subjects.add(new Subject("Matematika",questions,1));
//        subjects.add(new Subject("Matematika",questions,1));
////question
//        questions.add(new Question("1.Pifagor formulasi",answers,false, "A"));
//        questions.add(new Question("1.Uchburchak yuzi",answers,false, "A"));
//answer
//        answers.add(new Answer())
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

        List<Question> questionList = new ArrayList<>();
        List<Answer> answerList = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Javob: ");
            String javob = scanner.next();
            boolean chek = scanner.nextBoolean();
            answerList.add(new Answer(javob, chek));
        }
//        answerList.add(new Answer("A. Text1", false));
//        answerList.add(new Answer("B. Text2", true));
//        answerList.add(new Answer("C. Text3", false));
        questionList.add(new Question("laskfjsalkdj", answerList, false, ""));


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

    private static void showDashboard() {

    }

    private static void showAdminDashboard() {

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
}
