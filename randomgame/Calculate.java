package randomgame;

import java.util.Random;

public class Calculate {
    Random random = new Random();
    String appbuild = "v0.4";
    protected static long number, guesses = 0, lowestScore = 0, difficulty;
    public Calculate() {
        
    }
    public Calculate(long difficulty) {
        number = random.nextLong(difficulty + 1);
        Calculate.difficulty = difficulty;
        // System.out.println(number);
    }
    public void reset(long difficulty) {
        number = random.nextLong(difficulty);
        guesses = 0;
        lowestScore = 0;
        // System.out.println(number);
    }
    public String matchNumber(long guess) {
        guesses++;
        String returnText = "";
        if (guess == number) {
            System.out.println("You guessed it correctly!");
            returnText = "You guessed it correctly! Number of guesses: " + guesses + ". Try again!";
            if (guesses < lowestScore || lowestScore == 0) {
                lowestScore = guesses;
            }
            guesses = 0;
            number = (long) (Math.random() * difficulty) + 1;
            // System.out.println(number);
        } else if (guess > 999) {
            guesses+=10;
            returnText = "Are you trying to make fun of me? Serves you right!";
        } else if (guess > difficulty + 1) {
            guesses--;
            returnText = "Too high, try a number less thann " + Calculate.difficulty + "!";
        } else if ((guess - number) >= 10 && (guess - number) > 0) {
            returnText = "Try again, mate. Go lower this time!";
            System.out.println(returnText);
        } else if ((guess - number) < 10 && (guess - number) > 0) {
            returnText = "You\'re very close, mate, a bit more lower!";
            System.out.println(returnText);
        }  else if ((number - guess) >= 10 && (number - guess) > 0) {
            returnText = "Try again, mate. Go higher this time!";
            System.out.println(returnText);
        } else if ((number - guess) < 10 && (number - guess) > 0) {
            returnText = "You\'re very close, mate, a bit more higher!";
            System.out.println(returnText);
        } else if (guess < 0) {
            guesses--;
            returnText = "Too low, try a number more than 0!";
        } else {
            guesses--;
            returnText = "That\'s an error, try again! Check terminal for more info.";
            System.out.println("Sorry, but terminal may be used in future...");
        }
        return returnText;
    }
}
