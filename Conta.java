public class Conta{
	private double saldo;
	private Cliente cliente;

	public Conta (double saldo,Cliente cliente){
		this.saldo = saldo;
		this.cliente = cliente;
	}
	public Cliente getCliente() {
        return this.cliente;
    }
    public double getSaldo() {
        return this.saldo;
    }
}