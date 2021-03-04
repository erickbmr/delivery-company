package DAO;
import Models.Deposito;
import Data.ConnectionDB;
import Helpers.Log;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DepositoDAO 
{
    private final String nomeTabela = "deposito";
    
    public DepositoDAO()
    {
        
    }
    
    public boolean inserir(Deposito d) throws Exception
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "INSERT INTO " + this.nomeTabela + " VALUES(DEFAULT, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, d.getRua());
            statement.setString(2, d.getBairro());
            statement.setString(3, d.getCep());
            String estado = Helpers.UnidadeFederativa.getUF(d.getEstado());
            statement.setString(4, estado);
            statement.setInt(5, d.getNumero());
            statement.setDouble(6, d.getCapacidadeTotal());
            statement.setDouble(7, d.getCapacidadeRestante());
            
            int affectedRows = statement.executeUpdate();
            
            return this.affectARow(affectedRows);
        }
        catch(SQLException ex)
        {
            new Log(d, "DAO: " + Helpers.Mensagem.ErroCadastroDeposito(), ex.getMessage()).print();
            return false;
        }
        
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
            new Log(id, "DAO: " + Helpers.Mensagem.ErroRemoverDeposito(), ex.getMessage()).print();
            return false;
        }
    }
    
    //Editar
    public boolean editar(Deposito d, int id)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "UPDATE " + this.nomeTabela + " SET rua = ?, bairro = ?, cep = ?, estado = ?, "
                    + "numero = ?, capacidade_total = ?, capacidade_restante = ? WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, d.getRua());
            statement.setString(2, d.getBairro());
            statement.setString(3, d.getCep());
            String estado = Helpers.UnidadeFederativa.getUF(d.getEstado());
            statement.setString(4, estado);
            statement.setInt(5, d.getNumero());
            statement.setDouble(6, d.getCapacidadeTotal());
            statement.setDouble(7, d.getCapacidadeRestante());
            statement.setInt(8, id);
            
            int affectedRows = statement.executeUpdate();
            
            return this.affectARow(affectedRows);
        }
        catch(SQLException ex)
        {
            new Log(d, "DAO: " + Helpers.Mensagem.ErroEditarDeposito(), ex.getMessage()).print();
            return false;
        }
    }
    
    
    //Get unico
    public Deposito get(int id)
    {
        Deposito deposito = null;
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "SELECT * FROM " + this.nomeTabela + " WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            
            statement.execute();
            
            ResultSet result = statement.getResultSet();
            
            result.next();
            deposito = new Deposito();
            deposito.setId(result.getInt("id"));
            deposito.setRua(result.getString("rua"));
            deposito.setBairro(result.getString("bairro"));
            deposito.setCep(result.getString("cep"));
            String estado = result.getString("estado");
            deposito.setEstado(Helpers.UnidadeFederativa.getEstado(estado));
            deposito.setNumero(result.getInt("numero"));

            return deposito;
        }
        catch(SQLException ex)
        {
            new Log(id, "DAO: " + Helpers.Mensagem.ErroRecuperarDeposito(), ex.getMessage()).print();
            return null;
        }
    }
    
    //get lista
    public ArrayList<Deposito> getAll()
    {
        ArrayList<Deposito> depositos = new ArrayList<>();
        Deposito deposito = null;
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "SELECT * FROM " + this.nomeTabela;
            
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.execute();
            
            ResultSet result = statement.getResultSet();
            
            while(result.next())
            {
                deposito = new Deposito();
                deposito.setId(result.getInt("id"));
                deposito.setRua(result.getString("rua"));
                deposito.setBairro(result.getString("bairro"));
                deposito.setCep(result.getString("cep"));
                String estado = result.getString("estado");
                deposito.setEstado(Helpers.UnidadeFederativa.getEstado(estado));
                deposito.setNumero(result.getInt("numero"));
                depositos.add(deposito);
            }
            
            if(!depositos.isEmpty())
                return depositos;
        }
        catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    //get deposito a partir de id
    //parametro connection eh necessario para que ele nao feche no metodo que chamou este
    public int getId(Deposito d)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            
            String query = "SELECT id FROM " + this.nomeTabela + " WHERE ("
                    + "rua = ? AND bairro = ? AND cep = ? AND estado = ? AND numero = ? "
                    + "AND capacidade_total = ? AND capacidade_restante = ?)";
            
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, d.getRua());
            statement.setString(2, d.getBairro());
            statement.setString(3, d.getCep());
            String estado = Helpers.UnidadeFederativa.getUF(d.getEstado());
            statement.setString(4, estado);
            statement.setInt(5, d.getNumero());
            statement.setDouble(6, d.getCapacidadeTotal());
            statement.setDouble(7, d.getCapacidadeRestante());
            statement.execute();

            ResultSet result = statement.getResultSet();
            int id = -1;
            while(result.next())
                id = result.getInt("id");
            
            return id;
        }
        catch(SQLException ex)
        {
            new Log(d, "DAO: " + "Erro ao pegar o Id do deposito" , ex.getMessage()).print();
            return -1;
        }
    }
    
    //retorna se alguma linha foi afetada
    private boolean affectARow(int affectedRows)
    {
        return affectedRows > 0;
    }
}