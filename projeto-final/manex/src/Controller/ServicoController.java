package Controller;
import Helpers.Log;
import Models.Servico;
import java.util.ArrayList;

public class ServicoController 
{
    public static boolean cadastrar(Servico servico)
    {
        try
        {
            return false;
        }
        catch(Exception ex)
        {
            new Log(servico, Helpers.Mensagem.ErroCadastroServico(), ex.getMessage()).print();
            return false;
        }
    }
    
    public static Servico get(int id)
    {
        
        return null;
    }
    
    public static ArrayList<Servico> getAll()
    {
        
        return null;
    }
    
    public static boolean editar(Servico servico, int id)
    {
        
        return false;
    }
    
    public static boolean excluir(int id)
    {
        
        return false;
    }
}
