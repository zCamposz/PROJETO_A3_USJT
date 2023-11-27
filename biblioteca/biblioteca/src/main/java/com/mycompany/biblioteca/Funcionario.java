package com.mycompany.biblioteca;

import java.util.Date;

public class Funcionario extends Usuario{

    private int id_funcionario;
    private String nome;
    String CPF;
    String RG;
    int idade;
    private Date data_criacao;


    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }
    
    public int getId_funcionario() {
        return id_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getRG() {
        return RG;
    }

    public int getIdade() {
        return idade;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
}
