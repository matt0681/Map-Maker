// Matthew Lad

// Imports
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


// Location represents a position on the map grid. This position has
// a name, terrain, and an ImageView.
public class Location {
    private String name;
    private Terrain terrain;
    private ImageView imageView;
    
    // Default Constructor creates a Blank location
    public Location(){
        this.name = "BLANK";
        this.terrain = new Terrain("N/A");
        this.imageView = terrain.getImageView();
    }
    
    // Creates a location of terrain type terrType
    public Location(String nam, String terrType){
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

    public void setTerrain(String terrType) {
        this.terrain.setTerrainType(terrType);
    }
    
    public String getTerrainType(){
        return terrain.getTerrainType();
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(Image image) {
        this.imageView = new ImageView(image);
    }
}
