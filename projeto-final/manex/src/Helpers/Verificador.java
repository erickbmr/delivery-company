package Helpers;

public class Verificador
{
    public static boolean ehCPF(String documento)
    {
        int[] cpf = converteStringVetorInt(documento);
       
        int soma = 0, index = 0;
        for(int i = 10; i > 1; i--)
        {
            soma += (cpf[index] * i);
            index++;
        }
        
        int resto = soma % 11;
        int possivelDigito;
        
        if(resto <= 1) possivelDigito = 0;       
        else possivelDigito = 11 - resto;
        
        if(!(possivelDigito == cpf[cpf.length - 2])) return false;
        
        soma = 0;
        index = 0;
        
        for(int i = 11; i > 1; i--)
        {
            soma += (cpf[index] * i);
            index++;
        }
        
        resto = soma % 11;
        
        if(resto <= 1) possivelDigito = 0;
        else possivelDigito = 11 - resto;
        
        return possivelDigito == cpf[cpf.length - 1];
    }
    
    public static boolean ehCNPJ(String documento)
    {
        int[] cnpj = converteStringVetorInt(documento);
        
        int soma = 0, inicio = 0, multiplicador = 5;
        
        for(int j = 0; j < 2; j++)
        {
            for(int i = inicio; i < cnpj.length - 2; i++)
            {
                soma += (cnpj[i] * multiplicador);
                multiplicador--;
                if(multiplicador == 1)
                {
                    inicio = 4;
                    multiplicador = 9;
                    break;
                }
            }
        }
        
        int resto = soma % 11;
        int possivelDigito;
        
        if(resto <= 1) possivelDigito = 0;       
        else possivelDigito = 11 - resto;
        
        if(!(possivelDigito == cnpj[cnpj.length - 2])) return false;
        
        soma = 0;
        inicio = 0;
        multiplicador = 6;
        
        for(int j = 0; j < 2; j++)
        {
            for(int i = inicio; i < cnpj.length - 1; i++)
            {
                soma += (cnpj[i] * multiplicador);
                multiplicador--;
                if(multiplicador == 1)
                {
                    inicio = 5;
                    multiplicador = 9;
                    break;
                }
            }
        }
        
        resto = soma % 11;
        
        if(resto <= 1) possivelDigito = 0;       
        else possivelDigito = 11 - resto;
        
        return possivelDigito == cnpj[cnpj.length - 1];
    }
    
    public static boolean isCNH(String cnh)
    {
        //TODO
        return false;
    }
    
    private static int[] converteStringVetorInt(String string)
    {
        int[] vetor = new int[string.length()];
        char num;
        
        for(int i = 0; i < string.length(); i++)
        {
            num = string.charAt(i);
            
            if(Character.isDigit(num) == true)
            {
                vetor[i] = Integer.parseInt(num + "");
            }
        }
        
        return vetor;
    }
}
