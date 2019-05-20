package poo;
import java.io.Serializable;
import java.util.ArrayList;


 
public abstract class Veiculo implements Serializable{
   private ArrayList<Aluguer_final> historicoo;
   
   //construtor vazio
public Veiculo() {
        this.historicoo = new ArrayList<>();
   }
   
//construtor parametrizado
public Veiculo(ArrayList<Aluguer_final> historico){
        this.historicoo = new ArrayList<>();
        for(Aluguer_final hist: historico){
            this.historicoo.add(hist.clone());
        }
   }

  //construtor de copia
public Veiculo(Veiculo outroVeiculo) {
        this.historicoo = outroVeiculo.getHistorico();
}




//GETTERS E SETTERS
    public ArrayList<Aluguer_final> getHistorico(){
        ArrayList<Aluguer_final> newhistorico =new ArrayList<>();
        for(Aluguer_final hist: this.historicoo){
            newhistorico.add(hist.clone());
        }
        return newhistorico;
    }
    
   
      public void adicionarAluguer_finall(Aluguer_final a){
          historicoo.add(new Aluguer_final(a));
      }
    
  
     
    /**
     *EQUALS 
     */
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        
        Veiculo that = (Veiculo) o;
        return (this.historicoo.equals(that.getHistorico()));
    }
    
    /**
     *TO STRING
     */
    public String toString(){
        StringBuffer sb = new StringBuffer("\n ");
        sb.append("Historico de alugueres realizados: ").append(this.historicoo).append(", ");
        return sb.toString();
    }
    
 
}

