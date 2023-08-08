import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * A movie recommendation engine using both weighted/personalized ratings and unweighted/objective ratings.
 *
 * Ioan Hodean
 * 1.0
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(" ");
        System.out.println("Hello and welcome to our movie search engine recommendation!");
        System.out.println("This program intends to help in your in selection process for the next movie you should watch, " +
                "based on your preferences or on objective ratings.");
        System.out.println(" ");
        System.out.println("Are you ready?");
        Scanner s = new Scanner(System.in);
        String hei = s.nextLine();
        String[] positive={"Yes","yes","ay","sure","y","ok","yesboss","mhmm"};
        List<String> pos=Arrays.asList(positive);
        if (pos.contains(hei)) {
        Active.scannerAndRunner();
        } else {
            System.out.println("Alright, understandable. Have a good day!");
            System.exit(1);
        }
    }
}
