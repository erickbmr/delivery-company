package DAO;
import Models.Veiculo;
import Data.ConnectionDB;
import Helpers.Log;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VeiculoDAO
{
    private final String nomeTabela = "veiculo";
    
    public VeiculoDAO()
    {
        //TODO testes
    }
    
    public boolean inserir(Veiculo v)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "INSERT INTO " + this.nomeTabela + " VALUES (DEFAULT, ?, ?, ?, ?, ?)";
            
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, v.getPlaca());
            statement.setString(2, v.getModelo());
            statement.setString(3, v.getCor());
            statement.setDouble(4, v.getCapacidadeTotal());
            statement.setDouble(5, v.getCapacidadeRestante());
            
            int affectedRows = statement.executeUpdate();
            
            return this.affectARow(affectedRows);
        }
        catch(SQLException ex)
        {
            new Log(v, "DAO: " + Helpers.Mensagem.ErroCadastroVeiculo(), ex.getMessage()).print();
            return false;
        }

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
            new Log(id, "DAO: " + Helpers.Mensagem.ErroRemoverVeiculo(), ex.getMessage()).print();
            return false;
        }
    }
    
    //Editar
    public boolean editar(Veiculo v, int id)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "UPDATE " + this.nomeTabela + " SET placa = ?, modelo = ?, cor = ?, "
                    + "capacidade_total = ?, capacidade_restante = ? WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, v.getPlaca());
            statement.setString(2, v.getModelo());
            statement.setString(3, v.getCor());
            statement.setDouble(4, v.getCapacidadeTotal());
            statement.setDouble(5, v.getCapacidadeRestante());
            statement.setInt(6, id);
            
            int affectedRows = statement.executeUpdate();
            
            return this.affectARow(affectedRows);
        }
        catch(SQLException ex)
        {
            new Log(v, "DAO: " + Helpers.Mensagem.ErroEditarVeiculo(), ex.getMessage()).print();
            return false;
        }
    }
    
    public Veiculo get(int id)
    {
        Veiculo veiculo = null;
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "SELECT * FROM " + this.nomeTabela + " WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            
            statement.execute();
            
            ResultSet result = statement.getResultSet();
            
            result.next();
            veiculo = new Veiculo();
            veiculo.id = result.getInt("id");
            veiculo.setPlaca(result.getString("placa"));
            veiculo.setModelo(result.getString("modelo"));
            veiculo.setCor(result.getString("cor"));
            veiculo.setCapacidadeTotal(result.getDouble("capacidade_total"));
            veiculo.setCapacidadeRestante(result.getDouble("capacidade_restante"));
            
            return veiculo;
        }
        catch(SQLException ex)
        {
            new Log(id, "DAO: " + Helpers.Mensagem.ErroRecuperarVeiculo(), ex.getMessage()).print();
            return null;
        }
    }
    
    public ArrayList<Veiculo> getAll()
    {
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        Veiculo veiculo = null;
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "SELECT * FROM " + this.nomeTabela;
            
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.execute();
            
            ResultSet result = statement.getResultSet();
            
            while(result.next())
            {
                veiculo = new Veiculo();
                veiculo.id = result.getInt("id");
                veiculo.setPlaca(result.getString("placa"));
                veiculo.setModelo(result.getString("modelo"));
                veiculo.setCor(result.getString("cor"));
                veiculo.setCapacidadeTotal(result.getDouble("capacidade_total"));
                veiculo.setCapacidadeRestante(result.getDouble("capacidade_restante"));
                veiculos.add(veiculo);
            }
            
            if(!veiculos.isEmpty())
                return veiculos;
            else
                return null;
        }
        catch(SQLException ex)
        {
            new Log(null, "DAO: " + Helpers.Mensagem.ErroRecuperarListaVeiculo(), ex.getMessage()).print();
            return null;
        }
    }
    
    public int getId(Veiculo v)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "SELECT id FROM " + this.nomeTabela + " WHERE(placa = ? "
                    + "AND modelo = ? AND cor = ? AND capacidade_total = ? AND "
                    + "capacidade_restante = ?)";
            
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, v.getPlaca());
            statement.setString(2, v.getModelo());
            statement.setString(3, v.getCor());
            statement.setDouble(4, v.getCapacidadeTotal());
            statement.setDouble(5, v.getCapacidadeRestante());
            
            statement.execute();
            
            ResultSet result = statement.getResultSet();
            
            int id = -1;
            while(result.next())
                id = result.getInt("id");
            
            return id;
        }
        catch(SQLException ex)
        {
            new Log(v, "DAO: " + "Erro ao recuperar o id do veiculo.", ex.getMessage()).print();
            return -1;
        }
    }
    
    private boolean affectARow(int affectedRows)
    {
        return affectedRows > 0;
    }
}