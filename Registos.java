
package poo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Registos {
    private HashSet<Cliente> clientes;
    private HashSet<Proprietario> proprietarios;
    private ArrayList<Carro> carross;
    private ArrayList<Gasolina> car_gasol;
    private ArrayList<Eletrico> car_elet;
    private ArrayList<Hibrido> car_hib;
    private ArrayList<Aluguer> alugueres;
    private HashSet<Classificar> classificacoes;
    
/**  
*CONSTRUTOR VAZIO
*/
public Registos(){
this.clientes= new HashSet<>();
this.proprietarios= new HashSet<>();
this.carross=new ArrayList<>();
this.car_gasol=new ArrayList<>();
this.car_elet=new ArrayList<>();
this.car_hib=new ArrayList<>();
this.alugueres= new ArrayList<>();
this.classificacoes=new HashSet<>();
}



 /**
 *CONSTRUTOR PARAMETERIZADO
 */
    public Registos(HashSet<Cliente> clientes, HashSet<Proprietario> proprietarios, ArrayList<Carro> carross, ArrayList<Aluguer> alugueres, HashSet<Classificar> classificacoes) {
        this.clientes = new HashSet<>();
        for(Cliente clie: clientes){
            this.clientes.add(clie.clone());
        }
        this.proprietarios = new HashSet<>();
        for(Proprietario prop: proprietarios){
            this.proprietarios.add(prop.clone());
        }
        this.carross = new ArrayList<>();
        for(Carro car: carross){
            this.carross.add(car.clone());
        }
        
        this.car_gasol = new ArrayList<>();
        for(Gasolina car: car_gasol){
            this.car_gasol.add(car.clone());
        }
        
        
        this.car_elet = new ArrayList<>();
        for(Eletrico car: car_elet){
            this.car_elet.add(car.clone());
        }
        
        this.car_hib = new ArrayList<>();
        for(Hibrido car: car_hib){
            this.car_hib.add(car.clone());
        }
        
        
        this.alugueres = new ArrayList<>();
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
        this.car_gasol = outroRegistos.getCar_gasol();
        this.car_elet = outroRegistos.getCar_elet();
        this.car_hib = outroRegistos.getCar_hib();
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
      
      public ArrayList<Carro> getCarross(){
        ArrayList<Carro> newcar =new ArrayList<>();
        for(Carro car: this.carross){
            newcar.add(car.clone());
        }
        return newcar;
    }
      
       public ArrayList<Gasolina> getCar_gasol(){
        ArrayList<Gasolina> newcar =new ArrayList<>();
        for(Gasolina car: this.car_gasol){
            newcar.add(car.clone());
        }
        return newcar;
    }
       
       public ArrayList<Eletrico> getCar_elet(){
        ArrayList<Eletrico> newcar =new ArrayList<>();
        for(Eletrico car: this.car_elet){
            newcar.add(car.clone());
        }
        return newcar;
    }
       
       public ArrayList<Hibrido> getCar_hib(){
        ArrayList<Hibrido> newcar =new ArrayList<>();
        for(Hibrido car: this.car_hib){
            newcar.add(car.clone());
        }
        return newcar;
    }
       
       
      
      public ArrayList<Aluguer> getAlugueres(){
        ArrayList<Aluguer> newalg =new ArrayList<>();
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
    
    public void adicionarcarros_gasolina (ArrayList<Carro> carross, Gasolina gas){
        this.carross.add(new Gasolina(gas));
    }
    
    public void adicionarcarros_hibridos (ArrayList<Carro> carross, Hibrido hib){
        this.carross.add(new Hibrido(hib));
    }
    
    public void adicionarcarros_eletricos (ArrayList<Carro> carross, Eletrico ele){
        this.car_elet.add(new Eletrico(ele));
    }
    
     public void adicionarcarros_gasolina1 (ArrayList<Gasolina> carross, Gasolina gas){
        this.car_gasol.add(new Gasolina(gas));
    }
    
    public void adicionarcarros_hibridos1 (ArrayList<Hibrido> carross, Hibrido hib){
        this.car_hib.add(new Hibrido(hib));
    }
    
    public void adicionarcarros_eletricos1 (ArrayList<Eletrico> carross, Eletrico ele){
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
