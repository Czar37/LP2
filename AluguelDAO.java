package com.sistema.DAO;

import com.sistema.Entity.Aluguel;
import com.sistema.Exception.DAOException;

import java.util.List;
import java.util.ArrayList;

public class AluguelDAO extends DAO<Aluguel> {
    private List<Aluguel> aluguelTable = new ArrayList<>();

    @Override
    public void save(Aluguel aluguel) {
        aluguel.setId(idCounter++);
        aluguelTable.add(aluguel);
    }

    @Override
    public void delete(int id) throws DAOException {
        boolean success = aluguelTable.removeIf(aluguel -> aluguel.getId() == id);
        if(success != true){
            throw new DAOException("Erro ao deletar, aluguel nao encontrado");
        }
    }

    @Override
    public List<Aluguel> findAll() {
        return new ArrayList<>(aluguelTable);
    }

}
