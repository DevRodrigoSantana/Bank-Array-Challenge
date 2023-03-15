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
			System.out.println("OK !!\n Agora Digite sua Senha Numerica" + "[" + (contas ) + "]\n"+"Digite sua Senha :");
			ListaDeContas[contas].setNumeroSenha(entrada.nextInt());
		} catch (NumberFormatException e) {
			System.out.println("Você não digitou os numeros corretamente. Tente Novamente\n");
			
			System.out.println("OK !!\n Agora Digite sua Senha Numerica" + "[" + (contas ) + "]\n"+" Digite sua Senha : ");
			ListaDeContas[contas].setNumeroSenha(entrada.nextInt());
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
		
	private static void listarClientes() {}
	private static void extrato() {
		
	}
	private static void deposito() {

	}
	private static void saque() {}
	private static void transferencia() {}
	
}