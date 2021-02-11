package DAO;
import Models.Deposito;
import Data.ConnectionDB;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DepositoDAO 
{
    private Connection connection;
    public DepositoDAO()
    {
        this.connection = ConnectionDB.getConnection();
    }
    
    public void inserir(Deposito d)
    {
        try
        {
                
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
        }
        //insert
    }
    
    //Remover
    public Deposito remover(Deposito d)
    {
        //delete
        return null;
    }
    
    public Deposito remover(int id)
    {
        //delete
        return null;
    }
    
    //Editar
    public void editar(Deposito d)
    {
        //update
    }
    
    public void editar(int id)
    {
        //update
    }
    
    //Get unico ou lista
    public Deposito get(Deposito d)
    {
        //select where
        return null;
    }
    
    public Deposito get(int id)
    {
        //select where id
        return null;
    }
    
    public List<Deposito> getLista()
    {
        //select *
        return null;
    }
}