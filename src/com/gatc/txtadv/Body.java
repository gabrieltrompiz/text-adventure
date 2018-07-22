package com.gatc.txtadv;

import java.util.List;
import java.util.Vector;

public class Body implements Character {
    private int hitpoints;
    private List<Object> inventory = new Vector<>();

    public Body(int hitpoints){
        this.hitpoints = hitpoints;
    }

    @Override
    public void addToInventory(Object obj) {
        this.inventory.add(obj);
    }

    @Override
    public void showInventory(){
        System.out.println(Colors.white + "=== INVENTORY ===" + Colors.reset);
        for(Object obj : inventory) {
            System.out.println(obj);
        }
    }

    public void visit(Box box) {

    }

    @Override
    public Armor getCurrentArmor() { return null; }

    @Override
    public Weapon getCurrentWeapon() { return null; }

    @Override
    public int getCurrentHitpoints() { return this.hitpoints; }

    @Override
    public void setup() {
        System.out.println(Colors.black + "Current HP: " + Colors.red + this.hitpoints / 4.0 + " hearts." + Colors.reset);
    }
}
