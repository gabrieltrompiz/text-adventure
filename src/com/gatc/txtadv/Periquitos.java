package com.gatc.txtadv;

abstract class Periquitos implements Character, Visitor {

    private Character character;

    public Periquitos() {}
    public Periquitos(Character character){ this.character = character; }

    public abstract int getHitpoints();
    public abstract String getQuality();
    public abstract int  getAD();
    public abstract Character equipOn(Character character);
    public abstract Character unequipOn(Character character);
    public String getMe() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void visit(Box box) { character.visit(box); }
    @Override
    public void addToInventory(Object object) { character.addToInventory(object); }
    @Override
    public void showInventory() { character.showInventory(); }
    @Override
    public Weapon getCurrentWeapon() { return character.getCurrentWeapon(); }
    @Override
    public Armor getCurrentArmor() { return character.getCurrentArmor(); }
    @Override
    public int getCurrentHitpoints() { return character.getCurrentHitpoints(); }
    @Override
    public void setup(){ character.setup(); }
}
