package Lab3;

public class Pixhex extends Pixel{
    private String hex;

    public Pixhex(int x, int y,String hex, int depth) {
        super(x, y, depth);
        this.hex = hex;
        setTipo("hex");
    }

    /**
     * Getter de hex
     * @return hex (String)
     */
    public String getHex() {
        return hex;
    }

    /**
     * Setter de hex
     * @param hex (String)
     */
    public void setHex(String hex) {
        this.hex = hex;
    }
    
    /**
     * Transforma Pixhex a String
     * @return String
     */
    @Override
    public String toString() {
        return hex;
    }
    
}
