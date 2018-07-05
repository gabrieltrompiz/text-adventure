package com.gatc.txtadv;

abstract class Periquitos implements Character {

    private Character character;

    public Periquitos() {}
    public Periquitos(Character character){ this.character = character; }

    @Override
    public void setup(){ character.setup(); }
}
