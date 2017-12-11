
package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject {
    
    private double myDoubleT;
    private double myOtherDoubleT;
    private float  myFloatT;
    private short  myShortT;
    private short  myOtherShortT;
    private char   myCharT;
    
    public MyAllTypesSecond(double myDoubleT, double myOtherDoubleT, float myFloatT, short myShortT, short myOtherShortT, char myCharT) {
        this.myDoubleT      = myDoubleT;
        this.myOtherDoubleT = myOtherDoubleT;
        this.myFloatT       = myFloatT;
        this.myShortT       = myShortT;
        this.myOtherShortT  = myOtherShortT;
        this.myCharT        = myCharT;
    }
    
    public void set_myDoubleT(double d) {
        myDoubleT = d;
    }
    
    public double get_myDoubleT() {
        return myDoubleT;
    }
    
    public void set_myOtherDoubleT(double d) {
        myOtherDoubleT = d;
    }
    
    public double get_myOtherDoubleT() {
        return myOtherDoubleT;
    }
    
    public void set_myFloatT(float f) {
        myFloatT = f;
    }
    
    public float get_myFloatT() {
        return myFloatT;
    }
    
    public void set_myShortT(short s) {
        myShortT = s;
    }
    
    public short get_myShortT() {
        return myShortT;
    }
    
    public void set_myOtherShortT(short s) {
        myOtherShortT = s;
    }
    
    public short get_myOtherShortT() {
        return myOtherShortT;
    }
    
    public void set_myCharT(char c) {
        myCharT = c;
    }
    
    public char get_myCharT() {
        return myCharT;
    }
    
}

