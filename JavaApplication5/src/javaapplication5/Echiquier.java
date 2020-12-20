package javaapplication5;
import java.util.ArrayList;

public class Echiquier {
    private Cellule[][] echiquier;
    private int taille;
    ArrayList<Cellule> Libre_Cellule;
    
    public Echiquier(int taille){
        this.taille = taille;
        echiquier = new Cellule[taille][taille];// Creation de la matrice ayant les case commme type cellule
        Libre_Cellule = new ArrayList<>();// Creation d'une liste où on va déposer les cellule qui sont libres
        initialiserEchiquier();// Creation des objets dans l'echiquuier en donnant à chacun son x et y
        
    }

    public void initialiserEchiquier() {
        for(int x = 0; x<taille;x++){
            for(int y = 0; y<taille;y++){
                echiquier[x][y] = new Cellule(x, y);
                Libre_Cellule.add(echiquier[x][y]);// Ajout de tout les elements en premier lieu dans la liste libre_cellule
            }
        }
    }
    
    public void modifierCellule(int x, int y, int valeur){
        echiquier[x][y].setTypeOccupation(valeur);
    }
    
      public void placerReine(int x, int y){
        if(echiquier[x][y].getTypeOccupation() == Cellule.LIBRE){
            echiquier[x][y].setTypeOccupation(Cellule.REINE);
            Libre_Cellule.remove(echiquier[x][y]);
                 
            for(int i=0;i<taille;i++){
                if(echiquier[i][y].getTypeOccupation() == Cellule.LIBRE){ //On menace les cellule sur la meme ligne et on les enleve de la liste cellulelibre
                    echiquier[i][y].setTypeOccupation(Cellule.MENACEE);
                    Libre_Cellule.remove(echiquier[i][y]);
                }
                
                if(y-x+i>=0 && y-x+i<taille && echiquier[i][y-x+i].getTypeOccupation() == Cellule.LIBRE){
                    echiquier[i][y-x+i].setTypeOccupation(Cellule.MENACEE);
                    Libre_Cellule.remove(echiquier[i][y-x+i]);
                }
                if(y+x-i>=0 && y+x-i<taille && echiquier[i][y+x-i].getTypeOccupation() == Cellule.LIBRE){
                    echiquier[i][y+x-i].setTypeOccupation(Cellule.MENACEE);
                    Libre_Cellule.remove(echiquier[i][y+x-i]);
                }
                
                if(echiquier[x][i].getTypeOccupation() == Cellule.LIBRE){ //On menace les cellule sur la meme colonne et on les enleve de la liste cellulelibre
                    echiquier[x][i].setTypeOccupation(Cellule.MENACEE);  
                    Libre_Cellule.remove(echiquier[x][i]);
                }   
            }
        }
    }
    
      
     @Override
    public String toString(){
        String A="";
        System.out.println();
        for(int x = 0; x<taille;x++){
            for(int y = 0; y<taille;y++){
                if(y!=0){
                     System.out.print(" ");
                }       
                if(Cellule.LIBRE==echiquier[x][y].getTypeOccupation())
                {
                    System.out.print(" ");
                }
                else if(Cellule.MENACEE==echiquier[x][y].getTypeOccupation())
                {
                    System.out.print("0");
                }
                else
                {
                    System.out.print("R");
                }
            }
            System.out.println();
        }
        return A;
    } 
      
      public Cellule[][] AutreEchiquier(Cellule[][] echiquier){
        Cellule[][] copy = new Cellule[taille][taille];
        for(int x = 0;x<taille;x++){
            for(int y = 0;y<taille;y++){
                copy[x][y] = Cellule.copy(echiquier[x][y]);
            }
        }
        return copy;
    }  
    
    public int TrouverValeur(int x, int y){
        int v = 0; 
        for(int i=0;i<taille;i++){
            if(echiquier[i][y].getTypeOccupation() == Cellule.LIBRE){
                v++;
            }
            if(y-x+i>=0 && y-x+i<taille && echiquier[i][y-x+i].getTypeOccupation() == Cellule.LIBRE){
                v++;
            }
            if(y+x-i>=0 && y+x-i< taille && echiquier[i][y+x-i].getTypeOccupation() == Cellule.LIBRE){
                v++;
            }
            if(echiquier[x][i].getTypeOccupation() == Cellule.LIBRE){
                v++;   
            }   
        }
        return v;
    }
    
    public Cellule TrouverCelluleMoinsMenacente(){
        Cellule Reine=null;
        int c;
        int all = taille*taille;             
        for(Cellule cellule : Libre_Cellule){
            c = TrouverValeur(cellule.getX(), cellule.getY());
            if(c<all){
                all = c;
                Reine = cellule;
            }
        }      
        return Reine;
    } 
    
    public ArrayList<Cellule> Algo_Glouton(){
        ArrayList<Cellule> REINES = new ArrayList<>();
        while(Libre_Cellule.size()>0){
            Cellule reine = TrouverCelluleMoinsMenacente();
            placerReine(reine.getX(), reine.getY());
            REINES.add(reine);
        }
        return REINES;
    }
  
    public boolean Algorithme(ArrayList<Cellule> R, int x){
        if(x>=taille){
            return true;
        } 
        Cellule[][] echiquier1 = AutreEchiquier(echiquier);
        for(int y=0;y<taille;y++){
            if(echiquier[x][y].getTypeOccupation() == Cellule.LIBRE){
                placerReine(x, y);
                R.add(echiquier[x][y]);          
                if(Algorithme(R,x+1)){
                    return true;
                }
                R.remove(echiquier[x][y]);
                this.echiquier = AutreEchiquier(echiquier1);
            }       
        }
        return false;
    }
    
    
}
