/*package com.sistema.View;


public interface View {
    void menuinicial();
    void buscarCliente();
    void cadastrarCliente();
    /*void removerCliente();
    void listarClientes();
    void boasvindas();*/
//}

package com.sistema.View;

import com.sistema.Exception.ServiceException;

import java.util.Scanner;

public interface View {
    void menuInicial();
    void cadastrarCliente(Scanner scanner);
    void buscarCliente(Scanner scanner) throws ServiceException;
    void removerCliente(Scanner scanner);
    void listarClientes();
    void buscarVeiculo(Scanner scanner);
}
