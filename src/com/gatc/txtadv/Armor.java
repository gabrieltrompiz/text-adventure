package com.gatc.txtadv;

public class Armor extends Periquitos {

    private int armorHitpoints;
    private String name;
    private String color;

    public Armor (int armorHitpoints, String name){
        this.armorHitpoints = armorHitpoints;
        this.name = name;
        this.color = this.name.equalsIgnoreCase("Sacred Shield") || this.name.equalsIgnoreCase("Divine Shield")
        ? Colors.green : this.name.equalsIgnoreCase("Goddess Shield") || this.name.equalsIgnoreCase("Fortified Shield")
        ? Colors.blue : this.name.equalsIgnoreCase("Hylian Shield") ? Colors.purple : null;
    }

    public Armor (Character character, int armorHitpoints, String name){
        super(character);
        this.armorHitpoints = armorHitpoints;
        this.name = name;
    }

    public int getAD() { return 0; }
    public int getHitpoints(){ return this.armorHitpoints; }
    public void setArmorHitpoints(int hp) { this.armorHitpoints = hp; }
    public String getName() { return this.name; }

    public Character equipOn(Character character) {
        character = new Armor(character, this.getHitpoints(), this.getName());
        return character;
    }

    public Character unequipOn(Character character) {
        if(character.getClass().getSimpleName().equalsIgnoreCase("weapon")) {
            character = new Weapon(new Body(character.getCurrentHitpoints()), ((Weapon) character).getAD(), ((Weapon) character).getName());
            System.out.println("\nUnequipped " + this.getName() + " armor.\n");
        }
        else {
            character = new Body(character.getCurrentHitpoints());
            System.out.println("\nUnequipped " + this.getName() + " armor.\n");
        }
        return character;
    }

    @Override
    public Character visit(Box box, Character character) {
        return super.visit(box, character);
    }

    public void addToInventory(Object object){ super.addToInventory(object); }
    public Character showInventory(Character character) { return super.showInventory(character); }
    public Armor getCurrentArmor() { return this; }
    public Weapon getCurrentWeapon() { return super.getCurrentWeapon(); }
    public int getCurrentHitpoints() { return super.getCurrentHitpoints(); }
    public void setCurrentHp(int hp) { super.setCurrentHp(hp); }
    public int getTriforce() { return super.getTriforce(); }
    public int getRupees() { return super.getRupees(); }

    public void found() {
        System.out.println("Found " + color + this.name + Colors.black + ". Want to grab it? (y/n)");
    }

    @Override
    public String toString(){
        return (color + this.name.toUpperCase() + Colors.black + ": " + this.armorHitpoints + " HP");
    }
}
