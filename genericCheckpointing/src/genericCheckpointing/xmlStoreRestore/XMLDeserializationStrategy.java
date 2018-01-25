
package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

public class XMLDeserializationStrategy implements DeserializationStrategyI {
    
    @Override
    public SerializableObject deserialize(FileProcessor file) {
        Class<?>           cls      = null;
        SerializableObject instance = null;
        
        String line;
        
        try {
            while ((line = file.readLine()) != null) {
                if (line.equals("") || line.contains("<DPSerialization>") || line.contains("</complexType>")) {
                    continue;
                }
                
                if (line.contains("<complexType")) {
                    // Get the name of the class to create (MyAllTypesFirst or MyAllTypesSecond)
                    String className = line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\""));
                    
                    // Get the Class object for the class name
                    cls = Class.forName(className);
                    
                    // Create an instance of the class
                    instance = (SerializableObject) cls.newInstance();
                }
                
                if (line.contains("<my")) {
                    int startIndex = line.indexOf("<") + 1;
                    
                    String fieldName = line.substring(startIndex, line.indexOf(" ", startIndex));
                    
                    // Use the field name to determine the name of its
                    // associated setter method
                    String methodName = "set_" + fieldName;
                    
                    startIndex = line.indexOf("xsd:") + 4;
                    
                    // Get the type of the value in string form
                    String type = line.substring(startIndex, line.indexOf("\"", startIndex));
                    
                    startIndex = line.indexOf(">") + 1;
                    
                    // Get the value to pass into the setter method in
                    // string form
                    String valueString = line.substring(startIndex, line.indexOf("<", startIndex));
                    
                    Object value = null;
                    
                    if (type.equals("int")) {
                        value = new Integer(valueString);
                    }
                    else if (type.equals("long")) {
                        value = new Long(valueString);
                    }
                    else if (type.equals("string")) {
                        value = valueString;
                    }
                    else if (type.equals("boolean")) {
                        value = new Boolean(valueString);
                    }
                    else if (type.equals("double")) {
                        value = new Double(valueString);
                    }
                    else if (type.equals("float")) {
                        value = new Float(valueString);
                    }
                    else if (type.equals("short")) {
                        value = new Short(valueString);
                    }
                    else if (type.equals("char")) {
                        value = new Character(valueString.charAt(0));
                    }
                    
                    // Get the class' (public) methods via its name
                    Method[] methods = cls.getMethods();
                    
                    Method setterMethod = null;
                    
                    // Find the setter method
                    for (int i = 0; i < methods.length; i++) {
                        if (methods[i].getName().equals(methodName)) {
                            setterMethod = methods[i];
                            
                            break;
                        }
                    }
                    
                    // Call the setter method
                    setterMethod.invoke(instance, value);
                }
                
                // We've finished creating the current object
                if (line.contains("</DPSerialization>")) {
                    break;
                }
            }
        }
        catch (
            ClassNotFoundException    |
            IllegalAccessException    |
            IndexOutOfBoundsException |
            InstantiationException    |
            InvocationTargetException |
            LinkageError              |
            NullPointerException      |
            SecurityException
            e
        ) {
            System.err.println("Could not deserialize object");
            e.printStackTrace();
            System.exit(-1);
        }
        
        return instance;
    }
    
}

