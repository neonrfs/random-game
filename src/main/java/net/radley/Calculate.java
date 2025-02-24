package net.radley;

import java.util.Random;

public class Calculate {
    /**
     * number
     * @apiNote This is the actual number which is the RNG
     * @since RandomGame v0.0
     */
    protected static int number;
    /**
     * number
     * @apiNote This is the number of attempts per session
     * @since RandomGame v0.0
     */
    public static int guesses = 0;
    /**
     * number
     * @apiNote This is the number of lowest attemps per session
     * @deprecated Use Saves.scores instead
     * @since RandomGame v0.0
     */
    public static int lowestScore = 0;
    /**
     * number
     * @apiNote This is the number which determines which difficulty is selected
     * @since RandomGame v0.0
     */
    public static int difficulty;
    /**
     * number
     * @apiNote Random object
     * @since RandomGame v0.0
     */
    Random random = new Random();
    /**
     * random
     * @apiNote App build
     * @since RandomGame v0.0
     */
    public static String appbuild = "v0.9.1";
    /**
     * String
     * Used to set themes for the game
     * @apiNote This is supposed readonly, but I couldn't implement that
     * @since RandomGame v0.6
     */
    protected static String themeStatus = "dark.css";
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
    public Calculate(int difficulty) {
        Calculate.difficulty = difficulty;
        number = random.nextInt(Calculate.difficulty);
        // System.out.println(number);
    }
    /**
     * This will reset the scores, in the same difficulty.
     * @param difficulty - this number is used to reference which level to use
     * @deprecated This is deprecated, use reset()
     * @since RandomGame v0.2
     */
    public void reset(int difficulty) {
        number = random.nextInt(1, difficulty + 1);
        guesses = 0;
        lowestScore = 0;
        SetupStage.saves.reset();   
        // System.out.println(number);
    }
    /**
     * This will reset the scores, in the same difficulty.
     * @since RandomGame v0.5
     */
    public void reset() {
        number = random.nextInt(1, Calculate.difficulty);
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
    public String matchNumber(int guess) {
        String returnText = "";
        guesses++;
            if (guess == number) {
                System.out.println("You guessed it correctly!");
                returnText = "You guessed it correctly! Number of guesses: " + guesses + ". Try again!";
                if (Calculate.difficulty == 50) {
                    if (Calculate.guesses < Saves.scores[0]) {
                        Saves.scores[0] = Calculate.guesses;
                    }
                }
                if (Calculate.difficulty == 100) {
                    if (Calculate.guesses < Saves.scores[1]) {
                        Saves.scores[1] = Calculate.guesses;
                    }
                }
                if (Calculate.difficulty == 200) {
                    if (Calculate.guesses < Saves.scores[2]) {
                        Saves.scores[2] = Calculate.guesses;
                    }
                }
                guesses = 0;
                number = (int) (random.nextInt(1, difficulty + 1));
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
