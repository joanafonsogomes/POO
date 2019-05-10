package poo;
import java.util.ArrayList;

 
public abstract class Veiculo {
   private ArrayList<Aluguer_final> historico;
   
   //construtor vazio
public Veiculo() {
        this.historico = new ArrayList<>();
   }
   
//construtor parametrizado
public Veiculo(ArrayList<Aluguer_final> historico){
        this.historico = new ArrayList<>();
        for(Aluguer_final hist: historico){
            this.historico.add(hist.clone());
        }
   }

  //construtor de copia
public Veiculo(Veiculo outroVeiculo) {
        this.historico = outroVeiculo.getHistorico();
}

public void adicionarAluguer_finall (Aluguer_final a){
        this.historico.add(new Aluguer_final(a));
    }

//GETTERS E SETTERS
    public ArrayList<Aluguer_final> getHistorico(){
        ArrayList<Aluguer_final> newhistorico =new ArrayList<>();
        for(Aluguer_final hist: this.historico){
            newhistorico.add(hist.clone());
        }
        return newhistorico;
    }
    
    public void setHistorico(ArrayList<Aluguer_final> historico){
        ArrayList <Aluguer_final> newhistorico = new ArrayList<>();
        for(Aluguer_final hist: historico){
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
        
        Veiculo that = (Veiculo) o;
        return (this.historico.equals(that.getHistorico()));
    }
    
    /**
     *TO STRING
     */
    public String toString(){
        StringBuffer sb = new StringBuffer("\n ");
        sb.append("Historico de alugueres realizados: ").append(this.historico).append(", ");
        return sb.toString();
    }
    
    
    
}

