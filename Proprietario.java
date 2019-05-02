

import java.util.ArrayList;

public class Proprietario extends Pessoa{
    //private ArrayList<Carro> carros;
    private int avaliacao;
    private ArrayList<Aluguer> historico;
    
    /**
    *CONSTRUTOR VAZIO
    */
    public Proprietario(){
        this.avaliacao = 0;
        this.historico= new ArrayList<>();
    }
    
    /**
    *CONSTRUTOR PARAMETERIZADO
    */
    public Proprietario(int a, ArrayList<Aluguer> historico){
        this.avaliacao = a;
        this.historico = new ArrayList<>();
        for(Aluguer hist: historico){
            this.historico.add(hist.clone());
        }
    }
    
    /**
    *CONSTRUTOR DE COPIA
    */
    public Proprietario(Proprietario outroProprietario){
        this.avaliacao = outroProprietario.getAvaliacao();
        this.historico =outroProprietario.getHistorico();
    }
    
//GETTERS E SETTERS

    public int getAvaliacao() {
        return avaliacao;
    }

   
    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
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
        return this.avaliacao == that.getAvaliacao()
                && this.historico.equals(that.getHistorico());
    }
    
    /**
     *TO STRING
     */
    
    public String toString(){
        StringBuffer sb = new StringBuffer("Proprietario: ");
        sb.append("Avaliação: ").append(this.avaliacao).append(", ");
        sb.append("Lista de Alugueres: ").append(this.historico).append(", ");
        return sb.toString();
    }
}

