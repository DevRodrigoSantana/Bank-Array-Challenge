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
		System.out.println("5 : Saque");
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
				sair();
			}
			}
		
		}catch(NullPointerException e) {
			menu();
			
			}catch (NumberFormatException e) {
				System.out.println("\nVocê não digitou a opção corretamente.\nDigite um número de 1 a 6 Por favor.\n");
			menu();
		}
			
	}

                                              //metodos de cada função
	//metodo para cadastrar cliente no banco
	private static void cadastrar() {
		ListaDeContas[contas] = new Cliente();
        //pega nome digitado
        System.out.println("\n OK Vamos Começar?\n"+" \n Primeiro digite seu nome " + "[" + (contas ) + "]\n"+" \nDigite seu NOME :");
		ListaDeContas[contas].setNomeCliente(entrada.nextLine());
		entrada.nextLine();
		// pega senha numerica
		try {
			System.out.println("\nOK !!\n Agora Digite  o Numero de sua Conta" + "[" + (contas ) + "]\n"+"\nDigite Numero da conta :");
			ListaDeContas[contas].setNumeroConta(entrada.nextInt());
		} catch (NumberFormatException e) {
			System.out.println("\nVocê não digitou os numeros corretamente. Tente Novamente\n");
			
			System.out.println("OK !!\n Agora Digite sua Senha Numerica" + "[" + (contas ) + "]\n"+"\nDigite Numero da conta: ");
			ListaDeContas[contas].setNumeroConta(entrada.nextInt());
		}
			System.out.println("\nSeu saldo Inicial:\n R$ 0,00");
			
			
			System.out.println("\nCadastro realizado com sucesso !!!");
			contas++;
			menu();
			
		}
		///lista das contas percorre o array
	private static void listarClientes() {
		
	for(int i=0;i<ListaDeContas.length;i++){
		System.out.println("\nNome do Titular :"+ListaDeContas[i].getNomeCliente()+
						   "\nSaldo : R$ "+ListaDeContas[i].getSaldo());

	}
	menu();
}
//FUnção para mostrar o extrato da conta 
// apartir da comparaçao do numero da conta 
	private static void extrato() {
		try {
			System.out.println("\nDigite numero da Conta :");
			int numerodeconta = entrada.nextInt();
			for(int i =0;i<ListaDeContas.length;i++){
				if(ListaDeContas[i].getNumeroConta() == numerodeconta){
					System.out.println("\nSaldo disponivel: R$ "+ListaDeContas[i].getSaldo());
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("\nNumero digitado Incorretamente");
			extrato();
		}
		menu();
	}
	
	private static void deposito() {
		try {
			System.out.println("\ndigite numero da conta para deposito :\n");
			int numerocontadeposito = entrada.nextInt();
			System.out.println("\nQual Valor para deposito :");
			float valordeposito = entrada.nextInt();
			for(int i = 0;i<ListaDeContas.length;i++){
			 if(ListaDeContas[i].getNumeroConta() == numerocontadeposito){
				Float saldonovo = ListaDeContas[i].getSaldo()+ valordeposito;
				ListaDeContas[i].setSaldo(saldonovo);
				System.out.println("\nDeposito realizado com sucesso");
			 }
			}
		} catch (NumberFormatException e) {
			System.out.println("\nDigitado incorretamente"+"\nTente novamente");
				deposito();
		}
		menu();
	}
	private static void saque() {
		try {
			System.out.println("\n Dê qual conta deseja realizar o saque: /n");
			int numerosaque = entrada.nextInt();
			System.out.println("\nQual Valor do saque ? \n");
			float valorsaque = entrada .nextInt();
			for (int i = 0;i<ListaDeContas.length;i++){
				if(ListaDeContas[i].getNumeroConta() == numerosaque){
					if(ListaDeContas[i].getSaldo()<=valorsaque){
					float novosaldo = ListaDeContas[i].getSaldo() - valorsaque;
					ListaDeContas[i].setSaldo(novosaldo);
					System.out.println("\nsaque realizado com sucesso ? /n");				}
				}else{
					System.out.println("\nValor do saque maior do que o saldo.\nSaque não concluído.");
					
				}

			}
			
		} catch (NumberFormatException e) {
			System.out.println("\nDigitado incorretamente"+"\nTente novamente");
			saque();
		}
		menu();

	}
	private static void transferencia() {
	try{
		System.out.println("\nQual numero da sua conta ? ");
		int numerodaconta = entrada.nextInt();
		System.out.println("\nQual valor de Transferência ?");
		float valortransferencia = entrada.nextInt();
		System.out.println(" \nQual conta irá receber ?");
		int  receber = entrada.nextInt();
		
		for (int i =0; i<ListaDeContas.length;i++){
			try {
				if(ListaDeContas[i].getNumeroConta() == numerodaconta){
					if(valortransferencia<=ListaDeContas[i].getSaldo()){
					float novosaldoorigen =ListaDeContas[i].getSaldo()-valortransferencia;
						ListaDeContas[i].setSaldo(novosaldoorigen);
						System.out.println("\nTransferência realizada com sucesso");
					}else{
						System.out.println("\nValor da tranferência maior do que o saldo.\nTranferência não concluída.");
					}
			}
			}catch(NullPointerException e){
			continue;
			}
		}
		for(int i = 0;i<ListaDeContas.length;i++){
			try{
			if(ListaDeContas[i].getNumeroConta() == receber){
				float valorrecebido = ListaDeContas[i].getSaldo()+ receber;
				ListaDeContas[i].setSaldo(valorrecebido);
			}
			}catch(NullPointerException e){
				continue;
			}
		}
	}catch(NumberFormatException e){
		System.out.println("\nVocê digitou algo errado. Tente novamente.");
	}
	menu();
}
	private static  void sair () {
		System.out.println("\nAgradecemos à visita !! Voçte sempre");
	System.exit(0);
	
}
}