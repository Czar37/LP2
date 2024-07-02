package com.sistema.Entity;

public class Aluguel extends Entity{
    private Cliente cliente;
    private Veiculo veiculo;

    public Aluguel(int id, Cliente cliente, Veiculo veiculo){
        super(id);
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
