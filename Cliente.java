package poo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Pessoa{
    private double x;
    private double y;
    
    /**
    *CONSTRUTOR VAZIO
    */
    public Cliente(){
        super();
        this.x = 0.0;
        this.y = 0.0;
    }
    
    /**
    *CONSTRUTOR PARAMETERIZADO
    */
    public Cliente(String email, String nome, String password, String morada, LocalDate data,ArrayList<Aluguer> historico,double cx, double cy){
        super(email,nome,password,morada,data,historico);
        this.x = cx;
        this.y = cy;
    }
    
    /**
    *CONSTRUTOR DE COPIA
    */
    public Cliente(Cliente outroCliente){
        super(outroCliente);
        this.x = outroCliente.getX();
        this.y = outroCliente.getY();
    }
    
//GETTERS E SETTERS

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    /**
     *CLONE
     */
    public Cliente clone(){
        return new Cliente(this);
    }
    
    
    /**
     *EQUALS
     */
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        
        Cliente that = (Cliente) o;
        return  super.equals(o)
                && (this.x == that.getX()
                && this.y == that.getY());
    }
    
    /**
     *TO STRING
     */
    public String toString(){
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("Abcissa: ").append(this.x).append(", ");
        sb.append("Ordenada: ").append(this.y).append(" ");
        return sb.toString();
    }
}
