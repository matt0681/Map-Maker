// Matthew Lad
// 2/11/2019

package Display;

import TerrainControl.Terrain;
import MapControl.Biome;
import MapControl.Tribe;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class HandlingUserInput {

    private SceneMaker sceneMaker;
    private TimeProgression timeProgression;
    
    public HandlingUserInput(SceneMaker sceneMaker, TimeProgression timeProgression) {
        this.sceneMaker = sceneMaker;
        this.timeProgression = timeProgression;
    }
    
    public void handleAllInputs(){
        handleMouseInput();
        handlePlayButtonInput();
        handleStopButtonInput();
    }

    public void handleMouseInput() {
        sceneMaker.getScene().setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                sceneMaker.clearInformationRoot();

                // Use getIndexX and getIndexY to calculate what position within mapGrid was selected.
                // This position is represented by the index of the 
                // it then prints our that biome's name.
                int gridXIndex = getXIndexOfMouseInMapRoot((int) me.getSceneX());
                int gridYIndex = getYIndexOfMouseInMapRoot((int) me.getSceneY());

                // Creates a new line in the console.
                sceneMaker.addInformationTextln("");

                // If the indexes return are -1, then the user must not
                // have clicked a valid biome.
                if (gridXIndex == -1 || gridYIndex == -1) {
                    sceneMaker.clearInformationRoot();
                    sceneMaker.addInformationTextln("Not a Valid Location!");
                } else {
                    // If the click was on a valid biome, the user will see the 
                    // biome's name, Terrain Type, and description.
                    Biome biome = sceneMaker.getBiomeMapArr()[gridXIndex][gridYIndex];
                    Tribe tribe = sceneMaker.getTribeMapArr()[gridXIndex][gridYIndex];
                    Terrain terrain = biome.getTerrain();
                    sceneMaker.clearInformationRoot();
                    sceneMaker.addInformationTextln("Information: ");
                    sceneMaker.addInformationTextln("");
                    sceneMaker.addInformationTextln("Name:\t\t\t" + biome.getName());
                    sceneMaker.addInformationTextln("Terrain:\t\t\t" + biome.getTerrainType());
                    sceneMaker.addInformationTextln("Description:\t\t" + terrain.getDescription());
                    sceneMaker.addInformationTextln("");
                    sceneMaker.addInformationTextln("Temperature:\t\t" + terrain.getTemperatureLevel() + " f"
                            + "\t\t" + terrain.getTemperatureString());
                    sceneMaker.addInformationTextln("Vegitation:\t\t" + terrain.getVegitationLevel()
                            + "\t\t" + terrain.getVegitationString());
                    sceneMaker.addInformationTextln("Metals:\t\t\t" + terrain.getMetalsLevel()
                            + "\t\t" + terrain.getMetalsString());
                    sceneMaker.addInformationTextln("Soil:\t\t\t\t" + terrain.getSoilLevel()
                            + "\t\t" + terrain.getSoilString());
                    sceneMaker.addInformationTextln("Open Water:\t\t" + terrain.hasOpenWater());
                    sceneMaker.addInformationTextln("\n");
                    sceneMaker.addInformationTextln("Tribe:\t\t\t" + tribe.existsString());
                    sceneMaker.addInformationTextln("Population:\t\t" + tribe.getPopulation());
                    sceneMaker.addInformationTextln("Water Access:\t\t" + tribe.hasAccessToWater());
                    sceneMaker.addInformationTextln("General Health:\t" + tribe.getGeneralHealth());
                }
            }
        });
    }
    
    public void handlePlayButtonInput(){
        Button playButton = sceneMaker.getPlayButton();
        
        playButton.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Play Button Clicked");
                timeProgression.startTime();
            }
        });
    }
    
    
    // Handles 
    public void handleStopButtonInput() {
        Button stopButton = sceneMaker.getStopButton();
        
        stopButton.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Stop Button Clicked");
                timeProgression.stopTime();
            }
        });
    }
    
    // These two methods, getXIndexOfMouseInMapRoot() and getYIndexOfMouseInMapRoot()
    // use a formula to calculate what biome was selected by the user based on the 
    // X and Y coordinate of the mouse.
    public int getXIndexOfMouseInMapRoot(int x) {
        int xVal = -1;
        for (int i = 0; i < 10; i++) {
            if (x >= ((sceneMaker.getPADDING() * 2) + (i * 51)) && x <= ((sceneMaker.getPADDING() * 2) + ((i + 1) * 51) - (2))) {
                xVal = i;
            }
        }
        return xVal;
    }
    
    public int getYIndexOfMouseInMapRoot(int y) {
        int yVal = -1;
        for (int i = 0; i < 10; i++) {
            if (y >= ((56) + (sceneMaker.getPADDING() * 2) + (i * 51)) && y <= ((56) + (sceneMaker.getPADDING() * 2) + ((i + 1) * 51) - (2))) {
                yVal = i;
            }
        }
        return yVal;
    }
}
