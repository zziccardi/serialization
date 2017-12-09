
package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject {
    
    private double myDoubleT;
    private double myOtherDoubleT;
    private float  myFloatT;
    private short  myShortT;
    private short  myOtherShortT;
    private char   myCharT;
    
    public void setMyDoubleT(double d) {
        myDoubleT = d;
    }
    
    public double getMyDoubleT() {
        return myDoubleT;
    }
    
    public void setMyOtherDoubleT(double d) {
        myOtherDoubleT = d;
    }
    
    public double getMyOtherDoubleT() {
        return myOtherDoubleT;
    }
    
    public void setMyFloatT(float f) {
        myFloatT = f;
    }
    
    public float getMyFloatT() {
        return myFloatT;
    }
    
    public void setMyShortT(short s) {
        myShortT = s;
    }
    
    public short getMyShortT() {
        return myShortT;
    }
    
    public void setMyOtherShortT(short s) {
        myOtherShortT = s;
    }
    
    public short getMyOtherShortT() {
        return myOtherShortT;
    }
    
    public void setMyCharT(char c) {
        myCharT = c;
    }
    
    public char getMyCharT() {
        return myCharT;
    }
    
}

