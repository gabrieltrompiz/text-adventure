package com.gatc.txtadv;

public class Consumable {
    private int quantity;
    private String type;
    private int price;

    public Consumable(String type, int uses) {
        this.type = type;
        this.quantity = uses;
        this.price = type.equalsIgnoreCase("potion") ? 10 : type.equalsIgnoreCase("bomb") ? 5 :
        type.equalsIgnoreCase("arrow") ? 10 : type.equalsIgnoreCase("sand rod") ? 20 : 0;
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
    public int getPrice() { return this.price; }

    public String getType() { return this.type; }

    public void found() {
        System.out.println("Found " + this.quantity + " " + Colors.green + this.type.toUpperCase() + "(s) " + Colors.black);
    }

    @Override
    public String toString() {
        return Colors.black + this.type.toUpperCase();
    }
}
