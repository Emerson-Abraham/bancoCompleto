//superclass
public abstract class Conta {

	// atributos
	protected final Cliente cliente; // composi��o
	protected final long numeroConta;
	protected double saldo;
	private static long contador; // transforma a vari�vel como sendo da Classe e n�o do objeto

	public static void exibirContador() {
		System.out.println("Contas: " + contador);
	}

	public Conta(Cliente cliente, long numeroConta) {
		this.cliente = cliente;
		this.numeroConta = numeroConta;
		contador++;
	}

	public boolean sacar(double valor) throws SaldoInsuficiente {
		if (valor > 0) {
			if (this.saldo >= valor) {
				this.saldo -= valor;
				return true;
			}
			throw new SaldoInsuficiente("Saldo insuficiente, tente novamente!");
		}
		return false;
	}

	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
			System.out.println("Opera��o realizada");
		}
	}

	public void transferir(double valor, Conta conta) throws SaldoInsuficiente {
		boolean teste = this.sacar(valor);
		if (teste == true) {
			conta.depositar(valor);
		}
	}

	public abstract void exibirSaldo(); // abstract no m�todo for�a a reescrita.
}
