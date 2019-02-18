public class MiniNode {
    private int value;
    private boolean unique;

    public MiniNode(int value, boolean unique) {
        this.value = value;
        this.unique = unique;
    }

    public int getValue() {
        return value;
    }
    public boolean getUnique() {
        return unique;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public void setUnique(boolean unique) {
        this.unique = unique;
    }

}
