import java.util.*;

public class NumberGame {
    public static void main(String args[]) {

        boolean wantToplayAgain = true;

        Scanner scanner = new Scanner(System.in);
        System.out.println("------>WELCOME TO HARATHI's NUMBER GAME<------");
        System.out.println("RULES:");
        System.out.println("1.You Have to Guess Number in between from 0 to 100.");
        System.out.println("2.You have 5 attempts.");
        System.out.println("3.Your score depends on which attempt you guessed that number.");
        System.out.println(
                "4.For Example:- If you guessed it on first attempt then your score will be '5' if  attempts increases score will be decreased.");
        System.out.println("5.If you give input other than no.s from 0 to 100 it will exits your game.");
        System.out.println("*************All The Best*************");
        while (wantToplayAgain) {
            int score = game(scanner);
            if (score <= 0) {
                System.out.println("Well Tried!!");
                System.out.println("Try Again!!!");

            } else if (score >= 1 && score < 3) {
                System.out.println("Great!! Your score is " + score);

            } else {
                System.out.println("EXCELLENT YOU GUESSED VERY WELL!! Your Score is " + score);

            }

            System.out.print("Do You want to Play again?(y/n): ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("y")) {
                wantToplayAgain = false;
            }
        }
        System.out.println("Thank You For Playing!!!");
        scanner.close();
    }

    public static int game(Scanner scanner) {
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int score = 0;
        boolean guessed = false;
        while (!guessed && attempts < 5) {
            System.out.println("Enter your Guessed Number:");
            int guessNumber = scanner.nextInt();

            attempts++;
            if (guessNumber < targetNumber && guessNumber <= 100 && guessNumber >= 0) {
                System.out.println("Too Low...Try again!!!");

            } else if (guessNumber > targetNumber && guessNumber <= 100 && guessNumber >= 0) {
                System.out.println("Too High...Try again!!!");

            } else if (guessNumber >= 100) {
                System.out.println("Use 0 to 100 range only");
                System.out.println("Till now Your Score is: " + score);
                return -1;

            } else {

                System.out.println("Congratulations :)");
                System.out.println("Computer Guessed Number is " + targetNumber);

                System.out.println("You are a charm!!! You Guessed right");
                if (attempts == 1) {
                    score += 5;
                } else if (attempts == 2) {
                    score += 4;
                } else if (attempts == 3) {
                    score += 3;
                } else if (attempts == 4) {
                    score += 2;
                } else {
                    score += 1;
                }
                return score;
            }
            if (attempts == 5) {
                System.out.println("Computer Guessed Number is " + targetNumber);
            }
        }
        return score;
    }

}
