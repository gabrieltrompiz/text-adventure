package com.gatc.txtadv;

import java.util.Scanner;

public class Game {
    private Character character;
    private String name;
    private int myRupees, positionX, positionY, level;
    private Box currentBox;
    private boolean isGameOver;
    private Scanner sc = new Scanner(System.in);

    public Game() {
        this.character = new Body(12);
        this.positionX = 0;
        this.positionY = 0;
        this.myRupees = 0;
        this.level = 1;
        this.isGameOver = false;
        this.showLore();
    }

    public void showLore() {
        System.out.println(Colors.black + "LORE");
        System.out.println("What should I call you?");
        name = sc.nextLine();
    }

    public void start() {
        do {
            Map map = Map.getInstance(level);
            currentBox = map.getBox(positionX, positionY);
            System.out.println("\nWhat do you want to do, " + this.name + "?");
            System.out.println("1. Go left.");
            System.out.println("2. Go right.");
            System.out.println("3. Go forward.");
            System.out.println("4. Go backwards.");
            System.out.println("5. See inventory.");
            if(currentBox.getArmor() != null){
                System.out.println("6. Grab armor.");
            }
            if(currentBox.getWeapon() != null) {
                System.out.println("7. Grab weapon.");
            }
            System.out.println("0. Exit.");
            int option = sc.nextInt();
            switch(option) {
                case 1:
                    try {
                        map.getBox(positionX - 1, positionY);
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Bump! Can't go there.");
                        break;
                    }
                    positionX--;
                    break;

                case 2:
                    try {
                        map.getBox(positionX + 1, positionY);
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Bump! Can't go there.");
                        break;
                    }
                    positionX++;
                    break;

                case 3:
                    try {
                        map.getBox(positionX, positionY + 1);
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Bump! Can't go there.");
                        break;
                    }
                    positionY++;
                    break;

                case 4:
                    try {
                        map.getBox(positionX, positionY - 1);
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Bump! Can't go there");
                        break;
                    }
                    positionY--;
                    break;

                case 5:
                    character.showInventory();
                    break;

                case 0:
                    System.exit(0);
            }
        }while(!isGameOver);
        sc.close();
    }
}
