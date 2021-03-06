
package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

public class StoreRestoreHandler implements InvocationHandler {
    
    private String        fileName;
    private FileProcessor processor;
    
    public StoreRestoreHandler(String fileName) {
        this.fileName = fileName;
        
        processor = new FileProcessor(fileName);
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        
        if (methodName.equals("writeObj")) {
            if (((String) args[1]).equals("XML")) {
                SerializableObject obj = (SerializableObject) args[0];
                
                serialize(obj, new XMLSerializationStrategy());
            }
        }
        else if (methodName.equals("readObj")) {
            if (((String) args[0]).equals("XML")) {
                return deserialize(new XMLDeserializationStrategy());
            }
        }
        
        return null;
    }
    
    private void serialize(SerializableObject obj, SerializationStrategyI strategy) {
        strategy.serialize(obj, fileName);
    }
    
    private SerializableObject deserialize(DeserializationStrategyI strategy) {
        return strategy.deserialize(processor);
    }
    
    public void openFile() {
        processor.openFile();
    }
    
    public void closeFile() {
        processor.closeFile();
    }
    
}

