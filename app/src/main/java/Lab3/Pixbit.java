package Lab3;

public class Pixbit extends Pixel{
    private int bit;
    
    public Pixbit(int x, int y) {
        super(x,y);
    }
    
    public Pixbit(int x, int y, int bit, int depth) {
        super(x, y, depth);
        if (bit == 0) {
            this.bit = bit;
        }
        else {
            this.bit = 1;
        }
        setTipo("bit");
    }
    
    public int getBit() {
        return bit;
    }
    
    public void setBit(int bit) {
        this.bit = bit;
    }
    
    @Override
    public String toString() {
        return String.valueOf(bit);
    }
}
