package DAO;
import Models.Destinatario;
import Data.ConnectionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DestinatarioDAO 
{
    private String nomeTabela = "destinatario";
    
    public DestinatarioDAO()
    {
        
    }
    
    public boolean inserir(Destinatario d)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "INSERT INTO " + this.nomeTabela + " VALUES(DEFAULT, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, d.getNome());
            statement.setString(2, d.getDocumento());
            statement.setString(3, d.getRua());
            statement.setString(4, d.getBairro());
            statement.setString(5, d.getCep());
            statement.setString(6, d.getEstado());
            statement.setInt(7, d.getNumero());
            
            int affectedRows = statement.executeUpdate();
            
            return this.affectRow(affectedRows);
            
        }
        catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        
        return false;
    }
    
    //Remover
    public boolean remover(Destinatario d)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "DELETE FROM " + this.nomeTabela + " WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            int id = this.getId(d, connection);
            
            if(id > 0)
                statement.setLong(1, id);
            else
                return false;
            
            int affectedRows = statement.executeUpdate();
            
            return this.affectRow(affectedRows);
        }
        catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        
        return false;
    }
    
    public boolean remover(int id)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "DELETE FROM " + this.nomeTabela + " WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            
            int affectedRows = statement.executeUpdate();
            
            return this.affectRow(affectedRows);
        }
        catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        
        return false;
    }
    
    //Editar
    public boolean editar(Destinatario d, int id)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "UPDATE " + this.nomeTabela + " SET nome = ?, documento = ?, rua = ?, "
                    + "bairro = ?, cep = ?, estado = ?, numero = ? WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, d.getNome());
            statement.setString(2, d.getDocumento());
            statement.setString(3, d.getRua());
            statement.setString(4, d.getBairro());
            statement.setString(5, d.getCep());
            statement.setString(6, d.getEstado());
            statement.setInt(7, d.getNumero());
            statement.setInt(8, id);
            
            int affectedRows = statement.executeUpdate();
            
            return this.affectRow(affectedRows);
        }
        catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        
        return false;
    }
    
    //Get unico
    public Destinatario get(int id)
    {
        Destinatario destinatario = null;
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "SELECT * FROM " + this.nomeTabela + " WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            
            statement.execute();
            
            ResultSet result = statement.getResultSet();
            
            result.next();
            destinatario = new Destinatario();
            destinatario.id = result.getInt("id");
            destinatario.setNome(result.getString("nome"));
            destinatario.setDocumento(result.getString("documento"));            
            destinatario.setRua(result.getString("rua"));
            destinatario.setBairro(result.getString("bairro"));
            destinatario.setCep(result.getString("cep"));
            destinatario.setEstado(result.getString("estado"));
            destinatario.setNumero(result.getInt("numero"));
            
            return destinatario;
        }
        catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public ArrayList<Destinatario> getLista()
    {
        ArrayList<Destinatario> destinatarios = new ArrayList<>();
        Destinatario destinatario = null;
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "SELECT * FROM " + this.nomeTabela;
            
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.execute();
            
            ResultSet result = statement.getResultSet();
            
            while(result.next())
            {
                destinatario = new Destinatario();
                destinatario.id = result.getInt("id");
                destinatario.setNome(result.getString("nome"));
                destinatario.setDocumento(result.getString("documento"));            
                destinatario.setRua(result.getString("rua"));
                destinatario.setBairro(result.getString("bairro"));
                destinatario.setCep(result.getString("cep"));
                destinatario.setEstado(result.getString("estado"));
                destinatario.setNumero(result.getInt("numero"));
                destinatarios.add(destinatario);
            }
            
            if(!destinatarios.isEmpty())
                return destinatarios;
        }
        catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        
        return null;
    }

    public int getId(Destinatario d, Connection connection)
    {
        try
        {
            String query = "SELECT id FROM " + this.nomeTabela + " WHERE ("
                    + "nome = ? AND documento = ? AND rua = ? AND bairro = ? "
                    + "AND cep = ? AND estado = ? AND numero = ?)";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, d.getNome());
            statement.setString(2, d.getDocumento());
            statement.setString(3, d.getRua());
            statement.setString(3, d.getBairro());
            statement.setString(3, d.getCep());
            statement.setString(3, d.getEstado());
            statement.setInt(3, d.getNumero());
            
            statement.execute();
            
            ResultSet result = statement.getResultSet();
            int id = -1;
            
            while(result.next())
                id = result.getInt("id");
            
            return id;
        }
        catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        
        return -1;
    }
    
    private boolean affectRow(int affectedRows) 
    {
        return affectedRows > 0;
    }
}