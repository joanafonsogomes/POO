package poo;

import java.util.Objects;


public class Aluguer {
    private String cliente_nif;
    private double final_x;
    private double final_y;
    private String tipoCombustivel;
    private String preferencia;
    
    /**
    *CONSTRUTOR VAZIO
    */
    
    
    public Aluguer() {
        this.cliente_nif= new String();
        this.final_x = 0.0;
        this.final_y = 0.0;
        this.tipoCombustivel= new String();
        this.preferencia= new String();

    }
    
    /**
    *CONSTRUTOR PARAMETERIZADO
    */
    public Aluguer(String cliente_nif, double final_x, double final_y, String tipoCombustivel, String preferencia) {
        this.cliente_nif= cliente_nif;
        this.final_x = final_x;
        this.final_y = final_y;
        this.tipoCombustivel= tipoCombustivel;
        this.preferencia= preferencia;
    }

    /**
     *CONSTRUTOR DE COPIA
     */
    public Aluguer (Aluguer outroAluguer){
        this.cliente_nif=outroAluguer.getCliente_nif();
        this.final_x = outroAluguer.getFinal_x();
        this.final_y = outroAluguer.getFinal_y();
        this.tipoCombustivel = outroAluguer.getTipoCombustivel();
        this.preferencia = outroAluguer.getPreferencia();
    }
    
   

    public String getCliente_nif() {
        return cliente_nif;
    }

    public void setCliente_nif(String cliente_nif) {
        this.cliente_nif = cliente_nif;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getPreferencia() {
        return preferencia;
    }

    //GETTERS E SETTERS
    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
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
    
    /**
     *CLONE
     */
    public Aluguer clone(){
        return new Aluguer(this);
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
        Aluguer that = (Aluguer) obj;
        return (this.cliente_nif.equals(that.getCliente_nif())
                && this.final_x==that.getFinal_x()
                && this.final_y==that.getFinal_y()
                && this.tipoCombustivel.equals(that.getTipoCombustivel())
                && this.preferencia.equals(that.getPreferencia()));
    }
    
   
    /**
     *TO STRING
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("Aluguer: ");
        sb.append("Nif do cliente: ").append(this.cliente_nif).append(",");
        sb.append("Abcissa da posição final: ").append(this.final_x).append(", ");
        sb.append("Ordenada da posição final: ").append(this.final_y).append(", ");
        sb.append("Tipo de combustivel ").append(this.tipoCombustivel).append(", ");
        sb.append("Preferencia: ").append(this.preferencia).append("\n ");
        return sb.toString();
    }
    
    
    
}
