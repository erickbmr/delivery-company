import java.util.InputMismatchException;
import java.util.Scanner;

public class ManEx 
{   
    public static int[] converteStringVetorInt(String string)
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
    
    public static boolean ehCNPJ(String documento)
    {
        int[] cnpj = converteStringVetorInt(documento);
        
        int soma = 0, index = 0, inicio = 0, multiplicador = 5;
        
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
        
        if(!(possivelDigito == cnpj[cnpj.length - 1])) return false;
        
        return true;
    }
    
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
        
        if(!(possivelDigito == cpf[cpf.length - 1])) return false;
        
        return true;
    }
    
    public static void cadastraItem()
    {
        
    }
    
    public static Plataforma cadastraPlataforma()
    {
        
        return null;
    }
    
    public static Destinatario cadastraDestinatario()
    {
        Scanner input = new Scanner(System.in);
        
        try
        {
            System.out.print("Informe o nome do destinatario: ");
            String nome = input.nextLine();

            System.out.print("Insira o documento do destinatario: ");
            String documento = input.nextLine();
            
            while(!(documento.length() == 11 
                    && documento.matches("[0-9]+")
                    && ehCPF(documento)))
            {
                System.out.print("O documento deve conter 11 numeros e deve ser valido: ");
                documento = input.nextLine();
            }

            System.out.print("Insira a rua do destinatario: ");
            String rua = input.nextLine();
            input.skip("\n");

            System.out.print("Insira o cep do destinatario: ");
            String cep = input.nextLine();

            System.out.print("Insira o bairro do destinatario: ");
            String bairro = input.nextLine();
            input.skip("\n");

            System.out.print("Insira o estado do destinatario: ");
            String estado = input.nextLine();

            System.out.print("Insira o telefone do destinatario: ");
            String telefone = input.nextLine();
            input.skip("\n");

            while(!(telefone.length() >= 8 
                    && telefone.length() <= 13 
                    && telefone.matches("[0-9]+")))
            {
                System.out.print("O telefone deve conter apenas numeros e possuir entre 8 e 13 digitos: ");
                telefone = input.nextLine();
            }
            
            System.out.print("Insira o numero do destinatario: ");
            int numero = input.nextInt();

            Destinatario novoDestinatario = new Destinatario(
                    nome, documento, rua, cep, bairro, estado, telefone, numero
            );

            FakeBanco.insereDestinatario(novoDestinatario);

            return novoDestinatario;

        }
        catch(InputMismatchException ex)
        {
            System.err.println("O numero da casa é invalido.");
            input = new Scanner(System.in);
        }
        
        return null;
    }
    
    public static void cadastraFuncionario()
    {
        
    }
    
    public static void cadastraVeiculo()
    {
        
    }
    
    public static void cadastraRequisicaoServico()
    {
        Scanner input = new Scanner(System.in);
        
        RequisicaoServico novaRequisicao = new RequisicaoServico();
        
        System.out.print("Insira o seu CNPJ: ");
        String cnpj = input.nextLine();
        
        while(!(cnpj.length() == 14 
                    && cnpj.matches("[0-9]+")
                    && ehCNPJ(cnpj)))
        {
            System.out.print("O CNPJ deve conter 14 digitos numericos e deve ser valido: ");
            cnpj = input.nextLine();
        }
        
        Plataforma plataforma = FakeBanco.recuperaPlataforma(cnpj);
            
        if(plataforma == null)
        {
            System.out.println("Plataforma não cadastrada. Cadastre para continuar.");
            plataforma = cadastraPlataforma();
        }
        
        System.out.println("(1)Usar destinatario existente.\n(2)Cadastrar novo destinatario.");
        System.out.print("Opção: ");
        int opcao = input.nextInt();

        while(opcao > 2 || opcao < 1)
        {
            System.out.println("Opção inválida. (1)Destinatario existente\n(2)Cadastrar destinatario.");
            System.out.print("Opção: ");
            opcao = input.nextInt();
        }

        input.skip("\n");

        if(opcao == 1)
        {
            //destinatario existente
            System.out.print("Insira o documento do destinatario: ");
            String documento = input.nextLine();

            while(!(documento.length() == 11 
                && documento.matches("[0-9]+")
                && ehCPF(documento)))
            {
                System.out.print("O documento deve conter 11 numeros e deve ser valido: ");
                documento = input.nextLine();
            }

            Destinatario destinatario = FakeBanco.recuperaDestinatario(documento);

            if(destinatario == null)
            {
                System.out.println("Destinatario não cadastrado. Cadastre para continuar.");
                destinatario = cadastraDestinatario();
            }
        }
        else
        {
            //cadastro de destinatario
            Destinatario destinatario = cadastraDestinatario();
        }

        //realizar adicao de itens no servico
        
        //inserir a requisicao no banco
        
    }
    
    public static void main(String[] args) 
    {
        //FakeBanco.carregarInfo();
        
        //cadastraRequisicaoServico();
        
        //if(ehCNPJ("02391962000144")) System.out.println("true");
        //else System.out.println("false");
    }
}
