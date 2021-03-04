package DAO;
import Models.Item;
import Data.ConnectionDB;
import Helpers.Log;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ItemDAO 
{
    private final String nomeTabela = "item";
    
    public ItemDAO()
    {
        //TODO: testes
    }
    
    public boolean inserir(Item i)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "INSERT INTO " + this.nomeTabela + " VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, i.getDescricao());
            statement.setBoolean(2, i.isFragil());
            statement.setDouble(3, i.getVolume());
            statement.setDouble(4, i.getValorItem());
            statement.setDouble(5, i.getValorFrete());
            statement.setInt(6, i.getDepositoId());
            statement.setInt(7, i.getServicoId());
            
            int affectedRows = statement.executeUpdate();
            
            return this.affectARow(affectedRows);
        }
        catch(SQLException ex)
        {
            new Log(i, "DAO: " + Helpers.Mensagem.ErroCadastroItem(), ex.getMessage()).print();
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
            new Log(id, "DAO: " + Helpers.Mensagem.ErroRemoverItem(), ex.getMessage()).print();
            return false;
        }
    }
    
    //Editar
    public boolean editar(Item i, int id)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "UPDATE " + this.nomeTabela + " SET descricao = ?, eh_fragil = ?, volume = ?, "
                    + "valor_item = ?, valor_frete = ?, deposito_id = ?, servico_id = ? WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, i.getDescricao());
            statement.setBoolean(2, i.ehFragil());
            statement.setDouble(3, i.getVolume());
            statement.setDouble(4, i.getValorItem());
            statement.setDouble(5, i.getValorFrete());
            statement.setInt(6, i.getDepositoId());
            statement.setInt(7, i.getServicoId());
            statement.setInt(8, id);
            
            int affectedRows = statement.executeUpdate();
            
            return this.affectARow(affectedRows);
        }
        catch(SQLException ex)
        {
            new Log(i, "DAO: " + Helpers.Mensagem.ErroEditarItem(), ex.getMessage()).print();
            return false;
        }
    }
    
    //Get unico ou lista
    public Item get(int id)
    {
        Item item = null;
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "SELECT * FROM " + this.nomeTabela + " WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            
            statement.execute();
            
            ResultSet result = statement.getResultSet();
            
            result.next();
            item = new Item();
            item.id = result.getInt("id");
            item.setDescricao(result.getString("descricao"));
            item.setEhFragil(result.getBoolean("eh_fragil"));
            item.setVolume(result.getDouble("volume"));
            item.setValorItem(result.getDouble("valor_item"));
            item.setValorFrete(result.getDouble("valor_frete"));
            item.setDepositoId(result.getInt("deposito_id"));
            item.setServicoId(result.getInt("servico_id"));

            return item;
        }
        catch(SQLException ex)
        {
            new Log(item, "DAO: " + Helpers.Mensagem.ErroRecuperarItem(), ex.getMessage()).print();
            return null;
        }
    }
    
    public ArrayList<Item> getAll()
    {
        ArrayList<Item> itens = new ArrayList<>();
        Item item = null;
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "SELECT * FROM " + this.nomeTabela;
            
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.execute();
            
            ResultSet result = statement.getResultSet();
            
            while(result.next())
            {
                item = new Item();
                item.id = result.getInt("id");
                item.setDescricao(result.getString("descricao"));
                item.setEhFragil(result.getBoolean("eh_fragil"));
                item.setVolume(result.getDouble("volume"));
                item.setValorItem(result.getDouble("valor_item"));
                item.setValorFrete(result.getDouble("valor_frete"));
                item.setDepositoId(result.getInt("deposito_id"));
                item.setServicoId(result.getInt("servico_id"));
                itens.add(item);
            }
            
            if(!itens.isEmpty())
                return itens;
            else
                return null;
        }
        catch(SQLException ex)
        {
            new Log(item, "DAO: " + Helpers.Mensagem.ErroRecuperarListaItem(), ex.getMessage()).print();
            return null;
        }
    }
    
    public int getId(Item i)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "SELECT id FROM " + this.nomeTabela + " WHERE ("
                    + "descricao = ? AND eh_fragil = ? AND volume = ? AND valor_item = ? AND "
                    + "valor_frete = ? AND deposito_id = ? AND servico_id = ?)";
            
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setString(1, i.getDescricao());
            statement.setBoolean(2, i.isFragil());
            statement.setDouble(3, i.getVolume());
            statement.setDouble(4, i.getValorItem());
            statement.setDouble(5, i.getValorFrete());
            statement.setInt(6, i.getDepositoId());
            statement.setInt(7, i.getServicoId());
            
            statement.execute();
            
            ResultSet result = statement.getResultSet();
            
            int id = -1;
            while(result.next())
                id = result.getInt("id");
            
            return id;
        }
        catch(SQLException ex)
        {
            new Log(i, "DAO: " + "Erro ao pegar o Id do item", ex.getMessage()).print();
            return -1;
        }
    }
    
    //retorna se alguma linha foi afetada
    private boolean affectARow(int affectedRows)
    {
        return affectedRows > 0;
    }
}