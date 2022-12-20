package Lab3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase que representa el histograma, se compone de 3 int, 1 int[] y 1 String
 * @author joaquin
 * @version 11.0.17
 */
public class Histograma_21272789_SaldiviaMonsalve {
    private int masRepetidoBit;
    private int[] masRepetidoRGB;
    private String masRepetidoHex;
    private int cont;

    public Histograma_21272789_SaldiviaMonsalve() {
        cont = 0;
    }

    /**
     * Getter de el bit mas repetido en un Bitmap
     * @return masRepetidoBit (int)
     */
    public int getMasRepetidoBit() {
        return masRepetidoBit;
    }
    
    /**
     * Getter de el bit mas repetido en un Pixmap
     * @return masRepetidoRGB (int[])
     */
    public int[] getMasRepetidoRGB() {
        return masRepetidoRGB;
    }
    
    /**
     * Getter de el bit mas repetido en un Bitmap
     * @return masRepetidoHex (String)
     */
    public String getMasRepetidoHex() {
        return masRepetidoHex;
    }
    
    /**
     * Getter de cont
     * @return cont (int)
     */
    public int getCont() {
        return cont;
    }
    
    /**
     * obtiene el histograma de un Bitmap
     * @param pixs (ArrayList Pixel)
     */
    public void histogramaBit(ArrayList<Pixel_21272789_SaldiviaMonsalve> pixs) {
        Pixbit_21272789_SaldiviaMonsalve p;
        Pixbit_21272789_SaldiviaMonsalve pAux;
        int contAux;
        for (int i = 0; i < pixs.size(); i++) {
            p = (Pixbit_21272789_SaldiviaMonsalve) pixs.get(i);
            contAux = 0;
            for (int j = i; j < pixs.size(); j++) { 
                pAux = (Pixbit_21272789_SaldiviaMonsalve) pixs.get(j);
                if (p.getBit() == pAux.getBit()) {
                    contAux++;
                }
            }
            if (contAux > cont) {
                masRepetidoBit = p.getBit();
                cont = contAux;
            }
        }
    }
    
    /**
     * obtiene el histograma de un Pixmap
     * @param pixs (ArrayList Pixel)
     */
    public void histogramaRGB(ArrayList<Pixel_21272789_SaldiviaMonsalve> pixs) {
        Pixrgb_21272789_SaldiviaMonsalve p;
        Pixrgb_21272789_SaldiviaMonsalve pAux;
        int contAux;
        for (int i = 0; i < pixs.size(); i++) {
            p = (Pixrgb_21272789_SaldiviaMonsalve) pixs.get(i);
            contAux = 0;
            for (int j = i; j < pixs.size(); j++) { 
                pAux = (Pixrgb_21272789_SaldiviaMonsalve) pixs.get(j);
                if (Arrays.toString(p.getRgb()).equals(Arrays.toString(pAux.getRgb()))) {
                    contAux++;
                }
            }
            if (contAux > cont) {
                masRepetidoRGB = p.getRgb();
                cont = contAux;
            }
        }
    }
    
    /**
     * obtiene el histograma de un Hexmap
     * @param pixs (ArrayList Pixel)
     */
    public void histogramaHex(ArrayList<Pixel_21272789_SaldiviaMonsalve> pixs) {
        Pixhex_21272789_SaldiviaMonsalve p;
        Pixhex_21272789_SaldiviaMonsalve pAux;
        int contAux;
        for (int i = 0; i < pixs.size(); i++) {
            p = (Pixhex_21272789_SaldiviaMonsalve) pixs.get(i);
            contAux = 0;
            for (int j = i; j < pixs.size(); j++) {
                pAux = (Pixhex_21272789_SaldiviaMonsalve) pixs.get(j);
                if (p.getHex().equals(pAux.getHex())) {
                    contAux++;
                }
            }
            if (contAux > cont) {
                masRepetidoHex = p.getHex();
                cont = contAux;
            }
        }
    }
    
}
