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
        try
        {
            if(id <= 0)
                return null;
            
            PlataformaDAO dao = new PlataformaDAO();
            
            PlataformaCliente plataforma = dao.get(id);
            
            if(plataforma != null)
                return plataforma;
            else
                return null;
        }
        catch(Exception ex)
        {
            new Log(id, Helpers.Mensagem.ErroRecuperarPlataforma(), ex.getMessage()).print();
            return null;
        }
    }
    
    public static ArrayList<PlataformaCliente> getAll()
    {
        try
        {
            PlataformaDAO dao = new PlataformaDAO();
            
            return dao.getAll();
        }
        catch(Exception ex)
        {
            new Log(null, Helpers.Mensagem.ErroRecuperarListaPlataforma(), ex.getMessage()).print();
            return null;
        }
    }
    
    public static boolean editar(PlataformaCliente plataforma, int id)
    {
        try
        {
            if(id <= 0)
                return false;
            
            if(plataforma == null)
                return false;
            
            if(!plataforma.ehValido())
                return false;
            
            if(!Verificador.ehCNPJ(plataforma.getDocumento()))
                return false;
            
            PlataformaDAO dao = new PlataformaDAO();
            
            return dao.editar(plataforma, id);
        }
        catch(Exception ex)
        {
            new Log(plataforma, Helpers.Mensagem.ErroEditarPlataforma(), ex.getMessage()).print();
            return false;
        }
    }
    
    public static boolean excluir(int id)
    {
        try
        {
            if(id <= 0)
                return false;
            
            PlataformaDAO dao = new PlataformaDAO();
            
            return dao.remover(id);
        }
        catch(Exception ex)
        {
            new Log(id, Helpers.Mensagem.ErroRemoverPlataforma(), ex.getMessage()).print();
            return false;
        }
    }
    
    public static PlataformaCliente get(String CNPJ)
    {
        try
        {
            if(!Verificador.ehCNPJ(CNPJ))
                return null;
            else
            {
                PlataformaDAO dao = new PlataformaDAO();
                return dao.get(CNPJ);
            }
        }
        catch(Exception ex)
        {
            new Log(CNPJ, Helpers.Mensagem.ErroRecuperarPlataforma(), ex.getMessage()).print();
            return null;
        }
    }
}
