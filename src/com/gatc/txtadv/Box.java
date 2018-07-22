package com.gatc.txtadv;

public class Box implements Visitee {

    private Periquitos armor, weapon;
    private Monster monster;

    public Box(Periquitos armor, Periquitos weapon, Monster monster) {
        this.armor = armor;
        this.weapon = weapon;
        this.monster = monster;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public Periquitos getArmor() { return this.armor; }
    public Periquitos getWeapon() { return this.weapon; }
    public Monster getMonster() { return this.monster; }

    public void setArmor(Periquitos armor) { this.armor = armor; }
    public void setWeapon(Periquitos weapon) { this.weapon = weapon; }
    public void setMonster(Monster monster) { this.monster = monster; }
}
