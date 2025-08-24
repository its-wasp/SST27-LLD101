public class Player {

    private final Decoder decoder;
    private final UI ui;
    private final Cache cache;

    public Player(Decoder decoder, UI ui, Cache cache){
        this.decoder = decoder;
        this.ui = ui;
        this.cache = cache;
    }

    public void play(byte[] fileBytes){
        Frame f = decoder.decode(fileBytes);
        ui.render(f);
        cache.cacheLast(f);
        System.out.println("Cached last frame? " + cache.isLastCached());
    }
}
