import java.util.*;
import java.io.*;
import java.text.*;

public class FichaDeCliente implements Serializable
{
    private String nome;
    private String morada;
    private int telefone;
    private int numCliente;
    private int nif;
    
public FichaDeCliente (String n,String m,int t,int c,int ni)
{
    this.nome = n;
    this.morada = m;
    this.telefone = t;
    this.numCliente = c;
    this.nif = ni;
}


public String getNome()
{   return this.nome;}

public void setNome(String n)
{   this.nome=n; }
   
public String getMorada()
{   return this.morada;}

public void setMorada(String mo)
{  this.morada = mo; }

public int getTelefone()
{   return this.telefone; }

public void setTelefone(int tel)
{   this.telefone = tel;}

public int getNumCliente()
{   return this.numCliente; }

public int getNif()
{   return this.nif; }


public FichaDeCliente clone()
{   return new FichaDeCliente(this.nome,this.morada,this.telefone,this.numCliente,this.nif);}

}

















