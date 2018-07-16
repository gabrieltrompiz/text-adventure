package com.gatc.txtadv;

abstract class Periquitos implements Character {

    private Character character;

    public Periquitos() {}
    public Periquitos(Character character){ this.character = character; }

    public abstract int getHitpoints();
    public abstract String getQuality();
    public abstract int  getAD();
    public abstract double getAS();
    public abstract Character equipOn(Character character);
    public abstract Character unequipOn(Character character);
    public String getMe() {
        return this.getClass().getSimpleName();
    }

    @Override
    public int getCurrentHitpoints() { return character.getCurrentHitpoints(); }
    @Override
    public void setup(){ character.setup(); }
}
