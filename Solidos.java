import java.util.*;
import java.text.*;
import java.io.*;

public class Solidos extends Veiculo implements Serializable
{
    private double capCarga;
    
public Solidos(int cod,String m,double c,double cap)
{
    super(cod,m,c);
    this.capCarga = cap;
}


public double capacidade()
{   return this.capCarga;}

public Solidos clone()
{   return new Solidos(super.getCodigo(),super.getMatricula(),super.getConsumoMedio(),this.capCarga);}
}