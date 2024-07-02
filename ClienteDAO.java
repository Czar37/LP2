/*package com.sistema.DAO;

import com.sistema.Entity.Cliente;
import java.util.List;
import java.util.ArrayList;

public class ClienteDAO implements DAO<Cliente>{
    private List<Cliente> clienteTable = new ArrayList<>();


    @Override
    public void save(Cliente cliente){
        clienteTable.add(cliente);
    }

    @Override
    public void delete(int id){
        clienteTable.removeIf(cliente -> cliente.getId() == id);
    }



    @Override
    public List<Cliente> findAll() {
        return new ArrayList<>(clienteTable);
    }
}

/*public class ClienteDAO implements DAO<Cliente>{
    private Database database = Database.getInstance();

 */

/*package com.sistema.DAO;

import com.sistema.Entity.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements DAO<Cliente> {
    private List<Cliente> clienteTable = new ArrayList<>();

    @Override
    public void save(Cliente cliente) {
        clienteTable.add(cliente);
        System.out.println("Cliente salvo com sucesso: " + cliente.getId());
    }

    @Override
    public void delete(int id) {
        Cliente clienteToRemove = findById(id);
        if (clienteToRemove != null) {
            clienteTable.remove(clienteToRemove);
            System.out.println("Cliente removido com sucesso: " + id);
        } else {
            System.out.println("Cliente não encontrado: " + id);
        }
    }

    @Override
    public List<Cliente> findAll() {
        return clienteTable;
    }

    public Cliente findById(int id) {
        for (Cliente cliente : clienteTable) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}*/

package com.sistema.DAO;

import com.sistema.Entity.Cliente;
import com.sistema.Exception.DAOException;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO<Cliente> {
    private List<Cliente> clienteTable = new ArrayList<>();

    @Override
    public void save(Cliente cliente) {
        cliente.setId(idCounter++);
        clienteTable.add(cliente);
    }

    @Override
    public void delete(int id) throws DAOException {
        Cliente clienteToRemove = findById(id);
        if (clienteToRemove != null) {
            clienteTable.remove(clienteToRemove);
        }
    }

    public void deletePeloNOme(String nome) throws DAOException{
            boolean success = clienteTable.removeIf(cliente -> cliente.getNome().equalsIgnoreCase(nome));
            if(!success){
                throw new DAOException("Erro ao deletar usuario de nome " + nome);
            }

    }

    //lancar DAOExcepion

    @Override
    public List<Cliente> findAll() {
        return clienteTable;
    }

    public Cliente findById(int id) throws DAOException {
        for (Cliente cliente : clienteTable) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        throw new DAOException("Usuario nao encontrado");
    }

    public Cliente findByName(String nome) throws DAOException{
        for (Cliente cliente : clienteTable) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        throw new DAOException("Usuario nao encontrado");
    }
}

