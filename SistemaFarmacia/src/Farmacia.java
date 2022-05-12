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
        boolean cadastrado = false;

        // Vetores
        String usuarios[] = new String[tamanho]; // Nome dos clientes registrados
        String enderecos[] = new String[tamanho]; // Endereço dos clientes registrados
        String telefones[] = new String[tamanho]; // Telefone dos clientes registrados
        String idades[] = new String[tamanho]; // Idade dos clientes registrados
        String senhas[] = new String[tamanho]; // Senha dos clientes registrados

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
                        System.out.print(" 1 -> CADASTRAR / LOGAR\n 2 -> LISTA de PRODUTOS\n 3 -> COMPRAR\n 4 -> CARRINHO\n 5 -> SOBRE NOS\n 6 -> VOLTAR ao MENU PRINCIPAL \nEscolha: ");
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

                                    // Verificando se dados constam no sistema
                                    for (int c = 0; c < tamanho; c++) {
                                        if (usuario.equals(usuarios[c]) && senha.equals(senhas[c])) {
                                            cadastrado = true;
                                        }
                                    }

                                    // Feedback para estado do cadastro
                                    if (cadastrado == false) {
                                        // CADASTRO DO USUARIO
                                        System.out.println("\nDeseja CADASTRAR os seguintes DADOS no SISTEMA?");
                                        System.out.println("-------------------------------------------------");
                                        System.out.println("  USUARIO: " + usuario + "\t\t|\t\t\tSENHA: " + senha); // Dados do usuario
                                        System.out.println("-------------------------------------------------");
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
                                break;

                            case 3: // Comprar
                                break;

                            case 4: // Carrinho
                                break;

                            case 5: // Sobre nós
                                break;
                        }
                    } while (escolha_cliente != 6);
                    break;

                // Funcionario
                case 2:
                    do {
                        System.out.println("\nDigite o NUMERO que corresponde a sua ACAO DESEJADA."); // Instruções
                        System.out.print(" 1 -> ADICIONAR\n 2 -> EDITAR o PRECO dos PRODUTOS\n 3 -> ACESSAR CADASTROS\n 4 -> LUCRO TOTAL\n 5 -> VOLTAR ao MENU PRINCIPAL \nEscolha: ");
                        escolha_funcionario = inteiro.nextInt(); // Entrada do funcionario

                        switch (escolha_funcionario) {
                            case 1: // Adicionar produtos
                                break;

                            case 2: // Editar o preço dos produtos
                                break;

                            case 3: // Acesso ao cadastro dos clientes
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
