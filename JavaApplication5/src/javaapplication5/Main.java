package javaapplication5;
import java.util.ArrayList;



public class Main {

    public static void main(String[] args) {
        Echiquier A = new Echiquier(8);      
        ArrayList<Cellule> reines = new  ArrayList<>();
        A.Algorithme(reines,0);
        //A.Algo_Glouton();
        System.out.println(A);
//        reines.forEach((reine) -> {
//            System.out.println((reine.getX()+1)+","+(reine.getY()+1));
//        });
    }
    
}

