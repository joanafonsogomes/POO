
package poo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Facade implements Serializable{
    private HashSet<Cliente> clientes;
    private HashSet<Proprietario> proprietarios;
    private ArrayList<Carro> carross;
    private ArrayList<Gasolina> car_gasol;
    private ArrayList<Eletrico> car_elet;
    private ArrayList<Hibrido> car_hib;
    private ArrayList<Aluguer_final> alugueres;

    
/**  
*CONSTRUTOR VAZIO
*/
public Facade(){
this.clientes= new HashSet<>();
this.proprietarios= new HashSet<>();
this.carross=new ArrayList<>();
this.car_gasol=new ArrayList<>();
this.car_elet=new ArrayList<>();
this.car_hib=new ArrayList<>();
this.alugueres= new ArrayList<>();

}



 /**
 *CONSTRUTOR PARAMETERIZADO
 */
    public Facade(HashSet<Cliente> clientes, HashSet<Proprietario> proprietarios, ArrayList<Carro> carross, ArrayList<Aluguer_final> alugueres) {
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
        for(Aluguer_final alg: alugueres){
            this.alugueres.add(alg.clone());
        }
       
        
    }

 /**
    *CONSTRUTOR DE COPIA
    */
    public Facade(Facade outroFacade){
        
        this.clientes =outroFacade.getClientes();
        this.proprietarios = outroFacade.getProprietarios();
        this.carross = outroFacade.getCarross();
        this.car_gasol = outroFacade.getCar_gasol();
        this.car_elet = outroFacade.getCar_elet();
        this.car_hib = outroFacade.getCar_hib();
        this.alugueres=outroFacade.getAlugueres();
       
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
       
       
      
      public ArrayList<Aluguer_final> getAlugueres(){
        ArrayList<Aluguer_final> newalg =new ArrayList<>();
        for(Aluguer_final alg: this.alugueres){
            newalg.add(alg.clone());
        }
        return newalg;
    }
      
      
    
      
      
      
    /**
     *CLONE
     */
    public Facade clone(){
        return new Facade(this);
    }
    
    
    /**
     *EQUALS
     */
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        
        Facade that = (Facade) o;
        return super.equals(o)
                && this.clientes.equals(that.getClientes())
                && this.proprietarios.equals(that.getProprietarios())
                && this.carross.equals(that.getCarross())
                && this.car_gasol.equals(that.getCar_gasol())
                && this.car_elet.equals(that.getCar_elet())
                && this.car_hib.equals(that.getCar_hib())
                && this.alugueres.equals(that.getAlugueres());
               
                
    }
    
    /**
     *TO STRING
     */
    
    public String toString(){
        StringBuffer sb = new StringBuffer("");
        sb.append("Lista de clientes: ").append(this.clientes).append("\n ");
        sb.append("Lista de proprietários: ").append(this.proprietarios).append("\n ");
        sb.append("Lista de carros: ").append(this.carross).append("\n ");
        sb.append("Lista de carros a gasolina: ").append(this.car_gasol).append("\n ");
        sb.append("Lista de carros elétricos: ").append(this.car_elet).append("\n ");
        sb.append("Lista de carros híbridos: ").append(this.car_hib).append("\n ");
        sb.append("Lista de alugueres: ").append(this.alugueres).append("\n ");
    
        return sb.toString();
    }
    
    public void adicionarClientes (Cliente c){
        this.clientes.add(new Cliente(c));
    }
    
    public void adicionarProprietarios ( Proprietario p){
        this.proprietarios.add(new Proprietario(p));
    }
    
    public void adicionarcarros_gasolina (Gasolina gas){
        this.carross.add(new Gasolina(gas));
    }
    
    public void adicionarcarros_hibridos (Hibrido hib){
        this.carross.add(new Hibrido(hib));
    }
    
    public void adicionarcarros_eletricos (Eletrico ele){
        this.car_elet.add(new Eletrico(ele));
    }
    
     public void adicionarcarros_gasolina1 (Gasolina gas){
        this.car_gasol.add(new Gasolina(gas));
    }
    
    public void adicionarcarros_hibridos1 (Hibrido hib){
        this.car_hib.add(new Hibrido(hib));
    }
    
    public void adicionarcarros_eletricos1 ( Eletrico ele){
        this.carross.add(new Eletrico(ele));
    }
    
    public void adicionarAlugueres_final( Aluguer_final a){
        this.alugueres.add(new Aluguer_final(a));
    }
    
    
    /**
     *Verifica se o cliente já existe no sistema através do email
     */ 
    
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
   
    
    /**
     *Verifica se o cliente já existe no sistema através da password
     */ 
    
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
    
    /**
     *Descobre o cliente através do email
     */ 
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
    
    
   /**
     *Descobre o proprietário através do email
     */ 
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
    
    /**
     *Verifica se o proprietário já existe no sistema através do email
     */ 
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
    
    /**
     *Verifica se o proprietário já existe no sistema através da password
     */ 
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
    
    
    /**
     *Descobre o proprietário através do seu carro e do nif
     */ 
    public Proprietario encontrar_Prop (Carro car){
        Iterator<Proprietario> it= proprietarios.iterator();
        Proprietario elem=null;
        boolean r=false;
        while (it.hasNext() && r==false){
            elem=it.next();
           if(elem.getNif().compareTo(car.getNif())==0) r=true;
        }
        return elem;      
    }
    
    /**
     *Descobre o proprietário através da classif e do nif
     */ 
    public Proprietario encontrar_Prop (Classificar cla){
        Iterator<Proprietario> it= proprietarios.iterator();
        Proprietario elem=null;
        boolean r=false;
        while (it.hasNext() && r==false){
            elem=it.next();
           if(elem.getNif().compareTo(cla.getMat_Nif())==0) r=true;
        }
        return elem;      
    }
    
     /**
     *Descobre o cliente através do nif
     */ 
    public Cliente encontrar_Clie(String nif){
        Iterator<Cliente> it= clientes.iterator();
        Cliente elem=null;
        boolean r=false;
        while (it.hasNext() && r==false){
            elem=it.next();
           if(elem.getNif().compareTo(nif)==0) r=true;
        }
        return elem;      
    }
    
    /**
     *Descobre o cliente através da sua classificacao e do nif
     */ 
    public Cliente encontrar_Clie(Classificar cla){
        Iterator<Cliente> it= clientes.iterator();
        Cliente elem=null;
        boolean r=false;
        while (it.hasNext() && r==false){
            elem=it.next();
           if(elem.getNif().compareTo(cla.getMat_Nif())==0) r=true;
        }
        return elem;      
    }
    
     /**
     *Descobre o carro através da sua classificacao e da matrícula
     */ 
    public Carro encontrar_Carro(Classificar cla){
        Iterator<Carro> it= carross.iterator();
        Carro elem=null;
        boolean r=false;
        while (it.hasNext() && r==false){
            elem=it.next();
           if(elem.getMatricula().compareTo(cla.getMat_Nif())==0) r=true;
        }
        return elem;      
    }
    
    /**
     *Descobre o nif do proprietario
     */ 
    
    public String descobre_nif(Proprietario pros){
        String c;
        c=pros.getNif();
        return c;
    }
    
    /**
     *Descobre a autonomia do carro
     */ 
    public int descobre_autonomia(Carro car){
        int c;
        c=car.getAutonomia();
        return c;
    }
    
    
    /**
     *Descobre a matricula do carro
     */ 
    public String descobre_matricula(Carro car){
        String c;
        c=car.getMatricula();
        return c;
    }
    
    /**
     *Descobre a coordenada x do carro
     */ 
    public double descobre_x(Carro car){
        double c;
        c=car.getCoordenadasx();
        return c;
    }
    
    /**
     *Descobre a coordenada y do carro
     */ 
    public double descobre_y(Carro car){
        double c;
        c=car.getCoordenadasy();
        return c;
    }
    
    /**
     *Descobre a coordenada x do destino do cliente
     */ 
    public double descobre_cliente_destinox(Cliente clie){
        double c;
        c=clie.getDestinox();
        return c;
    }
    
    /**
     *Descobre a coordenada y do destino do cliente
     */ 
    public double descobre_cliente_destinoy(Cliente clie){
        double c;
        c=clie.getDestinoy();
        return c;
    }
    
   
    public void cliente_destinox(Cliente clie,double destinox){
        clie.setDestinox(destinox);
    }
    
    public void cliente_destinoy(Cliente clie,double destinoy){
        clie.setDestinoy(destinoy);
    }
    
    public void walking(Cliente clie, double walking){
    clie.setWalking(walking);
    }
    
    public void s_classif(Carro car){
    car.setClassificacao();
    }
    
    public void s_aval(Proprietario p){
    p.setAvaliacao();
    }
    
    
    /**
     *Criar cliente
     */
    public Cliente criacliente(String email, String nome, String password,String nif, String morada, LocalDate data, int a,double cx, double cy, double cwalking){
        HashSet<Classificar> clas= new HashSet<>();
        ArrayList<Aluguer_final> historico=new ArrayList<>();
        Cliente c =new Cliente(email,nome,password,nif,morada,data,clas,a,historico,cx,cy,cwalking);
        return c;
    }
    
    
    /**
     *Criar cliente
     */
    public Proprietario criaprop(String email, String nome, String password,String nif, String morada, LocalDate data, int a){
        ArrayList<Carro> carros=new ArrayList<>();
        ArrayList<Aluguer_final> historico=new ArrayList<>();
        HashSet<Classificar> clas= new HashSet<>();
        Proprietario c =new Proprietario(email,nome,password,nif,morada,data,clas,a,historico,carros);
        return c;
    }
    
    
    /**
     *Criar gasolina
     */
    public Gasolina criagas(String marca,String matricula, String nif,int autonomia, double vel, double preco,int cap, double consu, int clas , double coordx ,double coordy ,boolean pdalg, double dep){
        ArrayList<Aluguer_final> historico=new ArrayList<>();
        HashSet<Classificar> a= new HashSet<>();
        Gasolina gas =new Gasolina(historico,marca,matricula,nif,autonomia,vel,preco,cap,consu,a,clas,coordx,coordy,pdalg,dep);
        return gas;
    }
    
    
    /**
     *Criar eletrico
     */
    public Eletrico criael(String marca,String matricula, String nif,int autonomia, double vel, double preco,int cap, double consu, int clas , double coordx ,double coordy ,boolean pdalg, double bat){
        ArrayList<Aluguer_final> historico=new ArrayList<>();
        HashSet<Classificar> a= new HashSet<>();
        Eletrico el =new Eletrico(historico,marca,matricula,nif,autonomia,vel,preco,cap,consu,a,clas,coordx,coordy,pdalg,bat);
        return el;
    }
    
    
    /**
     *Criar hibrido
     */
    public Hibrido criah(String marca,String matricula, String nif,int autonomia, double vel, double preco,int cap, double consu,int clas , double coordx ,double coordy ,boolean pdalg ,double bat ,double dep){
        ArrayList<Aluguer_final> historico=new ArrayList<>();
        HashSet<Classificar> a= new HashSet<>();
        Hibrido h =new Hibrido(historico,marca,matricula,nif,autonomia,vel,preco,cap,consu,a,clas,coordx,coordy,pdalg,bat,dep);
        return h;
    }
    
    /**
     *Novo aluguer
     */
    public Aluguer_final novoal(Cliente c1, Proprietario p1,Carro car, double inicio_x, double inicio_y, double final_x, double final_y, double tempo_viagem) {
        Aluguer_final al =new Aluguer_final(c1,p1,car,inicio_x,inicio_y,final_x,final_y,tempo_viagem);
        return al;
    }
    
    
    /**
     *Novo classificar
     */
    public Classificar novocl(String mat_nif, int nota){
        Classificar cl =new Classificar(mat_nif,nota);
        return cl;
    }
    
    
    /**
     *Solicitar o aluguer do carro mais proximo das suas coordenadas ; retorna o carro mais proximo
     */
    public Carro closestCar(ArrayList<Carro> carros, Cliente clie){
        Carro chosen=null;
        double dist = 10000.0;
        for(int i=0 ; i < carros.size() ; i++){
            Carro j = carros.get(i);
            double distance = Math.sqrt(Math.pow((j.getCoordenadasx() - clie.getX()),2) + Math.pow((j.getCoordenadasy() - clie.getY()),2));
                if( distance < dist){
                    dist = distance;
                    chosen = j;  
                }
        }  
    return chosen;
    }
    
    /**
     *Solicitar o aluguer do carro mais barato ; retorna o carro mais barato
     */
    public Carro cheapestCar(ArrayList<Carro> carros){
        Carro chosen =null;
        double price = 10000.0;
        for(int i=0 ; i < carros.size() ; i++){
            Carro j = carros.get(i);
                if( j.getPreco() < price){
                    price = j.getPreco();
                    chosen = j;  
                }
        }  
    return chosen; 
    }
    
    
     /**
     *Solicitar o aluguer do carro mais barato dentro de uma distancia que esta disposto a percorrer a pe; retorna o carro
     */
    public Carro walkTillThere(ArrayList<Carro> carros,Cliente clie){
        Carro chosen=null;
        double price = 10000.0;
        for(int i=0 ; i < carros.size() ; i++){
            Carro j = carros.get(i);
            double distance = Math.sqrt(Math.pow((j.getCoordenadasx() - clie.getX()),2) + Math.pow((j.getCoordenadasy() - clie.getY()),2));
                if( distance < clie.getWalking()){
                   if( j.getPreco() < price){
                    price = j.getPreco();
                    chosen = j;  
                   }
                }
        }  
    return chosen;
    }
    
    
    /**
     *Solicitar o aluguer de um carro especifico; retorna o carro em questao
     */
    //public Carro specificCar(ArrayList<Carro> carros){
    
        //DIZER SE QUERO GASOLINA,......
        
    //}
    
    
    /**
     *Calcula a distancia a que o cliente está do destino
     */
    public double distanciaDestino(Cliente clie){
        double distanciaDest = Math.sqrt(Math.pow((clie.getDestinox() - clie.getX()),2) + Math.pow((clie.getDestinoy() - clie.getY()),2));
        return distanciaDest;
    }
    
     /**
     *Calcula a distancia a que o carro está do destino
     */
    public double distanciaDestino_carro(Carro ca, Cliente clie){
        double iniciox=ca.getCoordenadasx();
        double inicioy=ca.getCoordenadasy();
        double distancia = Math.sqrt(Math.pow((clie.getDestinox() - iniciox),2) + Math.pow((clie.getDestinoy() - inicioy),2));
        return distancia;
    }
    
      /**
     *Calcula o custo estimado da viagem tendo em conta o deslocamento 
     */
     public double custo_estimado (Carro ca,Cliente clie){
        double custo;
        double preco= ca.getPreco();
        double distancia = distanciaDestino_carro(ca,clie);
        custo =preco *distancia;
        return custo;
    }
     
      /**
     *Ver se um certo carro tem autonomia para chegar ao destino !!NAO SEI SE PONHO NESTA CLASSE YET!!
     */
    public boolean temAutonomia(Carro carro, Cliente clie){
        boolean i = false;
        double quantoConsome = carro.getConsumocombus();
        if(carro instanceof Gasolina){
            Gasolina carro1 = (Gasolina) carro;
                //fazer cenas de carrinho   
                if( carro1.getDeposito() > (quantoConsome * distanciaDestino(clie))){
                    i = true;
                }
        }
        
        if(carro instanceof Eletrico){
            Eletrico carro2 = (Eletrico) carro;  
                if( carro2.getBateria() > (quantoConsome * distanciaDestino(clie))){
                    i = true;
                }
        }
        
        if(carro instanceof Hibrido){
            Hibrido carro3 = (Hibrido) carro;  
                if( (carro3.getDeposito() > (quantoConsome * distanciaDestino(clie)) ) || ( carro3.getBateria() > (quantoConsome * distanciaDestino(clie))) ){
                    i = true;
                }
        }
        
        return i;
    }
    
    
     /**
     * Sinalizar que um carro está disponivel para aluguer
     */
    public boolean disponivel(Carro f){
    boolean r=false;
       if(f.isPdalugar()==true)
        r=true;
       else r=false;
    return r;
    }
    
      /**
     * Abastecer o veiculo
     */
    public void abastecerGasolina(Gasolina c, double quantidade){
        if(quantidade>60){
        System.out.println("ERRO: É impossível abastecer. Por favor abasteça com uma quantidade inferior a 60 litros");
        }
        else c.setDeposito(quantidade);
}
    
    public void abastecerElétrico(Eletrico ele, double bateria){
        ele.setBateria(bateria);
    }
    
    public void abastecerHibrido(Hibrido h, double bateria, double quantidade){
        if(quantidade>60){
            System.out.println("ERRO: É impossível abastecer o depósito. Por favor abasteça com uma quantidade inferior a 60 litros");
        }
        else {
           h.setBateria(bateria);
           h.setDeposito(quantidade);
        }
    }
    
   
    
    public void alterarPreco (Carro c, double preco){
        c.setPreco(preco);
    }
    
    
    public boolean aceitarAluguer (Cliente c, Carro ca){
        return temAutonomia(ca,c);
        
    }
    
    public double custoViagem (Carro ca, double destinox, double destinoy){
        double custo;
        double preco= ca.getPreco();
        double iniciox=ca.getCoordenadasx();
        double inicioy=ca.getCoordenadasy();
        double distancia = Math.sqrt(Math.pow((destinox - iniciox),2) + Math.pow((destinoy - inicioy),2));
        custo =preco *distancia;
        return custo;
    }
    
    
        public void adicionarcarros_prop (Carro car, Proprietario p){
        p.adicionarcarros(car);
    }    
      
        public void removecarros_prop (Carro car, Proprietario p){
        p.removecarros(car);
    }    
    
        public void addclassif_carro (Carro car, Classificar a){
        car.adicionarClassiff(a);
    }  
     
    public void adicionarAluguer_finall_veiculo (Aluguer_final a, Veiculo v){
          v.adicionarAluguer_finall(a);
      }   
    
    public void adicionarAluguer_final_pessoa(Aluguer_final a, Pessoa b){
          b.adicionarAluguer_final(a);
      }
    
    public void adicionarClassif_pessoa(Classificar a, Pessoa b){
          b.adicionarClassif(a);
      }
     
    /**
     *Alterar coordenadas do carro
     */
    
    public void alterarcoordenadas_carro(Carro c, double c_x, double c_y){
        c.setCoordenadasx(c_x);
        c.setCoordenadasy(c_y);
    }
    
    public void alterarcoordenadas_cliente(Cliente clie, double x, double y){
        clie.setX(x);
        clie.setY(y);
    }
  
    
    
    
     /**
     * Método que guarda em ficheiro de objectos o objecto que recebe a mensagem.
     */
    public void guardaEstado(String nome) throws FileNotFoundException, IOException {
      FileOutputStream fos = new FileOutputStream(nome);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(this);
      oos.flush ();
      oos.close();
    }
    
     /**
     * Método que carrega o ficheiro outrora guardado
     */
    public static Facade carregaEstado(String nome) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis= new FileInputStream(nome);
        ObjectInputStream ois= new ObjectInputStream(fis);
        Facade h =(Facade) ois.readObject();
        ois.close();
        return h;
    }
   
    
    public static Facade testee() throws IOException{ 
    
    Facade r=new Facade();
    
    int s=1; int scan; Carro car=null;
        Aluguer_final algss=null;
        Cliente clie=new Cliente();
        Proprietario pros=new Proprietario();
        LocalDate data=LocalDate.now();
        ArrayList<Aluguer_final> historico=new ArrayList<>();
        int cap=0;
        double walking=0.0;
        int classificacao=0;
        boolean pode_alugar=true;
        double deposito=0.0;
        double bateria=0.0;
        ArrayList<Carro> carros=new ArrayList<>();
        HashSet<Classificar> clas= new HashSet<>();
        
        Scanner scc=new Scanner(System.in);
    
    
        InputStream inputStream = Facade.class.getResourceAsStream("logsPOO_carregamentoInicial.bak");       
        try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
        for(String ss; (ss = br.readLine()) != null; ) {
        for(String l: ss.split(":")){
            
        if(l.compareTo("NovoProp")==0) {
        String[] word =ss.split(",|:");
        Proprietario pro =new Proprietario (word[3],word[1],word[2],word[2],word[4],data,clas,classificacao,historico,carros);
        r.adicionarProprietarios(pro);     
        }
        
        else if(l.compareTo("NovoCliente")==0){
        String[] word =ss.split(",|:");
        Cliente cc =new Cliente(word[3],word[1],word[2],word[2],word[4],data,clas,classificacao,historico,Double.parseDouble(word[5]),Double.parseDouble(word[6]),walking);
        r.adicionarClientes (cc);    
        }  
                
        else if(l.compareTo("NovoCarro")==0){
        String[] word =ss.split(",|:");
        if(word[1].compareTo("Gasolina")==0){
        Gasolina gas =new Gasolina(historico,word[2],word[3],word[4],Integer.parseInt(word[8]),Double.parseDouble(word[5]),Double.parseDouble(word[6]),cap,Double.parseDouble(word[7]),clas,classificacao,Double.parseDouble(word[9]),Double.parseDouble(word[10]),pode_alugar,deposito);
        r.adicionarcarros_gasolina(gas);  
        r.adicionarcarros_gasolina1(gas); 
        Proprietario pll= r.encontrar_Prop(gas);
        r.adicionarcarros_prop(gas,pll);
        }
        
        if(word[1].compareTo("Electrico")==0){
        Eletrico el =new Eletrico(historico,word[2],word[3],word[4],Integer.parseInt(word[8]),Double.parseDouble(word[5]),Double.parseDouble(word[6]),cap,Double.parseDouble(word[7]),clas,classificacao,Double.parseDouble(word[9]),Double.parseDouble(word[10]),pode_alugar,bateria);
        r.adicionarcarros_eletricos( el);  
        r.adicionarcarros_eletricos1( el); 
        Proprietario pll= r.encontrar_Prop(el);
        r.adicionarcarros_prop(el,pll);
        
        }
        if(word[1].compareTo("Hibrido")==0){
        Hibrido hi =new Hibrido(historico,word[2],word[3],word[4],Integer.parseInt(word[8]),Double.parseDouble(word[5]),Double.parseDouble(word[6]),cap,Double.parseDouble(word[7]),clas,classificacao,Double.parseDouble(word[9]),Double.parseDouble(word[10]),pode_alugar,bateria,deposito);
        r.adicionarcarros_hibridos( hi);  
        r.adicionarcarros_hibridos1( hi); 
        Proprietario pll= r.encontrar_Prop(hi);
        r.adicionarcarros_prop(hi,pll);
        }
          
        }    
        
        else if(l.compareTo("Aluguer")==0){
        String[] word =ss.split(",|:");
        Aluguer algg =new Aluguer(word[1],Double.parseDouble(word[2]),Double.parseDouble(word[3]),word[4],word[5]);
        clie= r.encontrar_Clie(word[1]);
        
        if(word[5].compareTo("MaisBarato")==0){
        car=r.cheapestCar(r.getCarross());
        pros= r.encontrar_Prop(car);
        r.removecarros_prop (car,pros);
        //resolver o aseguir
        if(car.getAutonomia()>r.distanciaDestino_carro(car,clie)){
        double temp_viagem=0;
        algss =new Aluguer_final(clie,pros,car,car.getCoordenadasx(),car.getCoordenadasy(),algg.getFinal_x(),algg.getFinal_y(),temp_viagem);
        r.adicionarAluguer_finall_veiculo(algss,car);
        r.adicionarAlugueres_final(algss);
        r.adicionarAluguer_final_pessoa(algss,clie);
        r.adicionarAluguer_final_pessoa(algss,pros);
        r.adicionarcarros_prop (car,pros);
        }
        }
        
        else{
        car=r.closestCar(r.getCarross(),clie);
        pros= r.encontrar_Prop(car);
        r.removecarros_prop (car,pros);
        if(car.getAutonomia()>r.distanciaDestino_carro(car,clie)){
        double temp_viagem=0;
        algss =new Aluguer_final(clie,pros,car,car.getCoordenadasx(),car.getCoordenadasy(),algg.getFinal_x(),algg.getFinal_y(),temp_viagem);
        r.adicionarAluguer_finall_veiculo(algss,car);
        r.adicionarAlugueres_final(algss);
        r.adicionarAluguer_final_pessoa(algss,clie);
        r.adicionarAluguer_final_pessoa(algss,pros);
        r.adicionarcarros_prop (car,pros);
        
        } 
        }
        
        
        }
                
        else if(l.compareTo("Classificar")==0){
        String[] word =ss.split(",|:");
        Classificar cla =new Classificar(word[1],Integer.parseInt(word[2]));
        if (r.encontrar_Clie(cla)!=null) {
            clie=r.encontrar_Clie(cla);
            r.adicionarClassif_pessoa(cla,clie);
            clie.setAvaliacao();
            
        }
        if (r.encontrar_Carro(cla)!=null){
            car=r.encontrar_Carro(cla);
            r.addclassif_carro(car,cla);
            car.setClassificacao();
            
        }
        if (r.encontrar_Prop(cla)!=null){
             pros=r.encontrar_Prop(cla);
             r.adicionarClassif_pessoa(cla,pros);
             pros.setAvaliacao();
             
        }
        
        }
         }
    }   br.close();
    
} return r;
    }
    
    
    
    
}
