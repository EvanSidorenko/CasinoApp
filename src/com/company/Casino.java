package com.company;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Casino {

    public static void main(String[] arg) {
        System.out.println("Привет! Для входа в казино укажи свой возраст:");
        Scanner keyboard = new Scanner(System.in);

        Player player = new Player();
        player.age = Integer.valueOf(keyboard.nextLine());
        if (player.age < 18) {
            System.out.println("Извини, несовершеннолетним в казино нельзя.");
        } else if (player.age > 90) {
            System.out.println("Извини, в таком пожилом возрасте нельзя играть в казино. ");
        } else if (player.age >= 18 || player.age <= 90) {
            System.out.println("Отлично!Давай знакомиться! Укажи имя:");
            player.name = String.valueOf(keyboard.nextLine());
            System.out.println("Приятно познакомиться! " + player.name);
            System.out.println("Последний вопрос! Укажи свой пол (М/Ж):");
            player.sex = String.valueOf(keyboard.nextLine());
            System.out.println("Добро пожаловать, " + player.name + "!");
            System.out.println("Нажми Enter для того, чтобы сесть за виртуальный стол!");
            keyboard.nextLine();
            System.out.println("Отлично, вот ты и за столом! " + "\nТеперь, нужно выбрать количество оппонентов от 2 до 5:");
        }
        Players players = new Players();
        players.number = Integer.valueOf(keyboard.nextInt());
        if (players.number > 1 & players.number < 6) {
            System.out.println("Ты играешь против " + players.number + " игроков");
            File file = new File("opponents.txt");
            Scanner fileScan = null;

            try {
                fileScan = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.out.println("Файл с опоннентами не считался! Эта бААААААг!");
            }

            String scanOpponents = fileScan.nextLine();
            String[] arrayOpponents = scanOpponents.split(" ");

            List<String> listOpponents = Arrays.asList(arrayOpponents);
            Collections.shuffle(listOpponents);
            ArrayList<String> newOpponents = new ArrayList<>();
            int i = 0;
            while (players.number > i) {
                newOpponents.add(arrayOpponents[i]);
                System.out.println(arrayOpponents[i]);
                i++;
            }

            System.out.println("Отлично! Приступим к первому раунду!");
            System.out.println("В трех раундах каждый участник бросает кубик по одному разу. Ты бросаешь первый.");
            System.out.println("Тап на Enter для броска");
            keyboard.nextLine();

            player.firstRoundResult = (int) Math.round((Math.random() * 100));
            System.out.println("Твой результат " + player.firstRoundResult);

            System.out.println("Теперь очередь бросать у оппонентов. Нажми Enter.");
            keyboard.nextLine();

            ArrayList<Integer> opponentFirstRoundResult = new ArrayList<>();
            int a = 0;
            while (a < players.number) {
                opponentFirstRoundResult.add((int) Math.round(Math.random() * 100));
                System.out.println(newOpponents.get(a) + " получилось в первом раунде: " + opponentFirstRoundResult.get(a));
                a++;
            }

            System.out.println("Второй раунд. Твой бросок. Нажми Enter");
            keyboard.nextLine();
            player.secoundRoundResult = (int) Math.round((Math.random() * 100));
            System.out.println("Твой результат " + player.secoundRoundResult);

            System.out.println("Теперь очередь бросать у оппонентов. Нажми Enter.");
            keyboard.nextLine();

            ArrayList<Integer> opponentSecondRoundResult = new ArrayList<>();
            int b = 0;
            while (b < players.number) {
                opponentSecondRoundResult.add((int) Math.round(Math.random() * 100));
                System.out.println(newOpponents.get(b) + " получилось в втором раунде: " + opponentSecondRoundResult.get(b));
                b++;
            }

            System.out.println("Третий раунд. Твой бросок. Нажми Enter");
            keyboard.nextLine();

            player.thirdRoundResult = (int) Math.round((Math.random() * 100));
            System.out.println("Твой результат " + player.thirdRoundResult);

            System.out.println("Теперь очередь бросать у оппонентов. Нажми Enter.");
            keyboard.nextLine();

            ArrayList<Integer> opponentThirdRoundResult = new ArrayList<>();
            int c = 0;
            while (c < players.number) {
                opponentThirdRoundResult.add((int) Math.round(Math.random() * 100));
                System.out.println(newOpponents.get(c) + " получилось в третьем раунде: " + opponentThirdRoundResult.get(c));
                c++;
            }
            System.out.println("Вот и все! Определяем победителей!");
            System.out.println("Нажми Enter для продолжения");
            keyboard.nextLine();

            player.playerResults = player.firstRoundResult + player.secoundRoundResult + player.thirdRoundResult;
            System.out.println("Твой результат " + player.playerResults);

            ArrayList<Integer> opponentsSummResults = new ArrayList<>();
            int d = 0;
            while (d < players.number) {
                opponentsSummResults.add(d, opponentFirstRoundResult.get(d) + opponentSecondRoundResult.get(d) + opponentThirdRoundResult.get(d));
                System.out.println(newOpponents.get(d) + " результат за три раунда: " + opponentFirstRoundResult.get(d) + "+" + opponentSecondRoundResult.get(d) + "+" + opponentThirdRoundResult.get(d));
                d++;
            }
            int opponentBest = 0;
            int maxResult =  opponentsSummResults.get(opponentBest);
            for (int f = 1; f < players.number; f++ ) {
                if (opponentsSummResults.get(f) > maxResult) {
                    maxResult = opponentsSummResults.get(f);
                    opponentBest = f;
                }
            }

            if (player.playerResults > opponentsSummResults.get(opponentBest)) {
                System.out.println(player.name + ", ты победил! Поздравляем! Твой результат:" + player.playerResults);
            } else {
                System.out.println("Победил(а) " + newOpponents.get(opponentBest)   + " с результатом: " +  opponentsSummResults.get(opponentBest));
            }

        } else {
            System.out.println("Введено неверное количество соперников");
        }
    }
}












