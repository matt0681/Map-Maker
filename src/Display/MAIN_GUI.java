// Matthew Lad
// 2/10/2019

package Display;

// Necessary Imports
import Interfaces.StringInterface;
import Interfaces.URLInterface;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

// UserInterface class 
public class MAIN_GUI extends Application {
    
    private SceneMaker sceneMaker;
    private HandlingUserInput userInput;
    private TimeProgression timeProgression;

    // Main class that runs the entire program, first by running start()
    public static void main(String[] args) {
        launch(args);
    }
    
    // JavaFX method for running a program.
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        // Creates a new Scene. Creates a timeProgression using the scene.
        // Created a user input handler using scene and time.
        sceneMaker = new SceneMaker();
        timeProgression = new TimeProgression(sceneMaker);
        userInput = new HandlingUserInput(sceneMaker, timeProgression);
        
        // Handles user inputs. See HandlingUserInput class for information.
        userInput.handleAllInputs();
        
        // Essentially sets the scene to the stage and shows it to the user.
        primaryStage.setTitle("Map Generator " + StringInterface.VERSION);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(URLInterface.FAVICON));
        primaryStage.setScene(sceneMaker.getScene());
        primaryStage.show();
    }
}
