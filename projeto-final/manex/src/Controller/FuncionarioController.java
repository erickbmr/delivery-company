package Controller;
import DAO.FuncionarioDAO;
import Helpers.Log;
import Helpers.Verificador;
import Models.Funcionario;
import java.util.ArrayList;

public class FuncionarioController 
{
    public static boolean cadastrar(Funcionario funcionario)
    {
        try
        {
            if(funcionario == null)
                return false;
            
            if(!funcionario.ehValido())
                return false;
            
            if(!Verificador.ehCNH(funcionario.getCnh()))
                return false;
            
            FuncionarioDAO dao = new FuncionarioDAO();
            
            return dao.inserir(funcionario);
        }
        catch(Exception ex)
        {
            new Log(funcionario, Helpers.Mensagem.ErroCadastroFuncionario(), ex.getMessage()).print();
            return false;
        }
    }
    
    public static Funcionario get(int id)
    {
        try
        {
            if(id <= 0)
                return null;
            
            FuncionarioDAO dao = new FuncionarioDAO();
            
            Funcionario funcionario = dao.get(id);
            
            if(funcionario != null)
                return funcionario;
            else
                return null;
        }
        catch(Exception ex)
        {
            new Log(id, Helpers.Mensagem.ErroRecuperarFuncionario(), ex.getMessage()).print();
            return null;
        }
    }
    
    public static ArrayList<Funcionario> getAll()
    {
        try
        {
            FuncionarioDAO dao = new FuncionarioDAO();
            
            return dao.getAll();
        }
        catch(Exception ex)
        {
            new Log(null, Helpers.Mensagem.ErroRecuperarFuncionario(), ex.getMessage()).print();
            return null;
        }
    }
    
    public static boolean editar(Funcionario funcionario, int id)
    {
        try
        {
            if(id <= 0)
                return false;
            
            if(funcionario == null)
                return false;
            
            if(!funcionario.ehValido())
                return false;
            
            if(!Verificador.ehCNH(funcionario.getCnh()))
                return false;
            
            FuncionarioDAO dao = new FuncionarioDAO();
            
            return dao.editar(funcionario, id);
        }
        catch(Exception ex)
        {
            new Log(funcionario, Helpers.Mensagem.ErroEditarFuncionario(), ex.getMessage()).print();
            return false;
        }
    }
    
    public static boolean excluir(int id)
    {
        try
        {
            if(id <= 0)
                return false;
            
            FuncionarioDAO dao = new FuncionarioDAO();
            
            return dao.remover(id);
        }
        catch(Exception ex)
        {
            new Log(id, Helpers.Mensagem.ErroRemoverFuncionario(), ex.getMessage()).print();
            return false;
        }
    }
}
