// Matthew Lad
// 2/27/19

package TerrainControl;

// necessary imports
import Interfaces.URLInterface;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Class for defining the different terrains and their values.
public class Terrain {

    /*
    TERRAIN VALUES: Temperature, Vegitation, openWater, soil, metals 
    SEA: Temperate, None, True, None, None
    PLAIN: Temperate, Low, True, Fertile, Low
    MOUNTAIN: Cold, Low, True, None, High
    FOREST: Temperate, High, True, Little, Low
    HILL: Temperate, Medium, True, Fertile, Medium
    DESERT: Hot, None, False, None, Low
     */
    private int terrainType;

    // Freezing, Cold, Temperate, Hot, Searing (Fahrenheit)
    private Temperature temperature;
    // None, Low, Medium, High
    private Vegitation vegitation;
    // True, False
    private boolean openWater;
    // None, Little, Medium, Fertile
    private Soil soil;
    // None, Low, Medium, High
    private Metals metals;
    // A short description for the user.
    private String description;

    // The Image / Graphic used for the terrain type
    private ImageView imageView;

    // Constructor, sets the Terrain Type the sets the terrain values.
    public Terrain(int terrType) {
        this.terrainType = terrType;
        setTerrainValues();
    }

    // Sets the terrain values of each terrain type using a switch.
    public void setTerrainValues() {
        switch (terrainType) {
            case 1:
                this.description = "A wide and calm sea.";
                this.temperature = new Temperature("Temperate");
                this.vegitation = new Vegitation("None");
                this.openWater = true;
                this.soil = new Soil("None");
                this.metals = new Metals("None");
                this.imageView = new ImageView(new Image(URLInterface.SEA));
                break;
            case 2:
                this.description = "A peaceful and fertile plain.";
                this.temperature = new Temperature("Temperate");
                this.vegitation = new Vegitation("Medium");
                this.openWater = true;
                this.soil = new Soil("Fertile");
                this.metals = new Metals("Low");
                this.imageView = new ImageView(new Image(URLInterface.PLAINS));
                break;
            case 3:
                this.description = "A rugged and cold mountain.";
                this.temperature = new Temperature("Cold");
                this.vegitation = new Vegitation("Low");
                this.openWater = true;
                this.soil = new Soil("Little");
                this.metals = new Metals("High");
                this.imageView = new ImageView(new Image(URLInterface.MOUNTAIN));
                break;
            case 4:
                this.description = "A large and dense forest.";
                this.temperature = new Temperature("Temperate");
                this.vegitation = new Vegitation("High");
                this.openWater = true;
                this.soil = new Soil("Medium");
                this.metals = new Metals("Low");
                this.imageView = new ImageView(new Image(URLInterface.FOREST));
                break;
            case 5:
                this.description = "A series of low hills.";
                this.temperature = new Temperature("Temperate");
                this.vegitation = new Vegitation("Low");
                this.openWater = true;
                this.soil = new Soil("Medium");
                this.metals = new Metals("Medium");
                this.imageView = new ImageView(new Image(URLInterface.HILL));
                break;
            case 6:
                this.description = "A dry an barren landscape.";
                this.temperature = new Temperature("Hot");
                this.vegitation = new Vegitation("Low");
                this.openWater = false;
                this.soil = new Soil("None");
                this.metals = new Metals("Low");
                this.imageView = new ImageView(new Image(URLInterface.DESERT));
                break;
            case 7:
                this.description = "NOT APPLICABLE";
                this.temperature = new Temperature("Null");
                this.vegitation = new Vegitation("Null");
                this.openWater = false;
                this.soil = new Soil("Null");
                this.metals = new Metals("Null");
                this.imageView = new ImageView(new Image(URLInterface.BLANK));
                break;
            default:
                System.out.println("NOT A VALID TERRAIN.");
                break;
        }
    }

    public int getTerrainType() {
        return terrainType;
    }
    
    public String getDescription() {
        return description;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public String getTemperatureString() {
        return temperature.getStringLevel();
    }

    public String getVegitationString() {
        return vegitation.getStringLevel();
    }
    
    public String getSoilString() {
        return soil.getStringLevel();
    }

    public String getMetalsString() {
        return metals.getStringLevel();
    }

    public int getTemperatureLevel() {
        return temperature.getIntLevel();
    }

    public int getVegitationLevel() {
        return vegitation.getIntLevel();
    }

    public int getSoilLevel() {
        return soil.getIntLevel();
    }

    public int getMetalsLevel() {
        return metals.getIntLevel();
    }
    
    public boolean hasOpenWater() {
        return openWater;
    }
    
    // Set Methods
    public void setTerrainType(int terrainType) {
        this.terrainType = terrainType;
        setTerrainValues();
    }
}
