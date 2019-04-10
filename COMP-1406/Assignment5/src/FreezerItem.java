public class FreezerItem extends PerishableItem {
    public FreezerItem(String n, float p, float w) {
        super(n, p, w);
    }

    public String toString () {
        return super.toString() + "[keep frozen]";
    }
}
