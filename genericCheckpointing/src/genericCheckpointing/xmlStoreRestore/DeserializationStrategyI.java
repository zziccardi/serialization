
package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;

public interface DeserializationStrategyI {
    
    SerializableObject deserialize(String fileName);
    
}

