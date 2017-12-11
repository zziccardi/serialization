
package genericCheckpointing.xmlStoreRestore;

public class SerializeTypes {
    
    private static String serialize(String name, String value, String type) {
        return "    <" + name + " xsi:type=\"xsd:" + type + "\">" + value + "</" + name + ">";
    }
    
    public static String serializeInt(String name, String value) {
        return serialize(name, value, "int");
    }
    
    public static String serializeLong(String name, String value) {
        return serialize(name, value, "long");
    }
    
    public static String serializeString(String name, String value) {
        return serialize(name, value, "string");
    }
    
    public static String serializeBoolean(String name, String value) {
        return serialize(name, value, "boolean");
    }
    
    public static String serializeDouble(String name, String value) {
        return serialize(name, value, "double");
    }
    
    public static String serializeFloat(String name, String value) {
        return serialize(name, value, "float");
    }
    
    public static String serializeShort(String name, String value) {
        return serialize(name, value, "short");
    }
    
    public static String serializeChar(String name, String value) {
        return serialize(name, value, "char");
    }
    
}

