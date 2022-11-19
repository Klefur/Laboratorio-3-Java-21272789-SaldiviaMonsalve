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

    public int getMasRepetidoBit() {
        return masRepetidoBit;
    }

    public int[] getMasRepetidoRGB() {
        return masRepetidoRGB;
    }

    public String getMasRepetidoHex() {
        return masRepetidoHex;
    }

    public int getCont() {
        return cont;
    }
    
    public void histogramaBit(ArrayList<Pixel> pixs) {
        Pixbit p, pAux;
        int contAux = 0;
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
    
    public void histogramaRGB(ArrayList<Pixel> pixs) {
        Pixrgb p, pAux;
        int contAux = 0;
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
    
    public void histogramaHex(ArrayList<Pixel> pixs) {
        Pixhex p, pAux;
        int contAux = 0;
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
