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
            String query = "INSERT INTO " + this.nomeTabela + " VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            statement.setDouble(1, s.getValorTotal());
            statement.setInt(2, s.getPrazoEmDias());
            //Date dataSql = (Date)s.getDataLimite(); //cast sql date > util date
            //Date.valueOf(s.getDataLimite().toString());
            statement.setDate(3, Date.valueOf(s.getDataLimiteString()));
            //dataSql = (Date)s.getDataCadastro(); //cast sql date > util date
            statement.setDate(4, Date.valueOf(s.getDataCadastroString()));
            //dataSql = (Date)s.getDataAgendada(); //cast sql date > util date
            if(s.getDataAgendadaString() != null)
                statement.setDate(5, Date.valueOf(s.getDataAgendadaString()));
            else
                statement.setDate(5, null);

            statement.setInt(6, s.getDestinatarioId());
            statement.setInt(7, s.getPlataformaId());
            statement.setInt(8, s.getFuncionarioId());
            statement.setInt(9, s.getStatus());
            
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
                    + "destinatario_id = ?, plataforma_id = ?, funcionario_id = ?, status = ? "
                    + "WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDouble(1, s.getValorTotal());
            statement.setInt(2, s.getPrazoEmDias());
            statement.setDate(3, Date.valueOf(s.getDataLimiteString()));
            statement.setDate(4, Date.valueOf(s.getDataCadastroString()));
           
            if(s.getDataAgendadaString() != null)
                statement.setDate(5, Date.valueOf(s.getDataAgendadaString()));
            else
                statement.setDate(5, null);
            
            statement.setInt(6, s.getDestinatarioId());
            statement.setInt(7, s.getPlataformaId());
            statement.setInt(8, s.getFuncionarioId());
            statement.setInt(9, s.getStatus());
            statement.setInt(10, id);
            
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
            
            if(result.next())
            {
                servico = new Servico();
                servico.id = result.getInt("id");
                servico.setValorTotal(result.getDouble("valor_total_frete"));
                servico.setPrazoEmDias(result.getInt("prazo_dias"));
                //servico.setDataLimite((Date)result.getDate("data_limite"));
                servico.setDataCadastroString(result.getDate("data_cadastro").toString());
                //servico.setDataCadastro((Date)result.getDate("data_cadastro"));
                if(result.getDate("data_agendada") != null)
                    servico.setDataAgendadaString(result.getDate("data_agendada").toString());
                //servico.setDataAgendada((Date)result.getDate("data_agendada"));
                servico.setDestinatarioId(result.getInt("destinatario_id"));
                servico.setPlataformaId(result.getInt("plataforma_id"));
                servico.setFuncionarioId(result.getInt("funcionario_id"));
                servico.setStatus(result.getInt("status"));
                return servico;
            }
            else
                return servico;
        }
        catch(SQLException ex)
        {
            new Log(servico, "DAO: " + Helpers.Mensagem.ErroRecuperarServico(), ex.getMessage()).print();
            return null;
        }
        
    }
    
    public ArrayList<Servico> getAll()
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
                //servico.setDataLimite((Date)result.getDate("data_limite"));
                servico.setDataCadastroString(result.getDate("data_cadastro").toString());
                //servico.setDataCadastro((Date)result.getDate("data_cadastro"));
                Date data = result.getDate("data_agendada");
                if(data != null)
                    servico.setDataAgendadaString(data.toString());
                //servico.setDataAgendada((Date)result.getDate("data_agendada"));
                servico.setDestinatarioId(result.getInt("destinatario_id"));
                servico.setPlataformaId(result.getInt("plataforma_id"));
                servico.setFuncionarioId(result.getInt("funcionario_id"));
                servico.setStatus(result.getInt("status"));
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
    
    public int getId(Servico s)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "SELECT id FROM " + this.nomeTabela + " WHERE("
                    + "valor_total_frete = ? AND prazo_dias = ? AND data_limite = ? AND "
                    + "data_cadastro = ? AND data_agendada = ? AND destinatario_id = ? AND "
                    + "plataforma_id = ? AND funcionario_id = ?)";
            
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setDouble(1, s.getValorTotal());
            statement.setInt(2, s.getPrazoEmDias());
            Date dataSql = (Date)s.getDataLimite();
            statement.setDate(3, dataSql);
            dataSql = (Date)s.getDataCadastro();
            statement.setDate(4, dataSql);
            dataSql = (Date)s.getDataAgendada();
            statement.setDate(5, dataSql);
            statement.setInt(6, s.getDestinatarioId());
            statement.setInt(7, s.getPlataformaId());
            statement.setInt(8, s.getFuncionarioId());
            
            statement.execute();
            
            ResultSet result = statement.getResultSet();
            
            int id = -1;
            while(result.next())
                id = result.getInt("id");
            
            return id;
        }
        catch(SQLException ex)
        {
            new Log(s, "DAO: " + "Erro ao recuperar o Id do servico", ex.getMessage()).print();
            return -1;
        }
    }
    
    public boolean changeStatus(int id, int status)
    {
        try(Connection connection = ConnectionDB.getConnection())
        {
            String query = "UPDATE servico SET status = ? WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setInt(1, status);
            statement.setInt(2, id);
            
            int affectedRows = statement.executeUpdate();
            return this.affectARow(affectedRows);
        }
        catch(Exception ex)
        {
            new Log(status, "DAO: " + Helpers.Mensagem.ErroMudarStatus(), ex.getMessage()).print();
            return false;
        }
    }
    
    //retorna se alguma linha foi afetada
    private boolean affectARow(int affectedRows)
    {
        return affectedRows > 0;
    }
}