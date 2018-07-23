package com.gatc.txtadv;

public class Triforce {

    private String type;

    public Triforce(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return Colors.yellow + "Triforce of " + this.type + Colors.black;
    }
}
