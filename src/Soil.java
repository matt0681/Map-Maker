// Matthew Lad
// 2/07/19

import java.util.Random;

public class Soil {

    private int intLevel;
    private String stringLevel;

    public Soil(String soilLevel) {
        // None, Little, Medium, Fertile
        switch (soilLevel) {
            case "None":
                this.intLevel = 0;
                this.stringLevel = "None";
                break;
            case "Little":
                this.intLevel = getRandomNumberInRange(1, 24);
                this.stringLevel = "Little";
                break;
            case "Medium":
                this.intLevel = getRandomNumberInRange(15, 74);
                this.stringLevel = "Medium";
                break;
            case "Fertile":
                this.intLevel = getRandomNumberInRange(30, 100);
                this.stringLevel = "Fertile";
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
