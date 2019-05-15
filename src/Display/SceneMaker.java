// Matthew Lad
// 2/10/2019

package Display;

// Necessary imports.
import MapControl.Biome;
import MapControl.Tribe;
import MapControl.WorldMaker;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

// Builds the Scene.
public class SceneMaker {
    private final int WIDTH = 1024;
    private final int HEIGHT = 820; //768
    private final int PADDING = 6;
    private final int worldSize = 10;
    
    private Scene scene;
    private WorldMaker world;
    
    private TextArea instructionRoot;
    private TextArea informationRoot;
    private Label timeTextRoot;
    private Button playButton;
    private Button stopButton;
    
    private Label[][] lblLayerOneMapArr;
    private Label[][] lblLayerTwoMapArr;
    private Biome[][] biomeMapArr;
    private Tribe[][] tribeMapArr;
    
    private String informationText;
    private String instructionText;
    private String timeText;
            
    // Constructor
    public SceneMaker() throws IOException {
        
        GridPane mapRoot = createMapRoot();
        HBox timeRoot = createTimeRoot();
        instructionRoot = createInstructionsRoot();
        informationRoot = createInformationRoot();

        BorderPane mainRoot = createBorderPane(mapRoot, timeRoot, instructionRoot, informationRoot);
        
        scene = new Scene(mainRoot, WIDTH, HEIGHT);
    }
    
    
    private GridPane createMapRoot() throws IOException {
        GridPane grid = new GridPane();
        grid.setHgap(1);
        grid.setVgap(1);

        // Makes a new MapGrid and gets the location array from it using getBiomeGrid().
        WorldMaker mainMap = new WorldMaker(worldSize);
        biomeMapArr = mainMap.getBiomeGrid();
        tribeMapArr = mainMap.getTribeGrid();
        
        lblLayerOneMapArr = new Label[worldSize][worldSize];
        lblLayerTwoMapArr = new Label[worldSize][worldSize];
        
        for (int i = 0; i < worldSize; i++) {
            for (int j = 0; j < worldSize; j++) {
                lblLayerOneMapArr[i][j] = new Label("", biomeMapArr[i][j].getImageView());
                lblLayerTwoMapArr[i][j] = new Label("", tribeMapArr[i][j].getImageView());
                
                StackPane allLayers = new StackPane();
                allLayers.getChildren().addAll(lblLayerOneMapArr[i][j], lblLayerTwoMapArr[i][j]);
                allLayers.setAlignment(lblLayerTwoMapArr[i][j], Pos.CENTER);
                grid.add(allLayers, i, j);
            }
        }
        
        
        return grid;
    }
    
    private TextArea createInstructionsRoot(){
        
        TextArea out = new TextArea();

        out.setWrapText(true);
        out.setEditable(false);
        
        instructionText = "Click a location to learn information."
                + "\n - Each Location has many attributes that can be viewed."
                + "\n - Attributes affect many aspects of the world."
                + "\n - The levels for metals and vegitation go from 0 to 100.\n";
        out.setText(instructionText);
        out.setFont(new Font("Bell MT", 20));
        out.setBorder(new Border(new BorderStroke(
                new Color(0.80, 0.80, 0.80, 1.0),
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                new BorderWidths(PADDING*1.5), //12
                new Insets(0)
        )));
        out.setPrefSize(WIDTH, 238);

        return out;
    }
    
    private TextArea createInformationRoot(){
        
        TextArea out = new TextArea();
        
        out.setWrapText(true);
        out.setEditable(false);
        
        informationText = "Information: \n";
        out.setText(informationText);
        out.setFont(new Font("Bell MT", 20));
        out.setBorder(new Border(new BorderStroke(
                new Color(0.80, 0.80, 0.80, 1.0),
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                new BorderWidths(PADDING*1.5),
                new Insets(0)
        )));
        out.setPrefSize(494, 0);

        return out;
    }
    
    private HBox createTimeRoot() {
        
        HBox out = new HBox();
        out.setSpacing(PADDING);
        
        playButton = new Button();
        playButton.setText("Play");
        playButton.setMinHeight(50);
        
        stopButton = new Button();
        stopButton.setText("Stop");
        stopButton.setMinHeight(50);
        
        timeTextRoot = new Label();
        timeTextRoot.setWrapText(true);
        timeText = " TIME: ";
        timeTextRoot.setText(timeText);
        timeTextRoot.setFont(new Font("Bell MT", 20));
        timeTextRoot.setPrefSize(900, 50);
        
        out.getChildren().addAll(playButton, stopButton, timeTextRoot);
        
        return out;
    }
    
    private BorderPane createBorderPane(GridPane map, HBox time, TextArea instrc, TextArea info) {
        BorderPane out = new BorderPane();
        
        out.setLeft(map);
        out.setBottom(instrc);
        out.setRight(info);
        out.setTop(time);
        
        BorderPane.setMargin(info, new Insets(PADDING, PADDING, 0, 0));
        BorderPane.setMargin(instrc, new Insets(PADDING ,PADDING, PADDING, PADDING));
        BorderPane.setMargin(map, new Insets(PADDING*2, 0, 0, PADDING*2));
        BorderPane.setMargin(time, new Insets(PADDING, PADDING, 0, PADDING));
       
        return out;
    }
    
    
    // Text updating classes
    public void addInformationTextln(String text){
        informationText += text += "\n";
        informationRoot.setText(informationText);
    }
    
    public void addInformationText(String text) {
        informationText += text;
        informationRoot.setText(informationText);
    }
    
    public void addInstructionTextln(String text){
        instructionText += text += "\n";
        instructionRoot.setText(instructionText);
    }
    
    public void addInstructionText(String text) {
        instructionText += text;
        instructionRoot.setText(instructionText);
    }
    
    public void addTimeText(String text){
        timeText += text;
        timeTextRoot.setText(timeText);
    }
    
    public void clearTimeRoot(){
        timeText = "";
    }
    
    public void clearInstructionRoot(){
        instructionText = "";
    }
    
    public void clearInformationRoot() {
        informationText = "";
    }
    
    
    // Getter Methods
    public Scene getScene() {
        return scene;
    }
    
    public Button getPlayButton(){
        return playButton;
    }
    
    public Button getStopButton(){
        return stopButton;
    }
    
    public Biome[][] getBiomeMapArr(){
        return biomeMapArr;
    }

    public Tribe[][] getTribeMapArr() {
        return tribeMapArr;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getPADDING() {
        return PADDING;
    }
}
