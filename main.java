import java.io.*;
import java.util.*;
import java.net.*;
import java.text.*;

public class main
{
    public static void main(String[] args) throws IOException
    {
        Empresa TransTrans=new Empresa();
        String option="";
        String x="";
        Scanner input = new Scanner(System.in);
        
        URL url = main.class.getProtectionDomain().getCodeSource().getLocation();       
        String path=url.toString();         
        path=path.replaceFirst("file:/","");        
        path=path.concat("Dados.txt");       
        //System.out.println("Caminho: "+path);  
        
        if(loadFile(path)!=null){  
            TransTrans=loadFile(path);
            System.out.println("\nFicheiro lido com sucesso de: \n\""+path+"\"\n\n");
        }
        else{
            System.out.println("Ficheiro nÃ£o encontrado ou ilegÃ­vel!\nSerÃ£o usados exemplos\n\n");
            TransTrans=new Empresa();
        }   
        
        
        while(option!="S"||option!="s")
        {   
            System.out.println("\nEscolha uma das seguintes opcoes:\n");
            System.out.println("0 - Colecao de servicos, clientes, veiculos");
            System.out.println("1 - Adicionar Veiculo");               
            System.out.println("2 - Contratacao de Servico");                    
            System.out.println("3 - Valor faturado num dia");                   
            System.out.println("4 - Servico que mais combustivel consumiu");     
            System.out.println("5 - Lista de clientes");  
            System.out.println("6 - Mapeamento código cliente/veiculos");                   
            System.out.println("7 - Veiculo mais rentavel");            
            System.out.println("8 - Veiculo mais usado");    
            System.out.println("9 - Mercadoria mais transportada"); 
            System.out.println("10 - Cliente mais rentável");                
            System.out.println("11 - Imprimir fatura");
            System.out.println("S - Sair");
            System.out.print("\nOpcao: ");
            
            option=input.next();
            System.out.println("");
            
            switch(option)
            {
                case "1":addVeiculo(input,TransTrans);break;
                //case "2":criarServiço(input,TransTrans);break;
                case "3":valorPorDia(input,TransTrans);break;
                case "4":maisCombustivel(TransTrans);break;
               /* case "2":addUAV(input,Amazon);break;
                case "3":criaServiÃ§o(input,Amazon);break;
                case "4":getLocalizacao(input,Amazon);break;
                case "5":maisViagens(Amazon);break;
                case "6":getParados(Amazon);break;
                case "7":maisRentavel(Amazon);break;
                case "8":maisTransportado(Amazon);break;
                case "9":valorPorDia(input,Amazon);break;
                case "A":getLog(Amazon);break;
                case "a":getLog(Amazon);break;
                case "B":getMeteo(Amazon);break;
                case "b":getMeteo(Amazon);break;
                case "s":saveFile(path,Amazon);break;
                case "S":saveFile(path,Amazon);break;*/
            }
            
            System.out.print("\nPrima qualquer tecla para voltar ao menu ");
            x=input.next();
            System.out.print("\n\n\n");
        }
        
    }
    
    public static Empresa loadFile(String path) throws IOException{
        try{
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(file);
            Empresa TransTrans=(Empresa)in.readObject();
            in.close();
            return TransTrans;
        }
        catch(ClassNotFoundException e)
        {return null;}
        catch(FileNotFoundException e)
        {return null;}
        catch(IOException e)
        {return null;}
    }
    
