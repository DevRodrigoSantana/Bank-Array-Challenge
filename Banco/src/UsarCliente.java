import java.util.*;
public class UsarCliente {
    private static int contas;
	private static Cliente[] listaDeContas = new Cliente[3];
	private static void menu() {
		try {
		Scanner entrada =new Scanner(System.in);
		System.out.println("---------------------------------\n");
		System.out.println("Olá seja bem vindo ao Banco TODOS");
		System.out.println("----------------------------------\n");
		System.out.println("           Escolha uma opção :\n");
		System.out.println("1 : Cadastrar cliente ");
		System.out.println("2 : Saldo");
		System.out.println("3 : Mostrar dados");
		System.out.println("4 : Deposito");
		System.out.println("5 : Sacar");
		System.out.println("6 : Transferencia");
		System.out.println("7 : sair");
		
		//caso digite um numero fora da categoria escolha
		int escolha = entrada.nextInt();
		if (escolha <0 ||escolha >7) {
			
			System.out.println("Digite uma opção  entre 1  e 6!!");
			menu();
		}else {
			//Aqui o que o usuario digitou sera levado para cada caso; alguns sendo direcionado para função
			switch (escolha) {
			
			case 1: 
				if (contas< listaDeContas.length) {
					cadastrar();
					}else {
						System.out.println("Banco Cheio");menu();
					}
				break;	
			case 2:
				Saldo();
				break;
			case 3: 
				dados();
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
				sair();
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
	private static void cadastrar() {}
	private static void Saldo() {}
	private static void dados() {}
	private static void deposito() {}
	private static void saque() {}
	private static void transferencia() {}
	private static void sair() {}
	public static void main(String[] args) {
	menu();
}}