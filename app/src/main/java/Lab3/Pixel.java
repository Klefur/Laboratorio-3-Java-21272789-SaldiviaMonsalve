package Lab3;

public abstract class Pixel {
    private int x;
    private int y;
    private int depth;
    private String tipo;
    
    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Pixel(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public abstract String toString();
    
}
