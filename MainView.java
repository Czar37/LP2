/*package com.sistema.View;

import com.sistema.Entity.Cliente;
import com.sistema.Service.ClienteService;

import java.util.Scanner;

public class MainView implements View {
    Scanner scanner = new Scanner(System.in);
    private ClienteService clienteService = new ClienteService();
    @Override
    public void menuinicial() {
        do {
            System.out.println("Sistema de Monitoramento - Locadora de veiculos");
            System.out.println("Digite o numero que corresponde ao que deseja:");
            System.out.println("1 - Cadastrar cliente ");
            System.out.println("2 - Buscar cliente ");
            System.out.println("3 - Remover cliente ");
            System.out.println("4 - Listar todos os clientes ");
            System.out.println("5 - Buscar carro no estoque ");
            System.out.println("6 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao){
                case 2:
                    buscarCliente();
                    break;
                case 6:
                    System.out.println("Obrigado por utilizar o sistema. Volte sempre!");
                    break;
                default:
                    System.out.println("Opçao invalida. Digite novamente");
                    break;
            }
        }while(opcao != 6);
    }

    @Override
    public void cadastrarCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        Cliente cliente  = new Cliente(nome);
        boolean teste = clienteService.

    }

    @Override
    public void buscarCliente() {
        System.out.print("Digite o ID do cliente: ");
        int id = scanner.nextInt();
        Cliente cliente = clienteService.buscarCLiente(id);
        //Cliente cliente = clienteDAO.buscarCliente(id)
        if(cliente != null){
            System.out.println("Cliente encontrado " + cliente.getNome());
        }
        else{
            System.out.println("Cliente nao encontrado");
        }
    }
/*
    @Override
    public void removerCliente(Scanner scanner) {
        System.out.print("Digite o ID do cliente a ser removido: ");
        int id = scanner.nextLine();
        //Cliente cliente = clienteService.removerCliente(id);
        //Cliente cliente = clienteDAO.delete(id);
        if(cliente != null){
            System.out.println("Cliente removido");
        }
        else{
            System.out.println("Cliente nao encontrado");
        }
    }*/

  //  @Override
  /*  public void listarClientes() {}

    public void buscarCarro(){}*/
//}

package com.sistema.View;

