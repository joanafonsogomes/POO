package veiculos;
import java.util.Objects;

public class Gasolina extends Carro {
    private double deposito;
   
    /**
    *CONSTRUTOR VAZIO
    */
    public Gasolina(){
        this.deposito = 0.0;
    }
    
    /**
    *CONSTRUTOR PARAMETERIZADO
    */
    public Gasolina(double dep){
        this.deposito = dep;
    }
    
    /**
    *CONSTRUTOR DE COPIA
    */
    public Gasolina(Gasolina outroCar){
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
        return (this.deposito == (that.getDeposito()));
    }
    /**
     *TO STRING
     */
    public String toString(){
        StringBuffer sb = new StringBuffer("Carro a gasolina: ");
        sb.append("Quantidade de combustivel no deposito: ").append(this.deposito).append(", ");
        return sb.toString();
    }
}
