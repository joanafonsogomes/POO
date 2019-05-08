 package poo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;



public class POO {

    public static void main(String[] args) throws IOException {
        
     
        Registos r= new Registos();
        
        
        int s=1; int scan;
        Cliente clie=new Cliente();
        Proprietario pros=new Proprietario();
        String utilizador;
        String cliente;
        String email;
        String nome;
        String pass=new String();
        String nif;
        String morada;
        LocalDate data=LocalDate.now();
        ArrayList<Aluguer> historico=new ArrayList<>();
        double x;
        double y;
        double walking=0.0;
        ArrayList<Carro> carros=new ArrayList<>();
        int avaliacao=0;
        
        
           InputStream inputStream = POO.class.getResourceAsStream("logsPOO_carregamentoInicial.bak");       
        try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
        for(String ss; (ss = br.readLine()) != null; ) {
        for(String l: ss.split(":")){
        if(l.compareTo("NovoProp")==0) {
        String[] word =ss.split(",|:");
        Proprietario pro =new Proprietario (word[3],word[1],pass,word[2],word[4],data,historico,carros,avaliacao);
        r.adicionarProprietarios(r.getProprietarios(),pro);     
        }
        
        else if(l.compareTo("NovoCliente")==0){
        String[] word =ss.split(",|:");
        Cliente cc =new Cliente(word[3],word[1],pass,word[2],word[4],data,historico,Double.parseDouble(word[5]),Double.parseDouble(word[6]),walking);
        r.adicionarClientes (r.getClientes(), cc);    
        } 
                
        else if(l.compareTo("NovoCarro")==0);
        else if(l.compareTo("Aluguer")==0) ;
        else if(l.compareTo("Classificar")==0){
        String[] word =ss.split(",|:");
        Classificar cla =new Classificar(word[1],Integer.parseInt(word[2]));
        r.adicionarClassificacoes (r.getClassificacoes(), cla);  
        }
         }
    }
    // line is not visible here.
}
        
        
        
        
        Scanner scanIn= new Scanner(System.in);
        Scanner sc=new Scanner(System.in);
        Scanner scc=new Scanner(System.in);
        
