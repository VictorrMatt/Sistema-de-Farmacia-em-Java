/*
 - CLIENTE
    Cadastro para cliente: nome, endereço, telefone e idade
    Adicionar remedios ao carrinho e escolher cupom de desconto

 - FUNCIONARIO
    Editar o preço dos produtos
    Adicionar produtos
    Ter acesso ao cadastro do cliente

 - IMPLEMENTAR
    Cadastro / Login
    Produtos
    Sobre nós
    Carrinho
*/

import java.util.Scanner;
import java.lang.*;

public class Farmacia {
    public static void main (String args[]) {
        // Declaração de variaveis
        int escolha = 0;
        int escolha_sessao = 0;
        int escolha_cliente = 0;
        int escolha_funcionario = 0;
        int tamanho = 100;
        String usuario = null;
        String senha = null;
        String telefone = null;
        String cidade = null;
        String estado = null;
        String bairro = null;
        String rua = null;
        boolean cadastrado = false;
        int n=100;
        String r[] = new String[n];
        float p[] = new float[n];
        int resp_func;
        int i=0;



        // Vetores referentes aos usuarios
        String usuarios[] = new String[tamanho]; // Nome dos clientes registrados
        String senhas[] = new String[tamanho]; // Senha dos clientes registrados
        String telefones[] = new String[tamanho]; // Telefone dos clientes registrados
        String idades[] = new String[tamanho]; // Idade dos clientes registrados
        //endereco dos cadastrados
        String cidades[] = new String[tamanho]; // Cidade dos clientes registrados
        String estados[] = new String[tamanho]; // Estado dos clientes cadastrados
        String bairros[] = new String[tamanho]; // Bairro do usuario
        String ruas[] = new String[tamanho]; // Nome da rua do usuario
        //vetores referentes a farmacia
        String remedios[] = new String[tamanho]; // Remedios da farmacia
        float preco[] = new float[tamanho]; // Preco dos remedios
        int quant[] = new int[tamanho]; // Colocação dos remedios

        Scanner caractere = new Scanner(System.in);
        Scanner inteiro = new Scanner(System.in);
        Scanner real = new Scanner(System.in);

        // Boas vindas
        System.out.println("\n\t\t\t\t== DROGARIA BOAS DROGAS ==");
        System.out.println("\t\t\tOLA CLIENTE AMIGO, seja MUITO BEM \n\t\t   VINDO ao nosso SISTEMA FARMACEUTICO!\n");

        do {
            // Mostrando prints situacionais
            if (escolha_sessao == 0) {
                System.out.println("Digite o NUMERO que corresponde ao seu ESTADO.");
            } else {
                System.out.println("\nDigite o NUMERO que corresponde ao seu ESTADO.");
            }
            System.out.print(" 1 -> Sou CLIENTE\n 2 -> Sou FUNCIONARIO\n 3 -> Quero SAIR do SISTEMA\nEscolha: ");
            escolha_sessao = inteiro.nextInt(); // Entrada do usuario

            switch (escolha_sessao) {
                // Cliente
                case 1:
                    do {
                        System.out.println("\nDigite o NUMERO que corresponde a sua ACAO DESEJADA."); // Instruções
                        System.out.print(" 1 -> CADASTRAR / LOGAR\n 2 -> LISTA de PRODUTOS\n 3 -> SOBRE NOS\n 4 -> VOLTAR ao MENU PRINCIPAL \nEscolha: ");
                        escolha_cliente = inteiro.nextInt(); // Entrada do cliente

                        switch (escolha_cliente) {
                            case 1: // Cadastrar / Logar
                                while (true) {
                                    cadastrado = false; // Reiniciando variavel
                                    System.out.println("\nPOR FAVOR, nos informe os seus DADOS.");

                                    // Entrada do usuario com filtragem do dado
                                    usuario = " ";
                                    while (usuario.length() <= 3) {
                                        System.out.print("USUARIO: ");
                                        usuario = caractere.nextLine();

                                        if (usuario.length() <= 3) {
                                            System.out.println("AVISO, USUARIOS devem conter 3 CARACTERES ou MAIS!");
                                        }
                                    }

                                    // Entrada da senha com filtragem do dado
                                    senha = " ";
                                    while (senha.length() <= 3) {
                                        System.out.print("SENHA: ");
                                        senha = caractere.nextLine();

                                        if (senha.length() <= 3) {
                                            System.out.println("AVISO, SENHAS devem conter 3 CARACTERES ou MAIS!");
                                        }
                                    }

                                    telefone = " ";
                                    while (telefone.length() <= 8)
                                    {
                                        System.out.print("NUMERO: ");
                                        telefone = caractere.nextLine();

                                        if (telefone.length() <= 8)
                                        {
                                            System.out.println("AVISO!\n\nDados incorretos\nexemplo de numero\n(xx)91234-5678");
                                        }
                                    }

                                    estado = " ";
                                    while (estado.length() <= 2)
                                    {
                                        System.out.print("ESTADO: ");
                                        estado = caractere.nextLine();

                                        if (estado.length() <= 2)
                                        {
                                            System.out.println("AVISO!\n\nNumero de caracteres invalidos");
                                        }
                                    }

                                    cidade = " ";
                                    while (cidade.length() <= 1)
                                    {
                                        System.out.print("CIDADE: ");
                                        cidade = caractere.nextLine();

                                        if (cidade.length() <= 1)
                                        {
                                            System.out.println("AVISO!\n\nNumero de caracteres invalidos");
                                        }
                                    }

                                    bairro= " ";
                                    while (bairro.length() <= 1)
                                    {
                                        System.out.print("BAIRRO: ");
                                        bairro = caractere.nextLine();

                                        if (bairro.length() <= 1)
                                        {
                                            System.out.println("AVISO!\n\nNumero de caracteres invalidos");
                                        }
                                    }


                                    rua= " ";
                                    while (rua.length() <= 1)
                                    {
                                        System.out.print("RUA: ");
                                        rua = caractere.nextLine();

                                        if (rua.length() <= 1)
                                        {
                                            System.out.println("AVISO!\n\nNumero de caracteres invalidos");
                                        }
                                    }

                                    // Verificando se dados constam no sistema
                                    for (int c = 0; c < tamanho; c++) {
                                        if (usuario.equals(usuarios[c]) && senha.equals(senhas[c]) && telefone.equals(telefones[c]) && cidade.equals(cidades[c]) && bairro.equals(bairros[c]) && rua.equals(ruas[c])) {
                                            cadastrado = true;
                                        }
                                    }

                                    // Feedback para estado do cadastro
                                    if (cadastrado == false) {
                                        // CADASTRO DO USUARIO
                                        System.out.println("\nDeseja CADASTRAR os seguintes DADOS no SISTEMA?");
                                        System.out.println("-------------------------------------------------");
                                        // Dados do usuario

                                        System.out.println("  USUARIO: " + usuario + "\t|\tSENHA: " + senha + "\t|\tTELEFONE: " + telefones);
                                        System.out.println("-------------------------------------------------");
                                        System.out.println("ENDERECO:\n");

                                        escolha = 0;
                                        System.out.print(" 1 -> SIM, CADASTRAR\n 2 -> NAO, DIGITAR NOVAMENTE\n 3 -> VOLTAR ao MENU\nEscolha: ");
                                        escolha = inteiro.nextInt();

                                        switch (escolha) {
                                            case 1:
                                                usuarios[0] = usuario;
                                                senhas[0] = senha;
                                                System.out.println("-------------------------------------------------");
                                                System.out.println("\t\t   == CADASTRADO com SUCESSO! ==");
                                                cadastrado = true;
                                                break;

                                            case 2:
                                                break;
                                        }
                                        break;
                                    } else {
                                        System.out.println("\n-------------------------------------------------");
                                        System.out.println("\t   Ola " + usuario + ", Seja BEM VINDO de VOLTA!");
                                        break;
                                    }
                                }

                            case 2: // Produtos
                                System.out.println("Produtos--|||--Preco---|||---Desconto-----\n");
                                for(i=0; i<tamanho; i++) {
                                    System.out.println((i+1) + "- "+r[i] +" R$" + p[i]);

                                }
                                System.out.print("\n----------------------------------------------------------");
                                break;

                            case 3: // Sobre nós
                                break;
                        }
                    } while (escolha_cliente != 4);
                    break;

                // Funcionario
                case 2:
                    do {
                        System.out.println("\nDigite o NUMERO que corresponde a sua ACAO DESEJADA."); // Instruções
                        System.out.print(" 1 -> ADICIONAR REMEDIOS\n 2 -> EDITAR o NOME / PRECO dos PRODUTOS\n 3 -> ACESSAR CADASTROS\n 4 -> LUCRO TOTAL\n 5 -> VOLTAR ao MENU PRINCIPAL \nEscolha: ");
                        escolha_funcionario = inteiro.nextInt(); // Entrada do funcionario

                        switch (escolha_funcionario) {
                            case 1: // adicionar remedios na farmacia

                                System.out.println("Quantos produtos voce deseja adicionar?");
                                tamanho = inteiro.nextInt();
                                for(i=0; i<tamanho; i++) {
                                    System.out.println("Nome do remedio:");
                                    r[i] = caractere.nextLine();

                                    System.out.println("Preco do " + r[i]);
                                    p[i] = real.nextFloat();
                                }
                                for(i=0; i<tamanho; i++) {
                                    System.out.println(r[i] +" R$" + p[i]+"\nFoi adicionado");
                                }
                                break;

                            case 2: // Editar o preço dos produtos
                                break;

                            case 3: // Acesso ao cadastro dos clientes
                                System.out.println("");
                                break;

                            case 4: // Lucro total
                                break;
                        }
                    } while (escolha_funcionario != 5);
                    break;
            }
        } while (escolha_sessao != 3);
        System.out.println("\n-------------------------------------------------");
        System.out.println("    AGRADECIDOS por CONFIAR no NOSSO SISTEMA!"); // Despedidas
    }
}	
