package poo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class POO {

    public static void main(String[] args) {
        
        Registos r= new Registos();
        
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
        ArrayList<Carro> carros;
        int avaliacao;
        
        Scanner scanIn= new Scanner(System.in);
        
        System.out.println("BEM VINDO À UMCarroJá!");
        
        System.out.println("Já é utilizador? [S/n]");
        
        utilizador=scanIn.nextLine();
        if(utilizador.charAt(0) == 'S') {
        System.out.println ("É cliente? [S/n]");
        cliente=scanIn.nextLine();
        if(cliente.charAt(0) == 'S'){
            System.out.println("Insira o seu email: ");
            email=scanIn.nextLine();
            System.out.println("Insira o seu nome de utilizador: ");
            nome=scanIn.nextLine();
        }
        else {
            System.out.println("Insira o seu email: ");
            email=scanIn.nextLine();
            System.out.println("Insira o seu nome de utilizador: ");
            nome=scanIn.nextLine();
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
               Cliente c =new Cliente(email,nome,pass,morada,data,historico,x,y);
               r.adicionarClientes (r.getClientes(), c);
               System.out.println("O seu registo foi concluído com sucesso.\n"
                       + "Faça login como cliente para conseguir ter acesso à aplicação.");
               //System.out.println(c.toString());
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
               System.out.println("Insira data de nascimento: [AAA-MM-DD]"); 
               data=LocalDate.parse(scanIn.nextLine());
               historico=new ArrayList<>();
               carros=new ArrayList<>();
               avaliacao=0;
               Proprietario p =new Proprietario (email,nome,pass,morada,data,historico,carros,avaliacao);
               r.adicionarProprietarios (r.getProprietarios(),p);
               System.out.println("O seu registo foi concluído com sucesso.\n"
                       + "Faça login como proprietário para conseguir ter acesso à aplicação.");
               //System.out.println(p.toString());
            }
            
        }
        
    }
    
}
