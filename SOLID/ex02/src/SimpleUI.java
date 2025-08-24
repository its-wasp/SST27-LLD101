public class SimpleUI implements UI{
    @Override
    public void render(Frame frame){
        System.out.println("\u25B6 Playing " + frame.getSize() + " bytes");
    }
}
