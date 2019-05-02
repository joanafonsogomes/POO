package veiculos;
import java.util.Objects;


import java.util.Objects;

public class  Eletrico extends Carro {
    private double bateria;
   
    /**
    *CONSTRUTOR VAZIO
    */
    public Eletrico(){
        this.bateria = 0.0;
    }
    
    /**
    *CONSTRUTOR PARAMETERIZADO
    */
    public Eletrico(double bat){
        this.bateria = bat;
    }
    
    /**
    *CONSTRUTOR DE COPIA
    */
    public Eletrico(Eletrico outroCar){
        this.bateria = outroCar.getBateria();
    }
    
//GETTERS E SETTERS

    public double getBateria() {
        return bateria;
    }

    public void setBateria(double bateria) {
        this.bateria = bateria;
    }
    
    /**
     *CLONE
     */
    public Eletrico clone(){
        return new Eletrico(this);
    }
    
    
    /**
     *EQUALS
     */
    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) return false;
        
        Eletrico that = (Eletrico) obj;
        return (this.bateria == (that.getBateria()));
    }
    /**
     *TO STRING
     */
    public String toString(){
        StringBuffer sb = new StringBuffer("Carro eletrico: ");
        sb.append("Quantidade de carga na bateria: ").append(this.bateria).append(", ");
        return sb.toString();
    }
}
