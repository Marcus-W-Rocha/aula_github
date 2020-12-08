
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private String title;
	private List<String> options;
	public Menu(List<String> options) {
		this.title = "Menu";
		this.options = options;
	}
	private ArrayList<Cliente> listClientes = new ArrayList<Cliente>();
	private ArrayList<Conta> listContas = new ArrayList<Conta>();

	public Menu(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}

	public int getSelection() {
		Scanner s = new Scanner(System.in);
		int op = 0;
		int op2;
		while (op<=3){
			System.out.println(title+"\n");
			int i=1;
			for (String option : options) {
				System.out.println(i++ + " - " + option);
			}

			System.out.println("Informe a opcao desejada. ");
			String str = s.nextLine();
			try {
				op = Integer.parseInt(str);
				if(op == 1){
					System.out.println("Informe seu CPF");
          			int cpf = Integer.parseInt(s.nextLine());
          			Cliente cli = null;
          			for (Cliente cliente : listClientes){
           		 		if (cpf == cliente.getCpf()){
              				cli = cliente;
            			}
          			}
          			if (cli == null){
            			System.out.println("Cliente Inexistente");
          			}
          			else{
            			System.out.println("Informe o Valor do Deposito Inicial");
            			double saldo = Double.parseDouble(s.nextLine());
            			Conta b = new Conta(saldo,cli);
            			System.out.println("Conta Criada\nNome do Cliente: "+ b.getCliente().getNome() +"\nSaldo: "+b.getSaldo());
            			listContas.add(b);
          			}
				}
				if(op == 2){
					System.out.println("Selecione uma opcao");
					System.out.println("1 - Ver Clientes Cadastrados");
					System.out.println("2 - Cadastrar um cliente");
				    str = s.nextLine();
					op2 = Integer.parseInt(str);
					if (op2 == 1){
						for (Cliente cliente : listClientes) {
							System.out.println(cliente.getNome());
						}
					}
					if (op2 == 2){
						System.out.println("Digite um nome");
						String nome = s.nextLine();
						System.out.println("Digite um cpf");
						int cpf = Integer.parseInt(s.nextLine());
						Cliente novoCliente = new Cliente(nome, cpf);
						listClientes.add(novoCliente);
					} }
				if (op==3) {
					System.out.println("Informe seu CPF");
					int cpf = Integer.parseInt(s.nextLine());
					double saldo = 0;
					Conta con = null;
					for (Conta conta : listContas) {
						if (cpf == conta.getCliente().getCpf()){	
							saldo = conta.getSaldo();
							con = conta;
							break;
						}
					}
					System.out.println(con.getCliente().getNome());
					System.out.println("Selecione uma opcao");
					System.out.println("1 - Saque");
					System.out.println("2 - Deposito");
					op2 = Integer.parseInt(s.nextLine());
					if (op2 == 1){
						System.out.println("Informe o Valor do Saque");
						double saque = Double.parseDouble(s.nextLine());
						if (saque<saldo){
							saldo = saldo - saque;
							con.setSaldo(saldo);
							System.out.println("Saque realizado com sucesso!");
						}
						else {
							System.out.println("Saldo insuficiente");
						}
					}
					if(op2 == 2){
						System.out.println("Informe o Valor do deposito");
						double valor = Double.parseDouble(s.nextLine());
						saldo = saldo + valor;
						con.setSaldo(saldo);
						System.out.println("Deposito realizado com sucesso!");
					}
				}	
			}
			catch (NumberFormatException e) {
				op =0;
			}
			if (op>=i){
				System.out.println("Opcao errada!");
				op=0;
			}
		}
		s.close();
		return op;
	}
}
