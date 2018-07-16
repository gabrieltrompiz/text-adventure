package com.gatc.txtadv;

public class Boxes {

    public boolean foundNpc, foundMonster, foundBoss, foundArmor, foundWeapon, foundConsumable, foundTrap;
    public Periquitos armor, weapon;

    public Boxes(boolean foundNpc, boolean foundMonster, boolean foundBoss, boolean foundArmor, boolean foundWeapon, boolean foundConsumable, boolean foundTrap) {
        this.foundNpc = foundNpc;
        this.foundMonster = foundMonster;
        this.foundBoss = foundBoss;
        this.foundArmor = foundArmor;
        this.foundWeapon = foundWeapon;
        this.foundConsumable = foundConsumable;
        this.foundTrap = foundTrap;
    }

    public void getBoxContext() {
        if(this.foundArmor) {
            this.armor = PeriquitosFactory.getPeriquito("armor");
        }
        if(this.foundWeapon) {
            this.weapon = PeriquitosFactory.getPeriquito("weapon");
        }
    }

    public Periquitos getArmor() { return this.armor; }
    public Periquitos getWeapon() { return this.weapon; }
}
