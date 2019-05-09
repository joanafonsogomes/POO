package poo;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Pessoa {
   private String email;
   private String nome;
   private String password;
   private String nif;
   private String morada;
   private LocalDate data;
   private ArrayList<Aluguer> historico;

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
            this.historico= new ArrayList<>();
    }
   
    /**
     *CONSTRUTOR PARAMETERIZADO
     */
    public Pessoa(String email, String nome, String password,String nif, String morada, LocalDate data, ArrayList<Aluguer> historico) {
            this.email = email;
            this.nome = nome;
            this.password = password;
            this.nif=nif;
            this.morada = morada;
            this.data = data;
            this.historico = new ArrayList<>();
        for(Aluguer hist: historico){
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
            
    
      public ArrayList<Aluguer> getHistorico(){
        ArrayList<Aluguer> newhistorico =new ArrayList<>();
        for(Aluguer hist: this.historico){
            newhistorico.add(hist.clone());
        }
        return newhistorico;
    }
    
    //nem sempre faz sentido usar set para uma lista: implementado 
    //mas se nao usarmos depois retirar
    
    public void setHistorico(ArrayList<Aluguer> historico){
        ArrayList <Aluguer> newhistorico = new ArrayList<>();
        for(Aluguer hist: historico){
            newhistorico.add(hist.clone());
        }
        this.historico=newhistorico;
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
        sb.append("Lista de Alugueres: ").append(this.historico).append("\n ");
        return sb.toString();
    }
}