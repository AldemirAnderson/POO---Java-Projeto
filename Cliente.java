public class Cliente extends Pessoa {

    // Construtor de Cliente que chama o construtor da superclasse Pessoa
    public Cliente(String nome, String cpf, String endereco, String telefone) throws IllegalArgumentException {
        super(nome, cpf, endereco, telefone); 
    }

 
}
