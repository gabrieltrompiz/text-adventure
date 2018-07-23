package com.gatc.txtadv;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Body implements Character {
    private int hitpoints;
    private Scanner sc = new Scanner(System.in);
    private Scanner sc2 = new Scanner(System.in);
    private Armor equippedArmor;
    private Weapon equippedWeapon;
    private List<Armor> armorInventory = new Vector<>();
    private List<Weapon> weaponInventory = new Vector<>();

    public Body(int hitpoints){
        this.hitpoints = hitpoints;
        this.equippedWeapon = new Weapon(1, "Fists");
        this.equippedArmor = new Armor(0, "Body");
    }

    @Override
    public void addToInventory(Object obj) {
        if(obj.getClass().getSimpleName().equalsIgnoreCase("armor")) {
            this.armorInventory.add((Armor) obj);
        }
        else if(obj.getClass().getSimpleName().equalsIgnoreCase("weapon")) {
            this.weaponInventory.add((Weapon) obj);
        }
    }

    @Override
    public Character showInventory(Character character){
        System.out.println(Colors.white + "=== INVENTORY ===" + Colors.black);
        System.out.println("+++ Armors [" + this.armorInventory.size() + "] +++");
        for (Armor armor : armorInventory) {
            System.out.print(armor);
            if(armor.getHitpoints() == 0) { System.out.print(" (BROKEN)"); }
            if(armor == equippedArmor) { System.out.print(" (EQUIPPED)"); }
            System.out.print("\n");
        }
        System.out.println("\n+++ Weapons [" + this.weaponInventory.size() + "] +++");
        for (Weapon weapon : weaponInventory) {
            System.out.print(weapon);
            if(weapon == equippedWeapon) { System.out.print(" (EQUIPPED)"); }
            System.out.print("\n");
        }
        System.out.println(Colors.white + "=== INVENTORY ===" + Colors.black);
        if (weaponInventory.size() > 0 || armorInventory.size() > 0) {
            System.out.println("What do you want to do?");
            System.out.println("1. Change armor.");
            System.out.println("2. Change weapon.");
            System.out.println("Any character. Go back.");
            int option = sc2.nextInt();
            if (option == 1) {
                System.out.println("What armor do you wish to equip?");
                for (Armor armor : armorInventory) {
                    System.out.print(armorInventory.indexOf(armor) + 1 + ". " + armor);
                    if(armor.getHitpoints() == 0) { System.out.print(" (BROKEN)"); }
                    if (armor == equippedArmor) { System.out.print(" (EQUIPPED)"); }
                    System.out.print("\n");
                }
                option = sc2.nextInt();
                try {
                    equippedArmor = armorInventory.get(option - 1);
                    character = equippedArmor.equipOn(character);
                } catch (Exception e) {
                    System.out.println("Invalid armor option.");
                }
            } else if (option == 2) {
                System.out.println("What weapon do you wish to equip?");
                for (Weapon weapon : weaponInventory) {
                    System.out.print(weaponInventory.indexOf(weapon) + 1 + ". " + weapon);
                    if (weapon == equippedWeapon) {
                        System.out.print(" (EQUIPPED)");
                    }
                    System.out.print("\n");
                }
                option = sc2.nextInt();
                try {
                    equippedWeapon = weaponInventory.get(option - 1);
                    character = equippedWeapon.equipOn(character);
                } catch (Exception e) {
                    System.out.println("Invalid weapon option.");
                }
            }
        }
        return character;
    }

    public Character visit(Box box, Character character) {
        if(box.getArmor() != null) {
            box.getArmor().found();
            char option = sc.nextLine().charAt(0);
            if (option == 'y') {
                addToInventory(box.getArmor());
                if(armorInventory.size() == 1) {
                    setEquippedArmor((Armor) box.getArmor());
                    character = box.getArmor().equipOn(character);
                }
                box.setArmor(null);
            }
        }
        if(box.getWeapon() != null) {
            box.getWeapon().found();
            sc.reset();
            char option = sc.nextLine().charAt(0);
            if(option == 'y') {
                addToInventory(box.getWeapon());
                if(weaponInventory.size() == 1) {
                    setEquippedWeapon((Weapon) box.getWeapon());
                    character = box.getWeapon().equipOn(this);
                }
                box.setWeapon(null);
            }
        }
        if(box.getMonster() != null) {
            box.getMonster().found();
            character = this.fight(character, box.getMonster());
            box.setMonster(null);
        }
        if(box.getArmor() == null && box.getWeapon() == null && box.getMonster() == null) {
            System.out.println("There's nothing here. We should keep going.");
        }
        return character;
    }

    public Character fight(Character character, Monster monster) {
        double mitigated = 0;
        double received = 0;
        double done = 0;
        do {
            monster.setHp(monster.getHp() - equippedWeapon.getAD());
            done += equippedWeapon.getAD() / 4.0;
            if (monster.getHp() > 0) {
                if (equippedArmor.getHitpoints() > 0) {
                    equippedArmor.setArmorHitpoints(equippedArmor.getHitpoints() - monster.getAd());
                    mitigated += monster.getAd() / 4.0;
                    if (equippedArmor.getHitpoints() - monster.getAd() < 0) {
                        character.setCurrentHp(character.getCurrentHitpoints() + equippedArmor.getHitpoints());
                        equippedArmor.setArmorHitpoints(0);
                    }
                }
                else {
                    character.setCurrentHp(character.getCurrentHitpoints() - monster.getAd());
                    received += monster.getAd() / 4.0;
                }
            }
        }while(monster.getHp() > 0);
        if(character.getCurrentHitpoints() > 0) {
            System.out.println("You killed the monster. Lost " + Colors.red + received + Colors.black + " health. Mitigated " +
                    Colors.cyan + mitigated + Colors.black + " with armor. Done " + Colors.green + done + Colors.black + " damage to monster. \n");
        }
        else {
            System.out.println("You died! Lost " + Colors.red + received + Colors.black + " health. GG!");
        }
        return character;
    }

    public void setEquippedArmor(Armor armor) { this.equippedArmor = armor; }
    public void setEquippedWeapon(Weapon weapon) { this.equippedWeapon = weapon; }

    @Override
    public Armor getCurrentArmor() { return null; }

    @Override
    public Weapon getCurrentWeapon() { return null; }

    @Override
    public int getCurrentHitpoints() { return this.hitpoints; }

    @Override
    public void setCurrentHp(int hp) { this.hitpoints = hp; }
}
