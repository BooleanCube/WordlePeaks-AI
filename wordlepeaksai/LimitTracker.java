package wordlepeaksai;

import wordlepeaksai.models.Word;
import wordlepeaksai.tools.Convertor;

public class LimitTracker {

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

    public double getAverage(int index) {
        return (this.limits[index][0] + this.limits[index][1])/2.0D;
    }

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
