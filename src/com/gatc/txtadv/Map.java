package com.gatc.txtadv;

public class Map {

    private int level;
    private Box[][] map = new Box[6][6];

    public Map(int level) {
        this.level = level;
        this.initialize();
    }

    private static class MapSingleton {
        private static final Map INSTANCE1 = new Map(1);
        private static final Map INSTANCE2 = new Map(2);
        private static final Map INSTANCE3 = new Map(3);
        private static final Map INSTANCE4 = new Map(4);
    }
    public static Map getInstance(int level) {
        if(level == 1) { return MapSingleton.INSTANCE1; }
        if(level == 2) { return MapSingleton.INSTANCE2; }
        if(level == 3) { return MapSingleton.INSTANCE3; }
        else { return MapSingleton.INSTANCE4; }
    }

    public void initialize() {
        if(this.level == 1) {
            map[0][0] = new Box(null, null, null, null, null, null, null);
            map[1][0] = new Box(null, null, null, null, new Consumable("potion", 1), null, null);
            map[2][0] = new Box(Factory.getPeriquito("armor"), null, null, null, null, null, null);
            map[3][0] = new Box(null, Factory.getPeriquito("weapon"), null, null, null, null, null);
            map[4][0] = new Box(null, null, null, null, null, null, new NPC());
            map[5][0] = new Box(null, null, null, null, null, null, null);
            map[0][1] = new Box(null, null, new Monster(level), null, null, null, null);
            map[1][1] = new Box(null, null, null, null, new Consumable("sand rod", 1), null, null);
            map[2][1] = new Box(null, null, new Monster(level), null, null, null, null);
            map[3][1] = new Box(null, null, new Monster(level), null, null, null, null);
            map[4][1] = new Box(Factory.getPeriquito("armor"), null, null, null, null, null, null);
            map[5][1] = new Box(null, Factory.getPeriquito("weapon"), null, null, null, null, null);
            map[0][2] = new Box(null, null, null, null, new Consumable("potion", 1), null, null);
            map[1][2] = new Box(Factory.getPeriquito("armor"), null, null, null, null, null, null);
            map[2][2] = new Box(null, Factory.getPeriquito("weapon"), null, null, null, null, null);
            map[3][2] = new Box(null, null, new Monster(level), null, null, null, null);
            map[4][2] = new Box(null, null, null, null, new Consumable("potion", 1), null, null);
            map[5][2] = new Box(null, Factory.getPeriquito("weapon"), null, null, null, null, null);
            map[0][3] = new Box(null, null, null, null, new Consumable("bomb", 2), null, null);
            map[1][3] = new Box(null, null, null, null, null, null, null);
            map[2][3] = new Box(null, Factory.getPeriquito("weapon"), null, null, null, null, null);
            map[3][3] = new Box(null, null, null, null, null, null, null);
            map[4][3] = new Box(null, Factory.getPeriquito("weapon"), new Monster(level), null, null, null, null);
            map[5][3] = new Box(null, Factory.getPeriquito("weapon"), null, null, new Consumable("potion", 1), null, null);
            map[0][4] = new Box(null, null, null, null, null, null, null);
            map[1][4] = new Box(null, null, new Monster(level), null, null, null, null);
            map[2][4] = new Box(null, null, null, null, null, null, null);
            map[3][4] = new Box(null, null, new Monster(level), null, null, null, null);
            map[4][4] = new Box(null, null, null, new Triforce("Wisdom"), new Consumable("arrow", 5), null, null);
            map[5][4] = new Box(null, null, new Monster(level), null, null, new Trap("sand rod"), null);
            map[0][5] = new Box(null, null, null, null, null, null, null);
            map[1][5] = new Box(null, null, null, null, new Consumable("potion", 1), null, null);
            map[2][5] = new Box(null, null, null, null, null, null, null);
            map[3][5] = new Box(null, null, null, null, null, null, null);
            map[4][5] = new Box(Factory.getPeriquito("armor"), null, null, null, null, new Trap("bomb"), null);
            map[5][5] = new Box(null, new Weapon(16, "Master Sword (FIRST UPGRADE)"), null, null, null, null, null);
        }
        if(this.level == 2) {
            map[0][0] = new Box(null, null, null, null, null, null, null);
            map[1][0] = new Box(null, null, null, null, null, new Trap("arrow"), null);
            map[2][0] = new Box(Factory.getPeriquito("armor"), null, null, null, null, null, null);
            map[3][0] = new Box(null, Factory.getPeriquito("weapon"), null, null, null, null, null);
            map[4][0] = new Box(null, null, null, null, null, new Trap("arrow"), null);
            map[5][0] = new Box(null, new Weapon(20, "Master Sword (SECOND UPGRADE)"), null, null, null, null, null);
            map[0][1] = new Box(null, null, new Monster(level), null, null, null, null);
            map[1][1] = new Box(null, null, null, null, new Consumable("sand rod", 1), null, null);
            map[2][1] = new Box(null, null, new Monster(level), null, null, null, null);
            map[3][1] = new Box(null, null, new Monster(level), null, null, null, null);
            map[4][1] = new Box(null, null, null, null, null, null, null);
            map[5][1] = new Box(null, Factory.getPeriquito("weapon"), null, null, null, new Trap("bomb"), null);
            map[0][2] = new Box(null, null, null, null, new Consumable("potion", 1), null, null);
            map[1][2] = new Box(Factory.getPeriquito("armor"), null, null, null, null, null, null);
            map[2][2] = new Box(null, Factory.getPeriquito("weapon"), null, null, null, null, null);
            map[3][2] = new Box(null, null, new Monster(level), null, null, null, null);
            map[4][2] = new Box(null, null, null, null, new Consumable("potion", 1), null, null);
            map[5][2] = new Box(null, null, new Monster(level), null, null, null, null);
            map[0][3] = new Box(null, null, null, null, new Consumable("bomb", 2), null, null);
            map[1][3] = new Box(null, null, null, null, null, null, new NPC());
            map[2][3] = new Box(null, Factory.getPeriquito("weapon"), null, null, null, null, null);
            map[3][3] = new Box(null, null, null, null, null, null, null);
            map[4][3] = new Box(null, Factory.getPeriquito("weapon"), new Monster(level), null, null, null, null);
            map[5][3] = new Box(null, null, null, null, new Consumable("potion", 1), null, null);
            map[0][4] = new Box(null, null, null, null, null, null, null);
            map[1][4] = new Box(null, null, new Monster(level), null, null, null, null);
            map[2][4] = new Box(null, null, null, null, null, null, null);
            map[3][4] = new Box(null, null, new Monster(level), null, null, null, null);
            map[4][4] = new Box(null, null, null, null, new Consumable("arrow", 5), null, null);
            map[5][4] = new Box(null, null, new Monster(level), null, null, new Trap("sand rod"), null);
            map[0][5] = new Box(null, null, null, null, null, null, null);
            map[1][5] = new Box(null, null, new Monster(level), null, new Consumable("potion", 1), null, null);
            map[2][5] = new Box(null, null, null, null, null, null, null);
            map[3][5] = new Box(null, null, null, new Triforce("Courage"), new Consumable("boomerang", 5), null, null);
            map[4][5] = new Box(Factory.getPeriquito("armor"), null, null, null, null, new Trap("bomb"), null);
            map[5][5] = new Box(null, null, new Monster(level), null, null, null, null);
        }
        if(level == 3) {
            map[0][0] = new Box(null, null, null, null, null, null, null);
            map[1][0] = new Box(null, null, null, null, null, null, null);
            map[2][0] = new Box(Factory.getPeriquito("armor"), null, null, null, null, null, null);
            map[3][0] = new Box(null, Factory.getPeriquito("weapon"), null, null, null, null, null);
            map[4][0] = new Box(null, null, null, null, null, new Trap("boomerang"), null);
            map[5][0] = new Box(null, null, null, new Triforce("Power"), null, null, null);
            map[0][1] = new Box(null, null, new Monster(level), null, null, null, null);
            map[1][1] = new Box(null, null, null, null, new Consumable("sand rod", 1), null, null);
            map[2][1] = new Box(null, null, new Monster(level), null, null, null, null);
            map[3][1] = new Box(null, null, new Monster(level), null, null, null, null);
            map[4][1] = new Box(null, null, null, null, null, null, null);
            map[5][1] = new Box(null, Factory.getPeriquito("weapon"), null, null, null, new Trap("boomerang"), null);
            map[0][2] = new Box(null, null, null, null, new Consumable("potion", 1), null, null);
            map[1][2] = new Box(Factory.getPeriquito("armor"), null, null, null, null, null, null);
            map[2][2] = new Box(null, Factory.getPeriquito("weapon"), null, null, null, null, null);
            map[3][2] = new Box(null, null, new Monster(level), null, null, null, null);
            map[4][2] = new Box(null, null, null, null, new Consumable("potion", 1), null, null);
            map[5][2] = new Box(null, null, new Monster(level), null, null, null, null);
            map[0][3] = new Box(null, null, null, null, new Consumable("bomb", 2), null, null);
            map[1][3] = new Box(null, null, null, null, null, null, new NPC());
            map[2][3] = new Box(null, Factory.getPeriquito("weapon"), null, null, null, null, null);
            map[3][3] = new Box(null, null, null, null, null, null, null);
            map[4][3] = new Box(null, Factory.getPeriquito("weapon"), new Monster(level), null, null, null, null);
            map[5][3] = new Box(null, null, null, null, new Consumable("potion", 1), null, null);
            map[0][4] = new Box(null, null, new Monster(level), null, null, new Trap("bomb"), null);
            map[1][4] = new Box(null, null, new Monster(level), null, null, null, null);
            map[2][4] = new Box(null, null, null, null, null, null, null);
            map[3][4] = new Box(null, null, new Monster(level), null, null, null, null);
            map[4][4] = new Box(null, null, null, null, new Consumable("arrow", 5), null, null);
            map[5][4] = new Box(null, null, new Monster(level), null, null, new Trap("sand rod"), null);
            map[0][5] = new Box(null, new Weapon(24, "Master Sword (THIRD UPGRADE)"), null, null, null, null, null);
            map[1][5] = new Box(null, null, new Monster(level), null, new Consumable("potion", 1), null, null);
            map[2][5] = new Box(null, null, null, null, null, null, new NPC());
            map[3][5] = new Box(null, null, null, null, null, null, null);
            map[4][5] = new Box(Factory.getPeriquito("armor"), null, null, null, null, new Trap("bomb"), null);
            map[5][5] = new Box(null, null, new Monster(level), null, null, null, null);
        }
        if(level == 4) {
            map[0][0] = new Box(null, null, new Monster(10, 30, 4), null, null, null, null);
        }
    }

    public Box getBox(int i, int j) { return map[i][j]; }

}
