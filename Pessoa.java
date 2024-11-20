
public class Pessoa {
    protected String nome;
    protected String cpf;
    protected String endereco;
    protected String telefone;


    public Pessoa(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        setCpf(cpf); // Validação de CPF
        this.endereco = endereco;
        setTelefone(telefone); 
    }

    // Validação do CPF
    public void setCpf(String cpf) {
        if (cpf.length() == 11 && cpf.matches("\\d+")) { 
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido! Deve conter exatamente 11 dígitos.");
        }
    }

    // Validação do Telefone
    public void setTelefone(String telefone) {
        if (telefone.matches("\\d{2}\\d{9}")) {
            this.telefone = telefone;
        } else {
            throw new IllegalArgumentException("Telefone inválido! Deve conter 11 dígitos no formato DDD + número.");
        }
    }

    // Getters e Setters para os outros atributos
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, CPF: %s, Endereço: %s, Telefone: %s", nome, cpf, endereco, telefone);
    }
}
