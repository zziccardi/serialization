
package genericCheckpointing.driver;

import java.util.Vector;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

public class Driver {
    
    public static void main(String[] args) {
	    if (args.length != 3) {
	        System.err.println("Usage: <mode> <number of objects> <file name>");
	        System.exit(-1);
	    }
	    
	    String mode = args[0];
	    
	    if (!(mode.equals("serdeser") || mode.equals("deser"))) {
	        System.err.println("Invalid mode (must be \"serdeser\" or \"deser\")");
	        System.exit(-1);
	    }
	    
	    // The number of objects of both MyAllTypesFirst and MyAllTypesSecond
	    int numObjects = -1;
	    
	    try {
            numObjects = Integer.parseInt(args[2]);
        }
        catch (NumberFormatException e) {
            System.err.println("Could not parse number of objects as integer");
            e.printStackTrace();
            System.exit(-1);
        }
        finally {
            // Do nothing!
        }
	    
	    String fileName = args[2];
	
	    ProxyCreator pc = new ProxyCreator();
	    
	    // Create a proxy
	    StoreRestoreI proxy = (StoreRestoreI) pc.createProxy(
            new Class[] {
                StoreI.class,
                RestoreI.class
            }, 
            new StoreRestoreHandler()
        );
        
        // Create two vectors of SerializableObject, to be populated
        // with instances of MyAllTypesFirst and MyAllTypesSecond
        Vector<SerializableObject> serialized  = new Vector<>();
        Vector<SerializableObject> deserialzed = new Vector<>();
		
		// FIXME: invoke a method on the handler instance to set the file name and open the file
	    
	    // Create a bunch of objects, serialize them, then deserialze
	    // them and ensure the values are identical
	    if (mode.equals("serdeser")) {
	        MyAllTypesFirst  myFirst  = null;
	        MyAllTypesSecond mySecond = null;

            // Create and serialize a bunch of objects
	        for (int i = 0; i < numObjects; i++) {

	            // FIXME: create these object instances correctly using an explicit value constructor
	            // use the index variable of this loop to change the values of the arguments to
	            // these constructors
	            
	            //myFirst = new MyAllTypesFirst(...);
	            //mySecond = new MyAllTypesSecond(...);

	            // FIXME: store myFirst and mySecond in the data structure
	            
	            ((StoreI) proxy).writeObj(myFirst, "XML");
	            ((StoreI) proxy).writeObj(mySecond, "XML");
	        }

	        SerializableObject obj;

            // Deserialize the objects
	        for (int i = 0; i < 2 * numObjects; i++) {
	            obj = ((RestoreI) proxy).readObj("XML");
	            
	            // FIXME: store obj in the vector
	        }

	        // FIXME: invoke a method on the handler to close the file (if it hasn't already been closed)

	        // FIXME: compare and confirm that the serialized and deserialzed objects are equal. 
	        // The comparison should use the equals and hashCode methods. Note that hashCode 
	        // is used for key-value based data structures
	        
	        
	    }
	    // Deserialize the input file
	    else if (mode.equals("deser")) {
	        
	        
	        // TODO
	        
	        
	    }
    }
    
}

