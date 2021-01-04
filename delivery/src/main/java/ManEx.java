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
    
    public static Item cadastraItem()
    {
        Scanner input = new Scanner(System.in);
        Item novoItem = null;
        
        try
        {
            System.out.print("Insira o código do item: ");
            int codigo = input.nextInt();

            System.out.print("O item é frágil? (1)Sim (2)Não\nOpção: ");
            int fragil = input.nextInt();

            while(fragil < 1 || fragil > 2)
            {
                System.out.print("O item é frágil? (1)Sim (2)Não\nOpção: ");
                fragil = input.nextInt();
            }

            boolean ehFragil;

            if(fragil == 1) ehFragil = true;
            else ehFragil = false;

            System.out.print("Insira o volume do produto: ");
            double volume = input.nextDouble();

            System.out.print("Insira o valor do produto: ");
            double valor = input.nextDouble();

            input.skip("\n");
            
            System.out.println("Insira a descricao desse produto: ");
            String descricao = input.nextLine();

            novoItem = new Item(codigo, descricao, ehFragil, volume, valor);
            
            if(!descricao.isEmpty()) FakeBanco.insereItem(novoItem);
            else System.err.println("O campo de descricao deve ser preenchido");
            
            return novoItem;
        }
        catch(InputMismatchException ex)
        {
            System.err.println("O código, volume e valor devem ser numéricos.");
        }
        
        return null;
    }
    
    public static Plataforma cadastraPlataforma()
    {
        Scanner input = new Scanner(System.in);
        Plataforma novaPlataforma = null;
        
        try
        {
            //TODO
            
            FakeBanco.inserePlataforma(novaPlataforma);
            
            return novaPlataforma;
        }
        catch(InputMismatchException ex)
        {
            System.err.println("");
        }
        
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

            System.out.print("Insira o cep do destinatario: ");
            String cep = input.nextLine();

            System.out.print("Insira o bairro do destinatario: ");
            String bairro = input.nextLine();

            System.out.print("Insira o estado do destinatario: ");
            String estado = input.nextLine();

            System.out.print("Insira o telefone do destinatario: ");
            String telefone = input.nextLine();

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

            if(!nome.isEmpty() && !documento.isEmpty() && !rua.isEmpty()
                    && !cep.isEmpty() && !bairro.isEmpty() && !estado.isEmpty())
                FakeBanco.insereDestinatario(novoDestinatario);
            else System.err.println("Todos os campos devem ser preenchidos.");
            
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
        
        //RequisicaoServico novaRequisicao = new RequisicaoServico();
        
        System.out.print("Para começar, insira o seu CNPJ: ");
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

        System.out.print("Insira o CPF do destinatario: ");
        String cpf = input.nextLine();
        
        while(!(cpf.length() == 11 
                    && cpf.matches("[0-9]+")
                    && ehCPF(cpf)))
        {
            System.out.print("O documento deve conter 11 numeros e deve ser valido: ");
            cpf = input.nextLine();
        }
        
        Destinatario destinatario = FakeBanco.recuperaDestinatario(cpf);
        
        if(destinatario == null)
        {
            System.out.println("Destinatario não encontrado, cadastre para continuar.");
            destinatario = cadastraDestinatario();
        }
        
        RequisicaoServico novaRequisicao = new RequisicaoServico(destinatario, plataforma);
        
        //realizar adicao de itens na requisicao de servico
        String opcao = "y";
        while(opcao.equalsIgnoreCase("y"))
        {
            System.out.println("Adicione os itens...");
            novaRequisicao.addItem(cadastraItem());
            System.out.print("Deseja adicionar outro item ? y/n: ");
            opcao = input.nextLine();
            if(!(opcao.equalsIgnoreCase("y") || opcao.equalsIgnoreCase("n")))
            {
                System.out.print("Opção inválida. \nDeseja adicionar outro item? y/n: ");
                opcao = input.nextLine();
            }
        }

        //inserir a requisicao no banco
        
    }
    
    public static void main(String[] args) 
    {
        FakeBanco.carregarInfo();
        
        cadastraRequisicaoServico();
        
        //if(ehCNPJ("02391962000144")) System.out.println("true");
        //else System.out.println("false");
        
        //RequisicaoServico novaRequisicao = new RequisicaoServico();
        //novaRequisicao.setDataLimite(5);

    }
}