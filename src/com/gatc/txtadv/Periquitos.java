package com.gatc.txtadv;

abstract class Periquitos implements Character, Visitor {

    private Character character;

    public Periquitos() {}
    public Periquitos(Character character){ this.character = character; }

    public abstract int getHitpoints();
    public abstract String getName();
    public abstract int  getAD();
    public abstract Character equipOn(Character character);
    public abstract Character unequipOn(Character character);
    public String getMe() {
        return this.getClass().getSimpleName();
    }
    public abstract void found();

    @Override
    public Character visit(Box box, Character character) { return this.character.visit(box, character); }
    @Override
    public void addToInventory(Object object) { character.addToInventory(object); }
    @Override
    public Character showInventory(Character character) { return this.character.showInventory(character); }
    @Override
    public Weapon getCurrentWeapon() { return character.getCurrentWeapon(); }
    @Override
    public Armor getCurrentArmor() { return character.getCurrentArmor(); }
    @Override
    public int getCurrentHitpoints() { return character.getCurrentHitpoints(); }
    @Override
    public void setCurrentHp(int hp) { character.setCurrentHp(hp); }
    @Override
    public int getTriforce() { return character.getTriforce(); }
    @Override
    public int getRupees() { return character.getRupees(); }
}
