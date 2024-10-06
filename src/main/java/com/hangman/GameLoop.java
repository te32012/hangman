package com.hangman;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GameLoop {
    private Game game;
    private Player player;

    public Game getGame() {
        return game;
    }

    public GameLoop(Player player) {
        this.player = player;
    }

    public void initGame(HashMap<Category, List<String>> categoris) {
        Random random = new Random();
        int level = player.getLevel();
        if (level == -1) {
            level = random.nextInt(10) + 3;
        }
        Category cat = player.getCategory();
        if (cat == Category.NONE) {
            switch (random.nextInt(categoris.size())) {
                case 0:
                    cat = Category.FIRST;
                    break;
                case 1:
                    cat = Category.SECOND;
                    break;
                case 2:
                    cat = Category.THIRD;
                    break;
                default:
                    cat = Category.FIRST;
                    break;
            }
        }
        int z = random.nextInt(categoris.size()) % categoris.size();
        var tmp = categoris.get(cat);
        String wd = tmp.get(z);
        HashMap<String, List<Integer>> word = new HashMap<>();
        for (int i = 0; i < wd.length(); i++) {
            List<Integer> t = word.get(String.valueOf(wd.charAt(i)));
            if (t == null) {
                ArrayList<Integer> y = new ArrayList<Integer>();
                y.add(Integer.valueOf(i));
                word.put(String.valueOf(wd.charAt(i)), y);
            } else {
                t.add(Integer.valueOf(i));
                word.put(String.valueOf(wd.charAt(i)), t);
            }
        }
        String x = "";
        for (int i = 0; i < wd.length(); i++) {
            x = x + "*";
        }

        this.game = new Game(x, word, level);
    }

    public void nextGame() {
        while (game.hashStep()) {
            String tmp = player.getLetter();
            while (tmp == null || tmp.length() == 0) {
                tmp = player.getLetter();
            }

            game.nextStep(tmp);
            player.print("Текущее слово:");
            player.print(game.printWord());
            player.print("количество возможных ошибок:");
            player.print(game.countError());
            player.print("До вашей смерти.....");
            player.print(game.printHangman());
        }
        if (game.printWord().contains("*")) {
            player.print("вы проиграли!!!");
        } else {
            player.print("вы выиграли!!!");
        }
    }
}
