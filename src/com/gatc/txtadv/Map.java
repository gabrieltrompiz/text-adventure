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
    }
    public static Map getInstance(int level) {
        if(level == 1) { return MapSingleton.INSTANCE1; }
        if(level == 2) { return MapSingleton.INSTANCE2; }
        else { return MapSingleton.INSTANCE3; }
    }

    public void initialize() {
        int odd = 0;
        if(this.level == 1) {
            if(odd == 0) {
                map[0][0] = new Box(null, null, null, null);
                map[1][0] = new Box(null, null, null, null);
                map[2][0] = new Box(Factory.getPeriquito("armor"), null, null, null);
                map[3][0] = new Box(null, Factory.getPeriquito("weapon"), null, null);
                map[4][0] = new Box(null, null, null, null);
                map[5][0] = new Box(null, null, null, null);
                map[0][1] = new Box(null, null, new Monster(level), null);
                map[1][1] = new Box(null, null, null, null);
                map[2][1] = new Box(null, Factory.getPeriquito("weapon"), null, null);
                map[3][1] = new Box(null, null, new Monster(level), null);
                map[4][1] = new Box(Factory.getPeriquito("armor"), null, null, null);
                map[5][1] = new Box(null, Factory.getPeriquito("weapon"), null, null);
                map[0][2] = new Box(null, null, null, null);
                map[1][2] = new Box(Factory.getPeriquito("armor"), null, null, null);
                map[2][2] = new Box(null, Factory.getPeriquito("weapon"), null, null);
                map[3][2] = new Box(null, null, new Monster(level), null);
                map[4][2] = new Box(null, null, null, null);
                map[5][2] = new Box(null, Factory.getPeriquito("weapon"), null, null);
                map[0][3] = new Box(null, null, null, null);
                map[1][3] = new Box(null, null, null, null);
                map[2][3] = new Box(null, Factory.getPeriquito("weapon"), null, null);
                map[3][3] = new Box(null, null, null, null);
                map[4][3] = new Box(null, Factory.getPeriquito("weapon"), new Monster(level), null);
                map[5][3] = new Box(null, Factory.getPeriquito("weapon"), null, null);
                map[0][4] = new Box(null, null, null, null);
                map[1][4] = new Box(null, null, new Monster(level), null);
                map[2][4] = new Box(null, null, null, null);
                map[3][4] = new Box(null, null, new Monster(level), null);
                map[4][4] = new Box(null, null, null, new Triforce("Power"));
                map[5][4] = new Box(null, null, new Monster(level), null);
                map[0][5] = new Box(null, null, null, null);
                map[1][5] = new Box(null, null, null, null);
                map[2][5] = new Box(null, null, null, null);
                map[3][5] = new Box(null, null, null, null);
                map[4][5] = new Box(Factory.getPeriquito("armor"), null, null, null);
                map[5][5] = new Box(null, null, null, null);
            }
        }
    }

    public Box getBox(int i, int j) { return map[i][j]; }

}
