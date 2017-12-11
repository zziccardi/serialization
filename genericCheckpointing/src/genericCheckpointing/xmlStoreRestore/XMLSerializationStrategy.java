
package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import genericCheckpointing.util.Results;
import genericCheckpointing.util.SerializableObject;

public class XMLSerializationStrategy implements SerializationStrategyI {
    
    @Override
    public void serialize(SerializableObject obj, String fileName) {
        // Used to write to the file
        Results results = new Results();
        
        results.storeNewResult("<DPSerialization>");
        
        // Get the runtime class (MyAllTypesFirst or MyAllTypesSecond)
        Class<?> cls = obj.getClass();
        
        // Get the class' fully qualified name
        String className = cls.getName();
        
        results.storeNewResult("  <complexType xsi:type=\"" + className + "\">");
        
        try {
            // Get the class' fields (including private ones)
            Field[] fields = cls.getDeclaredFields();
            
            // For each of the fields...
            for (int i = 0; i < fields.length; i++) {
                Class<?> fieldType = fields[i].getType();
                String   fieldName = fields[i].getName();
                
                // Use the field name to determine the name of its
                // associated getter method
                String methodName = "get_" + fieldName;
                
                // Get the getter method via its name
                Method getterMethod = cls.getMethod(methodName);
                
                // Call the object's getter method and store the result
                // as a string
                String result = getterMethod.invoke(obj).toString();
                
                if (fieldType == int.class) {
                    if (Integer.valueOf(result) >= 10) {
                        results.storeNewResult(SerializeTypes.serializeInt(fieldName, result));
                    }
                }
                else if (fieldType == long.class) {
                    if (Long.valueOf(result) >= 10) {
                        results.storeNewResult(SerializeTypes.serializeLong(fieldName, result));
                    }
                }
                else if (fieldType == String.class) {
                    results.storeNewResult(SerializeTypes.serializeString(fieldName, result));
                }
                else if (fieldType == boolean.class) {
                    results.storeNewResult(SerializeTypes.serializeBoolean(fieldName, result));
                }
                else if (fieldType == double.class) {
                    if (Double.valueOf(result) >= 10) {
                        results.storeNewResult(SerializeTypes.serializeDouble(fieldName, result));
                    }
                }
                else if (fieldType == float.class) {
                    results.storeNewResult(SerializeTypes.serializeFloat(fieldName, result));
                }
                else if (fieldType == short.class) {
                    results.storeNewResult(SerializeTypes.serializeShort(fieldName, result));
                }
                else if (fieldType == char.class) {
                    results.storeNewResult(SerializeTypes.serializeChar(fieldName, result));
                }
            }
        }
        catch (ExceptionInInitializerError | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | NullPointerException | SecurityException e) {
            System.err.println("Could not serialize object");
            e.printStackTrace();
            System.exit(-1);
        }
        
        results.storeNewResult("  </complexType>");
        results.storeNewResult("</DPSerialization>");
        
        // Create the file if it doesn't exist, otherwise append to it
        results.writeToFile(fileName);
    }
    
}

