/*package com.sistema.Service;

import com.sistema.DAO.AluguelDAO;

public class VeiculoService {
    private int valor;
    private int dias;
    private AluguelDAO aluguelDAO = new AluguelDAO();

    public VeiculoService(int valor, int dias){
        this.valor = valor;
        this.dias = dias;
    }

    //getters e setters
    //registrarVeiculo()
}*/

package com.sistema.Service;

import com.sistema.DAO.VeiculoDAO;
import com.sistema.Entity.Veiculo;
import com.sistema.Exception.DAOException;
import com.sistema.Exception.ServiceException;

import java.util.List;

public class VeiculoService {
    private VeiculoDAO veiculoDAO = new VeiculoDAO();

    public VeiculoService(VeiculoDAO veiculoDAO) {
    }

    public Veiculo buscaPeloModelo(String modelo) throws ServiceException {
        try {
            return veiculoDAO.buscaPeloModelo(modelo);
        } catch (DAOException e) {
            throw new ServiceException("Nao foi possivel encontrar o modelo atraves dos dados fornecidos", e);
        }
    }

    public List<Veiculo> listarVeiculos(){
        return veiculoDAO.findAll();
    }
}

