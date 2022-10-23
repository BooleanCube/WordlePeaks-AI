package wordlepeaksai;

import java.io.IOException;

public class WordlePeaksAI {

    public static void main(String[] args) throws IOException {

        // System Rules
        System.out.println("""
                RULES:
                -------------------------------------------------------------------------------
                You will be given a word to input into the Wordle Peaks Game and then prompted
                for input which follows a specific parameter so it can know the output of each
                move you make in the game.
                
                FOR EACH MOVE YOU NEED TO INPUT THE FEEDBACK FROM THE WORDLE PEAKS GAME:
                - U (up) if the box is orange indicating that the letter is after.
                - D (down) if the box is blue indicating that the letter is before.
                - G (green) if the box is green and the letter is in the correct position.
                
                ACCEPTED INPUT EXAMPLES:
                (without the quotation marks)
               "UUBUB", "GGGGG" or "UBGUB"
                """);

        Algorithm algorithm = new Algorithm();
        String answer = algorithm.start();

        // End Result
        System.out.println(answer != null ? "The wordle peaks answer is: " + answer.toUpperCase() : "I couldn't find the word in my current database!");

    }

}
