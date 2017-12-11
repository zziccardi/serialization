
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
    public MyAllTypesFirst() {}
    
    public MyAllTypesFirst(int myInt, int myOtherInt, long myLong, long myOtherLong, String myString, boolean myBool) {
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
        
        if (myInt != other.get_myInt()) {
            return false;
        }
        
        if (myOtherInt != other.get_myOtherInt()) {
            return false;
        }
        
        if (myLong != other.get_myLong()) {
            return false;
        }
        
        if (myOtherLong != other.get_myOtherLong()) {
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
    
}

