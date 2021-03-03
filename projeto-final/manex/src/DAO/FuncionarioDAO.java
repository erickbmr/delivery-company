package DAO;
import Models.Disabled.Funcionario;
import Data.ConnectionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FuncionarioDAO 
{
    private final String nomeTabela = "funcionario";
    public FuncionarioDAO()
    {
        //TODO: test
    }
    
    public boolean inserir(Funcionario f)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "INSERT INTO " + this.nomeTabela + " VALUES (DEFAULT, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, f.getNome());
            statement.setString(2, f.getCnh());
            statement.setString(3, f.getTelefone());
            statement.setBoolean(4, f.isDisponivel());

            int affectedRows = statement.executeUpdate();

            return this.affectARow(affectedRows);
        }
        catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }

        return false;
    }
    
    //Remover
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
    
    //Editar
    public boolean editar(Funcionario f, int id)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "UPDATE " + this.nomeTabela + " SET nome = ?, documento = ?, "
                    + "telefone = ?, disponivel = ? WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setString(1, f.getNome());
            statement.setString(2, f.getCnh());
            statement.setString(3, f.getTelefone());
            statement.setBoolean(4, f.isDisponivel());
            statement.setInt(5, id);

            int affectedRows = statement.executeUpdate();

            return this.affectARow(affectedRows);
        }
        catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return false;
    }
    
    public Funcionario get(int id)
    {
        Funcionario funcionario = null;
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "SELECT * FROM " + this.nomeTabela + " WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            statement.execute();

            ResultSet result = statement.getResultSet();

            result.next();
            funcionario = new Funcionario();
            funcionario.setId(result.getInt("id"));
            funcionario.setNome(result.getString("nome"));
            funcionario.setCnh(result.getString("documento"));
            funcionario.setTelefone(result.getString("telefone"));
            funcionario.setDisponivel(result.getBoolean("disponivel"));

            return funcionario;
        }
        catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public ArrayList<Funcionario> getAll()
    {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Funcionario funcionario = null;

        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "SELECT * FROM " + this.nomeTabela;

            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.execute();

            ResultSet result = statement.getResultSet();

            while(result.next())
            {
                funcionario = new Funcionario();
                funcionario.id = result.getInt("id");
                funcionario.setNome(result.getString("nome"));
                funcionario.setCnh(result.getString("documento"));
                funcionario.setTelefone(result.getString("telefone"));
                funcionario.setDisponivel(result.getBoolean("disponivel"));
                funcionarios.add(funcionario);
            }

            if(!funcionarios.isEmpty())
                return funcionarios;
        }
        catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public int getId(Funcionario f, Connection connection)
    {
        try
        {
            String query = "SELECT id FROM " + this.nomeTabela + " WHERE ("
                    + "nome = ? AND documento = ? AND telefone = ? AND disponivel = ?)";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, f.getNome());
            statement.setString(2, f.getCnh());
            statement.setString(3, f.getTelefone());
            statement.setBoolean(4, f.isDisponivel());
            
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

    private boolean affectARow(int affectedRows)
    {
        return affectedRows > 0;
    }
}