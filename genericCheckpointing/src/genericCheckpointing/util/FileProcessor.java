
package genericCheckpointing.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
    
    private String         fileName;
    private FileReader     fileReader;
    private BufferedReader bufferedReader;
    
    public FileProcessor(String fileName) {
        this.fileName = fileName;
    }
    
    public void openFile() {
        try {
            fileReader     = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
        }
        catch (FileNotFoundException e) {
            System.err.println("Could not open file " + fileName);
            e.printStackTrace();
            System.exit(-1);
        }
    }
    
    public String readLine() {
        String line = null;
        
        try {
            line = bufferedReader.readLine();
        }
        catch (IOException e) {
            System.err.println("Could not read from file " + fileName);
            e.printStackTrace();
            System.exit(-1);
        }
        
        return line;
    }
    
    public void closeFile() {
        try {
            bufferedReader.close();
        }
        catch (IOException e) {
            System.err.println("Could not close file " + fileName);
            e.printStackTrace();
            System.exit(-1);
        }
    }
    
}

