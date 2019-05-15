// Matthew Lad
// 2/10/2019

package Display;

import MapControl.Tribe;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class TimeProgression{

    // How many seconds is one day.
    private final double DAYINSECONDS = 0.25;
    
    private SceneMaker sceneMaker;
    private Timeline timeLine;
    
    // 7 days = 1 week
    // 4 weeks = 1 month
    // 12 months = 1 year
    private int year; 
    private int month;
    private int week;
    private int day;
    
    private boolean timeStarted = false;

    public TimeProgression(SceneMaker sceneMaker) {
        this.sceneMaker = sceneMaker;
        this.timeLine = new Timeline();
        this.year = 1;
        this.month = 1;
        this.week = 1;
        this.day = 1;
    }
    
    public void startTime() {
        System.out.println("Time progression started.");
        
        timeLine.setCycleCount(Timeline.INDEFINITE);
        
        if (!timeStarted) {
            timeLine.getKeyFrames().add(
                new KeyFrame(Duration.seconds(DAYINSECONDS),(event) -> {
                    startTimeCode();
                })
            );
        }
        
        timeStarted = true;
        timeLine.play();
    }
    
    public void stopTime(){
        System.out.println("Time stopped.");
        timeStarted = false;
        timeLine.stop();
        timeLine.getKeyFrames().clear();
    }
    
    
    public void startTimeCode(){
        sceneMaker.clearTimeRoot();
        sceneMaker.addTimeText(returnFormattedTime());
        
        for (int i = 0; i < sceneMaker.getTribeMapArr().length; i++) {
            for (int j = 0; j < sceneMaker.getTribeMapArr()[i].length; j++) {
                if(sceneMaker.getTribeMapArr()[i][j].getPopulation() > 0){
                    sceneMaker.getTribeMapArr()[i][j].updatePopulation();
                }
            }
        }
        
        increaseDateByDays();
    }
    
    public String returnFormattedTime(){
        String out = "";
        out += " TIME: " + this.month + " / " + this.day + " / " + this.year;
        return out;
    }

    private void increaseDateByDays() {
        if(day < 28){
            day++;
        } else if(day == 28){
            day = 1;
            if(month < 12){
                month++;
            } else if(month == 12){
                month = 1;
                year++;
            }
        }
    }
}
