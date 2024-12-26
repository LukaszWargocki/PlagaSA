import java.awt.*;

public class Region {
    private String name;
    private Color mapColor;
    private int population;
    private int infected = 0;
    // cured patients are immune to future infection
    private int cured = 0;
    private int deceased = 0;
    public Region(String name, int population) {
        this.name = name;
        this.population = population;
    }
}
