package com.gatc.txtadv;

public class Consumable {
    private int quantity;
    private String type;

    public Consumable(String type, int uses) {
        this.type = type;
        this.quantity = uses;
    }

    public Character use(Character character, int max) {
        if(this.quantity == 0) { return character; }
        if(type.equalsIgnoreCase("potion")) {
            if(character.getCurrentHitpoints() < max) {
                if(character.getCurrentHitpoints() + 4 >= max) { character.setCurrentHp(max); }
                else { character.setCurrentHp(character.getCurrentHitpoints() + 4); }
            }
        }
        this.setQuantity(this.getQuantity() - 1);
        return character;
    }
    public void use() {
        if (this.quantity == 0) { return; }
        this.setQuantity(this.getQuantity() - 1);
    }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public int getQuantity() { return this.quantity; }

    public String getType() { return this.type; }

    public void found() {
        System.out.println("Found " + this.quantity + " " + Colors.green + this.type.toUpperCase() + "(s) " + Colors.black);
    }

    @Override
    public String toString() {
        return Colors.black + this.type.toUpperCase();
    }
}
