// Matthew Lad
// 

package Utilities;

import java.util.Random;

public class Utility {

    // INCLUSIVE
    // generates a random number from min to max inclusive.
    // Uses Random class
    public static int getRandomNumber(int min, int max) {
        int out;
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min in getRandomNumberInRange in UserInterface");
        }
        Random r = new Random();
        out = r.nextInt((max - min) + 1) + min;
        return out;
    }
    
    // INCLUSIVE
    // generates a random number from 0 to max inclusive.
    // Uses Random class
    public static int getRandomNumber(int max){
        return 0;
    }
}
