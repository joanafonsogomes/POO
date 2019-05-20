package poo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class Proprietario extends Pessoa {
    private ArrayList<Carro> carros;
    
    
    
    /**
    *CONSTRUTOR VAZIO
    */
    public Proprietario(){
        super();
        this.carros= new ArrayList<>();

    }
    
    /**
    *CONSTRUTOR PARAMETERIZADO
    */
    public Proprietario(String email, String nome, String password,String nif, String morada, LocalDate data, HashSet<Classificar> classificacoes,int a,ArrayList<Aluguer_final> historico,ArrayList<Carro> carros){
        super(email,nome,password,nif,morada,data,classificacoes,a,historico);
        this.carros = new ArrayList<>();
        for(Carro car: carros){
            this.carros.add(car.clone());
        }
        
    }
    
    /**
    *CONSTRUTOR DE COPIA
    */
    public Proprietario(Proprietario outroProprietario){
        super(outroProprietario);
        this.carros =outroProprietario.getCarros();
        
    }
    
//GETTERS E SETTERS
    
      public ArrayList<Carro> getCarros(){
        ArrayList<Carro> newcarro =new ArrayList<>();
        for(Carro car: this.carros){
            newcarro.add(car.clone());
        }
        return newcarro;
    }
    
    

    /**
     *CLONE
     */
    public Proprietario clone(){
        return new Proprietario(this);
    }
    
    
    /**
     *EQUALS
     */
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        
        Proprietario that = (Proprietario) o;
        return super.equals(o)
                && this.carros.equals(that.getCarros());
            
                
    } 
    
    /**
     *TO STRING
     */
    
    public String toString(){
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("Lista de carros do proprietário: ").append(this.carros).append("\n ");
        return sb.toString();
    }
    
    
    public void adicionarcarros (Carro car){
        carros.add(car);
    } 
    
    public void removecarros (Carro car){
        carros.add(car);
    } 
    
    
    
    }
    
