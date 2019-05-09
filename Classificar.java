
package poo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Classificar {
    String mat_nif;
    int nota;
    
     /**
    *CONSTRUTOR VAZIO
    */
    public Classificar(){
        this.mat_nif=new String();
        this.nota =0;
    }
    
    /**
    *CONSTRUTOR PARAMETERIZADO
    */
    public Classificar(String mat_nif, int nota){
        this.mat_nif = mat_nif;
        this.nota=nota;
    }
    
    /**
    *CONSTRUTOR DE COPIA
    */
    public Classificar(Classificar outroClassificar){
        this.mat_nif = outroClassificar.getMat_Nif();
        this.nota = outroClassificar.getNota();
    }
   
    //GETTERS E SETTERS

    public String getMat_Nif() {
        return mat_nif;
    }

    public void setMat_Nif(String mat_nif) {
        this.mat_nif = mat_nif;
    }


    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
     
 
   /**
   *CLONE
   */
   public Classificar clone(){
    return new Classificar(this);
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
        Classificar that = (Classificar) obj;
        return (this.mat_nif.equals(that.getMat_Nif())
                && this.nota==that.getNota());
               
    }
     
   
    /**
     *TO STRING
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("Classificacao:\n ");
        sb.append("Matricula ou Nif: ").append(this.mat_nif).append("\n ");
        sb.append("Nota: ").append(this.nota).append("\n ");
        return sb.toString();
    }
    
   
}
