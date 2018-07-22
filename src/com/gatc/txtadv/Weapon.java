package com.gatc.txtadv;

public class Weapon extends Periquitos {

    private int attackDmg;
    private String quality;
    private String color;

    public Weapon(int attackDmg, String quality){
        this.attackDmg = attackDmg;
        this.quality = quality;
        this.color = this.quality.equalsIgnoreCase("common") ? Colors.green : this.quality.equalsIgnoreCase("rare")
        ? Colors.blue : this.quality.equalsIgnoreCase("epic") ? Colors.purple : null;
    }

    public Weapon(Character character, int attackDmg, String quality){
        super(character);
        this.attackDmg = attackDmg;
        this.quality = quality;
    }

    public int getHitpoints() { return 0; }
    public String getQuality() { return this.quality; }
    public int getAD(){ return this.attackDmg; }

    public Character equipOn(Character character) {
        character = new Weapon(character, this.getAD(), this.getQuality());
        return character;
    }

    public Character unequipOn(Character character) {
        if(character.getClass().getSimpleName().equalsIgnoreCase("armor")) {
            character = new Armor(new Body(character.getCurrentHitpoints()), ((Armor) character).getHitpoints(), ((Armor) character).getQuality());
            System.out.println("\nUnequipped " + this.getQuality() + " weapon.\n");
        }
        else {
            character = new Body(character.getCurrentHitpoints());
            System.out.println("\nUnequipped " + this.getQuality() + " weapon.\n");
        }
        return character;
    }

    @Override
    public void visit(Box box) {

    }

    public void addToInventory(Object object) { super.addToInventory(object); }
    public void showInventory() { super.showInventory(); }
    public Armor getCurrentArmor() { return super.getCurrentArmor(); }
    public Weapon getCurrentWeapon() { return this; }
    public int getCurrentHitpoints() {
        return super.getCurrentHitpoints();
    }

    public void setup(){
        super.setup();
        System.out.println("Weapon: AD: " + this.attackDmg + " (" + this.quality.toUpperCase() + ")");
    }

    @Override
    public String toString() {
        return (Colors.black + "Weapon: " + this.getAD() + " AD " + color + " (" + this.quality.toUpperCase() + ")" + Colors.reset);
    }
}
