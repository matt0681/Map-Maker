// Matthew Lad
// 2/28/2019

package MapControl;

import Interfaces.URLInterface;
import javafx.scene.image.ImageView;
import Interfaces.StringInterface;
import Utilities.Utility;

public class Tribe {

    private int population;
    private double generalHealth;
    private boolean accessToWater;
    private Biome biome;
    private ImageView imageView;
    
    public Tribe(int initialSize, Biome biome) {
        this.population = initialSize;
        this.generalHealth = 100;
        this.biome = biome;
        this.accessToWater = this.biome.getTerrain().hasOpenWater();
        if(this.population > 0){
            this.imageView = new ImageView(URLInterface.TRIBE);
        } else {
            this.imageView = new ImageView(URLInterface.DEADTRIBE);
        }
    }

    public void updatePopulation(){
        if(generalHealth >= 50){
            population += Utility.getRandomNumber(1, 2);
            generalHealth -= Utility.getRandomNumber(1, 3);
        } else if (generalHealth > 0 || generalHealth < 50) {
            population -= Utility.getRandomNumber(1, 2);
            generalHealth += Utility.getRandomNumber(1, 3);
        }
    }
    
    
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getGeneralHealth() {
        return generalHealth;
    }

    public void setGeneralHealth(double generalHealth) {
        this.generalHealth = generalHealth;
    }

    public boolean hasAccessToWater() {
        return accessToWater;
    }

    public void setAccessToWater(boolean accessToWater) {
        this.accessToWater = accessToWater;
    }

    public Biome getBiome() {
        return biome;
    }

    public void setBiome(Biome biome) {
        this.biome = biome;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
    
    public String existsString(){
        if(this.population > 0){
            return StringInterface.TRUE;
        } else {
            return StringInterface.FALSE;
        }
    }

}