    public static void saveFile(String path,Empresa TransTrans) throws IOException{
        File f1 = new File(path);
        if(!f1.exists())
        {
            try
            {f1.createNewFile();}
            catch(IOException e)
            {
                System.out.println("Falha na gravaÃ§Ã£o de ficheiro");
                System.exit(0);   
            }
        }
        else{
            f1.delete();
            f1.createNewFile();
        } 
        
        try{
            FileOutputStream file = new FileOutputStream(path,true);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(TransTrans);
            out.close();
            System.out.println("Ficheiro guardado com sucesso em: \n\""+path+"\"\n");
            System.exit(0);
        }
        catch(FileNotFoundException e)
        {System.out.println("Falha na gravaÃ§Ã£o do ficheiro!");System.exit(0);}
        catch(IOException e)
        {System.out.println("Falha na gravaÃ§Ã£o de ficheiro!"); System.exit(0);}  
    }
    
    
    //RENOVAR
    /*public String colecao(Scanner input,Serviço s,FichaDeCliente f,Veiculo v)
    {
        ArrayList<Serviço> a = new ArrayList<Serviço>();
        ArrayList<FichaDeCliente> aa = new ArrayList<FichaDeCliente>();
        ArrayList<Veiculo> aaa = new ArrayList<Veiculo>();
        
        for(Serviço s:this.a){
            System.out.println(s);}
            for(FichaDeCliente f:this.aa){
                System.out.println(f);}
                for(Veiculo v:this.aaa){
                    System.out.println(v);}
    
    }*/
    
           
    public static void addVeiculo(Scanner input,Empresa e)
    {
        try{
            System.out.print("Introduza o tipo de veiculo(Solidos,Cisternas,Frageis): ");
            String c=input.next();
            if((c.equals("Solidos"))||(c.equals("Cisternas"))||(c.equals("Frageis")))
                System.out.println("Introduza o codigo do veiculo:");
                    int b = input.nextInt();
                    if(b==0)
                        System.out.println("Não pode ser 0!");
                    else
                    {
                        System.out.println("Introduza a matricula: ");
                        String mm=input.next();
                        System.out.println("Introduza o consumo medio: ");
                        double cc=input.nextDouble();
                        System.out.println("Introduza a capacidade de carga:");
                        double ccc=input.nextDouble();
                        int tipo=0;
                        if(c.equals("Solidos"))tipo=1;
                        if(c.equals("Cisternas"))tipo=2;
                        if(c.equals("Frageis"))tipo=3;
                        if(e.addVeiculo(b,mm,cc,ccc,tipo))
                            System.out.println("Foi adicionado com sucesso!");
                        else
                            System.out.println("Veiculo existente!");
                        
                    }
                }    
            catch(InputMismatchException x)
            {System.out.println("Erro de Input!!");}           
                           
            }             
    

                
            /**
     * Obtem o valor faturado num dado dia
     * @param input Scanner de leitura de dados
     * @param x Objecto Empresa
     */
    public static void valorPorDia(Scanner input, Empresa x)
    {
        try
        {
            System.out.println("Introduza data(dd/mm/aaaa): ");
            int dia=input.nextInt();
            int mes=input.nextInt();
            int ano=input.nextInt();
            
            GregorianCalendar aux= new GregorianCalendar(ano,mes-1,dia);
            double valor=x.valorDia(aux);
            System.out.printf("O valor facturado foi: "+valor);
        }
        catch(InputMismatchException e)
        {
            System.out.println("Erro de Input!");
        }
    }
        
