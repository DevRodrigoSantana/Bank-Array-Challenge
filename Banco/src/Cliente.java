
public class Cliente {
    
        // variaveis para guardar nome, numero da conta e saldo do cliente 
        
        private  int numeroSenha;
        private String nomeCliente;
        private float saldo;
        
        //get's das vaiaveis. Cada  pega o valor setado e armazena
        public int getNumeroSenha() {
            return numeroSenha;
        }
        public void setNumeroSenha(int numeroSenha) {
            this.numeroSenha = numeroSenha;
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
