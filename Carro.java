package poo;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;


public class Carro extends Veiculo {
   private float velocidade;
   private float preco;
   private float consumocombus;
   private int classificacao;
   private float coordenadasx;
   private float coordenadasy;
   private boolean pdalugar;

   //construtor vazio
public Carro() {
        super();
        this.velocidade= 0.0f;
        this.preco = 0.0f;
        this.consumocombus = 0.0f;
        this.classificacao = 0;
        this.coordenadasx = 0.0f;
        this.coordenadasy = 0.0f;
        this.pdalugar = false;
}
   
//construtor parametrizado
public Carro(ArrayList<Aluguer> historico , float vel, float preco, float consu, int clas , float coordx ,float coordy ,boolean pdalg){
        super(historico);
        this.velocidade= vel;
        this.preco = preco;
        this.consumocombus = consu;
        this.classificacao = clas;
        this.coordenadasx = coordx;
        this.coordenadasy = coordy;
        this.pdalugar = pdalg;
}

  //construtor de cÃ³pia
public Carro(Carro outroCarro) {
        super(outroCarro);
        this.velocidade = outroCarro.getVelocidade();
        this.preco = outroCarro.getPreco();
        this.consumocombus = outroCarro.getConsumocombus();
        this.classificacao = outroCarro.getClassificacao();
        this.coordenadasx = outroCarro.getCoordenadasx();
        this.coordenadasy = outroCarro.getCoordenadasy();
        this.pdalugar = outroCarro.isPdalugar();


}

//GETTERS E SETTERS
    public float getVelocidade() {
        return velocidade;
    }

    public float getPreco() {
        return preco;
    }

    public float getConsumocombus() {
        return consumocombus;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public float getCoordenadasx() {
        return coordenadasx;
    }

    public float getCoordenadasy() {
        return coordenadasy;
    }

    public boolean isPdalugar() {
        return pdalugar;
    }

    

    
    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setConsumocombus(float consumocombus) {
        this.consumocombus = consumocombus;
    }
    
    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public void setCoordenadasx(float coordenadasx) {
        this.coordenadasx = coordenadasx;
    }

    public void setCoordenadasy(float coordenadasy) {
        this.coordenadasy = coordenadasy;
    }

    public void setPdalugar(boolean pdalugar) {
        this.pdalugar = pdalugar;
    }
    
    /**
     *CLONE
     */
    public Carro clone(){
        return new Carro(this);
    }
    
    
    /**
     *EQUALS
     */
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        
        Carro that = (Carro) o;
        return (super.equals(o)
                && this.velocidade == (that.getVelocidade())
                && this.preco == (that.getPreco())
                && this.consumocombus == (that.getConsumocombus())
                && this.classificacao == (that.getClassificacao())
                && this.coordenadasx == (that.getCoordenadasx())
                && this.coordenadasy == (that.getCoordenadasy())
                && this.pdalugar == (that.isPdalugar()));
    }
    
    /**
     *TO STRING
     */
    public String toString(){
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("Velocidade média por km: ").append(this.velocidade).append(", ");
        sb.append("Preço base por km: ").append(this.preco).append(", ");
        sb.append("Consumo de combustivel por km percorrido: ").append(this.consumocombus).append(", ");
        sb.append("Classificação do carro: ").append(this.classificacao).append(", ");
        sb.append("Ordenada: ").append(this.coordenadasx).append(", ");
        sb.append("Abcisa: ").append(this.coordenadasy).append(", ");
        sb.append("Pode alugar? : ").append(this.coordenadasy).append(", ");
        return sb.toString();
    }
    
}

