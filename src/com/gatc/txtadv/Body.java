package com.gatc.txtadv;

public class Body implements Character {
    private int hitpoints;

    public Body(int hitpoints){
        this.hitpoints = hitpoints;
    }

    @Override
    public int getCurrentHitpoints() { return this.hitpoints; }

    @Override
    public void setup() {
        System.out.println("Current HP: " + this.hitpoints);
    }
}
