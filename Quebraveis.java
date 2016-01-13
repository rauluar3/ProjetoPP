import java.util.*;
import java.io.*;
import java.text.*;

public class Quebraveis extends Fragil implements Serializable
{

   
public Quebraveis(int c,double p,double t)
{   super(c,p,t);}


public double valorFrete()
{  
    double precoBase = super.getValorMercado()*super.getPeso(); 
    double precoTaxa = precoBase * super.getTaxa();
    return precoBase + precoTaxa;
}

public boolean transporte(Veiculo v)
{ 
    if (super.getPeso()>v.capacidade())
    return false;
    else 
    return true;
}

public Quebraveis clone()
{   return new Quebraveis(super.getCodigo(),super.getPeso(),super.getTaxa()); }

}


