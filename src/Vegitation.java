// Matthew Lad
// 2/01/2019

import java.util.Random;

public class Vegitation {
    private int intLevel;
    private String stringLevel;
    
    public Vegitation(String vegLevel){
        switch(vegLevel){
            case "None":
                this.intLevel = 0;
                this.stringLevel = "None";
                break;
            case "Low":
                this.intLevel = getRandomNumberInRange(1, 24);;
                this.stringLevel = "Low";
                break;
            case "Medium":
                this.intLevel = getRandomNumberInRange(15, 74);;
                this.stringLevel = "Medium";
                break;
            case "High":
                this.intLevel = getRandomNumberInRange(30, 100);;
                this.stringLevel = "High";
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
