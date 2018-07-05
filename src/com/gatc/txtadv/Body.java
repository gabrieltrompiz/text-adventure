package com.gatc.txtadv;

public class Body implements Character {
    private int hitpoints;

    public Body(int hitpoints){
        this.hitpoints = hitpoints;
    }

    @Override
    public void setup() {
        System.out.println("Initial hp: " + this.hitpoints);
    }
}
