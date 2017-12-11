
package genericCheckpointing.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    
    private ArrayList<String> lines;
    
    public Results() {
        lines = new ArrayList<>();
        
        //MyLogger.writeMessage("Results constructor invoked", MyLogger.DebugLevel.CONSTRUCTOR);
    }
    
    /**
     * Store a word in lines to be printed or written to an output file
     * @param word - the word to add to lines
     */
    public void storeNewResult(String word) {
        lines.add(word);
    }
    
    /**
     * Write the stored lines to the output file
     * @param fileName - name of the file to write to
     */
    @Override
    public void writeToFile(String fileName) {
        try {
            Path path = Paths.get(fileName);
            
            // Automatically closes the file even if an exception occurs
            // NOTE: This seems to print an extra line at the end of
            // the output file
            Files.write(path, lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
        catch (InvalidPathException | IOException | UnsupportedOperationException | SecurityException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        finally {
            // Do nothing!
        }
    }
    
    /**
     * Write the stored lines to stdout
     */
    @Override
    public void writeToStdout() {
        for (String line : lines) {
            //System.out.println(line);
            //MyLogger.writeMessage(line, MyLogger.DebugLevel.STDOUT);
        }
    }
    
    /**
     * Return a string representation of lines
     * @return string
     */
    @Override
    public String toString() {
        return Arrays.toString(lines.toArray());
    }
    
}

