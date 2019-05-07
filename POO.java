package poo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class POO {

    public static void main(String[] args) {
        
        Registos r= new Registos();
        
        int s=1;
        String utilizador;
        String cliente;
        String email;
        String nome;
        String pass;
        String morada;
        LocalDate data;
        ArrayList<Aluguer> historico;
        double x;
        double y;
        double walking;
        ArrayList<Carro> carros;
        int avaliacao;
        
        Scanner scanIn= new Scanner(System.in);
        
        System.out.println("BEM VINDO À UMCarroJá!");
        
        
        checkpoint_1:
        while(s==1){
        System.out.println("Já é utilizador? [S/n]");
        
        utilizador=scanIn.nextLine();
        if(utilizador.charAt(0) == 'S') {
        
        System.out.println ("Login :É cliente? [S/n]");
        cliente=scanIn.nextLine();
        if(cliente.charAt(0) == 'S'){
            System.out.println("Insira o seu email: ");
            email=scanIn.nextLine();
            System.out.println("Insira o seu nome de utilizador: ");
            nome=scanIn.nextLine();
            s=2;
        }
        else {
            System.out.println ("Login :É proprietário? [S/n]");
            cliente=scanIn.nextLine();
            if(cliente.charAt(0) == 'S'){
            System.out.println("Insira o seu email: ");
            email=scanIn.nextLine();
            System.out.println("Insira o seu nome de utilizador: ");
            nome=scanIn.nextLine();
            s=3;
            }   
            else continue checkpoint_1;
        } 
        }
        else {
            System.out.println("Por favor, faça primeiro o seu registo na nossa aplicação!!!");
            System.out.println ("Pretende registar-se como cliente ou como proprietário? [CLIENTE/proprietario]");
            cliente=scanIn.nextLine();
            if(cliente == "CLIENTE" || cliente=="Cliente" || cliente=="cliente"){
               System.out.println("Insira o seu email: "); 
               email=scanIn.nextLine();
               System.out.println("Crie um nome de utilizador: ");
               nome=scanIn.nextLine();
               System.out.println("Crie uma palavra passe: "); 
               pass=scanIn.nextLine();
               System.out.println("Insira a sua morada: "); 
               morada=scanIn.nextLine();
               System.out.println("Insira data de nascimento: [AAAA-MM-DD]"); 
               data=LocalDate.parse(scanIn.nextLine());
               historico=new ArrayList<>();
               System.out.println("Indique a sua localização em coordenadas (x,y):");
               System.out.println("Coordenada x:");
               x=scanIn.nextDouble();
               System.out.println("Coordenada y:");
               y=scanIn.nextDouble();
               System.out.println("Indique a distância que está disposto a percorrer a pé (em Km):");
               walking=scanIn.nextDouble();
               Cliente c =new Cliente(email,nome,pass,morada,data,historico,x,y,walking);
               r.adicionarClientes (r.getClientes(), c);
               System.out.println("O seu registo foi concluído com sucesso.\n"
                       + "Faça login como cliente para conseguir ter acesso à aplicação.");
               continue checkpoint_1;
                
            }
            else {
                System.out.println("Insira o seu email: "); 
               email=scanIn.nextLine();
               System.out.println("Crie um nome de utilizador: ");
               nome=scanIn.nextLine();
               System.out.println("Crie uma palavra passe: "); 
               pass=scanIn.nextLine();
               System.out.println("Insira a sua morada: "); 
               morada=scanIn.nextLine();
               System.out.println("Insira data de nascimento: [AAAA-MM-DD]"); 
               data=LocalDate.parse(scanIn.nextLine());
               historico=new ArrayList<>();
               carros=new ArrayList<>();
               avaliacao=0;
               Proprietario p =new Proprietario (email,nome,pass,morada,data,historico,carros,avaliacao);
               r.adicionarProprietarios (r.getProprietarios(),p);
               System.out.println("O seu registo foi concluído com sucesso.\n"
                       + "Faça login como proprietário para conseguir ter acesso à aplicação.");
               continue checkpoint_1;
            }
            
        }
         
            
    }
        checkpoint_2:
        while(s==1){
            System.out.println("Cliente");  
        }
        
        
        
        checkpoint_3:
        while(s==2){
            System.out.println("Proprietario");
        }
    }
}
