package DAO;
import Models.Servico;
import Data.ConnectionDB;
import Helpers.Log;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

public class ServicoDAO
{
    private final String nomeTabela = "servico";

    public ServicoDAO()
    {
        //TODO testes
    }
    
    public boolean inserir(Servico s)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "INSERT INTO " + this.nomeTabela + " VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            statement.setDouble(1, s.getValorTotal());
            statement.setInt(2, s.getPrazoEmDias());
            Date dataSql = (Date)s.getDataLimite(); //cast sql date > util date
            statement.setDate(3, dataSql);
            dataSql = (Date)s.getDataCadastro(); //cast sql date > util date
            statement.setDate(4, dataSql);
            dataSql = (Date)s.getDataAgendada(); //cast sql date > util date
            statement.setDate(5, dataSql);
            statement.setInt(6, s.getDestinatarioId());
            statement.setInt(7, s.getPlataformaId());
            statement.setInt(8, s.getFuncionarioId());
            
            int affectedRows = statement.executeUpdate();
            
            return this.affectARow(affectedRows);

        }
        catch(SQLException ex)
        {
            new Log(s, "DAO: " + Helpers.Mensagem.ErroCadastroServico(), ex.getMessage()).print();
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
            new Log(id, "DAO: " + Helpers.Mensagem.ErroRemoverServico(), ex.getMessage()).print();
            return false;
        }
    }
    
    //Editar
    public boolean editar(Servico s, int id)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "UPDATE " + this.nomeTabela + " SET valor_total_frete = ?, "
                    + "prazo_dias = ?, data_limite = ?, data_cadastro = ?, data_agendada = ?, "
                    + "destinatario_id = ?, plataforma_id = ?, funcionario_id = ? "
                    + "WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDouble(1, s.getValorTotal());
            statement.setInt(2, s.getPrazoEmDias());
            Date dataSql = (Date)s.getDataLimite(); //cast sql date > util date
            statement.setDate(3, dataSql);
            dataSql = (Date)s.getDataCadastro();
            statement.setDate(4, dataSql);
            dataSql = (Date)s.getDataAgendada();
            statement.setDate(5, dataSql);
            statement.setInt(6, s.getDestinatarioId());
            statement.setInt(7, s.getPlataformaId());
            statement.setInt(8, s.getFuncionarioId());
            statement.setInt(9, id);
            
            int affectedRows = statement.executeUpdate();
            
            return this.affectARow(affectedRows);
        }
        catch(SQLException ex)
        {
            new Log(s, "DAO: " + Helpers.Mensagem.ErroEditarServico(), ex.getMessage()).print();
            return false;
        }
    }
    
    //Get unico ou lista
    public Servico get(int id)
    {
        Servico servico = null;
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "SELECT * FROM " + this.nomeTabela + " WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            
            statement.execute();
            
            ResultSet result = statement.getResultSet();
            
            result.next();
            servico = new Servico();
            servico.id = result.getInt("id");
            servico.setValorTotal(result.getDouble("valor_total_frete"));
            servico.setPrazoEmDias(result.getInt("prazo_dias"));
            servico.setDataLimite((Date)result.getDate("data_limite"));
            servico.setDataCadastro((Date)result.getDate("data_cadastro"));
            servico.setDataAgendada((Date)result.getDate("data_agendada"));
            servico.setDestinatarioId(result.getInt("destinatario_id"));
            servico.setPlataformaId(result.getInt("plataforma_id"));
            servico.setFuncionarioId(result.getInt("funcionario_id"));
            
            return servico;
        }
        catch(SQLException ex)
        {
            new Log(servico, "DAO: " + Helpers.Mensagem.ErroRecuperarServico(), ex.getMessage()).print();
            return null;
        }
        
    }
    
    public ArrayList<Servico> getLista()
    {
        ArrayList<Servico> servicos = new ArrayList<>();
        Servico servico = null;
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "SELECT * FROM " + this.nomeTabela;
            
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.execute();
            
            ResultSet result = statement.getResultSet();
            
            while(result.next())
            {
                servico = new Servico();
                servico.id = result.getInt("id");
                servico.setValorTotal(result.getDouble("valor_total_frete"));
                servico.setPrazoEmDias(result.getInt("prazo_dias"));
                servico.setDataLimite((Date)result.getDate("data_limite"));
                servico.setDataCadastro((Date)result.getDate("data_cadastro"));
                servico.setDataAgendada((Date)result.getDate("data_agendada"));
                servico.setDestinatarioId(result.getInt("destinatario_id"));
                servico.setPlataformaId(result.getInt("plataforma_id"));
                servico.setFuncionarioId(result.getInt("funcionario_id"));
                servicos.add(servico);
            }
            
            if(!servicos.isEmpty())
                return servicos;
            else
                return null;
        }
        catch(SQLException ex)
        {
            new Log(servico, "DAO: " + Helpers.Mensagem.ErroRecuperarListaServico(), ex.getMessage()).print();
            return null;
        }
    }
    
    //retorna se alguma linha foi afetada
    private boolean affectARow(int affectedRows)
    {
        return affectedRows > 0;
    }
}