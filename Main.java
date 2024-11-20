
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<OrdemServico> ordensServico = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    atualizarCliente(scanner);
                    break;
                case 4:
                    removerCliente(scanner);
                    break;
                case 5:
                    criarOrdemServico(scanner);
                    break;
                    case 6:
                    // Buscar Ordem de Serviço
                    System.out.print("Digite o número da ordem de serviço: ");
                    int numeroOrdem = scanner.nextInt();
                    OrdemServico ordem = OrdemServico.getOrdemPorNumero(numeroOrdem);
                    if (ordem != null) {
                        System.out.println(ordem);
                    } else {
                        System.out.println("Ordem de serviço não encontrada.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void mostrarMenu() {
        System.out.println("Menu:");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Listar Clientes");
        System.out.println("3. Atualizar Cliente");
        System.out.println("4. Remover Cliente");
        System.out.println("5. Cadastrar Ordem de Serviço");
        System.out.println("6. Buscar Ordem de Serviço");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarCliente(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF (11 dígitos): ");
        String cpf = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone (DDD + número): ");
        String telefone = scanner.nextLine();

        try {
            Cliente cliente = new Cliente(nome, cpf, endereco, telefone);
            clientes.add(cliente);
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    private static void removerCliente(Scanner scanner) {
        System.out.print("Digite o CPF do cliente para ser removido: ");
        String cpf = scanner.nextLine();

        clientes.removeIf(cliente -> cliente.getCpf().equals(cpf));
        System.out.println("Cliente removido (se existia).");
    }

    private static void atualizarCliente(Scanner scanner) {
        System.out.print("Digite o CPF do cliente a ser atualizado: ");
        String cpf = scanner.nextLine();
        Cliente cliente = encontrarCliente(cpf);

        if (cliente != null) {
            System.out.print("Novo Nome (deixe em branco para não alterar): ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo Endereço (deixe em branco para não alterar): ");
            String novoEndereco = scanner.nextLine();
            System.out.print("Novo Telefone (deixe em branco para não alterar): ");
            String novoTelefone = scanner.nextLine();

            if (!novoNome.isEmpty()) cliente.setNome(novoNome);
            if (!novoEndereco.isEmpty()) cliente.setEndereco(novoEndereco);
            if (!novoTelefone.isEmpty()) cliente.setTelefone(novoTelefone);

            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void criarOrdemServico(Scanner scanner) {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = encontrarCliente(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado. Cadastrando novo cliente.");
            cadastrarCliente(scanner);
            cliente = encontrarCliente(cpf); // Busca o cliente recém-cadastrado
        }

        System.out.print("Marca do aparelho: ");
        String marcaAparelho = scanner.nextLine();
        System.out.print("Modelo do aparelho: ");
        String modeloAparelho = scanner.nextLine();
        System.out.print("Número de série: ");
        String numeroSerie = scanner.nextLine();

        OrdemServico ordemServico = new OrdemServico(cliente, marcaAparelho, modeloAparelho, numeroSerie);
        ordensServico.add(ordemServico);
        System.out.println("Ordem de serviço criada com sucesso!");
        System.out.println(ordemServico);
    }

    private static Cliente encontrarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
}