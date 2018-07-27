package com.gatc.txtadv;

public interface Character extends Visitor {
    int getCurrentHitpoints();
    Armor getCurrentArmor();
    Weapon getCurrentWeapon();
    void addToInventory(Object object);
    Character showInventory(Character character);
    Character visit(Box box, Character character);
    void setCurrentHp(int hp);
    int getTriforce();
    int getRupees();
}