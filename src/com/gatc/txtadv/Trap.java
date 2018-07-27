package com.gatc.txtadv;

public class Trap {
    private String needed;

    public Trap(String needed) {
        this.needed = needed;
    }

    public String getNeeded() { return this.needed; }
    public void found() {
        if(needed.equalsIgnoreCase("bombs")) {
            System.out.println("Found a blocked cave. You need bombs to keep going this way.");
        }
        if(needed.equalsIgnoreCase("sand rod")) {
            System.out.println("There's sand blocking the road. You need a sand rod to keep going this way.");
        }
        if(needed.equalsIgnoreCase("arrow")) {
            System.out.println("The path is closed. There are eye targets. You need to shoot them with arrows to keep going.");
        }
        if(needed.equalsIgnoreCase("boomerang")) {
            System.out.println("You must hit various targets at the same time. You need a boomerang to keep going");
        }
    }
}
