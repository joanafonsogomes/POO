package poo;
import java.util.ArrayList;
import java.util.Objects;

public class Gasolina extends Carro {
    private double deposito;
   
    /**
    *CONSTRUTOR VAZIO
    */
    public Gasolina(){
        super();
        this.deposito = 0.0;
    }
    
    /**
    *CONSTRUTOR PARAMETERIZADO
    */
    public Gasolina(ArrayList<Aluguer> historico , float vel, float preco, float consu, int clas , float coordx ,float coordy ,boolean pdalg, double dep){
        super(historico ,vel ,preco ,consu ,clas ,coordx ,coordy ,pdalg);
        this.deposito = dep;
    }
    
    /**
    *CONSTRUTOR DE COPIA
    */
    public Gasolina(Gasolina outroCar){
        super(outroCar);
        this.deposito = outroCar.getDeposito();
    }
    
//GETTERS E SETTERS

    public double getDeposito() {
        return deposito;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }
    
    /**
     *CLONE
     */ 
    @Override
    public Gasolina clone(){
        return new Gasolina(this);
    }
    
    
    /**
     *EQUALS
     */
    
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) return false;
        
        Gasolina that = (Gasolina) o;
        return ((super.equals(o))
                && (this.deposito == (that.getDeposito())));
    }
    /**
     *TO STRING
     */
    public String toString(){
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("Quantidade de combustivel no deposito: ").append(this.deposito).append(", ");
        return sb.toString();
    }
}
