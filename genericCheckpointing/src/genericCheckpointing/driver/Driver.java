
package genericCheckpointing.driver;

import java.util.concurrent.ThreadLocalRandom;
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
            numObjects = Integer.parseInt(args[1]);
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
            new StoreRestoreHandler(fileName)
        );
        
        // Create two vectors of SerializableObject, to be populated
        // with instances of MyAllTypesFirst and MyAllTypesSecond
        Vector<SerializableObject> serialized   = new Vector<>();
        Vector<SerializableObject> deserialized = new Vector<>();
		
        // Create a bunch of objects, serialize them, then deserialze
	    // them and ensure the values are identical
	    if (mode.equals("serdeser")) {
	        // Create and serialize a bunch of objects
	        for (int i = 0; i < numObjects; i++) {
                MyAllTypesFirst  myFirst;
	            MyAllTypesSecond mySecond;
                
                int     myInt       = ThreadLocalRandom.current().nextInt(0, 100);
                int     myOtherInt  = ThreadLocalRandom.current().nextInt(0, 100);
                long    myLong      = ThreadLocalRandom.current().nextInt(0, 100);
                long    myOtherLong = ThreadLocalRandom.current().nextInt(0, 100);
                String  myString    = String.valueOf(ThreadLocalRandom.current().nextInt(0, 100));
                boolean myBool      = (i % 2 == 0);

	            myFirst = new MyAllTypesFirst(myInt, myOtherInt, myLong, myOtherLong, myString, myBool);
	            
	            double myDoubleT      = ThreadLocalRandom.current().nextInt(0, 100);
	            double myOtherDoubleT = ThreadLocalRandom.current().nextInt(0, 100);
	            float  myFloatT       = ThreadLocalRandom.current().nextInt(0, 100);
	            short  myShortT       = (short) ThreadLocalRandom.current().nextInt(0, 100);
	            short  myOtherShortT  = (short) ThreadLocalRandom.current().nextInt(0, 100);
	            char   myCharT        = (char)  ThreadLocalRandom.current().nextInt(32, 126 + 1);
	            
	            mySecond = new MyAllTypesSecond(myDoubleT, myOtherDoubleT, myFloatT, myShortT, myOtherShortT, myCharT);
	            
	            // Write the objects to the file via the proxy
	            ((StoreI) proxy).writeObj(myFirst, "XML");
	            ((StoreI) proxy).writeObj(mySecond, "XML");
	            
	            // Add the objects to the vector for comparison with the
	            // objects that are deserialized later
	            serialized.add(myFirst);
	            serialized.add(mySecond);
	        }

	        // Deserialize the objects
	        for (int i = 0; i < 2 * numObjects; i++) {
	            // Read the objects from the file via the proxy
	            SerializableObject obj = ((RestoreI) proxy).readObj("XML");
	            
	            // Add the deserialized object to the vector for
	            // comparison with the objects that were serialized
	            deserialized.add(obj);
	        }


	        // TODO: compare and confirm that the serialized and deserialized objects are equal. 
	        // The comparison should use the equals and hashCode methods. Note that hashCode 
	        // is used for key-value based data structures
	        
	        
	    }
	    // Deserialize the input file
	    else if (mode.equals("deser")) {
	        
	        
	        // TODO
	        
	        
	    }
    }
    
}

