public class Demo02 {
    public static void main(String[] args) {
        Player player = new Player(
                new SimpleDecoder(),
                new SimpleUI(),
                new SimpleCache()
        );

        byte[] sample = new byte[] {0, 1, 2, 3, 4, 5};
        player.play(sample);
    }
}
