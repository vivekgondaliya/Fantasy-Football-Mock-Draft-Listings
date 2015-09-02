import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 Input: A text file that consists picks from a Fantasy Football Mock Draft
 Output: A text file to retrieve my picks from the draft that starts with ** pattern  
*/

public class FantasyFootballMockDraft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// The name of the file to open.
		String fileName = "mockDraft.txt";
        
		//Pattern Matching 
	    Pattern patt = Pattern.compile("^(\\**)");
	    Matcher m = patt.matcher(fileName);
	    
        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader -Why?
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            //Create a file new Output File
            File file = new File("myMockDraft.txt");
            
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			
			//FileWriter writes into a text file
			FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
			//Wrap FileWriter in BufferedWriter -Why?
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
            //while there is a line, keep reading
			while((line = bufferedReader.readLine()) != null) {
				//if the line starts is not empty and ** then write/print to file
            	if(!line.equals("") && line.substring(0, 2).equals("**")){
					//get the value after "**"
					line = line.substring(2);
					//write the draft pick to the file
					bufferedWriter.write(line);
					bufferedWriter.newLine();
            	}
            }    

            // Always close files.
            bufferedReader.close();
            bufferedWriter.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                   
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }

}


