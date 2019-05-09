// Matthew Lad

// necessary imports
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
    
    private String terrainType;
    
    // Freezing, Cold, Temperate, Hot, Searing
    private String temperature;
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
    public Terrain(String terrType) {
        this.terrainType = terrType;
        setTerrainValues();
    }
    
    // Sets the terrain values of each terrain type using a switch.
    public void setTerrainValues(){
        switch (terrainType) {
            case "SEA":
                this.description = "A wide and calm sea.";
                this.temperature = "Temperate";
                this.vegitation = new Vegitation("None");
                this.openWater = true;
                this.soil = new Soil("None");
                this.metals = new Metals("None");
                this.imageView = new ImageView(new Image("file:\\E:\\Coding Projects\\Finished Projects\\Map Maker Main\\MapMakerV0.5 - FINISHED\\src\\Assets\\Images\\Ocean.png"));
                break;
            case "PLAIN":
                this.description = "A peaceful and fertile plain.";
                this.temperature = "Temperate";
                this.vegitation = new Vegitation("Medium");
                this.openWater = true;
                this.soil = new Soil("Fertile");
                this.metals = new Metals("Low");
                this.imageView = new ImageView(new Image("file:\\E:\\Coding Projects\\Finished Projects\\Map Maker Main\\MapMakerV0.5 - FINISHED\\src\\Assets\\Images\\Plains.png"));
                break;
            case "MOUNTAIN":
                this.description = "A rugged and cold mountain.";
                this.temperature = "Cold";
                this.vegitation = new Vegitation("Low");
                this.openWater = true;
                this.soil = new Soil("Little");
                this.metals = new Metals("High");
                this.imageView = new ImageView(new Image("file:\\E:\\Coding Projects\\Finished Projects\\Map Maker Main\\MapMakerV0.5 - FINISHED\\src\\Assets\\Images\\Mountain .png"));
                break;
            case "FOREST":
                this.description = "A large and dense forest.";
                this.temperature = "Temperate";
                this.vegitation = new Vegitation("High");
                this.openWater = true;
                this.soil = new Soil("Medium");
                this.metals = new Metals("Low");
                this.imageView = new ImageView(new Image("file:\\E:\\Coding Projects\\Finished Projects\\Map Maker Main\\MapMakerV0.5 - FINISHED\\src\\Assets\\Images\\Forest.png"));
                break;
            case "HILL":
                this.description = "A series of low hills.";
                this.temperature = "Temperate";
                this.vegitation = new Vegitation("Low");
                this.openWater = true;
                this.soil = new Soil("Medium");
                this.metals = new Metals("Medium");
                this.imageView = new ImageView(new Image("file:\\E:\\Coding Projects\\Finished Projects\\Map Maker Main\\MapMakerV0.5 - FINISHED\\src\\Assets\\Images\\Hill.png"));
                break;
            case "DESERT":
                this.description = "A dry an barren landscape.";
                this.temperature = "Hot";
                this.vegitation = new Vegitation("Low");
                this.openWater = false;
                this.soil = new Soil("None");
                this.metals = new Metals("Low");
                this.imageView = new ImageView(new Image("file:\\E:\\Coding Projects\\Finished Projects\\Map Maker Main\\MapMakerV0.5 - FINISHED\\src\\Assets\\Images\\Desert.png"));
                break;
            case "N/A":
                this.description = "NOT APPLICABLE";
                this.temperature = "Null";
                this.vegitation = new Vegitation("Null");
                this.openWater = false;
                this.soil = new Soil("Null");
                this.metals = new Metals("Null");
                this.imageView = new ImageView(new Image("file:\\E:\\Coding Projects\\Finished Projects\\Map Maker Main\\MapMakerV0.5 - FINISHED\\src\\Assets\\Images\\Blank.png"));
                break;
            default:
                System.out.println("NOT A VALID TERRAIN.");
                break;
        }
    }

    // Various Getters and Setters
    public ImageView getImageView(){
        return this.imageView;
    }
    
    public String getTerrainType(){
        return terrainType;
    }
    
    public void setTerrainType(String terrType){
        this.terrainType = terrType;
        setTerrainValues();
    }

    public String getTemperature() {
        return temperature;
    }

    public String getVegitation() {
        return vegitation.getStringLevel();
    }
    
    public int getVegitationLevel(){
        return vegitation.getIntLevel();
    }

    public boolean isOpenWater() {
        return openWater;
    }

    public String getMetalsString() {
        return metals.getStringLevel();
    }
    
    public int getMetalsLevel(){
        return metals.getIntLevel();
    }

    public String getDescription() {
        return description;
    }
    
    public String getSoil(){
        return soil.getStringLevel();
    }
    
}
