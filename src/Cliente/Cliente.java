public class Cliente {
    private int id;
    private String nome;
    private String documento; // CPF para cliente físico, CNPJ para cliente jurídico
    private double saldo;

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.saldo = 0.0; 
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setCnpj(String cnpj) {
        this.documento = cnpj;
    }

    // Método para depositar dinheiro na conta do cliente
    public boolean depositar(double valor) {
        if (valor <= 0) {
            return false; 
        }
        saldo += valor;
        return true; 
    }

    // Método para sacar dinheiro da conta do cliente
    public boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false; // Valor inválido para saque ou saldo insuficiente
        }
        saldo -= valor;
        return true; 
    }

    // Método para realizar transferência para outro cliente
    public boolean transferir(Cliente destinatario, double valor) {
        if (valor <= 0 || valor > saldo) {
            return false; 
        }
        saldo -= valor; 
        destinatario.depositar(valor); // Deposita o valor transferido na conta do destinatário
        return true; 
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", documento=" + documento + ", saldo=" + saldo + "]";
    }
}
// Júlio César Zamoro Sian
// Heytor Pires