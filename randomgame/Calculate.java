package randomgame;

import java.util.Random;

public class Calculate {
    protected static long number;
    public static long guesses = 0;
    public static long lowestScore = 0;
    public static long difficulty;
    Random random = new Random();
    public String appbuild = "v0.5";
    /**
     * Calculate, used for all calculations
     * @apiNote This code actually does nothing
     * @since RandomGame v0.0
     */
    public Calculate() {
        
    }
    /**
     * Calculate, used for all calculations
     * @apiNote This uses java.util.Random, but is inclusive
     * @param difficulty - this number is inclusive
     * @since RandomGame v0.1
     */
    public Calculate(long difficulty) {
        number = random.nextLong(difficulty + 1);
        Calculate.difficulty = difficulty;
        // System.out.println(number);
    }
    /**
     * This will reset the scores, in the same difficulty.
     * @param difficulty - this number is used to reference which level to use
     * @deprecated This is deprecated, use reset()
     * @since RandomGame v0.2
     */
    public void reset(long difficulty) {
        number = random.nextLong(difficulty);
        guesses = 0;
        lowestScore = 0;
        // System.out.println(number);
    }
    /**
     * This will reset the scores, in the same difficulty.
     * @since RandomGame v0.5
     */
    public void reset() {
        number = random.nextLong(Calculate.difficulty);
        guesses = 0;
        lowestScore = 0;
        // System.out.println(number);
    }
    /**
     * 
     * @param guess - Gets the user guess and sees if the number matches
     * @return a string, used in the displayLabel
     * @since RandomGame v0.0
     */
    public String matchNumber(long guess) {
        String returnText = "";
        guesses++;
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
                returnText = "Too high, try a number less than " + Calculate.difficulty + "!";
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
