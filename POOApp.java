
package poo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author susanamarques
 */
public class POOApp {
    
    private Facade r;
    
    private Menu MenuCliente, MenuProp, Menu_pretendecliente;
    private Menu Menu_InsereViat; 
    private Menu Menu_inicial;
 
 /**
     * O método main cria a aplicação e invoca o método run()
     */
    public static void main(String[] args) throws IOException {
        new POOApp().run();
    }   
    
 /**
     * Construtor.
     * 
     * Cria os menus e a camada de negócio.
     */
    
    private POOApp() throws IOException{
        // Criar o menu 
        String[] opcoes_menuinicial={"Faça login na aplicação como cliente.",
                                    "Faça login na aplicação como proprietário.",
                                    "Registe-se como cliente para criar uma conta.",
                                    "Registe-se como proprietário para criar uma conta.",
                                     };
        
        
        String[] opcoes_cliente = {"Visualizar o meu perfil.",
                           "Alterar a minha localização.",
                           "Solicitar um aluguer.",
                           "Sair."
                           };
        
        String[] opcoes_prop = {"Visualizar o meu perfil.",
                                 "Adicionar viatura.",
                                 "Sair."
                                 };
        
        
        String[] opcoes_pretendecliente = {"Solicitar o aluguer de um carro mais próximo"
                       + " das suas coordenadas.",
                                         "Solicitar o aluguer do carro mais barato.",
                                         "Solicitar o aluguer do carro mais barato, dentro"
                       + " de uma distância que está disposto a percorrer a pé.",
                                         "Solicitar o aluguer de um carro especifico.",
                                         "Solicitar o aluguer de um carro com uma determinada autonomia.",
                                         "Sair."};
        
        String[] opcoes_insere_viat = {"Alugar carro a gasolina.",
                                         "Alugar carro eletrico.",
                                         "Alugar carro híbrido.",
                                         "Sair."};
        
        this.MenuCliente = new Menu(opcoes_cliente);        
        this.MenuProp = new Menu(opcoes_prop);
        this.Menu_pretendecliente= new Menu(opcoes_pretendecliente);
        this.Menu_InsereViat=new Menu(opcoes_insere_viat);
        this.Menu_inicial=new Menu(opcoes_menuinicial);
        
        
        // Criar a lógica de negócio
        try {
            this.r = Facade.carregaEstado("estado.obj");
        }
        catch (FileNotFoundException e) {
            System.out.println("Parece que é a primeira utilização...");  
            this.r = r.testee();   
        }
        catch (IOException e) {
            System.out.println("Ops! Erro de leitura!");     
            this.r = new Facade();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Ops! Formato de ficheiro de dados errado!");
            this.r = new Facade();
        }
    }
        
        
         /**
     * Executa o menu principal e invoca o método correspondente à opção seleccionada.
     */
    private void run() {
        System.out.println("\n**********************");
        System.out.println("BEM VINDO À UMCarroJá!");
        System.out.println("**********************\n");
        do {
            Menu_inicial.executa();
            switch (Menu_inicial.getOpcao()) {
                case 1: tratalogincliente();
                case 2: trataloginprop();
                case 3: registocliente();
                case 4: registoprop();
            }
        } while (Menu_inicial.getOpcao()!=0); // A opção 0 é usada para sair do menu.
        try {
            this.r.guardaEstado("estado.obj");
        }
        catch (IOException e) {
            System.out.println("Ops! Não consegui gravar os dados!");
        }
        System.out.println("Até breve!...");  
        System.exit(0);
    }
       
    
    
    
    // Métodos auxiliares
    public void tratalogincliente() {
        Scanner scin = new Scanner(System.in);
        String email;
        String pass;
            System.out.println("Insira o seu email: ");
            email=scin.nextLine();
            System.out.println("----------------------");
            System.out.print('\u000C');
            System.out.println("Insira a sua password: ");
            pass=scin.nextLine();
            System.out.println("----------------------");
            System.out.print('\u000C');
            if(r.verificaEmail_Cliente(email)==true && r.verificaPassword_Cliente(pass)==true ) {
            do {
            MenuCliente.executa();
            switch (MenuCliente.getOpcao()) {
                case 1: ver_cliente_perfil( email);
                case 2: altera_localizacao_cliente( email);
                case 3: solicitar_aluguer(email);
                case 4: sair();
            }
        } while (MenuCliente.getOpcao()!=0); // A opção 0 é usada para sair do menu.
            try {
            this.r.guardaEstado("estado.obj");
        }
        catch (IOException e) {
            System.out.println("Ops! Não consegui gravar os dados!");
        }
        System.out.println("Até breve!..."); 
        System.exit(0);
    }
            
            else {
                System.out.println("O seu email ou a sua palavra passe estão errados. Por favor tente de novo.");
                sair();
            }
    }
    
