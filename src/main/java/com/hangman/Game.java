package com.hangman;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Game {
    private String currentWord;
    private HashMap<String, List<Integer>> word;
    private int level;
    private int countError;

    public HashMap<String, List<Integer>>  getWord() {
        return word;
    }

    public Game(String currentWord, HashMap<String, List<Integer>> word, int level) {
        this.level = level;
        this.word = word;
        this.currentWord = currentWord;
    }

    public void nextStep(String symbol)  {
        List<Integer> tmp = word.get(symbol);
        if (tmp != null && tmp.size() > 0) {
            String newCurrentWord = "";
            HashSet<Integer> data = new HashSet<>();
            for (int i = 0; i < tmp.size(); i++) {
                data.add(tmp.get(i));
            }    
            for (int i = 0; i < currentWord.length(); i++) {
                if (data.contains(Integer.valueOf(i))) {
                    newCurrentWord = newCurrentWord + symbol;   
                } else {
                    newCurrentWord = newCurrentWord + String.valueOf(currentWord.charAt(i));
                }
            }
            this.currentWord = newCurrentWord;
        } else {
            countError++;
        }
    }

    public String countError() {
        return String.valueOf(level - countError);
    }

    public boolean hashStep() {
        return countError < level && currentWord.contains("*");
    }

    public String printWord() {
        return currentWord;
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
