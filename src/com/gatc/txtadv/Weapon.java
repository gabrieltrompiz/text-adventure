package com.gatc.txtadv;

public class Weapon extends Periquitos {

    private int attackDmg;
    private String name;
    private String color;

    public Weapon(int attackDmg, String name){
        this.attackDmg = attackDmg;
        this.name = name;
        this.color = this.name.equalsIgnoreCase("Kokiri Sword") || this.name.equalsIgnoreCase("White Sword")
        ? Colors.green : this.name.equalsIgnoreCase("Magical Sword") ? Colors.blue :
        this.name.equalsIgnoreCase("Master Sword") || this.name.equalsIgnoreCase("Biggoron's Sword") ? Colors.purple : null;
    }

    public Weapon(Character character, int attackDmg, String name){
        super(character);
        this.attackDmg = attackDmg;
        this.name = name;
    }

    public int getHitpoints() { return 0; }
    public String getName() { return this.name; }
    public int getAD(){ return this.attackDmg; }

    public Character equipOn(Character character) {
        character = new Weapon(character, this.getAD(), this.getName());
        return character;
    }

    public Character unequipOn(Character character) {
        if(character.getClass().getSimpleName().equalsIgnoreCase("armor")) {
            character = new Armor(new Body(character.getCurrentHitpoints()), ((Armor) character).getHitpoints(), ((Armor) character).getName());
            System.out.println("\nUnequipped " + this.getName() + " weapon.\n");
        }
        else {
            character = new Body(character.getCurrentHitpoints());
            System.out.println("\nUnequipped " + this.getName() + " weapon.\n");
        }
        return character;
    }

    @Override
    public Character visit(Box box, Character character) { return super.visit(box, character); }

    public void addToInventory(Object object) { super.addToInventory(object); }
    public Character showInventory(Character character) { return super.showInventory(character); }
    public Armor getCurrentArmor() { return super.getCurrentArmor(); }
    public Weapon getCurrentWeapon() { return this; }
    public int getCurrentHitpoints() {
        return super.getCurrentHitpoints();
    }
    public void setCurrentHp(int hp) { super.setCurrentHp(hp); }

    public void found() {
        System.out.println("Found " + color + this.name + Colors.black + " with " + this.attackDmg + " AD. Want to grab it? (y/n)");
    }

    @Override
    public String toString() {
        return (Colors.black + "Weapon: " + this.getAD() + " AD " + color + " (" + this.name.toUpperCase() + ")" + Colors.black);
    }
}
