package Lab3;

/**
 * Clase que representa un Pixbit, compuesto de 4 int y 1 String
 * @author joaquin
 * @version 11.0.17
 */
public class Pixbit_21272789_SaldiviaMonsalve extends Pixel_21272789_SaldiviaMonsalve{
    private int bit;
    
    public Pixbit_21272789_SaldiviaMonsalve(int x, int y, int bit, int depth) {
        super(x, y, depth);
        if (bit == 0) {
            this.bit = bit;
        }
        else {
            this.bit = 1;
        }
        setTipo("bit");
    }
    
    /**
     * Getter de bit
     * @return bit (int)
     */
    public int getBit() {
        return bit;
    }
    
    /**
     * Setter de bit
     * @param bit (int)
     */
    public void setBit(int bit) {
        this.bit = bit;
    }
    
    /**
     * Transforma Pixbit a String
     * @return String
     */
    @Override
    public String toString() {
        return String.valueOf(bit);
    }
}
