
import java.util.*;
import java.io.*;
import java.text.*;

public abstract class Veiculo implements Serializable
{
    private int codigo;
    private String matricula;
    private double consumoMedio;
    
public Veiculo(int cod,String m,double con)
{
    this.codigo = cod;
    this.matricula=m;
    this.consumoMedio=con;
}

public int getCodigo()
{return this.codigo;}

public String getMatricula()
{return this.matricula;}

public double getConsumoMedio()
{return this.consumoMedio;}

public double setConsumoMedio(double cm)
{return this.consumoMedio=cm;}

public abstract double capacidade();

public abstract Veiculo clone();
}






