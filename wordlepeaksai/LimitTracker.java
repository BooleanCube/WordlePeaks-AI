package wordlepeaksai;

import wordlepeaksai.models.Word;
import wordlepeaksai.tools.Convertor;

/**
 * Binary Search Tracker for the average string to be calculated.
 */
public class LimitTracker {

    /**
     * Length 5 for the 5 characters in the average string and the minimum and maximum limits fit in a 2d array of length 2.
     * An example is shown in the constructor for the default average map with unmodified limits.
     */
    private final double[][] limits;

    public LimitTracker() {
        // Default average ( (0+25)/2 = 12/5 )
        this.limits = new double[][]{
                new double[]{0,25},
                new double[]{0,25},
                new double[]{0,25},
                new double[]{0,25},
                new double[]{0,25}
        };
    }

    public double[][] getTracker() {
        return this.limits;
    }

    /**
     * Gets the average letter from the corresponding limits at the given index.
     * @param index given index integer to get the average character.
     * @return double average ascii value
     */
    public double getAverage(int index) {
        return (this.limits[index][0] + this.limits[index][1])/2.0D;
    }

    /**
     * Updates the limits for the binary search according to the given feedback and the guessed word.
     * @param word last guessed word
     * @param input feedback from wordle peaks game with valid input format
     */
    public void updateCharacterLimits(Word word, String input) {
        for(int i=0; i<5; i++) {
            char current = input.charAt(i);
            char letter = word.currentWord.charAt(i);
            if(current == 'U') this.limits[i][0] = Math.max(this.limits[i][0], Convertor.l2n(letter)+1);
            else if(current == 'D') this.limits[i][1] = Math.min(this.limits[i][1], Convertor.l2n(letter)-1);
            else {
                this.limits[i][0] = Convertor.l2n(letter);
                this.limits[i][1] = this.limits[i][0];
            }
        }
    }

}
