public class Frame { 
    private final byte[] data;
    public Frame(byte[] d)
    { 
        this.data=d; 
    }
    public int getSize(){
        return data.length;
    }
}
