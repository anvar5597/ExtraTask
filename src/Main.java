
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

     /*   System.out.println("Hello world!");
        System.out.println("Hello world!");
        for (int i = 0; i < 10; i++) {

            int randomNum = (int) (Math.random() * 5);
            System.out.println(randomNum);
        }*/
        List<String> givenList = Arrays.asList("a","B");
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            String randomElement = givenList.get(rand.nextInt(givenList.size()));
            System.out.println(randomElement);
        }


    }
}