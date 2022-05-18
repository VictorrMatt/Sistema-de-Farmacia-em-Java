import java.util.Scanner;
import java.lang.*;

public class Farmacia {
    public static void main(String args[]) {
        // Declaração de variaveis
        int escolha = 0;
        int escolha_sessao = 0;
        int escolha_cliente = 0;
        int  escolha_funcionario = 0;
        int tamanho = 100;
        String usuario = null;
        String senha = null;
        String telefone = null;
        String cidade = null;
        String estado = null;
        String bairro = null;
        String rua = null;
        boolean cadastrado = true;
        boolean entrada = true;
        boolean cadastro = false;
        int n = 100;
        String entrada_remedios[] = new String[n];
        float entrada_precos[] = new float[n];
        int resposta_funcionario = 0;
        int i = 0;
        int alterar_preco;
        int resposta_cliente;
        int resposta_cliente2;
        int resposta_cliente3;
        int cupom_escolhido;
        int rodando=0;
        int rodando2=0;

        // Vetores referentes aos usuarios
        String usuarios[] = new String[tamanho]; // Nome dos clientes registrados
        String senhas[] = new String[tamanho]; // Senha dos clientes registrados
        String telefones[] = new String[tamanho]; // Telefone dos clientes registrados
        String idades[] = new String[tamanho]; // Idade dos clientes registrados
        int escolha_remedio[] = new int[tamanho];
        //endereco dos cadastrados
        String cidades[] = new String[tamanho]; // Cidade dos clientes registrados
        String estados[] = new String[tamanho]; // Estado dos clientes cadastrados
        String bairros[] = new String[tamanho]; // Bairro do usuario
        String ruas[] = new String[tamanho]; // Nome da rua do usuario
        //vetores referentes a farmacia
        String remedios[] = new String[tamanho]; // Remedios da farmacia
        float preco[] = new float[tamanho]; // Preco dos remedios
        int quantidade[] = new int[tamanho]; // Colocação dos remedios
        String cupom[] = new String[tamanho];
        float desconto[] = new float[tamanho];
        float carrinho[] = new float[tamanho];

        Scanner caractere = new Scanner(System.in);
        Scanner inteiro = new Scanner(System.in);
        Scanner real = new Scanner(System.in);

        // Boas vindas
        System.out.println("\n\t\t\t\t== DROGARIA BOAS DROGAS ==");
        System.out.println("\t\t\tOLA CLIENTE AMIGO, seja MUITO BEM \n\t\t   VINDO ao nosso SISTEMA FARMACEUTICO!\n");

        do {
            // Mostrando prints situacionais
            if (escolha_sessao == 0) {
                System.out.println("DIGITE o NUMERO que corresponde ao seu ESTADO.");
            } else {
                System.out.println("\nDIGITE o NUMERO que corresponde ao seu ESTADO.");
            }
            System.out.print(" 1 -> Sou CLIENTE\n 2 -> Sou FUNCIONARIO\n 3 -> Quero SAIR do SISTEMA\nEscolha: ");
            escolha_sessao = inteiro.nextInt(); // Entrada do usuario

            switch (escolha_sessao) {
                // Cliente
                case 1:
                    do {
                        System.out.println("\nDigite o NUMERO que corresponde a sua ACAO DESEJADA."); // Instruções
                        System.out.print(" 1 -> CADASTRAR / LOGAR\n 2 -> LISTA de PRODUTOS\n 3 -> VOLTAR ao MENU PRINCIPAL \nEscolha: ");
                        escolha_cliente = inteiro.nextInt(); // Entrada do cliente

                        switch (escolha_cliente) {
                            case 1: // Cadastrar / Logar
                                cadastrado = false; // Reiniciando a variavel
                                do {
                                    System.out.println("\nPOR FAVOR, nos informe os seus DADOS.");

                                    // Entrada do usuario com filtragem do dado
                                    usuario = " ";
                                    while (usuario.length() <= 3 || usuario.length() > 11) {
                                        System.out.print("USUARIO: ");
                                        usuario = caractere.nextLine();

                                        if (usuario.length() <= 3) {
                                            System.out.println("AVISO, USUARIOS devem conter 3 CARACTERES ou MAIS!");
                                        } else if (usuario.length() > 11) {
                                            System.out.println("AVISO, USUARIOS devem conter MENOS que 12 CARACTERES!");
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
                                        System.out.println("\n\t\tDeseja CADASTRAR-SE no SISTEMA?");
                                        System.out.println("-------------------------------------------------");

                                        // Dados do usuario
                                        System.out.println("  USUARIO: " + usuario + "\t|\tSENHA: " + senha);
                                        System.out.println("-------------------------------------------------");

                                        escolha = 0;
                                        System.out.print(" 1 -> SIM, CADASTRAR\n 2 -> NAO, DIGITAR NOVAMENTE\n 3 -> VOLTAR ao MENU\nEscolha: ");
                                        escolha = inteiro.nextInt();

                                        if (escolha == 1) {
                                            usuarios[0] = usuario;
                                            senhas[0] = senha;
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("\t\t   == CADASTRADO com SUCESSO! ==");
                                            cadastrado = true;
                                            break;
                                        } else if (escolha == 3) {
                                            break;
                                        }
                                    } else {
                                        System.out.println("\n-------------------------------------------------");
                                        System.out.println("    Ola " + usuario + ", Seja BEM VINDO de VOLTA!");
                                        break;
                                    }
                                } while (cadastrado == false);
                                break;

                            case 2: // Produtos
                                if(cadastrado) {
                                    System.out.println("Seu carrinho: R$" + (carrinho[i]));
                                    System.out.println("\nProdutos | Preco");
                                    System.out.println("-------------------------------------------------");


                                    for (i = 0; i < tamanho; i++) {
                                        System.out.println((i + 1) + "- " + entrada_remedios[i] + " R$" + entrada_precos[i]);
                                    }
                                    for (i = 0; i < tamanho; i++) {
                                        if (entrada_remedios[i] == null) {
                                            continue;
                                        }
                                        System.out.print("-> ");
                                        escolha_remedio[i] = inteiro.nextInt();

                                        carrinho[i] = carrinho[i] + entrada_precos[i];

                                        System.out.println("Preco total\n" + (carrinho[i]));

                                        // Mostrando produtos
                                        System.out.println("\n\t\t- " + escolha_remedio[i] + " R$" + entrada_precos[i] + " foi ADICIONADO(A)!" + " -");

                                        System.out.println("Deseja continuar comprando?\n1-sim\n2-nao");
                                        resposta_cliente3 = inteiro.nextInt();

                                        if (resposta_cliente3 == 2) {
                                            break;
                                        }
                                    }
                                    System.out.println("Deseja adicionar algum cupom?\n1-sim\n2-nao");
                                    resposta_cliente = inteiro.nextInt();
                                    if (resposta_cliente == 1) {
                                        for (i = 0; i < n; i++) {
                                            System.out.println((i + 1) + "- " + cupom[i] + " com R$" + desconto[i]);
                                        }
                                        for (i = 0; i < n; i++) {

                                            System.out.println("Qual cupom deseja adicionar?");
                                            System.out.print("-> ");
                                            cupom_escolhido = inteiro.nextInt();

                                            entrada_precos[i] = entrada_precos[i] - desconto[i];

                                            System.out.println("O cupom '" + cupom[i] + "' foi adicionado");
                                            System.out.println("---Finalizacao---\n");
                                            System.out.println("Deseja finalizar a compra?\n1-sim\n2-nao\n->");
                                            resposta_cliente2 = inteiro.nextInt();

                                            if (resposta_cliente2 == 1) {
                                                System.out.println("---Compra finalizada!!---");
                                                System.out.println("Preco total a pagar\n" + (entrada_precos[i] + 1));

                                            } else if (resposta_cliente2 == 2) {
                                                break;
                                            }

                                        }
                                    } else if (resposta_cliente == 2) {
                                        System.out.println("---Finalizacao---\n");
                                        System.out.println("Deseja finalizar a compra?\n1-sim\n2-nao\n->");
                                        resposta_cliente2 = inteiro.nextInt();

                                        if (resposta_cliente2 == 1) {
                                            System.out.println("---Compra finalizada!!---");
                                            System.out.println("Preco total a pagar\n" + carrinho[i]);

                                        } else if (resposta_cliente2 == 2) {
                                            break;
                                        }
                                    }
                                } else if(!cadastrado)
                                {
                                    System.out.println("Voce NAO ESTA CADASTRADO!!\nPor favor cadastre-se :)");
                                }
                                break;
                        }
                    } while (escolha_cliente != 3);
                    break;

                // Funcionario
                case 2:
                    do {
                        System.out.println("\nDIGITE o NUMERO que corresponde a sua ACAO DESEJADA."); // Instruções
                        System.out.print(" 1 -> ADICIONAR REMEDIOS\n 2 -> ALTERAR PRECO dos PRODUTOS\n 3 -> ACESSAR CADASTROS\n 4 -> Criar descontos \n 5 -> VOLTAR ao MENU PRINCIPAL \nEscolha: ");
                        escolha_funcionario = inteiro.nextInt(); // Entrada do funcionario

                        switch (escolha_funcionario) {
                            case 1: // adicionar remedios na farmacia
                                System.out.print("\nQUANTOS PRODUTOS voce deseja ADICIONAR? ");
                                tamanho = inteiro.nextInt();
                                for (i = 0; i < tamanho; i++) {
                                    System.out.println("\nPRODUTO N - " + (i + 1));
                                    System.out.println("-------------------------------------------------");
                                    System.out.print("NOME do REMEDIO: ");
                                    entrada_remedios[i] = caractere.nextLine();

                                    System.out.print("PRECO do " + entrada_remedios[i] + ": ");
                                    entrada_precos[i] = real.nextFloat();
                                }

                                // Mostrando produtos
                                for (i = 0; i < tamanho; i++) {
                                    if (i == 0) {
                                        System.out.println("\n\t\t- " + entrada_remedios[i] + " R$" + entrada_precos[i] + " foi ADICIONADO(A)!" + " -");
                                    } else {
                                        System.out.println("\t\t- " + entrada_remedios[i] + " R$" + entrada_precos[i] + " foi ADICIONADO(A)!" + " -");
                                    }
                                }
                                break;

                            case 2: // Editar o preço dos produtos

                                System.out.println("Qual produto voce quer alterar o preco?");

                                System.out.println("\nProdutos | Preco");
                                System.out.println("-------------------------------------------------");

                                for (i = 0; i < tamanho; i++) {
                                    if (entrada_remedios[i] == null) {
                                        continue;
                                    }
                                    System.out.println(i + "- " + entrada_remedios[i] + " R$" + entrada_precos[i]);
                                    System.out.print("-> ");
                                    alterar_preco = inteiro.nextInt();

                                    System.out.println("Novo preco do "+ entrada_remedios[i] + ": ");
                                    entrada_precos[i] = real.nextFloat();

                                }
                                System.out.println("Preco do"+entrada_remedios+" alterado!!");
                                break;

                            case 3: // Acesso ao cadastro dos clientes
                                System.out.println("");
                                break;

                            case 4://adicionar descontos


                                System.out.print("\nQUANTOS CUPONS voce deseja ADICIONAR? ");
                                n = inteiro.nextInt();
                                for (i = 0; i < n; i++) {
                                    System.out.println("\nDigite o nome do desconto "+ i);
                                    System.out.println("-------------------------------------------------");
                                    System.out.print("-> ");
                                    cupom[i] = caractere.nextLine();

                                    System.out.print("Quanto de desconto o cupom '"+cupom[i]+"' tera?");
                                    System.out.print("->");
                                    desconto[i] = real.nextFloat();
                                }

                                // Mostrando cupons adicionados
                                for (i = 0; i < n; i++) {
                                    if (i == 0) {
                                        System.out.println("\n\t\t- O cupom '" + cupom[i] + "' com R$" + desconto[i] + " de desconto foi ADICIONADO! -");
                                    } else {
                                        System.out.println("\t\t- O cupom '" + cupom[i] + "' com R$" + desconto[i] + " de desconto foi ADICIONADO! -");
                                    }
                                }
                                break;
                        }
                    } while (escolha_funcionario != 5);
                    break;
            }
        } while (escolha_sessao != 3);
        System.out.println("\n-------------------------------------------------");
        System.out.println("    AGRADECIDOS por CONFIAR no NOSSO SISTEMA!"); // Despedidas
        System.out.println("\n\n  ==Por Victor Mateus e Luan do Nascimeto==");
    }
}
