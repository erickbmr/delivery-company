package Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB 
{
    private static final String postgresUrl = "jdbc:postgresql://localhost:5432/managerdb";
    private static final String user = "postgres";
    private static final String password = "admindb";
    private static Connection connection;
    
    public static Connection getConnection()
    {
        try
        {
            if(connection == null || connection.isClosed())
                connection = DriverManager.getConnection(postgresUrl, user, password);

            return connection;
        }
        catch(SQLException ex)
        {
            System.err.println("Conexao com BD não estabelecida. Message: " + ex.getMessage());
        }
        return null;
    }
    
}
