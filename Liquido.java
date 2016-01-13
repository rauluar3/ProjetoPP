import java.util.*;
import java.io.*;
import java.text.*;

public class Liquido extends Carga implements Serializable
{
    private static double valorMercado = 20.0;
    private double peso;
    
public Liquido(int c,double p)
{   super(c);
    this.peso = p;
}

public double valorFrete()
{   return (this.valorMercado*this.peso); }

public double carga()
{   return this.peso;}


public boolean transporte(Veiculo v)
{ 
    if (this.peso>v.capacidade())
    return false;
    else 
    return true;
}

public Liquido clone()
{   
    return new Liquido(super.getCodigo(),this.peso); }

}


