package poo;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;


public abstract class Veiculo {
   private ArrayList<Aluguer> historico;
   
   //construtor vazio
public Veiculo() {
        this.historico = new ArrayList<>();
   }
   
//construtor parametrizado
public Veiculo(ArrayList<Aluguer> historico){
        this.historico = new ArrayList<>();
        for(Aluguer hist: historico){
            this.historico.add(hist.clone());
        }
   }

  //construtor de cÃ³pia
public Veiculo(Veiculo outroVeiculo) {
        this.historico = outroVeiculo.getHistorico();
}

//GETTERS E SETTERS
    public ArrayList<Aluguer> getHistorico(){
        ArrayList<Aluguer> newhistorico =new ArrayList<>();
        for(Aluguer hist: this.historico){
            newhistorico.add(hist.clone());
        }
        return newhistorico;
    }
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
        
        Veiculo that = (Veiculo) o;
        return (this.historico.equals(that.getHistorico()));
    }
    
    /**
     *TO STRING
     */
    public String toString(){
        StringBuffer sb = new StringBuffer("Veiculo: ");
        sb.append("Historico de alugueres realizados: ").append(this.historico).append(", ");
        return sb.toString();
    }
    
}

