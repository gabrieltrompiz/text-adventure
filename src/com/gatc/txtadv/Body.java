package com.gatc.txtadv;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Body implements Character {
    private int hitpoints, maxHitpoints, rupees;
    private Scanner sc = new Scanner(System.in);
    private Scanner sc2 = new Scanner(System.in);
    private Armor equippedArmor;
    private Weapon equippedWeapon;
    private List<Triforce> triforcePieces = new Vector<>();
    private List<Armor> armorInventory = new Vector<>();
    private List<Weapon> weaponInventory = new Vector<>();
    private List<Consumable> consumableInventory = new Vector<>();

    public Body(int hitpoints){
        this.hitpoints = hitpoints;
        this.maxHitpoints = 12;
        this.rupees = 0;
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
        System.out.println("Rupees: " + Colors.yellow + this.rupees + Colors.black);
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
        System.out.println("\n+++ Triforce Pieces [" + this.triforcePieces.size() + "/3] +++");
        for (Triforce triforce : triforcePieces) {
            System.out.print(Colors.yellow + triforce);
            System.out.print(Colors.black + "\n");
        }
        System.out.println("\n+++ Consumables [" + this.consumableInventory.size() + "] +++");
        for (Consumable consumable : consumableInventory) {
            System.out.print(consumable + " (" + consumable.getQuantity() + ") ");
            System.out.print("\n");
        }
        System.out.println(Colors.white + "=== INVENTORY ===" + Colors.black);
        if (weaponInventory.size() > 0 || armorInventory.size() > 0 || consumableInventory.size() > 0) {
            System.out.println("What do you want to do?");
            System.out.println("1. Change armor.");
            System.out.println("2. Change weapon.");
            System.out.println("3. Use consumable.");
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
            } else if (option == 3) {
                System.out.println("What consumable do you want to use?");
                for (Consumable consumable : consumableInventory) {
                    System.out.print(consumableInventory.indexOf(consumable) + 1 + ". " + consumable + " (" + consumable.getQuantity() + ") ");
                    System.out.print("\n");
                }
                option = sc2.nextInt();
                try {
                    if (consumableInventory.get(option - 1).getType().equalsIgnoreCase("potion")) {
                        character = consumableInventory.get(option - 1).use(character, maxHitpoints);
                    }
                }
                catch (Exception e) {
                    System.out.println("Invalid consumable option.");
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
                    character = box.getWeapon().equipOn(character);
                }
                box.setWeapon(null);
            }
        }
        if(box.getMonster() != null) {
            box.getMonster().found();
            character = this.fight(character, box.getMonster());
            box.setMonster(null);
        }
        if(box.getConsumable() != null) {
            box.getConsumable().found();
            if(consumableInventory.indexOf(box.getConsumable()) < 0) {
                consumableInventory.add(box.getConsumable());
            }
            else {
                consumableInventory.get(consumableInventory.indexOf(box.getConsumable())).
                setQuantity(consumableInventory.get(consumableInventory.indexOf(box.getConsumable())).getQuantity() + box.getConsumable().getQuantity());
            }
            box.setConsumable(null);
        }
        if(box.getTriforce() != null) {
            box.getTriforce().found();
            triforcePieces.add(box.getTriforce());
            this.maxHitpoints += 8;
            character.setCurrentHp(this.maxHitpoints);
        }
        if(box.getTrap() != null) {
            box.getTrap().found();
            for (Consumable consumable : consumableInventory) {
                if(box.getTrap() != null) {
                    if (consumable.getType().equalsIgnoreCase(box.getTrap().getNeeded()) && consumable.getQuantity() > 0) {
                        System.out.println("Want to use consumable? (y/n)");
                        char option = sc.nextLine().charAt(0);
                        if (option == 'y') {
                            consumable.use();
                            box.setTrap(null);
                            break;
                        }
                        else {
                            character.setCurrentHp(character.getCurrentHitpoints() - 4);
                            System.out.println("Lost " + Colors.red + "1 heart due to the trap." + Colors.black);
                            box.setTrap(null);
                            break;
                        }
                    }
                }
            }
            if(box.getTrap() != null) {
                character.setCurrentHp(character.getCurrentHitpoints() - 4);
                System.out.println("Lost " + Colors.red + "1 heart due to the trap." + Colors.black);
                box.setTrap(null);
            }
        }
        if(box.getNpc() != null) {
            Scanner sc3 = new Scanner(System.in);
            System.out.println("There's a marketer. You can talk to him.");
            int opt;
            do {
                box.getNpc().showStock();
                System.out.println("Your rupees: " + Colors.green + this.rupees + Colors.black);
                System.out.println("What do you want to buy?");
                opt = sc3.nextInt();
                if(box.getNpc().getConsumable(opt -1) != null) {
                    if (box.getNpc().canIBuy(box.getNpc().getConsumable(opt - 1), this.rupees)) {
                        consumableInventory.add(box.getNpc().getConsumable(opt - 1));
                        this.rupees -= box.getNpc().getConsumable(opt - 1).getPrice();
                        break;
                    } else {
                        System.out.println("Cannot buy it.");
                    }
                }
                else { break; }
            }while(opt != 0);
        }
        if(box.getArmor() == null && box.getWeapon() == null && box.getMonster() == null && box.getTriforce() == null && box.getNpc() == null) {
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
                } else {
                    character.setCurrentHp(character.getCurrentHitpoints() - monster.getAd());
                    received += monster.getAd() / 4.0;
                }
            }
        } while (monster.getHp() > 0);
        if (character.getCurrentHitpoints() > 0) {
            if (monster.getLevel() <= 3) {
                System.out.println("You killed the monster. Lost " + Colors.red + received + Colors.black + " health. Mitigated " +
                        Colors.cyan + mitigated + Colors.black + " with armor. Done " + Colors.green + done + Colors.black + " damage to monster. \n");
                this.rupees += monster.getRupees();
            }
            else {
                System.out.println("You killed " + Colors.purple + " Ganon" + Colors.black + "! Hyrule is finally free. GG!");
                System.out.println("Lost " + Colors.red + received + Colors.black + " health. Mitigated " +
                Colors.cyan + mitigated + Colors.black + " with armor. Done " + Colors.green + done + Colors.black + " damage to " +
                Colors.purple + "Ganon");
            }
        } else {
            System.out.println("You died! Lost " + Colors.red + received + Colors.black + " health. Mitigated " + Colors.cyan + mitigated + Colors.black + " with armor. GG!");
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

    @Override
    public int getTriforce() { return triforcePieces.size(); }

    @Override
    public int getRupees() { return rupees; }
}
