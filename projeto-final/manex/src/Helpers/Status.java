
package Helpers;

/**
 *1 - Postado recentemente, 2 - Em alocação, 3 - Em rota de entrega, 4 - Entregue, 5 - Problema
 */
public class Status 
{
    public static int getIdStatus(String status)
    {
        switch(status)
        {
            case "Postado recentemente": return 1;
            case "Em alocação": return 2;
            case "Em rota de entrega": return 3;
            case "Entregue": return 4;
            case "Problema": return 5;
            default: return 0;
        }
    }
    
    public static String getStatus(int id)
    {
        switch(id)
        {
            case 1: return "Postado recentemente";
            case 2: return "Em alocação";
            case 3: return "Em rota de entrega";
            case 4: return "Entregue";
            case 5: return "Problema";
            default: return null;
        }
    }
}
