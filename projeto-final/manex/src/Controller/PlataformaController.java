package Controller;
import DAO.PlataformaDAO;
import Helpers.Log;
import Helpers.Verificador;
import Models.PlataformaCliente;
import java.util.ArrayList;

public class PlataformaController 
{
    public static boolean cadastrar(PlataformaCliente plataforma)
    {
        try
        {
            if(plataforma == null)
                return false;
            
            if(!plataforma.ehValido())
                return false;
            
            if(!Verificador.ehCNPJ(plataforma.getDocumento()))
                return false;
            
            PlataformaDAO dao = new PlataformaDAO();
            
            return dao.inserir(plataforma);
        }
        catch(Exception ex)
        {
            new Log(plataforma, Helpers.Mensagem.ErroCadastroPlataforma(), ex.getMessage()).print();
            return false;
        }
    }
    
    public static PlataformaCliente get(int id)
    {
        
        return null;
    }
    
    public static ArrayList<PlataformaCliente> getAll()
    {
        
        return null;
    }
    
    public static boolean editar(PlataformaCliente plataforma, int id)
    {
        
        return false;
    }
    
    public static boolean excluir(int id)
    {
        
        return false;
    }
}