    private void trataloginprop(){
            Scanner scin = new Scanner(System.in);
            String email;
            String pass;
            System.out.println("Insira o seu email: ");
            email=scin.nextLine();
            System.out.println("----------------------");
            System.out.print('\u000C');
            System.out.println("Insira a sua password: ");
            pass=scin.nextLine();
            System.out.println("----------------------");
            System.out.print('\u000C');
            if(r.verificaEmail_Prop(email)==true && r.verificaPassword_Prop(pass)==true ) {  
            do {
            MenuProp.executa();
            switch (MenuProp.getOpcao()) {
                case 1: ver_prop_perfil(email);
                case 2: adicionarviatura(email);
                case 3: sair();
            }
        } while (MenuProp.getOpcao()!=0); // A opção 0 é usada para sair do menu.
            try {
            this.r.guardaEstado("estado.obj");
        }
        catch (IOException e) {
            System.out.println("Ops! Não consegui gravar os dados!");
        }
        System.out.println("Até breve!...");     
        System.exit(0);   
            
            
            
            }
            else {
                System.out.println("O seu email ou a sua palavra passe estão errados. Por favor tente de novo.");
                sair();
            }
        }
    
    private void registocliente(){
               Scanner scin = new Scanner(System.in);
               Scanner sc=new Scanner(System.in);
               String email, nome,pass,nif,morada;
               LocalDate data=LocalDate.now();
               Double x,y,walking=0.0;
               int classificacao=0;
               System.out.println("Insira o seu email: "); 
               email=scin.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Crie um nome de utilizador: ");
               nome=scin.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Crie uma palavra passe: "); 
               pass=scin.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Insira o seu NIF: "); 
               nif=scin.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Insira a sua morada: "); 
               morada=scin.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Insira data de nascimento: [AAAA-MM-DD]"); 
               data=LocalDate.parse(scin.nextLine());
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Indique a sua localização em coordenadas (x,y):");
               System.out.println("Coordenada x:");
               x=sc.nextDouble();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Coordenada y:");
               y=sc.nextDouble();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Indique a distância que está disposto a percorrer a pé (em Km):");
               walking=sc.nextDouble();
               System.out.println("----------------------");
               System.out.print('\u000C');
               r.adicionarClientes (r.criacliente(email, nome, pass, nif, morada, data, classificacao, x, y, walking));
               System.out.println("O seu registo foi concluído com sucesso.\n"
                       + "Faça login como cliente para conseguir ter acesso à aplicação.");
               sair();
    
    }
    
    private void registoprop (){
               Scanner scin = new Scanner(System.in);
               String email, nome,pass,nif,morada;
               LocalDate data=LocalDate.now();
               int classificacao=0;
 
               System.out.println("Insira o seu email: "); 
               email=scin.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Crie um nome de utilizador: ");
               nome=scin.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Crie uma palavra passe: "); 
               pass=scin.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Insira o seu NIF: "); 
               nif=scin.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Insira a sua morada: "); 
               morada=scin.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Insira data de nascimento: [AAAA-MM-DD]"); 
               data=LocalDate.parse(scin.nextLine());
               System.out.println("----------------------");
               System.out.print('\u000C'); 
               classificacao=0;
               r.adicionarProprietarios (r.criaprop(email, nome, pass, nif, morada, data, classificacao));
               System.out.println("O seu registo foi concluído com sucesso.\n"
                       + "Faça login como proprietário para conseguir ter acesso à aplicação."); 
               sair();
            }
  
  private void sair(){
       do {
            Menu_inicial.executa();
            switch (Menu_inicial.getOpcao()) {
                case 1: tratalogincliente();
                case 2: trataloginprop();
                case 3: registocliente();
                case 4: registoprop();
            }
        } while (Menu_inicial.getOpcao()!=0); // A opção 0 é usada para sair do menu.
        try {
            this.r.guardaEstado("estado.obj");
        }
        catch (IOException e) {
            System.out.println("Ops! Não consegui gravar os dados!");
        }
        System.out.println("Até breve!..."); 
        System.exit(0);
    }
  
