package poo;

import java.util.Objects;


public class Aluguer_final {
    private Carro car;
    private Cliente c1;
    private Proprietario p1;
    private double inicio_x;
    private double inicio_y;
    private double final_x;
    private double final_y;
    private double tempo_viagem;
    
    /**
    *CONSTRUTOR VAZIO
    */
    
    /**
     * Predefinido que se inicia com um carro a gasolina se não existir
     * outras instruções
     */
    public Aluguer_final() {
        this.car= new Gasolina();
        this.c1 = new Cliente();
        this.p1 = new Proprietario();
        this.inicio_x = 0.0;
        this.inicio_y = 0.0;
        this.final_x = 0.0;
        this.final_y = 0.0;
        this.tempo_viagem = 0.0;
    }
    
    /**
    *CONSTRUTOR PARAMETERIZADO
    */
    public Aluguer_final(Cliente c1, Proprietario p1,Carro car, double inicio_x, double inicio_y, double final_x, double final_y, double tempo_viagem) {
        this.car=car;
        this.c1 = c1;
        this.p1 = p1;
        this.inicio_x = inicio_x;
        this.inicio_y = inicio_y;
        this.final_x = final_x;
        this.final_y = final_y;

        this.tempo_viagem = tempo_viagem;
    }

    /**
     *CONSTRUTOR DE COPIA
     */
    public Aluguer_final(Aluguer_final outroAluguer){
        this.car=outroAluguer.getCar();
        this.c1 = outroAluguer.getC1();
        this.p1 = outroAluguer.getP1();
        this.inicio_x = outroAluguer.getInicio_x();
        this.inicio_y = outroAluguer.getInicio_y();
        this.final_x = outroAluguer.getFinal_x();
        this.final_y = outroAluguer.getFinal_y();
        this.tempo_viagem = outroAluguer.getTempo_viagem();
    }
    
    
    
    //GETTERS E SETTERS
    
    public Carro getCar(){
        return this.car.clone();
    }
    
    public void setCar() {
        this.car=car.clone();
    }

    public Cliente getC1() {
        return this.c1.clone();
    }

    public void setC1(Cliente c1) {
        this.c1 = c1.clone();
    }

    public Proprietario getP1() {
        return this.p1.clone();
    }

    public void setP1(Proprietario p1) {
        this.p1 = p1.clone();
    }
    
    
    
    public double getInicio_x() {
        return inicio_x;
    }

    public void setInicio_x(double inicio_x) {
        this.inicio_x = inicio_x;
    }

    public double getInicio_y() {
        return inicio_y;
    }

    public void setInicio_y(double inicio_y) {
        this.inicio_y = inicio_y;
    }

    public double getFinal_x() {
        return final_x;
    }

    public void setFinal_x(double final_x) {
        this.final_x = final_x;
    }

    public double getFinal_y() {
        return final_y;
    }

    public void setFinal_y(double final_y) {
        this.final_y = final_y;
    }


    public double getTempo_viagem() {
        return tempo_viagem;
    }

    public void setTempo_viagem(double tempo_viagem) {
        this.tempo_viagem = tempo_viagem;
    }
    
    
    /**
     *CLONE
     */
    public Aluguer_final clone(){
        return new Aluguer_final(this);
    }

    /**
     *EQUALS
     */
    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Aluguer_final that = (Aluguer_final) obj;
        return (this.c1.equals(that.getC1())
                && this.p1.equals(that.getP1())
                && this.inicio_x==that.getInicio_x()
                && this.inicio_y==that.getInicio_y()
                && this.final_x==that.getFinal_x()
                && this.tempo_viagem==that.getTempo_viagem());
    }
    
   
    /**
     *TO STRING
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("\nAluguer: ");
        sb.append("Carro: ").append(this.car.getMarca()).append(", ");
        sb.append("Preço:").append(this.car.getPreco()).append(", ");
        sb.append("Cliente: ").append(this.c1.getNome()).append(", ");
        sb.append("Proprietário: ").append(this.p1.getNome()).append(", ");
        sb.append("Abcissa da posição inicial: ").append(this.inicio_x).append(", ");
        sb.append("Ordenada da posição inicial: ").append(this.inicio_y).append(", ");
        sb.append("Abcissa da posição final: ").append(this.final_x).append(", ");
        sb.append("Ordenada da posição final: ").append(this.final_y).append(", ");
        sb.append("Duração da viagem: ").append(this.tempo_viagem).append("");
        return sb.toString();
    }
    
    
    
}
