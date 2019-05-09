// Matthew Lad

import java.io.IOException;
import java.util.Random;

// This class represents an array of Locations.
// It can create a multitude of different maps.
// Each map is a 2d array of Locations. This is also called a grid.
public class MapGrid {
    
    // The size of the grid. Declared in UserInterface
    final int SIZE;
    // The main grid or map.
    static private Location[][] mainGrid;
    // A class used to generate unique names.
    TextGenerator textGen;
    
    // Creates and populates the mainGrid
    public MapGrid(int size) throws IOException{
        this.SIZE = size;
        
        // instantiates textGen for random names.
        textGen = new TextGenerator();
        
        // Finally creates the main grid of size SIZE
        mainGrid = create_Grid_RANDOM(SIZE);
    }
    
    
    // This method is used for testing
    // It creates a non-random map.
    public Location[][] create_Grid_TEST(int size){
        
        // Creates and empty map of size size.
        Location[][] grid = new Location[size][size];
        // Fills the map with deserts.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // creates a location object for each grid 'tile'.
                grid[i][j] = new Location(textGen.getRandomPlainsName() + " Plain", "PLAIN");
            }
        }
        return grid;
//        
//        // Creates and empty map of size size.
//        Location[][] grid = new Location[size][size];
//        // Fills the map with deserts.
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                // creates a location object for each grid 'tile'.
//                grid[i][j] = new Location(textGen.getRandomForestName() + " Desert", "DESERT");
//            }
//        }
//        // Puts a sea at a position, and then one hill and
//        // one plain at a spot next it.
//        grid[2][2] = new Location(textGen.getRandomOceanName() + " Sea", "SEA");
//        grid[1][2] = new Location(textGen.getRandomOceanName() + " Plain", "PLAIN");
//        grid[2][3] = new Location(textGen.getRandomOceanName() + " Hills", "HILL");
//        return grid;
    }
    
    // This method picks a random map to create and then
    // returns the newly made map
    public Location[][] create_Grid_RANDOM(int size){
        // the new map to be returned
        Location[][] out = new Location[size][size];
        // The random number determines whether a Tropical
        // or Arid map will be created.
        int rand = getRandomNumberInRange(0, 1);
        switch(rand){
            case 0:
                out = create_Grid_TROPICAL(size);
                break;
            case 1:
                out = create_Grid_ARID(size);
                break;
        }
        return out;
    }
    
    // Creates a Trompical climate map.
    // This map consists of majority forests with a few seas and hills.
    private Location[][] create_Grid_TROPICAL(int size){
        // creates the empty map
        Location[][] grid = new Location[size][size];
        // Fills the map with forests
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // creates a location object for each grid 'tile'.
                grid[i][j] = new Location(textGen.getRandomForestName() + " Forest", "FOREST");
            }
        }
        // puts 3 Seas at random locations.
        for(int i = 0; i < 3; i++) {
            int rand1 = (int)(Math.random()*size);
            int rand2 = (int)(Math.random()*size);
            grid[rand1][rand2] = new Location(textGen.getRandomOceanName() + " Sea", "SEA");
        }
        // puts 3 Seas at random locations.
        for (int i = 0; i < 3; i++) {
            int rand1 = (int) (Math.random() * size);
            int rand2 = (int) (Math.random() * size);
            grid[rand1][rand2] = new Location(textGen.getRandomOceanName() + " Hills", "HILL");
        }

        return grid;
    }
    
    // Creates an Arid climate map.
    // This map consists of majority deserts with 2 oasis'.
    // Each oasis consists of a sea, hills, and a plain.
    private Location[][] create_Grid_ARID(int size){
        // Creates and empty map of size size.
        Location[][] grid = new Location[size][size];
        // Fills the map with deserts.
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // creates a location object for each grid 'tile'.
                grid[i][j] = new Location(textGen.getRandomForestName() + " Desert", "DESERT");
            }
        }
        // Puts 2 seas at random positions, and then one hill and
        // one plain at a random spot next to each sea.
        for(int i = 0; i < 2; i++) {
            int rand1 = getRandomNumberInRange(1, size-2);
            int rand2 = getRandomNumberInRange(1, size-2);
            
            int rand3 = getRandomNumberInRange(-1, 1); int rand4;
            int rand5 = getRandomNumberInRange(0, 1); int rand6;
            if(rand3 == -1){ rand4 = -1; } else { rand4 = 1; }
            if(rand5 == 1){ rand6 = 1;} else{ rand6 = 0;}
            
            grid[rand1][rand2] = new Location(textGen.getRandomOceanName() + " Sea", "SEA");
            grid[rand1 + rand4][rand2 + rand6] = new Location(textGen.getRandomOceanName() + " Plain", "PLAIN");
            grid[rand1][rand2 + rand4] = new Location(textGen.getRandomOceanName() + " Hill", "HILL");
        }
        return grid;
    }

    
    // Utility Methods
    // getRandomNumberInRange(), printGrid(), and getGrid()
    
    // Returns the mainGrid
    public Location[][] getGrid() {
        return mainGrid;
    }
    
    // INCLUSIVE
    // generates a random number from min to max inclusive.
    // Uses Random class
    private static int getRandomNumberInRange(int min, int max) {
        int out;
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min in getRandomNumberInRange in UserInterface");
        }
        Random r = new Random();
        out = r.nextInt((max - min) + 1) + min;
        return out;
    }

    // Prints the grid into the console using the first letter of the terrain type.
    // very old method that does not see use. 12/14/2018
    public void printGrid(Location[][] local){
        String out = "";
        for (int i = 0; i < local.length; i++) {
            for (int j = 0; j < local[i].length; j++) {
                out += local[i][j].getTerrainType().substring(0, 1) + " ";
            }
            out += "\n";
        }
        System.out.println(out);
    }
}
