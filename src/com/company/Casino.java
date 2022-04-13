package com.company;

import java.util.Scanner;

public class Casino {
    public static void main (String[]arg) {
        System.out.println("Привет! Для входа в казино укажи свой возраст:");
        Scanner keyboard = new Scanner(System.in);
        int age = keyboard.nextInt();
        keyboard.nextLine();
        if (age < 18) {
            System.out.println("Извини, несовершеннолетним в казино нельзя.");
        } else if (age > 90) {
            System.out.println("Извини, в таком пожилом возрасте нельзя играть в казино. ");
        } else if (age >= 18 || age <= 90) {
            System.out.println("Отлично!Давай знакомиться! Укажи имя:");
        String userName = keyboard.nextLine();
            System.out.println("Приятно познакомиться! " + userName);
            System.out.println("Последний вопрос! Укажи свой пол (М/Ж):");
        String sex = keyboard.nextLine();
            System.out.println("Добро пожаловать, " + userName + "!");
            System.out.println("Нажми Enter для того, чтобы сесть за виртуальный стол!");
            keyboard.nextLine();
            System.out.println("Отлично, вот ты и за столом! " + "\nТеперь, нужно выбрать количество оппонентов от 2 до 5:");
            int players = keyboard.nextInt();
            switch (players) {
                case (1):
                    System.out.println("Ты играешь против одного игрока");
                    break;
                case (2):
                    System.out.println("Ты играешь против двух игроков");
                    break;
                case (3):
                    System.out.println("Ты играешь против трех игроков");
                    break;
                case (4):
                    System.out.println("Ты играешь против четырех игроков");
                    break;
                case (5):
                    System.out.println("Ты играешь против пяти игроков");
                    break;
            }

            System.out.println("Познакомься с ними:\n" + );
            }
        }

    }

