
package genericCheckpointing.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class FileProcessor {
    
    private List<String> lines;
    private ListIterator<String> iter;
    
    public FileProcessor(String fileName) {
        try {
            Path path = Paths.get(fileName);
            
            // Automatically closes the file even if an exception occurs
            // WARNING: Reads all lines from a file into memory, so
            // don't use for large files!
            lines = Files.readAllLines(path);
        }
        catch (InvalidPathException | IOException | SecurityException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        finally {
            // Do nothing!
        }
        
        iter = lines.listIterator();
        
        //MyLogger.writeMessage("FileProcessor constructor invoked", MyLogger.DebugLevel.CONSTRUCTOR);
    }
    
    /**
     * Return one line from the list
     * @return line - null if all lines were already returned
     */
    public String readLine() {
        if (iter.hasNext()) {
            return iter.next();
        }
        
        return null;
    }
    
    /**
     * Return a string representation of the values in the list
     * @return string
     */
    @Override
    public String toString() {
        return Arrays.toString(lines.toArray());
    }
    
}

