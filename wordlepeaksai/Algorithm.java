package wordlepeaksai;

import wordlepeaksai.models.Word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algorithm {

    private final LimitTracker tracker;
    private final Word word;

    public Algorithm() {
        this.tracker = new LimitTracker();
        this.word = new Word();
    }

    private boolean isInvalid(String input) {
        if(input.length() != 5) return true;
        for(char c : input.toCharArray()) if(c!='D' && c!='G' && c!='U') return true;
        return false;
    }

    public String start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 6 tries maximum
        for(int i=0; i<6; i++) {
            this.word.calculateBestWord(this.tracker);
            System.out.println(this.word.currentWord.toUpperCase());
            String feedback = bf.readLine().toUpperCase();
            if(feedback.equals("GGGGG")) return this.word.currentWord;
            else if(this.isInvalid(feedback)) return null;
            this.tracker.updateCharacterLimits(this.word, feedback);
        }
        return null;
    }

}
