import Controller.ServicoController;
import DAO.PlataformaDAO;
import Data.ConnectionDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception {

        
        PlataformaDAO dao = new PlataformaDAO();
        dao.get("62196263000175");
    }
}
