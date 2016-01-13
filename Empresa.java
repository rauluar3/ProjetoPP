import java.util.*;
import java.io.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Empresa implements Serializable
{
   private HashMap<FichaDeCliente,ArrayList<Serviço>> lista;
   private ArrayList<Veiculo> veiculos;
   private ArrayList<FichaDeCliente> fichas;
   private HashMap<Veiculo,Serviço> list;
   
    /**
     *  Constrói uma nova instância de Empresa com exemplos incluídos
     */
    
public Empresa()
{   
    this.lista = new HashMap<FichaDeCliente,ArrayList<Serviço>>();
    this.veiculos = new ArrayList<Veiculo>();  
    this.fichas = new ArrayList<FichaDeCliente>();
    
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
    */this.veiculos.add(frageis1.clone());
    /*this.veiculos.add(frageis2.clone());
    
    //--------------------------------------------------------

    //serviço1.addCarga(new Solido(2,*/
    
} 

/**
     * Adiciona um novo veiculo na instância Empresa
     * @param c Codigo do Veiculo
     * @return verdadeiro - se o Veiculo for adicionado com sucesso
     */
public boolean addVeiculo(int c,String m,double con,double cap)
{  
    for(Veiculo v:this.veiculos)
    {
        if(v.getCodigo()==c)
        {
            return false;
        }
        else
            if(v instanceof Solidos){
                this.veiculos.add(new Solidos(c,m,con,cap));}
            if(v instanceof Cisternas){
                this.veiculos.add(new Cisternas(c,m,con,cap));}
            if(v instanceof Frageis){
                this.veiculos.add(new Frageis(c,m,con,cap));}
    }   
        return true;
    
}
/**
     * Adiciona um Serviço a um dado Veiculo na lista da Empresa
     * @param x UAV a adicionar no log
     * @param s Serviço a adicionar no log
     * @return verdadeiro se o Serviço foi adicionado com sucesso
     */
public boolean addServiço(FichaDeCliente f,Serviço s)
{
    if(lista.get(f)== null)
    {
        lista.put(f,new ArrayList<Serviço>());
        lista.get(f).add(s.clone());
        return true;
    }
    else
    {
        lista.get(f).add(s.clone());
        return true;
    }
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
            for(Serviço s:lista.get(f))
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
    public Serviço maisCombustivel()
    {   
        Serviço max = null;
        double x=0;
    
    
    for (FichaDeCliente f:lista.keySet()){
        ArrayList<Serviço> ls=lista.get(f);
        for(Serviço s:ls){
            x=s.consumo();
            if(x>max.consumo()){
                max=s;
            }
        }
     }
    
    return max.clone();
}

    public ArrayList<FichaDeCliente> preencher()
    {
        for(FichaDeCliente f:lista.keySet())
        {
          this.fichas.add(f);  
        }
        sortByName(fichas);
        return fichas;
    }
    
    private static void sortByName(List<FichaDeCliente> fichas)
    {
        Collections.sort(fichas, new PersonComparator());
    }
}


   
