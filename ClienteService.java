/*package com.sistema.Service;

import com.sistema.DAO.AluguelDAO;
import com.sistema.DAO.ClienteDAO;

public class ClienteService {
    private ClienteDAO clienteDAO = new ClienteDAO();

    public boolean cadastrarCliente(Cliente cliente, int valor, int dias, Veiculo veiculo){
        cliente.setValor(valor);
        cliente.setDias(dias);
        cliente.setVeiculo(veiculo);
        clienteDAO.save(cliente);
        return true;
    }

    //private AluguelDAO aluguelDAO = new AluguelDAO();


    public ClienteService(int valor, int dias){
        this.valor = valor;
        this.dias = dias;
    }

    /*public boolean cadastrarCliente(Cliente cliente){
        return aluguelDAO.cadastrarCliente(cliente);
    }*/

    //getters e setters
    //registrarCliente()
//}

package com.sistema.Service;

import com.sistema.DAO.ClienteDAO;
import com.sistema.Entity.Cliente;
import com.sistema.Exception.DAOException;
import com.sistema.Exception.ServiceException;

import java.util.List;

public class ClienteService {
    private ClienteDAO clienteDAO = new ClienteDAO();

    public ClienteService(ClienteDAO clienteDAO) {
    }

    public boolean cadastrarCliente(Cliente cliente) {
        if (cliente != null) {
            clienteDAO.save(cliente);
            return true;
        }
        return false;
    }


    public Cliente buscarClientePorId(int id) throws ServiceException {
        try{
            return clienteDAO.findById(id);
        }catch (DAOException e){
            throw new ServiceException("Nao foi possivel encontrar atraves do ID fornecido", e);
        }
    }

    public Cliente buscarClientePorNome(String nome) throws ServiceException{
        try{
            return clienteDAO.findByName(nome);
        }catch (DAOException e){
            throw new ServiceException("Nao foi possivel encontrar atraves do nome fornecido", e);
        }
    }

    public void removerCliente(int id) throws ServiceException {
        try{
            clienteDAO.delete(id);
        }catch (DAOException e){
            throw new ServiceException("Nao foi possivel remover atraves da ID fornecida", e);
        }
    }

    public void deletePeloNOme(String nome) throws ServiceException{
        try{
            clienteDAO.deletePeloNOme(nome);
        }catch (DAOException e){
            throw new ServiceException("Nao foi possivel remover atraves do nome fornecido", e);
        }
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.findAll();
    }
}
