package poo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;


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
    public Gasolina(ArrayList<Aluguer_final> historico ,String marca,String matricula, String nif,int autonomia, double vel, double preco,int cap, double consu,HashSet<Classificar> a, int clas , double coordx ,double coordy ,boolean pdalg, double dep){
        super(historico ,marca,matricula,nif,autonomia,vel ,preco ,cap,consu ,a,clas ,coordx ,coordy ,pdalg);
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
