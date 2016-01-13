import java.util.*;
import java.io.*;
import java.text.*;

//O MARTINS É GAY

public abstract class Carga implements Transportavel,Serializable
{
    private int codigo;
    
public Carga(int c)
{    this.codigo = c;}

public int getCodigo()
{   return this.codigo;}

public abstract double valorFrete();
public abstract double carga();

public abstract Carga clone();

}