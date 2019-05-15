// Matthew Lad
// 2/10/2019

package MapControl;

// Imports
import TerrainControl.Terrain;
import Interfaces.TerrainTypes;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Biome represents a position on the map grid. This position has
// a name, terrain, and an ImageView.
public class Biome {
    private String name;
    private Terrain terrain;
    private ImageView imageView;

    // Default Constructor creates a Blank biome.
    public Biome() {
        this.name = "BLANK";
        this.terrain = new Terrain(TerrainTypes.NOTAVALUE);
        this.imageView = terrain.getImageView();
    }

    // Creates a location of terrain type terrType
    public Biome(String nam, int terrType) {
        this.name = nam;
        this.terrain = new Terrain(terrType);
        this.imageView = terrain.getImageView();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(int terrType) {
        this.terrain.setTerrainType(terrType);
    }

    public int getTerrainType() {
        return terrain.getTerrainType();
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(Image image) {
        this.imageView = new ImageView(image);
    }
}
