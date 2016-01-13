import java.util.*;
import java.io.*;
import java.text.*;

public class Serviço implements Serializable
{
    private int codigo;
    private int codigoCliente;
    private String destino;
    private double distancia;
    private GregorianCalendar data;
    private GregorianCalendar aux;
    private Carga c;
    private Veiculo v;
   
    /**
    * Construtor de cópia de Serviços
    */
 public Serviço(Serviço x)
 {
     this.codigo=x.getCodigo();
     this.codigoCliente=x.getCodigoCliente();
     this.destino=x.getDestino();
     this.distancia=x.getDistancia();
     this.data=x.getData();
     this.aux=x.getAux();
     this.c=x.getCargaX();
     this.v=x.getVeiculo();
    }
     
 public Serviço(int c, int cc, String d,double dd,Veiculo v,Carga b)
 {
     this.codigo=c;
     this.codigoCliente=cc;
     this.destino=d;
     this.distancia=dd;
     this.c = b;
     this.v = v;
     this.data=new GregorianCalendar();
     this.aux=new GregorianCalendar();
    }
    
 public int getCodigo()
 {return this.codigo;}
 
 public int getCodigoCliente()
 {return this.codigoCliente;}
 
 public String getDestino()
 {return this.destino;}
 
 public double getDistancia()
 {return this.distancia;}
 
 public Carga getCargaX()
 {  return this.c;}
 
 public void printData()
 {
     System.out.printf("%1$tY/%1$tm/%1$td || %tT%n",data);
    }
 
 public GregorianCalendar getData()
 {return this.data;}
 
 public GregorianCalendar getAux()
 {return this.aux;}
 
 public void addVeiculo(Veiculo v){
     this.v = v;
 }
 
 public Veiculo getVeiculo(){
     return this.v;
 }
    
 public void addCarga(Carga c)
 {
     this.c=c;
 }
 
 public Carga getCarga(){
     return this.c;
  }
 
  public double consumo(){
      
        double cc =0.0;
        if(this.v.getClass().getName() == "Solido"){
        cc = ((v.getConsumoMedio()*this.distancia)/100);
        if(this.c.carga() > 0.75*v.capacidade())
        { cc = cc*2;}
        return cc;}
        
        if(this.v.getClass().getName() == "Liquido"){
        cc = ((v.getConsumoMedio()*this.distancia)/100);
        return cc;}
      
        if(this.v.getClass().getName() == "Fragil"){
        cc = ((v.getConsumoMedio()*this.distancia)/100);
        return cc;}
      
        return cc;
      
    }
  
 public String fatura(Carga c,Veiculo v)
 {
    String Fatura = null;
    if((v.getClass().getName().equals("Solidos")) && (c.getClass().getName().equals("Solido")))
    {       Fatura = this.destino+" "+this.codigoCliente+" "+c.getCodigo()+" "+v.getCodigo()+" "+c.valorFrete();}
            
    if((v.getClass().getName().equals("Cisternas")) && (c.getClass().getName().equals("Liquido")))
    {       Fatura = this.destino+" " +this.codigoCliente+ " " +c.getCodigo()+" " +v.getCodigo()+" " +c.valorFrete();}
    
    if((v.getClass().getName().equals("Frageis")) && (c.getClass().getName().equals("Fragil")))
    {       Fatura = this.destino+" " +this.codigoCliente+ " " +c.getCodigo()+" " +v.getCodigo()+" " +c.valorFrete();}
    
    return Fatura;
        }
    
     /**
     *   Verifica se há correspondência entre Serviços pela sua data
     *   @return verdadeiro - se os serviços corresponderem
     */
  public boolean equals(GregorianCalendar c)                           
  {return this.data==c;}
    
 
    
   /**
     *   Cria uma cópia da instância Serviços, preservando os Pacotes já existentes
     *   @return Clone da instância Serviços
     */
    public Serviço clone()
    {
        Serviço s= new Serviço(this.codigo,this.codigoCliente,this.destino,this.distancia,this.v,this.c);
            
        return s;
    }
}