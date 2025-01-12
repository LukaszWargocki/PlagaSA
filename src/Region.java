import java.awt.*;

public class Region {
    public static Color NAM_COL = new Color(7,104,172);
    public static Color LAM_COL =  new Color(118,42,132);
    public static Color SUB_COL =  new Color(255,255,51);
    public static Color MAG_COL =  new Color(247,129,190);
    public static Color EUR_COL =  new Color(252,187,131);
    public static Color SCA_COL =  new Color(171,217,233);
    public static Color MEA_COL =  new Color(1,147,146);
    public static Color NAS_COL =  new Color(205,51,51);
    public static Color SAS_COL = new Color(255,127,0);
    public static Color EAS_COL = new Color(191, 129,46);
    public static Color SEA_COL =  new Color(139,149,198);
    public static Color OCE_COL =  new Color(114, 175, 72);
    private double BLOCK_BORDERS_THRESHOLD;
    private double BLOCK_PORTS_THRESHOLD;
    private double BLOCK_AIRPORTS_THRESHOLD;
    private Color color;
    private String name;
    private int population;
    private int infected = 0;
    private int cured = 0;
    private int deceased = 0;
    private boolean upgrade1 = false;
    private boolean upgrade2 = false;
    private boolean upgrade3 = false;
    private boolean upgrade4 = false;
    private boolean upgrade5 = false;
    private boolean upgrade6 = false;
    private boolean upgrade7 = false;
    private boolean upgrade8 = false;
    private boolean upgrade9 = false;


    public Region(String name, Color color, int population, double bbt, double bpt, double bat) {
        this.name = name;
        this.color = color;
        this.population = population;
        this.BLOCK_AIRPORTS_THRESHOLD = bat;
        this.BLOCK_PORTS_THRESHOLD = bpt;
        this.BLOCK_BORDERS_THRESHOLD = bbt;

    }
    public void setInfected(int infected) {
        this.infected = infected;
    }
    public int getInfected() {
        return infected;
    }
    public int getPopulation() {
        return population;
    }
    public int getCured() {
        return cured;
    }
    public int getDeceased() {
        return deceased;
    }
    public String getName() {
        return name;
    }
    public Color getColor() {
        return color;
    }
    public boolean getUpgrade1() {
        return upgrade1;
    }
    public boolean getUpgrade2() {
        return upgrade2;
    }
    public boolean getUpgrade3() {
        return upgrade3;
    }
    public boolean getUpgrade4() {
        return upgrade4;
    }
    public boolean getUpgrade5() {
        return upgrade5;
    }
    public boolean getUpgrade6() {
        return upgrade6;
    }
    public boolean getUpgrade7() {
        return upgrade7;
    }
    public boolean getUpgrade8() {
        return upgrade8;
    }
    public boolean getUpgrade9() {
        return upgrade9;
    }
    public void setColor(int r, int g, int b) {
        this.color = new Color(r, g, b);
    }
    public void setUpgrade1(boolean value) {
        this.upgrade1 = value;
    }
    public void setUpgrade2(boolean value) {
        this.upgrade2 = value;
    }
    public void setUpgrade3(boolean value) {
        this.upgrade3 = value;
    }
    public void setUpgrade4(boolean value) {
        this.upgrade4 = value;
    }
    public void setUpgrade5(boolean value) {
        this.upgrade5 = value;
    }
    public void setUpgrade6(boolean value) {
        this.upgrade6 = value;
    }
    public void setUpgrade7(boolean value) {
        this.upgrade7 = value;
    }
    public void setUpgrade8(boolean value) {
        this.upgrade8 = value;
    }
    public void setUpgrade9(boolean value) {
        this.upgrade9 = value;
    }
}
