package com.gatc.txtadv;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        char option;
        Scanner sc = new Scanner(System.in);

        Character character = new Body(100);

        Boxes box = new Boxes(false,false, false, true, true, false, false);
        box.getBoxContext();
        System.out.println(box.getArmor());
        option = sc.nextLine().charAt(0);
        if(option == 'y') {
            character = box.getArmor().equipOn(character);
        }
        System.out.println(box.getWeapon());
        option = sc.nextLine().charAt(0);
        if(option == 'y') {
            character = box.getWeapon().equipOn(character);
        }
        character.setup();
        sc.close();
    }
}
