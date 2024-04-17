import java.util.Scanner;

public class SystemClient {

    public static void Menu() {
        System.out.println("-----Menu-----");
        System.out.println("1 - Cadastrar Cliente Fisico");
        System.out.println("2 - Cadastrar Cliente Juridico");
        System.out.println("3 - Procurar Cliente ");
        System.out.println("4 - Listar Todos os Cliente ");
        System.out.println("5 - Remover Cliente");
        System.out.println("6 - Consultar Saldo");
        System.out.println("7 - Depositar");
        System.out.println("8 - Transferencia");
        System.out.println("9 - Sacar");
        System.out.println("10 - Consultar Saldo Total do Banco");
        System.out.println("0 - Sair!");
        System.out.println("\n\n\n");
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner Scan = new Scanner(System.in);
        int Useroption;

        do {
            Menu();
            Useroption = Scan.nextInt();

            switch (Useroption) {
                case 1:
                    banco.addCliente(banco.createClienteFisico());
                    System.out.println("Cliente Fisico cadastrado com sucesso!");
                    break;
                case 2:
                    banco.addCliente(banco.createClienteJuridico());
                    System.out.println("Cliente Juridico cadastrado com sucesso!");
                    break;
                case 3:
                    System.out.println("Digite o identificador: ");
                    int identificador = Scan.nextInt();
                    System.out.println(banco.getCliente(identificador));
                    break;
                case 4:
                    banco.getClientes();
                    break;
                case 5:
                    System.out.println("Digite o identificador: ");
                    int identificador5 = Scan.nextInt();
                    banco.removeCliente(banco.getCliente(identificador5));
                    System.out.println("Cliente removido com sucesso!");
                    break;
                case 6:
                   System.out.println("Digite o identificador: ");
                    int identificador6 = Scan.nextInt();
                    Cliente cliente = banco.getCliente(identificador6);
                    System.out.println("Cliente: " + cliente.getNome()); // Verificar se o cliente foi encontrado corretamente
                    System.out.println("Saldo: " + cliente.getSaldo());
                    break;
                case 7:
                    System.out.println("Digite o identificador: ");
                    int identificador7 = Scan.nextInt();
                    System.out.println("Digite o valor do deposito: ");
                    double valor7 = Scan.nextDouble();
                    if (banco.getCliente(identificador7).depositar(valor7)) {
                        System.out.println("Deposito realizado com sucesso!");
                    } else {
                        System.out.println("Valor inválido para depósito!");
                    }
                    break;
                case 8:
                    System.out.println("Digite o id da conta origem: ");
                    int idOrigem = Scan.nextInt();
                    System.out.println("Digite o id da conta destino: ");
                    int idDestino = Scan.nextInt();
                    System.out.println("Digite o valor da transferencia: ");
                    double valorTransferencia = Scan.nextDouble();
                    if (banco.realizarTransferencia(idOrigem, idDestino, valorTransferencia)) {
                        System.out.println("Transferencia realizada com sucesso!");
                    } else {
                        System.out.println("Transferencia não realizada. Verifique os dados.");
                    }
                    break;
                case 9:
                    System.out.println("Digite o identificador: ");
                    int identificador9 = Scan.nextInt();
                    System.out.println("Digite o valor do saque: ");
                    double valorSaque = Scan.nextDouble();
                    if (banco.realizarSaque(identificador9, valorSaque)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saque não realizado. Verifique os dados.");
                    }
                    break;
                case 10:
                    double saldoTotal = banco.calcularSaldoTotal();
                    System.out.println("Saldo total do banco: " + saldoTotal);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        } while (Useroption != 0);
    }
}
// Júlio César Zamoro Sian
// Heytor Pires