package com.hangman;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Game {

    private Word wordObj;
    private int level;
    private int countError;

    public HashMap<String, List<Integer>> getWord() {
        return wordObj.getWordMap();
    }

    public String getAdvice() {
        return wordObj.getAdvice();
    }

    public Game(Word word, int level) {
        this.wordObj = word;
        this.level = level;
    }

    public void nextStep(String symbol)  {
        List<Integer> tmp = getWord().get(symbol);
        if (tmp != null && tmp.size() > 0) {
            String newCurrentWord = "";
            HashSet<Integer> data = new HashSet<>();
            for (int i = 0; i < tmp.size(); i++) {
                data.add(tmp.get(i));
            }    
            for (int i = 0; i < wordObj.getCurrentWord().length(); i++) {
                if (data.contains(Integer.valueOf(i))) {
                    newCurrentWord = newCurrentWord + symbol;   
                } else {
                    newCurrentWord = newCurrentWord + String.valueOf(wordObj.getCurrentWord().charAt(i));
                }
            }
            wordObj.setCurrentWord(newCurrentWord);
        } else {
            countError++;
        }
    }

    public String countError() {
        return String.valueOf(level - countError);
    }

    public boolean hashStep() {
        return countError < level && wordObj.getCurrentWord().contains("*");
    }

    public String printWord() {
        return wordObj.getCurrentWord();
    }

    public String printHangman() {
        String ans = "";
        ans = "___\n";
        for (int i = 0; i < countError; i++) {
            ans = ans + "|   |\n";
        }
        if (countError == level) {
            ans = ans + "|    0\n" + //
                        "|   /|\\\n" + //
                        "|    |\n" + //
                        "|   / \\\n"; 
        }
        ans = ans + "|\n" + //
                    "|\n" + //
                    "|\n" + //
                    "| __";
        return ans;
    }
}
