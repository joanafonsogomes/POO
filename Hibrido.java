package veiculos;
import java.util.Objects;

public class  Hibrido extends Carro {
    private double bateria;
    private double deposito;
   
    /**
    *CONSTRUTOR VAZIO
    */
    public Hibrido(){
        this.bateria = 0.0;
        this.deposito = 0.0;
    }
    
    /**
    *CONSTRUTOR PARAMETERIZADO
    */
    public Hibrido(double bat ,double dep){
        this.bateria = bat;        
        this.deposito = dep;
    }
    
    /**
    *CONSTRUTOR DE COPIA
    */
    public Hibrido(Hibrido outroCar){
        this.bateria = outroCar.getBateria();
        this.deposito = outroCar.getDeposito();
    }
    
//GETTERS E SETTERS

    public double getBateria() {
        return bateria;
    }
    
    public double getDeposito() {
        return deposito;
    }

    public void setBateria(double bateria) {
        this.bateria = bateria;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }

    
    /**
     *CLONE
     */
    public Hibrido clone(){
        return new Hibrido(this);
    }
    
    
    /**
     *EQUALS
     */
    
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        
        Hibrido that = (Hibrido) o;
        return (this.bateria == (that.getBateria())
                && this.deposito == (that.getDeposito()));
    }
    /**
     *TO STRING
     */
    public String toString(){
        StringBuffer sb = new StringBuffer("Carro hibrido : ");
        sb.append("Quantidade de ca        sb.append(\"Quantidade de carga na bateria: \").append(this.bateria).append(\", \");\n" +
"rga na bateria: ").append(this.bateria).append(", ");
        sb.append("Quantidade de combustivel no deposito: ").append(this.deposito).append(", ");
        return sb.toString();
    }
}