  public void voltarMenu_cliente(String email){
     Scanner sc=new Scanner(System.in);
     String x;
     System.out.println("Carregue em qualquer tecla para voltar ao menu!"); 
     x=sc.next();
    do {
            MenuCliente.executa();
            switch (MenuCliente.getOpcao()) {
                case 1: ver_cliente_perfil(email);
                case 2: altera_localizacao_cliente(email);
                case 3: solicitar_aluguer(email);
                case 4: sair();
            }
        } while (MenuCliente.getOpcao()!=0); // A opção 0 é usada para sair do menu.
            try {
            this.r.guardaEstado("estado.obj");
        }
        catch (IOException e) {
            System.out.println("Ops! Não consegui gravar os dados!");
        }
        System.out.println("Até breve!..."); 
        System.exit(0);
  }
         
   
  public void voltarMenu_prop(String mail){
      Scanner sc=new Scanner(System.in);
      String x;
      System.out.println("Carregue em qualquer tecla para voltar ao menu!"); 
      x=sc.next();
      do {
            MenuProp.executa();
            switch (MenuProp.getOpcao()) {
                case 1: ver_prop_perfil(mail);
                case 2: adicionarviatura(mail);
                case 3: sair();
            }
        } while (MenuProp.getOpcao()!=0); // A opção 0 é usada para sair do menu.
            try {
            this.r.guardaEstado("estado.obj");
        }
        catch (IOException e) {
            System.out.println("Ops! Não consegui gravar os dados!");
        }
        System.out.println("Até breve!...");  
        System.exit(0);
                     
            
  }
  
    public void ver_cliente_perfil(String email){
       System.out.println("\n**********************");
       System.out.println("**********************\n");
       System.out.println(r.descobreCliente(email).toString()); 
       System.out.println("**********************");
       System.out.println("**********************\n");
       voltarMenu_cliente(email);
   }
  
  
  private void altera_localizacao_cliente(String email){
               Scanner sc=new Scanner(System.in);
               Double x,y;
               System.out.println("Indique as suas coordenadas atuais (x,y):");
               System.out.println("Coordenada x:");
               x=sc.nextDouble();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Coordenada y:");
               y=sc.nextDouble();
               System.out.println("----------------------");
               System.out.print('\u000C');  
               r.alterarcoordenadas_cliente(r.descobreCliente(email),x,y);
               System.out.println("A sua localização foi alterada com sucesso!\n");
               voltarMenu_cliente(email);
  }
  
  
  private void solicitar_aluguer(String email){
      Scanner sc=new Scanner(System.in);
      double destinox, destinoy;
      System.out.println("Indique as coordenadas do seu destino (x,y):");
      System.out.println("Coordenada x:");
      destinox=sc.nextDouble();
      System.out.println("----------------------");
      System.out.print('\u000C');
      System.out.println("Coordenada y:");
      destinoy=sc.nextDouble();
      System.out.println("----------------------");
      System.out.print('\u000C');  
      r.cliente_destinox(r.descobreCliente(email),destinox);
      r.cliente_destinoy(r.descobreCliente(email),destinoy);
      do {
            Menu_pretendecliente.executa();
            switch (Menu_pretendecliente.getOpcao()) {
                case 1: realizaraluguer1(email);
                case 2: realizaraluguer2(email);
                case 3: trataWalking(email); realizaraluguer3(email);
                case 4: System.out.println("Por fazer!!");
                case 5: System.out.println("Por fazer!!");
                case 6: sair();
            }
        } while (Menu_pretendecliente.getOpcao()!=0); // A opção 0 é usada para sair do menu.
        try {
            this.r.guardaEstado("estado.obj");
        }
        catch (IOException e) {
            System.out.println("Ops! Não consegui gravar os dados!");
        }
        System.out.println("Até breve!..."); 
        System.exit(0);
    }
  
  private void trataWalking(String email){
    Scanner sc=new Scanner(System.in);
    System.out.println("Indique a distância que está disposto a percorrer a pé (em Km):");
    double walking=sc.nextDouble();
    System.out.println("----------------------");
    System.out.print('\u000C');
    r.walking(r.descobreCliente(email),walking);
    
    
 }
  
  
  private void ver_prop_perfil(String email){
      System.out.println("\n**********************");
      System.out.println("**********************\n");
      System.out.println(r.descobreProp(email).toString());
      System.out.println("**********************");
      System.out.println("**********************\n");
      voltarMenu_prop(email);
  }
  
  
  private void adicionarviatura(String email){
      do {
            Menu_InsereViat.executa();
            switch (Menu_InsereViat.getOpcao()) {
                case 1: alugarcarro_gasolina(email);
                case 2: alugarcarro_eletrico(email);
                case 3: alugarcarro_hibrido(email);
                case 4: sair();
            }
        } while (Menu_InsereViat.getOpcao()!=0); // A opção 0 é usada para sair do menu.
        try {
            this.r.guardaEstado("estado.obj");
        }
        catch (IOException e) {
            System.out.println("Ops! Não consegui gravar os dados!");
        }
        System.out.println("Até breve!..."); 
        System.exit(0);
    }
      
