package Lab3;

import java.util.Arrays;

/**
 * Clase que representa un Pixrgb, compuesto de 3 int, 1 int[] y 1 String
 * @author joaquin
 * @version 11.0.17
 * @author joaquin
 */
public class Pixrgb extends Pixel {
    private int[] rgb;

    public Pixrgb(int x, int y,int r, int g, int b, int depth) {
        super(x, y, depth);
        this.rgb = new int[3];
        
        if(0<= r && r <= 255){
            this.rgb[0] = r;
        }
        else {
            this.rgb[0] = 255;
        }
        
        if(0<= g && g <= 255){
            this.rgb[1] = g;
        }
        else {
            this.rgb[1] = 255;
        
        }if(0<= b && b <= 255){
            this.rgb[2] = b;
        }
        else {
            this.rgb[2] = 255;
        }
        setTipo("rgb");
    }

    /**
     * Getter de rgb
     * @return rgb (int[])
     */
    public int[] getRgb() {
        return rgb;
    }

    /**
     *
     * @param rgb (int[])
     */
    public void setRgb(int[] rgb) {
        this.rgb = rgb;
    }
    
    /**
     * Transforma Pixrgb a String
     * @return String
     */
    @Override
    public String toString() {
        return Arrays.toString(rgb);
    }
       
    
}
