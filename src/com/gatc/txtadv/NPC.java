package com.gatc.txtadv;

import jdk.nashorn.internal.runtime.arrays.ArrayIndex;

import javax.lang.model.type.ArrayType;
import java.util.List;
import java.util.Vector;

public class NPC {
    private List<Consumable> stock = new Vector<>();

    public NPC() {
        this.initialize();
    }

    public boolean canIBuy(Consumable consumable, int characterRupees) {
        if(consumable.getPrice() <= characterRupees) {
            return true;
        }
        return false;
    }

    public Consumable getConsumable(int i) {
        try {
            return stock.get(i);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public void initialize() {
        stock.add(new Consumable("potion", 1));
        stock.add(new Consumable("bomb", 1));
        stock.add(new Consumable("arrow", 1));
        stock.add(new Consumable("sand rod", 1));
    }

    public void showStock() {
        System.out.println(Colors.white + "=== STOCK ===" + Colors.black);
        for (Consumable consumable : stock) {
            System.out.println(stock.indexOf(consumable) + 1 + ". " + consumable + " (PRICE: " + consumable.getPrice() + ")");
        }
        System.out.println("0. Go back");
        System.out.println(Colors.white + "=== STOCK ===" + Colors.black);
    }
}
