package Helpers;

public class UnidadeFederativa 
{
    public static String getUF(String estado)
    {
        switch(estado)
        {
            case "Minas Gerais": return "MG";
            
            case "São Paulo": return "SP";
            
            case "Rio de Janeiro": return "RJ";
            
            //TODO
            
            default: return "BR";
        }
    }
    
    public static String getEstado(String uf)
    {
        switch(uf)
        {
            case "MG": return "Minas Gerais";
            
            case "SP": return "São Paulo";
            
            case "RJ": return "Rio de Janeiro";
            
            //TODO
            
            default: return "Brasil";
        }
    }
}
