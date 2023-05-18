import java.util.Scanner;

public class Menu {
    private double valorPedido = 0;
    private int opcao;
    private Scanner scanner = new Scanner(System.in);

    public double getValorPedido() {
        return valorPedido;
    }

    public void exibirOpcao() {
        while (true) {
            System.out.println("+------------------------------------------+");
            System.out.println("| Bem vindo! Escolha uma das opções abaixo |");
            System.out.println("| 1. Fazer pedido                          |");
            System.out.println("| 2. Sair                                  |");
            System.out.println("+------------------------------------------+");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("Começaremos o seu pedido");
                fazerPedido();
            } else if (opcao == 2) {
                System.out.println("Fechando o menu...");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    public void fazerPedido() {
        System.out.println("Por favor, insira seu nome:");
        String nome = scanner.nextLine();
        System.out.println("Este é o nosso cardápio " + nome + ", qual será o seu pedido? (Para finalizar o pedido, digite 0)");
        Cardapio cardapio = new Cardapio();
        cardapio.adicionarItem("1. Hamburguer, R$25,00");
        cardapio.adicionarItem("2. Pizza, R$50,00");
        cardapio.adicionarItem("3. Macarrão, R$20,00");
        cardapio.adicionarItem("4. Nhoque, R$50,00");
        cardapio.adicionarItem("5. Bolo, R$200,00");
        cardapio.mostrarCardapio();
        Pedido pedido = new Pedido();

        while (true) {
            int escolha = scanner.nextInt();
            if (escolha == 0) {
                System.out.println("Pedido finalizado!");
                pedido.mostrarPedido();
                break;
            } else if (escolha == 1) {
                valorPedido += 25.00;
                pedido.adicionarPedidoItem("Hamburguer, R$25,00");
            } else if (escolha == 2) {
                valorPedido += 50.00;
                pedido.adicionarPedidoItem("Pizza, R$50,00");
            } else if (escolha == 3) {
                valorPedido += 20.00;
                pedido.adicionarPedidoItem("Macarrão, R$20,00");
            } else if (escolha == 4) {
                valorPedido += 50.00;
                pedido.adicionarPedidoItem("Nhoque, R$50,00");
            } else if (escolha == 5) {
                valorPedido += 200.00;
                pedido.adicionarPedidoItem("Bolo, R$200,00");
            }
        }

        class NotaFiscal {
            private double valorAdicional;
            private double valorAdd;
            private Scanner scanner = new Scanner(System.in);

            public void mostrarNotaFiscal() {
                System.out.println("Nota Fiscal");
                System.out.println("Valor total: R$" + getValorPedido());
                System.out.println("Deseja adicionar uma gorjeta? 1 para SIM e 2 para NÃO");
                int valorAdd = scanner.nextInt();
                if (valorAdd == 1) {
                    System.out.println("Quanto deseja adicionar em reais?");
                    double valorAdicional = scanner.nextDouble();
                    System.out.println("Valor total do pedido: R$" + (valorPedido += valorAdicional));
                } else if (valorAdd == 2) {
                    System.out.println("Valor total do pedido: R$" + (valorPedido += valorPedido * 0.1));
                }
            }
        }

        NotaFiscal nota = new NotaFiscal();
        nota.mostrarNotaFiscal();

        boolean pagamentoValido = false;
        while (!pagamentoValido) {
            System.out.println("Insira o valor do pagamento: ");
            double valorPag = scanner.nextDouble();
            if (valorPag >= valorPedido) {
                System.out.println("Aqui está seu troco R$" + (valorPag - valorPedido));
                System.out.println("Obrigado pelo pedido, volte sempre!!!");
                pagamentoValido = true;
            } else {
                System.out.println("Valor insuficiente. Digite novamente.");
            }
        }
    }
}