    public static void criarServiço(Scanner input,Empresa e) throws IOException
    {
        try
        {                      
            System.out.println("Insira o codigo do serviço :");
            int cod=input.nextInt();
            System.out.println("Insira o seu codigo-Cliente: ");
            int codC=input.nextInt();
            System.out.println("Qual o destino: ");
            String dest=input.next();
            System.out.println("Qual a distancia: ");
            double dist=input.nextDouble();
            System.out.println("Qual o código do veiculo ");
            int codVeic = input.nextInt();
            System.out.println("Material da carga a transportar(1-Solido,2-Liquido,3-FragilQuebraveis,4-FragilToxicos): ");
            int material=input.nextInt();
            int tipo = 0;
            int c=0;;
            
            if(material == 1){
            tipo = 1;
            System.out.println("Qual o código da carga ");
            c = input.nextInt();                
            System.out.println("Qual a volumetria ");
            double vol = input.nextDouble();
            Solido s = new Solido(c,vol);
            e.addCargas(c,s);}
            
            if(material == 2){
            tipo = 2;
            System.out.println("Qual o código da carga ");
            c = input.nextInt(); 
            System.out.println("Qual o peso ");
            double pes = input.nextDouble();
            Liquido l = new Liquido(c,pes);
            e.addCargas(c,l);}
            
            if(material == 3){
            tipo = 3;
            System.out.println("Qual o código da carga ");
            c = input.nextInt(); 
            System.out.println("Qual o peso ");
            double pes = input.nextDouble();
            System.out.println("Qual a taxa ");
            double tax = input.nextDouble();
            Quebraveis q = new Quebraveis(c,pes,tax);
            e.addCargas(c,q);}
            
            if(material == 4){
            tipo = 4;
            System.out.println("Qual o código da carga ");
             c = input.nextInt(); 
            System.out.println("Qual o peso ");
            double pes = input.nextDouble();
            System.out.println("Qual a taxa ");
            double tax = input.nextDouble();
            System.out.println("Qual a taxa ambiental ");
            double taxA = input.nextDouble();
            Toxicos t = new Toxicos(c,pes,tax,taxA);
            e.addCargas(c,t);}
            
            
            
            Veiculo v = e.getVeiculo(codVeic);
            if(v==null){
                System.out.println("Não existe!"); 
                return;}
                        
            Serviço s = new Serviço(cod,codC,dest,dist,v,e.getCarga(c));
            FichaDeCliente f = e.getFicha(codC);
            e.addServiço(f,s);
            
                
            }       
        catch(InputMismatchException x)
        {
            System.out.println("Erro de Input!!");
        }
    }        
                
    
    public static void maisCombustivel(Empresa e)
    {
        Serviço s = e.maisCombustivel();
        System.out.println("O serviço que gastou mais combustivel é "+s.getCodigo());
    }
    
    
    
    
    
    
                
    public static void main(Scanner input,Empresa e) throws IOException
    {
        Scanner i= new Scanner(System.in);
        String option="";
        String a="";
        
        URL url = main.class.getProtectionDomain().getCodeSource().getLocation();       
        String path=url.toString();         
        path=path.replaceFirst("file:/","");        
        path=path.concat("Dados.txt");       
        
        while(option!="S"||option!="s")
        {   
            System.out.println("\nEscolha uma das seguintes opcoes:\n");
            System.out.println("0 - Colecao de servicos, clientes, veiculos");
            System.out.println("1 - Adicionar Veiculo");               
            System.out.println("2 - Contratacao de Servico");                    
            System.out.println("3 - Valor faturado num dia");                   
            System.out.println("4 - Servico que mais combustivel consumiu");     
            System.out.println("5 - Lista de clientes");  
            System.out.println("6 - Mapeamento código cliente/veiculos");                   
            System.out.println("7 - Veiculo mais rentavel");            
            System.out.println("8 - Veiculo mais usado");    
            System.out.println("9 - Mercadoria mais transportada"); 
            System.out.println("10 - Cliente mais rentável");                
            System.out.println("11 - Imprimir fatura");
            System.out.println("S - Sair");
            System.out.print("\nOpcao: ");
            
            
            option=input.next();
            System.out.println("");
            
            switch(option)
            {
                case "1":addVeiculo(input,e);break;
                case "4":maisCombustivel(e);break;
                /*case "3":criaServiÃ§o(input,x);break;
                case "4":getLocalizacao(input,x);break;
                case "5":maisViagens(x);break;
                case "6":getParados(x);break;
                case "7":maisRentavel(x);break;
                case "8":maisTransportado(x);break;
                case "9":valorPorDia(input,x);break;
                case "A":getLog(x);break;
                case "a":getLog(x);break;
                case "B":getMeteo(x);break;
                case "b":getMeteo(x);break;
                case "s":saveFile(path,x);break;
                case "S":saveFile(path,x);break;*/
            }
            
            System.out.print("\nPrima qualquer tecla para voltar ao menu ");
            a=input.next();
            System.out.print("\n\n\n");
        }
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
