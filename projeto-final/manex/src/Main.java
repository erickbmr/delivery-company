import DAO.DepositoDAO;
import Data.ConnectionDB;
import Models.Deposito;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception {

           
        Deposito d = new Deposito("Rua 1", "2", 170, "36400000", "MG", 1500);
        
        DepositoDAO dao = new DepositoDAO();
        
        //dao.inserir(d);
        //Connection connection = ConnectionDB.getConnection();
        //System.out.println(dao.getId(d, connection));
        
        //dao.remover(d);
        
    }
}
