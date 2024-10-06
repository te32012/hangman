package com.hangman;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Player {
    private InputStream input;
    private PrintStream output;
    private Scanner scann;


    public Player(InputStream input, PrintStream out) {
        this.input = input;
        this.output = out;
        scann = new Scanner(this.input);
    }
    
    public void print(String data) {
        output.println(data);
    }

    public int getLevel() {
        int level = Integer.parseInt(scann.nextLine());
        if (level > 1 || level < 10) {
            return level;
        } else {
            return -1;
        }
    }

    public Category getCategory() {
        String category = scann.nextLine();
        category = category.toLowerCase();
        switch (category) {
            case "first":
                return Category.FIRST;
            case "second":
                return Category.SECOND;
            case "third":
                return Category.THIRD;
            default:
                return Category.NONE;
        }
    }

    public String getLetter() {
        String letter = scann.nextLine();
        letter = letter.toLowerCase();

        if ((Pattern.matches("[a-z]+", letter) || Pattern.matches("[a-я]+", letter) || Pattern.matches("[1]+", letter)) && letter.length() == 1) {
            return letter;
        } else {
            return null;
        }
    }
}
