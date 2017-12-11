
package genericCheckpointing.util;

import java.util.Objects;

public class MyAllTypesSecond extends SerializableObject {
    
    private double myDoubleT;
    private double myOtherDoubleT;
    private float  myFloatT;
    private short  myShortT;
    private short  myOtherShortT;
    private char   myCharT;
    
    // Used in XMLDeserializationStrategy
    public MyAllTypesSecond() {
        this.myDoubleT      = -1;
        this.myOtherDoubleT = -1;
        this.myFloatT       = -1;
        this.myShortT       = -1;
        this.myOtherShortT  = -1;
        this.myCharT        = (char) 32;
    }
    
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
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        
        if (!(obj instanceof MyAllTypesSecond)) {
            return false;
        }
        
        MyAllTypesSecond other = (MyAllTypesSecond) obj;
        
        if ((myDoubleT >= 10) && (myDoubleT != other.get_myDoubleT())) {
            return false;
        }
        
        if ((myOtherDoubleT >= 10) && (myOtherDoubleT != other.get_myOtherDoubleT())) {
            return false;
        }
        
        if (myFloatT != other.get_myFloatT()) {
            return false;
        }
        
        if (myShortT != other.get_myShortT()) {
            return false;
        }
        
        if (myOtherShortT != other.get_myOtherShortT()) {
            return false;
        }
        
        if (myCharT != other.get_myCharT()) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(myDoubleT, myOtherDoubleT, myFloatT, myShortT, myOtherShortT, myCharT);
    }
    
    @Override
    public String toString() {
        String s = "MyAllTypesSecond\n";
        
        s += "myDoubleT:      " + String.valueOf(myDoubleT)      + "\n";
        s += "myOtherDoubleT: " + String.valueOf(myOtherDoubleT) + "\n";
        s += "myFloatT:       " + String.valueOf(myFloatT)       + "\n";
        s += "myShortT:       " + String.valueOf(myShortT)       + "\n";
        s += "myOtherShortT:  " + String.valueOf(myOtherShortT)  + "\n";
        s += "myCharT:        " + String.valueOf(myCharT)        + "\n\n";
        
        return s;
    }
    
}

