/*package com.sistema.Entity;

public class Veiculo extends Entity {
    public String modelo;
    public String cor;
    public int anoFabric;

    public Veiculo(int id, String modelo, String cor, int anoFabric){
        super(id);
        this.modelo = modelo;
        this.cor = cor;
        this.anoFabric = anoFabric;
    }
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAnoFabric() {
        return anoFabric;
    }

    public void setAnoFabric(int anoFabric) {
        this.anoFabric = anoFabric;
    }
}*/

package com.sistema.Entity;

public class Veiculo {
    public boolean setId;
    private int id;
    private String modelo;
    private Cliente cliente;


    public Veiculo(String modelo) {
        this.modelo = modelo;


    }

    public Veiculo(int veiculoID, String modelo) {
    }

    public Cliente getCliente(){return cliente; }

    public void setCliente(Cliente cliente){ this.cliente = cliente; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}


