
package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

public interface DeserializationStrategyI {
    
    SerializableObject deserialize(FileProcessor processor);
    
}

