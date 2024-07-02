package com.sistema.Service;


import com.sistema.DAO.AluguelDAO;
import com.sistema.Entity.Cliente;
import com.sistema.Entity.Veiculo;
import com.sistema.Entity.Aluguel;

public class AluguelService {
    private AluguelDAO aluguelDAO = new AluguelDAO();

    public void registrarAluguel(int id, Cliente clienteAluguel, Veiculo veiculoAluguel){
        Aluguel aluguel = new Aluguel(id, clienteAluguel, veiculoAluguel);
        aluguelDAO.save(aluguel);
    }
}
