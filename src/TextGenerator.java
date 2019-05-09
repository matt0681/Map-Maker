// Matthew Lad

// Necessary imports.
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// This class generates random names for naming locations.
// It relies on names.txt
public class TextGenerator {
    
    // This is the number of lines in names.txt
    final int NAMES_LENGTH = 8;
    // This is the String for the names.txt file location
    final String namesFile = "E:\\Coding Projects\\Finished Projects\\Map Maker Main\\MapMakerV0.5 - FINISHED\\src\\Assets\\Text\\names.txt";
    // array represents the different names within names.txt
    ArrayList<String> namesArray;
    
    // This constructor reads the names off of names.txt and
    // puts them into namesArray
    public TextGenerator() throws FileNotFoundException, IOException {
        // Uses BufferedReader class to read the names.txt file
        BufferedReader br = new BufferedReader(new FileReader(new File(namesFile)));

        // Uses for loops to go through names.txt
        // First splits it line by line, it then splits it up based on each
        // comma, the only character separating each word.
        String st = "";
        String out = "";
        namesArray = new ArrayList<>();

        for (int i = 0; i < NAMES_LENGTH; i++) {
            st = br.readLine();
            int begin = 0;
            for (int j = 0; j < st.length(); j++) {
                if (st.charAt(j) == ',') {
                    namesArray.add(st.substring(begin, j));
                    begin = j + 1;
                }
            }
        }
    }
    
    
    // These four classes return a random name from namesArray
    public String getRandomOceanName(){
        int rand = (int) (Math.random() * namesArray.size());
        return namesArray.get(rand);
    }
    
    public String getRandomPlainsName(){
        int rand = (int) (Math.random() * namesArray.size());
        return namesArray.get(rand);
    }
    
    public String getRandomDesertName(){
        int rand = (int) (Math.random() * namesArray.size());
        return namesArray.get(rand);
    }
    
    public String getRandomForestName(){
        int rand = (int) (Math.random() * namesArray.size());
        return namesArray.get(rand);
    }
}
