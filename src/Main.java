
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        System.out.println("Hello world!");
        for (int i = 0; i < 10; i++) {

            int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
            System.out.println(randomNum);
        }
    }
}