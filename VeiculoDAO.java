/*package com.sistema.DAO;

import com.sistema.Entity.Veiculo;
import java.util.List;
import java.util.ArrayList;

public class VeiculoDAO implements DAO<Veiculo> {

    private List<Veiculo> veicTable = new ArrayList<>();

    @Override
    public void save(Veiculo veiculo) {
        veicTable.add(veiculo);
    }

    @Override
    public void delete(int id) {
        veicTable.removeIf(veiculo -> veiculo.getId() == id);
    }

    @Override
    public List<Veiculo> findAll() {
        return new ArrayList<>(veicTable);
    }
}*/

package com.sistema.DAO;

import com.sistema.Entity.Veiculo;
import com.sistema.Exception.DAOException;

import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO extends DAO<Veiculo> {
    private List<Veiculo> veiculoTable = new ArrayList<>();

    @Override
    public void save(Veiculo veiculo) {
        veiculo.setId(idCounter++);
        veiculoTable.add(veiculo);
    }

    @Override
    public void delete(int id) throws DAOException {
        Veiculo veiculoToRemove = findById(id);
        if (veiculoToRemove != null) {
            veiculoTable.remove(veiculoToRemove);
        }
    }

    public Veiculo findById(int id) throws DAOException{
        for (Veiculo veiculo : veiculoTable) {
            if (veiculo.getId() == id) {
                return veiculo;
            }
        }
        throw new DAOException("Veiculo nao encontrado");
    }

    @Override
    public List<Veiculo> findAll() {
        return veiculoTable;
    }

    public Veiculo buscaPeloModelo(String modelo) throws DAOException{
        for(Veiculo veiculo : veiculoTable){
            if(veiculo.getModelo().equalsIgnoreCase(modelo)){
                return veiculo;
            }
        }
        throw new DAOException("Veiculo nao encontrado");
    }
}

