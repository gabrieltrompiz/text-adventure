package com.gatc.txtadv;

public class Armor extends Periquitos {

    private int armorHitpoints;
    private String quality;
    private String color;

    public Armor (int armorHitpoints, String quality){
        this.armorHitpoints = armorHitpoints;
        this.quality = quality;
        this.color = this.quality.equalsIgnoreCase("common") ? Colors.green : this.quality.equalsIgnoreCase("rare")
        ? Colors.blue : this.quality.equalsIgnoreCase("epic") ? Colors.purple : null;
    }

    public Armor (Character character, int armorHitpoints, String quality){
        super(character);
        this.armorHitpoints = armorHitpoints;
        this.quality = quality;
    }

    public int getAD() { return 0; }
    public double getAS() { return 0; }
    public int getHitpoints(){ return this.armorHitpoints; }
    public String getQuality() { return this.quality; }

    public Character equipOn(Character character) {
        character = new Armor(character, this.getHitpoints(), this.getQuality());
        return character;
    }

    public Character unequipOn(Character character) {
        if(character.getClass().getSimpleName().equalsIgnoreCase("weapon")) {
            character = new Weapon(new Body(character.getCurrentHitpoints()), ((Weapon) character).getAD(), ((Weapon) character).getQuality());
            System.out.println("\nUnequipped " + this.getQuality() + " armor.\n");
        }
        else {
            character = new Body(character.getCurrentHitpoints());
            System.out.println("\nUnequipped " + this.getQuality() + " armor.\n");
        }
        return character;
    }

    @Override
    public void visit(Box box) {

    }

    public void addToInventory(Object object){ super.addToInventory(object); }
    public void showInventory() { super.showInventory(); }
    public Armor getCurrentArmor() { return this; }
    public Weapon getCurrentWeapon() { return super.getCurrentWeapon(); }
    public int getCurrentHitpoints() {
        return super.getCurrentHitpoints();
    }

    public void setup() {
        super.setup();
        System.out.println("Armor: " + this.armorHitpoints + " (" + this.quality.toUpperCase() + ")");
    }

    @Override
    public String toString(){
        return (Colors.black + "Armor: " + this.armorHitpoints + color + " (" + this.quality.toUpperCase() + ")" + Colors.reset);
    }
}
