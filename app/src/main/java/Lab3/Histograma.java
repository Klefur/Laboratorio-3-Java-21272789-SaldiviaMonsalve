package Lab3;

import java.util.ArrayList;
import java.util.Arrays;

public class Histograma {
    private int masRepetidoBit;
    private int[] masRepetidoRGB;
    private String masRepetidoHex;
    private int cont;

    public Histograma() {
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
    public void histogramaBit(ArrayList<Pixel> pixs) {
        Pixbit p, pAux;
        int contAux;
        for (int i = 0; i < pixs.size(); i++) {
            p = (Pixbit) pixs.get(i);
            contAux = 0;
            for (int j = i; j < pixs.size(); j++) { 
                pAux = (Pixbit) pixs.get(j);
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
    public void histogramaRGB(ArrayList<Pixel> pixs) {
        Pixrgb p, pAux;
        int contAux;
        for (int i = 0; i < pixs.size(); i++) {
            p = (Pixrgb) pixs.get(i);
            contAux = 0;
            for (int j = i; j < pixs.size(); j++) { 
                pAux = (Pixrgb) pixs.get(j);
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
    public void histogramaHex(ArrayList<Pixel> pixs) {
        Pixhex p, pAux;
        int contAux;
        for (int i = 0; i < pixs.size(); i++) {
            p = (Pixhex) pixs.get(i);
            contAux = 0;
            for (int j = i; j < pixs.size(); j++) {
                pAux = (Pixhex) pixs.get(j);
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
