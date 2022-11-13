/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3;

/**
 *
 * @author joaquin
 */
public class Pixhex extends Pixel{
    private String hex;

    public Pixhex(int x, int y,String hex, int depth) {
        super(x, y, depth);
        this.hex = hex;
        this.tipo = "hex";
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }
    
}