        checkpoint_1:
        while(s==1){
        System.out.println("\n**********************");
        System.out.println("BEM VINDO À UMCarroJá!");
        System.out.println("**********************\n");
        
        
        System.out.println("\nJá é utilizador? [S/n]");
        
        utilizador =scanIn.nextLine();
        System.out.println("----------------------");
        System.out.print('\u000C');
        if(utilizador.equalsIgnoreCase("s")) {
        
        System.out.println ("Login: É cliente? [S/n]");
        cliente=scanIn.nextLine();
        System.out.println("----------------------");
        System.out.print('\u000C');
        if(cliente.equalsIgnoreCase("s")){
            System.out.println("Insira o seu email: ");
            email=scanIn.nextLine();
            System.out.println("----------------------");
            System.out.print('\u000C');
            System.out.println("Insira a sua password: ");
            pass=scanIn.nextLine();
            System.out.println("----------------------");
            System.out.print('\u000C');
            if(r.verificaEmail_Cliente(email)==true && r.verificaPassword_Cliente(pass)==true ) {
            clie=r.descobreCliente(email);
            s=2;
            }
            else {
                System.out.println("O seu email ou a sua palavra passe estão errados. Por favor tente de novo.");
                continue checkpoint_1;
                     
            }
        }
        else {
            System.out.println("Insira o seu email: ");
            email=scanIn.nextLine();
            System.out.println("----------------------");
            System.out.print('\u000C');
            System.out.println("Insira a sua password: ");
            pass=scanIn.nextLine();
            System.out.println("----------------------");
            System.out.print('\u000C');
            if(r.verificaEmail_Prop(email)==true && r.verificaPassword_Prop(pass)==true ) {
            pros=r.descobreProp(email);    
            s=3;
            }
            else {
                System.out.println("O seu email ou a sua palavra passe estão errados. Por favor tente de novo.");
                continue checkpoint_1;
                     
            }
        } 
        }
        else {
            System.out.println("Por favor, faça primeiro o seu registo na nossa aplicação!!!");
            System.out.println ("Pretende registar-se como cliente ou como proprietário? [CLIENTE/proprietario]");
            cliente=scanIn.nextLine();
            System.out.println("----------------------");
            System.out.print('\u000C');
            if(cliente.equalsIgnoreCase("cliente")){
               System.out.println("Insira o seu email: "); 
               email=scanIn.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Crie um nome de utilizador: ");
               nome=scanIn.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Crie uma palavra passe: "); 
               pass=scanIn.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Insira o seu NIF: "); 
               nif=scanIn.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Insira a sua morada: "); 
               morada=scanIn.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Insira data de nascimento: [AAAA-MM-DD]"); 
               data=LocalDate.parse(scanIn.nextLine());
               System.out.println("----------------------");
               System.out.print('\u000C');
               historico=new ArrayList<>();
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
               Cliente c =new Cliente(email,nome,pass,nif,morada,data,historico,x,y,walking);
               r.adicionarClientes (r.getClientes(), c);
               System.out.println("O seu registo foi concluído com sucesso.\n"
                       + "Faça login como cliente para conseguir ter acesso à aplicação.");
               continue checkpoint_1;
                
            }
            else {
                System.out.println("Insira o seu email: "); 
               email=scanIn.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Crie um nome de utilizador: ");
               nome=scanIn.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Crie uma palavra passe: "); 
               pass=scanIn.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Insira o seu NIF: "); 
               nif=scanIn.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Insira a sua morada: "); 
               morada=scanIn.nextLine();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Insira data de nascimento: [AAAA-MM-DD]"); 
               data=LocalDate.parse(scanIn.nextLine());
               System.out.println("----------------------");
               System.out.print('\u000C');
               historico=new ArrayList<>();
               carros=new ArrayList<>();
               avaliacao=0;
               Proprietario p =new Proprietario (email,nome,pass,nif,morada,data,historico,carros,avaliacao);
               r.adicionarProprietarios (r.getProprietarios(),p);
               System.out.println("O seu registo foi concluído com sucesso.\n"
                       + "Faça login como proprietário para conseguir ter acesso à aplicação.");
               continue checkpoint_1;
               
            }
            
        }
         
            
    
        checkpoint_2:
        while(s==2){
            System.out.println("        MENU:");
            System.out.println("**********************");
            System.out.println("**********************\n");
            System.out.println("Escolha a funcionalidade a que pretende aceder:"); 
            System.out.println("1-Visualizar o meu perfil"); 
            System.out.println("2-Solicitar um aluguer"); 
            System.out.println("3-Sair"); 
            scan=scc.nextInt();
            System.out.println("----------------------");
            System.out.print('\u000C');
           if(scan==1) s=4;
           else if(scan==3) {
               s=1;
               continue checkpoint_1;
           }
           
           checkpoint_4:
        while(s==4){
            System.out.println("\n**********************");
            System.out.println("**********************\n");
            System.out.println(clie.toString()); 
            System.out.println("**********************");
            System.out.println("**********************\n");
            System.out.println("Para voltar ao menu, digite 0.\n");
            System.out.println("Para sair, digite 1.\n");
            scan=scc.nextInt();
            System.out.println("----------------------");
            System.out.print('\u000C');
            if(scan==0){
            s=2;
            continue checkpoint_2;
            }
            else if(scan==1) {
               s=1;
               continue checkpoint_1;
           }
        }
        }
        
        
        checkpoint_3:
        while(s==3){
            System.out.println("Escolha a funcionalidade a que pretende aceder"); 
            System.out.println("1-Visualizar o meu perfil");
            System.out.println("2-Sair"); 
            scan=scc.nextInt();
            System.out.println("----------------------");
            System.out.print('\u000C');
           if(scan==1) s=5;
           else if(scan==2) {
               s=1;
               continue checkpoint_1;
           }
           
           
           checkpoint_5:
        while(s==5){
            System.out.println("\n**********************");
            System.out.println("**********************\n");
            System.out.println(pros.toString());
            System.out.println("**********************");
            System.out.println("**********************\n");
            System.out.println("Para voltar ao menu, digite 0.\n");
            System.out.println("Para sair, digite 1.\n");
            scan=scc.nextInt();
            System.out.println("----------------------");
            System.out.print('\u000C');
            if(scan==0){
            s=3;
            continue checkpoint_3;
            }
            else if(scan==1) {
               s=1;
               continue checkpoint_1;
           }
        }
        }
        
        } 
        
    }
}
