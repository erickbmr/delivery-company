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
        
        return null;
    }
    
    public static ArrayList<Item> getAll()
    {
        
        return null;
    }
    
    public static boolean editar(Item item, int id)
    {
        
        return false;
    }
    
    public static boolean excluir(int id)
    {
        
        return false;
    }
}
