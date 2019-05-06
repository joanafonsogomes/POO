package poo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Proprietario extends Pessoa{
    private ArrayList<Carro> carros;
    private int avaliacao;
    
    
    /**
    *CONSTRUTOR VAZIO
    */
    public Proprietario(){
        super();
        this.carros= new ArrayList<>();
        this.avaliacao = 0;
    }
    
    /**
    *CONSTRUTOR PARAMETERIZADO
    */
    public Proprietario(String email, String nome, String password, String morada, LocalDate data,ArrayList<Aluguer> historico,ArrayList<Carro> carros,int a){
        super(email,nome,password,morada,data,historico);
        this.carros = new ArrayList<>();
        for(Carro car: carros){
            this.carros.add(car.clone());
        }
        this.avaliacao = a;
    }
    
    /**
    *CONSTRUTOR DE COPIA
    */
    public Proprietario(Proprietario outroProprietario){
        super(outroProprietario);
        this.carros =outroProprietario.getCarros();
        this.avaliacao = outroProprietario.getAvaliacao();
        
    }
    
//GETTERS E SETTERS
    
      public ArrayList<Carro> getCarros(){
        ArrayList<Carro> newcarro =new ArrayList<>();
        for(Carro car: this.carros){
            newcarro.add(car.clone());
        }
        return newcarro;
    }
    

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
                && this.carros.equals(that.getCarros())
                && this.avaliacao == that.getAvaliacao();
                
    }
    
    /**
     *TO STRING
     */
    
    public String toString(){
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("Lista de carros do proprietário: ").append(this.carros).append(" ");
        sb.append("Avaliação: ").append(this.avaliacao).append(" ");
        return sb.toString();
    }
    
    public void adicionarcarros_gasolina (ArrayList<Carro> carros, Gasolina gas){
        this.carros.add(new Gasolina(gas));
    }
    
    public void adicionarcarros_hibridos (ArrayList<Carro> carros, Hibrido hib){
        this.carros.add(new Hibrido(hib));
    }
    
    public void adicionarcarros_eletricos (ArrayList<Carro> carros, Eletrico ele){
        this.carros.add(new Eletrico(ele));
    }
    
    
    /**
     * Sinalizar que um carro está disponivel para aluguer
     */
    public boolean disponivel(Carro f){
    boolean r=false;
       if(f.isPdalugar()==true)
        r=true;
       else r=false;
    return r;
    }
    
    /**
     * Abastecer o veiculo
     */
    public void abastecerGasolina(Gasolina c, double quantidade){
        if(quantidade>60){
        System.out.println("ERRO: É impossível abastecer. Por favor abasteça com uma quantidade inferior a 60 litros");
        }
        else c.setDeposito(quantidade);
}
}
