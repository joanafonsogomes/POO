
package poo;

import java.util.ArrayList;

public class Registos {
    private ArrayList<Cliente> clientes;
    private ArrayList<Proprietario> proprietarios;
    private ArrayList<Carro> carross;
    
    
/**
*CONSTRUTOR VAZIO
*/
public Registos(){
this.clientes= new ArrayList<>();
this.proprietarios= new ArrayList<>();
this.carross=new ArrayList<>();
}



 /**
 *CONSTRUTOR PARAMETERIZADO
 */
    public Registos(ArrayList<Cliente> clientes, ArrayList<Proprietario> proprietarios, ArrayList<Carro> carross) {
        this.clientes = new ArrayList<>();
        for(Cliente clie: clientes){
            this.clientes.add(clie.clone());
        }
        this.proprietarios = new ArrayList<>();
        for(Proprietario prop: proprietarios){
            this.proprietarios.add(prop.clone());
        }
        this.carross = new ArrayList<>();
        for(Carro car: carross){
            this.carross.add(car.clone());
        }
    }

 /**
    *CONSTRUTOR DE COPIA
    */
    public Registos(Registos outroRegistos){
        
        this.clientes =outroRegistos.getClientes();
        this.proprietarios = outroRegistos.getProprietarios();
        this.carross = outroRegistos.getCarross();
    }
    
    
//GETTERS E SETTERS
    
      public ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> newcliente =new ArrayList<>();
        for(Cliente clie: this.clientes){
            newcliente.add(clie.clone());
        }
        return newcliente;
    }
      
      public ArrayList<Proprietario> getProprietarios(){
        ArrayList<Proprietario> newprop =new ArrayList<>();
        for(Proprietario prop: this.proprietarios){
            newprop.add(prop.clone());
        }
        return newprop;
    }
      
      public ArrayList<Carro> getCarross(){
        ArrayList<Carro> newcar =new ArrayList<>();
        for(Carro car: this.carross){
            newcar.add(car.clone());
        }
        return newcar;
    }
      
    /**
     *CLONE
     */
    public Registos clone(){
        return new Registos(this);
    }
    
    
    /**
     *EQUALS
     */
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        
        Registos that = (Registos) o;
        return super.equals(o)
                && this.clientes.equals(that.getClientes())
                && this.proprietarios.equals(that.getProprietarios())
                && this.carross.equals(that.getCarross());
                
    }
    
    /**
     *TO STRING
     */
    
    public String toString(){
        StringBuffer sb = new StringBuffer("Registos: ");
        sb.append("Lista de clientes: ").append(this.clientes).append("\n ");
        sb.append("Lista de proprietários: ").append(this.proprietarios).append("\n ");
        sb.append("Lista de carros: ").append(this.carross).append("\n ");
        return sb.toString();
    }
    
    public void adicionarClientes (ArrayList<Cliente> clientes, Cliente c){
        this.clientes.add(new Cliente(c));
    }
    
    public void adicionarProprietarios (ArrayList<Proprietario> proprietarios, Proprietario p){
        this.proprietarios.add(new Proprietario(p));
    }
    
    public void adicionarcarros_gasolina (ArrayList<Carro> carross, Gasolina gas){
        this.carross.add(new Gasolina(gas));
    }
    
    public void adicionarcarros_hibridos (ArrayList<Carro> carross, Hibrido hib){
        this.carross.add(new Hibrido(hib));
    }
    
    public void adicionarcarros_eletricos (ArrayList<Carro> carross, Eletrico ele){
        this.carross.add(new Eletrico(ele));
    }

}
