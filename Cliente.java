package poo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.lang.*; 

public class Cliente extends Pessoa{
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
    public Cliente(String email, String nome, String password, String nif, String morada, LocalDate data,ArrayList<Aluguer> historico,double cx, double cy, double cwalking){
        super(email,nome,password,nif,morada,data,historico);
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
    
    /**
     *Solicitar o aluguer do carro mais proximo das suas coordenadas ; retorna o carro mais proximo
     */
    public Carro closestCar(ArrayList<Carro> carros){
        Carro chosen=null;
        double dist = 10000.0;
        for(int i=0 ; i < carros.size() ; i++){
            Carro j = carros.get(i);
            double distance = Math.sqrt(Math.pow((j.getCoordenadasx() - x),2) + Math.pow((j.getCoordenadasy() - y),2));
                if( distance < dist){
                    dist = distance;
                    chosen = j;  
                }
        }  
    return chosen;
    }
    
    /**
     *Solicitar o aluguer do carro mais barato ; retorna o carro mais barato
     */
    public Carro cheapestCar(ArrayList<Carro> carros){
        Carro chosen =null;
        double price = 10000.0;
        for(int i=0 ; i < carros.size() ; i++){
            Carro j = carros.get(i);
                if( j.getPreco() < price){
                    price = j.getPreco();
                    chosen = j;  
                }
        }  
    return chosen;
    }
    
    //da para otimizar usando a de cima, somehow
    /**
     *Solicitar o aluguer do carro mais barato dentro de uma distancia que esta disposto a percorrer a pe; retorna o carro
     */
    public Carro walkTillThere(ArrayList<Carro> carros){
        Carro chosen=null;
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
    
    /**
     *Solicitar o aluguer de um carro especifico; retorna o carro em questao
     */
    //public Carro specificCar(ArrayList<Carro> carros){
    
        //DIZER SE QUERO GASOLINA,......
        
    //}
    
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
    
    
    /**
     *Calcula a distancia a que esta do destino
     */
    public double distanciaDestino(){
        double distanciaDest = Math.sqrt(Math.pow((destinox - x),2) + Math.pow((destinoy - y),2));
        return distanciaDest;
    }
    
    /**
     *Ver se um certo carro tem autonomia para chegar ao destino !!NAO SEI SE PONHO NESTA CLASSE YET!!
     */
    public boolean temAutonomia(Carro carro){
        boolean i = false;
        double quantoConsome = carro.getConsumocombus();
        if(carro instanceof Gasolina){
            Gasolina carro1 = (Gasolina) carro;
                //fazer cenas de carrinho   
                if( carro1.getDeposito() > (quantoConsome * distanciaDestino())){
                    i = true;
                }
        }
        
        if(carro instanceof Eletrico){
            Eletrico carro2 = (Eletrico) carro;  
                if( carro2.getBateria() > (quantoConsome * distanciaDestino())){
                    i = true;
                }
        }
        
        if(carro instanceof Hibrido){
            Hibrido carro3 = (Hibrido) carro;  
                if( (carro3.getDeposito() > (quantoConsome * distanciaDestino()) ) || ( carro3.getBateria() > (quantoConsome * distanciaDestino())) ){
                    i = true;
                }
        }
        
        return i;
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
        return  super.equals(o)
                && (this.x == that.getX()
                && this.y == that.getY());
    }
    
    /**
     *TO STRING
     */
    public String toString(){
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("Abcissa: ").append(this.x).append("\n ");
        sb.append("Ordenada: ").append(this.y).append("\n ");
        return sb.toString();
    }
}