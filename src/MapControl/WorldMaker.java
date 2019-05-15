// Matthew Lad
// 2/10/2019

package MapControl;

import Interfaces.TerrainTypes;
import Utilities.TextGenerator;
import Utilities.Utility;
import java.io.IOException;

// This class represents an array of Locations.
// It can create a multitude of different maps.
// Each map is a 2d array of Locations. This is also called a gridBiome.
public class WorldMaker {

    // The size of the gridBiome. Declared in UserInterface
    final int SIZE;
    // The main gridBiome or map.
    static private Biome[][] biomeGrid;
    
    static private Tribe[][] tribeGrid;
    
    // A class used to generate unique names.
    TextGenerator textGen;

    // Creates and populates the biomeGrid
    public WorldMaker(int size) throws IOException {
        this.SIZE = size;

        // instantiates textGen for random names.
        textGen = new TextGenerator();

        // Creates the main biomeGrid and TribeGrid of size SIZE
        //create_Biome_Tribe_RANDOM(size);
        create_Biome_Tribe_TROPICAL(size);
    }
    
    
    // This method picks a random map to create and then
    // returns the newly made map
    public void create_Biome_Tribe_RANDOM(int size) {
        int rand = Utility.getRandomNumber(0, 1);
        switch (rand) {
            case 0:
                create_Biome_Tribe_TROPICAL(size);
                break;
            case 1:
                create_Biome_Tribe_ARID(size);
                break;
        }
    }

    // Creates a Tropical climate map.
    // This map consists of majority forests with a few seas and hills.
    private void create_Biome_Tribe_TROPICAL(int size) {
        // creates the empty map
        Biome[][] gridBiome = new Biome[size][size];
        Tribe[][] gridTribe = new Tribe[size][size];
        // Fills the map with forests
        for (int i = 0; i < gridBiome.length; i++) {
            for (int j = 0; j < gridBiome[i].length; j++) {
                // creates a location object for each gridBiome 'tile'.
                gridBiome[i][j] = new Biome(textGen.getRandomForestName() + " Forest", TerrainTypes.FOREST);
                gridTribe[i][j] = new Tribe(0, gridBiome[i][j]);
            }
        }
        // puts 3 Seas at random biomes.
        for (int i = 0; i < 3; i++) {
            int rand1 = (int) (Math.random() * size);
            int rand2 = (int) (Math.random() * size);
            gridBiome[rand1][rand2] = new Biome(textGen.getRandomOceanName() + " Sea", TerrainTypes.SEA);
        }
        // puts 3 Seas at random biomes.
        for (int i = 0; i < 3; i++) {
            int rand1 = (int) (Math.random() * size);
            int rand2 = (int) (Math.random() * size);
            gridBiome[rand1][rand2] = new Biome(textGen.getRandomOceanName() + " Hills", TerrainTypes.HILL);
        }
        
        for (int i = 0; i < gridTribe.length; i++) {
            for (int j = 0; j < gridTribe[i].length; j++) {
                gridTribe[i][j] = new Tribe(0, gridBiome[i][j]);
            }
        }
        
        for (int i = 0; i < 3; i++) {
            int rand1 = (int) (Math.random() * size);
            int rand2 = (int) (Math.random() * size);
            if(gridBiome[rand1][rand2].getTerrainType() == TerrainTypes.FOREST){
                gridTribe[rand1][rand2] = new Tribe(20, gridBiome[rand1][rand2]);
            }
        }
        
        this.biomeGrid = gridBiome;
        this.tribeGrid = gridTribe;
    }

    // Creates an Arid climate map.
    // Adds a pop.20 Tribe to the top left biome.
    private void create_Biome_Tribe_ARID(int size) {
        // Creates two empty maps of size size.
        Biome[][] gridBiome = new Biome[size][size];
        Tribe[][] gridTribe = new Tribe[size][size];
        // Fills the map with deserts.
        for (int i = 0; i < gridBiome.length; i++) {
            for (int j = 0; j < gridBiome[i].length; j++) {
                // creates a location object for each gridBiome 'tile'.
                gridBiome[i][j] = new Biome(textGen.getRandomForestName() + " Desert", TerrainTypes.DESERT);
                gridTribe[i][j] = new Tribe(0, gridBiome[i][j]);
            }
        }
        // Puts 2 seas at random positions, and then one hill and
        // one plain at a random spot next to each sea.
        for (int i = 0; i < 2; i++) {
            int rand1 = Utility.getRandomNumber(1, size - 2);
            int rand2 = Utility.getRandomNumber(1, size - 2);

            int rand3 = Utility.getRandomNumber(-1, 1);
            int rand4;
            int rand5 = Utility.getRandomNumber(0, 1);
            int rand6;
            if (rand3 == -1) {
                rand4 = -1;
            } else {
                rand4 = 1;
            }
            if (rand5 == 1) {
                rand6 = 1;
            } else {
                rand6 = 0;
            }

            gridBiome[rand1][rand2] = new Biome(textGen.getRandomOceanName() + " Sea", TerrainTypes.SEA);
            gridBiome[rand1 + rand4][rand2 + rand6] = new Biome(textGen.getRandomOceanName() + " Plain", TerrainTypes.PLAIN);
            gridBiome[rand1][rand2 + rand4] = new Biome(textGen.getRandomOceanName() + " Hill", TerrainTypes.HILL);
        }

        for (int i = 0; i < gridTribe.length; i++) {
            for (int j = 0; j < gridTribe[i].length; j++) {
                gridTribe[i][j] = new Tribe(0, gridBiome[i][j]);
            }
        }

        for (int i = 0; i < 2; i++) {
            int rand1 = (int) (Math.random() * size);
            int rand2 = (int) (Math.random() * size);
            if (gridBiome[rand1][rand2].getTerrainType() == TerrainTypes.DESERT) {
                gridTribe[rand1][rand2] = new Tribe(20, gridBiome[rand1][rand2]);
            }
        }

        this.biomeGrid = gridBiome;
        this.tribeGrid = gridTribe;
    }
    
    
    // Utility Methods
    // getBiomeGrid(), getTribeGrid(), 
    // Returns the biomeGrid
    public Biome[][] getBiomeGrid() {
        return biomeGrid;
    }
    
    // Returns the tribeGrid
    public Tribe[][] getTribeGrid(){
        return tribeGrid;
    }
}
