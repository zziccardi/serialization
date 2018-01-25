
package genericCheckpointing.util;

import java.util.Objects;

public class MyAllTypesFirst extends SerializableObject {
    
    private int     myInt;
    private int     myOtherInt;
    private long    myLong;
    private long    myOtherLong;
    private String  myString;
    private boolean myBool;
    
    // Used in XMLDeserializationStrategy
    public MyAllTypesFirst() {
        this.myInt       = -1;
        this.myOtherInt  = -1;
        this.myLong      = -1;
        this.myOtherLong = -1;
        this.myString    = "";
        this.myBool      = false;
    }
    
    public MyAllTypesFirst(
        int     myInt,
        int     myOtherInt,
        long    myLong,
        long    myOtherLong,
        String  myString,
        boolean myBool
    ) {
        this.myInt       = myInt;
        this.myOtherInt  = myOtherInt;
        this.myLong      = myLong;
        this.myOtherLong = myOtherLong;
        this.myString    = myString;
        this.myBool      = myBool;
    }
    
    public void set_myInt(int i) {
        myInt = i;
    }
    
    public int get_myInt() {
        return myInt;
    }
    
    public void set_myOtherInt(int i) {
        myOtherInt = i;
    }
    
    public int get_myOtherInt() {
        return myOtherInt;
    }
    
    public void set_myLong(long l) {
        myLong = l;
    }
    
    public long get_myLong() {
        return myLong;
    }
    
    public void set_myOtherLong(long l) {
        myOtherLong = l;
    }
    
    public long get_myOtherLong() {
        return myOtherLong;
    }
    
    public void set_myString(String s) {
        myString = s;
    }
    
    public String get_myString() {
        return myString;
    }
    
    public void set_myBool(boolean b) {
        myBool = b;
    }
    
    public boolean get_myBool() {
        return myBool;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        
        if (!(obj instanceof MyAllTypesFirst)) {
            return false;
        }
        
        MyAllTypesFirst other = (MyAllTypesFirst) obj;
        
        if ((myInt >= 10) && (myInt != other.get_myInt())) {
            return false;
        }
        
        if ((myOtherInt >= 10) && (myOtherInt != other.get_myOtherInt())) {
            return false;
        }
        
        if ((myLong >= 10) && (myLong != other.get_myLong())) {
            return false;
        }
        
        if ((myOtherLong >= 10) && (myOtherLong != other.get_myOtherLong())) {
            return false;
        }
        
        if (!myString.equals(other.get_myString())) {
            return false;
        }
        
        if (myBool != other.get_myBool()) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(myInt, myOtherInt, myLong, myOtherLong, myString, myBool);
    }
    
    @Override
    public String toString() {
        String s = "MyAllTypesFirst\n";
        
        s += "myInt:       " + String.valueOf(myInt)       + "\n";
        s += "myOtherInt:  " + String.valueOf(myOtherInt)  + "\n";
        s += "myLong:      " + String.valueOf(myLong)      + "\n";
        s += "myOtherLong: " + String.valueOf(myOtherLong) + "\n";
        s += "myString:    " + myString                    + "\n";
        s += "myBool:      " + String.valueOf(myBool)      + "\n\n";
        
        return s;
    }
}

