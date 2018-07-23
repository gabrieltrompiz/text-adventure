package com.gatc.txtadv;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Game {
    private Character character;
    private String name;
    private int myRupees, positionX, positionY, level;
    private Box currentBox, prevBox;
    private String[] menu;
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
        System.out.println("What should I call you?");
        name = sc.nextLine();
        System.out.println(Colors.black + "The story begins with a young Hylian boy named " + this.name + " that is 10 years old and lives in a village inhabited by children \n" +
                "that are watched over by the great Deku tree. " + this.name + " discovers the Deku tree is going to die and in his final moments tells " + this.name + " about an Evil man \n" +
                "from the Desert who cast a spell on him. " + this.name + " then leaves the village and meets Princess Zelda. She tells him that a man named Ganon is planning to destroy \n" +
                "Hyrule, and that " + this.name + " must find the three spiritual stones, which hold time in place. \n\n");
    }

    public void start() {
        String[] fixedMenu = new String[6];
        do {
            Map map = Map.getInstance(level);
            currentBox = map.getBox(positionX, positionY);
            prevBox = currentBox;
            character = currentBox.accept(character);
            if(character.getCurrentHitpoints() > 0) {
                System.out.println("Current health: " + Colors.red  + character.getCurrentHitpoints() / 4.0 + " hearts." + Colors.black);
                System.out.println("What do you want to do, " + this.name + "?");
                menu = getMenu();
                int fixed = 0;
                for (int i = 0; i < menu.length; i++) {
                    if (menu[i] != null) {
                        System.out.println(fixed + ". " + menu[i] + ".");
                        fixedMenu[fixed] = menu[i];
                        fixed++;
                    }
                }
                for (int i = 0; i < fixedMenu.length; i++) {
                    if (fixedMenu[i] == null) {
                        fixedMenu[i] = "empty";
                    }
                }
                int option = sc.nextInt();
                switch (fixedMenu[option].toLowerCase()) {
                    case "go forward":
                        System.out.println("You moved forward. \n");
                        positionY++;
                        break;

                    case "go backwards":
                        System.out.println("You moved backwards. \n");
                        positionY--;
                        break;

                    case "go left":
                        System.out.println("You moved to the left. \n");
                        positionX--;
                        break;

                    case "go right":
                        System.out.println("You moved to the right. \n");
                        positionX++;
                        break;

                    case "see inventory":
                        character = character.showInventory(character);
                        break;

                    case "exit":
                        System.exit(0);

                    default:
                        System.out.println("C'mmon " + this.name + ", you are better than this, select a valid option.");
                        break;
                }
            }
            else {
                isGameOver = true;
            }
        }while(!isGameOver);
        sc.close();
    }

    public boolean canIGoLeft() {
        Map map = Map.getInstance(level);
        try {
            map.getBox(positionX - 1, positionY);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public boolean canIGoRight() {
        Map map = Map.getInstance(level);
        try {
            map.getBox(positionX + 1, positionY);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public boolean canIGoForward() {
        Map map = Map.getInstance(level);
        try {
            map.getBox(positionX, positionY + 1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public boolean canIGoBackwards() {
        Map map = Map.getInstance(level);
        try {
            map.getBox(positionX, positionY - 1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public String[] getMenu() {
        String[] menuHelper = new String[6];
        menuHelper[1] = canIGoForward() ? "Go forward" : null;
        menuHelper[2] = canIGoBackwards() ? "Go backwards" : null;
        menuHelper[3] = canIGoLeft() ? "Go left" : null;
        menuHelper[4] = canIGoRight() ? "Go right" : null;
        menuHelper[5] = "See inventory";
        menuHelper[0] = "Exit";
        return menuHelper;
    }
}
