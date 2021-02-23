package DAO;
import Models.PlataformaCliente;
import Data.ConnectionDB;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PlataformaDAO 
{
    private final String nomeTabela = "plataforma";
    
    public PlataformaDAO()
    {
        //TODO testes
    }
    
    public boolean inserir(PlataformaCliente p)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "INSERT INTO " + this.nomeTabela + " VALUES (DEFAULT, ?, ?, ?)";
            
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, p.getDocumento());
            statement.setString(2, p.getTelefone());
            statement.setInt(3, p.getCategoriaId());
            
            int affectedRows = statement.executeUpdate();
            
            return this.affectARow(affectedRows);

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
            
            return this.affectARow(affectedRows);
        }
        catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean editar(PlataformaCliente p, int id)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "UPDATE " + this.nomeTabela + " SET documento = ?, "
                    + "telefone = ?, categoria_id = ? WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, p.getDocumento());
            statement.setString(2, p.getTelefone());
            statement.setInt(3, p.getCategoriaId());
            statement.setInt(4, id);
            
            int affectedRows = statement.executeUpdate();
            
            return this.affectARow(affectedRows);
        }
        catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return false;
    }
    
    public PlataformaCliente get(int id)
    {
        PlataformaCliente plataforma = null;
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "SELECT * FROM " + this.nomeTabela + " WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            
            statement.execute();
            
            ResultSet result = statement.getResultSet();
            
            result.next();
            plataforma = new PlataformaCliente();
            plataforma.id = result.getInt("id");
            plataforma.setDocumento(result.getString("documento"));
            plataforma.setTelefone(result.getString("telefone"));
            plataforma.setCategoria(result.getInt("categoria_id"));

            return plataforma;
        }
        catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public ArrayList<PlataformaCliente> getAll()
    {
        ArrayList<PlataformaCliente> plataformas = new ArrayList<>();
        PlataformaCliente plataforma = null;
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "SELECT * FROM " + this.nomeTabela;
            
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.execute();
            
            ResultSet result = statement.getResultSet();
            
            while(result.next())
            {
                plataforma = new PlataformaCliente();
                plataforma.id = result.getInt("id");
                plataforma.setDocumento(result.getString("documento"));
                plataforma.setTelefone(result.getString("telefone"));
                plataforma.setCategoria(result.getInt("categoria_id"));
                plataformas.add(plataforma);
            }
            
            if(!plataformas.isEmpty())
                return plataformas;
        }
        catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public int getId(PlataformaCliente p, Connection connection)
    {
        try
        {
            String query = "SELECT id FROM " + this.nomeTabela + " WHERE ("
                    + "documento = ? AND telefone = ? AND categoria_id = ?)";
            
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setString(1, p.getDocumento());
            statement.setString(2, p.getTelefone());
            statement.setInt(3, p.getCategoriaId());
            
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
    //retorna se alguma linha foi afetada
    private boolean affectARow(int affectedRows)
    {
        return affectedRows > 0;
    }
}