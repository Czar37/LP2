/*package com.sistema.Entity;

public class Cliente extends Entity {  //extends e super ou so super
    private String nome;
    private String cidade;
    private int idade;
    private int valor;
    private int dias;
    private Veiculo veiculo;

    public Cliente(int id, String nome, String cidade, int idade, int valor, int dias, Veiculo veiculo){
        super(id);
        this.nome = nome;
        this.cidade = cidade;
        this.idade = idade;
        this.valor = valor;
        this.dias = dias;
        this.veiculo = veiculo;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
}
public int getValor(){
    return valor;
}

public void setValor(int valor){
    this.valor = valor;
}*/

package com.sistema.Entity;

public class Cliente {
    private int id;
    private String nome;
    private double valor;
    private int dias;
    private Veiculo veiculo;

    public Cliente(int id, String nome, double valor, int dias, Veiculo veiculo) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.dias = dias;
        this.veiculo = veiculo;
        veiculo.setCliente(this);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    /*public void setNome(String nome) {
        this.nome = nome;
    }*/

    public double getValor() {
        return valor;
    }

    /*public void setValor(double valor) {
        this.valor = valor;
    }*/

    public int getDias() {
        return dias;
    }

    /*public void setDias(int dias) {
        this.dias = dias;
    }*/

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setId(int i) {
        this.id = id;
    }

    /*public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }*/
}

