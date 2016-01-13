import java.util.*;
import java.io.*;
import java.text.*;

public class Cisternas extends Veiculo implements Serializable
{
    private double capCarga;
    
public Cisternas(int cod,String m,double c,double cap)
{
    super(cod,m,c);
    this.capCarga = cap;
}

public double capacidade()
{   return this.capCarga;}

public Cisternas clone()
{   return new Cisternas(super.getCodigo(),super.getMatricula(),super.getConsumoMedio(),this.capCarga);}
}
