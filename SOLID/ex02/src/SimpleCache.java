public class SimpleCache implements Cache{
    private Frame last;

    @Override
    public void cacheLast(Frame frame){
        this.last=frame;
    }

    @Override
    public boolean isLastCached(){
        return this.last!=null;
    }
}
