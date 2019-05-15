package TerrainControl;

// Matthew Lad
// 2/01/2019

import java.util.Random;

public class Metals {
    private int intLevel;
    private String stringLevel;
    private double hematite;
    private double cuprite;
    
    public Metals(String metalsLevel){
        switch(metalsLevel){
            case "None":
                this.intLevel = 0;
                this.cuprite = 0;
                this.hematite = 0;
                this.stringLevel = "None";
                break;
            case "Low":
                this.intLevel = getRandomNumberInRange(1, 24);
                this.cuprite = intLevel/2;
                this.hematite = intLevel/2;
                this.stringLevel = "Low";
                break;
            case "Medium":
                this.intLevel = getRandomNumberInRange(15, 74);
                this.cuprite = intLevel/2;
                this.hematite = intLevel/2;
                this.stringLevel = "Medium";
                break;
            case "High":
                this.intLevel = getRandomNumberInRange(30, 100);
                this.cuprite = intLevel/2;
                this.hematite = intLevel/2;
                this.stringLevel = "High";
                break;
            case "Null":
                this.intLevel = 0;
                this.cuprite = 0;
                this.hematite = 0;
                this.stringLevel = "NULL";
                break;
        }
    }

    public int getIntLevel() {
        return intLevel;
    }
    
    public void setIntLevel(int level){
        intLevel = level;
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