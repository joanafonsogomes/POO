
import java.util.ArrayList;

public class POO {

    public static void main(String[] args) {
        Proprietario p1= new Proprietario();
        Gasolina c= new Gasolina();
        Gasolina c2= new Gasolina (c);
        p1.adicionarcarros_gasolina(p1.getCarros(),c);
        p1.adicionarcarros_gasolina(p1.getCarros(),c2);
        System.out.println(p1.toString());
    }
    
}
