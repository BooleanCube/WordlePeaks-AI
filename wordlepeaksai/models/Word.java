package wordlepeaksai.models;

import wordlepeaksai.LimitTracker;
import wordlepeaksai.tools.Convertor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Word {

    private static ArrayList<String> words;
    public String currentWord = "";

    public Word() {
        try { initializeWords(); } catch (IOException ignored) {}
    }

    /**
     * Creates the list of 5-letter words from the English dictionary.
     * @throws IOException for BufferedReader and InputStreamReader
     */
    private static void initializeWords() throws IOException {
        words = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(
                new URL("https://www-cs-faculty.stanford.edu/~knuth/sgb-words.txt")
                        .openConnection()
                        .getInputStream()
        ));
        String input;
        while((input=bf.readLine()) != null) words.add(input);
        bf.close();
    }

    /**
     * Calculate the difference between a word and the average string from the limit tracker in the binary search algorithm.
     * @param word current word to compare
     * @param tracker average string calculated from the limits tracker
     * @return difference value of the pair of strings
     */
    private double compareDiff(String word, LimitTracker tracker) {
        double diff = 0D;
        for(int i=0; i<5; i++) diff += Math.abs(Convertor.l2n(word.charAt(i))-tracker.getAverage(i));
        return diff;
    }

    /**
     * Finds the word with the least difference value with the current average string from the limit tracker.
     * @param tracker current limit tracker with the average string.
     */
    public void calculateBestWord(LimitTracker tracker) {
        double minimum = 69.420D; // 66 is the maximum possible (13*5+1)
        String bestWord = "";
        for(String word : words) {
            double diff = this.compareDiff(word, tracker);
            if(diff < minimum) {
                minimum = diff;
                bestWord = word;
                if(minimum == 0) break;
            }
        }
        this.currentWord = bestWord;
    }

}
