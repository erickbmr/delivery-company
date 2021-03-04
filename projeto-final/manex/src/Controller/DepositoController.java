package Controller;
import DAO.DepositoDAO;
import Helpers.Log;
import Models.Deposito;
import java.util.ArrayList;

public class DepositoController 
{
    public static boolean cadastrar(Deposito deposito)
    {
        try
        {
            if(deposito == null)
                return false;
            
            if(!deposito.ehValido())
                return false;
            
            DepositoDAO dao = new DepositoDAO();
            
            return dao.inserir(deposito);
        }
        catch(Exception ex)
        {
            new Log(deposito, Helpers.Mensagem.ErroCadastroDeposito(), ex.getMessage()).print();
            return false;
        }
    }
    
    public static Deposito get(int id)
    {
        try
        {
            if(id <= 0)
                return null;
            
            DepositoDAO dao = new DepositoDAO();
            
            Deposito deposito = dao.get(id);
            
            if(deposito != null)
                return deposito;
            else
                return null;
        }
        catch(Exception ex)
        {
            new Log(id, Helpers.Mensagem.ErroRecuperarDeposito(), ex.getMessage()).print();
            return null;
        }
    }
    
    public static ArrayList<Deposito> getAll()
    {
        try
        {
            DepositoDAO dao = new DepositoDAO();
            
            return dao.getAll();
        }
        catch(Exception ex)
        {
            new Log(null, Helpers.Mensagem.ErroRecuperarDeposito(), ex.getMessage()).print();
            return null;
        }
    }
    
    public static boolean editar(Deposito deposito, int id)
    {
        try
        {
            if(id <= 0)
                return false;

            if(deposito == null)
                return false;

            if(!deposito.ehValido())
                return false;
    
            DepositoDAO dao = new DepositoDAO();
            
            return dao.editar(deposito, id);
        }
        catch(Exception ex)
        {
            new Log(deposito, Helpers.Mensagem.ErroEditarDeposito(), ex.getMessage()).print();
            return false;
        }
    }
    
    public static boolean excluir(int id)
    {
        try
        {
            if(id <= 0)
                return false;
            
            DepositoDAO dao = new DepositoDAO();
            
            return dao.remover(id);
        }
        catch(Exception ex)
        {
            new Log(id, Helpers.Mensagem.ErroRemoverDeposito(), ex.getMessage()).print();
            return false;
        }
    }
}
