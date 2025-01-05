import java.awt.*;

public class Region {
    private static int BLOCK_BORDERS_THRESHOLD;
    private static int BLOCK_PORTS_THRESHOLD;
    private static int BLOCK_AIRPORTS_THRESHOLD;

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
