
public class Cliente {
    
        // variaveis para guardar nome, numero da conta e saldo do cliente 
        
        private  int numeroConta;
        private String nomeCliente;
        private float saldo;
        
        //get's das vaiaveis. Cada  pega o valor setado e armazena
        public int getNumeroConta() {
            return numeroConta;
        }
        public void setNumeroConta(int numeroConta) {
            this.numeroConta = numeroConta;
        }
        public String getNomeCliente() {
            return nomeCliente;
        }
        public void setNomeCliente(String nomeCliente) {
            this.nomeCliente = nomeCliente;
        }
        public float getSaldo() {
            return saldo;
        }
        public void setSaldo(float saldo) {
            this.saldo = saldo;
        }
    }
