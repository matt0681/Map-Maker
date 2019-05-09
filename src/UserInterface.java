// Matthew Lad
// 12/07/2018 - 02/07/2019
// version 0.5

// These are all the necessary imports
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

// This is the class that creates the GUI.
public class UserInterface extends Application {

    // The MapGrid displayed by the GUI.
    private Location[][] mapArr;
    // the text that goes in the consoleRoot
    private String consoleText = "";

    // Size of the Map Grid
    final int GRID_SIZE = 10;
    // Size of each image in pixels
    final int IMAGE_SIZE = 50;
    // Horizontal and Vertical gaps between location images
    // Padding are margins
    final int H_GAP = 1;
    final int V_GAP = 1;
    final int PADD = 6;
    // This is the current code version
    final String VERSION = "V0.5";

    // Main class that runs the entire program, first by running start()
    public static void main(String[] args) {
        launch(args);
    }

    // Creates the Scene and the roots.
    // Displays the GUI to the user.
    @Override
    public void start(Stage primaryStage) throws IOException {

        // This creates the two parts of the GUI:
        // visual output (mapRoot)
        // text output (consoleRoot)
        // createGridPane() actually creates the MapGrid and just returns
        // the visual gridPane version of it.
        GridPane mapRoot = createGridPane();  // Creates MapArr
        Label consoleRoot = createConsolePane();
        Label descriptionRoot = createDescriptionRoot();

        // Creates a stack of Roots using VBox
        BorderPane mainRoot = new BorderPane();
        mainRoot.setPadding(new Insets(10, 10, 10, 10));
        mainRoot.setLeft(mapRoot);
        mainRoot.setBottom(consoleRoot);
        mainRoot.setRight(descriptionRoot);

        // The sizes put into account padding and H & V gaps.
        Scene scene = new Scene(mainRoot, 1000, 760);

        // Handles mouse click events. The mouse click will
        // print in console information useful to the user.
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                // First the console Pane must be cleared, then it can output text
                clearPane(descriptionRoot);

                // Use getIndexX and getIndexY to calculate what position within mapGrid was selected.
                // This position is represented by the index of the 
                // it then prints our that location's name.
                int gridXIndex = getIndexX((int) me.getSceneX());
                int gridYIndex = getIndexY((int) me.getSceneY());

                // Creates a new line in the console.
                updatePane(descriptionRoot, "");

                // If the indexes return are -1, then the user must not
                // have clicked a valid location.
                if (gridXIndex == -1 || gridYIndex == -1) {
                    updatePane(descriptionRoot, "Not a Valid Location!\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                } else {
                    // If the click was on a valid location, the user will see the 
                    // location's name, Terrain Type, and description.
                    Location location = mapArr[gridXIndex][gridYIndex];
                    updatePane(descriptionRoot, "Name:\t\t" + location.getName());
                    updatePane(descriptionRoot, "Terrain:\t\t" + location.getTerrainType());
                    updatePane(descriptionRoot, "Description:\t" + location.getTerrain().getDescription());
                    updatePane(descriptionRoot, "");
                    updatePane(descriptionRoot, "Temperature:\t\t" + location.getTerrain().getTemperature());
                    updatePane(descriptionRoot, "Vegitation:\t\t" + location.getTerrain().getVegitationLevel());
                    updatePane(descriptionRoot, "Metals:\t\t\t" + location.getTerrain().getMetalsLevel());
                    updatePane(descriptionRoot, "Soil:\t\t\t\t" + location.getTerrain().getSoil());
                    updatePane(descriptionRoot, "Open Water:\t\t" + location.getTerrain().isOpenWater());
                    updatePane(descriptionRoot, "");
                    updatePane(descriptionRoot, "\n\n\n\n\n\n");
                }
                
//                scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
//                    @Override
//                    public void handle(KeyEvent t) {
//                        System.out.println(t.getText() + " key pressed");
//                        switch (t.getCharacter().toLowerCase()) {
//                            case "m":
//                                // If the click was on a valid location, the user will see the 
//                                // location's name, Terrain Type, and description.
//                                Location location = mapArr[gridXIndex][gridYIndex];
//                                updatePane(descriptionRoot, "Name:\t\t" + location.getName());
//                                updatePane(descriptionRoot, "Terrain:\t\t" + location.getTerrainType());
//                                updatePane(descriptionRoot, "Description:\t" + location.getTerrain().getDescription());
//                                updatePane(descriptionRoot, "");
//                                updatePane(descriptionRoot, "Temperature:\t\t" + location.getTerrain().getTemperature());
//                                updatePane(descriptionRoot, "Vegitation:\t\t" + location.getTerrain().getVegitationLevel());
//                                updatePane(descriptionRoot, "Metals:\t\t\t" + location.getTerrain().getMetalsLevel());
//                                updatePane(descriptionRoot, "Soil:\t\t\t\t" + location.getTerrain().getSoil());
//                                updatePane(descriptionRoot, "Open Water:\t\t" + location.getTerrain().isOpenWater());
//                                updatePane(descriptionRoot, "");
//                                updatePane(descriptionRoot, "Specific Metals:");
//                                updatePane(descriptionRoot, "Hematite....." + location.getTerrain().getMetals().getHematite() + "%");
//                                updatePane(descriptionRoot, "Cuprite......" + location.getTerrain().getMetals().getCuprite()) + "%";
//                                updatePane(descriptionRoot, "\n\n\n");
//                                break;
//                            case "v":
//                                break;
//                        }
//                    }
//                });
            }
        });


        // Sets State title, version, favicon, scene, and then displays it to user.
        primaryStage.setTitle("Map Generator " + VERSION);
        primaryStage.getIcons().add(new Image("file:\\E:\\Coding Projects\\Finished Projects\\Map Maker Main\\MapMakerV0.5 - FINISHED\\src\\Assets\\Images\\favicon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Creates the large grid interface the user can see.
    // Starts by creating a MapGrid. The type of Map created is 
    // controlled within the MapGrid constructor.
    public GridPane createGridPane() throws IOException {
        // Creates a grid pane with horizontal and vertical gaps of 1 pixel
        // makes the padding/ margins 6 pixels
        GridPane grid = new GridPane();
        grid.setHgap(H_GAP);
        grid.setVgap(V_GAP);
        grid.setPadding(new Insets(PADD, PADD, PADD, PADD));

        // Makes a new MapGrid and gets the location array from it using getGrid().
        MapGrid mainMap = new MapGrid(GRID_SIZE);
        mapArr = mainMap.getGrid();

        // Creates a label in the gridpane for each location in the location array.
        for (int i = 0; i < mapArr.length; i++) {
            for (int j = 0; j < mapArr[0].length; j++) {
                // Creates a new Label with the imageView from location.
                Label lbl = new Label("", mapArr[i][j].getImageView());
                grid.add(lbl, i, j);
            }
        }
        return grid;
    }

    // This creates the consoleRoot by using a label to display
    // the console content.
    public Label createConsolePane() {

        Label inner = new Label();
        // Gives user instruction, along with formatting \t and \n to
        // make the consoleRoot look better
        inner.setText("Click a location to learn information.\t\t\t\t       "
                + "\n - Each Location has many attributes that can be viewed."
                + "\n - Attributes affect many aspects of the world."
                + "\n - The levels for metals and vegitation go from 0 to 100."
                + "\nKey Binds:"
                + "\nm : view specific metals"
                + "\nv : view specific vegitation"
                + "\n");
        // Sets the padding/margins, textWrap, font, and text color.
        inner.setPadding(new Insets(0, PADD, PADD, PADD));
        inner.setWrapText(true);
        inner.setFont(new Font("Bell MT", 20));
        inner.setTextFill(new Color(0.0, 0.28, 0.28, 1.0));
        // This sets the borders for the consoleRoot
        inner.setBorder(new Border(new BorderStroke(
                new Color(0.80, 0.80, 0.80, 1.0),
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                new BorderWidths(10),
                new Insets(-PADD * 2, PADD, PADD, PADD)
        )));

        return inner;
    }

    public Label createDescriptionRoot() {
        Label inner = new Label();
        // Gives user instruction, along with formatting \t and \n to
        // make the consoleRoot look better
        inner.setText("Information: \t\t\t\t\t\t\t           \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        // Sets the padding/margins, textWrap, font, and text color.
        inner.setPadding(new Insets(0, PADD, PADD, PADD));
        inner.setWrapText(true);
        inner.setFont(new Font("Bell MT", 20));
        inner.setTextFill(new Color(0.0, 0.28, 0.28, 1.0));
        // This sets the borders for the consoleRoot
        inner.setBorder(new Border(new BorderStroke(
                new Color(0.80, 0.80, 0.80, 1.0),
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                new BorderWidths(10),
                new Insets(PADD - 1, PADD, PADD, PADD)
        )));

        return inner;
    }

    // This method adds parameter text to the consoleRoot
    public void updatePane(Label lbl, String text) {
        // First add text to the consoleText, then sets the
        // consoleRoot label text to be the consoleText
        consoleText += text + "\n";
        lbl.setText(consoleText);
    }

    // Clears the consoleRoot to make it blank
    // Has formatting to make it look nicer.
    // Gives user instruction.
    public void clearPane(Label lbl) {
        consoleText = "Information: \t\t\t\t\t\t\t           \n";
        lbl.setText(consoleText);
    }

    // Returns the index within mapArr for which the x value was sitting.
    public int getIndexX(int x) {
        int xVal = -1;
        int[] minVals = {7, 58, 109, 160, 211, 262, 313, 364, 415, 466};
        int[] maxVals = {57, 108, 159, 210, 261, 312, 363, 414, 465, 515};
        for (int i = 0; i < 10; i++) {
            if (x >= minVals[i] && x <= maxVals[i]) {
                xVal = i;
            }
        }

        return xVal;
    }

    // Returns the index within mapArr for which the y value was sitting.
    public int getIndexY(int y) {
        int yVal = -1;
        int[] minVals = {7, 58, 109, 160, 211, 262, 313, 364, 415, 466};
        int[] maxVals = {57, 108, 159, 210, 261, 312, 363, 414, 465, 515};
        for (int i = 0; i < 10; i++) {
            if (y >= minVals[i] && y <= maxVals[i]) {
                yVal = i;
            }
        }
        return yVal;
    }

    // Prints the grid into the console using the first letter of the terrain type.
    // very old method that does not see use. 12/14/2018
    public void printMapGrid(Location[][] local) {
        String out = "";
        for (int i = 0; i < local.length; i++) {
            for (int j = 0; j < local[i].length; j++) {
                out += local[j][i].getTerrainType().substring(0, 1) + " ";
            }
            out += "\n";
        }
        System.out.println(out);
    }
} // class END
