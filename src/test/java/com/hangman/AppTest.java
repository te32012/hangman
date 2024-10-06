package com.hangman;

import java.util.HashMap;
import java.util.List;
import java.io.*;


import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class AppTest {
    
    // входные данные в прогрмму 
    // уровень сложности (число ошибок)
    // категория слов
    

    // Берем заведомо не существующую категорию слов
    @Test
    public void Test1() {
        HashMap<Category, List<String>> categoris = new HashMap<>();
        categoris.put(Category.FIRST, List.of("данные"));
        InputStream sb = new ByteArrayInputStream("5\nsix\n".getBytes());
        PrintStream ps = new PrintStream(new ByteArrayOutputStream());
        Player player = new Player(sb, ps);
        GameLoop game = new GameLoop(player);
        try {
            game.initGame(categoris);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }   
    }

    // Прогоняем игру с нуля до победы один раз. 
    @Test
    public void Test2() {
        HashMap<Category, List<String>> categoris = new HashMap<>();
        categoris.put(Category.FIRST, List.of("программа"));
        InputStream sb = new ByteArrayInputStream("5\nfrist\nп\nр\nо\nг\nр\nа\nм\nм\nа\n".getBytes());
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bytes);

        Player player = new Player(sb, ps);
        GameLoop game = new GameLoop(player);
        game.initGame(categoris);
        game.nextGame();
        ps.flush();
        Assert.assertEquals("Текущее слово:\n" + //
                        "п********\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "пр**р****\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "про*р****\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "прогр****\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "прогр****\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "програ**а\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "программа\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "вы выиграли!!!\n" + //
                        "" , bytes.toString());
    }

    // Регистрозависимость
    @Test
    public void Test3() {
        HashMap<Category, List<String>> categoris = new HashMap<>();
        categoris.put(Category.FIRST, List.of("программа"));
        InputStream sb = new ByteArrayInputStream("5\nfrist\nП\nР\nО\nГ\nР\nА\nМ\nМ\nА\n".getBytes());
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bytes);

        Player player = new Player(sb, ps);
        GameLoop game = new GameLoop(player);
        game.initGame(categoris);
        game.nextGame();
        ps.flush();
        Assert.assertEquals("Текущее слово:\n" + //
                        "п********\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "пр**р****\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "про*р****\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "прогр****\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "прогр****\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "програ**а\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "программа\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "вы выиграли!!!\n" + //
                        "" , bytes.toString());
    }

    // Прогоняем игру с нуля до поражения один раз. 
    @Test
    public void Test5() {
        HashMap<Category, List<String>> categoris = new HashMap<>();
        categoris.put(Category.FIRST, List.of("программа"));
        InputStream sb = new ByteArrayInputStream("5\nfrist\nс\nс\nс\nс\nс\nс\nс\nс\nс\nс\n".getBytes());
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bytes);

        Player player = new Player(sb, ps);
        GameLoop game = new GameLoop(player);
        game.initGame(categoris);
        game.nextGame();
        ps.flush();
        System.out.println(bytes.toString());
        Assert.assertEquals("Текущее слово:\n" + //
                        "*********\n" + //
                        "количество возможных ошибок:\n" + //
                        "4\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|   |\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "*********\n" + //
                        "количество возможных ошибок:\n" + //
                        "3\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|   |\n" + //
                        "|   |\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "*********\n" + //
                        "количество возможных ошибок:\n" + //
                        "2\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|   |\n" + //
                        "|   |\n" + //
                        "|   |\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "*********\n" + //
                        "количество возможных ошибок:\n" + //
                        "1\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|   |\n" + //
                        "|   |\n" + //
                        "|   |\n" + //
                        "|   |\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "*********\n" + //
                        "количество возможных ошибок:\n" + //
                        "0\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|   |\n" + //
                        "|   |\n" + //
                        "|   |\n" + //
                        "|   |\n" + //
                        "|   |\n" + //
                        "|    0\n" + //
                        "|   /|\\\n" + //
                        "|    |\n" + //
                        "|   / \\\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "вы проиграли!!!\n" + //
                        "", bytes.toString());
    }

    // При опечатках не изменяются данные
    @Test
    public void Test6() {
        HashMap<Category, List<String>> categoris = new HashMap<>();
        categoris.put(Category.FIRST, List.of("программа"));
        InputStream sb = new ByteArrayInputStream("5\nfrist\nп\nп\nп\nр\nо\nг\nр\nа\nм\nм\nа\n".getBytes());
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bytes);
        Player player = new Player(sb, ps);
        GameLoop game = new GameLoop(player);
        game.initGame(categoris);
        game.nextGame();
        System.out.println(bytes.toString());
        Assert.assertEquals("Текущее слово:\n" + //
                        "п********\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "п********\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "п********\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "пр**р****\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "про*р****\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "прогр****\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "прогр****\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "програ**а\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "Текущее слово:\n" + //
                        "программа\n" + //
                        "количество возможных ошибок:\n" + //
                        "5\n" + //
                        "До вашей смерти.....\n" + //
                        "___\n" + //
                        "|\n" + //
                        "|\n" + //
                        "|\n" + //
                        "| __\n" + //
                        "вы выиграли!!!\n" + //
                        "" , bytes.toString());
    }
}