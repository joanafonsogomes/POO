package poo;

import java.util.ArrayList;

public class POO {

    public static void main(String[] args) {
        
        System.out.println("BEM VINDO À UMCarroJá!");
        
       
        Eletrico ele= new Eletrico ();
        Cliente c1 = new Cliente ();
        Proprietario t1 =new Proprietario();
        double a =3.0;
        double b=3.0;
        double c =4.0;
        double d=5.0;
        int x=4;
        int y=6;
        int f=9;
        double r=2.3;
        Aluguer p1= new Aluguer(c1,t1,ele,a,b,c,d,x,y,f,r);
        System.out.println(p1.toString());
        //System.out.println(p1.disponivel(c));
    }
    
}
