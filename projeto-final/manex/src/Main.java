import DAO.DepositoDAO;
import Data.ConnectionDB;
import Models.Deposito;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

           
        Deposito d = new Deposito("Rua 1", "2", 70, "36400000", "MG", 1500);
        
        DepositoDAO dao = new DepositoDAO();
        
        System.out.println(dao.remover(d));
        
    }
}
