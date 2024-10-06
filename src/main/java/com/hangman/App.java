package com.hangman;

import java.util.HashMap;
import java.util.List;

public class App {
    
    public static void main(String[] args) {
        HashMap<Category, List<String>> categoris = new HashMap<>();
        categoris.put(Category.FIRST, List.of("данные", "программа", "структура"));
        categoris.put(Category.SECOND, List.of("человек", "животное", "попугай"));
        categoris.put(Category.THIRD, List.of("семь", "восемь", "девять"));
        Player player = new Player(System.in, System.out);
        GameLoop game = new GameLoop(player);
        while (true) {
            System.out.println("Добро пожаловать в игру Висилеца!!");
            System.out.println("Выберите уровень сложности!!!");
            System.out.println("Выберите категорию слов!!!");
            game.initGame(categoris);
            game.nextGame();
        }
    }
    
}
