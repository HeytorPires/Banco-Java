import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    private List<Cliente> clientes;
    private int proximoId;

    public Banco() {
        clientes = new ArrayList<>();
        proximoId = 1; // Inicia o próximo ID de cliente como 1
    }

    // Método para criar um novo cliente físico e retorná-lo
    public Cliente createClienteFisico() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do cliente fisico:");
        String nome = scanner.nextLine();

        System.out.println("Digite o documento do cliente fisico (CPF):");
        String documento = scanner.nextLine();

        Cliente cliente = new Cliente(proximoId, nome);
        cliente.setDocumento(documento);
        proximoId++; 
        return cliente;
    }

    // Método para criar um novo cliente jurídico e retorná-lo
    public Cliente createClienteJuridico() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do cliente jurídico:");
        String nome = scanner.nextLine();

        System.out.println("Digite o CNPJ do cliente jurídico:");
        String cnpj = scanner.nextLine();

        Cliente cliente = new Cliente(proximoId, nome);
        cliente.setCnpj(cnpj);
        proximoId++; 
        return cliente;
    }

    // Método para adicionar um cliente à lista de clientes do banco
    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Método para remover um cliente da lista de clientes do banco
    public void removeCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    // Método para obter um cliente pelo ID
    public Cliente getCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null; 
    }

    // Método para listar todos os clientes do banco
    public void getClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    // Método para realizar transferência entre clientes
    public boolean realizarTransferencia(int idOrigem, int idDestino, double valor) {
        Cliente origem = getCliente(idOrigem);
        Cliente destino = getCliente(idDestino);
        if (origem == null || destino == null) {
            return false; 
        }
        return origem.transferir(destino, valor);
    }

    // Método para realizar saque em uma conta de cliente
    public boolean realizarSaque(int idCliente, double valor) {
        Cliente cliente = getCliente(idCliente);
        if (cliente == null) {
            return false; 
        }
        return cliente.sacar(valor);
    }
    
    // Método para calcular o saldo total do banco somando os saldos de todas as contas
    public double calcularSaldoTotal() {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }
}
// Júlio César Zamoro Sian
// Heytor Pires