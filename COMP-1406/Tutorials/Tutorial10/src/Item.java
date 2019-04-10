public class Item {
    public byte    data;
    public Item    previous;
    public Item    next;

    public Item(int d) {
        data = (byte)d;
        previous = null;
        next = null;
    }
}