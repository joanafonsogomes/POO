package poo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public abstract class Pessoa implements Serializable{
   private String email;
   private String nome;
   private String password;
   private String nif;
   private String morada;
   private LocalDate data;
   private HashSet<Classificar> classificacoes;
   private int avaliacao;
   private ArrayList<Aluguer_final> historico;

    /**
    *CONSTRUTOR VAZIO
    */
    public Pessoa() {
            this.nif= new String();
            this.email = new String();
            this.nome = new String();
            this.password = new String();
            this.morada = new String();
            this.data = LocalDate.now();
            this.classificacoes = new HashSet<>();
            this.avaliacao = 0;
            this.historico= new ArrayList<>();
    }
   
    /**
     *CONSTRUTOR PARAMETERIZADO
     */
    public Pessoa(String email, String nome, String password,String nif, String morada, LocalDate data,HashSet<Classificar> classificacoes, int avaliacao,ArrayList<Aluguer_final> historico) {
            this.email = email;
            this.nome = nome;
            this.password = password;
            this.nif=nif;
            this.morada = morada;
            this.data = data;
            this.classificacoes = new HashSet<>();
        for(Classificar hist: classificacoes){
            this.classificacoes.add(hist.clone());
        }
            this.avaliacao = avaliacao;
            this.historico = new ArrayList<>();
        for(Aluguer_final hist: historico){
            this.historico.add(hist.clone());
        }
    }

    /**
     *CONSTRUTOR DE COPIA
     */
    public Pessoa(Pessoa outraPessoa) {
            this.email = outraPessoa.getEmail();
            this.nome = outraPessoa.getNome();
            this.password = outraPessoa.getPassword();
            this.nif=outraPessoa.getNif();
            this.morada = outraPessoa.getMorada();
            this.data = outraPessoa.getData();
            this.classificacoes=outraPessoa.getClassif();
            this.avaliacao=outraPessoa.getAvaliacao();
            this.historico =outraPessoa.getHistorico();
    }

//GETTERS E SETTERS
    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }
    
    public String getNif(){
        return nif;
    }

    public String getMorada() {
        return morada;
    }

    public LocalDate getData() {
        return data;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao() {
       Iterator<Classificar> it= classificacoes.iterator();
        Classificar elem=null;
        int r=0; int s=0;
        while (it.hasNext()){
            elem=it.next();
            r=r+elem.getNota();
            s++;
           
        }
           if(s==0) this.avaliacao=0;
           else this.avaliacao=r/s; 
    }

    
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setNif(String nif){
        this.nif=nif;
    }
    
    public void setMorada(String morada){
        this.morada=morada;
    }
            
            
    public void setData(LocalDate data){
        this.data= data;
    }
            
    
      public ArrayList<Aluguer_final> getHistorico(){
        ArrayList<Aluguer_final> newhistorico =new ArrayList<>();
        for(Aluguer_final hist: this.historico){
            newhistorico.add(hist.clone());
        }
        return newhistorico;
    }
     
    
      
      public HashSet<Classificar> getClassif(){
        HashSet<Classificar> newhistorico =new HashSet<>();
        for(Classificar hist: this.classificacoes){
            newhistorico.add(hist.clone());
        }
        return newhistorico;
    }
      
     public void adicionarAluguer_final(Aluguer_final a){
          historico.add(new Aluguer_final(a));
      }
     
      public void adicionarClassif(Classificar a){
          classificacoes.add(new Classificar(a));
      }
     
    /**
     *EQUALS
     */
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        
        Pessoa that = (Pessoa) o;
        return (this.email.equals(that.getEmail())
                && this.nome.equals(that.getNome())
                && this.password.equals(that.getPassword())
                && this.nif.equals(that.getNif())
                && this.morada.equals(that.getMorada())
                && this.data.equals(that.getData())
                && this.avaliacao==(that.getAvaliacao())
                && this.classificacoes.equals(that.getClassif())
                && this.historico.equals(that.getHistorico()));
    } 
    
    /**
     *TO STRING
     */
    public String toString(){
        StringBuffer sb = new StringBuffer(" Perfil:\n ");
        sb.append("Email: ").append(this.email).append("\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        sb.append("Password: ").append(this.password).append("\n ");
        sb.append("Nif: ").append(this.nif).append("\n ");
        sb.append("Morada: ").append(this.morada).append("\n ");
        sb.append("Data: ").append(this.data).append("\n ");
        sb.append("Avaliacao: ").append(this.avaliacao).append("\n ");
        sb.append("Lista de Alugueres: ").append(this.historico).append("\n ");
        return sb.toString();
    }
    
    
    
    
      
}