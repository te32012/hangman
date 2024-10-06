package com.hangman;

import java.util.HashMap;
import java.util.List;

public class Word {
    private String currentWord;
    private HashMap<String, List<Integer>> wordMap;
    private String advice;
    
    public Word(String currentWord, HashMap<String, List<Integer>> wordMap, String advice) {
        this.currentWord = currentWord;
        this.wordMap = wordMap;
        this.advice = advice;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public HashMap<String, List<Integer>> getWordMap() {
        return wordMap;
    }

    public String getAdvice() {
        return advice;
    }

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    public void setWordMap(HashMap<String, List<Integer>> wordMap) {
        this.wordMap = wordMap;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    
}
