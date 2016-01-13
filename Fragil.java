import java.util.*;
import java.io.*;
import java.text.*;
public abstract class Fragil extends Carga implements Serializable
{
    private static double valorMercado = 25.0;
    private double peso;
    private double taxa;
    
public Fragil(int c,double p,double t)
{   super(c);
    this.peso = p;
    this.taxa = t;
}

public double carga()
{   return this.peso;}

public double getTaxa()
{   return this.taxa;}

public double getPeso()
{   return this.peso;}

public double getValorMercado()
{   return this.valorMercado;}

public abstract double valorFrete();
public abstract Fragil clone();

}

