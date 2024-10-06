package com.hangman;

import java.util.HashMap;
import java.util.List;

public class App {
    
    public static void main(String[] args) {
        HashMap<Category, List<Pair<String>>> categoris = new HashMap<>();
        categoris.put(Category.FIRST, List.of(new Pair<String>("данные", "то что хранит информацию."), 
        new Pair<String>("программа", "то что хранит информацию.")
        ,new Pair<String>("структура", "как культура только.")));
        categoris.put(Category.SECOND, List.of(new Pair<String>("человек", "с интелектом"), 
        new Pair<String>("животное", "без интелекта")
        ,new Pair<String>("попугай", "повторяет если научитьь")));
        categoris.put(Category.THIRD, List.of(new Pair<String>("семь", "следующая за средней цифрой"), 
        new Pair<String>("восемь", "цифра предпоследняя")
        ,new Pair<String>("девять", "цифра последняя")));

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
