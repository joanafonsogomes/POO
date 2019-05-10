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
        
        
        int s=1; int scan; Carro car=null;
        Aluguer_final algss=null;
        Cliente clie=new Cliente();
        Proprietario pros=new Proprietario();
        String utilizador;
        String cliente;
        String email;
        String nome;
        String pass;
        String nif;
        String morada;
        LocalDate data=LocalDate.now();
        ArrayList<Aluguer_final> historico=new ArrayList<>();
        double x;
        double y;
        double destinox;
        double destinoy;
        double walking=0.0;
        int classificacao=0;
        boolean pode_alugar=false;
        double deposito=0.0;
        double bateria=0.0;
        ArrayList<Carro> carros=new ArrayList<>();
        int avaliacao=0;
        
        
           InputStream inputStream = POO.class.getResourceAsStream("logsPOO_carregamentoInicial.bak");       
        try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
        for(String ss; (ss = br.readLine()) != null; ) {
        for(String l: ss.split(":")){
            
        if(l.compareTo("NovoProp")==0) {
        String[] word =ss.split(",|:");
        Proprietario pro =new Proprietario (word[3],word[1],word[2],word[2],word[4],data,historico,carros,avaliacao);
        r.adicionarProprietarios(pro);     
        }
        
        else if(l.compareTo("NovoCliente")==0){
        String[] word =ss.split(",|:");
        Cliente cc =new Cliente(word[3],word[1],word[2],word[2],word[4],data,historico,Double.parseDouble(word[5]),Double.parseDouble(word[6]),walking);
        r.adicionarClientes (cc);    
        }  
                
        else if(l.compareTo("NovoCarro")==0){
        String[] word =ss.split(",|:");
        if(word[1].compareTo("Gasolina")==0){
        Gasolina gas =new Gasolina(historico,word[2],word[3],word[4],Integer.parseInt(word[8]),Double.parseDouble(word[5]),Double.parseDouble(word[6]),Double.parseDouble(word[7]),classificacao,Double.parseDouble(word[9]),Double.parseDouble(word[10]),pode_alugar,deposito);
        r.adicionarcarros_gasolina(gas);  
        r.adicionarcarros_gasolina1(gas); 
        Proprietario pll= r.encontrar_Prop(gas.getNif());
        pll.adicionarcarros_gasolina( gas);
        }
        
        if(word[1].compareTo("Electrico")==0){
        Eletrico el =new Eletrico(historico,word[2],word[3],word[4],Integer.parseInt(word[8]),Double.parseDouble(word[5]),Double.parseDouble(word[6]),Double.parseDouble(word[7]),classificacao,Double.parseDouble(word[9]),Double.parseDouble(word[10]),pode_alugar,bateria);
        r.adicionarcarros_eletricos( el);  
        r.adicionarcarros_eletricos1( el); 
        Proprietario pll= r.encontrar_Prop(el.getNif());
        pll.adicionarcarros_eletricos( el);
        
        }
        if(word[1].compareTo("Hibrido")==0){
        Hibrido hi =new Hibrido(historico,word[2],word[3],word[4],Integer.parseInt(word[8]),Double.parseDouble(word[5]),Double.parseDouble(word[6]),Double.parseDouble(word[7]),classificacao,Double.parseDouble(word[9]),Double.parseDouble(word[10]),pode_alugar,bateria,deposito);
        r.adicionarcarros_hibridos( hi);  
        r.adicionarcarros_hibridos1( hi); 
        Proprietario pll= r.encontrar_Prop(hi.getNif());
        pll.adicionarcarros_hibridos(hi);
        }
          
        }    
        
        else if(l.compareTo("Aluguer")==0){
        String[] word =ss.split(",|:");
        Aluguer algg =new Aluguer(word[1],Double.parseDouble(word[2]),Double.parseDouble(word[3]),word[4],word[5]);
        Cliente cll= r.encontrar_Clie(algg.getCliente_nif());
        
        if(algg.getPreferencia().compareTo("MaisBarato")==0){
        car=cll.closestCar(r.getCarross());
        pros= r.encontrar_Prop(car.getNif());
        if(car.getAutonomia()>cll.distanciaDestino_carro(car)){
        double temp_viagem=0;
        algss =new Aluguer_final(cll,pros,car,car.getCoordenadasx(),car.getCoordenadasy(),algg.getFinal_x(),algg.getFinal_y(),temp_viagem);
        r.adicionarAlugueres_final(algss);
        cll.adicionarAluguer_final (algss);
        car.adicionarAluguer_finall(algss);
        //pros.adicionarAluguer_final(algss);
        }
        }
        
        else{
        car=cll.closestCar(r.getCarross());
        pros= r.encontrar_Prop(car.getNif());
        if(car.getAutonomia()>cll.distanciaDestino_carro(car)){
        double temp_viagem=0;
        algss =new Aluguer_final(cll,pros,car,car.getCoordenadasx(),car.getCoordenadasy(),algg.getFinal_x(),algg.getFinal_y(),temp_viagem);
        r.adicionarAlugueres_final(algss);
        car.adicionarAluguer_finall(algss);
        cll.adicionarAluguer_final (algss);
        pros.adicionarAluguer_final(algss);
        } 
        }
        
        
        }
                
        else if(l.compareTo("Classificar")==0){
        String[] word =ss.split(",|:");
        Classificar cla =new Classificar(word[1],Integer.parseInt(word[2]));
        r.adicionarClassificacoes ( cla);  
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
               r.adicionarClientes (c);
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
               r.adicionarProprietarios (p);
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
            System.out.println("2-Alterar a minha localização"); 
            System.out.println("3-Solicitar um aluguer"); 
            System.out.println("4-Sair"); 
            scan=scc.nextInt();
            System.out.println("----------------------");
            System.out.print('\u000C');
           if(scan==1) s=4;
           else if(scan==2) s=7;
           else if(scan==3) s=6;
           else if(scan==4) {
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
            System.out.println("Para voltar ao menu, digite 0.");
            System.out.println("Para sair, digite 1.");
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
           
            checkpoint_6:
            while(s==6){
            System.out.println("Indique as coordenadas do seu destino (x,y):");
               System.out.println("Coordenada x:");
               destinox=sc.nextDouble();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Coordenada y:");
               destinoy=sc.nextDouble();
               System.out.println("----------------------");
               System.out.print('\u000C');  
               clie.setDestinox(destinox);
               clie.setDestinoy(destinoy);
               System.out.println("      PRETENDE:");
               System.out.println("**********************");
               System.out.println("**********************\n");
               System.out.println("1-Solicitar o aluguer de um carro mais próximo"
                       + " das suas coordenadas");
               System.out.println("2-Solicitar o aluguer do carro mais barato");
               System.out.println("3-Solicitar o aluguer do carro mais barato, dentro"
                       + " de uma distância que está disposto a percorrer a pé");
               System.out.println("4-Solicitar o aluguer de um carro especifico");
               System.out.println("5-Solicitar o aluguer de um carro com uma determinada autonomia");
               scan=scc.nextInt();
               System.out.println("----------------------");
               System.out.print('\u000C'); 
               if(scan==1){
                   car=clie.closestCar(r.getCarross());
               }
               else if(scan==2){
                   car=clie.cheapestCar(r.getCarross());
               }
               else if(scan==3){
               System.out.println("Indique a distância que está disposto a percorrer a pé (em Km):");
               walking=sc.nextDouble();
               System.out.println("----------------------");
               System.out.print('\u000C');
               clie.setWalking(walking);
               car=clie.walkTillThere(r.getCarross());
               }
               else if(scan==4){
                   System.out.println("Por fazer!!");
               }
               else if(scan==5){
                   System.out.println("Por fazer!!");
               }
               
               if(car.getAutonomia()>clie.distanciaDestino_carro(car)){
                   double custo= clie.custo_estimado(car);
                   System.out.println("O carro tem autonomia para efetuar a viagem");
                   System.out.println("O custo estimado da viagem é de " + String.format("%.2f",custo) + " euros");
                   System.out.println("Pretende continuar? [S/n]");
                   cliente=scanIn.nextLine();
                   System.out.println("----------------------");
                   System.out.print('\u000C');
                   if(cliente.equalsIgnoreCase("s")){
                       Proprietario propp= r.encontrar_Prop(car.getNif());
                       System.out.println(propp.toString());
                   }
                   else ;
               }
               else if(car.getAutonomia()<=clie.distanciaDestino_carro(car)) System.out.println("O carro pretendido não "
                       + "tem autonomia para efetuar a viagem");
             //final do aluguer 
            System.out.println("Para voltar ao menu, digite 0.");
            System.out.println("Para sair, digite 1.");
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
          
            checkpoint_7:
        while(s==7){
            System.out.println("Indique as suas coordenadas atuais (x,y):");
               System.out.println("Coordenada x:");
               x=sc.nextDouble();
               System.out.println("----------------------");
               System.out.print('\u000C');
               System.out.println("Coordenada y:");
               y=sc.nextDouble();
               System.out.println("----------------------");
               System.out.print('\u000C');  
               clie.setX(x);
               clie.setY(y);
               System.out.println("A sua localização foi alterada com sucesso!\n");
               
               System.out.println("Para voltar ao menu, digite 0.");
               System.out.println("Para sair, digite 1.");
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
            System.out.println("        MENU:");
            System.out.println("**********************");
            System.out.println("**********************\n");
            System.out.println("Escolha a funcionalidade a que pretende aceder:"); 
            System.out.println("1-Visualizar o meu perfil");
            System.out.println("2-Adicionar viatura");
            System.out.println("3-Sair"); 
            scan=scc.nextInt();
            System.out.println("----------------------");
            System.out.print('\u000C');
           if(scan==1) s=5;
           else if(scan==3) {
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
            System.out.println("Para voltar ao menu, digite 0.");
            System.out.println("Para sair, digite 1.");
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
