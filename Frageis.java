import java.util.*;
import java.io.*;
import java.text.*;

public class Frageis extends Veiculo implements Serializable
{
    private double capCarga;
    
public Frageis(int cod,String m,double c,double cap)
{
    super(cod,m,c);
    this.capCarga = cap;
}


public double capacidade()
{   return this.capCarga;}

public Frageis clone()
{   return new Frageis(super.getCodigo(),super.getMatricula(),super.getConsumoMedio(),this.capCarga);}
}