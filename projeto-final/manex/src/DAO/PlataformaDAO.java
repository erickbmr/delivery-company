package DAO;
import Models.PlataformaCliente;
import Data.ConnectionDB;
import Helpers.Log;
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
            String query = "INSERT INTO " + this.nomeTabela + " VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, p.getDocumento());
            statement.setString(2, p.getTelefone());
            statement.setInt(3, p.getCategoriaId());
            statement.setString(4, p.getRua());
            statement.setString(5, p.getBairro());
            statement.setInt(6, p.getNumero());
            statement.setString(7, p.getCidade());
            String estado = Helpers.UnidadeFederativa.getUF(p.getEstado());
            statement.setString(8, estado);
            statement.setString(9, p.getNome());

            int affectedRows = statement.executeUpdate();
            
            return this.affectARow(affectedRows);

        }
        catch(SQLException ex)
        {
            new Log(p, "DAO: " + Helpers.Mensagem.ErroCadastroPlataforma(), ex.getMessage()).print();
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
            new Log(id, "DAO: " + Helpers.Mensagem.ErroRemoverPlataforma(), ex.getMessage()).print();
            return false;
        }
    }
    
    public boolean editar(PlataformaCliente p, int id)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "UPDATE " + this.nomeTabela + " SET documento = ?, "
                    + "telefone = ?, categoria_id = ?, rua = ?, bairro = ?, numero = ?, "
                    + "cidade = ?, estado = ? WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, p.getDocumento());
            statement.setString(2, p.getTelefone());
            statement.setInt(3, p.getCategoriaId());
            statement.setString(4, p.getRua());
            statement.setString(5, p.getBairro());
            statement.setInt(6, p.getNumero());
            statement.setString(7, p.getCidade());
            String estado = Helpers.UnidadeFederativa.getUF(p.getEstado());
            statement.setString(8, estado);
            statement.setInt(9, id);
            
            int affectedRows = statement.executeUpdate();
            
            return this.affectARow(affectedRows);
        }
        catch(SQLException ex)
        {
            new Log(p, "DAO: " + Helpers.Mensagem.ErroEditarPlataforma(), ex.getMessage()).print();
            return false;
        }
    }
    
    public PlataformaCliente get(String CNPJ)
    {
        PlataformaCliente plataforma = null;

        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "SELECT * FROM " + this.nomeTabela + " WHERE documento = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, CNPJ);
            
            statement.execute();
            
            plataforma = new PlataformaCliente();
            
            ResultSet result = statement.getResultSet();
            if(result.next())
            {
                plataforma.id = result.getInt("id");
                plataforma.setTelefone(result.getString("telefone"));
                plataforma.setCategoria(result.getInt("categoria_id"));
                plataforma.setDocumento(result.getString("documento"));
                plataforma.setRua(result.getString("rua"));
                plataforma.setBairro(result.getString("bairro"));
                plataforma.setNumero(result.getInt("numero"));
                plataforma.setCidade(result.getString("cidade"));
                plataforma.setEstado(result.getString("estado"));
                plataforma.setNome(result.getString("nome"));
                return plataforma;
            }
            else
                return null;

        }
        catch(Exception ex)
        {
            new Log(CNPJ, "DAO: " + Helpers.Mensagem.ErroRecuperarPlataforma(), ex.getMessage()).print();
            return plataforma;
        }
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
            plataforma.setRua(result.getString("rua"));
            plataforma.setBairro(result.getString("bairro"));
            plataforma.setNumero(result.getInt("numero"));
            plataforma.setCidade(result.getString("cidade"));
            plataforma.setEstado(result.getString("estado"));
            plataforma.setNome(result.getString("nome"));


            return plataforma;
        }
        catch(SQLException ex)
        {
            new Log(plataforma, "DAO: " + Helpers.Mensagem.ErroRecuperarPlataforma(), ex.getMessage()).print();
            return null;
        }
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
                plataforma.setRua(result.getString("rua"));
                plataforma.setBairro(result.getString("bairro"));
                plataforma.setNumero(result.getInt("numero"));
                plataforma.setCidade(result.getString("cidade"));
                plataforma.setEstado(result.getString("estado"));
                plataforma.setNome(result.getString("nome"));
                plataformas.add(plataforma);
            }
            
            if(!plataformas.isEmpty())
                return plataformas;
            else
                return null;
        }
        catch(SQLException ex)
        {
            new Log(plataforma, "DAO: " + Helpers.Mensagem.ErroRecuperarListaPlataforma(), ex.getMessage()).print();
            return null;
        }
    }
    
    public int getId(PlataformaCliente p)
    {
        try(Connection connection = ConnectionDB.getConnection())
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
            new Log(p, "DAO: Erro ao pegar o Id da plataforma." , ex.getMessage()).print();
            return -1;
        }
    }
    //retorna se alguma linha foi afetada
    private boolean affectARow(int affectedRows)
    {
        return affectedRows > 0;
    }
}