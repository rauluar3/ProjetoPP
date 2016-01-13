import java.util.*;
import java.io.*;
import java.text.*;

public class Toxicos extends Fragil implements Serializable
{
   private double taxaAmb;
   
public Toxicos(int c,double p,double t,double tx)
{   super(c,p,t);
    this.taxaAmb = tx;
}

public double valorFrete()
{  
    double precoBase = super.getValorMercado()*super.getPeso(); 
    double precoTaxa = precoBase * super.getTaxa() * this.taxaAmb;
    return precoBase + precoTaxa;
}

public boolean transporte(Veiculo v)
{ 
    if (super.getPeso()>v.capacidade())
    return false;
    else 
    return true;
}

public Toxicos clone()
{   return new Toxicos(super.getCodigo(),super.getPeso(),super.getTaxa(),this.taxaAmb); }

}

