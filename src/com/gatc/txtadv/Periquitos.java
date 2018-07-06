package com.gatc.txtadv;

abstract class Periquitos implements Character {

    private Character character;

    public Periquitos() {}
    public Periquitos(Character character){ this.character = character; }

    public abstract int getHitpoints();
    public abstract String getQuality();
    public abstract int  getAD();
    public abstract double getAS();

    @Override
    public void setup(){ character.setup(); }
}
