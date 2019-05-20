package poo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.lang.*; 
import java.util.HashSet;

public class Cliente extends Pessoa {
    private double x;
    private double y;
    private double walking; //distancia que esta disposto a percorrer a pe
    private double destinox;
    private double destinoy;
    
    /**
    *CONSTRUTOR VAZIO
    */
    public Cliente(){
        super();
        this.x = 0.0;
        this.y = 0.0;
        this.walking = 0.0;
    }
   
            
    /**
    *CONSTRUTOR PARAMETERIZADO
    */
    public Cliente(String email, String nome, String password, String nif, String morada, LocalDate data, HashSet<Classificar> classificacoes,int a,ArrayList<Aluguer_final> historico,double cx, double cy, double cwalking){
        super(email,nome,password,nif,morada,data,classificacoes,a,historico);
        this.x = cx;
        this.y = cy;
        this.walking = cwalking;

    }
    
    /**
    *CONSTRUTOR DE COPIA
    */
    public Cliente(Cliente outroCliente){
        super(outroCliente);
        this.x = outroCliente.getX();
        this.y = outroCliente.getY();
        this.walking = outroCliente.getWalking();

    }
    
//GETTERS E SETTERS      
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public double getWalking() {
        return this.walking;
    }

    public void setWalking(double walking) {
        this.walking = walking;
    }

    public double getDestinox() {
        return destinox;
    }

    public void setDestinox(double destinox) {
        this.destinox = destinox;
    }

    public double getDestinoy() {
        return destinoy;
    }

    public void setDestinoy(double destinoy) {
        this.destinoy = destinoy;
    }
    
    
    
    
    
    /**
     *CLONE
     */
    public Cliente clone(){
        return new Cliente(this);
    }
    
    
    /**
     *EQUALS
     */
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        
        Cliente that = (Cliente) o;
        return  (super.equals(o)
                && this.x == that.getX()
                && this.y == that.getY()
                && this.walking==that.getWalking());

                
    }
    
    /**
     *TO STRING
     */
    public String toString(){
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("Abcissa: ").append(this.x).append("\n ");
        sb.append("Ordenada: ").append(this.y).append("\n ");
        sb.append("Tempo disposto a percorrer a pé: ").append(this.walking).append("\n ");
        return sb.toString();
    }
    
    
 
    
    /**
     *Solicitar o aluguer de um carro com um autonomia desejada; retorna o carro
     */
    public Carro carRange(ArrayList<Carro> carros){
        Carro chosen =null;
        double price = 10000.0;
        for(int i=0 ; i < carros.size() ; i++){
            Carro j = carros.get(i);
            double distance = Math.sqrt(Math.pow((j.getCoordenadasx() - x),2) + Math.pow((j.getCoordenadasy() - y),2));
                if( distance < walking){
                   if( j.getPreco() < price){
                    price = j.getPreco();
                    chosen = j;  
                   }
                }
        }  
    return chosen;
    }
    
   
    
}