import java.util.*;
import java.io.*;
import java.text.*;

public class Solido extends Carga implements Serializable
{
    private static double valorMercado = 15.0;
    private double volumetria;
    
public Solido(int c,double v)
{   super(c);
    this.volumetria = v;
}
 
public double valorFrete()
{   return (this.valorMercado*this.volumetria); }

public double carga()
{   return this.volumetria;}

public boolean transporte(Veiculo v)
{ 
    if (this.volumetria>v.capacidade())
    return false;
    else 
    return true;
}

public Solido clone()
{   return new Solido(super.getCodigo(),this.volumetria); }

}

















    