import com.sistema.Entity.Cliente;
import com.sistema.Entity.Veiculo;
import com.sistema.Exception.ServiceException;
import com.sistema.Service.ClienteService;
import com.sistema.Service.VeiculoService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView implements View {
    //private ClienteDAO clienteDAO;


    private ClienteService clienteService;
    private VeiculoService veiculoService;

    public MainView(ClienteService clienteService, VeiculoService veiculoService){
        this.clienteService = clienteService;
        this.veiculoService = veiculoService;
    }

    @Override
    public void menuInicial() {

    Scanner scanner = new Scanner(System.in);
    int opcao = 0;
    /**/
        while(true)
        {
        System.out.println("Sistema de Monitoramento - Locadora de Veículos");
        System.out.println("Digite o número que corresponde ao que deseja:");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Buscar cliente");
        System.out.println("3 - Remover cliente");
        System.out.println("4 - Listar todos os clientes");
        System.out.println("5 - Buscar veículo");

        try {
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;
                case 2:
                    try {
                        buscarCliente(scanner);
                    } catch (ServiceException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    removerCliente(scanner);
                    break;
                case 4:
                    listarClientes();
                    break;
                case 5:
                    buscarVeiculo(scanner);
                    break;
                default:
                    throw new OpcaoInvalidaException("Opção inválida. Digite novamente.");
            }
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Consumir a nova linha inválida
            System.out.println("Entrada invalida. Digite novamente");
        }
    } //while (opcao > 5 || opcao < 1);
}

    @Override
    public void cadastrarCliente(Scanner scanner) {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o valor do aluguel: ");
        double valor = scanner.nextDouble();
        System.out.print("Digite a quantidade de dias do aluguel: ");
        int dias = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o modelo do veículo: ");
        String modelo = scanner.nextLine();

        /*Veiculo veiculo = new Veiculo(clienteDAO.findAll().size() + 1, modelo);
        Cliente cliente = new Cliente(nome, valor, dias, veiculo);*/
        int veiculoID = veiculoService.listarVeiculos().size() + 1;
        Veiculo veiculo = new Veiculo(veiculoID, modelo); //add

        int clienteID = clienteService.listarClientes().size() + 1;
        Cliente cliente = new Cliente(clienteID, nome, valor, dias, veiculo); //add

        veiculo.setCliente(cliente);

        clienteService.cadastrarCliente(cliente); //ADD


        /*clienteDAO.save(cliente);
        veiculoDAO.save(veiculo);*/
        System.out.println("Cliente cadastrado com sucesso!");
    }

    @Override
    public void buscarCliente(Scanner scanner) throws ServiceException {
        System.out.println("Voce deseja buscar o cliente por:");
        System.out.println("1 - ID");
        System.out.println("2 - Nome");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        switch(opcao) {
            case 1:
                System.out.print("Digite a ID do cliente: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                //Cliente cliente = clienteDAO.findById(id);
                Cliente cliente = null; //add
                try {
                    cliente = clienteService.buscarClientePorId(id);
                } catch (ServiceException e) {
                    throw new RuntimeException(e);
                }
                if (cliente != null) {
                    System.out.println("Cliente encontrado: " + cliente.getNome());
                    System.out.println("Veículo alugado: " + cliente.getVeiculo().getModelo());
                    System.out.println("Valor do aluguel: " + cliente.getValor());
                    System.out.println("Dias do aluguel: " + cliente.getDias());
                } else {
                    System.out.println("Cliente não encontrado.");
                }
                break;
            case 2:
                System.out.print("Digite o nome do cliente: ");
                String nome = scanner.nextLine();
                //Cliente cliente1 = clienteDAO.findByName(nome);
                Cliente cliente1 = clienteService.buscarClientePorNome(nome); //add
                if (cliente1 != null) {
                    System.out.println("Cliente encontrado: " + cliente1.getNome());
                    System.out.println("Veículo alugado: " + cliente1.getVeiculo().getModelo());
                    System.out.println("Valor do aluguel: " + cliente1.getValor());
                    System.out.println("Dias do aluguel: " + cliente1.getDias());
                } else {
                    System.out.println("Cliente não encontrado.");
                }
                break;
            default:
                System.out.println("Opçao invalida. Retornando ao menu principal...");
                break;
        }
    }

    @Override
    public void removerCliente(Scanner scanner) {
        System.out.println("Deseja remover o cliente atraves do:");
        System.out.println("1 - ID");
        System.out.println("2 - Nome");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        switch(opcao){
            case 1:
                System.out.print("Digite o ID do cliente a remover: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                //clienteDAO.delete(id); //Refletir acerca de id nao existente
                try {
                    clienteService.removerCliente(id); //add
                } catch (ServiceException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Cliente removido com sucesso!");
                break;
            case 2:
                System.out.print("Digite o nome do cliente a ser removido: ");
                String nome = scanner.nextLine();
                scanner.nextLine();
                //clienteDAO.deletePeloNOme(nome);
                try{
                    clienteService.deletePeloNOme(nome);
                    System.out.println("Cliente removido com sucesso!");
                }catch (ServiceException e){
                    System.out.println("Erro encontrado" + e.getMessage()); //try - catch -> remover cliente(id)
                }

                break;
            default:
                System.out.println("Opcao invalida. Voltando ao menu principal...");
        }
    }

    @Override
    public void listarClientes() {
        System.out.println("Lista de todos os clientes:");
        for (Cliente cliente : clienteService.listarClientes()) {
            System.out.println("ID: " + cliente.getId() + ", Nome: " + cliente.getNome() +
                    ", Veículo: " + cliente.getVeiculo().getModelo() +
                    ", Valor: " + cliente.getValor() +
                    ", Dias: " + cliente.getDias());
        }
    }

    @Override
    public void buscarVeiculo(Scanner scanner) {
        System.out.println("Digite o modelo do veiculo que procura: ");
        String modelo = scanner.nextLine();
        try {
            Veiculo veiculo = veiculoService.buscaPeloModelo(modelo);
            System.out.println("Veiculo encontrado!");
            System.out.println("Cliente: " + veiculo.getCliente().getNome());
            //System.out.println("Duracao do aluguel: " );
        } catch(ServiceException e){
            System.out.println("Veiculo nao encontrado" + e.getMessage());
        }


    }
}

