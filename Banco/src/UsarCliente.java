import java.util.*;
public class UsarCliente {
    private static int contas=0;///contador iterator
	private static Cliente[]ListaDeContas  = new Cliente[3];
	static Scanner entrada =new Scanner(System.in);
	public static void main(String[] args) {
		menu();
	}
	private static void menu() {
		try {
		System.out.println("---------------------------------\n");
		System.out.println("Olá seja bem vindo ao Banco TODOS");
		System.out.println("----------------------------------\n");
		System.out.println("           Escolha uma opção :\n");
		System.out.println("1 : Cadastrar cliente ");
		System.out.println("2 : Saldo");
		System.out.println("3 : Mostrar extrato");
		System.out.println("4 : Deposito");
		System.out.println("5 : Sacar");
		System.out.println("6 : Transferencia");
		System.out.println("7 : sair");
		
		//caso digite um numero fora da categoria escolha
		int escolha = entrada.nextInt();
		if (escolha <0 ||escolha >7) {
			
			System.out.println("Digite uma opção  entre 1  e 7!!");
			menu();
		}else {
			//Aqui o que o usuario digitou sera levado para cada caso; alguns sendo direcionado para função
			switch (escolha) {
			
			case 1: 
				if (contas< ListaDeContas.length) {
					cadastrar();
					}else {
						System.out.println("Banco Cheio");menu();
					}
				break;	
			case 2:
				listarClientes();
				break;
			case 3: 
				extrato();
				break;
			case 4:
				deposito();
				break;
			case 5:
				saque();
				break;
			case 6:
				transferencia();
				break;
			case 7:
				extrato();
			}
			}
		
		}catch(NullPointerException e) {
			menu();
			
			}catch (NumberFormatException e) {
				System.out.println("Você não digitou a opção corretamente.\nDigite um número de 1 a 6 Por favor.");
			menu();
		}
			
	}

                                              //metodos de cada função
	//metodo para cadastrar cliente no banco
	private static void cadastrar() {
		ListaDeContas[contas] = new Cliente();
        //pega nome digitado
        System.out.println(" OK Vamos Começar? \n   Primeiro digite seu nome\n " + "[" + (contas ) + "]\n"+"Digite seu NOME :");
		ListaDeContas[contas].setNomeCliente(entrada.nextLine());
		entrada.nextLine();
		// pega senha numerica
		try {
			System.out.println("OK !!\n Agora Digite  o Numero de sua Conta" + "[" + (contas ) + "]\n"+"\nDigite Numero da conta :");
			ListaDeContas[contas].setNumeroConta(entrada.nextInt());
		} catch (NumberFormatException e) {
			System.out.println("Você não digitou os numeros corretamente. Tente Novamente\n");
			
			System.out.println("OK !!\n Agora Digite sua Senha Numerica" + "[" + (contas ) + "]\n"+"\nDigite Numero da conta: ");
			ListaDeContas[contas].setNumeroConta(entrada.nextInt());
		}
		//tratativa para saldo
			System.out.println("\nSeu saldo Inicial:\n R$ 0,00");
			try {
				System.out.println(" \nGostaria de efetuar seu primeiro deposito ??\n 1-SIM\n 2-NÃO");
				int escolhaa =entrada.nextInt();

				if(escolhaa<0||escolhaa>2){
					System.out.println("Digite opção válida!!  Vamos Recomeçar");
					cadastrar();
				}else{
					switch(escolhaa){
						case 1:
							deposito();
						break;	
						case 2 :
						float saldoinicial=0;
						ListaDeContas[contas].setSaldo(saldoinicial);
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("Digite opção válida!!  Vamos Recomeçar");
				menu();
			}
			System.out.println(" Cadastro realizado com sucesso !!!");
			contas++;
			menu();
			
		}
		///lista das contas percorre o array
	private static void listarClientes() {
		
	for(int i=0;i<ListaDeContas.length;i++){
		System.out.println("Nome do Titular :"+ListaDeContas[i].getNomeCliente()+
						   "\nSaldo : R$ "+ListaDeContas[i].getSaldo());

	}
	menu();
}
//FUnção para mostrar o extrato da conta 
// apartir da comparaçao do numero da conta 
	private static void extrato() {
		try {
			System.out.println("Digite numero da Conta :");
			int numerodeconta = entrada.nextInt();
			for(int i =0;i<ListaDeContas.length;i++){
				if(ListaDeContas[i].getNumeroConta() == numerodeconta){
					System.out.println("Saldo disponivel: R$ "+ListaDeContas[i].getSaldo());
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Numero digitado Incorretamente");
			extrato();
		}
		menu();
	}
	
	private static void deposito() {
		try {
			System.out.println("digite numero da conta para deposito :\n");
			int numerocontadeposito = entrada.nextInt();
			System.out.println("\nQual Valor para deposito :");
			int valordeposito = entrada.nextInt();
			for(int i = 0;i<ListaDeContas.length;i++){
			 if(ListaDeContas[i].getNumeroConta() == numerocontadeposito){
				Float saldonovo = ListaDeContas[i].getSaldo()+ valordeposito;
				ListaDeContas[i].setSaldo(saldonovo);
				System.out.println("\nDeposito realizado com sucesso");
			 }
			}
		} catch (NumberFormatException e) {
			System.out.println("Digitado incorretamente"+"\nTente novamente");
				deposito();
		}
		menu();
	}
	private static void saque() {}
	private static void transferencia() {}
	
}