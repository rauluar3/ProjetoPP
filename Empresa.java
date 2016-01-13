import java.util.*;
import java.io.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Empresa implements Serializable
{
   private HashMap<FichaDeCliente,ArrayList<Servi�o>> lista;
   private HashMap<Integer,Veiculo> veiculos;
   private HashMap<Integer,Carga> cargas;
   
   
   
    /**
     *  Constr�i uma nova inst�ncia de Empresa com exemplos inclu�dos
     */
    
public Empresa()
{   
    this.lista = new HashMap<FichaDeCliente,ArrayList<Servi�o>>();
    this.veiculos = new HashMap<Integer,Veiculo>();  
    this.cargas = new HashMap<Integer,Carga>();
    
    //---------------------------------------------------------------------------------------
    /*Solidos solidos1 = new Solidos(1,"01-AA-01",15.0,70.0);
    Solidos solidos2 = new Solidos(2,"02-BB-02",14.0,69.0);
    Cisternas cisternas1 = new Cisternas(3,"03-CC-03",14.4,4500.0);
    Cisternas cisternas2 = new Cisternas(4,"04-DD-04",14.7,5000.0);*/
    Frageis frageis1= new Frageis(5,"05-EE-05",13.2,3500.0);
    /*Frageis frageis2= new Frageis(6,"06-FF-06",13.5,3250.0);
    
    this.veiculos.add(solidos1.clone());
    this.veiculos.add(solidos2.clone());
    this.veiculos.add(cisternas1.clone());
    this.veiculos.add(cisternas2.clone());
    */this.veiculos.put(5,frageis1.clone());
    /*this.veiculos.add(frageis2.clone());
    
    //--------------------------------------------------------

    //servi�o1.addCarga(new Solido(2,*/
    
} 

/**
     * Adiciona um novo veiculo na inst�ncia Empresa
     * @param c Codigo do Veiculo
     * @param tipo 1 se Solido, 2 se Cisterna, 3 se Frageis
     * @return verdadeiro - se o Veiculo for adicionado com sucesso
     */
public boolean addVeiculo(int c,String m,double con,double cap,int tipo)
{  
    if(this.veiculos.containsKey(c))
        return false;
       
        if(tipo == 1){
        this.veiculos.put(c,new Solidos(c,m,con,cap));}
        if(tipo == 2){
        this.veiculos.put(c,new Cisternas(c,m,con,cap));}
        if(tipo == 3){
        this.veiculos.put(c,new Frageis(c,m,con,cap));}
     
        return true;
    
}
 
public boolean addCargas(int c,Carga z)
{
    if(this.cargas.containsKey(c))
        return false;
        
        this.cargas.put(c,z);
               
        return true;
    }      
        
public Carga getCarga(int c)
{  return this.cargas.get(c);}    
    

/**
     * Adiciona um Servi�o a um dado Veiculo na lista da Empresa
     * @param x UAV a adicionar no log
     * @param s Servi�o a adicionar no log
     * @return verdadeiro se o Servi�o foi adicionado com sucesso
     */
public boolean addServi�o(FichaDeCliente f,Servi�o s)
{
    if(lista.get(f)== null)
    {
        lista.put(f,new ArrayList<Servi�o>());
        lista.get(f).add(s.clone());
        return true;
    }
    else
    {
        lista.get(f).add(s.clone());
        return true;
    }
}

public Veiculo getVeiculo(int cod){
    return this.veiculos.get(cod);
}

public FichaDeCliente getFicha(int cod){
    for(FichaDeCliente f : lista.keySet()){
        if(cod==(f.getNumCliente()))
        return f;
    }
    return null;
}

 /**
     * Calcula o valor facturado num dado dia   dfgchjbknllllllllllllllllllllllllllllllllllllllllllllll
     * @param dia Dia a consultar
     * @return valor total facturado nesse dia
     */ 
    
    public double valorDia(GregorianCalendar dia)
    {
        double valor=0;
        
        Carga c = null;
                
        for(FichaDeCliente f:lista.keySet())
        {
            for(Servi�o s:lista.get(f))
            {
                c=s.getCarga();
                
                    if(dia.get(Calendar.DAY_OF_YEAR)==s.getData().get(Calendar.DAY_OF_YEAR))
                    {
                        //if(s.getCarga()instanceof Solido)
                        if(s.getCarga().getClass().getName().equals("Solido"))
                            valor+=((Solido)c).valorFrete();
                        if(s.getCarga().getClass().getName().equals("Liquido"))
                            valor+=((Liquido)c).valorFrete();
                        if(s.getCarga().getClass().getName().equals("Fragil"))
                            valor+=((Fragil)c).valorFrete();  
                        if(s.getCarga().getClass().getName().equals("Quebraveis"))
                            valor+=((Quebraveis)c).valorFrete();
                        if(s.getCarga().getClass().getName().equals("Toxicos"))
                            valor+=((Toxicos)c).valorFrete();
                    }
                }        
            }             
        
       
        return valor;
}


    public Servi�o maisCombustivel()
    {   
        Servi�o max = null;
        double x=0;
    
    
    for (FichaDeCliente f:lista.keySet()){
        ArrayList<Servi�o> ls=lista.get(f);
        for(Servi�o s:ls){
            x=s.consumo();
            if(x>max.consumo()){
                max=s;
            }
        }
     }
    
    return max.clone();
}

    public List<FichaDeCliente> preencher()
    {
        ArrayList<FichaDeCliente> fichas = new ArrayList<FichaDeCliente>();
        for(FichaDeCliente f:lista.keySet())
        {
          fichas.add(f);  
        }
        sortByName(fichas);
        return fichas;
    }
    
    private static void sortByName(List<FichaDeCliente> fichas)
    {
        Collections.sort(fichas, new PersonComparator());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}


   
