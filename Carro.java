package poo;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList; 


public abstract class Carro extends Veiculo {
   private String marca;
   private String matricula;
   private String nif;
   private int autonomia;
   private double velocidade;
   private double preco;
   private double consumocombus;
   private int classificacao;
   private double coordenadasx;
   private double coordenadasy;
   private boolean pdalugar;

   //construtor vazio
public Carro() {
        super();
        this.marca =new String();
        this.matricula=new String();
        this.nif=new String();
        this.autonomia=0;
        this.velocidade= 0.0;
        this.preco = 0.0;
        this.consumocombus = 0.0;
        this.classificacao = 0;
        this.coordenadasx = 0.0;
        this.coordenadasy = 0.0;
        this.pdalugar = false;
}
   
//construtor parametrizado
public Carro(ArrayList<Aluguer_final> historico ,String marca,String matricula, String nif,int autonomia, double vel, double preco, double consu, int clas , double coordx ,double coordy ,boolean pdalg){
        super(historico);
        this.marca=marca;
        this.matricula=matricula;
        this.nif=nif;
        this.autonomia=autonomia;
        this.velocidade= vel;
        this.preco = preco;
        this.consumocombus = consu;
        this.classificacao = clas;
        this.coordenadasx = coordx;
        this.coordenadasy = coordy;
        this.pdalugar = pdalg;
}

  //construtor de cópia
public Carro(Carro outroCarro) {
        super(outroCarro);
        this.marca = outroCarro.getMarca();
        this.matricula = outroCarro.getMatricula();
        this.nif = outroCarro.getNif();
        this.autonomia = outroCarro.getAutonomia();
        this.velocidade = outroCarro.getVelocidade();
        this.preco = outroCarro.getPreco();
        this.consumocombus = outroCarro.getConsumocombus();
        this.classificacao = outroCarro.getClassificacao();
        this.coordenadasx = outroCarro.getCoordenadasx();
        this.coordenadasy = outroCarro.getCoordenadasy();
        this.pdalugar = outroCarro.isPdalugar();


}

//GETTERS E SETTERS

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    

    public double getVelocidade() {
        return velocidade;
    }

    public double getPreco() {
        return preco;
    }

    public double getConsumocombus() {
        return consumocombus;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public double getCoordenadasx() {
        return coordenadasx;
    }

    public double getCoordenadasy() {
        return coordenadasy;
    }

    public boolean isPdalugar() {
        return pdalugar;
    }

    
    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setConsumocombus(double consumocombus) {
        this.consumocombus = consumocombus;
    }
    
    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public void setCoordenadasx(double coordenadasx) {
        this.coordenadasx = coordenadasx;
    }

    public void setCoordenadasy(double coordenadasy) {
        this.coordenadasy = coordenadasy;
    }

    public void setPdalugar(boolean pdalugar) {
        this.pdalugar = pdalugar;
    }
    
    /**
     *CLONE
     */
    public abstract Carro clone ();
    
    /**
     *EQUALS
     */
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        
        Carro that = (Carro) o;
        return (super.equals(o)
                && this.marca.equals(that.getMarca())
                && this.matricula.equals(that.getMatricula())
                && this.nif.equals(that.getNif())
                && this.autonomia == that.getAutonomia()
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
        sb.append("Marca: ").append(this.marca).append(", ");
        sb.append("Matricula: ").append(this.matricula).append(", ");
        sb.append("Nif: ").append(this.nif).append(", ");
        sb.append("Autonomia: ").append(this.autonomia).append(", ");
        sb.append("Velocidade média por km: ").append(this.velocidade).append(", ");
        sb.append("Preço base por km: ").append(this.preco).append(", ");
        sb.append("Consumo de combustivel por km percorrido: ").append(this.consumocombus).append(", ");
        sb.append("Classificação do carro: ").append(this.classificacao).append(", ");
        sb.append("Ordenada: ").append(this.coordenadasx).append(", ");
        sb.append("Abcisa: ").append(this.coordenadasy).append(", ");
        sb.append("Pode alugar? : ").append(this.pdalugar).append("\n ");
        return sb.toString();
    }
    
    
     
}

