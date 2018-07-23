package com.gatc.txtadv;

public class Monster {
    private int hp, ad, rupees, level;
    private Integer[] rupeesOpt = {1, 5, 20, 50, 100};

    public Monster(int level) {
        this.level = level;
        this.hp = 2 * level;
        this.ad = 2 * level;
        this.rupees = rupeesOpt[new Double(Math.floor(Math.random() * rupeesOpt.length)).intValue()];
    }

    public int getHp() { return this.hp; }
    public int getAd() { return this.ad; }
    public int getRupees() { return this.rupees; }

    public void setHp(int hp) { this.hp = hp; }

    public void found() {
        System.out.println("There's a level " + Colors.blue +  this.level + Colors.black + " monster. You must fight with him.");
    }
}
