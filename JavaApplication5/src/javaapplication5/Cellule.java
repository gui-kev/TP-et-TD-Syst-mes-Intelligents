package javaapplication5;
public class Cellule {
    private int x;
    private int y;
    
    private int typeOccupation;
    final static int LIBRE = 0;
    final static int REINE = 1;
    final static int MENACEE = 2;
    
    public Cellule(int x, int y){
        this.x = x;
        this.y = y;
        this.typeOccupation = LIBRE;
    }
    
    public static Cellule copy(Cellule c){
        Cellule cellule = new Cellule(c.getX(), c.getY());
        cellule.setTypeOccupation(c.getTypeOccupation());
        return cellule;
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

    public int getTypeOccupation() {
        return typeOccupation;
    }

    public void setTypeOccupation(int typeOccupation) {
        this.typeOccupation = typeOccupation;
    }
    
}