    public void alugarcarro_gasolina(String email){
        Scanner scanIn=new Scanner(System.in);
        Scanner scc=new Scanner(System.in);
        Scanner sc=new Scanner(System.in);
        String marca, matricula;
        int autonomia;
        double velocidade,preco,consumo,x,y;
        int cap=0, classificacao=0;
        double deposito=0.0;
        boolean pode_alugar=true;
        System.out.println("Insira a marca do carro:");
                marca=scanIn.nextLine();
                System.out.println("----------------------");
            System.out.print('\u000C');
                System.out.println("Insira a matricula do carro:");
                matricula=scanIn.nextLine();
                System.out.println("----------------------");
            System.out.print('\u000C');
            System.out.println("Insira a autonomia atual :");
                autonomia=scc.nextInt();
                System.out.println("----------------------");
            System.out.print('\u000C');
                System.out.println("Insira a velocidade média do carro por km:");
                velocidade=sc.nextDouble();
                System.out.println("----------------------");
            System.out.print('\u000C');
                System.out.println("Insira o preco do carro por km:");
                preco=sc.nextDouble();
                System.out.println("----------------------");
            System.out.print('\u000C');
                System.out.println("Insira a quantidade em litros que o carro consome por km:");
                consumo=sc.nextDouble();
                System.out.println("----------------------");
            System.out.print('\u000C');
                System.out.println("Indique a localização do carro em coordenadas (x,y):");
               System.out.println("Coordenada x:");
               x=sc.nextDouble();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Coordenada y:");
               y=sc.nextDouble();
               System.out.println("----------------------");
               System.out.print('\u000C');          
               r.adicionarcarros_gasolina(r.criagas( marca, matricula, r.descobre_nif(r.descobreProp(email)), autonomia, velocidade, preco, cap, consumo,  classificacao, x, y, pode_alugar, deposito));  
               r.adicionarcarros_gasolina1(r.criagas( marca, matricula, r.descobre_nif(r.descobreProp(email)), autonomia, velocidade, preco, cap, consumo,  classificacao, x, y, pode_alugar, deposito));
               r.adicionarcarros_prop(r.criagas( marca, matricula, r.descobre_nif(r.descobreProp(email)), autonomia, velocidade, preco, cap, consumo, classificacao, x, y, pode_alugar, deposito),r.descobreProp(email));
               System.out.println("O seu carro a gasolina foi inserido com sucesso!\n");
               voltarMenu_prop(email);
    }
  
    public void alugarcarro_eletrico(String email){
        Scanner scanIn=new Scanner(System.in);
        Scanner scc=new Scanner(System.in);
        Scanner sc=new Scanner(System.in);
        String marca, matricula;
        int autonomia;
        double velocidade,preco,consumo,x,y;
        int cap=0, classificacao=0;
        double bateria=0.0;
        boolean pode_alugar=true;
        System.out.println("Insira a marca do carro:");
                marca=scanIn.nextLine();
                System.out.println("----------------------");
            System.out.print('\u000C');
                System.out.println("Insira a matricula do carro:");
                matricula=scanIn.nextLine();
                System.out.println("----------------------");
            System.out.print('\u000C');
            System.out.println("Insira a autonomia atual :");
                autonomia=scc.nextInt();
                System.out.println("----------------------");
            System.out.print('\u000C');
                System.out.println("Insira a velocidade média do carro por km:");
                velocidade=sc.nextDouble();
                System.out.println("----------------------");
            System.out.print('\u000C');
                System.out.println("Insira o preco do carro por km:");
                preco=sc.nextDouble();
                System.out.println("----------------------");
            System.out.print('\u000C');
                System.out.println("Insira a quantidade de bateria que o carro consome por km:");
                consumo=sc.nextDouble();
                System.out.println("----------------------");
            System.out.print('\u000C');
                System.out.println("Indique a localização do carro em coordenadas (x,y):");
               System.out.println("Coordenada x:");
               x=sc.nextDouble();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Coordenada y:");
               y=sc.nextDouble();
               System.out.println("----------------------");
               System.out.print('\u000C');          
               r.adicionarcarros_eletricos(r.criael(marca, matricula, r.descobre_nif(r.descobreProp(email)), autonomia, velocidade, preco, cap, consumo, classificacao, x, y, pode_alugar, bateria));  
               r.adicionarcarros_eletricos(r.criael(marca, matricula, r.descobre_nif(r.descobreProp(email)), autonomia, velocidade, preco, cap, consumo, classificacao, x, y, pode_alugar, bateria));
               r.adicionarcarros_prop(r.criael(marca, matricula, r.descobre_nif(r.descobreProp(email)), autonomia, velocidade, preco, cap, consumo, classificacao, x, y, pode_alugar, bateria),r.descobreProp(email));
               System.out.println("O seu carro elétrico foi inserido com sucesso!\n");
               voltarMenu_prop(email);
    }
  
