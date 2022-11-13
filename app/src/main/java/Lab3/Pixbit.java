/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3;

/**
 *
 * @author joaquin
 */
public class Pixbit extends Pixel{
    private int bit;

    public Pixbit(int x, int y, int bit, int depth) {
        super(x, y, depth);
        if (bit == 0) {
            this.bit = bit;
        }
        else {
            this.bit = 1;
        }
        this.tipo = "bit";
    }
    
    public int getBit() {
        return bit;
    }
    
    public void setBit(int bit) {
        this.bit = bit;
    }    
}
