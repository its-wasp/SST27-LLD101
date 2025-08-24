public class SimpleDecoder implements Decoder {

    @Override
    public Frame decode(byte[] data) {
        return new Frame(data);
    }
}