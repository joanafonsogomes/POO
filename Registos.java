
package poo;

import java.util.HashSet;
import java.util.Iterator;

public class Registos {
    private HashSet<Cliente> clientes;
    private HashSet<Proprietario> proprietarios;
    private HashSet<Carro> carross;
    private HashSet<Aluguer> alugueres;
    private HashSet<Classificar> classificacoes;
    
/** 
*CONSTRUTOR VAZIO
*/
public Registos(){
this.clientes= new HashSet<>();
this.proprietarios= new HashSet<>();
this.carross=new HashSet<>();
this.alugueres= new HashSet<>();
this.classificacoes=new HashSet<>();
}



 /**
 *CONSTRUTOR PARAMETERIZADO
 */
    public Registos(HashSet<Cliente> clientes, HashSet<Proprietario> proprietarios, HashSet<Carro> carross, HashSet<Aluguer> alugueres, HashSet<Classificar> classificacoes) {
        this.clientes = new HashSet<>();
        for(Cliente clie: clientes){
            this.clientes.add(clie.clone());
        }
        this.proprietarios = new HashSet<>();
        for(Proprietario prop: proprietarios){
            this.proprietarios.add(prop.clone());
        }
        this.carross = new HashSet<>();
        for(Carro car: carross){
            this.carross.add(car.clone());
        }
        this.alugueres = new HashSet<>();
        for(Aluguer alg: alugueres){
            this.alugueres.add(alg.clone());
        }
        this.classificacoes = new HashSet<>();
        for(Classificar cla: classificacoes){
            this.classificacoes.add(cla.clone());
        }
        
    }

 /**
    *CONSTRUTOR DE COPIA
    */
    public Registos(Registos outroRegistos){
        
        this.clientes =outroRegistos.getClientes();
        this.proprietarios = outroRegistos.getProprietarios();
        this.carross = outroRegistos.getCarross();
        this.alugueres=outroRegistos.getAlugueres();
        this.classificacoes=outroRegistos.getClassificacoes();
    }
    
    
//GETTERS E SETTERS
    
      public HashSet<Cliente> getClientes(){
        HashSet<Cliente> newcliente =new HashSet<>();
        for(Cliente clie: this.clientes){
            newcliente.add(clie.clone());
        }
        return newcliente;
    }
      
      public HashSet<Proprietario> getProprietarios(){
        HashSet<Proprietario> newprop =new HashSet<>();
        for(Proprietario prop: this.proprietarios){
            newprop.add(prop.clone());
        }
        return newprop;
    }
      
      public HashSet<Carro> getCarross(){
        HashSet<Carro> newcar =new HashSet<>();
        for(Carro car: this.carross){
            newcar.add(car.clone());
        }
        return newcar;
    }
      
      public HashSet<Aluguer> getAlugueres(){
        HashSet<Aluguer> newalg =new HashSet<>();
        for(Aluguer alg: this.alugueres){
            newalg.add(alg.clone());
        }
        return newalg;
    }
      
      public HashSet<Classificar> getClassificacoes(){
        HashSet<Classificar> newcla =new HashSet<>();
        for(Classificar cla: this.classificacoes){
            newcla.add(cla.clone());
        }
        return newcla;
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
                && this.carross.equals(that.getCarross())
                && this.alugueres.equals(that.getAlugueres())
                && this.classificacoes.equals(that.getClassificacoes());
                
    }
    
    /**
     *TO STRING
     */
    
    public String toString(){
        StringBuffer sb = new StringBuffer("Registos: ");
        sb.append("Lista de clientes: ").append(this.clientes).append("\n ");
        sb.append("Lista de proprietários: ").append(this.proprietarios).append("\n ");
        sb.append("Lista de carros: ").append(this.carross).append("\n ");
        sb.append("Lista de alugueres: ").append(this.alugueres).append("\n ");
        sb.append("Lista de classificacoes: ").append(this.classificacoes).append("\n ");
        return sb.toString();
    }
    
    public void adicionarClientes (HashSet<Cliente> clientes, Cliente c){
        this.clientes.add(new Cliente(c));
    }
    
    public void adicionarProprietarios (HashSet<Proprietario> proprietarios, Proprietario p){
        this.proprietarios.add(new Proprietario(p));
    }
    
    public void adicionarcarros_gasolina (HashSet<Carro> carross, Gasolina gas){
        this.carross.add(new Gasolina(gas));
    }
    
    public void adicionarcarros_hibridos (HashSet<Carro> carross, Hibrido hib){
        this.carross.add(new Hibrido(hib));
    }
    
    public void adicionarcarros_eletricos (HashSet<Carro> carross, Eletrico ele){
        this.carross.add(new Eletrico(ele));
    }
    
    public void adicionarAlugueres(HashSet<Aluguer> alugueres, Aluguer a){
        this.alugueres.add(new Aluguer(a));
    }
    
    public void adicionarClassificacoes(HashSet<Classificar> classificacoes, Classificar cl){
        this.classificacoes.add(new Classificar(cl));
    }
    
    
    public boolean verificaEmail_Cliente (String email){
        Iterator<Cliente> it= clientes.iterator();
        Cliente elem;
        boolean r=false;
        while (it.hasNext() && r==false){
            elem=it.next();
           if(elem.getEmail().compareTo(email)==0) r=true;
        }
        return r;      
    }
   
    
    public boolean verificaPassword_Cliente (String pass){
        Iterator<Cliente> it= clientes.iterator();
        Cliente elem; 
        boolean r=false;
        while (it.hasNext() && r==false){
            elem=it.next();
           if(elem.getPassword().compareTo(pass)==0) r=true;
        }
        return r;      
    }
    
    public Cliente descobreCliente(String email){
        Iterator<Cliente> it= clientes.iterator();
        Cliente elem=null;
        boolean r=false;
        while (it.hasNext() && r==false){
            elem=it.next();
           if(elem.getEmail().compareTo(email)==0) r=true;
        }
        return elem;      
    }
    
    
   public Proprietario descobreProp(String email){
        Iterator<Proprietario> it= proprietarios.iterator();
        Proprietario elem=null;
        boolean r=false;
        while (it.hasNext() && r==false){
            elem=it.next();
           if(elem.getEmail().compareTo(email)==0) r=true;
        }
        return elem;      
    } 
    
    
    public boolean verificaEmail_Prop (String email){
        Iterator<Proprietario> it= proprietarios.iterator();
        Proprietario elem;
        boolean r=false;
        while (it.hasNext() && r==false){
            elem=it.next();
           if(elem.getEmail().compareTo(email)==0) r=true;
        }
        return r;      
    }
    
    public boolean verificaPassword_Prop (String pass){
        Iterator<Proprietario> it= proprietarios.iterator();
        Proprietario elem;
        boolean r=false;
        while (it.hasNext() && r==false){
            elem=it.next();
           if(elem.getPassword().compareTo(pass)==0) r=true;
        }
        return r;      
    }

}
