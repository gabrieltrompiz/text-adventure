package com.gatc.txtadv;

public class Triforce {

    private String type;

    public Triforce(String type) {
        this.type = type;
    }

    public void found() {
        System.out.println(Colors.yellow + "Found Triforce of " + this.type + "! We're one step closer to stopping Ganon." + Colors.black);
        System.out.println("Heading now to the next level.");
    }
    @Override
    public String toString() {
        return Colors.yellow + "Triforce of " + this.type + Colors.black;
    }
}
