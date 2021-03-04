package Controller;
import DAO.ItemDAO;
import Helpers.Log;
import Models.Item;
import java.util.ArrayList;

public class ItemController 
{
    public static boolean cadastrar(Item item)
    {
        try
        {
            if(item == null)
                return false;
            
            if(!item.ehValido())
                return false;
            
            ItemDAO dao = new ItemDAO();
            
            return dao.inserir(item);
        }
        catch(Exception ex)
        {
            new Log(item, Helpers.Mensagem.ErroCadastroItem(), ex.getMessage()).print();
            return false;
        }
    }
    
    public static Item get(int id)
    {
        try
        {
            if(id <= 0)
                return null;
            
            ItemDAO dao = new ItemDAO();
            
            Item item = dao.get(id);
            
            if(item != null)
                return item;
            else
                return null;
        }
        catch(Exception ex)
        {
            new Log(id, Helpers.Mensagem.ErroRecuperarItem(), ex.getMessage()).print();
            return null;
        }
    }
    
    public static ArrayList<Item> getAll()
    {
        try
        {
            ItemDAO dao = new ItemDAO();
            
            return dao.getAll();
        }
        catch(Exception ex)
        {
            new Log(null, Helpers.Mensagem.ErroRecuperarListaItem(), ex.getMessage()).print();
            return null;
        }
    }
    
    public static boolean editar(Item item, int id)
    {
        try
        {
            if(id <= 0)
                return false;
            
            if(item == null)
                return false;
            
            if(!item.ehValido())
                return false;
            
            ItemDAO dao = new ItemDAO();
            
            return dao.editar(item, id);
        }
        catch(Exception ex)
        {
            new Log(item, Helpers.Mensagem.ErroEditarItem(), ex.getMessage()).print();
            return false;
        }
    }
    
    public static boolean excluir(int id)
    {
        try
        {
            if(id <= 0)
                return false;
            
            ItemDAO dao = new ItemDAO();
            
            return dao.remover(id);
        }
        catch(Exception ex)
        {
            new Log(id, Helpers.Mensagem.ErroRemoverItem(), ex.getMessage()).print();
            return false;
        }
    }
}