    public void alugarcarro_hibrido(String email){
        Scanner scanIn=new Scanner(System.in);
        Scanner scc=new Scanner(System.in);
        Scanner sc=new Scanner(System.in);
        String marca, matricula;
        int autonomia;
        double velocidade,preco,consumo,x,y;
        int cap=0, classificacao=0;
        double bateria=0.0, deposito=0.0;
        boolean pode_alugar=true;
        System.out.println("Insira a marca do carro:");
                marca=scanIn.nextLine();
                System.out.println("----------------------");
            System.out.print('\u000C');
                System.out.println("Insira a matricula do carro:");
                matricula=scanIn.nextLine();
                System.out.println("----------------------");
            System.out.print('\u000C');
            System.out.println("Insira a autonomia atual :");
                autonomia=scc.nextInt();
                System.out.println("----------------------");
            System.out.print('\u000C');
                System.out.println("Insira a velocidade média do carro por km:");
                velocidade=sc.nextDouble();
                System.out.println("----------------------");
            System.out.print('\u000C');
                System.out.println("Insira o preco do carro por km:");
                preco=sc.nextDouble();
                System.out.println("----------------------");
            System.out.print('\u000C');
                System.out.println("Insira a quantidade de bateria que o carro consome por km:");
                consumo=sc.nextDouble();
                System.out.println("----------------------");
            System.out.print('\u000C');
            System.out.println("Insira a quantidade de gasolina que o carro consome por km:");
                consumo=sc.nextDouble();
                System.out.println("----------------------");
            System.out.print('\u000C');
                System.out.println("Indique a localização do carro em coordenadas (x,y):");
               System.out.println("Coordenada x:");
               x=sc.nextDouble();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Coordenada y:");
               y=sc.nextDouble();
               System.out.println("----------------------");
               System.out.print('\u000C');         
               r.adicionarcarros_hibridos(r.criah( marca, matricula, r.descobre_nif(r.descobreProp(email)), autonomia, velocidade, preco, cap, consumo,  classificacao, x, y, pode_alugar, bateria, deposito));  
               r.adicionarcarros_hibridos(r.criah( marca, matricula, r.descobre_nif(r.descobreProp(email)), autonomia, velocidade, preco, cap, consumo,  classificacao, x, y, pode_alugar, bateria, deposito));
               r.adicionarcarros_prop(r.criah( marca, matricula, r.descobre_nif(r.descobreProp(email)), autonomia, velocidade, preco, cap, consumo, classificacao, x, y, pode_alugar, bateria, deposito),r.descobreProp(email));
               System.out.println("O seu carro híbrido foi inserido com sucesso!\n"); 
               voltarMenu_prop(email);
    }
  
