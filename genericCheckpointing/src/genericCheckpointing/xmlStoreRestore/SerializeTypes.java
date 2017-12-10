
package genericCheckpointing.xmlStoreRestore;

public class SerializeTypes {
    
    public String serializeInt(String name, int value) {
        return "    <" + name + " xsi:type=\"xsd:int\">" + String.valueOf(value) + "</" + name + ">";
    }
    
    public String serializeLong(String name, long value) {
        return "    <" + name + " xsi:type=\"xsd:long\">" + String.valueOf(value) + "</" + name + ">";
    }
    
    public String serializeString(String name, String value) {
        return "    <" + name + " xsi:type=\"xsd:string\">" + value + "</" + name + ">";
    }
    
    public String serializeBoolean(String name, boolean value) {
        return "    <" + name + " xsi:type=\"xsd:boolean\">" + String.valueOf(value) + "</" + name + ">";
    }
    
    public String serializeDouble(String name, double value) {
        return "    <" + name + " xsi:type=\"xsd:double\">" + String.valueOf(value) + "</" + name + ">";
    }
    
    public String serializeFloat(String name, float value) {
        return "    <" + name + " xsi:type=\"xsd:float\">" + String.valueOf(value) + "</" + name + ">";
    }
    
    public String serializeShort(String name, short value) {
        return "    <" + name + " xsi:type=\"xsd:short\">" + String.valueOf(value) + "</" + name + ">";
    }
    
    public String serializeChar(String name, char value) {
        return "    <" + name + " xsi:type=\"xsd:char\">" + String.valueOf(value) + "</" + name + ">";
    }
    
}

