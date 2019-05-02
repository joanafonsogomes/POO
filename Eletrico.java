
import java.util.ArrayList;
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
    public Eletrico(ArrayList<Aluguer> historico , float vel, float preco, float consu, int clas , float coordx ,float coordy ,boolean pdalg, double bat){
        super(historico , vel, preco,consu,clas ,coordx ,coordy, pdalg);
        this.bateria = bat;
    }
    
    /**
    *CONSTRUTOR DE COPIA
    */
    public Eletrico(Eletrico outroCar){
        super(outroCar);
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
        if (obj == null || this.getClass() != obj.getClass()) return false;
        
        Eletrico that = (Eletrico) obj;
        return ((super.equals(obj))
                && (this.bateria == (that.getBateria())));
    }
    /**
     *TO STRING
     */
    public String toString(){
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("Quantidade de carga na bateria: ").append(this.bateria).append(", ");
        return sb.toString();
    }
}
