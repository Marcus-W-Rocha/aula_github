
import java.io.IOException;
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

	public Menu(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}

	public int getSelection() {
		int op = 0;
		int op2;
		while (op==0){
			System.out.println(title+"\n");
			int i=1;
			for (String option : options) {
				System.out.println(i++ + " - " + option);
			}

			System.out.println("Informe a opcao desejada. ");
			Scanner s = new Scanner(System.in);
			String str = s.nextLine();
			try {
				op = Integer.parseInt(str);
				if(op == 1){
					System.out.println("Selecione uma opcao");
					System.out.println("1 - Ver Clientes Cadastrados");
					System.out.println("2 - Cadastrar um cliente");
				    str = s.nextLine();
					op2 = Integer.parseInt(str);
					if (op == 1){
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
		return op;
	}
}
