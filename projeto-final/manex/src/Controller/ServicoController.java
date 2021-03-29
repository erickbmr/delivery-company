package Controller;
import DAO.ServicoDAO;
import Helpers.Log;
import Models.Servico;
import java.util.ArrayList;

public class ServicoController 
{
    public static boolean cadastrar(Servico servico)
    {
        try
        {
            if(servico == null)
                return false;
            //if(!servico.ehValido())
                //return false;
            
            ServicoDAO dao = new ServicoDAO();
            
            return dao.inserir(servico);
        }
        catch(Exception ex)
        {
            new Log(servico, Helpers.Mensagem.ErroCadastroServico(), ex.getMessage()).print();
            return false;
        }
    }
    
    public static Servico get(int id)
    {
        try
        {
            if(id <= 0)
                return null;
            
            ServicoDAO dao = new ServicoDAO();
            
            Servico servico = dao.get(id);
            
            if(servico != null)
                return servico;
            else
                return null;
        }
        catch(Exception ex)
        {
            new Log(id, Helpers.Mensagem.ErroRecuperarServico(), ex.getMessage()).print();
            return null;
        }
    }
    
    public static ArrayList<Servico> getAll()
    {
        try
        {
            
            ServicoDAO dao = new ServicoDAO();
            
            return dao.getAll();
        }
        catch(Exception ex)
        {
            new Log(null, Helpers.Mensagem.ErroRecuperarListaServico(), ex.getMessage()).print();
            return null;
        }
    }
    
    public static boolean editar(Servico servico, int id)
    {
        try
        {
            if(id <= 0)
                return false;
            
            if(servico == null)
                return false;
            
            if(!servico.ehValido())
                return false;
            
            ServicoDAO dao = new ServicoDAO();
            
            return dao.editar(servico, id);
        }
        catch(Exception ex)
        {
            new Log(servico, Helpers.Mensagem.ErroEditarServico(), ex.getMessage()).print();
            return false;
        }
    }
    
    public static boolean excluir(int id)
    {
        try
        {
            if(id <= 0)
                return false;
            
            ServicoDAO dao = new ServicoDAO();
            
            return dao.remover(id);
        }
        catch(Exception ex)
        {
            new Log(id, Helpers.Mensagem.ErroRemoverServico(), ex.getMessage()).print();
            return false;
        }
    }
    
    public static boolean changeStatus(int id, int status)
    {
        try
        {
            if(id <= 0 || status <= 0)
                return false;
            
            ServicoDAO dao = new ServicoDAO();
            
            return dao.changeStatus(id, status);
        }
        catch(Exception ex)
        {
            new Log(id, Helpers.Mensagem.ErroMudarStatus(), ex.getMessage()).print();
            return false;
        }
    }
}
