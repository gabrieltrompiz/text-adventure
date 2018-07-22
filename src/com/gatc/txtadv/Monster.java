package com.gatc.txtadv;

public class Monster {
    private int hp, ad, rupees;
    private Integer[] rupeesOpt = {1, 5, 20, 50, 100};

    public Monster(int level) {
        this.hp = 2 * level;
        this.ad = level;
        this.rupees = rupeesOpt[new Double(Math.floor(Math.random() * rupeesOpt.length)).intValue()];
    }

    public int getHp() { return this.hp; }
    public int getAd() { return this.ad; }
    public int getRupees() { return this.rupees; }
}
