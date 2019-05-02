package poo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Proprietario extends Pessoa{
    //private ArrayList<Carro> carros;
    private int avaliacao;
    
    
    /**
    *CONSTRUTOR VAZIO
    */
    public Proprietario(){
        super();
        this.avaliacao = 0;
    }
    
    /**
    *CONSTRUTOR PARAMETERIZADO
    */
    public Proprietario(String email, String nome, String password, String morada, LocalDate data,ArrayList<Aluguer> historico,int a){
        super(email,nome,password,morada,data,historico);
        this.avaliacao = a;
    }
    
    /**
    *CONSTRUTOR DE COPIA
    */
    public Proprietario(Proprietario outroProprietario){
        super(outroProprietario);
        this.avaliacao = outroProprietario.getAvaliacao();
        
    }
    
//GETTERS E SETTERS

    public int getAvaliacao() {
        return avaliacao;
    }

   
    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
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
                && this.avaliacao == that.getAvaliacao();
                
    }
    
    /**
     *TO STRING
     */
    
    public String toString(){
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("Avaliação: ").append(this.avaliacao).append(" ");
        return sb.toString();
    }
}

