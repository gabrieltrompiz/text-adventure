package com.gatc.txtadv;

public interface Character extends Visitor {
    void setup();
    int getCurrentHitpoints();
    Armor getCurrentArmor();
    Weapon getCurrentWeapon();
    void addToInventory(Object object);
    void showInventory();
    void visit(Box box);
}