package Lab3;

public class Pixhex extends Pixel{
    private String hex;

    public Pixhex(int x, int y,String hex, int depth) {
        super(x, y, depth);
        this.hex = hex;
        setTipo("hex");
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    @Override
    public String toString() {
        return hex;
    }
    
}
