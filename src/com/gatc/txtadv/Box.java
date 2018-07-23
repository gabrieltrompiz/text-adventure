package com.gatc.txtadv;

public class Box implements Visitee {

    private Periquitos armor, weapon;
    private Monster monster;
    private Triforce triforce;

    public Box(Periquitos armor, Periquitos weapon, Monster monster, Triforce triforce) {
        this.armor = armor;
        this.weapon = weapon;
        this.monster = monster;
        this.triforce = triforce;
    }

    @Override
    public Character accept(Visitor v) {
        return v.visit(this, (Character) v);
    }

    public Periquitos getArmor() { return this.armor; }
    public Periquitos getWeapon() { return this.weapon; }
    public Monster getMonster() { return this.monster; }
    public Triforce getTriforce() { return  this.triforce; }

    public void setArmor(Periquitos armor) { this.armor = armor; }
    public void setWeapon(Periquitos weapon) { this.weapon = weapon; }
    public void setMonster(Monster monster) { this.monster = monster; }

}
