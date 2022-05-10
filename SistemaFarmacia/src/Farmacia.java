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
        int escolha_sessao = 0;
        int escolha_cliente = 0;
        int escolha_funcionario = 0;

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
                                break;

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
        System.out.println("AGRADECIDOS por CONFIAR no NOSSO SISTEMA!"); // Despedidas
    }
}
