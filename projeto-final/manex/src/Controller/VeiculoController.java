package Controller;
import DAO.VeiculoDAO;
import Helpers.Log;
import Models.Veiculo;
import java.util.ArrayList;

public class VeiculoController 
{
    public static boolean cadastrar(Veiculo veiculo)
    {
        try
        {
            if(veiculo == null)
                return false;
            
            if(!veiculo.ehValido())
                return false;
            
            VeiculoDAO dao = new VeiculoDAO();
            
            return dao.inserir(veiculo);
        }
        catch(Exception ex)
        {
            new Log(veiculo, Helpers.Mensagem.ErroCadastroVeiculo(), ex.getMessage()).print();
            return false;
        }
    }
    
    public static Veiculo get(int id)
    {
        try
        {
            if(id <= 0)
                return null;
            
            VeiculoDAO dao = new VeiculoDAO();
            
            Veiculo veiculo = dao.get(id);
            
            if(veiculo != null)
                return veiculo;
            else
                return null;
        }
        catch(Exception ex)
        {
            new Log(id, Helpers.Mensagem.ErroRecuperarVeiculo(), ex.getMessage()).print();
            return null;
        }
    }
    
    public static ArrayList<Veiculo> getAll()
    {
        try
        {
            VeiculoDAO dao = new VeiculoDAO();
            
            return dao.getAll();
        }
        catch(Exception ex)
        {
            new Log(null, Helpers.Mensagem.ErroRecuperarListaVeiculo(), ex.getMessage()).print();
            return null;
        }
    }
    
    public static boolean editar(Veiculo veiculo, int id)
    {
        try
        {
            if(id <= 0)
                return false;
            
            if(veiculo == null)
                return false;
            
            if(!veiculo.ehValido())
                return false;
            
            VeiculoDAO dao = new VeiculoDAO();
            
            return dao.editar(veiculo, id);
        }
        catch(Exception ex)
        {
            new Log(veiculo, Helpers.Mensagem.ErroEditarVeiculo(), ex.getMessage()).print();
            return false;
        }
    }
    
    public static boolean excluir(int id)
    {
        try
        {
            if(id <= 0)
                return false;
            
            VeiculoDAO dao = new VeiculoDAO();
            
            return dao.remover(id);
        }
        catch(Exception ex)
        {
            new Log(id, Helpers.Mensagem.ErroRemoverVeiculo(), ex.getMessage()).print();
            return false;
        }
    }
}
