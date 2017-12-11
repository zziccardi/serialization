
package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;

public interface SerializationStrategyI {
    
    void serialize(SerializableObject obj, String fileName);
    
}

