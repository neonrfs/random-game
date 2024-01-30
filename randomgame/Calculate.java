package randomgame;

public class Calculate {
    String appbuild = "v0.0.1";
    long number, guesses = 0, lowestScore = 0;
    public Calculate() {
        guesses = 0;
        lowestScore = 0;
        number = (long) (Math.random() * 100) + 1;
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
            number = (long) (Math.random() * 100) + 1;
            // System.out.println(number);
        } else if (guess > 100) {
            guesses--;
            returnText = "Too high, try a number less than 100!";
        } else if ((guess - number) > 10 && (guess - number) > 0) {
            returnText = "Try again, mate. Go lower this time!";
            System.out.println(returnText);
        } else if ((guess - number) < 10 && (guess - number) > 0) {
            returnText = "You\'re very close, mate, a bit more lower!";
            System.out.println(returnText);
        }  else if ((number - guess) > 10 && (number - guess) > 0) {
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
