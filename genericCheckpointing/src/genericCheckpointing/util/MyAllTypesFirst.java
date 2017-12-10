
package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject {
    
    private int     myInt;
    private int     myOtherInt;
    private long    myLong;
    private long    myOtherLong;
    private String  myString;
    private boolean myBool;
    
    public MyAllTypesFirst(int myInt, int myOtherInt, long myLong, long myOtherLong, String myString, boolean myBool) {
        this.myInt       = myInt;
        this.myOtherInt  = myOtherInt;
        this.myLong      = myLong;
        this.myOtherLong = myOtherLong;
        this.myString    = myString;
        this.myBool      = myBool;
    }
    
    public void setMyInt(int i) {
        myInt = i;
    }
    
    public int getMyInt() {
        return myInt;
    }
    
    public void setMyOtherInt(int i) {
        myOtherInt = i;
    }
    
    public int getMyOtherInt() {
        return myOtherInt;
    }
    
    public void setMyLong(long l) {
        myLong = l;
    }
    
    public long getMyLong() {
        return myLong;
    }
    
    public void setMyOtherLong(long l) {
        myOtherLong = l;
    }
    
    public long getMyOtherLong() {
        return myOtherLong;
    }
    
    public void setMyString(String s) {
        myString = s;
    }
    
    public String getMyString() {
        return myString;
    }
    
    public void setMyBool(boolean b) {
        myBool = b;
    }
    
    public boolean getMyBool() {
        return myBool;
    }
    
}

