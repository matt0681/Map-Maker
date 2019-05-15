package TerrainControl;

// Matthew Lad
// 2/10/2019

import java.util.Random;

public class Temperature {

    private int intLevel;
    private String stringLevel;

    public Temperature(String soilLevel) {
        // Freezing, Cold, Temperate, Hot, Searing
        switch (soilLevel) {
            case "Freezing":
                this.intLevel = getRandomNumberInRange(-20, 31);
                this.stringLevel = "Freezing";
                break;
            case "Cold":
                this.intLevel = getRandomNumberInRange(20, 40);
                this.stringLevel = "Cold";
                break;
            case "Temperate":
                this.intLevel = getRandomNumberInRange(40, 70);
                this.stringLevel = "Temperate";
                break;
            case "Hot":
                this.intLevel = getRandomNumberInRange(70, 100);
                this.stringLevel = "Hot";
                break;
            case "Searing":
                this.intLevel = getRandomNumberInRange(100, 120);
                this.stringLevel = "Searing";
                break;
            case "Null":
                this.intLevel = 0;
                this.stringLevel = "NULL";
                break;
        }
    }

    public int getIntLevel() {
        return intLevel;
    }

    public String getStringLevel() {
        return stringLevel;
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

}
