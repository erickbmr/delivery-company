package Controller;
import Helpers.Verificador;
import Models.Destinatario;

public class DestinatarioController 
{
    public boolean cadastrar(Destinatario destinatario)
    {
        try
        {
            if(destinatario == null)
                return false;
            
            if(!Verificador.ehCPF(destinatario.getDocumento()))
            {
                //nao eh um cpf valido
            }
            
            return true;
        }
        catch(Exception ex)
        {
            System.err.println("Create(): " + ex.getMessage());
            return false;
        }
    }
}