  public void realizaraluguer1(String email){
     Scanner scanIn=new Scanner(System.in);
     Scanner scc=new Scanner(System.in);
     Scanner sc=new Scanner(System.in); 
     String cliente; int scan;
     if(r.descobre_autonomia(r.closestCar(r.getCarross(),r.descobreCliente(email)))>r.distanciaDestino_carro(r.closestCar(r.getCarross(),r.descobreCliente(email)),r.descobreCliente(email))){
        double custo= r.custo_estimado(r.closestCar(r.getCarross(),r.descobreCliente(email)),r.descobreCliente(email));
        System.out.println("O carro tem autonomia para efetuar a viagem");
        System.out.println("O custo estimado da viagem é de " + String.format("%.2f",custo) + " euros");
        System.out.println("Pretende continuar? [S/n]");
        cliente=scanIn.nextLine();
        System.out.println("----------------------");
        System.out.print('\u000C');
        if(cliente.equalsIgnoreCase("s")){
        r.removecarros_prop(r.closestCar(r.getCarross(),r.descobreCliente(email)),r.encontrar_Prop(r.closestCar(r.getCarross(),r.descobreCliente(email))));
        double temp_viagem=0;
        r.alterarcoordenadas_carro(r.closestCar(r.getCarross(),r.descobreCliente(email)), r.descobre_cliente_destinox(r.descobreCliente(email)), r.descobre_cliente_destinoy(r.descobreCliente(email)));
        r.adicionarAluguer_finall_veiculo(r.novoal(r.descobreCliente(email),r.encontrar_Prop(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.closestCar(r.getCarross(),r.descobreCliente(email)),r.descobre_x(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_y(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_cliente_destinox(r.descobreCliente(email)),r.descobre_cliente_destinoy(r.descobreCliente(email)),temp_viagem),r.closestCar(r.getCarross(),r.descobreCliente(email)));
        r.adicionarAlugueres_final(r.novoal(r.descobreCliente(email),r.encontrar_Prop(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.closestCar(r.getCarross(),r.descobreCliente(email)),r.descobre_x(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_y(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_cliente_destinox(r.descobreCliente(email)),r.descobre_cliente_destinoy(r.descobreCliente(email)),temp_viagem));
        r.adicionarAluguer_final_pessoa(r.novoal(r.descobreCliente(email),r.encontrar_Prop(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.closestCar(r.getCarross(),r.descobreCliente(email)),r.descobre_x(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_y(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_cliente_destinox(r.descobreCliente(email)),r.descobre_cliente_destinoy(r.descobreCliente(email)),temp_viagem),r.descobreCliente(email));
        r.adicionarAluguer_final_pessoa(r.novoal(r.descobreCliente(email),r.encontrar_Prop(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.closestCar(r.getCarross(),r.descobreCliente(email)),r.descobre_x(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_y(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_cliente_destinox(r.descobreCliente(email)),r.descobre_cliente_destinoy(r.descobreCliente(email)),temp_viagem),r.encontrar_Prop(r.closestCar(r.getCarross(),r.descobreCliente(email))));
        r.adicionarcarros_prop (r.closestCar(r.getCarross(),r.descobreCliente(email)),r.encontrar_Prop(r.closestCar(r.getCarross(),r.descobreCliente(email))));
        System.out.println("O aluguer foi realizado com sucesso!!!\n");
        System.out.println("Por favor, avalie o carro com uma nota de 0 a 100.");
        scan=scc.nextInt();
        //
        r.addclassif_carro(r.closestCar(r.getCarross(),r.descobreCliente(email)),r.novocl(r.descobre_matricula(r.closestCar(r.getCarross(),r.descobreCliente(email))), scan));
        r.s_classif(r.closestCar(r.getCarross(),r.descobreCliente(email)));
        //
        System.out.println("Por favor, avalie o proprietário com uma nota de 0 a 100.");
        scan=scc.nextInt();
        r.adicionarClassif_pessoa(r.novocl(r.descobre_nif(r.encontrar_Prop(r.closestCar(r.getCarross(),r.descobreCliente(email)))), scan),r.encontrar_Prop(r.closestCar(r.getCarross(),r.descobreCliente(email))));
        r.s_aval(r.encontrar_Prop(r.closestCar(r.getCarross(),r.descobreCliente(email))));
        System.out.println("Obrigado por ter realizado o seu aluguer na UMCarroJá!. Volte sempre!!!\n");
        voltarMenu_cliente(email);
        }
        else ;
           }
            
        else if(r.descobre_autonomia(r.closestCar(r.getCarross(),r.descobreCliente(email)))<=r.distanciaDestino_carro(r.closestCar(r.getCarross(),r.descobreCliente(email)),r.descobreCliente(email))) System.out.println("O carro pretendido não "
        + "tem autonomia para efetuar a viagem\n"); 
       voltarMenu_cliente(email);
  }
     
  
  
  
  public void realizaraluguer2(String email){
     Scanner scanIn=new Scanner(System.in);
     Scanner scc=new Scanner(System.in);
     Scanner sc=new Scanner(System.in); 
     String cliente; int scan;
     if(r.descobre_autonomia(r.cheapestCar(r.getCarross()))>r.distanciaDestino_carro(r.cheapestCar(r.getCarross()),r.descobreCliente(email))){
        double custo= r.custo_estimado(r.cheapestCar(r.getCarross()),r.descobreCliente(email));
        System.out.println("O carro tem autonomia para efetuar a viagem");
        System.out.println("O custo estimado da viagem é de " + String.format("%.2f",custo) + " euros");
        System.out.println("Pretende continuar? [S/n]");
        cliente=scanIn.nextLine();
        System.out.println("----------------------");
        System.out.print('\u000C');
        if(cliente.equalsIgnoreCase("s")){
        r.removecarros_prop(r.cheapestCar(r.getCarross()),r.encontrar_Prop(r.cheapestCar(r.getCarross())));
        double temp_viagem=0;
        //Aluguer_final algss =new Aluguer_final(r.descobreCliente(email),r.encontrar_Prop(r.cheapestCar(r.getCarross())),r.cheapestCar(r.getCarross()),r.descobre_x(r.cheapestCar(r.getCarross())),r.descobre_y(r.cheapestCar(r.getCarross())),r.descobre_cliente_destinox(r.descobreCliente(email)),r.descobre_cliente_destinoy(r.descobreCliente(email)),temp_viagem);
        r.alterarcoordenadas_carro(r.cheapestCar(r.getCarross()), r.descobre_cliente_destinox(r.descobreCliente(email)), r.descobre_cliente_destinoy(r.descobreCliente(email)));
        r.adicionarAluguer_finall_veiculo(r.novoal(r.descobreCliente(email),r.encontrar_Prop(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.closestCar(r.getCarross(),r.descobreCliente(email)),r.descobre_x(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_y(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_cliente_destinox(r.descobreCliente(email)),r.descobre_cliente_destinoy(r.descobreCliente(email)),temp_viagem),r.cheapestCar(r.getCarross()));
        r.adicionarAlugueres_final(r.novoal(r.descobreCliente(email),r.encontrar_Prop(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.closestCar(r.getCarross(),r.descobreCliente(email)),r.descobre_x(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_y(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_cliente_destinox(r.descobreCliente(email)),r.descobre_cliente_destinoy(r.descobreCliente(email)),temp_viagem));
        r.adicionarAluguer_final_pessoa(r.novoal(r.descobreCliente(email),r.encontrar_Prop(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.closestCar(r.getCarross(),r.descobreCliente(email)),r.descobre_x(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_y(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_cliente_destinox(r.descobreCliente(email)),r.descobre_cliente_destinoy(r.descobreCliente(email)),temp_viagem),r.descobreCliente(email));
        r.adicionarAluguer_final_pessoa(r.novoal(r.descobreCliente(email),r.encontrar_Prop(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.closestCar(r.getCarross(),r.descobreCliente(email)),r.descobre_x(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_y(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_cliente_destinox(r.descobreCliente(email)),r.descobre_cliente_destinoy(r.descobreCliente(email)),temp_viagem),r.encontrar_Prop(r.cheapestCar(r.getCarross())));
        r.adicionarcarros_prop (r.cheapestCar(r.getCarross()),r.encontrar_Prop(r.cheapestCar(r.getCarross())));
        System.out.println("O aluguer foi realizado com sucesso!!!\n");
        System.out.println("Por favor, avalie o carro com uma nota de 0 a 100.");
        scan=scc.nextInt();
        //
        r.addclassif_carro(r.cheapestCar(r.getCarross()),r.novocl(r.descobre_matricula(r.cheapestCar(r.getCarross())), scan));
        r.s_classif(r.cheapestCar(r.getCarross()));
        //
        System.out.println("Por favor, avalie o proprietário com uma nota de 0 a 100.");
        scan=scc.nextInt();
        r.adicionarClassif_pessoa(r.novocl(r.descobre_nif(r.encontrar_Prop(r.cheapestCar(r.getCarross()))), scan),r.encontrar_Prop(r.cheapestCar(r.getCarross())));
        r.s_aval(r.encontrar_Prop(r.cheapestCar(r.getCarross())));
        System.out.println("Obrigado por ter realizado o seu aluguer na UMCarroJá!. Volte sempre!!!\n");
        voltarMenu_cliente(email);
        }
        else ;
           }
            
        else if(r.descobre_autonomia(r.cheapestCar(r.getCarross()))<=r.distanciaDestino_carro(r.cheapestCar(r.getCarross()),r.descobreCliente(email))) System.out.println("O carro pretendido não "
        + "tem autonomia para efetuar a viagem\n"); 
       voltarMenu_cliente(email);
  }
     
  
  
  
  //rever
  public void realizaraluguer3(String email){
     Scanner scanIn=new Scanner(System.in);
     Scanner scc=new Scanner(System.in);
     Scanner sc=new Scanner(System.in); 
     String cliente; int scan;
     if(r.descobre_autonomia(r.walkTillThere(r.getCarross(),r.descobreCliente(email)))>r.distanciaDestino_carro(r.walkTillThere(r.getCarross(),r.descobreCliente(email)),r.descobreCliente(email))){
        double custo= r.custo_estimado(r.walkTillThere(r.getCarross(),r.descobreCliente(email)),r.descobreCliente(email));
        System.out.println("O carro tem autonomia para efetuar a viagem");
        System.out.println("O custo estimado da viagem é de " + String.format("%.2f",custo) + " euros");
        System.out.println("Pretende continuar? [S/n]");
        cliente=scanIn.nextLine();
        System.out.println("----------------------");
        System.out.print('\u000C');
        if(cliente.equalsIgnoreCase("s")){
        r.removecarros_prop(r.walkTillThere(r.getCarross(),r.descobreCliente(email)),r.encontrar_Prop(r.walkTillThere(r.getCarross(),r.descobreCliente(email))));
        double temp_viagem=0;
        //Aluguer_final algss =new Aluguer_final(r.descobreCliente(email),r.encontrar_Prop(trataWalking(email)),trataWalking(email),r.descobre_x(trataWalking(email)),r.descobre_y(trataWalking(email)),r.descobre_cliente_destinox(r.descobreCliente(email)),r.descobre_cliente_destinoy(r.descobreCliente(email)),temp_viagem);
        r.alterarcoordenadas_carro(r.walkTillThere(r.getCarross(),r.descobreCliente(email)), r.descobre_cliente_destinox(r.descobreCliente(email)), r.descobre_cliente_destinoy(r.descobreCliente(email)));
        r.adicionarAluguer_finall_veiculo(r.novoal(r.descobreCliente(email),r.encontrar_Prop(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.closestCar(r.getCarross(),r.descobreCliente(email)),r.descobre_x(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_y(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_cliente_destinox(r.descobreCliente(email)),r.descobre_cliente_destinoy(r.descobreCliente(email)),temp_viagem),r.walkTillThere(r.getCarross(),r.descobreCliente(email)));
        r.adicionarAlugueres_final(r.novoal(r.descobreCliente(email),r.encontrar_Prop(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.closestCar(r.getCarross(),r.descobreCliente(email)),r.descobre_x(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_y(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_cliente_destinox(r.descobreCliente(email)),r.descobre_cliente_destinoy(r.descobreCliente(email)),temp_viagem));
        r.adicionarAluguer_final_pessoa(r.novoal(r.descobreCliente(email),r.encontrar_Prop(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.closestCar(r.getCarross(),r.descobreCliente(email)),r.descobre_x(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_y(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_cliente_destinox(r.descobreCliente(email)),r.descobre_cliente_destinoy(r.descobreCliente(email)),temp_viagem),r.descobreCliente(email));
        r.adicionarAluguer_final_pessoa(r.novoal(r.descobreCliente(email),r.encontrar_Prop(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.closestCar(r.getCarross(),r.descobreCliente(email)),r.descobre_x(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_y(r.closestCar(r.getCarross(),r.descobreCliente(email))),r.descobre_cliente_destinox(r.descobreCliente(email)),r.descobre_cliente_destinoy(r.descobreCliente(email)),temp_viagem),r.encontrar_Prop(r.walkTillThere(r.getCarross(),r.descobreCliente(email))));
        r.adicionarcarros_prop (r.walkTillThere(r.getCarross(),r.descobreCliente(email)),r.encontrar_Prop(r.walkTillThere(r.getCarross(),r.descobreCliente(email))));
        System.out.println("O aluguer foi realizado com sucesso!!!\n");
        System.out.println("Por favor, avalie o carro com uma nota de 0 a 100.");
        scan=scc.nextInt();
        //
        r.addclassif_carro(r.walkTillThere(r.getCarross(),r.descobreCliente(email)),r.novocl(r.descobre_matricula(r.walkTillThere(r.getCarross(),r.descobreCliente(email))), scan));
        r.s_classif(r.walkTillThere(r.getCarross(),r.descobreCliente(email)));
        //
        System.out.println("Por favor, avalie o proprietário com uma nota de 0 a 100.");
        scan=scc.nextInt();
        r.adicionarClassif_pessoa(r.novocl(r.descobre_nif(r.encontrar_Prop(r.walkTillThere(r.getCarross(),r.descobreCliente(email)))), scan),r.encontrar_Prop(r.walkTillThere(r.getCarross(),r.descobreCliente(email))));
        r.s_aval(r.encontrar_Prop(r.walkTillThere(r.getCarross(),r.descobreCliente(email))));
        System.out.println("Obrigado por ter realizado o seu aluguer na UMCarroJá!. Volte sempre!!!\n");
        voltarMenu_cliente(email);
        }
        else ;
           }
            
        else  System.out.println("O carro pretendido não "
        + "tem autonomia para efetuar a viagem\n"); 
       voltarMenu_cliente(email);
  }
     
  
  
  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    
 
    
    
    
    
    
    
    
    
    
    
    
    

