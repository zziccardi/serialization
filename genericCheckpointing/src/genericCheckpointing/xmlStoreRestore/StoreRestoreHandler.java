
package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import genericCheckpointing.util.SerializableObject;

public class StoreRestoreHandler implements InvocationHandler {
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        
        if (methodName.equals("writeObj")) {
            SerializableObject obj = (SerializableObject) args[0];
            
            
            
            
        }
        else if (methodName.equals("readObj")) {
            
            
            
        }
        
        return null;
    }
    
    public void openFile(String fileName) {
        
        
        
    }
    
    public void closeFile() {
        
        
        
    }
    
}

