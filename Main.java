/*import com.sistema.View.MainView;

import java.net.StandardSocketOptions;
public class Main {
    public static void main(String[] args) {
        System.out.println("---");
        MainView mainView = new MainView();
        mainView.menuinicial();

    }
}*/

import com.sistema.DAO.ClienteDAO;
import com.sistema.DAO.VeiculoDAO;
import com.sistema.Exception.ServiceException;
import com.sistema.Service.ClienteService;
import com.sistema.Service.VeiculoService;
import com.sistema.View.MainView;
//import com.sistema.View.View;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        ClienteService clienteService = new ClienteService(clienteDAO);
        VeiculoService veiculoService = new VeiculoService(veiculoDAO);
        MainView mainView = new MainView(clienteService, veiculoService);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mainView.menuInicial();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    mainView.cadastrarCliente(scanner);
                    break;
                case 2:
                    try {
                        mainView.buscarCliente(scanner);
                    } catch (ServiceException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    mainView.removerCliente(scanner);
                    break;
                case 4:
                    mainView.listarClientes();
                    break;
                case 5:
                    mainView.buscarVeiculo(scanner);
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}

