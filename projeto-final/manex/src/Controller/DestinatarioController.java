package Controller;
import DAO.DestinatarioDAO;
import Helpers.Log;
import Helpers.Verificador;
import Helpers.Mensagem;
import Models.Destinatario;
import java.util.ArrayList;

public class DestinatarioController 
{
    public static boolean cadastrar(Destinatario destinatario)
    {
        try
        {
            if(destinatario == null)
                return false;
            
            //if(!destinatario.ehValido())
                //return false;
            
            if(!Verificador.ehCPF(destinatario.getDocumento()))
                return false;
            
            DestinatarioDAO dao = new DestinatarioDAO();
            
            return dao.inserir(destinatario);
        }
        catch(Exception ex)
        {
            new Log(destinatario, Helpers.Mensagem.ErroCadastroDestinatario(), ex.getMessage()).print();
            return false;
        }
    }
    
    public static Destinatario get(String CPF)
    {
     try
        {
            if(CPF.isBlank())
                return null;
            
            if(!Verificador.ehCPF(CPF))
                return null;

            DestinatarioDAO dao = new DestinatarioDAO();
            
            return dao.get(CPF);
        }
        catch(Exception ex)
        {
            new Log(CPF, Helpers.Mensagem.ErroRecuperarDestinatario(), ex.getMessage()).print();
            return null;
        }   
    }
    
    public static Destinatario get(int id)
    {
        try
        {
            if(id <= 0)
                return null;
        
            DestinatarioDAO dao = new DestinatarioDAO();

            Destinatario destinatario = dao.get(id);

            if(destinatario != null)
                return destinatario;
            else
                return null;
        }
        catch(Exception ex)
        {
            new Log(null, Helpers.Mensagem.ErroRecuperarDestinatario(), ex.getMessage()).print();
            return null;
        }
    }
    
    public static ArrayList<Destinatario> getAll()
    {
        try
        {
            DestinatarioDAO dao = new DestinatarioDAO();
            
            return dao.getAll();
        }
        catch(Exception ex)
        {
            new Log(null, Helpers.Mensagem.ErroRecuperarListaDestinatario(), ex.getMessage()).print();
            return null;
        }
    }
    
    public static boolean editar(Destinatario destinatario, int id)
    {
        try
        {
            if(id <= 0)
                return false;
            
            if(destinatario == null)
                return false;
            
            if(!destinatario.ehValido())
                return false;
            
            if(!Verificador.ehCPF(destinatario.getDocumento()))
                return false;
            
            DestinatarioDAO dao = new DestinatarioDAO();
            
            return dao.editar(destinatario, id);
        }
        catch(Exception ex)
        {
            new Log(destinatario, Helpers.Mensagem.ErroEditarDestinatario(), ex.getMessage()).print();
            return false;
        }
    }
    
    public static boolean exlcuir(int id)
    {
        try
        {
            if(id <= 0)
                return false;
            
            DestinatarioDAO dao = new DestinatarioDAO();
            
            return dao.remover(id);
        }
        catch(Exception ex)
        {
            new Log(id, Helpers.Mensagem.ErroRemoverDestinatario(), ex.getMessage()).print();
            return false;
        }
    }
}
